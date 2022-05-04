package mobi.xdsp.tracking.router;

import mobi.xdsp.tracking.common.AdTool;
import mobi.xdsp.tracking.common.AddressUtils;
import mobi.xdsp.tracking.common.HttpClientUtil;
import mobi.xdsp.tracking.core.CacheData;
import mobi.xdsp.tracking.core.ShutdownHookEvent;
import mobi.xdsp.tracking.core.job.CacheDataJob;
import mobi.xdsp.tracking.dto.Click;
import mobi.xdsp.tracking.dto.ResponseModel;
import mobi.xdsp.tracking.dto.enums.OfferApplyStatusEnum;
import mobi.xdsp.tracking.dto.enums.RiskLevelE;
import mobi.xdsp.tracking.dto.enums.StateE;
import mobi.xdsp.tracking.entity.Affiliate;
import mobi.xdsp.tracking.entity.Offer;
import mobi.xdsp.tracking.entity.Publisher;
import mobi.xdsp.tracking.entity.PublisherOffer;
import mobi.xdsp.tracking.service.DataService;
import mobi.xdsp.tracking.service.TrackingHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Enumeration;
import java.util.Set;

//@RestController
public class AdjustMock {

    private static final Logger testlog = LoggerFactory.getLogger("test");


    private static final Logger logger = LoggerFactory.getLogger(ConversionAPI.class);

    @CrossOrigin
    @GetMapping("/xxxxx")
    public void tracklist(@RequestParam(value = "pid", required = true) Integer publisherid,
                          @RequestParam(value = "offer", required = true) Integer offerid,
                          @RequestParam(value = "pub_sub", defaultValue = "") String pubSub,
                          @RequestParam(value = "idfa", defaultValue = "") String idfa,
                          @RequestParam(value = "gaid", defaultValue = "") String gaid,
                          @RequestParam(value = "lang", defaultValue = "") String lang,
                          @RequestParam(value = "ip", defaultValue = "") String ip,
                          @RequestParam(value = "ua", defaultValue = "") String ua,
                          @RequestParam(value = "click_id", defaultValue = "") String pubClickid,
                          @RequestParam(value = "sub1", defaultValue = "") String sub1,
                          @RequestParam(value = "sub2", defaultValue = "") String sub2,
                          @RequestParam(value = "sub3", defaultValue = "") String sub3,
                          @RequestParam(value = "sub4", defaultValue = "") String sub4,
                          @RequestParam(value = "sub5", defaultValue = "") String sub5,
                          @RequestParam(value = "sub6", defaultValue = "") String sub6,
                          @RequestParam(value = "appid", defaultValue = "") String appid,
                          @RequestParam(value = "appname", defaultValue = "") String appname,
                          HttpServletRequest request, HttpServletResponse response) throws Exception {


    }
}
