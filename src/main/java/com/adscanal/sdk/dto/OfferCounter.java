package com.adscanal.sdk.dto;

import java.util.concurrent.atomic.LongAdder;

public class OfferCounter {
    public String id ;
    public LongAdder success = new LongAdder();
    public LongAdder error = new LongAdder();
    public LongAdder total = new LongAdder();
    public LongAdder success1 = new LongAdder();
    public LongAdder error1 = new LongAdder();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LongAdder getSuccess() {
        return success;
    }

    public void setSuccess(LongAdder success) {
        this.success = success;
    }

    public LongAdder getError() {
        return error;
    }

    public void setError(LongAdder error) {
        this.error = error;
    }

    public LongAdder getTotal() {
        return total;
    }

    public void setTotal(LongAdder total) {
        this.total = total;
    }

    public LongAdder getSuccess1() {
        return success1;
    }

    public void setSuccess1(LongAdder success1) {
        this.success1 = success1;
    }

    public LongAdder getError1() {
        return error1;
    }

    public void setError1(LongAdder error1) {
        this.error1 = error1;
    }



}
