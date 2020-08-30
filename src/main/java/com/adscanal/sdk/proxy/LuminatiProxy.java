package com.adscanal.sdk.proxy;

import com.adscanal.sdk.common.AdTool;
import com.adscanal.sdk.common.GeoMap;
import com.adscanal.sdk.common.Statistics;
import com.adscanal.sdk.dto.Counter;
import com.adscanal.sdk.dto.LiveOffer;
import com.adscanal.sdk.dto.Tracker;
import com.google.common.collect.Lists;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

class HighPrefClient {
    private static final Logger logger = LoggerFactory.getLogger(HighPrefClient.class);
    private static final Logger errorlog = LoggerFactory.getLogger("error");
    private static final Logger tracklogger = LoggerFactory.getLogger("track");
    private static final Logger dtracklogger = LoggerFactory.getLogger("dtrack");

    public static final String username = "lum-customer-huangyongchao-zone-residential-route_err-block";
    public static final String password = "hhlgwhurqyv3";

    public static final int port = 22225;
    public static final String user_agent = "Mozilla/5.0 (iPhone; CPU iPhone OS 10_1 like Mac OS X) AppleWebKit/602.2.14 (KHTML, like Gecko) Mobile/14B72c";
    public static final int max_failures = 3;
    public static final int req_timeout = 10 * 1000;
    public String session_id;
    public HttpHost super_proxy;
    public CloseableHttpClient client;
    public String country;
    public int fail_count;
    public int n_req_for_exit_node;
    public Random rng;
    public String host;

    public HighPrefClient(String country, String host) {
        this.country = country.toLowerCase();
        this.host = host;
        rng = new Random();
        switch_session_id();
    }

    public void switch_session_id() {
        session_id = Integer.toString(rng.nextInt(Integer.MAX_VALUE));
        n_req_for_exit_node = 0;
        super_proxy = new HttpHost(host, port);
        update_client();
    }

