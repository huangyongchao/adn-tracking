package com.adscanal.sdk.core.job;

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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Component
@Order(0)
public class LoadProxyJob {

    public static List<GeoProxy> PROXIES = Lists.newArrayList();
    public static Map<String, GeoProxy> GEOPROXYMAP = Maps.newHashMap();
    private static final Logger logger = LoggerFactory.getLogger(OfferTask.class);
    private static final Logger errorlog = LoggerFactory.getLogger("error");

    @Autowired
    ProxyClient proxyClient;


    @Value("${proxyserver}")
    private String proxyserver;

    private static int BASE = 1000 * 60 * 60 * 24;

    @Scheduled(cron = "0 0/3 * * * ?")
    public void sychOffers() {
        Set<Integer> acoffers = Sets.newHashSet();
        SdkConf.ACTI_GEO.forEach(n -> {
            List<LiveOffer> list = getOffers(n);
            if(list == null){
                return;
            }
            list.forEach(offer -> {
                SimpleData.LIVEOFFERSR_EDIRECT.put(offer.getUid(), new HashMap<String, AtomicLong>());
                // 存储当前激活的offer
                SimpleData.LIVEOFFERS.put(offer.getUid(), offer);
                rebuildCustomer(offer);
                acoffers.add(offer.getUid());
            });

            errorlog.info(JSONObject.toJSONString(list));

        });
        Set<Integer> stopoffers = Sets.newHashSet();

        SdkConf.OFFER_SCHED.forEach((k,v)->{
            if(!acoffers.contains(k)){
                try {
                    stopoffers.add(k);
                    //移除当前停止的offer
                    SimpleData.LIVEOFFERS.remove(k);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        stopoffers.forEach(v->{

            SdkConf.OFFER_SCHED.get(v).shutdownNow();
            SdkConf.OFFER_SCHED.remove(v);
            errorlog.info("TaskInit:-" + v);
        });

    }

    public List getOffers(String geo) {

        List<LiveOffer> offers = Lists.newArrayList();
        try {
            //http://54.218.163.206:5080/openapi/test
            String offerapi = "http://127.0.0.1:8180/liveoffers?auth=18&type=3&location=" + geo.toLowerCase();
            System.out.println(offerapi);
            String respj = HttpClientUtil.get(offerapi);

            JSONArray respja = JSONArray.parseArray(respj);
            if (respja != null && respja.size() > 0) {
                respja.forEach(n -> {
                    JSONObject o = (JSONObject) n;
                    LiveOffer offer = o.toJavaObject(LiveOffer.class);
                    if("UK".equalsIgnoreCase(offer.getCountry())){
                        offer.setCountry("GB");
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

    public static void setCustomerTask(LiveOffer offer) {
        if(SimpleData.PAUSE_OFFERS.contains(offer.getUid())){
            return;
        }
        if (SdkConf.OFFER_SCHED.containsKey(offer.getUid())) {
            try {
                SdkConf.OFFER_SCHED.get(offer.getUid()).shutdownNow();
            } catch (Exception e) {
                e.printStackTrace();
            }
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
            return;
        }
        int priority = offer.getPriority();
        if (priority <= 0) {
            priority = 2;
        }
        if (priority > 5) {
            priority = 5;
        }
        int weight = (10 / priority);
        coresize = clicks / 10000 * weight;


        period = period * 10 * weight;

        SdkConf.OFFER_SCHED.put(offer.getUid(), Executors.newScheduledThreadPool(coresize));
        for (int i = 0; i < coresize; i++) {
            SdkConf.OFFER_SCHED.get(offer.getUid()).scheduleAtFixedRate(new OfferTask(offer, offer.getCountry().toUpperCase() + offer.getOsName().toLowerCase(), offer.getCountry().toUpperCase(), offer.getOsName().toLowerCase()),
                    i * 1000, period, TimeUnit.MILLISECONDS);
        }

        //记录过去之前的点击数
        SimpleData.OFFER_CLICKS.put(offer.getUid(), offer.getDailyMaxClicks());


    }

    public static void rebuildCustomer(LiveOffer offer) {

        if (!SdkConf.OFFER_SCHED.containsKey(offer.getUid())) {
            logger.warn("INIT:" + offer.getUid());
            setCustomerTask(offer);
        } else if (SimpleData.OFFER_CLICKS.containsKey(offer.getUid())
                && (Math.abs(offer.getDailyMaxClicks() - SimpleData.OFFER_CLICKS.get(offer.getUid())) > 50000)) {
            logger.warn("INIT-RE:" + offer.getUid());
            setCustomerTask(offer);
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

    public static void main(String[] args) {
        //getResFile();
        System.out.println(1);

        try {
            HttpClientUtil.get("http://44.235.122.213:22999/api/proxies_running");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void loadDevid(String geo, String os) {

        String key = geo + os;
        String geo3 = GeoMap.word2Map.get(geo);
        if (SdkConf.RUNPRODUCERS.contains(key)) {
            return;
        }

        ExecutorPool.getExecutor().execute(() -> {

            ArrayBlockingQueue q = SdkConf.GEO_OS_QUE.get(key);

            SimpleData.PRODUCERCOUNTER.put(key, new ProducerCounter());
            String path1 = "/opt/did/" + geo3 + os + ".log.dist";
            String path2 = "/opt/did/" + geo3 + os + ".log";
            String path = null;
            if (Files.exists(Paths.get(path1))) {
                path = path1;
            } else if (Files.exists(Paths.get(path2))) {
                path = path2;
            } else {
                return;
            }
            SdkConf.RUNPRODUCERS.add(key);
            try {
                for (int i = 0; i < 100; i++) {
                    Files.lines(Paths.get(path)).skip(GEOPROXYMAP.getOrDefault(geo, new GeoProxy()).getSkip()).forEach(n -> {
                        try {
                            q.put(n);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
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
            logger.info(proxystr);
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
                if (StringUtils.isEmpty(geo)) {
                    return;
                }
                geo = geo.toUpperCase();
                String zone = json.getString("static");

                ArrayBlockingQueue qaos = SdkConf.GEO_OS_QUE.get(geo + OsE.AOS.name);
                if (qaos == null) {
                    SdkConf.GEO_OS_QUE.put(geo + OsE.AOS.name, new ArrayBlockingQueue<String>(1000));
                }
                ArrayBlockingQueue qios = SdkConf.GEO_OS_QUE.get(geo + OsE.IOS.name);

                if (qios == null) {
                    SdkConf.GEO_OS_QUE.put(geo + OsE.IOS.name, new ArrayBlockingQueue<String>(1000));
                }
                SdkConf.ACTI_GEO.add(geo);

                loadDevid(geo, OsE.AOS.name);
                loadDevid(geo, OsE.IOS.name);
                proxyClient.putClientPool(proxyserver, port, offset, geo);
                ProxyClient.GEO_OFFSET.put(geo, offset);


            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @PostConstruct
    public void init() {
        loadProxy();

        sychOffers();


    }
}
