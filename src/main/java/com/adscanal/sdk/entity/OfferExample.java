package com.adscanal.sdk.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OfferExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OfferExample() {
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

        public Criteria andOfferidIsNull() {
            addCriterion("offerId is null");
            return (Criteria) this;
        }

        public Criteria andOfferidIsNotNull() {
            addCriterion("offerId is not null");
            return (Criteria) this;
        }

        public Criteria andOfferidEqualTo(String value) {
            addCriterion("offerId =", value, "offerid");
            return (Criteria) this;
        }

        public Criteria andOfferidNotEqualTo(String value) {
            addCriterion("offerId <>", value, "offerid");
            return (Criteria) this;
        }

        public Criteria andOfferidGreaterThan(String value) {
            addCriterion("offerId >", value, "offerid");
            return (Criteria) this;
        }

        public Criteria andOfferidGreaterThanOrEqualTo(String value) {
            addCriterion("offerId >=", value, "offerid");
            return (Criteria) this;
        }

        public Criteria andOfferidLessThan(String value) {
            addCriterion("offerId <", value, "offerid");
            return (Criteria) this;
        }

        public Criteria andOfferidLessThanOrEqualTo(String value) {
            addCriterion("offerId <=", value, "offerid");
            return (Criteria) this;
        }

        public Criteria andOfferidLike(String value) {
            addCriterion("offerId like", value, "offerid");
            return (Criteria) this;
        }

        public Criteria andOfferidNotLike(String value) {
            addCriterion("offerId not like", value, "offerid");
            return (Criteria) this;
        }

        public Criteria andOfferidIn(List<String> values) {
            addCriterion("offerId in", values, "offerid");
            return (Criteria) this;
        }

        public Criteria andOfferidNotIn(List<String> values) {
            addCriterion("offerId not in", values, "offerid");
            return (Criteria) this;
        }

        public Criteria andOfferidBetween(String value1, String value2) {
            addCriterion("offerId between", value1, value2, "offerid");
            return (Criteria) this;
        }

        public Criteria andOfferidNotBetween(String value1, String value2) {
            addCriterion("offerId not between", value1, value2, "offerid");
            return (Criteria) this;
        }

        public Criteria andAffiliateidIsNull() {
            addCriterion("affiliateId is null");
            return (Criteria) this;
        }

        public Criteria andAffiliateidIsNotNull() {
            addCriterion("affiliateId is not null");
            return (Criteria) this;
        }

        public Criteria andAffiliateidEqualTo(Short value) {
            addCriterion("affiliateId =", value, "affiliateid");
            return (Criteria) this;
        }

        public Criteria andAffiliateidNotEqualTo(Short value) {
            addCriterion("affiliateId <>", value, "affiliateid");
            return (Criteria) this;
        }

        public Criteria andAffiliateidGreaterThan(Short value) {
            addCriterion("affiliateId >", value, "affiliateid");
            return (Criteria) this;
        }

        public Criteria andAffiliateidGreaterThanOrEqualTo(Short value) {
            addCriterion("affiliateId >=", value, "affiliateid");
            return (Criteria) this;
        }

        public Criteria andAffiliateidLessThan(Short value) {
            addCriterion("affiliateId <", value, "affiliateid");
            return (Criteria) this;
        }

        public Criteria andAffiliateidLessThanOrEqualTo(Short value) {
            addCriterion("affiliateId <=", value, "affiliateid");
            return (Criteria) this;
        }

        public Criteria andAffiliateidIn(List<Short> values) {
            addCriterion("affiliateId in", values, "affiliateid");
            return (Criteria) this;
        }

        public Criteria andAffiliateidNotIn(List<Short> values) {
            addCriterion("affiliateId not in", values, "affiliateid");
            return (Criteria) this;
        }

        public Criteria andAffiliateidBetween(Short value1, Short value2) {
            addCriterion("affiliateId between", value1, value2, "affiliateid");
            return (Criteria) this;
        }

        public Criteria andAffiliateidNotBetween(Short value1, Short value2) {
            addCriterion("affiliateId not between", value1, value2, "affiliateid");
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

        public Criteria andOffernameIsNull() {
            addCriterion("offerName is null");
            return (Criteria) this;
        }

        public Criteria andOffernameIsNotNull() {
            addCriterion("offerName is not null");
            return (Criteria) this;
        }

        public Criteria andOffernameEqualTo(String value) {
            addCriterion("offerName =", value, "offername");
            return (Criteria) this;
        }

        public Criteria andOffernameNotEqualTo(String value) {
            addCriterion("offerName <>", value, "offername");
            return (Criteria) this;
        }

        public Criteria andOffernameGreaterThan(String value) {
            addCriterion("offerName >", value, "offername");
            return (Criteria) this;
        }

        public Criteria andOffernameGreaterThanOrEqualTo(String value) {
            addCriterion("offerName >=", value, "offername");
            return (Criteria) this;
        }

        public Criteria andOffernameLessThan(String value) {
            addCriterion("offerName <", value, "offername");
            return (Criteria) this;
        }

        public Criteria andOffernameLessThanOrEqualTo(String value) {
            addCriterion("offerName <=", value, "offername");
            return (Criteria) this;
        }

        public Criteria andOffernameLike(String value) {
            addCriterion("offerName like", value, "offername");
            return (Criteria) this;
        }

        public Criteria andOffernameNotLike(String value) {
            addCriterion("offerName not like", value, "offername");
            return (Criteria) this;
        }

        public Criteria andOffernameIn(List<String> values) {
            addCriterion("offerName in", values, "offername");
            return (Criteria) this;
        }

        public Criteria andOffernameNotIn(List<String> values) {
            addCriterion("offerName not in", values, "offername");
            return (Criteria) this;
        }

        public Criteria andOffernameBetween(String value1, String value2) {
            addCriterion("offerName between", value1, value2, "offername");
            return (Criteria) this;
        }

        public Criteria andOffernameNotBetween(String value1, String value2) {
            addCriterion("offerName not between", value1, value2, "offername");
            return (Criteria) this;
        }

        public Criteria andAffiliatenameIsNull() {
            addCriterion("affiliateName is null");
            return (Criteria) this;
        }

        public Criteria andAffiliatenameIsNotNull() {
            addCriterion("affiliateName is not null");
            return (Criteria) this;
        }

        public Criteria andAffiliatenameEqualTo(String value) {
            addCriterion("affiliateName =", value, "affiliatename");
            return (Criteria) this;
        }

        public Criteria andAffiliatenameNotEqualTo(String value) {
            addCriterion("affiliateName <>", value, "affiliatename");
            return (Criteria) this;
        }

        public Criteria andAffiliatenameGreaterThan(String value) {
            addCriterion("affiliateName >", value, "affiliatename");
            return (Criteria) this;
        }

        public Criteria andAffiliatenameGreaterThanOrEqualTo(String value) {
            addCriterion("affiliateName >=", value, "affiliatename");
            return (Criteria) this;
        }

        public Criteria andAffiliatenameLessThan(String value) {
            addCriterion("affiliateName <", value, "affiliatename");
            return (Criteria) this;
        }

        public Criteria andAffiliatenameLessThanOrEqualTo(String value) {
            addCriterion("affiliateName <=", value, "affiliatename");
            return (Criteria) this;
        }

        public Criteria andAffiliatenameLike(String value) {
            addCriterion("affiliateName like", value, "affiliatename");
            return (Criteria) this;
        }

        public Criteria andAffiliatenameNotLike(String value) {
            addCriterion("affiliateName not like", value, "affiliatename");
            return (Criteria) this;
        }

        public Criteria andAffiliatenameIn(List<String> values) {
            addCriterion("affiliateName in", values, "affiliatename");
            return (Criteria) this;
        }

        public Criteria andAffiliatenameNotIn(List<String> values) {
            addCriterion("affiliateName not in", values, "affiliatename");
            return (Criteria) this;
        }

        public Criteria andAffiliatenameBetween(String value1, String value2) {
            addCriterion("affiliateName between", value1, value2, "affiliatename");
            return (Criteria) this;
        }

        public Criteria andAffiliatenameNotBetween(String value1, String value2) {
            addCriterion("affiliateName not between", value1, value2, "affiliatename");
            return (Criteria) this;
        }

        public Criteria andTrackurlIsNull() {
            addCriterion("trackUrl is null");
            return (Criteria) this;
        }

        public Criteria andTrackurlIsNotNull() {
            addCriterion("trackUrl is not null");
            return (Criteria) this;
        }

        public Criteria andTrackurlEqualTo(String value) {
            addCriterion("trackUrl =", value, "trackurl");
            return (Criteria) this;
        }

        public Criteria andTrackurlNotEqualTo(String value) {
            addCriterion("trackUrl <>", value, "trackurl");
            return (Criteria) this;
        }

        public Criteria andTrackurlGreaterThan(String value) {
            addCriterion("trackUrl >", value, "trackurl");
            return (Criteria) this;
        }

        public Criteria andTrackurlGreaterThanOrEqualTo(String value) {
            addCriterion("trackUrl >=", value, "trackurl");
            return (Criteria) this;
        }

        public Criteria andTrackurlLessThan(String value) {
            addCriterion("trackUrl <", value, "trackurl");
            return (Criteria) this;
        }

        public Criteria andTrackurlLessThanOrEqualTo(String value) {
            addCriterion("trackUrl <=", value, "trackurl");
            return (Criteria) this;
        }

        public Criteria andTrackurlLike(String value) {
            addCriterion("trackUrl like", value, "trackurl");
            return (Criteria) this;
        }

        public Criteria andTrackurlNotLike(String value) {
            addCriterion("trackUrl not like", value, "trackurl");
            return (Criteria) this;
        }

        public Criteria andTrackurlIn(List<String> values) {
            addCriterion("trackUrl in", values, "trackurl");
            return (Criteria) this;
        }

        public Criteria andTrackurlNotIn(List<String> values) {
            addCriterion("trackUrl not in", values, "trackurl");
            return (Criteria) this;
        }

        public Criteria andTrackurlBetween(String value1, String value2) {
            addCriterion("trackUrl between", value1, value2, "trackurl");
            return (Criteria) this;
        }

        public Criteria andTrackurlNotBetween(String value1, String value2) {
            addCriterion("trackUrl not between", value1, value2, "trackurl");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andPayouttypeIsNull() {
            addCriterion("payoutType is null");
            return (Criteria) this;
        }

        public Criteria andPayouttypeIsNotNull() {
            addCriterion("payoutType is not null");
            return (Criteria) this;
        }

        public Criteria andPayouttypeEqualTo(String value) {
            addCriterion("payoutType =", value, "payouttype");
            return (Criteria) this;
        }

        public Criteria andPayouttypeNotEqualTo(String value) {
            addCriterion("payoutType <>", value, "payouttype");
            return (Criteria) this;
        }

        public Criteria andPayouttypeGreaterThan(String value) {
            addCriterion("payoutType >", value, "payouttype");
            return (Criteria) this;
        }

        public Criteria andPayouttypeGreaterThanOrEqualTo(String value) {
            addCriterion("payoutType >=", value, "payouttype");
            return (Criteria) this;
        }

        public Criteria andPayouttypeLessThan(String value) {
            addCriterion("payoutType <", value, "payouttype");
            return (Criteria) this;
        }

        public Criteria andPayouttypeLessThanOrEqualTo(String value) {
            addCriterion("payoutType <=", value, "payouttype");
            return (Criteria) this;
        }

        public Criteria andPayouttypeLike(String value) {
            addCriterion("payoutType like", value, "payouttype");
            return (Criteria) this;
        }

        public Criteria andPayouttypeNotLike(String value) {
            addCriterion("payoutType not like", value, "payouttype");
            return (Criteria) this;
        }

        public Criteria andPayouttypeIn(List<String> values) {
            addCriterion("payoutType in", values, "payouttype");
            return (Criteria) this;
        }

        public Criteria andPayouttypeNotIn(List<String> values) {
            addCriterion("payoutType not in", values, "payouttype");
            return (Criteria) this;
        }

        public Criteria andPayouttypeBetween(String value1, String value2) {
            addCriterion("payoutType between", value1, value2, "payouttype");
            return (Criteria) this;
        }

        public Criteria andPayouttypeNotBetween(String value1, String value2) {
            addCriterion("payoutType not between", value1, value2, "payouttype");
            return (Criteria) this;
        }

        public Criteria andConversioncapIsNull() {
            addCriterion("conversionCap is null");
            return (Criteria) this;
        }

        public Criteria andConversioncapIsNotNull() {
            addCriterion("conversionCap is not null");
            return (Criteria) this;
        }

        public Criteria andConversioncapEqualTo(Integer value) {
            addCriterion("conversionCap =", value, "conversioncap");
            return (Criteria) this;
        }

        public Criteria andConversioncapNotEqualTo(Integer value) {
            addCriterion("conversionCap <>", value, "conversioncap");
            return (Criteria) this;
        }

        public Criteria andConversioncapGreaterThan(Integer value) {
            addCriterion("conversionCap >", value, "conversioncap");
            return (Criteria) this;
        }

        public Criteria andConversioncapGreaterThanOrEqualTo(Integer value) {
            addCriterion("conversionCap >=", value, "conversioncap");
            return (Criteria) this;
        }

        public Criteria andConversioncapLessThan(Integer value) {
            addCriterion("conversionCap <", value, "conversioncap");
            return (Criteria) this;
        }

        public Criteria andConversioncapLessThanOrEqualTo(Integer value) {
            addCriterion("conversionCap <=", value, "conversioncap");
            return (Criteria) this;
        }

        public Criteria andConversioncapIn(List<Integer> values) {
            addCriterion("conversionCap in", values, "conversioncap");
            return (Criteria) this;
        }

        public Criteria andConversioncapNotIn(List<Integer> values) {
            addCriterion("conversionCap not in", values, "conversioncap");
            return (Criteria) this;
        }

        public Criteria andConversioncapBetween(Integer value1, Integer value2) {
            addCriterion("conversionCap between", value1, value2, "conversioncap");
            return (Criteria) this;
        }

        public Criteria andConversioncapNotBetween(Integer value1, Integer value2) {
            addCriterion("conversionCap not between", value1, value2, "conversioncap");
            return (Criteria) this;
        }

        public Criteria andPreviewurlIsNull() {
            addCriterion("previewUrl is null");
            return (Criteria) this;
        }

        public Criteria andPreviewurlIsNotNull() {
            addCriterion("previewUrl is not null");
            return (Criteria) this;
        }

        public Criteria andPreviewurlEqualTo(String value) {
            addCriterion("previewUrl =", value, "previewurl");
            return (Criteria) this;
        }

        public Criteria andPreviewurlNotEqualTo(String value) {
            addCriterion("previewUrl <>", value, "previewurl");
            return (Criteria) this;
        }

        public Criteria andPreviewurlGreaterThan(String value) {
            addCriterion("previewUrl >", value, "previewurl");
            return (Criteria) this;
        }

        public Criteria andPreviewurlGreaterThanOrEqualTo(String value) {
            addCriterion("previewUrl >=", value, "previewurl");
            return (Criteria) this;
        }

        public Criteria andPreviewurlLessThan(String value) {
            addCriterion("previewUrl <", value, "previewurl");
            return (Criteria) this;
        }

        public Criteria andPreviewurlLessThanOrEqualTo(String value) {
            addCriterion("previewUrl <=", value, "previewurl");
            return (Criteria) this;
        }

        public Criteria andPreviewurlLike(String value) {
            addCriterion("previewUrl like", value, "previewurl");
            return (Criteria) this;
        }

        public Criteria andPreviewurlNotLike(String value) {
            addCriterion("previewUrl not like", value, "previewurl");
            return (Criteria) this;
        }

        public Criteria andPreviewurlIn(List<String> values) {
            addCriterion("previewUrl in", values, "previewurl");
            return (Criteria) this;
        }

        public Criteria andPreviewurlNotIn(List<String> values) {
            addCriterion("previewUrl not in", values, "previewurl");
            return (Criteria) this;
        }

        public Criteria andPreviewurlBetween(String value1, String value2) {
            addCriterion("previewUrl between", value1, value2, "previewurl");
            return (Criteria) this;
        }

        public Criteria andPreviewurlNotBetween(String value1, String value2) {
            addCriterion("previewUrl not between", value1, value2, "previewurl");
            return (Criteria) this;
        }

        public Criteria andDefaultpayoutIsNull() {
            addCriterion("defaultPayout is null");
            return (Criteria) this;
        }

        public Criteria andDefaultpayoutIsNotNull() {
            addCriterion("defaultPayout is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultpayoutEqualTo(Float value) {
            addCriterion("defaultPayout =", value, "defaultpayout");
            return (Criteria) this;
        }

        public Criteria andDefaultpayoutNotEqualTo(Float value) {
            addCriterion("defaultPayout <>", value, "defaultpayout");
            return (Criteria) this;
        }

        public Criteria andDefaultpayoutGreaterThan(Float value) {
            addCriterion("defaultPayout >", value, "defaultpayout");
            return (Criteria) this;
        }

        public Criteria andDefaultpayoutGreaterThanOrEqualTo(Float value) {
            addCriterion("defaultPayout >=", value, "defaultpayout");
            return (Criteria) this;
        }

        public Criteria andDefaultpayoutLessThan(Float value) {
            addCriterion("defaultPayout <", value, "defaultpayout");
            return (Criteria) this;
        }

        public Criteria andDefaultpayoutLessThanOrEqualTo(Float value) {
            addCriterion("defaultPayout <=", value, "defaultpayout");
            return (Criteria) this;
        }

        public Criteria andDefaultpayoutIn(List<Float> values) {
            addCriterion("defaultPayout in", values, "defaultpayout");
            return (Criteria) this;
        }

        public Criteria andDefaultpayoutNotIn(List<Float> values) {
            addCriterion("defaultPayout not in", values, "defaultpayout");
            return (Criteria) this;
        }

        public Criteria andDefaultpayoutBetween(Float value1, Float value2) {
            addCriterion("defaultPayout between", value1, value2, "defaultpayout");
            return (Criteria) this;
        }

        public Criteria andDefaultpayoutNotBetween(Float value1, Float value2) {
            addCriterion("defaultPayout not between", value1, value2, "defaultpayout");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andApprvoalstatusIsNull() {
            addCriterion("apprvoalStatus is null");
            return (Criteria) this;
        }

        public Criteria andApprvoalstatusIsNotNull() {
            addCriterion("apprvoalStatus is not null");
            return (Criteria) this;
        }

        public Criteria andApprvoalstatusEqualTo(String value) {
            addCriterion("apprvoalStatus =", value, "apprvoalstatus");
            return (Criteria) this;
        }

        public Criteria andApprvoalstatusNotEqualTo(String value) {
            addCriterion("apprvoalStatus <>", value, "apprvoalstatus");
            return (Criteria) this;
        }

        public Criteria andApprvoalstatusGreaterThan(String value) {
            addCriterion("apprvoalStatus >", value, "apprvoalstatus");
            return (Criteria) this;
        }

        public Criteria andApprvoalstatusGreaterThanOrEqualTo(String value) {
            addCriterion("apprvoalStatus >=", value, "apprvoalstatus");
            return (Criteria) this;
        }

        public Criteria andApprvoalstatusLessThan(String value) {
            addCriterion("apprvoalStatus <", value, "apprvoalstatus");
            return (Criteria) this;
        }

        public Criteria andApprvoalstatusLessThanOrEqualTo(String value) {
            addCriterion("apprvoalStatus <=", value, "apprvoalstatus");
            return (Criteria) this;
        }

        public Criteria andApprvoalstatusLike(String value) {
            addCriterion("apprvoalStatus like", value, "apprvoalstatus");
            return (Criteria) this;
        }

        public Criteria andApprvoalstatusNotLike(String value) {
            addCriterion("apprvoalStatus not like", value, "apprvoalstatus");
            return (Criteria) this;
        }

        public Criteria andApprvoalstatusIn(List<String> values) {
            addCriterion("apprvoalStatus in", values, "apprvoalstatus");
            return (Criteria) this;
        }

        public Criteria andApprvoalstatusNotIn(List<String> values) {
            addCriterion("apprvoalStatus not in", values, "apprvoalstatus");
            return (Criteria) this;
        }

        public Criteria andApprvoalstatusBetween(String value1, String value2) {
            addCriterion("apprvoalStatus between", value1, value2, "apprvoalstatus");
            return (Criteria) this;
        }

        public Criteria andApprvoalstatusNotBetween(String value1, String value2) {
            addCriterion("apprvoalStatus not between", value1, value2, "apprvoalstatus");
            return (Criteria) this;
        }

        public Criteria andExpirationdateIsNull() {
            addCriterion("expirationDate is null");
            return (Criteria) this;
        }

        public Criteria andExpirationdateIsNotNull() {
            addCriterion("expirationDate is not null");
            return (Criteria) this;
        }

        public Criteria andExpirationdateEqualTo(String value) {
            addCriterion("expirationDate =", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateNotEqualTo(String value) {
            addCriterion("expirationDate <>", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateGreaterThan(String value) {
            addCriterion("expirationDate >", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateGreaterThanOrEqualTo(String value) {
            addCriterion("expirationDate >=", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateLessThan(String value) {
            addCriterion("expirationDate <", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateLessThanOrEqualTo(String value) {
            addCriterion("expirationDate <=", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateLike(String value) {
            addCriterion("expirationDate like", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateNotLike(String value) {
            addCriterion("expirationDate not like", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateIn(List<String> values) {
            addCriterion("expirationDate in", values, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateNotIn(List<String> values) {
            addCriterion("expirationDate not in", values, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateBetween(String value1, String value2) {
            addCriterion("expirationDate between", value1, value2, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateNotBetween(String value1, String value2) {
            addCriterion("expirationDate not between", value1, value2, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andSystimeIsNull() {
            addCriterion("sysTime is null");
            return (Criteria) this;
        }

        public Criteria andSystimeIsNotNull() {
            addCriterion("sysTime is not null");
            return (Criteria) this;
        }

        public Criteria andSystimeEqualTo(Date value) {
            addCriterion("sysTime =", value, "systime");
            return (Criteria) this;
        }

        public Criteria andSystimeNotEqualTo(Date value) {
            addCriterion("sysTime <>", value, "systime");
            return (Criteria) this;
        }

        public Criteria andSystimeGreaterThan(Date value) {
            addCriterion("sysTime >", value, "systime");
            return (Criteria) this;
        }

        public Criteria andSystimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sysTime >=", value, "systime");
            return (Criteria) this;
        }

        public Criteria andSystimeLessThan(Date value) {
            addCriterion("sysTime <", value, "systime");
            return (Criteria) this;
        }

        public Criteria andSystimeLessThanOrEqualTo(Date value) {
            addCriterion("sysTime <=", value, "systime");
            return (Criteria) this;
        }

        public Criteria andSystimeIn(List<Date> values) {
            addCriterion("sysTime in", values, "systime");
            return (Criteria) this;
        }

        public Criteria andSystimeNotIn(List<Date> values) {
            addCriterion("sysTime not in", values, "systime");
            return (Criteria) this;
        }

        public Criteria andSystimeBetween(Date value1, Date value2) {
            addCriterion("sysTime between", value1, value2, "systime");
            return (Criteria) this;
        }

        public Criteria andSystimeNotBetween(Date value1, Date value2) {
            addCriterion("sysTime not between", value1, value2, "systime");
            return (Criteria) this;
        }

        public Criteria andAppidIsNull() {
            addCriterion("appId is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("appId is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(String value) {
            addCriterion("appId =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(String value) {
            addCriterion("appId <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(String value) {
            addCriterion("appId >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(String value) {
            addCriterion("appId >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(String value) {
            addCriterion("appId <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(String value) {
            addCriterion("appId <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLike(String value) {
            addCriterion("appId like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotLike(String value) {
            addCriterion("appId not like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<String> values) {
            addCriterion("appId in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<String> values) {
            addCriterion("appId not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(String value1, String value2) {
            addCriterion("appId between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(String value1, String value2) {
            addCriterion("appId not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppnameIsNull() {
            addCriterion("appName is null");
            return (Criteria) this;
        }

        public Criteria andAppnameIsNotNull() {
            addCriterion("appName is not null");
            return (Criteria) this;
        }

        public Criteria andAppnameEqualTo(String value) {
            addCriterion("appName =", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameNotEqualTo(String value) {
            addCriterion("appName <>", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameGreaterThan(String value) {
            addCriterion("appName >", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameGreaterThanOrEqualTo(String value) {
            addCriterion("appName >=", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameLessThan(String value) {
            addCriterion("appName <", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameLessThanOrEqualTo(String value) {
            addCriterion("appName <=", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameLike(String value) {
            addCriterion("appName like", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameNotLike(String value) {
            addCriterion("appName not like", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameIn(List<String> values) {
            addCriterion("appName in", values, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameNotIn(List<String> values) {
            addCriterion("appName not in", values, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameBetween(String value1, String value2) {
            addCriterion("appName between", value1, value2, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameNotBetween(String value1, String value2) {
            addCriterion("appName not between", value1, value2, "appname");
            return (Criteria) this;
        }

        public Criteria andAppstoreurlIsNull() {
            addCriterion("appStoreUrl is null");
            return (Criteria) this;
        }

        public Criteria andAppstoreurlIsNotNull() {
            addCriterion("appStoreUrl is not null");
            return (Criteria) this;
        }

        public Criteria andAppstoreurlEqualTo(String value) {
            addCriterion("appStoreUrl =", value, "appstoreurl");
            return (Criteria) this;
        }

        public Criteria andAppstoreurlNotEqualTo(String value) {
            addCriterion("appStoreUrl <>", value, "appstoreurl");
            return (Criteria) this;
        }

        public Criteria andAppstoreurlGreaterThan(String value) {
            addCriterion("appStoreUrl >", value, "appstoreurl");
            return (Criteria) this;
        }

        public Criteria andAppstoreurlGreaterThanOrEqualTo(String value) {
            addCriterion("appStoreUrl >=", value, "appstoreurl");
            return (Criteria) this;
        }

        public Criteria andAppstoreurlLessThan(String value) {
            addCriterion("appStoreUrl <", value, "appstoreurl");
            return (Criteria) this;
        }

        public Criteria andAppstoreurlLessThanOrEqualTo(String value) {
            addCriterion("appStoreUrl <=", value, "appstoreurl");
            return (Criteria) this;
        }

        public Criteria andAppstoreurlLike(String value) {
            addCriterion("appStoreUrl like", value, "appstoreurl");
            return (Criteria) this;
        }

        public Criteria andAppstoreurlNotLike(String value) {
            addCriterion("appStoreUrl not like", value, "appstoreurl");
            return (Criteria) this;
        }

        public Criteria andAppstoreurlIn(List<String> values) {
            addCriterion("appStoreUrl in", values, "appstoreurl");
            return (Criteria) this;
        }

        public Criteria andAppstoreurlNotIn(List<String> values) {
            addCriterion("appStoreUrl not in", values, "appstoreurl");
            return (Criteria) this;
        }

        public Criteria andAppstoreurlBetween(String value1, String value2) {
            addCriterion("appStoreUrl between", value1, value2, "appstoreurl");
            return (Criteria) this;
        }

        public Criteria andAppstoreurlNotBetween(String value1, String value2) {
            addCriterion("appStoreUrl not between", value1, value2, "appstoreurl");
            return (Criteria) this;
        }

        public Criteria andAppiconIsNull() {
            addCriterion("appIcon is null");
            return (Criteria) this;
        }

        public Criteria andAppiconIsNotNull() {
            addCriterion("appIcon is not null");
            return (Criteria) this;
        }

        public Criteria andAppiconEqualTo(String value) {
            addCriterion("appIcon =", value, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppiconNotEqualTo(String value) {
            addCriterion("appIcon <>", value, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppiconGreaterThan(String value) {
            addCriterion("appIcon >", value, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppiconGreaterThanOrEqualTo(String value) {
            addCriterion("appIcon >=", value, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppiconLessThan(String value) {
            addCriterion("appIcon <", value, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppiconLessThanOrEqualTo(String value) {
            addCriterion("appIcon <=", value, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppiconLike(String value) {
            addCriterion("appIcon like", value, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppiconNotLike(String value) {
            addCriterion("appIcon not like", value, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppiconIn(List<String> values) {
            addCriterion("appIcon in", values, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppiconNotIn(List<String> values) {
            addCriterion("appIcon not in", values, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppiconBetween(String value1, String value2) {
            addCriterion("appIcon between", value1, value2, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppiconNotBetween(String value1, String value2) {
            addCriterion("appIcon not between", value1, value2, "appicon");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNull() {
            addCriterion("platform is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNotNull() {
            addCriterion("platform is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformEqualTo(String value) {
            addCriterion("platform =", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotEqualTo(String value) {
            addCriterion("platform <>", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThan(String value) {
            addCriterion("platform >", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThanOrEqualTo(String value) {
            addCriterion("platform >=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThan(String value) {
            addCriterion("platform <", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThanOrEqualTo(String value) {
            addCriterion("platform <=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLike(String value) {
            addCriterion("platform like", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotLike(String value) {
            addCriterion("platform not like", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformIn(List<String> values) {
            addCriterion("platform in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotIn(List<String> values) {
            addCriterion("platform not in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformBetween(String value1, String value2) {
            addCriterion("platform between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotBetween(String value1, String value2) {
            addCriterion("platform not between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andOsIsNull() {
            addCriterion("os is null");
            return (Criteria) this;
        }

        public Criteria andOsIsNotNull() {
            addCriterion("os is not null");
            return (Criteria) this;
        }

        public Criteria andOsEqualTo(String value) {
            addCriterion("os =", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotEqualTo(String value) {
            addCriterion("os <>", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsGreaterThan(String value) {
            addCriterion("os >", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsGreaterThanOrEqualTo(String value) {
            addCriterion("os >=", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsLessThan(String value) {
            addCriterion("os <", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsLessThanOrEqualTo(String value) {
            addCriterion("os <=", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsLike(String value) {
            addCriterion("os like", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotLike(String value) {
            addCriterion("os not like", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsIn(List<String> values) {
            addCriterion("os in", values, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotIn(List<String> values) {
            addCriterion("os not in", values, "os");
            return (Criteria) this;
        }

        public Criteria andOsBetween(String value1, String value2) {
            addCriterion("os between", value1, value2, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotBetween(String value1, String value2) {
            addCriterion("os not between", value1, value2, "os");
            return (Criteria) this;
        }

        public Criteria andMinosIsNull() {
            addCriterion("minOS is null");
            return (Criteria) this;
        }

        public Criteria andMinosIsNotNull() {
            addCriterion("minOS is not null");
            return (Criteria) this;
        }

        public Criteria andMinosEqualTo(String value) {
            addCriterion("minOS =", value, "minos");
            return (Criteria) this;
        }

        public Criteria andMinosNotEqualTo(String value) {
            addCriterion("minOS <>", value, "minos");
            return (Criteria) this;
        }

        public Criteria andMinosGreaterThan(String value) {
            addCriterion("minOS >", value, "minos");
            return (Criteria) this;
        }

        public Criteria andMinosGreaterThanOrEqualTo(String value) {
            addCriterion("minOS >=", value, "minos");
            return (Criteria) this;
        }

        public Criteria andMinosLessThan(String value) {
            addCriterion("minOS <", value, "minos");
            return (Criteria) this;
        }

        public Criteria andMinosLessThanOrEqualTo(String value) {
            addCriterion("minOS <=", value, "minos");
            return (Criteria) this;
        }

        public Criteria andMinosLike(String value) {
            addCriterion("minOS like", value, "minos");
            return (Criteria) this;
        }

        public Criteria andMinosNotLike(String value) {
            addCriterion("minOS not like", value, "minos");
            return (Criteria) this;
        }

        public Criteria andMinosIn(List<String> values) {
            addCriterion("minOS in", values, "minos");
            return (Criteria) this;
        }

        public Criteria andMinosNotIn(List<String> values) {
            addCriterion("minOS not in", values, "minos");
            return (Criteria) this;
        }

        public Criteria andMinosBetween(String value1, String value2) {
            addCriterion("minOS between", value1, value2, "minos");
            return (Criteria) this;
        }

        public Criteria andMinosNotBetween(String value1, String value2) {
            addCriterion("minOS not between", value1, value2, "minos");
            return (Criteria) this;
        }

        public Criteria andCreativesIsNull() {
            addCriterion("creatives is null");
            return (Criteria) this;
        }

        public Criteria andCreativesIsNotNull() {
            addCriterion("creatives is not null");
            return (Criteria) this;
        }

        public Criteria andCreativesEqualTo(String value) {
            addCriterion("creatives =", value, "creatives");
            return (Criteria) this;
        }

        public Criteria andCreativesNotEqualTo(String value) {
            addCriterion("creatives <>", value, "creatives");
            return (Criteria) this;
        }

        public Criteria andCreativesGreaterThan(String value) {
            addCriterion("creatives >", value, "creatives");
            return (Criteria) this;
        }

        public Criteria andCreativesGreaterThanOrEqualTo(String value) {
            addCriterion("creatives >=", value, "creatives");
            return (Criteria) this;
        }

        public Criteria andCreativesLessThan(String value) {
            addCriterion("creatives <", value, "creatives");
            return (Criteria) this;
        }

        public Criteria andCreativesLessThanOrEqualTo(String value) {
            addCriterion("creatives <=", value, "creatives");
            return (Criteria) this;
        }

        public Criteria andCreativesLike(String value) {
            addCriterion("creatives like", value, "creatives");
            return (Criteria) this;
        }

        public Criteria andCreativesNotLike(String value) {
            addCriterion("creatives not like", value, "creatives");
            return (Criteria) this;
        }

        public Criteria andCreativesIn(List<String> values) {
            addCriterion("creatives in", values, "creatives");
            return (Criteria) this;
        }

        public Criteria andCreativesNotIn(List<String> values) {
            addCriterion("creatives not in", values, "creatives");
            return (Criteria) this;
        }

        public Criteria andCreativesBetween(String value1, String value2) {
            addCriterion("creatives between", value1, value2, "creatives");
            return (Criteria) this;
        }

        public Criteria andCreativesNotBetween(String value1, String value2) {
            addCriterion("creatives not between", value1, value2, "creatives");
            return (Criteria) this;
        }

        public Criteria andWhitelistIsNull() {
            addCriterion("whitelist is null");
            return (Criteria) this;
        }

        public Criteria andWhitelistIsNotNull() {
            addCriterion("whitelist is not null");
            return (Criteria) this;
        }

        public Criteria andWhitelistEqualTo(String value) {
            addCriterion("whitelist =", value, "whitelist");
            return (Criteria) this;
        }

        public Criteria andWhitelistNotEqualTo(String value) {
            addCriterion("whitelist <>", value, "whitelist");
            return (Criteria) this;
        }

        public Criteria andWhitelistGreaterThan(String value) {
            addCriterion("whitelist >", value, "whitelist");
            return (Criteria) this;
        }

        public Criteria andWhitelistGreaterThanOrEqualTo(String value) {
            addCriterion("whitelist >=", value, "whitelist");
            return (Criteria) this;
        }

        public Criteria andWhitelistLessThan(String value) {
            addCriterion("whitelist <", value, "whitelist");
            return (Criteria) this;
        }

        public Criteria andWhitelistLessThanOrEqualTo(String value) {
            addCriterion("whitelist <=", value, "whitelist");
            return (Criteria) this;
        }

        public Criteria andWhitelistLike(String value) {
            addCriterion("whitelist like", value, "whitelist");
            return (Criteria) this;
        }

        public Criteria andWhitelistNotLike(String value) {
            addCriterion("whitelist not like", value, "whitelist");
            return (Criteria) this;
        }

        public Criteria andWhitelistIn(List<String> values) {
            addCriterion("whitelist in", values, "whitelist");
            return (Criteria) this;
        }

        public Criteria andWhitelistNotIn(List<String> values) {
            addCriterion("whitelist not in", values, "whitelist");
            return (Criteria) this;
        }

        public Criteria andWhitelistBetween(String value1, String value2) {
            addCriterion("whitelist between", value1, value2, "whitelist");
            return (Criteria) this;
        }

        public Criteria andWhitelistNotBetween(String value1, String value2) {
            addCriterion("whitelist not between", value1, value2, "whitelist");
            return (Criteria) this;
        }

        public Criteria andBlacklistIsNull() {
            addCriterion("blacklist is null");
            return (Criteria) this;
        }

        public Criteria andBlacklistIsNotNull() {
            addCriterion("blacklist is not null");
            return (Criteria) this;
        }

        public Criteria andBlacklistEqualTo(String value) {
            addCriterion("blacklist =", value, "blacklist");
            return (Criteria) this;
        }

        public Criteria andBlacklistNotEqualTo(String value) {
            addCriterion("blacklist <>", value, "blacklist");
            return (Criteria) this;
        }

        public Criteria andBlacklistGreaterThan(String value) {
            addCriterion("blacklist >", value, "blacklist");
            return (Criteria) this;
        }

        public Criteria andBlacklistGreaterThanOrEqualTo(String value) {
            addCriterion("blacklist >=", value, "blacklist");
            return (Criteria) this;
        }

        public Criteria andBlacklistLessThan(String value) {
            addCriterion("blacklist <", value, "blacklist");
            return (Criteria) this;
        }

        public Criteria andBlacklistLessThanOrEqualTo(String value) {
            addCriterion("blacklist <=", value, "blacklist");
            return (Criteria) this;
        }

        public Criteria andBlacklistLike(String value) {
            addCriterion("blacklist like", value, "blacklist");
            return (Criteria) this;
        }

        public Criteria andBlacklistNotLike(String value) {
            addCriterion("blacklist not like", value, "blacklist");
            return (Criteria) this;
        }

        public Criteria andBlacklistIn(List<String> values) {
            addCriterion("blacklist in", values, "blacklist");
            return (Criteria) this;
        }

        public Criteria andBlacklistNotIn(List<String> values) {
            addCriterion("blacklist not in", values, "blacklist");
            return (Criteria) this;
        }

        public Criteria andBlacklistBetween(String value1, String value2) {
            addCriterion("blacklist between", value1, value2, "blacklist");
            return (Criteria) this;
        }

        public Criteria andBlacklistNotBetween(String value1, String value2) {
            addCriterion("blacklist not between", value1, value2, "blacklist");
            return (Criteria) this;
        }

        public Criteria andCountriesIsNull() {
            addCriterion("countries is null");
            return (Criteria) this;
        }

        public Criteria andCountriesIsNotNull() {
            addCriterion("countries is not null");
            return (Criteria) this;
        }

        public Criteria andCountriesEqualTo(String value) {
            addCriterion("countries =", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesNotEqualTo(String value) {
            addCriterion("countries <>", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesGreaterThan(String value) {
            addCriterion("countries >", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesGreaterThanOrEqualTo(String value) {
            addCriterion("countries >=", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesLessThan(String value) {
            addCriterion("countries <", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesLessThanOrEqualTo(String value) {
            addCriterion("countries <=", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesLike(String value) {
            addCriterion("countries like", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesNotLike(String value) {
            addCriterion("countries not like", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesIn(List<String> values) {
            addCriterion("countries in", values, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesNotIn(List<String> values) {
            addCriterion("countries not in", values, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesBetween(String value1, String value2) {
            addCriterion("countries between", value1, value2, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesNotBetween(String value1, String value2) {
            addCriterion("countries not between", value1, value2, "countries");
            return (Criteria) this;
        }

        public Criteria andCitiesIsNull() {
            addCriterion("cities is null");
            return (Criteria) this;
        }

        public Criteria andCitiesIsNotNull() {
            addCriterion("cities is not null");
            return (Criteria) this;
        }

        public Criteria andCitiesEqualTo(String value) {
            addCriterion("cities =", value, "cities");
            return (Criteria) this;
        }

        public Criteria andCitiesNotEqualTo(String value) {
            addCriterion("cities <>", value, "cities");
            return (Criteria) this;
        }

        public Criteria andCitiesGreaterThan(String value) {
            addCriterion("cities >", value, "cities");
            return (Criteria) this;
        }

        public Criteria andCitiesGreaterThanOrEqualTo(String value) {
            addCriterion("cities >=", value, "cities");
            return (Criteria) this;
        }

        public Criteria andCitiesLessThan(String value) {
            addCriterion("cities <", value, "cities");
            return (Criteria) this;
        }

        public Criteria andCitiesLessThanOrEqualTo(String value) {
            addCriterion("cities <=", value, "cities");
            return (Criteria) this;
        }

        public Criteria andCitiesLike(String value) {
            addCriterion("cities like", value, "cities");
            return (Criteria) this;
        }

        public Criteria andCitiesNotLike(String value) {
            addCriterion("cities not like", value, "cities");
            return (Criteria) this;
        }

        public Criteria andCitiesIn(List<String> values) {
            addCriterion("cities in", values, "cities");
            return (Criteria) this;
        }

        public Criteria andCitiesNotIn(List<String> values) {
            addCriterion("cities not in", values, "cities");
            return (Criteria) this;
        }

        public Criteria andCitiesBetween(String value1, String value2) {
            addCriterion("cities between", value1, value2, "cities");
            return (Criteria) this;
        }

        public Criteria andCitiesNotBetween(String value1, String value2) {
            addCriterion("cities not between", value1, value2, "cities");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Short value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Short value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Short value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Short value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Short value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Short value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Short> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Short> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Short value1, Short value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Short value1, Short value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andDailybudgetIsNull() {
            addCriterion("dailybudget is null");
            return (Criteria) this;
        }

        public Criteria andDailybudgetIsNotNull() {
            addCriterion("dailybudget is not null");
            return (Criteria) this;
        }

        public Criteria andDailybudgetEqualTo(Float value) {
            addCriterion("dailybudget =", value, "dailybudget");
            return (Criteria) this;
        }

        public Criteria andDailybudgetNotEqualTo(Float value) {
            addCriterion("dailybudget <>", value, "dailybudget");
            return (Criteria) this;
        }

        public Criteria andDailybudgetGreaterThan(Float value) {
            addCriterion("dailybudget >", value, "dailybudget");
            return (Criteria) this;
        }

        public Criteria andDailybudgetGreaterThanOrEqualTo(Float value) {
            addCriterion("dailybudget >=", value, "dailybudget");
            return (Criteria) this;
        }

        public Criteria andDailybudgetLessThan(Float value) {
            addCriterion("dailybudget <", value, "dailybudget");
            return (Criteria) this;
        }

        public Criteria andDailybudgetLessThanOrEqualTo(Float value) {
            addCriterion("dailybudget <=", value, "dailybudget");
            return (Criteria) this;
        }

        public Criteria andDailybudgetIn(List<Float> values) {
            addCriterion("dailybudget in", values, "dailybudget");
            return (Criteria) this;
        }

        public Criteria andDailybudgetNotIn(List<Float> values) {
            addCriterion("dailybudget not in", values, "dailybudget");
            return (Criteria) this;
        }

        public Criteria andDailybudgetBetween(Float value1, Float value2) {
            addCriterion("dailybudget between", value1, value2, "dailybudget");
            return (Criteria) this;
        }

        public Criteria andDailybudgetNotBetween(Float value1, Float value2) {
            addCriterion("dailybudget not between", value1, value2, "dailybudget");
            return (Criteria) this;
        }

        public Criteria andDailymaxclicksIsNull() {
            addCriterion("dailymaxclicks is null");
            return (Criteria) this;
        }

        public Criteria andDailymaxclicksIsNotNull() {
            addCriterion("dailymaxclicks is not null");
            return (Criteria) this;
        }

        public Criteria andDailymaxclicksEqualTo(Integer value) {
            addCriterion("dailymaxclicks =", value, "dailymaxclicks");
            return (Criteria) this;
        }

        public Criteria andDailymaxclicksNotEqualTo(Integer value) {
            addCriterion("dailymaxclicks <>", value, "dailymaxclicks");
            return (Criteria) this;
        }

        public Criteria andDailymaxclicksGreaterThan(Integer value) {
            addCriterion("dailymaxclicks >", value, "dailymaxclicks");
            return (Criteria) this;
        }

        public Criteria andDailymaxclicksGreaterThanOrEqualTo(Integer value) {
            addCriterion("dailymaxclicks >=", value, "dailymaxclicks");
            return (Criteria) this;
        }

        public Criteria andDailymaxclicksLessThan(Integer value) {
            addCriterion("dailymaxclicks <", value, "dailymaxclicks");
            return (Criteria) this;
        }

        public Criteria andDailymaxclicksLessThanOrEqualTo(Integer value) {
            addCriterion("dailymaxclicks <=", value, "dailymaxclicks");
            return (Criteria) this;
        }

        public Criteria andDailymaxclicksIn(List<Integer> values) {
            addCriterion("dailymaxclicks in", values, "dailymaxclicks");
            return (Criteria) this;
        }

        public Criteria andDailymaxclicksNotIn(List<Integer> values) {
            addCriterion("dailymaxclicks not in", values, "dailymaxclicks");
            return (Criteria) this;
        }

        public Criteria andDailymaxclicksBetween(Integer value1, Integer value2) {
            addCriterion("dailymaxclicks between", value1, value2, "dailymaxclicks");
            return (Criteria) this;
        }

        public Criteria andDailymaxclicksNotBetween(Integer value1, Integer value2) {
            addCriterion("dailymaxclicks not between", value1, value2, "dailymaxclicks");
            return (Criteria) this;
        }

        public Criteria andRtbrunningIsNull() {
            addCriterion("rtbRunning is null");
            return (Criteria) this;
        }

        public Criteria andRtbrunningIsNotNull() {
            addCriterion("rtbRunning is not null");
            return (Criteria) this;
        }

        public Criteria andRtbrunningEqualTo(Short value) {
            addCriterion("rtbRunning =", value, "rtbrunning");
            return (Criteria) this;
        }

        public Criteria andRtbrunningNotEqualTo(Short value) {
            addCriterion("rtbRunning <>", value, "rtbrunning");
            return (Criteria) this;
        }

        public Criteria andRtbrunningGreaterThan(Short value) {
            addCriterion("rtbRunning >", value, "rtbrunning");
            return (Criteria) this;
        }

        public Criteria andRtbrunningGreaterThanOrEqualTo(Short value) {
            addCriterion("rtbRunning >=", value, "rtbrunning");
            return (Criteria) this;
        }

        public Criteria andRtbrunningLessThan(Short value) {
            addCriterion("rtbRunning <", value, "rtbrunning");
            return (Criteria) this;
        }

        public Criteria andRtbrunningLessThanOrEqualTo(Short value) {
            addCriterion("rtbRunning <=", value, "rtbrunning");
            return (Criteria) this;
        }

        public Criteria andRtbrunningIn(List<Short> values) {
            addCriterion("rtbRunning in", values, "rtbrunning");
            return (Criteria) this;
        }

        public Criteria andRtbrunningNotIn(List<Short> values) {
            addCriterion("rtbRunning not in", values, "rtbrunning");
            return (Criteria) this;
        }

        public Criteria andRtbrunningBetween(Short value1, Short value2) {
            addCriterion("rtbRunning between", value1, value2, "rtbrunning");
            return (Criteria) this;
        }

        public Criteria andRtbrunningNotBetween(Short value1, Short value2) {
            addCriterion("rtbRunning not between", value1, value2, "rtbrunning");
            return (Criteria) this;
        }

        public Criteria andRunningIsNull() {
            addCriterion("running is null");
            return (Criteria) this;
        }

        public Criteria andRunningIsNotNull() {
            addCriterion("running is not null");
            return (Criteria) this;
        }

        public Criteria andRunningEqualTo(Short value) {
            addCriterion("running =", value, "running");
            return (Criteria) this;
        }

        public Criteria andRunningNotEqualTo(Short value) {
            addCriterion("running <>", value, "running");
            return (Criteria) this;
        }

        public Criteria andRunningGreaterThan(Short value) {
            addCriterion("running >", value, "running");
            return (Criteria) this;
        }

        public Criteria andRunningGreaterThanOrEqualTo(Short value) {
            addCriterion("running >=", value, "running");
            return (Criteria) this;
        }

        public Criteria andRunningLessThan(Short value) {
            addCriterion("running <", value, "running");
            return (Criteria) this;
        }

        public Criteria andRunningLessThanOrEqualTo(Short value) {
            addCriterion("running <=", value, "running");
            return (Criteria) this;
        }

        public Criteria andRunningIn(List<Short> values) {
            addCriterion("running in", values, "running");
            return (Criteria) this;
        }

        public Criteria andRunningNotIn(List<Short> values) {
            addCriterion("running not in", values, "running");
            return (Criteria) this;
        }

        public Criteria andRunningBetween(Short value1, Short value2) {
            addCriterion("running between", value1, value2, "running");
            return (Criteria) this;
        }

        public Criteria andRunningNotBetween(Short value1, Short value2) {
            addCriterion("running not between", value1, value2, "running");
            return (Criteria) this;
        }

        public Criteria andClickstepsIsNull() {
            addCriterion("clickSteps is null");
            return (Criteria) this;
        }

        public Criteria andClickstepsIsNotNull() {
            addCriterion("clickSteps is not null");
            return (Criteria) this;
        }

        public Criteria andClickstepsEqualTo(Byte value) {
            addCriterion("clickSteps =", value, "clicksteps");
            return (Criteria) this;
        }

        public Criteria andClickstepsNotEqualTo(Byte value) {
            addCriterion("clickSteps <>", value, "clicksteps");
            return (Criteria) this;
        }

        public Criteria andClickstepsGreaterThan(Byte value) {
            addCriterion("clickSteps >", value, "clicksteps");
            return (Criteria) this;
        }

        public Criteria andClickstepsGreaterThanOrEqualTo(Byte value) {
            addCriterion("clickSteps >=", value, "clicksteps");
            return (Criteria) this;
        }

        public Criteria andClickstepsLessThan(Byte value) {
            addCriterion("clickSteps <", value, "clicksteps");
            return (Criteria) this;
        }

        public Criteria andClickstepsLessThanOrEqualTo(Byte value) {
            addCriterion("clickSteps <=", value, "clicksteps");
            return (Criteria) this;
        }

        public Criteria andClickstepsIn(List<Byte> values) {
            addCriterion("clickSteps in", values, "clicksteps");
            return (Criteria) this;
        }

        public Criteria andClickstepsNotIn(List<Byte> values) {
            addCriterion("clickSteps not in", values, "clicksteps");
            return (Criteria) this;
        }

        public Criteria andClickstepsBetween(Byte value1, Byte value2) {
            addCriterion("clickSteps between", value1, value2, "clicksteps");
            return (Criteria) this;
        }

        public Criteria andClickstepsNotBetween(Byte value1, Byte value2) {
            addCriterion("clickSteps not between", value1, value2, "clicksteps");
            return (Criteria) this;
        }

        public Criteria andToppublisherIsNull() {
            addCriterion("topPublisher is null");
            return (Criteria) this;
        }

        public Criteria andToppublisherIsNotNull() {
            addCriterion("topPublisher is not null");
            return (Criteria) this;
        }

        public Criteria andToppublisherEqualTo(String value) {
            addCriterion("topPublisher =", value, "toppublisher");
            return (Criteria) this;
        }

        public Criteria andToppublisherNotEqualTo(String value) {
            addCriterion("topPublisher <>", value, "toppublisher");
            return (Criteria) this;
        }

        public Criteria andToppublisherGreaterThan(String value) {
            addCriterion("topPublisher >", value, "toppublisher");
            return (Criteria) this;
        }

        public Criteria andToppublisherGreaterThanOrEqualTo(String value) {
            addCriterion("topPublisher >=", value, "toppublisher");
            return (Criteria) this;
        }

        public Criteria andToppublisherLessThan(String value) {
            addCriterion("topPublisher <", value, "toppublisher");
            return (Criteria) this;
        }

        public Criteria andToppublisherLessThanOrEqualTo(String value) {
            addCriterion("topPublisher <=", value, "toppublisher");
            return (Criteria) this;
        }

        public Criteria andToppublisherLike(String value) {
            addCriterion("topPublisher like", value, "toppublisher");
            return (Criteria) this;
        }

        public Criteria andToppublisherNotLike(String value) {
            addCriterion("topPublisher not like", value, "toppublisher");
            return (Criteria) this;
        }

        public Criteria andToppublisherIn(List<String> values) {
            addCriterion("topPublisher in", values, "toppublisher");
            return (Criteria) this;
        }

        public Criteria andToppublisherNotIn(List<String> values) {
            addCriterion("topPublisher not in", values, "toppublisher");
            return (Criteria) this;
        }

        public Criteria andToppublisherBetween(String value1, String value2) {
            addCriterion("topPublisher between", value1, value2, "toppublisher");
            return (Criteria) this;
        }

        public Criteria andToppublisherNotBetween(String value1, String value2) {
            addCriterion("topPublisher not between", value1, value2, "toppublisher");
            return (Criteria) this;
        }

        public Criteria andMonitorIsNull() {
            addCriterion("monitor is null");
            return (Criteria) this;
        }

        public Criteria andMonitorIsNotNull() {
            addCriterion("monitor is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorEqualTo(String value) {
            addCriterion("monitor =", value, "monitor");
            return (Criteria) this;
        }

        public Criteria andMonitorNotEqualTo(String value) {
            addCriterion("monitor <>", value, "monitor");
            return (Criteria) this;
        }

        public Criteria andMonitorGreaterThan(String value) {
            addCriterion("monitor >", value, "monitor");
            return (Criteria) this;
        }

        public Criteria andMonitorGreaterThanOrEqualTo(String value) {
            addCriterion("monitor >=", value, "monitor");
            return (Criteria) this;
        }

        public Criteria andMonitorLessThan(String value) {
            addCriterion("monitor <", value, "monitor");
            return (Criteria) this;
        }

        public Criteria andMonitorLessThanOrEqualTo(String value) {
            addCriterion("monitor <=", value, "monitor");
            return (Criteria) this;
        }

        public Criteria andMonitorLike(String value) {
            addCriterion("monitor like", value, "monitor");
            return (Criteria) this;
        }

        public Criteria andMonitorNotLike(String value) {
            addCriterion("monitor not like", value, "monitor");
            return (Criteria) this;
        }

        public Criteria andMonitorIn(List<String> values) {
            addCriterion("monitor in", values, "monitor");
            return (Criteria) this;
        }

        public Criteria andMonitorNotIn(List<String> values) {
            addCriterion("monitor not in", values, "monitor");
            return (Criteria) this;
        }

        public Criteria andMonitorBetween(String value1, String value2) {
            addCriterion("monitor between", value1, value2, "monitor");
            return (Criteria) this;
        }

        public Criteria andMonitorNotBetween(String value1, String value2) {
            addCriterion("monitor not between", value1, value2, "monitor");
            return (Criteria) this;
        }

        public Criteria andRuntimeIsNull() {
            addCriterion("runTime is null");
            return (Criteria) this;
        }

        public Criteria andRuntimeIsNotNull() {
            addCriterion("runTime is not null");
            return (Criteria) this;
        }

        public Criteria andRuntimeEqualTo(Date value) {
            addCriterion("runTime =", value, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeNotEqualTo(Date value) {
            addCriterion("runTime <>", value, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeGreaterThan(Date value) {
            addCriterion("runTime >", value, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeGreaterThanOrEqualTo(Date value) {
            addCriterion("runTime >=", value, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeLessThan(Date value) {
            addCriterion("runTime <", value, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeLessThanOrEqualTo(Date value) {
            addCriterion("runTime <=", value, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeIn(List<Date> values) {
            addCriterion("runTime in", values, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeNotIn(List<Date> values) {
            addCriterion("runTime not in", values, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeBetween(Date value1, Date value2) {
            addCriterion("runTime between", value1, value2, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeNotBetween(Date value1, Date value2) {
            addCriterion("runTime not between", value1, value2, "runtime");
            return (Criteria) this;
        }

        public Criteria andStoptimeIsNull() {
            addCriterion("stopTime is null");
            return (Criteria) this;
        }

        public Criteria andStoptimeIsNotNull() {
            addCriterion("stopTime is not null");
            return (Criteria) this;
        }

        public Criteria andStoptimeEqualTo(Date value) {
            addCriterion("stopTime =", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeNotEqualTo(Date value) {
            addCriterion("stopTime <>", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeGreaterThan(Date value) {
            addCriterion("stopTime >", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("stopTime >=", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeLessThan(Date value) {
            addCriterion("stopTime <", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeLessThanOrEqualTo(Date value) {
            addCriterion("stopTime <=", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeIn(List<Date> values) {
            addCriterion("stopTime in", values, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeNotIn(List<Date> values) {
            addCriterion("stopTime not in", values, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeBetween(Date value1, Date value2) {
            addCriterion("stopTime between", value1, value2, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeNotBetween(Date value1, Date value2) {
            addCriterion("stopTime not between", value1, value2, "stoptime");
            return (Criteria) this;
        }

        public Criteria andPlacementsIsNull() {
            addCriterion("placements is null");
            return (Criteria) this;
        }

        public Criteria andPlacementsIsNotNull() {
            addCriterion("placements is not null");
            return (Criteria) this;
        }

        public Criteria andPlacementsEqualTo(String value) {
            addCriterion("placements =", value, "placements");
            return (Criteria) this;
        }

        public Criteria andPlacementsNotEqualTo(String value) {
            addCriterion("placements <>", value, "placements");
            return (Criteria) this;
        }

        public Criteria andPlacementsGreaterThan(String value) {
            addCriterion("placements >", value, "placements");
            return (Criteria) this;
        }

        public Criteria andPlacementsGreaterThanOrEqualTo(String value) {
            addCriterion("placements >=", value, "placements");
            return (Criteria) this;
        }

        public Criteria andPlacementsLessThan(String value) {
            addCriterion("placements <", value, "placements");
            return (Criteria) this;
        }

        public Criteria andPlacementsLessThanOrEqualTo(String value) {
            addCriterion("placements <=", value, "placements");
            return (Criteria) this;
        }

        public Criteria andPlacementsLike(String value) {
            addCriterion("placements like", value, "placements");
            return (Criteria) this;
        }

        public Criteria andPlacementsNotLike(String value) {
            addCriterion("placements not like", value, "placements");
            return (Criteria) this;
        }

        public Criteria andPlacementsIn(List<String> values) {
            addCriterion("placements in", values, "placements");
            return (Criteria) this;
        }

        public Criteria andPlacementsNotIn(List<String> values) {
            addCriterion("placements not in", values, "placements");
            return (Criteria) this;
        }

        public Criteria andPlacementsBetween(String value1, String value2) {
            addCriterion("placements between", value1, value2, "placements");
            return (Criteria) this;
        }

        public Criteria andPlacementsNotBetween(String value1, String value2) {
            addCriterion("placements not between", value1, value2, "placements");
            return (Criteria) this;
        }

        public Criteria andInserttimeIsNull() {
            addCriterion("insertTime is null");
            return (Criteria) this;
        }

        public Criteria andInserttimeIsNotNull() {
            addCriterion("insertTime is not null");
            return (Criteria) this;
        }

        public Criteria andInserttimeEqualTo(Date value) {
            addCriterion("insertTime =", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotEqualTo(Date value) {
            addCriterion("insertTime <>", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeGreaterThan(Date value) {
            addCriterion("insertTime >", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("insertTime >=", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeLessThan(Date value) {
            addCriterion("insertTime <", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeLessThanOrEqualTo(Date value) {
            addCriterion("insertTime <=", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeIn(List<Date> values) {
            addCriterion("insertTime in", values, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotIn(List<Date> values) {
            addCriterion("insertTime not in", values, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeBetween(Date value1, Date value2) {
            addCriterion("insertTime between", value1, value2, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotBetween(Date value1, Date value2) {
            addCriterion("insertTime not between", value1, value2, "inserttime");
            return (Criteria) this;
        }

        public Criteria andProxyinfoIsNull() {
            addCriterion("proxyinfo is null");
            return (Criteria) this;
        }

        public Criteria andProxyinfoIsNotNull() {
            addCriterion("proxyinfo is not null");
            return (Criteria) this;
        }

        public Criteria andProxyinfoEqualTo(String value) {
            addCriterion("proxyinfo =", value, "proxyinfo");
            return (Criteria) this;
        }

        public Criteria andProxyinfoNotEqualTo(String value) {
            addCriterion("proxyinfo <>", value, "proxyinfo");
            return (Criteria) this;
        }

        public Criteria andProxyinfoGreaterThan(String value) {
            addCriterion("proxyinfo >", value, "proxyinfo");
            return (Criteria) this;
        }

        public Criteria andProxyinfoGreaterThanOrEqualTo(String value) {
            addCriterion("proxyinfo >=", value, "proxyinfo");
            return (Criteria) this;
        }

        public Criteria andProxyinfoLessThan(String value) {
            addCriterion("proxyinfo <", value, "proxyinfo");
            return (Criteria) this;
        }

        public Criteria andProxyinfoLessThanOrEqualTo(String value) {
            addCriterion("proxyinfo <=", value, "proxyinfo");
            return (Criteria) this;
        }

        public Criteria andProxyinfoLike(String value) {
            addCriterion("proxyinfo like", value, "proxyinfo");
            return (Criteria) this;
        }

        public Criteria andProxyinfoNotLike(String value) {
            addCriterion("proxyinfo not like", value, "proxyinfo");
            return (Criteria) this;
        }

        public Criteria andProxyinfoIn(List<String> values) {
            addCriterion("proxyinfo in", values, "proxyinfo");
            return (Criteria) this;
        }

        public Criteria andProxyinfoNotIn(List<String> values) {
            addCriterion("proxyinfo not in", values, "proxyinfo");
            return (Criteria) this;
        }

        public Criteria andProxyinfoBetween(String value1, String value2) {
            addCriterion("proxyinfo between", value1, value2, "proxyinfo");
            return (Criteria) this;
        }

        public Criteria andProxyinfoNotBetween(String value1, String value2) {
            addCriterion("proxyinfo not between", value1, value2, "proxyinfo");
            return (Criteria) this;
        }

        public Criteria andIsreachableIsNull() {
            addCriterion("isReachable is null");
            return (Criteria) this;
        }

        public Criteria andIsreachableIsNotNull() {
            addCriterion("isReachable is not null");
            return (Criteria) this;
        }

        public Criteria andIsreachableEqualTo(Short value) {
            addCriterion("isReachable =", value, "isreachable");
            return (Criteria) this;
        }

        public Criteria andIsreachableNotEqualTo(Short value) {
            addCriterion("isReachable <>", value, "isreachable");
            return (Criteria) this;
        }

        public Criteria andIsreachableGreaterThan(Short value) {
            addCriterion("isReachable >", value, "isreachable");
            return (Criteria) this;
        }

        public Criteria andIsreachableGreaterThanOrEqualTo(Short value) {
            addCriterion("isReachable >=", value, "isreachable");
            return (Criteria) this;
        }

        public Criteria andIsreachableLessThan(Short value) {
            addCriterion("isReachable <", value, "isreachable");
            return (Criteria) this;
        }

        public Criteria andIsreachableLessThanOrEqualTo(Short value) {
            addCriterion("isReachable <=", value, "isreachable");
            return (Criteria) this;
        }

        public Criteria andIsreachableIn(List<Short> values) {
            addCriterion("isReachable in", values, "isreachable");
            return (Criteria) this;
        }

        public Criteria andIsreachableNotIn(List<Short> values) {
            addCriterion("isReachable not in", values, "isreachable");
            return (Criteria) this;
        }

        public Criteria andIsreachableBetween(Short value1, Short value2) {
            addCriterion("isReachable between", value1, value2, "isreachable");
            return (Criteria) this;
        }

        public Criteria andIsreachableNotBetween(Short value1, Short value2) {
            addCriterion("isReachable not between", value1, value2, "isreachable");
            return (Criteria) this;
        }

        public Criteria andScheduleIsNull() {
            addCriterion("schedule is null");
            return (Criteria) this;
        }

        public Criteria andScheduleIsNotNull() {
            addCriterion("schedule is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleEqualTo(String value) {
            addCriterion("schedule =", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleNotEqualTo(String value) {
            addCriterion("schedule <>", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleGreaterThan(String value) {
            addCriterion("schedule >", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleGreaterThanOrEqualTo(String value) {
            addCriterion("schedule >=", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleLessThan(String value) {
            addCriterion("schedule <", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleLessThanOrEqualTo(String value) {
            addCriterion("schedule <=", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleLike(String value) {
            addCriterion("schedule like", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleNotLike(String value) {
            addCriterion("schedule not like", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleIn(List<String> values) {
            addCriterion("schedule in", values, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleNotIn(List<String> values) {
            addCriterion("schedule not in", values, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleBetween(String value1, String value2) {
            addCriterion("schedule between", value1, value2, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleNotBetween(String value1, String value2) {
            addCriterion("schedule not between", value1, value2, "schedule");
            return (Criteria) this;
        }

        public Criteria andRestrictionsIsNull() {
            addCriterion("restrictions is null");
            return (Criteria) this;
        }

        public Criteria andRestrictionsIsNotNull() {
            addCriterion("restrictions is not null");
            return (Criteria) this;
        }

        public Criteria andRestrictionsEqualTo(String value) {
            addCriterion("restrictions =", value, "restrictions");
            return (Criteria) this;
        }

        public Criteria andRestrictionsNotEqualTo(String value) {
            addCriterion("restrictions <>", value, "restrictions");
            return (Criteria) this;
        }

        public Criteria andRestrictionsGreaterThan(String value) {
            addCriterion("restrictions >", value, "restrictions");
            return (Criteria) this;
        }

        public Criteria andRestrictionsGreaterThanOrEqualTo(String value) {
            addCriterion("restrictions >=", value, "restrictions");
            return (Criteria) this;
        }

        public Criteria andRestrictionsLessThan(String value) {
            addCriterion("restrictions <", value, "restrictions");
            return (Criteria) this;
        }

        public Criteria andRestrictionsLessThanOrEqualTo(String value) {
            addCriterion("restrictions <=", value, "restrictions");
            return (Criteria) this;
        }

        public Criteria andRestrictionsLike(String value) {
            addCriterion("restrictions like", value, "restrictions");
            return (Criteria) this;
        }

        public Criteria andRestrictionsNotLike(String value) {
            addCriterion("restrictions not like", value, "restrictions");
            return (Criteria) this;
        }

        public Criteria andRestrictionsIn(List<String> values) {
            addCriterion("restrictions in", values, "restrictions");
            return (Criteria) this;
        }

        public Criteria andRestrictionsNotIn(List<String> values) {
            addCriterion("restrictions not in", values, "restrictions");
            return (Criteria) this;
        }

        public Criteria andRestrictionsBetween(String value1, String value2) {
            addCriterion("restrictions between", value1, value2, "restrictions");
            return (Criteria) this;
        }

        public Criteria andRestrictionsNotBetween(String value1, String value2) {
            addCriterion("restrictions not between", value1, value2, "restrictions");
            return (Criteria) this;
        }

        public Criteria andKpisIsNull() {
            addCriterion("kpis is null");
            return (Criteria) this;
        }

        public Criteria andKpisIsNotNull() {
            addCriterion("kpis is not null");
            return (Criteria) this;
        }

        public Criteria andKpisEqualTo(String value) {
            addCriterion("kpis =", value, "kpis");
            return (Criteria) this;
        }

        public Criteria andKpisNotEqualTo(String value) {
            addCriterion("kpis <>", value, "kpis");
            return (Criteria) this;
        }

        public Criteria andKpisGreaterThan(String value) {
            addCriterion("kpis >", value, "kpis");
            return (Criteria) this;
        }

        public Criteria andKpisGreaterThanOrEqualTo(String value) {
            addCriterion("kpis >=", value, "kpis");
            return (Criteria) this;
        }

        public Criteria andKpisLessThan(String value) {
            addCriterion("kpis <", value, "kpis");
            return (Criteria) this;
        }

        public Criteria andKpisLessThanOrEqualTo(String value) {
            addCriterion("kpis <=", value, "kpis");
            return (Criteria) this;
        }

        public Criteria andKpisLike(String value) {
            addCriterion("kpis like", value, "kpis");
            return (Criteria) this;
        }

        public Criteria andKpisNotLike(String value) {
            addCriterion("kpis not like", value, "kpis");
            return (Criteria) this;
        }

        public Criteria andKpisIn(List<String> values) {
            addCriterion("kpis in", values, "kpis");
            return (Criteria) this;
        }

        public Criteria andKpisNotIn(List<String> values) {
            addCriterion("kpis not in", values, "kpis");
            return (Criteria) this;
        }

        public Criteria andKpisBetween(String value1, String value2) {
            addCriterion("kpis between", value1, value2, "kpis");
            return (Criteria) this;
        }

        public Criteria andKpisNotBetween(String value1, String value2) {
            addCriterion("kpis not between", value1, value2, "kpis");
            return (Criteria) this;
        }

        public Criteria andAidIsNull() {
            addCriterion("aId is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("aId is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(String value) {
            addCriterion("aId =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(String value) {
            addCriterion("aId <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(String value) {
            addCriterion("aId >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(String value) {
            addCriterion("aId >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(String value) {
            addCriterion("aId <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(String value) {
            addCriterion("aId <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLike(String value) {
            addCriterion("aId like", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotLike(String value) {
            addCriterion("aId not like", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<String> values) {
            addCriterion("aId in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<String> values) {
            addCriterion("aId not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(String value1, String value2) {
            addCriterion("aId between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(String value1, String value2) {
            addCriterion("aId not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andSourceaffiliateidIsNull() {
            addCriterion("sourceAffiliateId is null");
            return (Criteria) this;
        }

        public Criteria andSourceaffiliateidIsNotNull() {
            addCriterion("sourceAffiliateId is not null");
            return (Criteria) this;
        }

        public Criteria andSourceaffiliateidEqualTo(Short value) {
            addCriterion("sourceAffiliateId =", value, "sourceaffiliateid");
            return (Criteria) this;
        }

        public Criteria andSourceaffiliateidNotEqualTo(Short value) {
            addCriterion("sourceAffiliateId <>", value, "sourceaffiliateid");
            return (Criteria) this;
        }

        public Criteria andSourceaffiliateidGreaterThan(Short value) {
            addCriterion("sourceAffiliateId >", value, "sourceaffiliateid");
            return (Criteria) this;
        }

        public Criteria andSourceaffiliateidGreaterThanOrEqualTo(Short value) {
            addCriterion("sourceAffiliateId >=", value, "sourceaffiliateid");
            return (Criteria) this;
        }

        public Criteria andSourceaffiliateidLessThan(Short value) {
            addCriterion("sourceAffiliateId <", value, "sourceaffiliateid");
            return (Criteria) this;
        }

        public Criteria andSourceaffiliateidLessThanOrEqualTo(Short value) {
            addCriterion("sourceAffiliateId <=", value, "sourceaffiliateid");
            return (Criteria) this;
        }

        public Criteria andSourceaffiliateidIn(List<Short> values) {
            addCriterion("sourceAffiliateId in", values, "sourceaffiliateid");
            return (Criteria) this;
        }

        public Criteria andSourceaffiliateidNotIn(List<Short> values) {
            addCriterion("sourceAffiliateId not in", values, "sourceaffiliateid");
            return (Criteria) this;
        }

        public Criteria andSourceaffiliateidBetween(Short value1, Short value2) {
            addCriterion("sourceAffiliateId between", value1, value2, "sourceaffiliateid");
            return (Criteria) this;
        }

        public Criteria andSourceaffiliateidNotBetween(Short value1, Short value2) {
            addCriterion("sourceAffiliateId not between", value1, value2, "sourceaffiliateid");
            return (Criteria) this;
        }

        public Criteria andSourceofferidIsNull() {
            addCriterion("sourceOfferId is null");
            return (Criteria) this;
        }

        public Criteria andSourceofferidIsNotNull() {
            addCriterion("sourceOfferId is not null");
            return (Criteria) this;
        }

        public Criteria andSourceofferidEqualTo(String value) {
            addCriterion("sourceOfferId =", value, "sourceofferid");
            return (Criteria) this;
        }

        public Criteria andSourceofferidNotEqualTo(String value) {
            addCriterion("sourceOfferId <>", value, "sourceofferid");
            return (Criteria) this;
        }

        public Criteria andSourceofferidGreaterThan(String value) {
            addCriterion("sourceOfferId >", value, "sourceofferid");
            return (Criteria) this;
        }

        public Criteria andSourceofferidGreaterThanOrEqualTo(String value) {
            addCriterion("sourceOfferId >=", value, "sourceofferid");
            return (Criteria) this;
        }

        public Criteria andSourceofferidLessThan(String value) {
            addCriterion("sourceOfferId <", value, "sourceofferid");
            return (Criteria) this;
        }

        public Criteria andSourceofferidLessThanOrEqualTo(String value) {
            addCriterion("sourceOfferId <=", value, "sourceofferid");
            return (Criteria) this;
        }

        public Criteria andSourceofferidLike(String value) {
            addCriterion("sourceOfferId like", value, "sourceofferid");
            return (Criteria) this;
        }

        public Criteria andSourceofferidNotLike(String value) {
            addCriterion("sourceOfferId not like", value, "sourceofferid");
            return (Criteria) this;
        }

        public Criteria andSourceofferidIn(List<String> values) {
            addCriterion("sourceOfferId in", values, "sourceofferid");
            return (Criteria) this;
        }

        public Criteria andSourceofferidNotIn(List<String> values) {
            addCriterion("sourceOfferId not in", values, "sourceofferid");
            return (Criteria) this;
        }

        public Criteria andSourceofferidBetween(String value1, String value2) {
            addCriterion("sourceOfferId between", value1, value2, "sourceofferid");
            return (Criteria) this;
        }

        public Criteria andSourceofferidNotBetween(String value1, String value2) {
            addCriterion("sourceOfferId not between", value1, value2, "sourceofferid");
            return (Criteria) this;
        }

        public Criteria andModifyuserIsNull() {
            addCriterion("modifyUser is null");
            return (Criteria) this;
        }

        public Criteria andModifyuserIsNotNull() {
            addCriterion("modifyUser is not null");
            return (Criteria) this;
        }

        public Criteria andModifyuserEqualTo(String value) {
            addCriterion("modifyUser =", value, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserNotEqualTo(String value) {
            addCriterion("modifyUser <>", value, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserGreaterThan(String value) {
            addCriterion("modifyUser >", value, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserGreaterThanOrEqualTo(String value) {
            addCriterion("modifyUser >=", value, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserLessThan(String value) {
            addCriterion("modifyUser <", value, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserLessThanOrEqualTo(String value) {
            addCriterion("modifyUser <=", value, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserLike(String value) {
            addCriterion("modifyUser like", value, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserNotLike(String value) {
            addCriterion("modifyUser not like", value, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserIn(List<String> values) {
            addCriterion("modifyUser in", values, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserNotIn(List<String> values) {
            addCriterion("modifyUser not in", values, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserBetween(String value1, String value2) {
            addCriterion("modifyUser between", value1, value2, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifyuserNotBetween(String value1, String value2) {
            addCriterion("modifyUser not between", value1, value2, "modifyuser");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNull() {
            addCriterion("modifyTime is null");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNotNull() {
            addCriterion("modifyTime is not null");
            return (Criteria) this;
        }

        public Criteria andModifytimeEqualTo(Date value) {
            addCriterion("modifyTime =", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotEqualTo(Date value) {
            addCriterion("modifyTime <>", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThan(Date value) {
            addCriterion("modifyTime >", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modifyTime >=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThan(Date value) {
            addCriterion("modifyTime <", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThanOrEqualTo(Date value) {
            addCriterion("modifyTime <=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeIn(List<Date> values) {
            addCriterion("modifyTime in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotIn(List<Date> values) {
            addCriterion("modifyTime not in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeBetween(Date value1, Date value2) {
            addCriterion("modifyTime between", value1, value2, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotBetween(Date value1, Date value2) {
            addCriterion("modifyTime not between", value1, value2, "modifytime");
            return (Criteria) this;
        }

        public Criteria andPlatformwhitelistIsNull() {
            addCriterion("platformwhitelist is null");
            return (Criteria) this;
        }

        public Criteria andPlatformwhitelistIsNotNull() {
            addCriterion("platformwhitelist is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformwhitelistEqualTo(String value) {
            addCriterion("platformwhitelist =", value, "platformwhitelist");
            return (Criteria) this;
        }

        public Criteria andPlatformwhitelistNotEqualTo(String value) {
            addCriterion("platformwhitelist <>", value, "platformwhitelist");
            return (Criteria) this;
        }

        public Criteria andPlatformwhitelistGreaterThan(String value) {
            addCriterion("platformwhitelist >", value, "platformwhitelist");
            return (Criteria) this;
        }

        public Criteria andPlatformwhitelistGreaterThanOrEqualTo(String value) {
            addCriterion("platformwhitelist >=", value, "platformwhitelist");
            return (Criteria) this;
        }

        public Criteria andPlatformwhitelistLessThan(String value) {
            addCriterion("platformwhitelist <", value, "platformwhitelist");
            return (Criteria) this;
        }

        public Criteria andPlatformwhitelistLessThanOrEqualTo(String value) {
            addCriterion("platformwhitelist <=", value, "platformwhitelist");
            return (Criteria) this;
        }

        public Criteria andPlatformwhitelistLike(String value) {
            addCriterion("platformwhitelist like", value, "platformwhitelist");
            return (Criteria) this;
        }

        public Criteria andPlatformwhitelistNotLike(String value) {
            addCriterion("platformwhitelist not like", value, "platformwhitelist");
            return (Criteria) this;
        }

        public Criteria andPlatformwhitelistIn(List<String> values) {
            addCriterion("platformwhitelist in", values, "platformwhitelist");
            return (Criteria) this;
        }

        public Criteria andPlatformwhitelistNotIn(List<String> values) {
            addCriterion("platformwhitelist not in", values, "platformwhitelist");
            return (Criteria) this;
        }

        public Criteria andPlatformwhitelistBetween(String value1, String value2) {
            addCriterion("platformwhitelist between", value1, value2, "platformwhitelist");
            return (Criteria) this;
        }

        public Criteria andPlatformwhitelistNotBetween(String value1, String value2) {
            addCriterion("platformwhitelist not between", value1, value2, "platformwhitelist");
            return (Criteria) this;
        }

        public Criteria andTrackurlextIsNull() {
            addCriterion("trackUrlExt is null");
            return (Criteria) this;
        }

        public Criteria andTrackurlextIsNotNull() {
            addCriterion("trackUrlExt is not null");
            return (Criteria) this;
        }

        public Criteria andTrackurlextEqualTo(String value) {
            addCriterion("trackUrlExt =", value, "trackurlext");
            return (Criteria) this;
        }

        public Criteria andTrackurlextNotEqualTo(String value) {
            addCriterion("trackUrlExt <>", value, "trackurlext");
            return (Criteria) this;
        }

        public Criteria andTrackurlextGreaterThan(String value) {
            addCriterion("trackUrlExt >", value, "trackurlext");
            return (Criteria) this;
        }

        public Criteria andTrackurlextGreaterThanOrEqualTo(String value) {
            addCriterion("trackUrlExt >=", value, "trackurlext");
            return (Criteria) this;
        }

        public Criteria andTrackurlextLessThan(String value) {
            addCriterion("trackUrlExt <", value, "trackurlext");
            return (Criteria) this;
        }

        public Criteria andTrackurlextLessThanOrEqualTo(String value) {
            addCriterion("trackUrlExt <=", value, "trackurlext");
            return (Criteria) this;
        }

        public Criteria andTrackurlextLike(String value) {
            addCriterion("trackUrlExt like", value, "trackurlext");
            return (Criteria) this;
        }

        public Criteria andTrackurlextNotLike(String value) {
            addCriterion("trackUrlExt not like", value, "trackurlext");
            return (Criteria) this;
        }

        public Criteria andTrackurlextIn(List<String> values) {
            addCriterion("trackUrlExt in", values, "trackurlext");
            return (Criteria) this;
        }

        public Criteria andTrackurlextNotIn(List<String> values) {
            addCriterion("trackUrlExt not in", values, "trackurlext");
            return (Criteria) this;
        }

        public Criteria andTrackurlextBetween(String value1, String value2) {
            addCriterion("trackUrlExt between", value1, value2, "trackurlext");
            return (Criteria) this;
        }

        public Criteria andTrackurlextNotBetween(String value1, String value2) {
            addCriterion("trackUrlExt not between", value1, value2, "trackurlext");
            return (Criteria) this;
        }

        public Criteria andImprurlIsNull() {
            addCriterion("imprurl is null");
            return (Criteria) this;
        }

        public Criteria andImprurlIsNotNull() {
            addCriterion("imprurl is not null");
            return (Criteria) this;
        }

        public Criteria andImprurlEqualTo(String value) {
            addCriterion("imprurl =", value, "imprurl");
            return (Criteria) this;
        }

        public Criteria andImprurlNotEqualTo(String value) {
            addCriterion("imprurl <>", value, "imprurl");
            return (Criteria) this;
        }

        public Criteria andImprurlGreaterThan(String value) {
            addCriterion("imprurl >", value, "imprurl");
            return (Criteria) this;
        }

        public Criteria andImprurlGreaterThanOrEqualTo(String value) {
            addCriterion("imprurl >=", value, "imprurl");
            return (Criteria) this;
        }

        public Criteria andImprurlLessThan(String value) {
            addCriterion("imprurl <", value, "imprurl");
            return (Criteria) this;
        }

        public Criteria andImprurlLessThanOrEqualTo(String value) {
            addCriterion("imprurl <=", value, "imprurl");
            return (Criteria) this;
        }

        public Criteria andImprurlLike(String value) {
            addCriterion("imprurl like", value, "imprurl");
            return (Criteria) this;
        }

        public Criteria andImprurlNotLike(String value) {
            addCriterion("imprurl not like", value, "imprurl");
            return (Criteria) this;
        }

        public Criteria andImprurlIn(List<String> values) {
            addCriterion("imprurl in", values, "imprurl");
            return (Criteria) this;
        }

        public Criteria andImprurlNotIn(List<String> values) {
            addCriterion("imprurl not in", values, "imprurl");
            return (Criteria) this;
        }

        public Criteria andImprurlBetween(String value1, String value2) {
            addCriterion("imprurl between", value1, value2, "imprurl");
            return (Criteria) this;
        }

        public Criteria andImprurlNotBetween(String value1, String value2) {
            addCriterion("imprurl not between", value1, value2, "imprurl");
            return (Criteria) this;
        }

        public Criteria andCategorynameIsNull() {
            addCriterion("categoryname is null");
            return (Criteria) this;
        }

        public Criteria andCategorynameIsNotNull() {
            addCriterion("categoryname is not null");
            return (Criteria) this;
        }

        public Criteria andCategorynameEqualTo(String value) {
            addCriterion("categoryname =", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameNotEqualTo(String value) {
            addCriterion("categoryname <>", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameGreaterThan(String value) {
            addCriterion("categoryname >", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameGreaterThanOrEqualTo(String value) {
            addCriterion("categoryname >=", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameLessThan(String value) {
            addCriterion("categoryname <", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameLessThanOrEqualTo(String value) {
            addCriterion("categoryname <=", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameLike(String value) {
            addCriterion("categoryname like", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameNotLike(String value) {
            addCriterion("categoryname not like", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameIn(List<String> values) {
            addCriterion("categoryname in", values, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameNotIn(List<String> values) {
            addCriterion("categoryname not in", values, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameBetween(String value1, String value2) {
            addCriterion("categoryname between", value1, value2, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameNotBetween(String value1, String value2) {
            addCriterion("categoryname not between", value1, value2, "categoryname");
            return (Criteria) this;
        }

        public Criteria andRisklevelIsNull() {
            addCriterion("risklevel is null");
            return (Criteria) this;
        }

        public Criteria andRisklevelIsNotNull() {
            addCriterion("risklevel is not null");
            return (Criteria) this;
        }

        public Criteria andRisklevelEqualTo(Integer value) {
            addCriterion("risklevel =", value, "risklevel");
            return (Criteria) this;
        }

        public Criteria andRisklevelNotEqualTo(Integer value) {
            addCriterion("risklevel <>", value, "risklevel");
            return (Criteria) this;
        }

        public Criteria andRisklevelGreaterThan(Integer value) {
            addCriterion("risklevel >", value, "risklevel");
            return (Criteria) this;
        }

        public Criteria andRisklevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("risklevel >=", value, "risklevel");
            return (Criteria) this;
        }

        public Criteria andRisklevelLessThan(Integer value) {
            addCriterion("risklevel <", value, "risklevel");
            return (Criteria) this;
        }

        public Criteria andRisklevelLessThanOrEqualTo(Integer value) {
            addCriterion("risklevel <=", value, "risklevel");
            return (Criteria) this;
        }

        public Criteria andRisklevelIn(List<Integer> values) {
            addCriterion("risklevel in", values, "risklevel");
            return (Criteria) this;
        }

        public Criteria andRisklevelNotIn(List<Integer> values) {
            addCriterion("risklevel not in", values, "risklevel");
            return (Criteria) this;
        }

        public Criteria andRisklevelBetween(Integer value1, Integer value2) {
            addCriterion("risklevel between", value1, value2, "risklevel");
            return (Criteria) this;
        }

        public Criteria andRisklevelNotBetween(Integer value1, Integer value2) {
            addCriterion("risklevel not between", value1, value2, "risklevel");
            return (Criteria) this;
        }

        public Criteria andTeststatusIsNull() {
            addCriterion("testStatus is null");
            return (Criteria) this;
        }

        public Criteria andTeststatusIsNotNull() {
            addCriterion("testStatus is not null");
            return (Criteria) this;
        }

        public Criteria andTeststatusEqualTo(Integer value) {
            addCriterion("testStatus =", value, "teststatus");
            return (Criteria) this;
        }

        public Criteria andTeststatusNotEqualTo(Integer value) {
            addCriterion("testStatus <>", value, "teststatus");
            return (Criteria) this;
        }

        public Criteria andTeststatusGreaterThan(Integer value) {
            addCriterion("testStatus >", value, "teststatus");
            return (Criteria) this;
        }

        public Criteria andTeststatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("testStatus >=", value, "teststatus");
            return (Criteria) this;
        }

        public Criteria andTeststatusLessThan(Integer value) {
            addCriterion("testStatus <", value, "teststatus");
            return (Criteria) this;
        }

        public Criteria andTeststatusLessThanOrEqualTo(Integer value) {
            addCriterion("testStatus <=", value, "teststatus");
            return (Criteria) this;
        }

        public Criteria andTeststatusIn(List<Integer> values) {
            addCriterion("testStatus in", values, "teststatus");
            return (Criteria) this;
        }

        public Criteria andTeststatusNotIn(List<Integer> values) {
            addCriterion("testStatus not in", values, "teststatus");
            return (Criteria) this;
        }

        public Criteria andTeststatusBetween(Integer value1, Integer value2) {
            addCriterion("testStatus between", value1, value2, "teststatus");
            return (Criteria) this;
        }

        public Criteria andTeststatusNotBetween(Integer value1, Integer value2) {
            addCriterion("testStatus not between", value1, value2, "teststatus");
            return (Criteria) this;
        }

        public Criteria andAsyncidIsNull() {
            addCriterion("asyncId is null");
            return (Criteria) this;
        }

        public Criteria andAsyncidIsNotNull() {
            addCriterion("asyncId is not null");
            return (Criteria) this;
        }

        public Criteria andAsyncidEqualTo(String value) {
            addCriterion("asyncId =", value, "asyncid");
            return (Criteria) this;
        }

        public Criteria andAsyncidNotEqualTo(String value) {
            addCriterion("asyncId <>", value, "asyncid");
            return (Criteria) this;
        }

        public Criteria andAsyncidGreaterThan(String value) {
            addCriterion("asyncId >", value, "asyncid");
            return (Criteria) this;
        }

        public Criteria andAsyncidGreaterThanOrEqualTo(String value) {
            addCriterion("asyncId >=", value, "asyncid");
            return (Criteria) this;
        }

        public Criteria andAsyncidLessThan(String value) {
            addCriterion("asyncId <", value, "asyncid");
            return (Criteria) this;
        }

        public Criteria andAsyncidLessThanOrEqualTo(String value) {
            addCriterion("asyncId <=", value, "asyncid");
            return (Criteria) this;
        }

        public Criteria andAsyncidLike(String value) {
            addCriterion("asyncId like", value, "asyncid");
            return (Criteria) this;
        }

        public Criteria andAsyncidNotLike(String value) {
            addCriterion("asyncId not like", value, "asyncid");
            return (Criteria) this;
        }

        public Criteria andAsyncidIn(List<String> values) {
            addCriterion("asyncId in", values, "asyncid");
            return (Criteria) this;
        }

        public Criteria andAsyncidNotIn(List<String> values) {
            addCriterion("asyncId not in", values, "asyncid");
            return (Criteria) this;
        }

        public Criteria andAsyncidBetween(String value1, String value2) {
            addCriterion("asyncId between", value1, value2, "asyncid");
            return (Criteria) this;
        }

        public Criteria andAsyncidNotBetween(String value1, String value2) {
            addCriterion("asyncId not between", value1, value2, "asyncid");
            return (Criteria) this;
        }

        public Criteria andTesttimeIsNull() {
            addCriterion("testtime is null");
            return (Criteria) this;
        }

        public Criteria andTesttimeIsNotNull() {
            addCriterion("testtime is not null");
            return (Criteria) this;
        }

        public Criteria andTesttimeEqualTo(Date value) {
            addCriterion("testtime =", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeNotEqualTo(Date value) {
            addCriterion("testtime <>", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeGreaterThan(Date value) {
            addCriterion("testtime >", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("testtime >=", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeLessThan(Date value) {
            addCriterion("testtime <", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeLessThanOrEqualTo(Date value) {
            addCriterion("testtime <=", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeIn(List<Date> values) {
            addCriterion("testtime in", values, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeNotIn(List<Date> values) {
            addCriterion("testtime not in", values, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeBetween(Date value1, Date value2) {
            addCriterion("testtime between", value1, value2, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeNotBetween(Date value1, Date value2) {
            addCriterion("testtime not between", value1, value2, "testtime");
            return (Criteria) this;
        }

        public Criteria andAutosubidIsNull() {
            addCriterion("autosubid is null");
            return (Criteria) this;
        }

        public Criteria andAutosubidIsNotNull() {
            addCriterion("autosubid is not null");
            return (Criteria) this;
        }

        public Criteria andAutosubidEqualTo(Integer value) {
            addCriterion("autosubid =", value, "autosubid");
            return (Criteria) this;
        }

        public Criteria andAutosubidNotEqualTo(Integer value) {
            addCriterion("autosubid <>", value, "autosubid");
            return (Criteria) this;
        }

        public Criteria andAutosubidGreaterThan(Integer value) {
            addCriterion("autosubid >", value, "autosubid");
            return (Criteria) this;
        }

        public Criteria andAutosubidGreaterThanOrEqualTo(Integer value) {
            addCriterion("autosubid >=", value, "autosubid");
            return (Criteria) this;
        }

        public Criteria andAutosubidLessThan(Integer value) {
            addCriterion("autosubid <", value, "autosubid");
            return (Criteria) this;
        }

        public Criteria andAutosubidLessThanOrEqualTo(Integer value) {
            addCriterion("autosubid <=", value, "autosubid");
            return (Criteria) this;
        }

        public Criteria andAutosubidIn(List<Integer> values) {
            addCriterion("autosubid in", values, "autosubid");
            return (Criteria) this;
        }

        public Criteria andAutosubidNotIn(List<Integer> values) {
            addCriterion("autosubid not in", values, "autosubid");
            return (Criteria) this;
        }

        public Criteria andAutosubidBetween(Integer value1, Integer value2) {
            addCriterion("autosubid between", value1, value2, "autosubid");
            return (Criteria) this;
        }

        public Criteria andAutosubidNotBetween(Integer value1, Integer value2) {
            addCriterion("autosubid not between", value1, value2, "autosubid");
            return (Criteria) this;
        }

        public Criteria andAutoadjustIsNull() {
            addCriterion("autoadjust is null");
            return (Criteria) this;
        }

        public Criteria andAutoadjustIsNotNull() {
            addCriterion("autoadjust is not null");
            return (Criteria) this;
        }

        public Criteria andAutoadjustEqualTo(Integer value) {
            addCriterion("autoadjust =", value, "autoadjust");
            return (Criteria) this;
        }

        public Criteria andAutoadjustNotEqualTo(Integer value) {
            addCriterion("autoadjust <>", value, "autoadjust");
            return (Criteria) this;
        }

        public Criteria andAutoadjustGreaterThan(Integer value) {
            addCriterion("autoadjust >", value, "autoadjust");
            return (Criteria) this;
        }

        public Criteria andAutoadjustGreaterThanOrEqualTo(Integer value) {
            addCriterion("autoadjust >=", value, "autoadjust");
            return (Criteria) this;
        }

        public Criteria andAutoadjustLessThan(Integer value) {
            addCriterion("autoadjust <", value, "autoadjust");
            return (Criteria) this;
        }

        public Criteria andAutoadjustLessThanOrEqualTo(Integer value) {
            addCriterion("autoadjust <=", value, "autoadjust");
            return (Criteria) this;
        }

        public Criteria andAutoadjustIn(List<Integer> values) {
            addCriterion("autoadjust in", values, "autoadjust");
            return (Criteria) this;
        }

        public Criteria andAutoadjustNotIn(List<Integer> values) {
            addCriterion("autoadjust not in", values, "autoadjust");
            return (Criteria) this;
        }

        public Criteria andAutoadjustBetween(Integer value1, Integer value2) {
            addCriterion("autoadjust between", value1, value2, "autoadjust");
            return (Criteria) this;
        }

        public Criteria andAutoadjustNotBetween(Integer value1, Integer value2) {
            addCriterion("autoadjust not between", value1, value2, "autoadjust");
            return (Criteria) this;
        }

        public Criteria andAutomonitorIsNull() {
            addCriterion("automonitor is null");
            return (Criteria) this;
        }

        public Criteria andAutomonitorIsNotNull() {
            addCriterion("automonitor is not null");
            return (Criteria) this;
        }

        public Criteria andAutomonitorEqualTo(Integer value) {
            addCriterion("automonitor =", value, "automonitor");
            return (Criteria) this;
        }

        public Criteria andAutomonitorNotEqualTo(Integer value) {
            addCriterion("automonitor <>", value, "automonitor");
            return (Criteria) this;
        }

        public Criteria andAutomonitorGreaterThan(Integer value) {
            addCriterion("automonitor >", value, "automonitor");
            return (Criteria) this;
        }

        public Criteria andAutomonitorGreaterThanOrEqualTo(Integer value) {
            addCriterion("automonitor >=", value, "automonitor");
            return (Criteria) this;
        }

        public Criteria andAutomonitorLessThan(Integer value) {
            addCriterion("automonitor <", value, "automonitor");
            return (Criteria) this;
        }

        public Criteria andAutomonitorLessThanOrEqualTo(Integer value) {
            addCriterion("automonitor <=", value, "automonitor");
            return (Criteria) this;
        }

        public Criteria andAutomonitorIn(List<Integer> values) {
            addCriterion("automonitor in", values, "automonitor");
            return (Criteria) this;
        }

        public Criteria andAutomonitorNotIn(List<Integer> values) {
            addCriterion("automonitor not in", values, "automonitor");
            return (Criteria) this;
        }

        public Criteria andAutomonitorBetween(Integer value1, Integer value2) {
            addCriterion("automonitor between", value1, value2, "automonitor");
            return (Criteria) this;
        }

        public Criteria andAutomonitorNotBetween(Integer value1, Integer value2) {
            addCriterion("automonitor not between", value1, value2, "automonitor");
            return (Criteria) this;
        }

        public Criteria andIsmanualIsNull() {
            addCriterion("ismanual is null");
            return (Criteria) this;
        }

        public Criteria andIsmanualIsNotNull() {
            addCriterion("ismanual is not null");
            return (Criteria) this;
        }

        public Criteria andIsmanualEqualTo(Boolean value) {
            addCriterion("ismanual =", value, "ismanual");
            return (Criteria) this;
        }

        public Criteria andIsmanualNotEqualTo(Boolean value) {
            addCriterion("ismanual <>", value, "ismanual");
            return (Criteria) this;
        }

        public Criteria andIsmanualGreaterThan(Boolean value) {
            addCriterion("ismanual >", value, "ismanual");
            return (Criteria) this;
        }

        public Criteria andIsmanualGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ismanual >=", value, "ismanual");
            return (Criteria) this;
        }

        public Criteria andIsmanualLessThan(Boolean value) {
            addCriterion("ismanual <", value, "ismanual");
            return (Criteria) this;
        }

        public Criteria andIsmanualLessThanOrEqualTo(Boolean value) {
            addCriterion("ismanual <=", value, "ismanual");
            return (Criteria) this;
        }

        public Criteria andIsmanualIn(List<Boolean> values) {
            addCriterion("ismanual in", values, "ismanual");
            return (Criteria) this;
        }

        public Criteria andIsmanualNotIn(List<Boolean> values) {
            addCriterion("ismanual not in", values, "ismanual");
            return (Criteria) this;
        }

        public Criteria andIsmanualBetween(Boolean value1, Boolean value2) {
            addCriterion("ismanual between", value1, value2, "ismanual");
            return (Criteria) this;
        }

        public Criteria andIsmanualNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ismanual not between", value1, value2, "ismanual");
            return (Criteria) this;
        }

        public Criteria andIsappidIsNull() {
            addCriterion("isappid is null");
            return (Criteria) this;
        }

        public Criteria andIsappidIsNotNull() {
            addCriterion("isappid is not null");
            return (Criteria) this;
        }

        public Criteria andIsappidEqualTo(Boolean value) {
            addCriterion("isappid =", value, "isappid");
            return (Criteria) this;
        }

        public Criteria andIsappidNotEqualTo(Boolean value) {
            addCriterion("isappid <>", value, "isappid");
            return (Criteria) this;
        }

        public Criteria andIsappidGreaterThan(Boolean value) {
            addCriterion("isappid >", value, "isappid");
            return (Criteria) this;
        }

        public Criteria andIsappidGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isappid >=", value, "isappid");
            return (Criteria) this;
        }

        public Criteria andIsappidLessThan(Boolean value) {
            addCriterion("isappid <", value, "isappid");
            return (Criteria) this;
        }

        public Criteria andIsappidLessThanOrEqualTo(Boolean value) {
            addCriterion("isappid <=", value, "isappid");
            return (Criteria) this;
        }

        public Criteria andIsappidIn(List<Boolean> values) {
            addCriterion("isappid in", values, "isappid");
            return (Criteria) this;
        }

        public Criteria andIsappidNotIn(List<Boolean> values) {
            addCriterion("isappid not in", values, "isappid");
            return (Criteria) this;
        }

        public Criteria andIsappidBetween(Boolean value1, Boolean value2) {
            addCriterion("isappid between", value1, value2, "isappid");
            return (Criteria) this;
        }

        public Criteria andIsappidNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isappid not between", value1, value2, "isappid");
            return (Criteria) this;
        }

        public Criteria andIsattrsIsNull() {
            addCriterion("isattrs is null");
            return (Criteria) this;
        }

        public Criteria andIsattrsIsNotNull() {
            addCriterion("isattrs is not null");
            return (Criteria) this;
        }

        public Criteria andIsattrsEqualTo(Boolean value) {
            addCriterion("isattrs =", value, "isattrs");
            return (Criteria) this;
        }

        public Criteria andIsattrsNotEqualTo(Boolean value) {
            addCriterion("isattrs <>", value, "isattrs");
            return (Criteria) this;
        }

        public Criteria andIsattrsGreaterThan(Boolean value) {
            addCriterion("isattrs >", value, "isattrs");
            return (Criteria) this;
        }

        public Criteria andIsattrsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isattrs >=", value, "isattrs");
            return (Criteria) this;
        }

        public Criteria andIsattrsLessThan(Boolean value) {
            addCriterion("isattrs <", value, "isattrs");
            return (Criteria) this;
        }

        public Criteria andIsattrsLessThanOrEqualTo(Boolean value) {
            addCriterion("isattrs <=", value, "isattrs");
            return (Criteria) this;
        }

        public Criteria andIsattrsIn(List<Boolean> values) {
            addCriterion("isattrs in", values, "isattrs");
            return (Criteria) this;
        }

        public Criteria andIsattrsNotIn(List<Boolean> values) {
            addCriterion("isattrs not in", values, "isattrs");
            return (Criteria) this;
        }

        public Criteria andIsattrsBetween(Boolean value1, Boolean value2) {
            addCriterion("isattrs between", value1, value2, "isattrs");
            return (Criteria) this;
        }

        public Criteria andIsattrsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isattrs not between", value1, value2, "isattrs");
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