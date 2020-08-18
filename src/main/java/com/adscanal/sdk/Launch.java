package com.adscanal.sdk;

import com.adscanal.sdk.common.AppConstant;
import com.adscanal.sdk.common.AdTestUtils;
import com.adscanal.sdk.dto.LiveOffer;
import com.adscanal.sdk.proxy.SimpleProxy;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class Launch {
    private static final Logger logger = LoggerFactory.getLogger(SimpleProxy.class);
    private static final Logger errorlog = LoggerFactory.getLogger("error");
    private static final Logger tracklogger = LoggerFactory.getLogger("track");

    public static AtomicInteger counter = new AtomicInteger(0);
    public static AtomicInteger errorcounter = new AtomicInteger(0);
    SimpleProxy client = null;
    public static LiveOffer randomOffer(List<LiveOffer> offers) {

        int le = offers.size();
        int i = new Random().nextInt(le);
        return offers.get(i);
    }

    public static String randomUA(LiveOffer offer) {

        List<String> uas = AppConstant.GEO_UA.get("IND1");
        int le = uas.size();
        int i = new Random().nextInt(le);
        return uas.get(i);
    }


    public static void main(String[] args) {
    }

    @PostConstruct
    public void launch() {
        AppConstant.initGua();
        try {

            client = new SimpleProxy("in");

            LiveOffer offer1 = new LiveOffer();
            offer1.setOfferId("1477754");
            offer1.setTrackUrl("https://3point14.g2afse.com/click?pid=1125&offer_id=1477754&ref_id={click_id}&sub2={pub_subid}&sub3={device_id}&sub1={click_id}");


            LiveOffer offer4 = new LiveOffer();
            offer4.setOfferId("1931298");
            offer4.setTrackUrl("https://3point14.g2afse.com/click?pid=1125&offer_id=1931298&ref_id={click_id}&sub2={pub_subid}&sub3={device_id}&sub1={click_id}");


            LiveOffer offer5 = new LiveOffer();
            offer5.setOfferId("1970038");
            offer5.setTrackUrl("https://3point14.g2afse.com/click?pid=1125&offer_id=1970038&ref_id={click_id}&sub2={pub_subid}&sub3={device_id}&sub1={click_id}");

            List<LiveOffer> offers = Lists.newArrayList();
            offers.add(offer1);
            offers.add(offer4);
            offers.add(offer4);
            offers.add(offer5);


            Files.lines(Paths.get("/Volumes/FrankSSD/distdevid/inios.log")).forEach(idfa -> {

                LiveOffer offer = randomOffer(offers);
                int hour = new Date().getHours();
                String trackurl = offer.getTrackUrl();
                if (trackurl == null) {
                    return;
                }
                trackurl = AdTestUtils.trackurl(trackurl, "AC" + hour, idfa, UUID.randomUUID().toString().substring(0, 8), null);
                try {
                    client.request(randomUA(offer), trackurl, offer);
                } catch (Exception e) {
                    int c = errorcounter.incrementAndGet();
                    String endline = "errorreqcounter:" + c;
                    System.out.println(endline);
                    errorlog.error(e.getMessage());
                    client = new SimpleProxy("in");
                } finally {
                    int c = counter.incrementAndGet();
                    String endline = "reqcounter:" + c;
                    System.out.println(endline);
                    logger.error(endline);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            errorlog.error(e.getMessage());
        }
    }
}
