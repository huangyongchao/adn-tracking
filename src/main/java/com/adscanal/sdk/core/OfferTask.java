package com.adscanal.sdk.core;

import com.adscanal.sdk.common.AdTool;
import com.adscanal.sdk.common.GeoLang;
import com.adscanal.sdk.dto.LiveOffer;
import com.adscanal.sdk.dto.SimpleData;
import org.apache.http.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OfferTask implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(OfferTask.class);
    private static final Logger errorlog = LoggerFactory.getLogger("error");


    public static final int n_total_req = 10000000;
    public static AtomicInteger at_req = new AtomicInteger(0);
    public AtomicInteger success_req_account_store = new AtomicInteger(0);
    public AtomicInteger success_req_account_200 = new AtomicInteger(0);
    public AtomicInteger error_req_account_500 = new AtomicInteger(0);
    public AtomicInteger error_req_account = new AtomicInteger(0);


    private LiveOffer offer;
    private String key;
    private String geo;
    private String os;

    @Override
    public void run() {
            try {

                String deviceid = SdkConf.GEO_OS_QUE.get(key).take().toString();
                if (offer == null || !ProxyClient.GEO_CLIENTS.keySet().contains(geo)) {
                    return;
                }

                SimpleData.PRODUCERCOUNTER.get(key).getQueue().incrementAndGet();
                //long s = System.currentTimeMillis();
                String url = AdTool.trackurl(os, offer.getTrackUrl(), AdTool.randomSub(offer), deviceid, AdTool.geClickid(offer), null);
                String ua = AdTool.randomUA(os);
                request(key, ProxyClient.getConn(geo), url, ua, offer, null, deviceid, os);
                //long d = System.currentTimeMillis();
                //System.out.println(deviceid+"   "+(s-d));



            } catch (InterruptedException e) {
                SimpleData.PRODUCERCOUNTER.get(key).getError().incrementAndGet();
                errorlog.error(e.getMessage(), e);
            }
    }

    public OfferTask(LiveOffer offer, String key, String geo, String os) {
        this.offer = offer;
        this.key = key;
        this.geo = geo;
        this.os = os;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public LiveOffer getOffer() {
        return offer;
    }

    public void setOffer(LiveOffer offer) {
        this.offer = offer;
    }


    public synchronized void  request(String key, CloseableHttpClient client, String url, String ua, LiveOffer offer, Header[] headers, String deviceid, String os) {
        try {
            CloseableHttpResponse response = null;
            for (int i = 0; i < 5; i++) {
                url = AdTool.urlEncode(url, deviceid, os);
                if (i == 4) {
                    logger.info("ERRORREDIRECT:" + offer.getOfferId() + " " + offer.getName() + ua + url);
                }
                HttpGet request = new HttpGet(url);
                request.setProtocolVersion(HttpVersion.HTTP_1_1);
                request.setHeader(HttpHeaders.USER_AGENT, ua);
                request.setHeader(HttpHeaders.CONNECTION, HTTP.CONN_CLOSE);
                request.setHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate");
                request.setHeader(HttpHeaders.ACCEPT, "*/*");
                request.setHeader(HttpHeaders.PRAGMA, "no-cache");
                request.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
                String lang = GeoLang.LAN_M.get(geo);
                if (lang == null) {
                    lang = "en-" + geo;
                }
                request.setHeader(HttpHeaders.ACCEPT_LANGUAGE, lang);

                request.setHeader("upgrade-insecure-requests", "1");

                if (headers != null && headers.length > 0) {
                    for (Header header : headers) {
                        request.addHeader("Cookie", header.getValue());
                    }
                }
                response = client.execute(request);
                request.releaseConnection();

                if (isRedirect(offer, response)) {
                    url = response.getHeaders("Location")[0].toString().replace("location: ","").trim();
                    if (!AdTool.isStore(url)) {
                        headers = response.getHeaders("set-cookie");
                        continue;
                    }else{
                        //302到商店的话
                        SimpleData.PRODUCERCOUNTER.get(key).getSuccess().incrementAndGet();
                    }
                } else {
                    break;
                }

            }
            handle_response(key, offer, response);
            SimpleData.PRODUCERCOUNTER.get(key).getRequest().incrementAndGet();
        } catch (IOException e) {
            errorlog.error(e.getMessage(), e);
            error_req_account.incrementAndGet();
        }

    }

    public static boolean isRedirect(LiveOffer offer, CloseableHttpResponse response) {
        if (response != null && response.getStatusLine() != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY) {
            String location = response.getHeaders("Location")[0].toString().substring(10).trim();
            return true;
        }
        return false;
    }

    public void handle_response(String key, LiveOffer offer, HttpResponse response) {


        int status = response.getStatusLine().getStatusCode();
        if (status == HttpStatus.SC_OK) {
            SimpleData.PRODUCERCOUNTER.get(key).getSuccess().incrementAndGet();
        }
        if (response != null && !status_code_requires_exit_node_switch(
                response.getStatusLine().getStatusCode())) {
            // success or other client/website error like 404...
            return;
        }
        switch_session_id();
        SimpleData.PRODUCERCOUNTER.get(key).getError500().incrementAndGet();
    }

    public boolean status_code_requires_exit_node_switch(int code) {
        return code == 403 || code == 407 || code == 404 || code == 429 || code == 502 || code == 500 || code == 503;
    }

    public List<CloseableHttpClient> switch_session_id() {

        return null;

    }
}
