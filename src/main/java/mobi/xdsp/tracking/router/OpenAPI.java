package mobi.xdsp.tracking.router;

import mobi.xdsp.tracking.core.CacheData;
import mobi.xdsp.tracking.entity.Offer;
import mobi.xdsp.tracking.entity.OfferExample;
import mobi.xdsp.tracking.mapper.OfferMapper;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;

@RestController
public class OpenAPI {
    @Autowired
    WebApplicationContext applicationContext;
    @Autowired
    OfferMapper offerMapper;

    @GetMapping("/cacheaff")
    public Object cacheaff() {
        return CacheData.AFF_CACHE;

    }


    @GetMapping("/refreshapicache")
    public Object activeoffers(@RequestParam(name = "token") String token) {
        if (StringUtils.isBlank(token)) {
            return "No tokne";
        } else {
            OffersQueryAPI.QUERY_CACHE.remove(token);
            OffersQueryAPI.QUERY_LOCK.remove(token);

            return "OK";

        }

    }

    @GetMapping("/posc")
    public Object pub_off_smt_cache() {
        return JSONObject.toJSONString(CacheData.PUB_OFF_SMT_CACHE);

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

            stringBuilder.append("<a target='_blank' href=\"http://sdk.pingme.fans/" + n.get("url") + "\">" + n.get("url") + "</a><br>\n");

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
