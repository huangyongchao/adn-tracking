package com.adscanal.sdk.core.job;

import com.adscanal.sdk.common.AdTool;
import com.adscanal.sdk.common.ExecutorPool;
import com.adscanal.sdk.common.GeoMap;
import com.adscanal.sdk.common.HttpClientUtil;
import com.adscanal.sdk.core.OfferTask;
import com.adscanal.sdk.core.ProxyClient;
import com.adscanal.sdk.core.SdkConf;
import com.adscanal.sdk.dto.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Component
@Order(0)
public class LoadProxyJob {

    public static List<GeoProxy> PROXIES = Lists.newArrayList();
    public static Map<String, GeoProxy> GEOPROXYMAP = Maps.newHashMap();
    private static final Logger logger = LoggerFactory.getLogger(OfferTask.class);
    private static final Logger errorlog = LoggerFactory.getLogger("error");


    @Value("${proxyserver}")
    private String proxyserver;
    @Value("${devidrootpath}")
    private String devidrootpath;

    @Value("${apiserver}")
    private String apiserver;

    private static int BASE = 1000 * 60 * 60 * 24;

    @Scheduled(cron = "0 0/3 * * * ?")
    public void sychOffers() {
        Set<Integer> acoffers = Sets.newHashSet();
        Set<Integer> stopoffers = Sets.newHashSet();

        SdkConf.ACTI_GEO.forEach(n -> {
            List<LiveOffer> list = getOffers(n);
            if (list == null) {
                return;
            }
            //如果不在受众时间,停止投放
            if (!AdTool.isTargetTimeByGeo2word(n)) {
                //  return;
            }

            list.forEach(offer -> {
                SimpleData.LIVEOFFERSR_EDIRECT.put(offer.getUid(), new HashMap<String, AtomicLong>());
                // 存储当前激活的offer
                SimpleData.LIVEOFFERS.put(offer.getUid(), offer);
                rebuildCustomer(offer, n);
                acoffers.add(offer.getUid());
            });


        });

        SdkConf.OFFER_SCHED.forEach((k, v) -> {
            if (!acoffers.contains(k)) {
                try {
                    stopoffers.add(k);
                    //移除当前停止的offer
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        stopoffers.forEach(v -> {

            SdkConf.OFFER_SCHED.get(v).shutdownNow();
            SdkConf.OFFER_SCHED.remove(v);
            SimpleData.LIVEOFFERS.remove(v);
            errorlog.info("TaskInit:-" + v);
        });

    }

    public List getOffers(String geo) {

        String geo3 = GeoMap.word2Map.get(geo.toUpperCase());

        List<LiveOffer> offers = Lists.newArrayList();

        try {
            //http://54.218.163.206:5080/openapi/test
            String offerapi = "http://" + apiserver + ":8180/liveoffers?auth=18&type=3&location=" + geo.toLowerCase();
            String respj = HttpClientUtil.get(offerapi);

            JSONArray respja = JSONArray.parseArray(respj);
            if (respja != null && respja.size() > 0) {
                respja.forEach(n -> {
                    JSONObject o = (JSONObject) n;
                    LiveOffer offer = o.toJavaObject(LiveOffer.class);
                    if ("UK".equalsIgnoreCase(offer.getCountry())) {
                        offer.setCountry("GB");
                    }
                    if ("android".equalsIgnoreCase(offer.getOsName())) {
                        offer.setOsName(OsE.AOS.name);
                    }
                    offers.add(offer);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        SimpleData.GOFFERS.remove(geo);
        SimpleData.GOFFERS.put(geo, offers);

        return offers;

    }

    public static void setCustomerTask(LiveOffer offer, String geoUP) {
        /*如果单子在点击满暂停的集合里就停止设置任务*/
        if (SimpleData.PAUSE_OFFERS.contains(offer.getUid())) {
            return;
        }
        /*如果没有初始化点击计数器 同步时候初始化*/
        if (!Counter.DAILY_CLICKS.containsKey(offer.getUid())) {
            Counter.DAILY_CLICKS.put(offer.getUid(), new AtomicInteger());
        }

        /*如果没有初始化点击计数器 同步时候初始化*/
        if (!Counter.SUB_CLICKS.containsKey(offer.getUid())) {
            Counter.SUB_CLICKS.put(offer.getUid(), new AtomicInteger());
        }


        int period = 0;
        int coresize = 100;
        int clicks = offer.getDailyMaxClicks();
        if (offer.getDailyMaxClicks() <= 0) {
            period = Integer.MAX_VALUE;
        } else {
            period = BASE / offer.getDailyMaxClicks();
        }

        if (SdkConf.OFFER_SCHED.containsKey(offer.getUid())) {
            // return;
        }
        int priority = offer.getPriority();
        if (priority <= 0) {
            priority = 2;
        }
        if (priority > 5) {
            priority = 5;
        }
        coresize = clicks / 20000;

        int weight = (5 / priority);
        SimpleData.OFFERREQCOUNTER.put(offer.getOfferId(), new AtomicLong());

        SdkConf.OFFER_SCHED.put(offer.getUid(), Executors.newScheduledThreadPool(coresize));
        for (int j = 0; j < coresize; j++) {
            for (int i = 0; i < ProxyClient.GEO_CLIENTS.get(geoUP).size(); i++) {
                final int serNo = i;
                OfferTask offerTask = new OfferTask(offer, offer.getCountry().toUpperCase() + offer.getOsName().toLowerCase(), GeoMap.word2Map.get(offer.getCountry().toUpperCase()), offer.getCountry().toUpperCase(), offer.getOsName().toLowerCase(), serNo);
                SdkConf.OFFER_SCHED.get(offer.getUid()).scheduleWithFixedDelay(offerTask,
                    i * 1000, 1, TimeUnit.MILLISECONDS);

         /*       ExecutorPool.getExecutor().execute(() -> {
                    offerTask.consumer(serNo);

                });*/


            }
        }


    }

    public static void rebuildCustomer(LiveOffer offer, String geoUP) {

        SimpleData.OFFER_CLICKS.put(offer.getUid(), offer.getDailyMaxClicks());

        if (!SdkConf.OFFER_SCHED.containsKey(offer.getUid())) {
            logger.warn("INIT:" + offer.getUid());
            setCustomerTask(offer, geoUP);
        } else if (SimpleData.OFFER_CLICKS.containsKey(offer.getUid())
            && (Math.abs(offer.getDailyMaxClicks() - SimpleData.OFFER_CLICKS.get(offer.getUid())) > 50000)) {
            logger.warn("INIT-RE:" + offer.getUid());
            setCustomerTask(offer, geoUP);
        }


    }


    private static List<GeoProxy> getResFile() {
        try {
            String filename = "proxy.json";
            File file = new File(filename);
            Resource resource = new FileSystemResource(file);
            if (!resource.exists()) {
                file = ResourceUtils.getFile("classpath:" + filename);
            }
            if (file.exists()) {
                StringBuffer stringBuffer = new StringBuffer();
                try {
                    Files.lines(file.toPath()).forEach(line -> {
                        stringBuffer.append(line);
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JSONArray j = JSON.parseArray(stringBuffer.toString());
                if (j != null && j.size() > 0) {
                    List<GeoProxy> geoProxies = Lists.newArrayList();
                    j.forEach(o -> {
                        JSONObject jobj = (JSONObject) o;
                        geoProxies.add(jobj.toJavaObject(GeoProxy.class));

                    });
                    return geoProxies;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static final Map<String, List<String>> GEO_FILES = Maps.newHashMap();

    public void getGeoOsFiles() {
        try {
            java.nio.file.Files.walkFileTree(new File(devidrootpath).toPath(), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String path = file.toString();
                    String os = OsE.IOS.name;
                    int i = path.indexOf("ios.device");
                    if (i < 0) {
                        os = OsE.AOS.name;
                        i = path.indexOf("android.device");
                    }
                    if (i < 4) {
                        logger.warn("errorpath:" + path);
                    } else {
                        String geo = path.substring(i - 4, i - 1);
                        if (i > 0 && !StringUtils.isEmpty(geo) && !StringUtils.isEmpty(os)) {
                            String key = geo.toUpperCase() + os;
                            if (!GEO_FILES.containsKey(key)) {
                                GEO_FILES.put(key, Lists.newArrayList());
                            }
                            GEO_FILES.get(key).add(path);
                            //System.out.println(path);
                        }
                    }
                    return super.visitFile(file, attrs);
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        LoadProxyJob l = new LoadProxyJob();
        l.devidrootpath = "/Users/huangyongchao/workspace/devid1";
        l.getGeoOsFiles();
        GEO_FILES.forEach((k, v) -> {
            v.forEach(n -> {
                System.out.println(k + "  " + n);
            });
        });
    }

    public static void main1(String[] args) {
        try {
            java.nio.file.Files.walkFileTree(new File("/Volumes/FrankSSD/deviceid/").toPath(), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String path = file.toString();
                    String os = OsE.IOS.name;
                    int i = path.indexOf("ios.device");
                    if (i < 0) {
                        os = OsE.AOS.name;
                        i = path.indexOf("android.device");
                    }
                    String geo = path.substring(i - 4, i - 1);
                    if (i > 0 && !StringUtils.isEmpty(geo) && !StringUtils.isEmpty(os)) {
                        String key = geo.toUpperCase() + os;
                        if (GEO_FILES.containsKey(key)) {
                            GEO_FILES.get(key).add(path);
                        } else {
                            GEO_FILES.put(key, Lists.newArrayList());
                        }
                    }

                    return super.visitFile(file, attrs);
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        GEO_FILES.get("PERios").forEach(p -> {
            try {
                Files.lines(Paths.get(p)).forEach(n -> {
                    try {
                        System.out.println(p + "    " + n);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        System.out.println(1);
    }

    public static void loadDevid(String geo, String os) {

        String key = geo + os;
        String geo3 = GeoMap.word2Map.get(geo);
        String key3 = geo3 + os;

        if (SdkConf.RUNPRODUCERS.contains(key)) {
            return;
        }
        if (!GEO_FILES.containsKey(key3)) {
            return;
        }
        ExecutorPool.getExecutor().execute(() -> {

            ArrayBlockingQueue q = SdkConf.GEO_OS_QUE.get(key);

            SimpleData.PRODUCERCOUNTER.put(key, new ProducerCounter());


            SdkConf.RUNPRODUCERS.add(key);
            List<String> files = GEO_FILES.get(key3);
            while (true) {
                files.forEach(p -> {
                    try {
                        Files.lines(Paths.get(p)).forEach(n -> {
                            try {
                                q.put(n);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                });
                System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
            }

        });
    }

    @Scheduled(cron = "0 0/3 * * * ?")
    public void loadProxy() {

/*
curl -X GET "http://127.0.0.1:22999/api/gen_token" -H "accept: application/json"
curl -v http://127.0.0.1:22999/api/add_wip -X POST -H "Content-Type: application/json" -H "Authorization:8bEc4LTSumzFmK" -d '{"ip":"111.197.245.125"}'
curl -X POST "http://127.0.0.1:22999/api/add_whitelist_ip" -H "Content-Type: application/json" -d '{"ip":"111.197.245.125"}'
*/
        try {

    /*        List<GeoProxy> geoProxies = getResFile();

            if (!CollectionUtils.isEmpty(geoProxies)) {
                Map<String, GeoProxy> geoProxyMap = Maps.newHashMap();
                geoProxies.forEach(gp -> {
                    geoProxyMap.put(gp.getGeo(), gp);
                });
                GEOPROXYMAP = geoProxyMap;
            }*/
            String proxystr = HttpClientUtil.get("http://" + proxyserver + ":22999/api/proxies_running");
/*
            logger.info(proxystr);
*/

            if (proxystr.indexOf("forbidden") > 0) {

                int e = proxystr.lastIndexOf(" to ");
                int s = proxystr.lastIndexOf(" add ");
                logger.error(proxystr);
                System.out.println("-----++++++++++++++Please set Ip white list (lpm_whitelist_ip " + proxystr.substring(s + 5, e) + ") ++++++++++++++-----");
            }
            JSONArray proxys = JSONArray.parseArray(proxystr);
            proxys.forEach(n -> {
                //初始化安卓 设备号生产者
                JSONObject json = (JSONObject) n;
                String geo = json.getString("country");
                int port = json.getInteger("port");
                Integer offset = json.getInteger("multiply");
                if (offset == null) {
                    offset = 0;
                }
                if (offset == null || offset == 0) {
                    offset = 1;
                }
                if (StringUtils.isEmpty(geo)) {
                    return;
                }
                geo = geo.toUpperCase();
                String zone = json.getString("static");

                ArrayBlockingQueue qaos = SdkConf.GEO_OS_QUE.get(geo + OsE.AOS.name);
                if (qaos == null) {
                    SdkConf.GEO_OS_QUE.put(geo + OsE.AOS.name, new ArrayBlockingQueue<String>(50000));
                }
                ArrayBlockingQueue qios = SdkConf.GEO_OS_QUE.get(geo + OsE.IOS.name);

                if (qios == null) {
                    SdkConf.GEO_OS_QUE.put(geo + OsE.IOS.name, new ArrayBlockingQueue<String>(50000));
                }
                SdkConf.ACTI_GEO.add(geo);
                GEO_FILES.forEach((k, files) -> {
                    Collections.shuffle(files);
                    GEO_FILES.replace(k, files);
                });

                loadDevid(geo, OsE.AOS.name);
                loadDevid(geo, OsE.IOS.name);

                if (ProxyClient.GEO_CLIENTS.containsKey(geo)) {
                    return;
                }
                ProxyClient.GEO_CLIENTS.put(geo, new ArrayList<>());
                for (int i = 0; i < offset; i++) {
                    ProxyClient.GEO_CLIENTS.get(geo).add(ProxyClient.getClient(proxyserver, port + i));
                    logger.info("INITCLIENT:" + geo + " " + (port + i));
                }
                ProxyClient.GEO_OFFSET.put(geo, offset);


            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @PostConstruct
    public void init() {

        try {
            getGeoOsFiles();
            logger.warn("FIRSTTIME:GEO FILES INIT DONE");
        } catch (Exception e) {
            logger.warn("FIRSTTIME:GEO FILES INIT ERROR");

            e.printStackTrace();
        }
        try {
            loadProxy();
            logger.warn("FIRSTTIME:PROXY INIT DONE");
        } catch (Exception e) {
            logger.warn("FIRSTTIME:PROXY INIT ERROR");

            e.printStackTrace();
        }
        try {
            sychOffers();
            logger.warn("FIRSTTIME:OFFERS INIT DONE");
        } catch (Exception e) {
            logger.warn("FIRSTTIME:OFFERS INIT ERROR");

            e.printStackTrace();
        }


    }


}
