package com.adscanal.sdk.core;

import java.net.URLEncoder;

public class LazadaCPIExt {
    public static String lp_url_vn = "lp_url=https://pages.lazada.vn/wow/gcp/route/lazada/vn/upr_1000345_lazada/channel/vn/upr-router/vn?hybrid=1&data_prefetch=true&prefetch_replace=1&wh_pid=/lazada/channel/vn/khuyen-mai/lazada-chao-ban-moi&";
    public static String suffix = "&fallback=false&deeplink=false";
    public static void  lazadaVN(){

        //https://u.lazada.vn/u/c.ZCo5zd?lp_url=laz_trackid=4:mm_160831343_52003356_2010903443:clk5h42p61f2eqc0jl10e8&mkttid=clk5h42p61f2eqc0jl10e8&clickId=clk5h42p61f2eqc0jl10e8exlaz=c_jeptLWlL50SKxfrR9uXSjdHqRzyZnM4YcbeOGv2O2ok%3D
    }

    public static void main(String[] args) {
        String furl = "https://c.lazada.vn/t/c.ZCo5zd?sub_aff_id=%7Bpub_subid%7D&idfa=%7Bidfa%7D&sub_id1=%7Bclick_id%7D";
        String surl = "https://www.lazada.vn?laz_trackid=4:mm_160831343_52003356_2010903443:clk5h33e61f2eqrut91cmu&mkttid=clk5h33e61f2eqrut91cmu";
        String setcookie = "XSRF-TOKEN=d569077b-0315-4a45-a79d-9f8a19d1f51d; Path=/; HttpOnlymiidlaz=miid5h33e61f2eqrutc1cn2; Max-Age=86400000; Expires=Sat, 30-Dec-2023 16:18:48 GMT; Domain=lazada.vn; Path=/exlaz=c_NqEd9oiMxGAGgiXOoscfkSCFRJJWpapQfxH0zdZxxyY%3D; Domain=lazada.vn; Path=/lzd_click_id=clk5h33e61f2eqrut91cmu; Max-Age=86400000; Expires=Sat, 30-Dec-2023 16:18:48 GMT; Domain=lazada.vn; Path=/disable_smb=true; Max-Age=0; Expires=Thu, 01-Jan-1970 00:00:10 GMT; Domain=lazada.vn; Path=/";

        String urlbase = furl.substring(0,furl.indexOf("?")+1);
        String urlsecond = surl.substring(surl.indexOf("?")+1);
        String clickid = surl.substring(surl.indexOf("mkttid=") + 7);
        String exlaz = setcookie.substring(setcookie.indexOf("exlaz=") + 6);
        exlaz = exlaz.substring(0, exlaz.indexOf(";"));
        System.out.println(urlbase);
        System.out.println(urlsecond);
        System.out.println(clickid);
        System.out.println(exlaz);

        String fin = urlbase.replace("c.lazada.vn/t/c","u.lazada.vn/u/c") + lp_url_vn + urlsecond + "&clickId=" + clickid + "&exlaz=" + exlaz+suffix;
        System.out.println(fin);
    }

}
