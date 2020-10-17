package com.adscanal.sdk.dto;

import java.util.concurrent.atomic.LongAdder;

public class OfferCounter {
    public String id;
    /**
     * 点击成功
     */
    public LongAdder success = new LongAdder();
    public long successsnp;
    /**
     * 404 500
     */
    public LongAdder error = new LongAdder();
    public long errorssnp;

    public LongAdder total = new LongAdder();
    public long totalsnp;

    /**
     * 到200落地页
     */
    public LongAdder success1 = new LongAdder();
    public long success1snp;

    /**
     * 非商店 非落地页 其他页面 属于点击不成功
     */
    public LongAdder error1 = new LongAdder();
    public long error1snp;


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

    public long getSuccesssnp() {
        return successsnp;
    }

    public void setSuccesssnp(long successsnp) {
        this.successsnp = successsnp;
    }

    public long getErrorssnp() {
        return errorssnp;
    }

    public void setErrorssnp(long errorssnp) {
        this.errorssnp = errorssnp;
    }

    public long getTotalsnp() {
        return totalsnp;
    }

    public void setTotalsnp(long totalsnp) {
        this.totalsnp = totalsnp;
    }

    public long getSuccess1snp() {
        return success1snp;
    }

    public void setSuccess1snp(long success1snp) {
        this.success1snp = success1snp;
    }

    public long getError1snp() {
        return error1snp;
    }

    public void setError1snp(long error1snp) {
        this.error1snp = error1snp;
    }
}
