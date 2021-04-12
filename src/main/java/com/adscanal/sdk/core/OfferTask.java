package com.adscanal.sdk.core;

import com.adscanal.sdk.common.AdTool;
import com.adscanal.sdk.common.GeoLang;
import com.adscanal.sdk.common.Mailer;
import com.adscanal.sdk.core.job.LumiJob;
import com.adscanal.sdk.dto.Counter;
import com.adscanal.sdk.dto.LiveOffer;
import com.adscanal.sdk.dto.SimpleData;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class OfferTask implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(OfferTask.class);
    private static final Logger errorlog = LoggerFactory.getLogger("error");


    public static volatile long n_total_req = 0;
    public static AtomicLong at_req = new AtomicLong(0);
    public AtomicInteger success_req_account_store = new AtomicInteger(0);
    public AtomicInteger success_req_account_200 = new AtomicInteger(0);
    public AtomicInteger error_req_account_500 = new AtomicInteger(0);
    public AtomicInteger error_req_account = new AtomicInteger(0);


    private LiveOffer offer;
    private String key;
    private String geo;
    private String geo3;
    private String os;
    private int serNo;
    private Mailer mailer;

    public void consumer(int serNo) {
        exec(serNo);
    }

    @Override
    public void run() {
        exec(serNo);
    }

    public void exec(int seriNo) {
        try {
            if (LumiJob.STOP_ALL_REQUEST) {

                return;
            }

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
            //request(key, , url, ua, offer, null, deviceid, os);
            request(key, ProxyClient.getConn(geo, seriNo), url, ua, offer, null, deviceid, os);
        } catch (InterruptedException e) {
            SimpleData.PRODUCERCOUNTER.get(key).getError().incrementAndGet();
            errorlog.error(e.getMessage(), e);
        }
    }

    public OfferTask(LiveOffer offer, String key, String geo3, String geo, String os, int serNo, Mailer mailer) {
        this.offer = offer;
        this.key = key;
        this.geo = geo;
        this.geo3 = geo3;
        this.os = os;
        this.serNo = serNo;
        this.mailer = mailer;
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

                if (!url.startsWith("http")) {
                    Counter.increaseError(offer.getUid());
                    at_req.incrementAndGet();

                    return;

                }

                HttpGet request = new HttpGet(url);
                request.setProtocolVersion(HttpVersion.HTTP_1_1);
                request.setHeader(HttpHeaders.USER_AGENT, ua);
                request.setHeader(HttpHeaders.CONNECTION, HTTP.CONN_CLOSE);
                request.setHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br");
                request.setHeader(HttpHeaders.ACCEPT, "*/*");
                request.setHeader(HttpHeaders.PRAGMA, "no-cache");
                request.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
                String lang = GeoLang.LAN_M.get(geo);
                if (lang == null) {
                    lang = "en-" + geo;
                }
                boolean iscpi = false ;
                if (LazadaCPIExt.AID_VN.equals(offer.getaId())) {
                    iscpi = true;
                }
                request.setHeader(HttpHeaders.ACCEPT_LANGUAGE, lang + ";q=0.9,en-US;q=0.8,en;q=0.7");
                request.setHeader("upgrade-insecure-requests", "1");
                if (iscpi) {

                    if (headers != null && headers.length > 0) {
                        for (Header header : headers) {

                            String value = header.getValue();
                            System.out.println(value);
                            if (value.indexOf(LazadaCPIExt.miidlaz) >= 0 || value.indexOf(LazadaCPIExt.exlaz) >= 0 || value.indexOf(LazadaCPIExt.lzd_click_id) >= 0) {
                                request.addHeader("set-cookie", value);
                                logger.warn(value);
                            }
                        }
                    }
                }
                response = client.execute(request);
                request.releaseConnection();

                boolean is3rd = AdTool.is3pt(url);
                if (SdkConf.DEBUG_REQ_LOG.contains(offer.getUid())) {
                    logger.warn(url);
                }
                if (502 == response.getStatusLine().getStatusCode()) {
                    System.out.println(502);
                    return;
                }
                boolean isStore = AdTool.isStore(url);

                if (isRedirect(offer, response) && !is3rd && !isStore) {
                    url = response.getHeaders("Location")[0].toString().replace("location: ", "").trim();
                    if(iscpi){

                        headers = response.getAllHeaders();
                        if(headers!=null){
                            System.out.println("111");
                            for(Header header : headers){
                                System.out.println(header.getValue());

                            }

                        }
                    }
                    continue;

                }
                int status = response.getStatusLine().getStatusCode();
                if (isStore) {
                    Counter.increaseSuccess(offer.getUid());
                } else if ((status == HttpStatus.SC_OK)) {
                    Counter.increaseSuccess(offer.getUid());
                } else if (is3rd) {
                    Counter.increaseSuccess1(offer.getUid());
                } else if (i == 5) {
                    Counter.increaseError1(offer.getUid());
                } else {
                    Counter.increaseError(offer.getUid());
                }
                break;

            }
            handle_response(key, offer, response);
            SimpleData.PRODUCERCOUNTER.get(key).getRequest().incrementAndGet();
            at_req.incrementAndGet();

        } catch (Exception e) {
            //Counter.increaseError(offer.getUid());
            errorlog.error(url, e);
            error_req_account.incrementAndGet();
        }

    }

    public static boolean isRedirect(LiveOffer offer, HttpResponse response) {
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


    public static void main(String[] args) {
        String url = "https://u.lazada.co.th/u/c.bVWZnP?lp_url=https%3A%2F%2Fpages.lazada.co.th%2Fwow%2Fi%2Fth%2Fmarketing%2Fams_lp%3Fhybrid%3D1%26laz_trackid%3D2%3Amm_164131072_52202903_2011302891%3Aclk5hg4a71et8ingeum6jm%26mkttid%3Dclk5hg4a71et8ingeum6jm%26exlaz%3Dc_5z9KGVExw904bLdPw10DoZOiJVbNcTncscD4vkQsEoM%25253D&fallback=true&deeplink=true";

        new HttpGet(url);
    }
}
