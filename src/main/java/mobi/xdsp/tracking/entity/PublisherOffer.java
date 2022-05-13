package mobi.xdsp.tracking.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PublisherOffer {
    private Integer id;

    private Integer offerid;

    private Integer publisherid;

    private BigDecimal payout;

    private Float dailybudget;

    private Float monthbudget;

    private Integer dailycap;

    private Integer monthcap;

    private Integer clickcap;

    private Byte redirect;

    private Date applytime;

    private Date approvaltime;

    private Date starttime;

    private Date expirationtime;

    private Integer status;

    private Date createtime;

    private Date updatetime;

    private String createuser;

    private String updateuser;

    private Integer advertiserid;

    private Integer payoutrate;

    private Integer dailydummycap;

    private Integer actioncode;

    private String actionlog;

    private Integer mixrate;

    private Integer directrate;

    private Integer deductrate;

    private String oaplacements;

    private String directofferids;

    private Integer configflag;

    private Integer deleteflag;

    private Integer state;

    private Integer trackingtype;

    private String ukey;

    private Integer hourcap=0;

    private Integer hourclickcap;

    private String redirectids;

    private Integer caputc=0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOfferid() {
        return offerid;
    }

    public void setOfferid(Integer offerid) {
        this.offerid = offerid;
    }

    public Integer getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(Integer publisherid) {
        this.publisherid = publisherid;
    }

    public BigDecimal getPayout() {
        return payout;
    }

    public void setPayout(BigDecimal payout) {
        this.payout = payout;
    }

    public Float getDailybudget() {
        return dailybudget;
    }

    public void setDailybudget(Float dailybudget) {
        this.dailybudget = dailybudget;
    }

    public Float getMonthbudget() {
        return monthbudget;
    }

    public void setMonthbudget(Float monthbudget) {
        this.monthbudget = monthbudget;
    }

    public Integer getDailycap() {
        return dailycap;
    }

    public void setDailycap(Integer dailycap) {
        this.dailycap = dailycap;
    }

    public Integer getMonthcap() {
        return monthcap;
    }

    public void setMonthcap(Integer monthcap) {
        this.monthcap = monthcap;
    }

    public Integer getClickcap() {
        return clickcap;
    }

    public void setClickcap(Integer clickcap) {
        this.clickcap = clickcap;
    }

    public Byte getRedirect() {
        return redirect;
    }

    public void setRedirect(Byte redirect) {
        this.redirect = redirect;
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public Date getApprovaltime() {
        return approvaltime;
    }

    public void setApprovaltime(Date approvaltime) {
        this.approvaltime = approvaltime;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getExpirationtime() {
        return expirationtime;
    }

    public void setExpirationtime(Date expirationtime) {
        this.expirationtime = expirationtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser == null ? null : updateuser.trim();
    }

    public Integer getAdvertiserid() {
        return advertiserid;
    }

    public void setAdvertiserid(Integer advertiserid) {
        this.advertiserid = advertiserid;
    }

    public Integer getPayoutrate() {
        return payoutrate;
    }

    public void setPayoutrate(Integer payoutrate) {
        this.payoutrate = payoutrate;
    }

    public Integer getDailydummycap() {
        return dailydummycap;
    }

    public void setDailydummycap(Integer dailydummycap) {
        this.dailydummycap = dailydummycap;
    }

    public Integer getActioncode() {
        return actioncode;
    }

    public void setActioncode(Integer actioncode) {
        this.actioncode = actioncode;
    }

    public String getActionlog() {
        return actionlog;
    }

    public void setActionlog(String actionlog) {
        this.actionlog = actionlog == null ? null : actionlog.trim();
    }

    public Integer getMixrate() {
        return mixrate;
    }

    public void setMixrate(Integer mixrate) {
        this.mixrate = mixrate;
    }

    public Integer getDirectrate() {
        return directrate;
    }

    public void setDirectrate(Integer directrate) {
        this.directrate = directrate;
    }

    public Integer getDeductrate() {
        return deductrate;
    }

    public void setDeductrate(Integer deductrate) {
        this.deductrate = deductrate;
    }

    public String getOaplacements() {
        return oaplacements;
    }

    public void setOaplacements(String oaplacements) {
        this.oaplacements = oaplacements == null ? null : oaplacements.trim();
    }

    public String getDirectofferids() {
        return directofferids;
    }

    public void setDirectofferids(String directofferids) {
        this.directofferids = directofferids == null ? null : directofferids.trim();
    }

    public Integer getConfigflag() {
        return configflag;
    }

    public void setConfigflag(Integer configflag) {
        this.configflag = configflag;
    }

    public Integer getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(Integer deleteflag) {
        this.deleteflag = deleteflag;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getTrackingtype() {
        return trackingtype;
    }

    public void setTrackingtype(Integer trackingtype) {
        this.trackingtype = trackingtype;
    }

    public String getUkey() {
        return ukey;
    }

    public void setUkey(String ukey) {
        this.ukey = ukey == null ? null : ukey.trim();
    }

    public Integer getHourcap() {
        return hourcap;
    }

    public void setHourcap(Integer hourcap) {
        this.hourcap = hourcap;
    }

    public Integer getHourclickcap() {
        return hourclickcap;
    }

    public void setHourclickcap(Integer hourclickcap) {
        this.hourclickcap = hourclickcap;
    }

    public String getRedirectids() {
        return redirectids;
    }

    public void setRedirectids(String redirectids) {
        this.redirectids = redirectids == null ? null : redirectids.trim();
    }

    public Integer getCaputc() {
        return caputc;
    }

    public void setCaputc(Integer caputc) {
        this.caputc = caputc;
    }
}