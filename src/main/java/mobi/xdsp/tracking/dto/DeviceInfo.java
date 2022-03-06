package mobi.xdsp.tracking.dto;

import java.io.Serializable;

public class DeviceInfo implements Serializable {
    private boolean longdata;

    private String devid;

    private String geo = "0";
    private String appid = "0";
    private String pub = "0";
    private String model = "0";
    private String make = "0";
    private String osv = "0";
    private String ua = "";
    private String lang = "";
    private String ip = "";

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    /**
     * @see OsE
     */
    private String os = "0";
    /**
     * @see SspE
     */
    private int ssp;

    public String getDevid() {
        return devid;
    }

    public void setDevid(String devid) {
        this.devid = devid;
    }


    public int getSsp() {
        return ssp;
    }

    public void setSsp(int ssp) {
        this.ssp = ssp;
    }


    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOsv() {
        return osv;
    }

    public void setOsv(String osv) {
        this.osv = osv;
    }

    public boolean isLongdata() {
        return longdata;
    }

    public void setLongdata(boolean longdata) {
        this.longdata = longdata;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
