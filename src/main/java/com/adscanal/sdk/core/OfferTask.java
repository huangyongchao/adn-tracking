package com.adscanal.sdk.core;

import com.adscanal.sdk.common.AdTool;
import com.adscanal.sdk.common.GeoLang;
import com.adscanal.sdk.dto.Counter;
import com.adscanal.sdk.dto.LiveOffer;
import com.adscanal.sdk.dto.SimpleData;
import org.apache.http.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private String geo3;
    private String os;

    @Override
    public void run() {
        try {
            if (SimpleData.PAUSE_OFFERS.contains(offer.getUid())) {
                return;
            }
            if (offer == null || !ProxyClient.GEO_CLIENTS.keySet().contains(geo)) {
                return;
            }
            offer = SimpleData.LIVEOFFERS.get(offer.getUid());
            String deviceid = SdkConf.GEO_OS_QUE.get(key).take().toString();

            SimpleData.PRODUCERCOUNTER.get(key).getQueue().incrementAndGet();
            String url = AdTool.trackurl(os, offer.getTrackUrl(), AdTool.randomSub(offer), deviceid, AdTool.geClickid(offer), null);
            String ua = AdTool.randomUA(os);
            request(key, ProxyClient.getConn(geo), url, ua, offer, null, deviceid, os);
           // logger.info(offer.getOfferId() + ":" + SimpleData.OFFERREQCOUNTER.get(offer.getOfferId()).incrementAndGet());

        } catch (InterruptedException e) {
            SimpleData.PRODUCERCOUNTER.get(key).getError().incrementAndGet();
            errorlog.error(e.getMessage(), e);
        }
    }

    public OfferTask(LiveOffer offer, String key, String geo3, String geo, String os) {
        this.offer = offer;
        this.key = key;
        this.geo = geo;
        this.geo3 = geo3;
        this.os = os;
        // logger.warn("SCHE INIT:"+geo3 +" "+ key+" "+os);
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


    public void request(String key, CloseableHttpClient client, String url, String ua, LiveOffer offer, Header[] headers, String deviceid, String os) {
        try {
            CloseableHttpResponse response = null;
            int steps = 3;
            if (offer.getClickSteps() != null && offer.getClickSteps() >= 3) {
                steps = offer.getClickSteps();
            }
            for (int i = 0; i < steps; i++) {
                url = AdTool.urlEncode(url, deviceid, os);
                if (i == 5) {
                    Counter.increaseError1(offer.getUid());
                    break;
                }
                if (!url.startsWith("http")) {
                    Counter.increaseError(offer.getUid());
                    break;
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

                boolean is3rd = AdTool.is3pt(url);
                if (SdkConf.DEBUG_REQ_LOG.contains(offer.getUid())) {
                    logger.warn(url);
                }
                if (isRedirect(offer, response) && !is3rd) {
                    url = response.getHeaders("Location")[0].toString().replace("location: ", "").trim();
                    headers = response.getHeaders("set-cookie");
                    continue;
                } else {
                    int status = response.getStatusLine().getStatusCode();
                    if ((status == HttpStatus.SC_OK)) {
                        Counter.increaseSuccess(offer.getUid());
                    } else if (is3rd) {
                        Counter.increaseSuccess1(offer.getUid());
                    } else {
                        Counter.increaseError(offer.getUid());
                    }
                    break;
                }

            }
            handle_response(key, offer, response);
            SimpleData.PRODUCERCOUNTER.get(key).getRequest().incrementAndGet();
        } catch (Exception e) {
            Counter.increaseError(offer.getUid());
            errorlog.error(e.getMessage(), e);
            error_req_account.incrementAndGet();
        }

    }

    public static boolean isRedirect(LiveOffer offer, CloseableHttpResponse response) {
        if (response != null && response.getStatusLine() != null && (response.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY || response.getStatusLine().getStatusCode() == HttpStatus.SC_TEMPORARY_REDIRECT)) {
            return true;
        }
        return false;
    }

    public void handle_response(String key, LiveOffer offer, HttpResponse response) {


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
