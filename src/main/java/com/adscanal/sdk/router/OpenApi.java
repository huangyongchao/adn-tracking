package com.adscanal.sdk.router;

import com.adscanal.sdk.common.Statistics;
import com.adscanal.sdk.core.SdkConf;
import com.adscanal.sdk.dto.Counter;
import com.adscanal.sdk.dto.SimpleData;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class OpenApi {
    @Autowired
    WebApplicationContext applicationContext;

    @GetMapping("/live_offers")
    public Object live_offers() {
        return JSONObject.toJSONString(SimpleData.LIVEOFFERS);

    }

    @GetMapping("/today_counter")
    public Object getCounter() {
        return JSONObject.toJSONString(Counter.TODAY_COUNTER);

    }

    @GetMapping("/offer_redirects")
    public Object rcnt() {
        return JSONObject.toJSONString(SimpleData.LIVEOFFERSR_EDIRECT);

    }


    @GetMapping("/run_geos")
    public Object acgeos() {
        return JSONObject.toJSONString(SdkConf.ACTI_GEO);
    }

    @GetMapping("/run_offer_uids")
    public Object ids() {
        return Counter.counterMap().keySet();

    }

    @GetMapping("/black_offers")
    public Object bo() {
        return SimpleData.BLACK_OFFERS;

    }

    @GetMapping("/click_full_pause_offers")
    public Object pause() {
        return SimpleData.PAUSE_OFFERS;

    }

    @GetMapping("/set_black_offer")
    public Object blackoffer(@RequestParam(name = "id") Integer id) {
        if (id != null) {
            SimpleData.BLACK_OFFERS.add(id);
            return "ok";
        }
        return "Nothing";

    }

    @GetMapping("/geo_offers")
    public Object offers() {
        return SimpleData.GOFFERS;
    }

    @GetMapping("/geo_producers")
    public Object producercnt() {
        return SimpleData.PRODUCERCOUNTER;
    }


    @GetMapping("/offer_landing_page")
    public Object land() {
        return SimpleData.OFFER_LAND;
    }


    @GetMapping("/offer_errorreq_count")
    public Object oe() {
        return SimpleData.OFFERERROR;
    }

    @GetMapping("/offer_tracking")
    public Object getTracker() {
        return JSONObject.toJSONString((Statistics.offer_tracker));
    }


    @RequestMapping("/apis")
    public Object getAllUrl() {
        // 获取springmvc处理器映射器组件对象 RequestMappingHandlerMapping无法直接注入
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        //获取url与类和方法的对应信息
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
            Map<String, String> mapone = new HashMap<String, String>();
            RequestMappingInfo info = m.getKey();
            HandlerMethod method = m.getValue();
            // 获取url
            PatternsRequestCondition p = info.getPatternsCondition();
            for (String url : p.getPatterns()) {
                mapone.put("url", url);
            }
            // 反射获取url对应类名和方法名
            mapone.put("className", method.getMethod().getDeclaringClass().getName()); // 类名
            mapone.put("method", method.getMethod().getName()); // 方法名
            // 获取请求类型
            RequestMethodsRequestCondition methodsRequestCondition = info.getMethodsCondition();
            for (RequestMethod requestMethod : methodsRequestCondition.getMethods()) {
                mapone.put("type", requestMethod.toString());
            }
            if (method.getMethod().getDeclaringClass().getName().indexOf("OpenApi") > 0) {
                list.add(mapone);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(n -> {

            stringBuilder.append("<a href=\"http://sdk.colour.mobi" + n.get("url") + "\">" + n.get("url") + "</a><br>\n");

        });

        String s = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Open API</title>\n" +
                "</head>\n" +
                "<body>\n" +
                stringBuilder.toString() +
                "</body>\n" +
                "</html>";

        return s;
    }

}
