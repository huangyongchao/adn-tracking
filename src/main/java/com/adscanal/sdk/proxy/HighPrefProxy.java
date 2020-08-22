package com.adscanal.sdk.proxy;

import com.adscanal.sdk.common.AdTestUtils;
import com.adscanal.sdk.common.GeoMap;
import com.adscanal.sdk.common.HttpClientUtil;
import com.adscanal.sdk.datafile.Collecter;
import com.adscanal.sdk.dto.LiveOffer;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.apache.http.*;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class HighPrefClient {
    private static final Logger logger = LoggerFactory.getLogger(HighPrefClient.class);
    private static final Logger errorlog = LoggerFactory.getLogger("error");
    private static final Logger tracklogger = LoggerFactory.getLogger("track");
    private static final Logger dtracklogger = LoggerFactory.getLogger("dtrack");

/*    public static final String username = "lum-customer-hl_97bee780-zone-static_res";
    public static final String password = "gwh05xf366u6";*/

    public static final String username = "lum-customer-hl_97bee780-zone-static-route_err-pass_dyn";
    public static final String password = "q5srrwcvkx9x";

    public static final int port = 22225;
    public static final String user_agent = "Mozilla/5.0 (iPhone; CPU iPhone OS 10_1 like Mac OS X) AppleWebKit/602.2.14 (KHTML, like Gecko) Mobile/14B72c";
    public static final int max_failures = 3;
    public static final int req_timeout = 60 * 1000;
    public String session_id;
    public HttpHost super_proxy;
    public CloseableHttpClient client;
    public String country;
    public int fail_count;
    public int n_req_for_exit_node;
    public Random rng;
    public String host;

    public HighPrefClient(String country, String host) {
        this.country = country;
        this.host = host;
        rng = new Random();
        switch_session_id();
    }

    public void switch_session_id() {
        session_id = Integer.toString(rng.nextInt(Integer.MAX_VALUE));
        n_req_for_exit_node = 0;
    /*    51.15.11.249:2752
        51.15.11.249:2753
        51.15.11.249:2754
        51.15.11.249:2755
        51.15.11.249:2756
        51.15.11.249:2757
        51.15.11.249:2758
        51.15.11.249:2759
        51.15.11.249:2760*/

        super_proxy = new HttpHost("51.15.11.249", 2751);
        update_client();
    }

    public void update_client() {
        close();
        String login = username + (country != null ? "-country-" + country : "")
                + "-session-" + session_id;
        CredentialsProvider cred_provider = new BasicCredentialsProvider();
        cred_provider.setCredentials(new AuthScope(super_proxy),
                new UsernamePasswordCredentials(login, password));
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(req_timeout)
                .setConnectionRequestTimeout(req_timeout)
                .build();
        PoolingHttpClientConnectionManager conn_mgr =
                new PoolingHttpClientConnectionManager();
        conn_mgr.setDefaultMaxPerRoute(Integer.MAX_VALUE);
        conn_mgr.setMaxTotal(Integer.MAX_VALUE);


        client = HttpClients.custom()
                .setConnectionManager(conn_mgr)
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
/*
                .setDefaultCredentialsProvider(cred_provider)
*/
                .setDefaultRequestConfig(config)
                .build();
    }

    public boolean isRedirect(LiveOffer offer, CloseableHttpResponse response) {
        if (response != null && response.getStatusLine() != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY) {
            String location = response.getHeaders("Location")[0].toString().substring(10).trim();
            if (location.startsWith("http")) {
                return true;
            } else {
                dtracklogger.info(offer.getOfferId() + ":" + location);
            }
        }
        return false;
    }

    public CloseableHttpResponse request(String url, String ua, LiveOffer offer) throws IOException {
        try {
            CloseableHttpResponse response = null;
            for (int i = 0; i < 5; i++) {
                System.out.println(url);
                url = AdTestUtils.urlEncode(url);
                HttpGet request = new HttpGet(url);
                request.setProtocolVersion(HttpVersion.HTTP_1_0);
                request.addHeader(HttpHeaders.CONNECTION, HTTP.CONN_CLOSE);
                request.addHeader(HttpHeaders.CONTENT_ENCODING, "gzip,deflate");
                request.addHeader(HttpHeaders.USER_AGENT, ua);
                request.addHeader(HttpHeaders.RANGE, "0-100");
                request.addHeader(HttpHeaders.CONTENT_RANGE, "0-100");
                response = client.execute(request);
                if (!isRedirect(offer, response)) {
                    break;
                } else {
                    if (response != null && response.getStatusLine() != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY) {
                        request.addHeader(HttpHeaders.REFERER, url);
                        url = response.getHeaders("Location")[0].toString().substring(10).trim();
                    } else {
                        break;

                    }
                }
            }
            handle_response(response);
            return response;

        } catch (IOException e) {
            handle_response(null);
            throw e;
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
        return code == 403 || code == 429 || code == 502 || code == 503;
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

public class HighPrefProxy implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(HighPrefProxy.class);
    private static final Logger errorlog = LoggerFactory.getLogger("error");
    private static final Logger tracklogger = LoggerFactory.getLogger("track");
    private static final Logger dtracklogger = LoggerFactory.getLogger("dtrack");

    public static final int n_parallel_exit_nodes = 1;
    public static final int n_total_req = 10000000;
    public static final int switch_ip_every_n_req = 40;
    public static AtomicInteger at_req = new AtomicInteger(0);
    public static AtomicInteger success_req_account = new AtomicInteger(0);
    public static AtomicInteger error_req_account = new AtomicInteger(0);

    public static void main(String[] args) {
        Collecter.initGua();
        Collecter.initFilePath();
        System.out.println("To enable your free eval account and get "
                + "CUSTOMER, YOURZONE and YOURPASS, please contact "
                + "sales@luminati.io");
        try {

            int proxy_session_id = new Random().nextInt(Integer.MAX_VALUE);
            InetAddress address = InetAddress.getByName("session-" + proxy_session_id + ".zproxy.lum-superproxy.io");
            String host = address.getHostAddress();
            List<LiveOffer> offers = Lists.newArrayList();
            String cgeo = "VN";

            try {
                //http://54.218.163.206:5080/openapi/test
                String respj = HttpClientUtil.get("http://44.235.122.213:8080/liveoffers?auth=18&type=3&location=" + cgeo);

                JSONArray respja = JSONArray.parseArray(respj);
                if (respja != null && respja.size() > 0) {
                    respja.forEach(n -> {
                        JSONObject o = (JSONObject) n;
                        LiveOffer offer = o.toJavaObject(LiveOffer.class);
                        offers.add(offer);
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(offers.size() ==0){
                return;
            }

            ExecutorService executor =
                    Executors.newFixedThreadPool(n_parallel_exit_nodes);
            List<String> paths = Lists.newArrayList();
            paths.add("/opt/did/VNMios.log.dist");

            for (int i = 2751; i <= 2760; i++) {
                executor.execute(new HighPrefProxy(cgeo.toLowerCase(), host, i, n_parallel_exit_nodes, offers, paths, "1"));
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
    private int line = 0;
    private int cursorline = 0;
    private List<LiveOffer> offers = null;
    private List<String> deviceidfiles = null;
    private String os = null;


    public HighPrefProxy(String geo, String proxyhost, int seed, int nodes, List<LiveOffer> offers, List<String> deviceidfiles, String os) {
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
            deviceidfiles.parallelStream().forEach(path -> {
                try {

                    Files.lines(Paths.get(path)).forEach(deviceid -> {
                        if (++line % totalslice != seed || line < cursorline) {
                            return;
                        }
                        if (at_req.getAndAdd(1) < n_total_req) {
                            if (!client.have_good_super_proxy())
                                client.switch_session_id();
                            if (client.n_req_for_exit_node == switch_ip_every_n_req)
                                client.switch_session_id();
                            CloseableHttpResponse response = null;
                            try {
                                LiveOffer offer = AdTestUtils.randomOffers(offers);
                                String url = AdTestUtils.trackurl(offer.getTrackUrl(), ("AC" + seed + new Date().getHours()), deviceid, UUID.randomUUID().toString().substring(0, 8), null);
                                String ua = AdTestUtils.randomUA(geochar3, os);
                                response = client.request("http://54.218.163.206:5080/openapi/test", ua, offer);
                                int code = response.getStatusLine().getStatusCode();
                                if (code == HttpStatus.SC_OK || code == 307) {
                                    String msg = HttpStatus.SC_OK + "total:" + at_req.get() + " success:" + success_req_account.incrementAndGet() + " error:" + error_req_account.get();
                                    System.out.println(msg);
                                    logger.warn(msg);
                                }
                            } catch (Exception e) {
                                error_req_account.incrementAndGet();
                                errorlog.error(e.getMessage());
                                System.out.println(e.getMessage());
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
