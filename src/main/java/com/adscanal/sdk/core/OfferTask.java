package com.adscanal.sdk.core;

import com.adscanal.sdk.common.AdTool;
import com.adscanal.sdk.dto.Counter;
import com.adscanal.sdk.dto.LiveOffer;
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
            String url = AdTool.trackurl(os, offer.getTrackUrl(), AdTool.randomSub(offer), deviceid, AdTool.geClickid(offer), null);
            String ua = AdTool.randomUA(os);
            request(ProxyClient.GEO_CLIENTS.get(geo).get(0), url, ua, offer, null, deviceid, os);
        } catch (InterruptedException e) {
            e.printStackTrace();
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


    public void request(CloseableHttpClient client, String url, String ua, LiveOffer offer, Header[] headers, String deviceid, String os) {
        try {
            CloseableHttpResponse response = null;
            boolean issuccess = false;
            for (int i = 0; i < 5; i++) {
                url = AdTool.urlEncode(url, deviceid, os);
                if(i==4){
                    logger.info("ERRORREDIRECT:" + offer.getOsName() + url);
                }
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

                if (isRedirect(offer, response)) {
                    url = response.getHeaders("Location")[0].toString().substring(10).trim();
                    if (!AdTool.isStore(url)) {
                        headers = response.getHeaders("set-cookie");
                        continue;
                    } else {
                        Counter.increaseSuccess(offer.getId());
                        issuccess = true;
                        break;
                    }
                } else {

                    if (status_code_requires_exit_node_switch(
                            response.getStatusLine().getStatusCode())) {
                        Counter.increaseError(offer.getId());
                    } else {

                        logger.info(offer.getName() + " :" + url);
                        Counter.increaseSuccess(offer.getId());
    /*                    if (!AdTool.isStore(url)) {
                            Counter.increaseError1(offer.getId());
                            AdTool.saveLand(offer, url);
                            logger.warn(offer.getOfferId());
                        } else {
                            Counter.increaseSuccess(offer.getId());
                        }*/

                    }
                    break;

                }



            }
            handle_response(offer, response, issuccess);
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

    public void handle_response(LiveOffer offer, HttpResponse response, boolean issuccess) {


        int status = response.getStatusLine().getStatusCode();
        if (issuccess || status == HttpStatus.SC_OK) {
            success_req_account_200.incrementAndGet();
        }
        int i = at_req.get();

        logger.warn(offer.getId() + "Total:" + i + " Success:" + success_req_account_200.get() + " ERROR:" + error_req_account_500.get() + " ERROR:" + error_req_account.get());


        if (response != null && !status_code_requires_exit_node_switch(
                response.getStatusLine().getStatusCode())) {
            // success or other client/website error like 404...
            error_req_account_500.set(0);
            return;
        }
        switch_session_id();
        error_req_account_500.incrementAndGet();
    }

    public boolean status_code_requires_exit_node_switch(int code) {
        return code == 403 || code == 404 || code == 429 || code == 502 || code == 500 || code == 503;
    }

    public List<CloseableHttpClient> switch_session_id() {

        return null;

    }
}
