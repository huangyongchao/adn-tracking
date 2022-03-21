package mobi.xdsp.tracking.maf;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import mobi.xdsp.tracking.maf.dto.MafOffer;
import mobi.xdsp.tracking.maf.dto.MafResp;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;

@Component
public class MafDao {
    final String CONTENT_TYPE_TEXT_JSON = "text/json";

    final String edit = "http://94.74.108.73:5003/prod-api/obuzz";
    final String query = "http://94.74.108.73:5003/prod-api/obuzz?page=1&page_size=200";
    final String login = "http://94.74.108.73:5003/prod-api/site/login";
    final String loginJSON = "{\"email\":\"test@qq.com\",\"password\":\"87654321\"}";
    private static String TTTTKKKK = null;


/*    Request URL: http://94.74.108.73:5003/prod-api/obuzz/edit-clk-limit
    Request Method: PATCH
    {"id":6301,"site_clk_limit":1000000}*/
/*    Request URL: http://94.74.108.73:5003/prod-api/obuzz/offer-max-clk
    Request Method: PATCH
    {"id":6302,"max_clk_num":2000000}*/

/*    Request URL: http://94.74.108.73:5003/prod-api/obuzz/status
    Request Method: PATCH
    {"id":6302,"status":1}*/

    @Scheduled(cron = "* */30 * * * ?")
    public void login() {
        try {
            HttpPost httpPost = new HttpPost(URI.create(login));
            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
            httpPost.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36");
            httpPost.setHeader("Referer", "http://94.74.108.73:5003/");
            httpPost.setHeader("Origin", "http://94.74.108.73:5003/");
            JSONObject jsonObject = JSONObject.parseObject(loginJSON);
            StringEntity json = new StringEntity(jsonObject.toJSONString());
            json.setContentType(CONTENT_TYPE_TEXT_JSON);
            httpPost.setEntity(json);
            CloseableHttpResponse response = HttpClients.createDefault().execute(httpPost);
            JSONObject resp = JSONObject.parseObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
            String token = resp.getJSONObject("data").getString("token");
            TTTTKKKK = token;
            System.out.println(token);
        } catch (Exception e) {
            e.printStackTrace();
            TTTTKKKK = null;
        }

    }


    public void putEdit(String token, MafOffer offer) {

        try {
            offer.setType("2");
            offer.setCopy_offer("");

            HttpPut httpPost = new HttpPut(URI.create(edit));
            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
            httpPost.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36");
            httpPost.setHeader("Referer", "http://94.74.108.73:5003/");
            httpPost.setHeader("Origin", "http://94.74.108.73:5003/");
            String jsonstr = JSONObject.toJSONString(offer);
            System.out.println(jsonstr);
            JSONObject jsonObject = JSONObject.parseObject(jsonstr);
            StringEntity json = new StringEntity(jsonObject.toJSONString());
            httpPost.setHeader("Cookie", "Token=" + token);
            httpPost.setHeader("token", token);
            httpPost.setHeader("Authorization", "Bearer " + token);
            json.setContentType(CONTENT_TYPE_TEXT_JSON);
            httpPost.setEntity(json);

            CloseableHttpResponse response = HttpClients.createDefault().execute(httpPost);
            System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void post(String token, MafOffer offer) {

        try {
            offer.setType("1");
            offer.setOperation_type("1");
            offer.setCopy_offer("");
            offer.setUpdate_date(null);
            offer.setCreate_date(null);

            HttpPost httpPost = new HttpPost(URI.create(edit));
            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
            httpPost.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36");
            httpPost.setHeader("Referer", "http://94.74.108.73:5003/");
            httpPost.setHeader("Origin", "http://94.74.108.73:5003/");
            String jsonstr = JSONObject.toJSONString(offer);
            System.out.println(jsonstr);
            JSONObject jsonObject = JSONObject.parseObject(jsonstr);
            StringEntity json = new StringEntity(jsonObject.toJSONString());
            httpPost.setHeader("Cookie", "Token=" + token);
            httpPost.setHeader("token", token);
            httpPost.setHeader("Authorization", "Bearer " + token);
            json.setContentType(CONTENT_TYPE_TEXT_JSON);
            httpPost.setEntity(json);

            CloseableHttpResponse response = HttpClients.createDefault().execute(httpPost);
            System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public MafResp query(String token) {

        try {
            HttpGet httpPost = new HttpGet(URI.create(query));
            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
            httpPost.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36");
            httpPost.setHeader("Referer", "http://94.74.108.73:5003/");
            httpPost.setHeader("Origin", "http://94.74.108.73:5003/");
            httpPost.setHeader("Cookie", "Token=" + token);
            httpPost.setHeader("token", token);
            httpPost.setHeader("Authorization", "Bearer " + token);
            CloseableHttpResponse response = HttpClients.createDefault().execute(httpPost);
            MafResp resp = JSON.parseObject(EntityUtils.toString(response.getEntity(), "UTF-8"), MafResp.class);


            return resp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }



    public static void main(String[] args) {
        new MafDao().login();
        new MafDao().query(TTTTKKKK);
    }
}