    public  SSLContext createIgnoreVerifySSL(){
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

            sc.init(null, new TrustManager[] { trustManager }, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sc;
    }


    public void update_client() {
        close();
        String login = username + (country != null ? "-country-" + country : "")
                + "-session-" + session_id;
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
        client = HttpClients.custom()
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

    }

    public boolean isRedirect(LiveOffer offer, CloseableHttpResponse response) {
        if (response != null && response.getStatusLine() != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY) {
            String location = response.getHeaders("Location")[0].toString().substring(10).trim();
            return true;
        }
        return false;
    }


    public CloseableHttpResponse request(int counter, String url, String ua, LiveOffer offer, Header[] headers, List<Tracker> trackers, boolean testing) throws IOException {
        CloseableHttpResponse response = null;

        for (int i = 0; i < 5; i++) {
            url = AdTool.urlEncode(url);
            HttpGet request = new HttpGet(url);
            request.setProtocolVersion(HttpVersion.HTTP_1_1);
            request.setHeader(HttpHeaders.USER_AGENT, ua);
            request.setHeader(HttpHeaders.CONNECTION, HTTP.CONN_CLOSE);
            request.setHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br");
            request.setHeader(HttpHeaders.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp, image/apng,*/*;q=0.8");
            request.setHeader(HttpHeaders.PRAGMA, "no-cache'");
            request.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache'");
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
                headers = response.getHeaders("set-cookie");

                if (!AdTool.isStore(url)) {
                    headers = response.getHeaders("set-cookie");
                } else {
                    response.setStatusCode(HttpStatus.SC_MOVED_PERMANENTLY);
                    if (!Statistics.offer_tracker.containsKey(offer.getId())) {
                        trackers.add(new Tracker(response.getStatusLine().getStatusCode(), url));
                    }
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
                break;

            }

        }
        handleTracker(response, offer, trackers);
        handle_response(response);
        return response;

    }


    public CloseableHttpResponse requestR(int counter, String url, String ua, LiveOffer offer, Header[] headers, List<Tracker> trackers, boolean testing) throws IOException {
        CloseableHttpResponse response = null;
        url = AdTool.urlEncode(url);
        HttpGet request = new HttpGet(url);
        request.setProtocolVersion(HttpVersion.HTTP_1_1);
        request.setHeader(HttpHeaders.USER_AGENT, ua);
        request.setHeader(HttpHeaders.CONNECTION, HTTP.CONN_CLOSE);
        request.setHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br");
        request.setHeader(HttpHeaders.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp, image/apng,*/*;q=0.8");
        request.setHeader(HttpHeaders.PRAGMA, "no-cache'");
        request.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache'");
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
            if (counter > 5) {
                Counter.increaseError1(offer.getId());
                if (!Statistics.offer_tracker.containsKey(offer.getId())) {
                    trackers.add(new Tracker(response.getStatusLine().getStatusCode(), url));
                }
                return response;
            }
            if (!AdTool.isStore(url)) {
                requestR(++counter, url, ua, offer, response.getHeaders("set-cookie"), trackers, testing);
            } else {
                response.setStatusCode(HttpStatus.SC_MOVED_PERMANENTLY);
                if (!Statistics.offer_tracker.containsKey(offer.getId())) {
                    trackers.add(new Tracker(response.getStatusLine().getStatusCode(), url));
                }
                Counter.increaseSuccess(offer.getId());
            }
        } else {
            if(status_code_requires_exit_node_switch(
                    response.getStatusLine().getStatusCode())){
                Counter.increaseError(offer.getId());
            }else{
                if (!AdTool.isStore(url)) {
                    Counter.increaseSuccess1(offer.getId());
                } else {
                    Counter.increaseSuccess(offer.getId());
                }
            }

        }
        handleTracker(response, offer, trackers);
        handle_response(response);
        return response;

    }

    private Random random = new Random();

    public void handleTracker(CloseableHttpResponse response, LiveOffer offer, List<Tracker> trackers) {
        int i = random.nextInt(100);
        if (!Statistics.offer_tracker.containsKey(offer.getId())) {
            Statistics.offer_tracker.put(offer.getId(), trackers);
        }
        if (i == 1) {
            Statistics.offer_tracker.remove(offer.getId());
        }
    }

    public void handle_response(HttpResponse response) {
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

    public boolean status_code_requires_exit_node_switch(int code) {
        return code == 403 || code == 404 ||code == 429 || code == 502 || code == 500 ||  code == 503;
    }

    public boolean have_good_super_proxy() {
        return super_proxy != null && fail_count < max_failures;
    }

    public void close() {
        if (client != null)
            try {
                client.close();
            } catch (IOException e) {
            }
        client = null;
    }
}

public class LuminatiProxy implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(LuminatiProxy.class);
    private static final Logger errorlog = LoggerFactory.getLogger("error");
    private static final Logger tracklogger = LoggerFactory.getLogger("track");
    private static final Logger dtracklogger = LoggerFactory.getLogger("dtrack");

    public static int n_parallel_exit_nodes = 1;
    public static final int n_total_req = 10000000;
    public static final int switch_ip_every_n_req = 40;
    public static AtomicInteger at_req = new AtomicInteger(0);
    public static AtomicInteger success_req_account = new AtomicInteger(0);
    public static AtomicInteger error_req_account = new AtomicInteger(0);

    public static void launch(String geo, String os, List<LiveOffer> offers, int parallel) {

        try {
            if (StringUtils.isBlank(geo) || StringUtils.isBlank(GeoMap.word2Map.get(geo))) {
                System.out.println("GEO null,  can`t start");
                return;
            }
            int proxy_session_id = new Random().nextInt(Integer.MAX_VALUE);
            InetAddress address = InetAddress.getByName("session-" + proxy_session_id + ".zproxy.lum-superproxy.io");

            String host = address.getHostAddress();


            n_parallel_exit_nodes = parallel;
            ExecutorService executor =
                    Executors.newFixedThreadPool(n_parallel_exit_nodes);
            List<String> paths = Lists.newArrayList();
            paths.add("/opt/did/" + GeoMap.word2Map.get(geo.toUpperCase()) + os + ".log.dist");

            for (int i = 0; i <= n_parallel_exit_nodes; i++) {
                executor.execute(new LuminatiProxy(geo, host, i, n_parallel_exit_nodes, offers, paths, os));
            }
            executor.shutdown();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private String geo = null;
    private String geochar3 = null;
    private HighPrefClient client = null;
    private int seed = 0;
    private int totalslice = 5;
    private AtomicLong line = new AtomicLong();
    private long cursorline = 0;
    private List<LiveOffer> offers = null;
    private List<String> deviceidfiles = null;
    private String os = null;


    public LuminatiProxy(String geo, String proxyhost, int seed, int nodes, List<LiveOffer> offers, List<String> deviceidfiles, String os) {
        this.geo = geo;
        client = new HighPrefClient(geo, proxyhost);
        this.seed = seed;
        this.totalslice = nodes;
        this.offers = offers;
        this.deviceidfiles = deviceidfiles;
        this.os = os;
        this.geochar3 = GeoMap.word2Map.get(geo.toUpperCase());


    }

    @Override
    public void run() {

        try {
            if (client == null || geo == null) {
                System.out.println("Please set geo");
            }
            deviceidfiles.forEach(path -> {
                try {

                    Files.lines(Paths.get(path)).forEach(deviceid -> {

                        long l = line.incrementAndGet();
                        if (l % totalslice != seed || l < cursorline) {
                            return;
                        }
                        if (at_req.getAndAdd(1) < n_total_req) {
                            if (!client.have_good_super_proxy())
                                client.switch_session_id();
                            if (client.n_req_for_exit_node == switch_ip_every_n_req)
                                client.switch_session_id();
                            CloseableHttpResponse response = null;
                            try {
                                LiveOffer offer = AdTool.randomOffers(offers);
                                System.out.println(deviceid);
                                String url = AdTool.trackurl(os, offer.getTrackUrl(), AdTool.randomSub(offer), deviceid, AdTool.geClickid(offer), null);
                                System.out.println(url);
                                String ua = AdTool.randomUA(os);
                                List<Tracker> trackers = null;
                                response = client.requestR(1, url, ua, offer, null, null, false);
                                int status = response.getStatusLine().getStatusCode();
                                if (status == HttpStatus.SC_OK || status == HttpStatus.SC_MOVED_PERMANENTLY) {
                                    success_req_account.incrementAndGet();
                                }
                                if (status > 400) {
                                    error_req_account.incrementAndGet();
                                }
                                System.out.println(offer.getId() + "Total:" + at_req.get() + " Success:" + success_req_account.get() + " Error:" + error_req_account.get());
                            } catch (Exception e) {
                                error_req_account.incrementAndGet();
                                errorlog.error(e.getMessage());
                            } finally {

                                try {
                                    if (response != null)
                                        response.close();
                                } catch (Exception e) {
                                }
                            }
                        }

                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });


            client.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (client != null)
                client.close();
        }
    }
}
