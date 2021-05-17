package mobi.xdsp.tracking.router;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import mobi.xdsp.tracking.common.HttpClientUtil;
import mobi.xdsp.tracking.entity.Publisher;
import mobi.xdsp.tracking.entity.PublisherExample;
import mobi.xdsp.tracking.service.DataService;
import mobi.xdsp.tracking.service.TrackingHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestingAPI {

    @Autowired
    private TrackingHandler handler;
    @Autowired
    private DataService dataService;

    @GetMapping("/testpb")
    public Object tracklist(@RequestParam(value = "pid", required = true) Integer publisherid,
                            @RequestParam(value = "pub_sub", defaultValue = "") String pubSub,
                            @RequestParam(value = "idfa", defaultValue = "") String idfa,
                            @RequestParam(value = "gaid", defaultValue = "") String gaid,
                            @RequestParam(value = "lang", defaultValue = "") String lang,
                            @RequestParam(value = "ip", defaultValue = "") String ip,
                            @RequestParam(value = "ua", defaultValue = "") String ua,
                            @RequestParam(value = "click_id", defaultValue = "") String pubClickid,
                            @RequestParam(value = "sub1", defaultValue = "") String sub1,
                            @RequestParam(value = "sub2", defaultValue = "") String sub2,
                            @RequestParam(value = "appid", defaultValue = "") String appid,
                            @RequestParam(value = "appname", defaultValue = "") String appname,
                            HttpServletRequest request, HttpServletResponse response) throws Exception {

        if(publisherid==null){
            return "Publisher not exist";
        }
        Publisher p = dataService.getPublisherCache(publisherid);
        if(p==null){
            return "Publisher not exist";
        }
        if (StringUtils.isBlank(p.getPostbackurl())||p.getPostbackurl().indexOf("{click_id}")<0) {
            return "Publisher PostBack set error";
        }

        String track = p.getPostbackurl();
        if (track.indexOf("{click_id}") > -1 && StringUtils.isNotBlank(pubClickid)) {
            track = StringUtils.replaceAll(track, "\\{click_id}", pubClickid);
        }
        if (track.indexOf("{idfa}") > -1 && StringUtils.isNotBlank(idfa)) {
            track = StringUtils.replaceAll(track, "\\{idfa}", idfa);
        }

        if (track.indexOf("{gaid}") > -1 && StringUtils.isNotBlank(gaid)) {
            track = StringUtils.replaceAll(track, "\\{gaid}", gaid);
        }

        if (track.indexOf("{pub_sub}") > -1 && StringUtils.isNotBlank(pubSub)) {
            track = StringUtils.replaceAll(track, "\\{pub_sub}", pubSub);
        }

        if (track.indexOf("{appid}") > -1 && StringUtils.isNotBlank(appid)) {
            track = StringUtils.replaceAll(track, "\\{appid}", appid);
        }
        if (track.indexOf("{appname}") > -1 && StringUtils.isNotBlank(appname)) {
            track = StringUtils.replaceAll(track, "\\{appid}", appid);
        }
        if (track.indexOf("{sub1}") > -1 && StringUtils.isNotBlank(sub1)) {
            track = StringUtils.replaceAll(track, "\\{sub1}", sub1);
        }
        if (track.indexOf("{sub2}") > -1 && StringUtils.isNotBlank(sub2)) {
            track = StringUtils.replaceAll(track, "\\{sub2}", sub2);
        }
        if (track.indexOf("{ip}") > -1 && StringUtils.isNotBlank(ip)) {
            track = StringUtils.replaceAll(track, "\\{ip}", ip);
        }
        if (track.indexOf("{ua}") > -1 && StringUtils.isNotBlank(ua)) {
            track = StringUtils.replaceAll(track, "\\{ua}", ua);
        }
        if (track.indexOf("{lang}") > -1 && StringUtils.isNotBlank(lang)) {
            track = StringUtils.replaceAll(track, "\\{lang}", lang);
        }

        return HttpClientUtil.get(track);
    }

    @GetMapping("/testclick")
    public Object testclick(
            @RequestParam(value = "url", required = true, defaultValue = "") String testlink,
            HttpServletRequest request) throws Exception {


        // 模拟（创建）一个浏览器用户
        Map resp = Maps.newHashMap();
        boolean isourend = false;
        List<Map> redirects = Lists.newArrayList();
        testlink = URLDecoder.decode(testlink, "utf-8");
        Map o = new HashMap();
        o.put("status", 200);
        o.put("url", testlink);
        redirects.add(o);
        if (testlink.indexOf("pubearn.com") > 0 || testlink.indexOf("adscanal.com") > 0) {
            isourend = true;
        }

        if (!isourend) {
            for (int i = 0; i < 3; i++) {

                CloseableHttpClient client = HttpClients.createDefault();
                HttpGet httpGet = new HttpGet(testlink);
                CloseableHttpResponse response = client.execute(httpGet);
                testlink = response.getHeaders("Location")[0].toString().replace("location: ", "").trim();
                Map o1 = new HashMap();
                o1.put("status", response.getStatusLine().getStatusCode());
                o1.put("url", testlink);
                redirects.add(o1);
                if (testlink.indexOf("pubearn.com") > 0 || testlink.indexOf("adscanal.com") > 0) {
                    isourend = true;
                    break;
                }
            }

        }
        resp.put("tracks", redirects);
        if (isourend) {
            URL url = new URL(testlink);
            String q = url.getQuery();
            String[] qs = q.split("&");
            List<Map> params = Lists.newArrayList();
            for (String s : qs) {
                String[] ks = s.split("=");
                if (ks != null && ks.length > 1) {
                    Map param = new HashMap();
                    param.put("param", ks[0]);
                    param.put("value", ks[1]);
                    params.add(param);
                }

            }
            resp.put("status", true);
            resp.put("params", params);
            if(StringUtils.isNotBlank(q)){
                resp.put("q", q);
            }
        } else {
            resp.put("status", false);

        }
        return resp;

    }

}
