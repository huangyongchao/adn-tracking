package com.adscanal.sdk.core.job;

import com.adscanal.sdk.common.ExecutorPool;
import com.adscanal.sdk.core.ProxyClient;
import com.adscanal.sdk.core.SdkConf;
import com.adscanal.sdk.dto.GeoProxy;
import com.adscanal.sdk.dto.ProducerCounter;
import com.adscanal.sdk.dto.SimpleData;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

@Component
@Order(0)
public class LoadProxyJob {

    @Autowired
    ProxyClient proxyClient;

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
        getResFile();
        System.out.println(1);
    }


    public static void loadDevid(String filepath, String key, GeoProxy proxy) {
        ExecutorPool.getExecutor().execute(() -> {
            if (SdkConf.GEO_OS_QUE.containsKey(key)) {
                return;
            }
            ArrayBlockingQueue q = SdkConf.GEO_OS_QUE.get(key);
            SimpleData.PRODUCERCOUNTER.put(key, new ProducerCounter());
            String path = filepath;
            if (!Files.exists(Paths.get(path))) {
                return;
            }
            try {
                for (int i = 0; i < 5; i++) {
                    Files.lines(Paths.get(path)).skip(proxy.getSkip()).forEach(n -> {
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

    public void loadProxy() {
        List<GeoProxy> list = getResFile();
        if (list != null) {
            list.forEach(n -> {
                if (n.isRun() && n.isAOS()) {
                    loadDevid(n.getAospath(), n.getGeo() + "android", n);
                }
                if (n.isRun() && n.isIOS()) {
                    loadDevid(n.getIospath(), n.getGeo() + "ios", n);
                }

                if (n.isRun()) {
                    proxyClient.putClientPool(n.getProxyserver(), n.getPort(), n.getOffset(), n.getGeo());
                }
            });
        }


    }

    @PostConstruct
    public void init() {
        loadProxy();
    }
}
