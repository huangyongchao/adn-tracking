package com.adscanal.sdk.core.job;

import com.adscanal.sdk.common.ExecutorPool;
import com.adscanal.sdk.common.GeoMap;
import com.adscanal.sdk.common.HttpClientUtil;
import com.adscanal.sdk.core.ProxyClient;
import com.adscanal.sdk.core.SdkConf;
import com.adscanal.sdk.dto.GeoProxy;
import com.adscanal.sdk.dto.ProducerCounter;
import com.adscanal.sdk.dto.SimpleData;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

@Component
@Order(0)
public class LoadProxyJob {

    public static List<GeoProxy> PROXIES = Lists.newArrayList();
    public static Map<String, GeoProxy> GEOPROXYMAP = Maps.newHashMap();
    @Autowired
    ProxyClient proxyClient;

    @Value("${proxyserver}")
    private String proxyserver;

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
                for (int i = 0; i < 5; i++) {
                    Files.lines(Paths.get(path)).skip(GEOPROXYMAP.getOrDefault(geo, new GeoProxy()).getSkip()).forEach(n -> {
                        try {
                            q.put(n);
                            SimpleData.PRODUCERCOUNTER.get(key).getCursor().incrementAndGet();
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

    @Scheduled(cron = "0 0/30 * * * ?")
    public void loadProxy() {
        try {

            List<GeoProxy> geoProxies = getResFile();

            if (!CollectionUtils.isEmpty(geoProxies)) {
                Map<String, GeoProxy> geoProxyMap = Maps.newHashMap();
                geoProxies.forEach(gp -> {
                    geoProxyMap.put(gp.getGeo(), gp);
                });
                GEOPROXYMAP = geoProxyMap;
            }
            String proxystr = HttpClientUtil.get("http://" + proxyserver + ":22999/api/proxies_running");
            JSONArray proxys = JSONArray.parseArray(proxystr);
            proxys.forEach(n -> {
                //初始化安卓 设备号生产者
                JSONObject json = (JSONObject) n;
                String geo = json.getString("country");
                int port = json.getInteger("port");
                Integer offset = json.getInteger("multiply");
                if(offset==null){
                    offset = 0;
                }
                if (StringUtils.isEmpty(geo)) {
                    return;
                }
                geo = geo.toUpperCase();
                String zone = json.getString("static");

                loadDevid(geo, "android");
                loadDevid(geo, "ios");
                proxyClient.putClientPool(proxyserver, port, offset, geo);

            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @PostConstruct
    public void init() {
        loadProxy();
    }
}
