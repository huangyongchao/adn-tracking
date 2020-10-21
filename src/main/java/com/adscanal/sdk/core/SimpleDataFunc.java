package com.adscanal.sdk.core;

import com.adscanal.sdk.dto.SimpleData;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author huangyongchao
 */
@Component
public class SimpleDataFunc {

    public static String getHostByReg(String link) {
        int i = link.indexOf("://");
        int e = link.indexOf("?");
        if(e==-1){
            e = 30;
        }
        return link.substring(i + 3, e);
    }

    public static void saveReriects(int offerUid,String url){

        Map<String, AtomicLong> offer = SimpleData.LIVEOFFERSR_EDIRECT.get(offerUid);
        String domain = getHostByReg(url);
        if (offer.containsKey(domain)) {
            offer.get(domain).incrementAndGet();
        } else {
            offer.put(domain, new AtomicLong());
        }
    }

    public static void main(String[] args) {
        System.out.println(SimpleData.LIVEOFFERSR_EDIRECT.getOrDefault(11, new HashMap<>()));;

        long start = System.currentTimeMillis();
      /*  for (int i = 0; i < 1000000; i++) {
            System.out.println(getHostByReg("https://jingyan.baidu.com/article?ca41422fc76c4a1eae99ed9f.html"));
        }*/
        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000);

    }
}