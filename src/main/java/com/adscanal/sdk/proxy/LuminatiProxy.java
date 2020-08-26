package com.adscanal.sdk.proxy;

import com.adscanal.sdk.common.AdTestUtils;
import com.adscanal.sdk.common.GeoMap;
import com.adscanal.sdk.common.HttpClientUtil;
import com.adscanal.sdk.dto.LiveOffer;
import com.adscanal.sdk.dto.OsE;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static com.google.common.net.HttpHeaders.COOKIE;

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
        this.country = country;
        this.host = host;
        rng = new Random();
        switch_session_id();
    }

    public void switch_session_id() {
        session_id = Integer.toString(rng.nextInt(Integer.MAX_VALUE));
        n_req_for_exit_node = 0;
        super_proxy = new HttpHost("44.235.122.213", 24000);
        update_client();
    }

    public  SSLContext createIgnoreVerifySSL(){
        SSLContext sc = null;
        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
        try {
            sc = SSLContext.getInstance("SSLv3");

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
                //.setDefaultCredentialsProvider(cred_provider)
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
                request.setProtocolVersion(HttpVersion.HTTP_1_1);
                request.addHeader(HttpHeaders.CONNECTION, HTTP.CONN_CLOSE);
                request.addHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br");
                request.addHeader(HttpHeaders.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp, image/apng,*/*;q=0.8");
                request.addHeader(HttpHeaders.USER_AGENT, ua);
                request.addHeader(HttpHeaders.PRAGMA, "no-cache'");
                request.addHeader(HttpHeaders.CACHE_CONTROL, "no-cache'");
                request.addHeader(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.8");
                request.addHeader(HttpHeaders.UPGRADE, "1");
                request.addHeader("upgrade-insecure-requests", "1");


                response = client.execute(request);
                if (!isRedirect(offer, response)) {
                    break;
                } else {
                    if (response != null && response.getStatusLine() != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY) {
                        request.addHeader(HttpHeaders.REFERER, url);
                        if(response.getHeaders("Set-Cookie")!=null && response.getHeaders("Set-Cookie").length>0){
                            for (Header cookie :response.getHeaders("Set-Cookie")){
                                request.addHeader(COOKIE, cookie.getValue());
                            }
                        }
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

public class LuminatiProxy implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(LuminatiProxy.class);
    private static final Logger errorlog = LoggerFactory.getLogger("error");
    private static final Logger tracklogger = LoggerFactory.getLogger("track");
    private static final Logger dtracklogger = LoggerFactory.getLogger("dtrack");

    public static final int n_parallel_exit_nodes = 1;
    public static final int n_total_req = 10000000;
    public static final int switch_ip_every_n_req = 40;
    public static AtomicInteger at_req = new AtomicInteger(0);
    public static AtomicInteger success_req_account = new AtomicInteger(0);
    public static AtomicInteger error_req_account = new AtomicInteger(0);

    public static void launch() {

        try {

            int proxy_session_id = new Random().nextInt(Integer.MAX_VALUE);
            InetAddress address = InetAddress.getByName("session-" + proxy_session_id + ".zproxy.lum-superproxy.io");
            //String host = address.getHostAddress();
            String host = "44.235.122.213";
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

            for (int i = 0; i <= n_parallel_exit_nodes; i++) {
                executor.execute(new LuminatiProxy(cgeo.toLowerCase(), host, i, n_parallel_exit_nodes, offers, paths, OsE.IOS.v));
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
                                String url = AdTestUtils.trackurl(os,"https://app.appsflyer.com/id674984916?c=etoro&af_siteid={pub_subid}&af_cost_value={cost_value}&af_cost_currency=USD&af_prt=oneenginemedia&pid=oceanmob_int&af_click_lookback=7d&clickid={click_id}&idfa={idfa}&advertising_id=", ("AC" + new Date().getHours()), deviceid, UUID.randomUUID().toString().substring(0, 8), null);
                                String ua = AdTestUtils.randomUA(geochar3, os);
                                response = client.request(url, ua, offer);
                                int code = response.getStatusLine().getStatusCode();
                                if (code == HttpStatus.SC_OK ) {
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
