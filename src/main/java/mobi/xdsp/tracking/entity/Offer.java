package mobi.xdsp.tracking.entity;

import java.util.Date;

public class Offer extends OfferKey {
    private Integer id;

    private String offername;

    private String affiliatename;

    private String trackurl;

    private String description;

    private String remark;

    private String payouttype;

    private Integer conversioncap;

    private String previewurl;

    private Float defaultpayout;

    private String currency;

    private String status;

    private String apprvoalstatus;

    private String expirationdate;

    private Date systime;

    private String appid;

    private String appname;

    private String appstoreurl;

    private String appicon;

    private String platform;

    private String os;

    private String minos;

    private String creatives;

    private String whitelist;

    private String blacklist;

    private String countries;

    private String cities;

    private Short priority;

    private Float dailybudget;

    private Integer dailymaxclicks;

    private Short rtbrunning;

    private Short running;

    private Byte clicksteps;

    private String toppublisher;

    private String monitor;

    private Date runtime;

    private Date stoptime;

    private String placements;

    private Date inserttime;

    private String proxyinfo;

    private Short isreachable;

    private String schedule;

    private String restrictions;

    private String kpis;

    private String aid;

    private Short sourceaffiliateid;

    private String sourceofferid;

    private String modifyuser;

    private Date modifytime;

    private String platformwhitelist;

    private String trackurlext;

    private String imprurl;

    private String categoryname;

    private Integer risklevel;

    private Integer teststatus;

    private String asyncid;

    private Date testtime;

    private Integer autosubid;

    private Integer autoadjust;

    private Integer automonitor;

    private Integer ismanual;

    private Boolean isappid;

    private Boolean isattrs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOffername() {
        return offername;
    }

    public void setOffername(String offername) {
        this.offername = offername == null ? null : offername.trim();
    }

    public String getAffiliatename() {
        return affiliatename;
    }

    public void setAffiliatename(String affiliatename) {
        this.affiliatename = affiliatename == null ? null : affiliatename.trim();
    }

    public String getTrackurl() {
        return trackurl;
    }

