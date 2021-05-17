package mobi.xdsp.tracking.entity;

import java.util.Date;

public class DailyReportAdnKey {
    private Integer offerUid;

    private Short channelId;

    private String subId;

    private Date stateDate;

    public Integer getOfferUid() {
        return offerUid;
    }

    public void setOfferUid(Integer offerUid) {
        this.offerUid = offerUid;
    }

    public Short getChannelId() {
        return channelId;
    }

    public void setChannelId(Short channelId) {
        this.channelId = channelId;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId == null ? null : subId.trim();
    }

    public Date getStateDate() {
        return stateDate;
    }

    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }
}