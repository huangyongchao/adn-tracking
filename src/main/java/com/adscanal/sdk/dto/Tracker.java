package com.adscanal.sdk.dto;

public class Tracker {
    public int status;

    public String url;

    public Tracker(int status, String url) {
        this.status = status;
        this.url = url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
