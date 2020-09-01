package com.adscanal.sdk.proxy;

import com.adscanal.sdk.common.AdTool;
import com.adscanal.sdk.common.GeoMap;
import com.adscanal.sdk.common.Statistics;
import com.adscanal.sdk.dto.Counter;
import com.adscanal.sdk.dto.LiveOffer;
import com.adscanal.sdk.dto.SimpleData;
import com.adscanal.sdk.dto.Tracker;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class LumProxy {
    private static final Logger logger = LoggerFactory.getLogger(LumProxy.class);
    private static final Logger errorlog = LoggerFactory.getLogger("error");
    private static final Logger tracklogger = LoggerFactory.getLogger("track");
    private static final Logger dtracklogger = LoggerFactory.getLogger("dtrack");

    public static final int req_timeout = 10 * 1000;

    public static final String username = "lum-customer-huangyongchao-zone-residential-route_err-block";
    public static final String password = "hhlgwhurqyv3";

    public static final int port = 22225;

    public static volatile int fail_count;
    public static int parallel = 1;
    public static volatile int n_req_for_exit_node;
    public static String client_geo;

    public static volatile int n_parallel_exit_nodes = 1;
    public static final int n_total_req = 10000000;
    public static final int switch_ip_every_n_req = 1000 * parallel;
    public static AtomicInteger at_req = new AtomicInteger(0);
    public static AtomicInteger success_req_account = new AtomicInteger(0);
    public static AtomicInteger error_req_account = new AtomicInteger(0);

    public static void close(CloseableHttpClient client) {
        if (client != null)
            try {
                client.close();
            } catch (IOException e) {
            }
        client = null;
    }


    public static CloseableHttpClient updateClient(String country, String session_id, String host, int port) {

        String login = username + (country != null ? "-country-" + country : "")
                + "-session-" + session_id;
        //HttpHost super_proxy = new HttpHost(host, port);
        HttpHost super_proxy = new HttpHost("127.0.0.1", port);


        CredentialsProvider cred_provider = new BasicCredentialsProvider();
        cred_provider.setCredentials(new AuthScope(super_proxy),
                new UsernamePasswordCredentials(login, password));


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
                .setDefaultCredentialsProvider(cred_provider)
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

    public static Random clientRnd = new Random();

    public static void launch(String geo, String os, int praallelClients) {

        try {
            if (StringUtils.isBlank(geo) || StringUtils.isBlank(GeoMap.word2Map.get(geo))) {
                System.out.println("GEO null,  can`t start");
                return;
            }
            client_geo = geo;
            String path = "/opt/did/" + GeoMap.word2Map.get(geo.toUpperCase()) + os + ".log.dist";

            parallel = 500;

            String geoS = geo + os;
            List<CloseableHttpClient> clients = switch_session_id();


            System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "" + parallel);

            Files.lines(Paths.get(path)).parallel().forEach(deviceid -> {

                if (n_req_for_exit_node == switch_ip_every_n_req) {
                    switch_session_id();
                }

                int i = at_req.getAndAdd(1);

                CloseableHttpClient client = clients.get(i % praallelClients);

                if (i< n_total_req&&i>420000) {
                    List<LiveOffer> offers = SimpleData.GOFFERS.get(geoS);
                    if (offers == null || offers.size() == 0) {
                        errorlog.error("10000:GEO " + geo + " No Offers");
                        return;
                    }

                    CloseableHttpResponse response = null;
                    try {

                        LiveOffer offer = AdTool.randomOffers(offers);
                        if (SimpleData.BLACK_OFFERS.contains(offer.getId())) {
                            return;
                        }
                        String url = AdTool.trackurl(os, "https://athenmobi.g2afse.com/click?pid=39&offer_id=2573&sub1={clickid}&sub5={idfa}&sub2={pub_subid}&sub6={gaid}", AdTool.randomSub(offer), deviceid, AdTool.geClickid(offer), null);
                        String ua = AdTool.randomUA(os);
                        List<Tracker> trackers = null;
                        response = request(client, 1, url, ua, offer, null, null, false, deviceid, os);

                    } catch (Exception e) {
                        error_req_account.incrementAndGet();
                        errorlog.error(e.getMessage());
                    } finally {

                        try {
                            if (response != null) {
                                response.close();
                            }
                        } catch (Exception e) {
                        }
                    }
                }

            });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static CloseableHttpResponse requestR(CloseableHttpClient client, int counter, String url, String ua, LiveOffer offer, Header[] headers, List<Tracker> trackers, boolean testing, String deviceid, String os) throws IOException {
        CloseableHttpResponse response = null;
        url = AdTool.urlEncode(url, deviceid, os);
        HttpGet request = new HttpGet(url);
        request.setProtocolVersion(HttpVersion.HTTP_1_1);
        request.setHeader(HttpHeaders.USER_AGENT, ua);
        request.setHeader(HttpHeaders.CONNECTION, HTTP.CONN_CLOSE);
        request.setHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br");
        request.setHeader(HttpHeaders.ACCEPT, "application/xhtml+xml,application/xml;q=0.9,image/webp, image/apng,*/*;q=0.8");
        request.setHeader(HttpHeaders.PRAGMA, "no-cache");
        request.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
        request.setHeader(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.8");
        request.setHeader("upgrade-insecure-requests", "1");

        if (headers != null && headers.length > 0) {
            for (Header header : headers) {
                request.addHeader("Cookie", header.getValue());
            }
        }
        response = client.execute(request);

        if (!Statistics.offer_tracker.containsKey(offer.getId())) {
            if (trackers == null) {
                trackers = new LinkedList<>();
            }
            trackers.add(new Tracker(response.getStatusLine().getStatusCode(), url));
        }


        if (isRedirect(offer, response)) {
            url = response.getHeaders("Location")[0].toString().substring(10).trim();
            if (!AdTool.isStore(url)) {
                requestR(client, ++counter, url, ua, offer, response.getHeaders("set-cookie"), trackers, testing, deviceid, os);
            } else {
                if (!Statistics.offer_tracker.containsKey(offer.getId())) {
                    trackers.add(new Tracker(response.getStatusLine().getStatusCode(), url));
                }
                response.setStatusCode(HttpStatus.SC_MOVED_PERMANENTLY);
                Counter.increaseSuccess(offer.getId());
            }
        } else {
            if (status_code_requires_exit_node_switch(
                    response.getStatusLine().getStatusCode())) {
                Counter.increaseError(offer.getId());
            } else {
                if (!AdTool.isStore(url)) {
                    Counter.increaseSuccess1(offer.getId());
                } else {
                    Counter.increaseSuccess(offer.getId());
                }
            }

        }
        handleTracker(response, offer, trackers);
        handle_response(offer, response);
        return response;

    }


    public static CloseableHttpResponse request(CloseableHttpClient client, int counter, String url, String ua, LiveOffer offer, Header[] headers, List<Tracker> trackers, boolean testing, String deviceid, String os) throws IOException {
        CloseableHttpResponse response = null;
        for (int i = 0; i < 5; i++) {
            url = AdTool.urlEncode(url, deviceid, os);
            HttpGet request = new HttpGet(url);
            request.setProtocolVersion(HttpVersion.HTTP_1_1);
            request.setHeader(HttpHeaders.USER_AGENT, ua);
            request.setHeader(HttpHeaders.CONNECTION, HTTP.CONN_CLOSE);
            request.setHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br");
            request.setHeader(HttpHeaders.ACCEPT, "application/xhtml+xml,application/xml;q=0.9,image/webp, image/apng,*/*;q=0.8");
            request.setHeader(HttpHeaders.PRAGMA, "no-cache");
            request.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
            request.setHeader(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.8");
            request.setHeader("upgrade-insecure-requests", "1");

            if (headers != null && headers.length > 0) {
                for (Header header : headers) {
                    request.addHeader("Cookie", header.getValue());
                }
            }
            response = client.execute(request);
            request.releaseConnection();
            if (!Statistics.offer_tracker.containsKey(offer.getId())) {
                if (trackers == null) {
                    trackers = new LinkedList<>();
                }
                trackers.add(new Tracker(response.getStatusLine().getStatusCode(), url));
            }


            if (isRedirect(offer, response)) {
                url = response.getHeaders("Location")[0].toString().substring(10).trim();
                if (!AdTool.isStore(url)) {
                    headers = response.getHeaders("set-cookie");
                    continue;
                } else {
                    if (!Statistics.offer_tracker.containsKey(offer.getId())) {
                        trackers.add(new Tracker(response.getStatusLine().getStatusCode(), url));
                    }
                    response.setStatusCode(HttpStatus.SC_MOVED_PERMANENTLY);
                    Counter.increaseSuccess(offer.getId());
                    break;
                }
            } else {
                if (status_code_requires_exit_node_switch(
                        response.getStatusLine().getStatusCode())) {
                    Counter.increaseError(offer.getId());
                } else {
                    if (!AdTool.isStore(url)) {
                        Counter.increaseSuccess1(offer.getId());
                    } else {
                        Counter.increaseSuccess(offer.getId());
                    }
                }
                break;

            }
        }
        handleTracker(response, offer, trackers);
        handle_response(offer, response);
        return response;

    }


    public static boolean isRedirect(LiveOffer offer, CloseableHttpResponse response) {
        if (response != null && response.getStatusLine() != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY) {
            String location = response.getHeaders("Location")[0].toString().substring(10).trim();
            return true;
        }
        return false;
    }


    private static Random random = new Random();

    public static void handleTracker(CloseableHttpResponse response, LiveOffer offer, List<Tracker> trackers) {
        int i = random.nextInt(100);
        if (!Statistics.offer_tracker.containsKey(offer.getId())) {
            Statistics.offer_tracker.put(offer.getId(), trackers);
        }
        if (i == 1) {
            Statistics.offer_tracker.remove(offer.getId());
        }
    }

    public static void handle_response(LiveOffer offer, HttpResponse response) {


        int status = response.getStatusLine().getStatusCode();
        if (status == HttpStatus.SC_OK) {
            success_req_account.incrementAndGet();
        }

        logger.warn(offer.getId() + "Total:" + at_req.get() + " Success:" + success_req_account.get() + "PERROR:" + fail_count + " Error:" + error_req_account.get());


        if (response != null && !status_code_requires_exit_node_switch(
                response.getStatusLine().getStatusCode())) {
            // success or other client/website error like 404...
            n_req_for_exit_node++;
            fail_count = 0;
            return;
        }
        switch_session_id();
        fail_count++;
    }

    public static boolean status_code_requires_exit_node_switch(int code) {
        return code == 403 || code == 404 || code == 429 || code == 502 || code == 500 || code == 503;
    }


    public static List<CloseableHttpClient> switch_session_id() {
        List<CloseableHttpClient> clients = new ArrayList<>(parallel);
        clients.forEach(client -> {
            close(client);
        });
        for (int i = 0; i < parallel; i++) {
            try {
                String proxy_session_id = new Random().nextInt(Integer.MAX_VALUE) + "";
                InetAddress address = InetAddress.getByName("session-" + proxy_session_id + ".zproxy.lum-superproxy.io");

                String host = address.getHostAddress();
                clients.add(updateClient(client_geo, proxy_session_id, host, 24000 + i));
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        n_req_for_exit_node = 0;
        return clients;

    }

}
