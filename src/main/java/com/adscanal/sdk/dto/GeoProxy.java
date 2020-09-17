package com.adscanal.sdk.dto;

public class GeoProxy {
    private boolean isRun;
    private String geo;
    private String proxyserver;
    private int port;
    private int skip;
    private int offset;
    private boolean isIOS;
    private boolean isAOS;
    private String iospath;
    private String aospath;

    public boolean isRun() {
        return isRun;
    }

    public void setRun(boolean run) {
        isRun = run;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public String getProxyserver() {
        return proxyserver;
    }

    public void setProxyserver(String proxyserver) {
        this.proxyserver = proxyserver;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isIOS() {
        return isIOS;
    }

    public void setIOS(boolean IOS) {
        isIOS = IOS;
    }

    public boolean isAOS() {
        return isAOS;
    }

    public void setAOS(boolean AOS) {
        isAOS = AOS;
    }

    public String getIospath() {
        return iospath;
    }

    public void setIospath(String iospath) {
        this.iospath = iospath;
    }

    public String getAospath() {
        return aospath;
    }

    public void setAospath(String aospath) {
        this.aospath = aospath;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }
}
