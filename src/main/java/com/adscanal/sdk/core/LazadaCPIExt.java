package com.adscanal.sdk.core;

import java.net.URLEncoder;

public class LazadaCPIExt {

    public static String miidlaz = "miidlaz";
    public static String exlaz = "exlaz";
    public static String lzd_click_id = "lzd_click_id";

    public static String AID_ID = "1047";
    public static String AID_VN = "1048";
    public static String AID_PH = "1049";
    public static String AID_SG = "1038";
    public static String AID_TH = "";
    public static String AID_MY = "";
    public static String vn_lp_url = "lp_url=https://pages.lazada.vn/wow/gcp/route/lazada/vn/upr_1000345_lazada/channel/vn/upr-router/vn?hybrid=1&data_prefetch=true&prefetch_replace=1&wh_pid=/lazada/channel/vn/khuyen-mai/lazada-chao-ban-moi&";
    public static String vnpc = "c.lazada.vn/t/c";
    public static String vnmobile = "u.lazada.vn/u/c";

    public static String id_lp_url = "lp_url=https://www.lazada.co.id/?";
    public static String idpc = "c.lazada.com.ph/t/c";
    public static String idmobile = "u.lazada.com.ph/u/c";


    public static String ph_lp_url = "p_url=https://www.lazada.com.ph?";
    public static String phpc = "c.lazada.co.id/t/c";
    public static String phmobile = "u.lazada.co.id/u/c";


    public static String sg_lp_url = "lp_url=https://www.lazada.sg/?";
    public static String sgpc = "c.lazada.sg/t/c";
    public static String sgmobile = "u.lazada.sg/u/c";


    public static String suffix = "&fallback=false&deeplink=false";

    public static String  lazadaCPI(String furl,String location,String setcookie,String pc,String mobile ,String lpurl) {
        String urlbase = furl.substring(0, furl.indexOf("?") + 1);
        String urlsecond = location.substring(location.indexOf("?") + 1);
        String clickid = location.substring(location.indexOf("mkttid=") + 7);
        String exlaz = setcookie.substring(setcookie.indexOf("exlaz=") + 6);
        exlaz = exlaz.substring(0, exlaz.indexOf(";"));

        String finalurl = urlbase.replace(pc, mobile) + lpurl + urlsecond + "&clickId=" + clickid + "&exlaz=" + exlaz + suffix;
        return finalurl;
    }

    public static void main(String[] args) {
        String furl = "https://c.lazada.vn/t/c.ZCo5zd?sub_aff_id=%7Bpub_subid%7D&idfa=%7Bidfa%7D&sub_id1=%7Bclick_id%7D";
        String surl = "https://www.lazada.vn?laz_trackid=4:mm_160831343_52003356_2010903443:clk5h33e61f2eqrut91cmu&mkttid=clk5h33e61f2eqrut91cmu";
        String setcookie = "XSRF-TOKEN=d569077b-0315-4a45-a79d-9f8a19d1f51d; Path=/; HttpOnlymiidlaz=miid5h33e61f2eqrutc1cn2; Max-Age=86400000; Expires=Sat, 30-Dec-2023 16:18:48 GMT; Domain=lazada.vn; Path=/exlaz=c_NqEd9oiMxGAGgiXOoscfkSCFRJJWpapQfxH0zdZxxyY%3D; Domain=lazada.vn; Path=/lzd_click_id=clk5h33e61f2eqrut91cmu; Max-Age=86400000; Expires=Sat, 30-Dec-2023 16:18:48 GMT; Domain=lazada.vn; Path=/disable_smb=true; Max-Age=0; Expires=Thu, 01-Jan-1970 00:00:10 GMT; Domain=lazada.vn; Path=/";
/*
        String urlbase = furl.substring(0, furl.indexOf("?") + 1);
        String urlsecond = surl.substring(surl.indexOf("?") + 1);
        String clickid = surl.substring(surl.indexOf("mkttid=") + 7);
        String exlaz = setcookie.substring(setcookie.indexOf("exlaz=") + 6);
        exlaz = exlaz.substring(0, exlaz.indexOf(";"));

        String fin = urlbase.replace("c.lazada.vn/t/c", "u.lazada.vn/u/c") + lp_url_vn + urlsecond + "&clickId=" + clickid + "&exlaz=" + exlaz + suffix;
        System.out.println(fin);*/

        System.out.println(lazadaCPI(furl, surl, setcookie, vnpc, vnmobile, vn_lp_url));
    }

}
