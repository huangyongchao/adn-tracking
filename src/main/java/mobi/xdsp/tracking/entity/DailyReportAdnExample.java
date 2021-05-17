package mobi.xdsp.tracking.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DailyReportAdnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public DailyReportAdnExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOfferUidIsNull() {
            addCriterion("offer_uid is null");
            return (Criteria) this;
        }

        public Criteria andOfferUidIsNotNull() {
            addCriterion("offer_uid is not null");
            return (Criteria) this;
        }

        public Criteria andOfferUidEqualTo(Integer value) {
            addCriterion("offer_uid =", value, "offerUid");
            return (Criteria) this;
        }

        public Criteria andOfferUidNotEqualTo(Integer value) {
            addCriterion("offer_uid <>", value, "offerUid");
            return (Criteria) this;
        }

        public Criteria andOfferUidGreaterThan(Integer value) {
            addCriterion("offer_uid >", value, "offerUid");
            return (Criteria) this;
        }

        public Criteria andOfferUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("offer_uid >=", value, "offerUid");
            return (Criteria) this;
        }

        public Criteria andOfferUidLessThan(Integer value) {
            addCriterion("offer_uid <", value, "offerUid");
            return (Criteria) this;
        }

        public Criteria andOfferUidLessThanOrEqualTo(Integer value) {
            addCriterion("offer_uid <=", value, "offerUid");
            return (Criteria) this;
        }

        public Criteria andOfferUidIn(List<Integer> values) {
            addCriterion("offer_uid in", values, "offerUid");
            return (Criteria) this;
        }

        public Criteria andOfferUidNotIn(List<Integer> values) {
            addCriterion("offer_uid not in", values, "offerUid");
            return (Criteria) this;
        }

        public Criteria andOfferUidBetween(Integer value1, Integer value2) {
            addCriterion("offer_uid between", value1, value2, "offerUid");
            return (Criteria) this;
        }

        public Criteria andOfferUidNotBetween(Integer value1, Integer value2) {
            addCriterion("offer_uid not between", value1, value2, "offerUid");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(Short value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(Short value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(Short value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(Short value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(Short value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(Short value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<Short> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<Short> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(Short value1, Short value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(Short value1, Short value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andSubIdIsNull() {
            addCriterion("sub_id is null");
            return (Criteria) this;
        }

        public Criteria andSubIdIsNotNull() {
            addCriterion("sub_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubIdEqualTo(String value) {
            addCriterion("sub_id =", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotEqualTo(String value) {
            addCriterion("sub_id <>", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdGreaterThan(String value) {
            addCriterion("sub_id >", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdGreaterThanOrEqualTo(String value) {
            addCriterion("sub_id >=", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdLessThan(String value) {
            addCriterion("sub_id <", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdLessThanOrEqualTo(String value) {
            addCriterion("sub_id <=", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdLike(String value) {
            addCriterion("sub_id like", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotLike(String value) {
            addCriterion("sub_id not like", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdIn(List<String> values) {
            addCriterion("sub_id in", values, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotIn(List<String> values) {
            addCriterion("sub_id not in", values, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdBetween(String value1, String value2) {
            addCriterion("sub_id between", value1, value2, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotBetween(String value1, String value2) {
            addCriterion("sub_id not between", value1, value2, "subId");
            return (Criteria) this;
        }

        public Criteria andStateDateIsNull() {
            addCriterion("state_date is null");
            return (Criteria) this;
        }

        public Criteria andStateDateIsNotNull() {
            addCriterion("state_date is not null");
            return (Criteria) this;
        }

        public Criteria andStateDateEqualTo(Date value) {
            addCriterion("state_date =", value, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateNotEqualTo(Date value) {
            addCriterion("state_date <>", value, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateGreaterThan(Date value) {
            addCriterion("state_date >", value, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("state_date >=", value, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateLessThan(Date value) {
            addCriterion("state_date <", value, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateLessThanOrEqualTo(Date value) {
            addCriterion("state_date <=", value, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateIn(List<Date> values) {
            addCriterion("state_date in", values, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateNotIn(List<Date> values) {
            addCriterion("state_date not in", values, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateBetween(Date value1, Date value2) {
            addCriterion("state_date between", value1, value2, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateNotBetween(Date value1, Date value2) {
            addCriterion("state_date not between", value1, value2, "stateDate");
            return (Criteria) this;
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andChannelNameIsNull() {
            addCriterion("channel_name is null");
            return (Criteria) this;
        }

        public Criteria andChannelNameIsNotNull() {
            addCriterion("channel_name is not null");
            return (Criteria) this;
        }

        public Criteria andChannelNameEqualTo(String value) {
            addCriterion("channel_name =", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotEqualTo(String value) {
            addCriterion("channel_name <>", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameGreaterThan(String value) {
            addCriterion("channel_name >", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameGreaterThanOrEqualTo(String value) {
            addCriterion("channel_name >=", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLessThan(String value) {
            addCriterion("channel_name <", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLessThanOrEqualTo(String value) {
            addCriterion("channel_name <=", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLike(String value) {
            addCriterion("channel_name like", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotLike(String value) {
            addCriterion("channel_name not like", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameIn(List<String> values) {
            addCriterion("channel_name in", values, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotIn(List<String> values) {
            addCriterion("channel_name not in", values, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameBetween(String value1, String value2) {
            addCriterion("channel_name between", value1, value2, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotBetween(String value1, String value2) {
            addCriterion("channel_name not between", value1, value2, "channelName");
            return (Criteria) this;
        }

        public Criteria andSubNameIsNull() {
            addCriterion("sub_name is null");
            return (Criteria) this;
        }

        public Criteria andSubNameIsNotNull() {
            addCriterion("sub_name is not null");
            return (Criteria) this;
        }

        public Criteria andSubNameEqualTo(String value) {
            addCriterion("sub_name =", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameNotEqualTo(String value) {
            addCriterion("sub_name <>", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameGreaterThan(String value) {
            addCriterion("sub_name >", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameGreaterThanOrEqualTo(String value) {
            addCriterion("sub_name >=", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameLessThan(String value) {
            addCriterion("sub_name <", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameLessThanOrEqualTo(String value) {
            addCriterion("sub_name <=", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameLike(String value) {
            addCriterion("sub_name like", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameNotLike(String value) {
            addCriterion("sub_name not like", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameIn(List<String> values) {
            addCriterion("sub_name in", values, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameNotIn(List<String> values) {
            addCriterion("sub_name not in", values, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameBetween(String value1, String value2) {
            addCriterion("sub_name between", value1, value2, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameNotBetween(String value1, String value2) {
            addCriterion("sub_name not between", value1, value2, "subName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdIsNull() {
            addCriterion("advertiser_id is null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdIsNotNull() {
            addCriterion("advertiser_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdEqualTo(Short value) {
            addCriterion("advertiser_id =", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdNotEqualTo(Short value) {
            addCriterion("advertiser_id <>", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdGreaterThan(Short value) {
            addCriterion("advertiser_id >", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdGreaterThanOrEqualTo(Short value) {
            addCriterion("advertiser_id >=", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdLessThan(Short value) {
            addCriterion("advertiser_id <", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdLessThanOrEqualTo(Short value) {
            addCriterion("advertiser_id <=", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdIn(List<Short> values) {
            addCriterion("advertiser_id in", values, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdNotIn(List<Short> values) {
            addCriterion("advertiser_id not in", values, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdBetween(Short value1, Short value2) {
            addCriterion("advertiser_id between", value1, value2, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdNotBetween(Short value1, Short value2) {
            addCriterion("advertiser_id not between", value1, value2, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameIsNull() {
            addCriterion("advertiser_name is null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameIsNotNull() {
            addCriterion("advertiser_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameEqualTo(String value) {
            addCriterion("advertiser_name =", value, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameNotEqualTo(String value) {
            addCriterion("advertiser_name <>", value, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameGreaterThan(String value) {
            addCriterion("advertiser_name >", value, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameGreaterThanOrEqualTo(String value) {
            addCriterion("advertiser_name >=", value, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameLessThan(String value) {
            addCriterion("advertiser_name <", value, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameLessThanOrEqualTo(String value) {
            addCriterion("advertiser_name <=", value, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameLike(String value) {
            addCriterion("advertiser_name like", value, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameNotLike(String value) {
            addCriterion("advertiser_name not like", value, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameIn(List<String> values) {
            addCriterion("advertiser_name in", values, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameNotIn(List<String> values) {
            addCriterion("advertiser_name not in", values, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameBetween(String value1, String value2) {
            addCriterion("advertiser_name between", value1, value2, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameNotBetween(String value1, String value2) {
            addCriterion("advertiser_name not between", value1, value2, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAffiliateIdIsNull() {
            addCriterion("affiliate_id is null");
            return (Criteria) this;
        }

        public Criteria andAffiliateIdIsNotNull() {
            addCriterion("affiliate_id is not null");
            return (Criteria) this;
        }

        public Criteria andAffiliateIdEqualTo(Short value) {
            addCriterion("affiliate_id =", value, "affiliateId");
            return (Criteria) this;
        }

        public Criteria andAffiliateIdNotEqualTo(Short value) {
            addCriterion("affiliate_id <>", value, "affiliateId");
            return (Criteria) this;
        }

        public Criteria andAffiliateIdGreaterThan(Short value) {
            addCriterion("affiliate_id >", value, "affiliateId");
            return (Criteria) this;
        }

        public Criteria andAffiliateIdGreaterThanOrEqualTo(Short value) {
            addCriterion("affiliate_id >=", value, "affiliateId");
            return (Criteria) this;
        }

        public Criteria andAffiliateIdLessThan(Short value) {
            addCriterion("affiliate_id <", value, "affiliateId");
            return (Criteria) this;
        }

        public Criteria andAffiliateIdLessThanOrEqualTo(Short value) {
            addCriterion("affiliate_id <=", value, "affiliateId");
            return (Criteria) this;
        }

        public Criteria andAffiliateIdIn(List<Short> values) {
            addCriterion("affiliate_id in", values, "affiliateId");
            return (Criteria) this;
        }

        public Criteria andAffiliateIdNotIn(List<Short> values) {
            addCriterion("affiliate_id not in", values, "affiliateId");
            return (Criteria) this;
        }

        public Criteria andAffiliateIdBetween(Short value1, Short value2) {
            addCriterion("affiliate_id between", value1, value2, "affiliateId");
            return (Criteria) this;
        }

        public Criteria andAffiliateIdNotBetween(Short value1, Short value2) {
            addCriterion("affiliate_id not between", value1, value2, "affiliateId");
            return (Criteria) this;
        }

        public Criteria andAffiliateNameIsNull() {
            addCriterion("affiliate_name is null");
            return (Criteria) this;
        }

        public Criteria andAffiliateNameIsNotNull() {
            addCriterion("affiliate_name is not null");
            return (Criteria) this;
        }

        public Criteria andAffiliateNameEqualTo(String value) {
            addCriterion("affiliate_name =", value, "affiliateName");
            return (Criteria) this;
        }

        public Criteria andAffiliateNameNotEqualTo(String value) {
            addCriterion("affiliate_name <>", value, "affiliateName");
            return (Criteria) this;
        }

        public Criteria andAffiliateNameGreaterThan(String value) {
            addCriterion("affiliate_name >", value, "affiliateName");
            return (Criteria) this;
        }

        public Criteria andAffiliateNameGreaterThanOrEqualTo(String value) {
            addCriterion("affiliate_name >=", value, "affiliateName");
            return (Criteria) this;
        }

        public Criteria andAffiliateNameLessThan(String value) {
            addCriterion("affiliate_name <", value, "affiliateName");
            return (Criteria) this;
        }

        public Criteria andAffiliateNameLessThanOrEqualTo(String value) {
            addCriterion("affiliate_name <=", value, "affiliateName");
            return (Criteria) this;
        }

        public Criteria andAffiliateNameLike(String value) {
            addCriterion("affiliate_name like", value, "affiliateName");
            return (Criteria) this;
        }

        public Criteria andAffiliateNameNotLike(String value) {
            addCriterion("affiliate_name not like", value, "affiliateName");
            return (Criteria) this;
        }

        public Criteria andAffiliateNameIn(List<String> values) {
            addCriterion("affiliate_name in", values, "affiliateName");
            return (Criteria) this;
        }

        public Criteria andAffiliateNameNotIn(List<String> values) {
            addCriterion("affiliate_name not in", values, "affiliateName");
            return (Criteria) this;
        }

        public Criteria andAffiliateNameBetween(String value1, String value2) {
            addCriterion("affiliate_name between", value1, value2, "affiliateName");
            return (Criteria) this;
        }

        public Criteria andAffiliateNameNotBetween(String value1, String value2) {
            addCriterion("affiliate_name not between", value1, value2, "affiliateName");
            return (Criteria) this;
        }

        public Criteria andOfferIdIsNull() {
            addCriterion("offer_id is null");
            return (Criteria) this;
        }

        public Criteria andOfferIdIsNotNull() {
            addCriterion("offer_id is not null");
            return (Criteria) this;
        }

        public Criteria andOfferIdEqualTo(String value) {
            addCriterion("offer_id =", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdNotEqualTo(String value) {
            addCriterion("offer_id <>", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdGreaterThan(String value) {
            addCriterion("offer_id >", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdGreaterThanOrEqualTo(String value) {
            addCriterion("offer_id >=", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdLessThan(String value) {
            addCriterion("offer_id <", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdLessThanOrEqualTo(String value) {
            addCriterion("offer_id <=", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdLike(String value) {
            addCriterion("offer_id like", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdNotLike(String value) {
            addCriterion("offer_id not like", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdIn(List<String> values) {
            addCriterion("offer_id in", values, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdNotIn(List<String> values) {
            addCriterion("offer_id not in", values, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdBetween(String value1, String value2) {
            addCriterion("offer_id between", value1, value2, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdNotBetween(String value1, String value2) {
            addCriterion("offer_id not between", value1, value2, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferNameIsNull() {
            addCriterion("offer_name is null");
            return (Criteria) this;
        }

        public Criteria andOfferNameIsNotNull() {
            addCriterion("offer_name is not null");
            return (Criteria) this;
        }

        public Criteria andOfferNameEqualTo(String value) {
            addCriterion("offer_name =", value, "offerName");
            return (Criteria) this;
        }

        public Criteria andOfferNameNotEqualTo(String value) {
            addCriterion("offer_name <>", value, "offerName");
            return (Criteria) this;
        }

        public Criteria andOfferNameGreaterThan(String value) {
            addCriterion("offer_name >", value, "offerName");
            return (Criteria) this;
        }

        public Criteria andOfferNameGreaterThanOrEqualTo(String value) {
            addCriterion("offer_name >=", value, "offerName");
            return (Criteria) this;
        }

        public Criteria andOfferNameLessThan(String value) {
            addCriterion("offer_name <", value, "offerName");
            return (Criteria) this;
        }

        public Criteria andOfferNameLessThanOrEqualTo(String value) {
            addCriterion("offer_name <=", value, "offerName");
            return (Criteria) this;
        }

        public Criteria andOfferNameLike(String value) {
            addCriterion("offer_name like", value, "offerName");
            return (Criteria) this;
        }

        public Criteria andOfferNameNotLike(String value) {
            addCriterion("offer_name not like", value, "offerName");
            return (Criteria) this;
        }

        public Criteria andOfferNameIn(List<String> values) {
            addCriterion("offer_name in", values, "offerName");
            return (Criteria) this;
        }

        public Criteria andOfferNameNotIn(List<String> values) {
            addCriterion("offer_name not in", values, "offerName");
            return (Criteria) this;
        }

        public Criteria andOfferNameBetween(String value1, String value2) {
            addCriterion("offer_name between", value1, value2, "offerName");
            return (Criteria) this;
        }

        public Criteria andOfferNameNotBetween(String value1, String value2) {
            addCriterion("offer_name not between", value1, value2, "offerName");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNull() {
            addCriterion("app_name is null");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("app_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("app_name =", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("app_name <>", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("app_name >", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("app_name >=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("app_name <", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("app_name <=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("app_name like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("app_name not like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameIn(List<String> values) {
            addCriterion("app_name in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotIn(List<String> values) {
            addCriterion("app_name not in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("app_name between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("app_name not between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andWorkerIdIsNull() {
            addCriterion("worker_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkerIdIsNotNull() {
            addCriterion("worker_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerIdEqualTo(String value) {
            addCriterion("worker_id =", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdNotEqualTo(String value) {
            addCriterion("worker_id <>", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdGreaterThan(String value) {
            addCriterion("worker_id >", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdGreaterThanOrEqualTo(String value) {
            addCriterion("worker_id >=", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdLessThan(String value) {
            addCriterion("worker_id <", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdLessThanOrEqualTo(String value) {
            addCriterion("worker_id <=", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdLike(String value) {
            addCriterion("worker_id like", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdNotLike(String value) {
            addCriterion("worker_id not like", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdIn(List<String> values) {
            addCriterion("worker_id in", values, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdNotIn(List<String> values) {
            addCriterion("worker_id not in", values, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdBetween(String value1, String value2) {
            addCriterion("worker_id between", value1, value2, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdNotBetween(String value1, String value2) {
            addCriterion("worker_id not between", value1, value2, "workerId");
            return (Criteria) this;
        }

        public Criteria andSourceCampaignIsNull() {
            addCriterion("source_campaign is null");
            return (Criteria) this;
        }

        public Criteria andSourceCampaignIsNotNull() {
            addCriterion("source_campaign is not null");
            return (Criteria) this;
        }

        public Criteria andSourceCampaignEqualTo(String value) {
            addCriterion("source_campaign =", value, "sourceCampaign");
            return (Criteria) this;
        }

        public Criteria andSourceCampaignNotEqualTo(String value) {
            addCriterion("source_campaign <>", value, "sourceCampaign");
            return (Criteria) this;
        }

        public Criteria andSourceCampaignGreaterThan(String value) {
            addCriterion("source_campaign >", value, "sourceCampaign");
            return (Criteria) this;
        }

        public Criteria andSourceCampaignGreaterThanOrEqualTo(String value) {
            addCriterion("source_campaign >=", value, "sourceCampaign");
            return (Criteria) this;
        }

        public Criteria andSourceCampaignLessThan(String value) {
            addCriterion("source_campaign <", value, "sourceCampaign");
            return (Criteria) this;
        }

        public Criteria andSourceCampaignLessThanOrEqualTo(String value) {
            addCriterion("source_campaign <=", value, "sourceCampaign");
            return (Criteria) this;
        }

        public Criteria andSourceCampaignLike(String value) {
            addCriterion("source_campaign like", value, "sourceCampaign");
            return (Criteria) this;
        }

        public Criteria andSourceCampaignNotLike(String value) {
            addCriterion("source_campaign not like", value, "sourceCampaign");
            return (Criteria) this;
        }

        public Criteria andSourceCampaignIn(List<String> values) {
            addCriterion("source_campaign in", values, "sourceCampaign");
            return (Criteria) this;
        }

        public Criteria andSourceCampaignNotIn(List<String> values) {
            addCriterion("source_campaign not in", values, "sourceCampaign");
            return (Criteria) this;
        }

        public Criteria andSourceCampaignBetween(String value1, String value2) {
            addCriterion("source_campaign between", value1, value2, "sourceCampaign");
            return (Criteria) this;
        }

        public Criteria andSourceCampaignNotBetween(String value1, String value2) {
            addCriterion("source_campaign not between", value1, value2, "sourceCampaign");
            return (Criteria) this;
        }

        public Criteria andBidCountIsNull() {
            addCriterion("bid_count is null");
            return (Criteria) this;
        }

        public Criteria andBidCountIsNotNull() {
            addCriterion("bid_count is not null");
            return (Criteria) this;
        }

        public Criteria andBidCountEqualTo(Integer value) {
            addCriterion("bid_count =", value, "bidCount");
            return (Criteria) this;
        }

        public Criteria andBidCountNotEqualTo(Integer value) {
            addCriterion("bid_count <>", value, "bidCount");
            return (Criteria) this;
        }

        public Criteria andBidCountGreaterThan(Integer value) {
            addCriterion("bid_count >", value, "bidCount");
            return (Criteria) this;
        }

        public Criteria andBidCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("bid_count >=", value, "bidCount");
            return (Criteria) this;
        }

        public Criteria andBidCountLessThan(Integer value) {
            addCriterion("bid_count <", value, "bidCount");
            return (Criteria) this;
        }

        public Criteria andBidCountLessThanOrEqualTo(Integer value) {
            addCriterion("bid_count <=", value, "bidCount");
            return (Criteria) this;
        }

        public Criteria andBidCountIn(List<Integer> values) {
            addCriterion("bid_count in", values, "bidCount");
            return (Criteria) this;
        }

        public Criteria andBidCountNotIn(List<Integer> values) {
            addCriterion("bid_count not in", values, "bidCount");
            return (Criteria) this;
        }

        public Criteria andBidCountBetween(Integer value1, Integer value2) {
            addCriterion("bid_count between", value1, value2, "bidCount");
            return (Criteria) this;
        }

        public Criteria andBidCountNotBetween(Integer value1, Integer value2) {
            addCriterion("bid_count not between", value1, value2, "bidCount");
            return (Criteria) this;
        }

        public Criteria andImprCountIsNull() {
            addCriterion("impr_count is null");
            return (Criteria) this;
        }

        public Criteria andImprCountIsNotNull() {
            addCriterion("impr_count is not null");
            return (Criteria) this;
        }

        public Criteria andImprCountEqualTo(Integer value) {
            addCriterion("impr_count =", value, "imprCount");
            return (Criteria) this;
        }

        public Criteria andImprCountNotEqualTo(Integer value) {
            addCriterion("impr_count <>", value, "imprCount");
            return (Criteria) this;
        }

        public Criteria andImprCountGreaterThan(Integer value) {
            addCriterion("impr_count >", value, "imprCount");
            return (Criteria) this;
        }

        public Criteria andImprCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("impr_count >=", value, "imprCount");
            return (Criteria) this;
        }

        public Criteria andImprCountLessThan(Integer value) {
            addCriterion("impr_count <", value, "imprCount");
            return (Criteria) this;
        }

        public Criteria andImprCountLessThanOrEqualTo(Integer value) {
            addCriterion("impr_count <=", value, "imprCount");
            return (Criteria) this;
        }

        public Criteria andImprCountIn(List<Integer> values) {
            addCriterion("impr_count in", values, "imprCount");
            return (Criteria) this;
        }

        public Criteria andImprCountNotIn(List<Integer> values) {
            addCriterion("impr_count not in", values, "imprCount");
            return (Criteria) this;
        }

        public Criteria andImprCountBetween(Integer value1, Integer value2) {
            addCriterion("impr_count between", value1, value2, "imprCount");
            return (Criteria) this;
        }

        public Criteria andImprCountNotBetween(Integer value1, Integer value2) {
            addCriterion("impr_count not between", value1, value2, "imprCount");
            return (Criteria) this;
        }

        public Criteria andClickCountIsNull() {
            addCriterion("click_count is null");
            return (Criteria) this;
        }

        public Criteria andClickCountIsNotNull() {
            addCriterion("click_count is not null");
            return (Criteria) this;
        }

        public Criteria andClickCountEqualTo(Integer value) {
            addCriterion("click_count =", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotEqualTo(Integer value) {
            addCriterion("click_count <>", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountGreaterThan(Integer value) {
            addCriterion("click_count >", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("click_count >=", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountLessThan(Integer value) {
            addCriterion("click_count <", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountLessThanOrEqualTo(Integer value) {
            addCriterion("click_count <=", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountIn(List<Integer> values) {
            addCriterion("click_count in", values, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotIn(List<Integer> values) {
            addCriterion("click_count not in", values, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountBetween(Integer value1, Integer value2) {
            addCriterion("click_count between", value1, value2, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotBetween(Integer value1, Integer value2) {
            addCriterion("click_count not between", value1, value2, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickInvalidIsNull() {
            addCriterion("click_invalid is null");
            return (Criteria) this;
        }

        public Criteria andClickInvalidIsNotNull() {
            addCriterion("click_invalid is not null");
            return (Criteria) this;
        }

        public Criteria andClickInvalidEqualTo(Integer value) {
            addCriterion("click_invalid =", value, "clickInvalid");
            return (Criteria) this;
        }

        public Criteria andClickInvalidNotEqualTo(Integer value) {
            addCriterion("click_invalid <>", value, "clickInvalid");
            return (Criteria) this;
        }

        public Criteria andClickInvalidGreaterThan(Integer value) {
            addCriterion("click_invalid >", value, "clickInvalid");
            return (Criteria) this;
        }

        public Criteria andClickInvalidGreaterThanOrEqualTo(Integer value) {
            addCriterion("click_invalid >=", value, "clickInvalid");
            return (Criteria) this;
        }

        public Criteria andClickInvalidLessThan(Integer value) {
            addCriterion("click_invalid <", value, "clickInvalid");
            return (Criteria) this;
        }

        public Criteria andClickInvalidLessThanOrEqualTo(Integer value) {
            addCriterion("click_invalid <=", value, "clickInvalid");
            return (Criteria) this;
        }

        public Criteria andClickInvalidIn(List<Integer> values) {
            addCriterion("click_invalid in", values, "clickInvalid");
            return (Criteria) this;
        }

        public Criteria andClickInvalidNotIn(List<Integer> values) {
            addCriterion("click_invalid not in", values, "clickInvalid");
            return (Criteria) this;
        }

        public Criteria andClickInvalidBetween(Integer value1, Integer value2) {
            addCriterion("click_invalid between", value1, value2, "clickInvalid");
            return (Criteria) this;
        }

        public Criteria andClickInvalidNotBetween(Integer value1, Integer value2) {
            addCriterion("click_invalid not between", value1, value2, "clickInvalid");
            return (Criteria) this;
        }

        public Criteria andCpcBudgetIsNull() {
            addCriterion("cpc_budget is null");
            return (Criteria) this;
        }

        public Criteria andCpcBudgetIsNotNull() {
            addCriterion("cpc_budget is not null");
            return (Criteria) this;
        }

        public Criteria andCpcBudgetEqualTo(Integer value) {
            addCriterion("cpc_budget =", value, "cpcBudget");
            return (Criteria) this;
        }

        public Criteria andCpcBudgetNotEqualTo(Integer value) {
            addCriterion("cpc_budget <>", value, "cpcBudget");
            return (Criteria) this;
        }

        public Criteria andCpcBudgetGreaterThan(Integer value) {
            addCriterion("cpc_budget >", value, "cpcBudget");
            return (Criteria) this;
        }

        public Criteria andCpcBudgetGreaterThanOrEqualTo(Integer value) {
            addCriterion("cpc_budget >=", value, "cpcBudget");
            return (Criteria) this;
        }

        public Criteria andCpcBudgetLessThan(Integer value) {
            addCriterion("cpc_budget <", value, "cpcBudget");
            return (Criteria) this;
        }

        public Criteria andCpcBudgetLessThanOrEqualTo(Integer value) {
            addCriterion("cpc_budget <=", value, "cpcBudget");
            return (Criteria) this;
        }

        public Criteria andCpcBudgetIn(List<Integer> values) {
            addCriterion("cpc_budget in", values, "cpcBudget");
            return (Criteria) this;
        }

        public Criteria andCpcBudgetNotIn(List<Integer> values) {
            addCriterion("cpc_budget not in", values, "cpcBudget");
            return (Criteria) this;
        }

        public Criteria andCpcBudgetBetween(Integer value1, Integer value2) {
            addCriterion("cpc_budget between", value1, value2, "cpcBudget");
            return (Criteria) this;
        }

        public Criteria andCpcBudgetNotBetween(Integer value1, Integer value2) {
            addCriterion("cpc_budget not between", value1, value2, "cpcBudget");
            return (Criteria) this;
        }

        public Criteria andConverionCountIsNull() {
            addCriterion("converion_count is null");
            return (Criteria) this;
        }

        public Criteria andConverionCountIsNotNull() {
            addCriterion("converion_count is not null");
            return (Criteria) this;
        }

        public Criteria andConverionCountEqualTo(Integer value) {
            addCriterion("converion_count =", value, "converionCount");
            return (Criteria) this;
        }

        public Criteria andConverionCountNotEqualTo(Integer value) {
            addCriterion("converion_count <>", value, "converionCount");
            return (Criteria) this;
        }

        public Criteria andConverionCountGreaterThan(Integer value) {
            addCriterion("converion_count >", value, "converionCount");
            return (Criteria) this;
        }

        public Criteria andConverionCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("converion_count >=", value, "converionCount");
            return (Criteria) this;
        }

        public Criteria andConverionCountLessThan(Integer value) {
            addCriterion("converion_count <", value, "converionCount");
            return (Criteria) this;
        }

        public Criteria andConverionCountLessThanOrEqualTo(Integer value) {
            addCriterion("converion_count <=", value, "converionCount");
            return (Criteria) this;
        }

        public Criteria andConverionCountIn(List<Integer> values) {
            addCriterion("converion_count in", values, "converionCount");
            return (Criteria) this;
        }

        public Criteria andConverionCountNotIn(List<Integer> values) {
            addCriterion("converion_count not in", values, "converionCount");
            return (Criteria) this;
        }

        public Criteria andConverionCountBetween(Integer value1, Integer value2) {
            addCriterion("converion_count between", value1, value2, "converionCount");
            return (Criteria) this;
        }

        public Criteria andConverionCountNotBetween(Integer value1, Integer value2) {
            addCriterion("converion_count not between", value1, value2, "converionCount");
            return (Criteria) this;
        }

        public Criteria andConverionPayoutIsNull() {
            addCriterion("converion_payout is null");
            return (Criteria) this;
        }

        public Criteria andConverionPayoutIsNotNull() {
            addCriterion("converion_payout is not null");
            return (Criteria) this;
        }

        public Criteria andConverionPayoutEqualTo(BigDecimal value) {
            addCriterion("converion_payout =", value, "converionPayout");
            return (Criteria) this;
        }

        public Criteria andConverionPayoutNotEqualTo(BigDecimal value) {
            addCriterion("converion_payout <>", value, "converionPayout");
            return (Criteria) this;
        }

        public Criteria andConverionPayoutGreaterThan(BigDecimal value) {
            addCriterion("converion_payout >", value, "converionPayout");
            return (Criteria) this;
        }

        public Criteria andConverionPayoutGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("converion_payout >=", value, "converionPayout");
            return (Criteria) this;
        }

        public Criteria andConverionPayoutLessThan(BigDecimal value) {
            addCriterion("converion_payout <", value, "converionPayout");
            return (Criteria) this;
        }

        public Criteria andConverionPayoutLessThanOrEqualTo(BigDecimal value) {
            addCriterion("converion_payout <=", value, "converionPayout");
            return (Criteria) this;
        }

        public Criteria andConverionPayoutIn(List<BigDecimal> values) {
            addCriterion("converion_payout in", values, "converionPayout");
            return (Criteria) this;
        }

        public Criteria andConverionPayoutNotIn(List<BigDecimal> values) {
            addCriterion("converion_payout not in", values, "converionPayout");
            return (Criteria) this;
        }

        public Criteria andConverionPayoutBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("converion_payout between", value1, value2, "converionPayout");
            return (Criteria) this;
        }

        public Criteria andConverionPayoutNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("converion_payout not between", value1, value2, "converionPayout");
            return (Criteria) this;
        }

        public Criteria andConfirmCountIsNull() {
            addCriterion("confirm_count is null");
            return (Criteria) this;
        }

        public Criteria andConfirmCountIsNotNull() {
            addCriterion("confirm_count is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmCountEqualTo(Integer value) {
            addCriterion("confirm_count =", value, "confirmCount");
            return (Criteria) this;
        }

        public Criteria andConfirmCountNotEqualTo(Integer value) {
            addCriterion("confirm_count <>", value, "confirmCount");
            return (Criteria) this;
        }

        public Criteria andConfirmCountGreaterThan(Integer value) {
            addCriterion("confirm_count >", value, "confirmCount");
            return (Criteria) this;
        }

        public Criteria andConfirmCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("confirm_count >=", value, "confirmCount");
            return (Criteria) this;
        }

        public Criteria andConfirmCountLessThan(Integer value) {
            addCriterion("confirm_count <", value, "confirmCount");
            return (Criteria) this;
        }

        public Criteria andConfirmCountLessThanOrEqualTo(Integer value) {
            addCriterion("confirm_count <=", value, "confirmCount");
            return (Criteria) this;
        }

        public Criteria andConfirmCountIn(List<Integer> values) {
            addCriterion("confirm_count in", values, "confirmCount");
            return (Criteria) this;
        }

        public Criteria andConfirmCountNotIn(List<Integer> values) {
            addCriterion("confirm_count not in", values, "confirmCount");
            return (Criteria) this;
        }

        public Criteria andConfirmCountBetween(Integer value1, Integer value2) {
            addCriterion("confirm_count between", value1, value2, "confirmCount");
            return (Criteria) this;
        }

        public Criteria andConfirmCountNotBetween(Integer value1, Integer value2) {
            addCriterion("confirm_count not between", value1, value2, "confirmCount");
            return (Criteria) this;
        }

        public Criteria andConfirmPayoutIsNull() {
            addCriterion("confirm_payout is null");
            return (Criteria) this;
        }

        public Criteria andConfirmPayoutIsNotNull() {
            addCriterion("confirm_payout is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmPayoutEqualTo(BigDecimal value) {
            addCriterion("confirm_payout =", value, "confirmPayout");
            return (Criteria) this;
        }

        public Criteria andConfirmPayoutNotEqualTo(BigDecimal value) {
            addCriterion("confirm_payout <>", value, "confirmPayout");
            return (Criteria) this;
        }

        public Criteria andConfirmPayoutGreaterThan(BigDecimal value) {
            addCriterion("confirm_payout >", value, "confirmPayout");
            return (Criteria) this;
        }

        public Criteria andConfirmPayoutGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("confirm_payout >=", value, "confirmPayout");
            return (Criteria) this;
        }

        public Criteria andConfirmPayoutLessThan(BigDecimal value) {
            addCriterion("confirm_payout <", value, "confirmPayout");
            return (Criteria) this;
        }

        public Criteria andConfirmPayoutLessThanOrEqualTo(BigDecimal value) {
            addCriterion("confirm_payout <=", value, "confirmPayout");
            return (Criteria) this;
        }

        public Criteria andConfirmPayoutIn(List<BigDecimal> values) {
            addCriterion("confirm_payout in", values, "confirmPayout");
            return (Criteria) this;
        }

        public Criteria andConfirmPayoutNotIn(List<BigDecimal> values) {
            addCriterion("confirm_payout not in", values, "confirmPayout");
            return (Criteria) this;
        }

        public Criteria andConfirmPayoutBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("confirm_payout between", value1, value2, "confirmPayout");
            return (Criteria) this;
        }

        public Criteria andConfirmPayoutNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("confirm_payout not between", value1, value2, "confirmPayout");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("currency is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("currency is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("currency =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("currency <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("currency >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("currency >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("currency <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("currency <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("currency like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("currency not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("currency in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("currency not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("currency between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("currency not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNull() {
            addCriterion("update_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNotNull() {
            addCriterion("update_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdEqualTo(Integer value) {
            addCriterion("update_id =", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotEqualTo(Integer value) {
            addCriterion("update_id <>", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThan(Integer value) {
            addCriterion("update_id >", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_id >=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThan(Integer value) {
            addCriterion("update_id <", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThanOrEqualTo(Integer value) {
            addCriterion("update_id <=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIn(List<Integer> values) {
            addCriterion("update_id in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotIn(List<Integer> values) {
            addCriterion("update_id not in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdBetween(Integer value1, Integer value2) {
            addCriterion("update_id between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("update_id not between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdIsNull() {
            addCriterion("source_affiliate_id is null");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdIsNotNull() {
            addCriterion("source_affiliate_id is not null");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdEqualTo(Short value) {
            addCriterion("source_affiliate_id =", value, "sourceAffiliateId");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdNotEqualTo(Short value) {
            addCriterion("source_affiliate_id <>", value, "sourceAffiliateId");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdGreaterThan(Short value) {
            addCriterion("source_affiliate_id >", value, "sourceAffiliateId");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdGreaterThanOrEqualTo(Short value) {
            addCriterion("source_affiliate_id >=", value, "sourceAffiliateId");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdLessThan(Short value) {
            addCriterion("source_affiliate_id <", value, "sourceAffiliateId");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdLessThanOrEqualTo(Short value) {
            addCriterion("source_affiliate_id <=", value, "sourceAffiliateId");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdIn(List<Short> values) {
            addCriterion("source_affiliate_id in", values, "sourceAffiliateId");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdNotIn(List<Short> values) {
            addCriterion("source_affiliate_id not in", values, "sourceAffiliateId");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdBetween(Short value1, Short value2) {
            addCriterion("source_affiliate_id between", value1, value2, "sourceAffiliateId");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdNotBetween(Short value1, Short value2) {
            addCriterion("source_affiliate_id not between", value1, value2, "sourceAffiliateId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}