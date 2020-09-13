package com.adscanal.sdk.dto;

import java.util.concurrent.atomic.AtomicInteger;

public class ProducerCounter {
    AtomicInteger cursor = new AtomicInteger();
    AtomicInteger queue = new AtomicInteger();
    AtomicInteger request = new AtomicInteger();
    AtomicInteger error500 = new AtomicInteger();
    AtomicInteger error = new AtomicInteger();
    AtomicInteger success = new AtomicInteger();

    public AtomicInteger getCursor() {
        return cursor;
    }

    public void setCursor(AtomicInteger cursor) {
        this.cursor = cursor;
    }

    public AtomicInteger getQueue() {
        return queue;
    }

    public void setQueue(AtomicInteger queue) {
        this.queue = queue;
    }

    public AtomicInteger getRequest() {
        return request;
    }

    public void setRequest(AtomicInteger request) {
        this.request = request;
    }

    public AtomicInteger getError500() {
        return error500;
    }

    public void setError500(AtomicInteger error500) {
        this.error500 = error500;
    }

    public AtomicInteger getError() {
        return error;
    }

    public void setError(AtomicInteger error) {
        this.error = error;
    }

    public AtomicInteger getSuccess() {
        return success;
    }

    public void setSuccess(AtomicInteger success) {
        this.success = success;
    }
}
