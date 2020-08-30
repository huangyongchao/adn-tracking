package com.adscanal.sdk.router;

import com.adscanal.sdk.common.Statistics;
import com.adscanal.sdk.dto.Counter;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api")
public class OpenApi {

    @GetMapping("cnt")
    public Object getCounter() {
        return JSONObject.toJSONString(Counter.TODAY_COUNTER);

    }

    @GetMapping("track")
    public Object getTracker() {
        return JSONObject.toJSONString((Statistics.offer_tracker));
    }

}
