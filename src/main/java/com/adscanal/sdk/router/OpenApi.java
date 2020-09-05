package com.adscanal.sdk.router;

import com.adscanal.sdk.common.Statistics;
import com.adscanal.sdk.dto.Counter;
import com.adscanal.sdk.dto.SimpleData;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class OpenApi {
    @GetMapping("/")
    public String ping() {
        return "ok";
    }

    @GetMapping("/cnt")
    public Object getCounter() {
        return JSONObject.toJSONString(Counter.TODAY_COUNTER);

    }

    @GetMapping("/ids")
    public Object ids() {
        return Counter.counterMap().keySet();

    }

    @GetMapping("/bo")
    public Object bo() {
        return SimpleData.BLACK_OFFERS;

    }

    @GetMapping("/setbo")
    public Object blackoffer(@RequestParam(name = "id") String id) {
        if (StringUtils.isNotBlank(id)) {
            SimpleData.BLACK_OFFERS.add(id);
            return "ok";
        }
        return "Nothing";

    }

    @GetMapping("/offers")
    public Object offers() {
        return SimpleData.GOFFERS;
    }

    @GetMapping("/land")
    public Object land() {
        return SimpleData.OFFER_LAND;
    }

    @GetMapping("/tracking")
    public Object getTracker() {
        return JSONObject.toJSONString((Statistics.offer_tracker));
    }

}
