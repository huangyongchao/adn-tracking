package com.adscanal.sdk.proxy;

import com.adscanal.sdk.common.AdTestUtils;
import com.adscanal.sdk.common.HttpClientUtil;
import com.adscanal.sdk.datafile.Collecter;
import com.adscanal.sdk.dto.LiveOffer;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.apache.http.*;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huangyongchao
 */
@Service
public class ShifterProxy {
    private static final Logger logger = LoggerFactory.getLogger(ShifterProxy.class);
    private static final Logger errorlog = LoggerFactory.getLogger("error");
    private static final Logger tracklogger = LoggerFactory.getLogger("track");
    private static final Logger dtracklogger = LoggerFactory.getLogger("dtrack");
    public static int fail_count;
    public static int n_req_for_exit_node;
    public static final int max_failures = 3;
    public static final int req_timeout = 60 * 1000;

    public static AtomicInteger at_req = new AtomicInteger(0);
    public static AtomicInteger success_req_account = new AtomicInteger(0);
    public static AtomicInteger error_req_account = new AtomicInteger(0);
    public static final int n_total_req = 70000000;


    public static CloseableHttpClient createClient(String ip, int port) {

        HttpHost super_proxy = new HttpHost(ip, port);
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(req_timeout)
                .setConnectionRequestTimeout(req_timeout)
                .build();
        PoolingHttpClientConnectionManager conn_mgr =
                new PoolingHttpClientConnectionManager();
        conn_mgr.setDefaultMaxPerRoute(Integer.MAX_VALUE);
        conn_mgr.setMaxTotal(Integer.MAX_VALUE);


        return HttpClients.custom()
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
                .setDefaultRequestConfig(config)
                .build();
    }

    public static boolean isRedirect(LiveOffer offer, CloseableHttpResponse response) {
        if (response != null && response.getStatusLine() != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY) {
            String location = response.getHeaders("Location")[0].toString().substring(10).trim();
            if (location.startsWith("http")) {
                return true;
            } else {
                //dtracklogger.info(offer.getOfferId() + ":" + location);
            }
        }
        return false;
    }

    public static CloseableHttpResponse request(CloseableHttpClient client, String url, String ua, LiveOffer offer) throws IOException {
        try {
            CloseableHttpResponse response = null;
            for (int i = 0; i < 5; i++) {
                url = AdTestUtils.urlEncode(url);
                HttpGet request = new HttpGet(url);
                request.addHeader(HttpHeaders.CONNECTION, HTTP.CONN_CLOSE);
                request.addHeader(HttpHeaders.USER_AGENT, ua);
                response = client.execute(request);
                request.releaseConnection();
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

    public static boolean statusError(int code) {
        return code == 403 || code == 429 || code == 502 || code == 503;
    }

    public static void handle_response(HttpResponse response) {
        if (response != null && !statusError(
                response.getStatusLine().getStatusCode())) {
            // success or other client/website error like 404...
            n_req_for_exit_node++;
            fail_count = 0;
            return;
        }
        fail_count++;
    }

    public  static void launch() {


        List<LiveOffer> offers = Lists.newArrayList();
        String cgeo = "VN";
        String cgeo3 = "VNM";
        String os = "1";
        logger.warn("proxy: start "+new Date());

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
        if (offers.size() == 0) {
            return;
        }

        List<CloseableHttpClient> clients = Lists.newArrayList();

        for (int port = 2751; port <= 2760; port++) {
            clients.add(createClient("51.15.11.249", port));
        }


        try {
            System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "200");

            Files.lines(Paths.get("/opt/did/VNMios.log.dist")).parallel().forEach(deviceid -> {
                int i = at_req.getAndAdd(1);
                int seed = i % 10;
                if (i < n_total_req) {
                    CloseableHttpClient client = clients.get(seed);
                    CloseableHttpResponse response = null;
                    try {
                        LiveOffer offer = AdTestUtils.randomOffers(offers);
                        String url = AdTestUtils.trackurl(offer.getTrackUrl(), ("AC" + seed + new Date().getHours()), deviceid, UUID.randomUUID().toString().substring(0, 8), null);
                        String ua = AdTestUtils.randomUA(cgeo3, os);
                        response = request(client, url, ua, offer);
                        int code = response.getStatusLine().getStatusCode();
                        if (code == HttpStatus.SC_OK) {
                            String msg = HttpStatus.SC_OK + "total:" + at_req.get() + " success:" + success_req_account.incrementAndGet() + " error:" + error_req_account.get();
                            if(i%100==0){
                                logger.warn(msg);
                                System.out.println(msg);
                            }
                        }
                    } catch (Exception e) {
                        error_req_account.incrementAndGet();
                        errorlog.error(e.getMessage());
                        System.out.println(e.getMessage());
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.warn("proxy: end "+new Date());
    }

}
