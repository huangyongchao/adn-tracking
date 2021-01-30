package com.adscanal.sdk.core;

import com.adscanal.sdk.dto.GeoProxy;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class ProxyClient {

    public static Map<String, Integer> GEO_OFFSET = Maps.newHashMap();

    public static final int req_timeout = 10 * 1000;

    public static Map<String, ArrayList<CloseableHttpClient>> GEO_CLIENTS = new HashMap();
    public static Map<String, HttpComponentsClientHttpRequestFactory> GEO_CLIENT = new HashMap();

    public static CloseableHttpClient getConn(String geo, int serNo) {

        return GEO_CLIENTS.get(geo).get(0);
    }

    public static CloseableHttpClient getClient(String host, int port, int offset) {

        // HttpHost super_proxy = new HttpHost(host, port);
        // HttpHost super_proxy = new HttpHost("44.235.122.213", port);

        for (int i=0;i<offset;i++){

        }
        HttpHost super_proxy = new HttpHost(host, port);
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
            .register("http", PlainConnectionSocketFactory.INSTANCE)
            .register("https", new SSLConnectionSocketFactory(createIgnoreVerifySSL()))
            .build();

        RequestConfig config = RequestConfig.custom()
            .setConnectTimeout(req_timeout)
            .setConnectionRequestTimeout(req_timeout)
            .build();
        PoolingHttpClientConnectionManager conn_mgr =
            new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        conn_mgr.setDefaultMaxPerRoute(Integer.MAX_VALUE);
        conn_mgr.setMaxTotal(10000);
        conn_mgr.closeExpiredConnections();
        conn_mgr.closeIdleConnections(req_timeout, TimeUnit.MILLISECONDS);
        CloseableHttpClient client = HttpClients.custom()
            .setConnectionManager(conn_mgr)
            .disableAutomaticRetries()
            .setRedirectStrategy(new RedirectStrategy() {
                @Override
                public boolean isRedirected(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
                    return false;
                }

                @Override
                public HttpUriRequest getRedirect(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
                    return null;
                }
            })
            .setProxy(super_proxy)
            // .setDefaultCredentialsProvider(cred_provider)
            .setDefaultRequestConfig(config)
            .build();

        return client;

    }

    public static SSLContext createIgnoreVerifySSL() {
        SSLContext sc = null;
        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
        try {
            sc = SSLContext.getInstance("TLSv1.2");

            X509TrustManager trustManager = new X509TrustManager() {
                @Override
                public void checkClientTrusted(
                    X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(
                    X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };

            sc.init(null, new TrustManager[]{trustManager}, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sc;
    }

    /**
     * 要不要覆盖client?
     *
     * @param host
     * @param portMin
     * @param offset
     * @param geo
     */
//    public void putClientPool(String host, int portMin, int offset, String geo) {
//        if (GEO_CLIENTS.containsKey(geo)) {
//            return;
//        }
//        int portMax = portMin + offset;
//        ArrayList<CloseableHttpClient> pool = new ArrayList<>(offset);
//        for (int p = portMin; p < portMax; p++) {
//            pool.add(getClient(host, p, offset));
//        }
//        GEO_CLIENTS.put(geo, pool);
//    }


    public void putClientPool1(String host, int port, int offset, String geo) {
        if (GEO_CLIENT.containsKey(geo)) {
            return;
        }
        GEO_CLIENT.put(geo,new HttpComponentsClientHttpRequestFactory(getClient(host,port,offset)));



    }


    // @PostConstruct
    public void initClient() {



    }

    public static void main(String[] args) {
        GeoProxy geoProxy = new GeoProxy();
        geoProxy.setAOS(true);
        geoProxy.setIOS(true);
        geoProxy.setOffset(100);
        geoProxy.setRun(true);
        geoProxy.setGeo("CO");
        geoProxy.setPort(24200);
        geoProxy.setIospath("");
        geoProxy.setAospath("");

        System.out.println(JSONObject.toJSONString(geoProxy));
    }

}
