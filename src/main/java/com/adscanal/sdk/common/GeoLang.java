package com.adscanal.sdk.common;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class V {
    private String lang;
    private String geo;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }
}

public class GeoLang {

    public static Map<String, String> LAN_M = Maps.newHashMap();
    static{
        LAN_M.put("DE", "de-DE");
        LAN_M.put("NO", "en-NO");
        LAN_M.put("PR", "es-PR");
        LAN_M.put("RU", "ru-RU");
        LAN_M.put("BE", "nl-BE");
        LAN_M.put("FI", "fi-FI");
        LAN_M.put("HK", "en-HK");
        LAN_M.put("TW", "zh-TW");
        LAN_M.put("PT", "pt-PT");
        LAN_M.put("JP", "ja-JP");
        LAN_M.put("DK", "da-DK");
        LAN_M.put("LU", "fr-LU");
        LAN_M.put("FR", "fr-FR");
        LAN_M.put("NZ", "en-NZ");
        LAN_M.put("HU", "hu-HU");
        LAN_M.put("BR", "pt-BR");
        LAN_M.put("SE", "sv-SE");
        LAN_M.put("SG", "en-SG");
        LAN_M.put("SL", "sl-SL");
        LAN_M.put("ID", "en-ID");
        LAN_M.put("GB", "en-GB");
        LAN_M.put("IE", "en-IE");
        LAN_M.put("US", "en-US");
        LAN_M.put("CA", "en-CA");
        LAN_M.put("WW", "en-WW");
        LAN_M.put("IL", "he-IL");
        LAN_M.put("CH", "fr-CH");
        LAN_M.put("IN", "en-IN");
        LAN_M.put("KR", "ko-KR");
        LAN_M.put("ZA", "en-ZA");
        LAN_M.put("CL", "es-CL");
        LAN_M.put("XA", "en-XA");
        LAN_M.put("IT", "it-IT");
        LAN_M.put("CN", "zh-CN");
        LAN_M.put("GR", "el-GR");
        LAN_M.put("MX", "es-MX");
        LAN_M.put("CO", "es-CO");
        LAN_M.put("MY", "en-MY");
        LAN_M.put("ES", "es-ES");
        LAN_M.put("AR", "es-AR");
        LAN_M.put("AT", "de-AT");
        LAN_M.put("AU", "en-AU");
        LAN_M.put("TH", "en-TH");
        LAN_M.put("LA", "es-LA");
        LAN_M.put("CZ", "cs-CZ");
        LAN_M.put("PH", "en-PH");
        LAN_M.put("PL", "pl-PL");
        LAN_M.put("TR", "tr-TR");
        LAN_M.put("NL", "nl-NL");
        LAN_M.put("VN", "vi-VN");


    }


    public static void init(){
        List<String> list = Lists.newArrayList();
        list.add("zh-tw");
        list.add("en-hk");
        list.add("en-gb");
        list.add("en-ca");
        list.add("en-ie");
        list.add("fi-fi");
        list.add("da-dk");
        list.add("he-il");
        list.add("en-in");
        list.add("en-sg");
        list.add("en-id");
        list.add("en-th");
        list.add("en-xa");
        list.add("ja-jp");
        list.add("nl-be");
        list.add("pt-br");
        list.add("fr-lu");
        list.add("fr-be");
        list.add("es-la");
        list.add("es-ar");
        list.add("es-mx");
        list.add("es-pr");
        list.add("de-at");
        list.add("ru-ru");
        list.add("el-gr");
        list.add("hu-hu");
        list.add("cs-cz");
        list.add("pl-pl");
        list.add("es-cl");
        list.add("zh-cn");
        list.add("zh-hk");
        list.add("en-us");
        list.add("en-ww");
        list.add("en-au");
        list.add("en-fi");
        list.add("en-dk");
        list.add("en-il");
        list.add("en-za");
        list.add("en-no");
        list.add("en-nz");
        list.add("en-ph");
        list.add("en-my");
        list.add("ko-kr");
        list.add("nl-nl");
        list.add("pt-pt");
        list.add("fr-fr");
        list.add("fr-ch");
        list.add("fr-ca");
        list.add("es-es");
        list.add("es-us");
        list.add("es-co");
        list.add("de-de");
        list.add("de-ch");
        list.add("it-it");
        list.add("no-no");
        list.add("tr-tr");
        list.add("sl-sl");
        list.add("sv-se");

        Map<String, List<V>> ls = list.stream().map(s -> {
            V v = new V();
            String[] ss = s.split("-");
            v.setGeo(ss[1]);
            v.setLang(ss[0]);
            return v;

        }).collect(Collectors.toList()).stream().collect(Collectors.groupingBy(V::getGeo));

        ls.forEach((k,v)->{
            System.out.println(v.get(0).getLang()+"-"+k.toUpperCase());

        });


    }

    public static void main(String[] args) {
        System.out.println(GeoLang.LAN_M.get("VN"));
        System.out.println(GeoLang.LAN_M.get("PH"));
        System.out.println(GeoLang.LAN_M.get("MY"));
        System.out.println(GeoLang.LAN_M.get("SG"));
        System.out.println(GeoLang.LAN_M.get("ID"));
    }

}
