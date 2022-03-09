package mobi.xdsp.tracking;

import com.alibaba.fastjson.JSONObject;
import mobi.xdsp.tracking.common.HttpClientUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class SdkApplicationTests {
    public static void main(String[] args) {


        try {
            JSONObject jsonObject = HttpClientUtil.getAndBodyAsJson("http://94.74.108.73");
            jsonObject.getJSONArray("data").forEach(n->{
                JSONObject obj = (JSONObject) n;
                System.out.println(obj.getString("offer_id") + "," + obj.getString("title")+ "," + obj.getString("tracking_link"));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
