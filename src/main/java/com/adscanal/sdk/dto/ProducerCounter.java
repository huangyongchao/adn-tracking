package com.adscanal.sdk.dto;

import java.util.concurrent.atomic.AtomicInteger;

public class ProducerCounter {
    AtomicInteger cursor = new AtomicInteger();
    AtomicInteger queue = new AtomicInteger();

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
}
