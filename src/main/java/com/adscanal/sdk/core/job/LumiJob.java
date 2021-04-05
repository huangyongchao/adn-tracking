package com.adscanal.sdk.core.job;

import com.adscanal.sdk.core.OfferTask;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.client.fluent.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class LumiJob {
    private static final Logger logger = LoggerFactory.getLogger(LumiJob.class);

    public static Boolean STOP_ALL_REQUEST = false;
    public static float DAILY = 0;
    public static float LIMIT = 0;


    @Scheduled(cron = "0 0/20 * * * ?")
    public void getZoneInfo() {
        try {
            String cost = Request.Get("http://luminati.io/api/zone/cost?zone=static").addHeader("Authorization", "Bearer f1290b71a089b5d803cdf6304fb1076f").execute().returnContent().asString(Consts.UTF_8);
            String zone = Request.Get("http://luminati.io/api/zone?zone=static").addHeader("Authorization", "Bearer f1290b71a089b5d803cdf6304fb1076f").execute().returnContent().asString(Consts.UTF_8);
            System.out.println(cost);
            System.out.println(zone);

            JSONObject costj = JSONObject.parseObject(cost);
            JSONObject zoneJ = JSONObject.parseObject(zone);
            Float daycost = costj.getJSONObject("huangyongchao").getJSONObject("back_d0").getFloat("cost");
            Float daylimit = zoneJ.getJSONObject("usage_limit").getFloat("limit");
            if (daycost > (daylimit * 0.95)) {
                STOP_ALL_REQUEST = true;

                logger.warn("LumiJobStopAll:dailycost=" + daycost + ",limit=" + daylimit);
            } else {
                logger.warn("LumiJobStartAll:dailycost=" + daycost + ",limit=" + daylimit);
                STOP_ALL_REQUEST = false;
            }
            DAILY = daycost;
            LIMIT = daylimit;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @PostConstruct
    public void init() {
        getZoneInfo();
    }

    public static void main(String[] args) {
        JSONObject costj = JSONObject.parseObject("{\"huangyongchao\":{\"back_m2\":{\"bw\":3873333741020,\"cost\":1801},\"back_m1\":{\"bw\":6729961101003,\"cost\":3075},\"back_m0\":{\"bw\":2216103112819,\"cost\":842},\"back_d2\":{\"bw\":387266604772,\"cost\":147},\"back_d1\":{\"bw\":677816059138,\"cost\":258},\"back_d0\":{\"bw\":427144279451,\"cost\":162}}}");
        JSONObject zoneJ = JSONObject.parseObject("{\"password\":[\"q5srrwcvkx9x\"],\"ips\":[\"44.235.122.213\",\"47.88.35.223\"],\"plan\":{\"start\":\"2021-03-29T09:40:09.928Z\",\"type\":\"static\",\"ip_fallback\":1,\"ips_type\":\"shared\",\"ip_alloc_preset\":\"shared_block\",\"bandwidth\":\"payperusage\"},\"usage_limit\":{\"period\":\"d\",\"unit\":\"$\",\"limit\":250,\"editable\":true},\"usage_limit_expires_action\":\"disable\",\"usage_limit_expires\":\"2021-04-05T00:00:00.000Z\",\"static\":1,\"perm\":\"country ip route_all route_dedicated\",\"kw\":{}}");
        Float daycost = costj.getJSONObject("huangyongchao").getJSONObject("back_d0").getFloat("cost");
        Float daylimit = zoneJ.getJSONObject("usage_limit").getFloat("limit");

        System.out.println(daycost > (daylimit * 0.1));
    }
}
