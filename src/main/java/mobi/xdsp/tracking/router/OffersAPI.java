package mobi.xdsp.tracking.router;

import com.google.common.collect.Maps;
import mobi.xdsp.tracking.core.CacheData;
import mobi.xdsp.tracking.dto.ResponseModel;
import mobi.xdsp.tracking.dto.offerapi.OfferApiResponse;
import mobi.xdsp.tracking.mapper.OfferMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class OffersAPI {
    /**
     * 每20分钟查询一次 ,20分钟之内.返回缓存
     */
    private Map<String, Date> QUERY_LOCK = Maps.newHashMap();
    private Map<String, OfferApiResponse> QUERY_CACHE = Maps.newHashMap();

    private boolean isCache(String token) {
        boolean returnCache = false;
        if (QUERY_LOCK.containsKey(token)) {
            Date queryDate = new Date();
            Date oldDate = QUERY_LOCK.get(token);
            int minutes = (int) ((queryDate.getTime() - oldDate.getTime()) / (1000 * 60));
            if (minutes < 20) {
                returnCache = true;
            }
        }
        return returnCache;

    }

    @Autowired
    WebApplicationContext applicationContext;
    @Autowired
    OfferMapper offerMapper;


    @GetMapping("/offers")
    public Object offers(@RequestParam(value = "token", required = true) String token) {
        if (StringUtils.isBlank(token) || !CacheData.PUB_TOKEN.containsKey(token)) {
            return new ResponseModel(HttpStatus.SC_BAD_REQUEST, "Invalid token");
        }
        if (isCache(token)) {
            return QUERY_CACHE.get(token);
        }
        OfferApiResponse response = new OfferApiResponse();


        QUERY_LOCK.put(token, new Date());
        return response;
    }

}