    public void setTrackurl(String trackurl) {
        this.trackurl = trackurl == null ? null : trackurl.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPayouttype() {
        return payouttype;
    }

    public void setPayouttype(String payouttype) {
        this.payouttype = payouttype == null ? null : payouttype.trim();
    }

    public Integer getConversioncap() {
        return conversioncap;
    }

    public void setConversioncap(Integer conversioncap) {
        this.conversioncap = conversioncap;
    }

    public String getPreviewurl() {
        return previewurl;
    }

    public void setPreviewurl(String previewurl) {
        this.previewurl = previewurl == null ? null : previewurl.trim();
    }

    public Float getDefaultpayout() {
        return defaultpayout;
    }

    public void setDefaultpayout(Float defaultpayout) {
        this.defaultpayout = defaultpayout;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getApprvoalstatus() {
        return apprvoalstatus;
    }

    public void setApprvoalstatus(String apprvoalstatus) {
        this.apprvoalstatus = apprvoalstatus == null ? null : apprvoalstatus.trim();
    }

    public String getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(String expirationdate) {
        this.expirationdate = expirationdate == null ? null : expirationdate.trim();
    }

    public Date getSystime() {
        return systime;
    }

    public void setSystime(Date systime) {
        this.systime = systime;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname == null ? null : appname.trim();
    }

    public String getAppstoreurl() {
        return appstoreurl;
    }

    public void setAppstoreurl(String appstoreurl) {
        this.appstoreurl = appstoreurl == null ? null : appstoreurl.trim();
    }

    public String getAppicon() {
        return appicon;
    }

    public void setAppicon(String appicon) {
        this.appicon = appicon == null ? null : appicon.trim();
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os == null ? null : os.trim();
    }

    public String getMinos() {
        return minos;
    }

    public void setMinos(String minos) {
        this.minos = minos == null ? null : minos.trim();
    }

    public String getCreatives() {
        return creatives;
    }

    public void setCreatives(String creatives) {
        this.creatives = creatives == null ? null : creatives.trim();
    }

    public String getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(String whitelist) {
        this.whitelist = whitelist == null ? null : whitelist.trim();
    }

    public String getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(String blacklist) {
        this.blacklist = blacklist == null ? null : blacklist.trim();
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries == null ? null : countries.trim();
    }

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities == null ? null : cities.trim();
    }

    public Short getPriority() {
        return priority;
    }

    public void setPriority(Short priority) {
        this.priority = priority;
    }

    public Float getDailybudget() {
        return dailybudget;
    }

    public void setDailybudget(Float dailybudget) {
        this.dailybudget = dailybudget;
    }

    public Integer getDailymaxclicks() {
        return dailymaxclicks;
    }

    public void setDailymaxclicks(Integer dailymaxclicks) {
        this.dailymaxclicks = dailymaxclicks;
    }

    public Short getRtbrunning() {
        return rtbrunning;
    }

    public void setRtbrunning(Short rtbrunning) {
        this.rtbrunning = rtbrunning;
    }

    public Short getRunning() {
        return running;
    }

    public void setRunning(Short running) {
        this.running = running;
    }

    public Byte getClicksteps() {
        return clicksteps;
    }

    public void setClicksteps(Byte clicksteps) {
        this.clicksteps = clicksteps;
    }

    public String getToppublisher() {
        return toppublisher;
    }

    public void setToppublisher(String toppublisher) {
        this.toppublisher = toppublisher == null ? null : toppublisher.trim();
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor == null ? null : monitor.trim();
    }

    public Date getRuntime() {
        return runtime;
    }

    public void setRuntime(Date runtime) {
        this.runtime = runtime;
    }

    public Date getStoptime() {
        return stoptime;
    }

    public void setStoptime(Date stoptime) {
        this.stoptime = stoptime;
    }

    public String getPlacements() {
        return placements;
    }

    public void setPlacements(String placements) {
        this.placements = placements == null ? null : placements.trim();
    }

    public Date getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    public String getProxyinfo() {
        return proxyinfo;
    }

    public void setProxyinfo(String proxyinfo) {
        this.proxyinfo = proxyinfo == null ? null : proxyinfo.trim();
    }

    public Short getIsreachable() {
        return isreachable;
    }

    public void setIsreachable(Short isreachable) {
        this.isreachable = isreachable;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule == null ? null : schedule.trim();
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions == null ? null : restrictions.trim();
    }

    public String getKpis() {
        return kpis;
    }

    public void setKpis(String kpis) {
        this.kpis = kpis == null ? null : kpis.trim();
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid == null ? null : aid.trim();
    }

    public Short getSourceaffiliateid() {
        return sourceaffiliateid;
    }

    public void setSourceaffiliateid(Short sourceaffiliateid) {
        this.sourceaffiliateid = sourceaffiliateid;
    }

    public String getSourceofferid() {
        return sourceofferid;
    }

    public void setSourceofferid(String sourceofferid) {
        this.sourceofferid = sourceofferid == null ? null : sourceofferid.trim();
    }

    public String getModifyuser() {
        return modifyuser;
    }

    public void setModifyuser(String modifyuser) {
        this.modifyuser = modifyuser == null ? null : modifyuser.trim();
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getPlatformwhitelist() {
        return platformwhitelist;
    }

    public void setPlatformwhitelist(String platformwhitelist) {
        this.platformwhitelist = platformwhitelist == null ? null : platformwhitelist.trim();
    }

    public String getTrackurlext() {
        return trackurlext;
    }

    public void setTrackurlext(String trackurlext) {
        this.trackurlext = trackurlext == null ? null : trackurlext.trim();
    }

    public String getImprurl() {
        return imprurl;
    }

    public void setImprurl(String imprurl) {
        this.imprurl = imprurl == null ? null : imprurl.trim();
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
    }

    public Integer getRisklevel() {
        return risklevel;
    }

    public void setRisklevel(Integer risklevel) {
        this.risklevel = risklevel;
    }

    public Integer getTeststatus() {
        return teststatus;
    }

    public void setTeststatus(Integer teststatus) {
        this.teststatus = teststatus;
    }

    public String getAsyncid() {
        return asyncid;
    }

    public void setAsyncid(String asyncid) {
        this.asyncid = asyncid == null ? null : asyncid.trim();
    }

    public Date getTesttime() {
        return testtime;
    }

    public void setTesttime(Date testtime) {
        this.testtime = testtime;
    }

    public Integer getAutosubid() {
        return autosubid;
    }

    public void setAutosubid(Integer autosubid) {
        this.autosubid = autosubid;
    }

    public Integer getAutoadjust() {
        return autoadjust;
    }

    public void setAutoadjust(Integer autoadjust) {
        this.autoadjust = autoadjust;
    }

    public Integer getAutomonitor() {
        return automonitor;
    }

    public void setAutomonitor(Integer automonitor) {
        this.automonitor = automonitor;
    }

    public Integer getIsmanual() {
        return ismanual;
    }

    public void setIsmanual(Integer ismanual) {
        this.ismanual = ismanual;
    }

    public Boolean getIsappid() {
        return isappid;
    }

    public void setIsappid(Boolean isappid) {
        this.isappid = isappid;
    }

    public Boolean getIsattrs() {
        return isattrs;
    }

    public void setIsattrs(Boolean isattrs) {
        this.isattrs = isattrs;
    }
}