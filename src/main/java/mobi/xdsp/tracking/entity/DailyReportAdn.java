package mobi.xdsp.tracking.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DailyReportAdn extends DailyReportAdnKey {
    private Integer id;

    private String channelName;

    private String subName;

    private Short advertiserId;

    private String advertiserName;

    private Short affiliateId;

    private String affiliateName;

    private String offerId;

    private String offerName;

    private String appId;

    private String appName;

    private String country;

    private Date stateDate;

    private String workerId;

    private String sourceCampaign;

    private Integer bidCount;

    private Integer imprCount;

    private Integer clickCount;

    private Integer clickInvalid;

    private Integer cpcBudget;

    private Integer converionCount;

    private BigDecimal converionPayout;

    private Integer confirmCount;

    private BigDecimal confirmPayout;

    private String currency;

    private Byte status;

    private Date createTime;

    private Integer updateId;

    private Date updateTime;

    private Short sourceAffiliateId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName == null ? null : subName.trim();
    }

    public Short getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(Short advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String getAdvertiserName() {
        return advertiserName;
    }

    public void setAdvertiserName(String advertiserName) {
        this.advertiserName = advertiserName == null ? null : advertiserName.trim();
    }

    public Short getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(Short affiliateId) {
        this.affiliateId = affiliateId;
    }

    public String getAffiliateName() {
        return affiliateName;
    }

    public void setAffiliateName(String affiliateName) {
        this.affiliateName = affiliateName == null ? null : affiliateName.trim();
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId == null ? null : offerId.trim();
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName == null ? null : offerName.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public Date getStateDate() {
        return stateDate;
    }

    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId == null ? null : workerId.trim();
    }

    public String getSourceCampaign() {
        return sourceCampaign;
    }

    public void setSourceCampaign(String sourceCampaign) {
        this.sourceCampaign = sourceCampaign == null ? null : sourceCampaign.trim();
    }

    public Integer getBidCount() {
        return bidCount;
    }

    public void setBidCount(Integer bidCount) {
        this.bidCount = bidCount;
    }

    public Integer getImprCount() {
        return imprCount;
    }

    public void setImprCount(Integer imprCount) {
        this.imprCount = imprCount;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Integer getClickInvalid() {
        return clickInvalid;
    }

    public void setClickInvalid(Integer clickInvalid) {
        this.clickInvalid = clickInvalid;
    }

    public Integer getCpcBudget() {
        return cpcBudget;
    }

    public void setCpcBudget(Integer cpcBudget) {
        this.cpcBudget = cpcBudget;
    }

    public Integer getConverionCount() {
        return converionCount;
    }

    public void setConverionCount(Integer converionCount) {
        this.converionCount = converionCount;
    }

    public BigDecimal getConverionPayout() {
        return converionPayout;
    }

    public void setConverionPayout(BigDecimal converionPayout) {
        this.converionPayout = converionPayout;
    }

    public Integer getConfirmCount() {
        return confirmCount;
    }

    public void setConfirmCount(Integer confirmCount) {
        this.confirmCount = confirmCount;
    }

    public BigDecimal getConfirmPayout() {
        return confirmPayout;
    }

    public void setConfirmPayout(BigDecimal confirmPayout) {
        this.confirmPayout = confirmPayout;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Short getSourceAffiliateId() {
        return sourceAffiliateId;
    }

    public void setSourceAffiliateId(Short sourceAffiliateId) {
        this.sourceAffiliateId = sourceAffiliateId;
    }
}