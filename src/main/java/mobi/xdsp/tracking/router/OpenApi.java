package mobi.xdsp.tracking.router;

import mobi.xdsp.tracking.entity.Offer;
import mobi.xdsp.tracking.entity.OfferExample;
import mobi.xdsp.tracking.mapper.OfferMapper;
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

import java.util.*;

@RestController
@EnableAutoConfiguration
public class OpenApi {
    @Autowired
    WebApplicationContext applicationContext;
    @Autowired
    OfferMapper offerMapper;



    @GetMapping("/activeoffers")
    public Object activeoffers() {
        OfferExample example = new OfferExample();
        example.createCriteria().andPriorityGreaterThan(Short.valueOf("1")).andStatusEqualTo("active");

        List<Offer> offers = offerMapper.selectByExample(example);
        return JSONObject.toJSONString(Optional.of(offers).orElse(new ArrayList<>()));

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
