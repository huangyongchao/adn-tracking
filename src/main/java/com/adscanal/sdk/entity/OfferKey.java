package com.adscanal.sdk.entity;

public class OfferKey {
    private String offerid;

    private Short affiliateid;

    public String getOfferid() {
        return offerid;
    }

    public void setOfferid(String offerid) {
        this.offerid = offerid == null ? null : offerid.trim();
    }

    public Short getAffiliateid() {
        return affiliateid;
    }

    public void setAffiliateid(Short affiliateid) {
        this.affiliateid = affiliateid;
    }
}