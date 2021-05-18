package mobi.xdsp.tracking.entity;

public class DailyReportAdnKey {
    private Integer offerUid;

    private Short channelId;

    private String subId;

    private String daystr;

    private Integer h;

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

    public String getDaystr() {
        return daystr;
    }

    public void setDaystr(String daystr) {
        this.daystr = daystr == null ? null : daystr.trim();
    }

    public Integer getH() {
        return h;
    }

    public void setH(Integer h) {
        this.h = h;
    }
}