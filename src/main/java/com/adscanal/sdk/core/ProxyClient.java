package com.adscanal.sdk.core;

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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class ProxyClient {
    @Value("${proxy.server}")
    String proxyHost;
    public static final int req_timeout = 10 * 1000;

    public static Map<String, ArrayList<CloseableHttpClient>> GEO_CLIENTS = new HashMap();


    public static CloseableHttpClient getClient(String host, int port) {

        // HttpHost super_proxy = new HttpHost(host, port);
        // HttpHost super_proxy = new HttpHost("44.235.122.213", port);
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
        conn_mgr.setMaxTotal(Integer.MAX_VALUE);
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

    public void putClientPool(String host, int port, String geo) {
        ArrayList<CloseableHttpClient> pool = new ArrayList<>();
        pool.add(getClient(host, port));
        GEO_CLIENTS.put(geo, pool);
    }

    @PostConstruct
    public void initClient() {
        putClientPool(proxyHost, 24000, "VN");
        putClientPool(proxyHost, 26000, "ID");
        putClientPool(proxyHost, 26001, "TH");
        putClientPool(proxyHost, 26002, "PH");
        putClientPool(proxyHost, 26003, "SG");
    }
}
