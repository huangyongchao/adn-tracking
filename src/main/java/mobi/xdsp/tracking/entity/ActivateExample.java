package mobi.xdsp.tracking.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ActivateExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andDeviceidIsNull() {
            addCriterion("deviceId is null");
            return (Criteria) this;
        }

        public Criteria andDeviceidIsNotNull() {
            addCriterion("deviceId is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceidEqualTo(String value) {
            addCriterion("deviceId =", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotEqualTo(String value) {
            addCriterion("deviceId <>", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThan(String value) {
            addCriterion("deviceId >", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThanOrEqualTo(String value) {
            addCriterion("deviceId >=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThan(String value) {
            addCriterion("deviceId <", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThanOrEqualTo(String value) {
            addCriterion("deviceId <=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLike(String value) {
            addCriterion("deviceId like", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotLike(String value) {
            addCriterion("deviceId not like", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidIn(List<String> values) {
            addCriterion("deviceId in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotIn(List<String> values) {
            addCriterion("deviceId not in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidBetween(String value1, String value2) {
            addCriterion("deviceId between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotBetween(String value1, String value2) {
            addCriterion("deviceId not between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andActivatedateIsNull() {
            addCriterion("activateDate is null");
            return (Criteria) this;
        }

        public Criteria andActivatedateIsNotNull() {
            addCriterion("activateDate is not null");
            return (Criteria) this;
        }

        public Criteria andActivatedateEqualTo(String value) {
            addCriterion("activateDate =", value, "activatedate");
            return (Criteria) this;
        }

        public Criteria andActivatedateNotEqualTo(String value) {
            addCriterion("activateDate <>", value, "activatedate");
            return (Criteria) this;
        }

        public Criteria andActivatedateGreaterThan(String value) {
            addCriterion("activateDate >", value, "activatedate");
            return (Criteria) this;
        }

        public Criteria andActivatedateGreaterThanOrEqualTo(String value) {
            addCriterion("activateDate >=", value, "activatedate");
            return (Criteria) this;
        }

        public Criteria andActivatedateLessThan(String value) {
            addCriterion("activateDate <", value, "activatedate");
            return (Criteria) this;
        }

        public Criteria andActivatedateLessThanOrEqualTo(String value) {
            addCriterion("activateDate <=", value, "activatedate");
            return (Criteria) this;
        }

        public Criteria andActivatedateLike(String value) {
            addCriterion("activateDate like", value, "activatedate");
            return (Criteria) this;
        }

        public Criteria andActivatedateNotLike(String value) {
            addCriterion("activateDate not like", value, "activatedate");
            return (Criteria) this;
        }

        public Criteria andActivatedateIn(List<String> values) {
            addCriterion("activateDate in", values, "activatedate");
            return (Criteria) this;
        }

        public Criteria andActivatedateNotIn(List<String> values) {
            addCriterion("activateDate not in", values, "activatedate");
            return (Criteria) this;
        }

        public Criteria andActivatedateBetween(String value1, String value2) {
            addCriterion("activateDate between", value1, value2, "activatedate");
            return (Criteria) this;
        }

        public Criteria andActivatedateNotBetween(String value1, String value2) {
            addCriterion("activateDate not between", value1, value2, "activatedate");
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

        public Criteria andClickserveridIsNull() {
            addCriterion("clickServerId is null");
            return (Criteria) this;
        }

        public Criteria andClickserveridIsNotNull() {
            addCriterion("clickServerId is not null");
            return (Criteria) this;
        }

        public Criteria andClickserveridEqualTo(String value) {
            addCriterion("clickServerId =", value, "clickserverid");
            return (Criteria) this;
        }

        public Criteria andClickserveridNotEqualTo(String value) {
            addCriterion("clickServerId <>", value, "clickserverid");
            return (Criteria) this;
        }

        public Criteria andClickserveridGreaterThan(String value) {
            addCriterion("clickServerId >", value, "clickserverid");
            return (Criteria) this;
        }

        public Criteria andClickserveridGreaterThanOrEqualTo(String value) {
            addCriterion("clickServerId >=", value, "clickserverid");
            return (Criteria) this;
        }

        public Criteria andClickserveridLessThan(String value) {
            addCriterion("clickServerId <", value, "clickserverid");
            return (Criteria) this;
        }

        public Criteria andClickserveridLessThanOrEqualTo(String value) {
            addCriterion("clickServerId <=", value, "clickserverid");
            return (Criteria) this;
        }

        public Criteria andClickserveridLike(String value) {
            addCriterion("clickServerId like", value, "clickserverid");
            return (Criteria) this;
        }

        public Criteria andClickserveridNotLike(String value) {
            addCriterion("clickServerId not like", value, "clickserverid");
            return (Criteria) this;
        }

        public Criteria andClickserveridIn(List<String> values) {
            addCriterion("clickServerId in", values, "clickserverid");
            return (Criteria) this;
        }

        public Criteria andClickserveridNotIn(List<String> values) {
            addCriterion("clickServerId not in", values, "clickserverid");
            return (Criteria) this;
        }

        public Criteria andClickserveridBetween(String value1, String value2) {
            addCriterion("clickServerId between", value1, value2, "clickserverid");
            return (Criteria) this;
        }

        public Criteria andClickserveridNotBetween(String value1, String value2) {
            addCriterion("clickServerId not between", value1, value2, "clickserverid");
            return (Criteria) this;
        }

        public Criteria andClicktimeIsNull() {
            addCriterion("clickTime is null");
            return (Criteria) this;
        }

        public Criteria andClicktimeIsNotNull() {
            addCriterion("clickTime is not null");
            return (Criteria) this;
        }

        public Criteria andClicktimeEqualTo(String value) {
            addCriterion("clickTime =", value, "clicktime");
            return (Criteria) this;
        }

        public Criteria andClicktimeNotEqualTo(String value) {
            addCriterion("clickTime <>", value, "clicktime");
            return (Criteria) this;
        }

        public Criteria andClicktimeGreaterThan(String value) {
            addCriterion("clickTime >", value, "clicktime");
            return (Criteria) this;
        }

        public Criteria andClicktimeGreaterThanOrEqualTo(String value) {
            addCriterion("clickTime >=", value, "clicktime");
            return (Criteria) this;
        }

        public Criteria andClicktimeLessThan(String value) {
            addCriterion("clickTime <", value, "clicktime");
            return (Criteria) this;
        }

        public Criteria andClicktimeLessThanOrEqualTo(String value) {
            addCriterion("clickTime <=", value, "clicktime");
            return (Criteria) this;
        }

        public Criteria andClicktimeLike(String value) {
            addCriterion("clickTime like", value, "clicktime");
            return (Criteria) this;
        }

        public Criteria andClicktimeNotLike(String value) {
            addCriterion("clickTime not like", value, "clicktime");
            return (Criteria) this;
        }

        public Criteria andClicktimeIn(List<String> values) {
            addCriterion("clickTime in", values, "clicktime");
            return (Criteria) this;
        }

        public Criteria andClicktimeNotIn(List<String> values) {
            addCriterion("clickTime not in", values, "clicktime");
            return (Criteria) this;
        }

        public Criteria andClicktimeBetween(String value1, String value2) {
            addCriterion("clickTime between", value1, value2, "clicktime");
            return (Criteria) this;
        }

        public Criteria andClicktimeNotBetween(String value1, String value2) {
            addCriterion("clickTime not between", value1, value2, "clicktime");
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

        public Criteria andAffiliateidEqualTo(String value) {
            addCriterion("affiliateId =", value, "affiliateid");
            return (Criteria) this;
        }

        public Criteria andAffiliateidNotEqualTo(String value) {
            addCriterion("affiliateId <>", value, "affiliateid");
            return (Criteria) this;
        }

        public Criteria andAffiliateidGreaterThan(String value) {
            addCriterion("affiliateId >", value, "affiliateid");
            return (Criteria) this;
        }

        public Criteria andAffiliateidGreaterThanOrEqualTo(String value) {
            addCriterion("affiliateId >=", value, "affiliateid");
            return (Criteria) this;
        }

        public Criteria andAffiliateidLessThan(String value) {
            addCriterion("affiliateId <", value, "affiliateid");
            return (Criteria) this;
        }

        public Criteria andAffiliateidLessThanOrEqualTo(String value) {
            addCriterion("affiliateId <=", value, "affiliateid");
            return (Criteria) this;
        }

        public Criteria andAffiliateidLike(String value) {
            addCriterion("affiliateId like", value, "affiliateid");
            return (Criteria) this;
        }

        public Criteria andAffiliateidNotLike(String value) {
            addCriterion("affiliateId not like", value, "affiliateid");
            return (Criteria) this;
        }

        public Criteria andAffiliateidIn(List<String> values) {
            addCriterion("affiliateId in", values, "affiliateid");
            return (Criteria) this;
        }

        public Criteria andAffiliateidNotIn(List<String> values) {
            addCriterion("affiliateId not in", values, "affiliateid");
            return (Criteria) this;
        }

        public Criteria andAffiliateidBetween(String value1, String value2) {
            addCriterion("affiliateId between", value1, value2, "affiliateid");
            return (Criteria) this;
        }

        public Criteria andAffiliateidNotBetween(String value1, String value2) {
            addCriterion("affiliateId not between", value1, value2, "affiliateid");
            return (Criteria) this;
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

        public Criteria andOfferuidIsNull() {
            addCriterion("offerUId is null");
            return (Criteria) this;
        }

        public Criteria andOfferuidIsNotNull() {
            addCriterion("offerUId is not null");
            return (Criteria) this;
        }

        public Criteria andOfferuidEqualTo(String value) {
            addCriterion("offerUId =", value, "offeruid");
            return (Criteria) this;
        }

        public Criteria andOfferuidNotEqualTo(String value) {
            addCriterion("offerUId <>", value, "offeruid");
            return (Criteria) this;
        }

        public Criteria andOfferuidGreaterThan(String value) {
            addCriterion("offerUId >", value, "offeruid");
            return (Criteria) this;
        }

        public Criteria andOfferuidGreaterThanOrEqualTo(String value) {
            addCriterion("offerUId >=", value, "offeruid");
            return (Criteria) this;
        }

        public Criteria andOfferuidLessThan(String value) {
            addCriterion("offerUId <", value, "offeruid");
            return (Criteria) this;
        }

        public Criteria andOfferuidLessThanOrEqualTo(String value) {
            addCriterion("offerUId <=", value, "offeruid");
            return (Criteria) this;
        }

        public Criteria andOfferuidLike(String value) {
            addCriterion("offerUId like", value, "offeruid");
            return (Criteria) this;
        }

        public Criteria andOfferuidNotLike(String value) {
            addCriterion("offerUId not like", value, "offeruid");
            return (Criteria) this;
        }

        public Criteria andOfferuidIn(List<String> values) {
            addCriterion("offerUId in", values, "offeruid");
            return (Criteria) this;
        }

        public Criteria andOfferuidNotIn(List<String> values) {
            addCriterion("offerUId not in", values, "offeruid");
            return (Criteria) this;
        }

        public Criteria andOfferuidBetween(String value1, String value2) {
            addCriterion("offerUId between", value1, value2, "offeruid");
            return (Criteria) this;
        }

        public Criteria andOfferuidNotBetween(String value1, String value2) {
            addCriterion("offerUId not between", value1, value2, "offeruid");
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

        public Criteria andClickdateIsNull() {
            addCriterion("clickDate is null");
            return (Criteria) this;
        }

        public Criteria andClickdateIsNotNull() {
            addCriterion("clickDate is not null");
            return (Criteria) this;
        }

        public Criteria andClickdateEqualTo(String value) {
            addCriterion("clickDate =", value, "clickdate");
            return (Criteria) this;
        }

        public Criteria andClickdateNotEqualTo(String value) {
            addCriterion("clickDate <>", value, "clickdate");
            return (Criteria) this;
        }

        public Criteria andClickdateGreaterThan(String value) {
            addCriterion("clickDate >", value, "clickdate");
            return (Criteria) this;
        }

        public Criteria andClickdateGreaterThanOrEqualTo(String value) {
            addCriterion("clickDate >=", value, "clickdate");
            return (Criteria) this;
        }

        public Criteria andClickdateLessThan(String value) {
            addCriterion("clickDate <", value, "clickdate");
            return (Criteria) this;
        }

        public Criteria andClickdateLessThanOrEqualTo(String value) {
            addCriterion("clickDate <=", value, "clickdate");
            return (Criteria) this;
        }

        public Criteria andClickdateLike(String value) {
            addCriterion("clickDate like", value, "clickdate");
            return (Criteria) this;
        }

        public Criteria andClickdateNotLike(String value) {
            addCriterion("clickDate not like", value, "clickdate");
            return (Criteria) this;
        }

        public Criteria andClickdateIn(List<String> values) {
            addCriterion("clickDate in", values, "clickdate");
            return (Criteria) this;
        }

        public Criteria andClickdateNotIn(List<String> values) {
            addCriterion("clickDate not in", values, "clickdate");
            return (Criteria) this;
        }

        public Criteria andClickdateBetween(String value1, String value2) {
            addCriterion("clickDate between", value1, value2, "clickdate");
            return (Criteria) this;
        }

        public Criteria andClickdateNotBetween(String value1, String value2) {
            addCriterion("clickDate not between", value1, value2, "clickdate");
            return (Criteria) this;
        }

        public Criteria andActivatetimeIsNull() {
            addCriterion("activateTime is null");
            return (Criteria) this;
        }

        public Criteria andActivatetimeIsNotNull() {
            addCriterion("activateTime is not null");
            return (Criteria) this;
        }

        public Criteria andActivatetimeEqualTo(Date value) {
            addCriterion("activateTime =", value, "activatetime");
            return (Criteria) this;
        }

        public Criteria andActivatetimeNotEqualTo(Date value) {
            addCriterion("activateTime <>", value, "activatetime");
            return (Criteria) this;
        }

        public Criteria andActivatetimeGreaterThan(Date value) {
            addCriterion("activateTime >", value, "activatetime");
            return (Criteria) this;
        }

        public Criteria andActivatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activateTime >=", value, "activatetime");
            return (Criteria) this;
        }

        public Criteria andActivatetimeLessThan(Date value) {
            addCriterion("activateTime <", value, "activatetime");
            return (Criteria) this;
        }

        public Criteria andActivatetimeLessThanOrEqualTo(Date value) {
            addCriterion("activateTime <=", value, "activatetime");
            return (Criteria) this;
        }

        public Criteria andActivatetimeIn(List<Date> values) {
            addCriterion("activateTime in", values, "activatetime");
            return (Criteria) this;
        }

        public Criteria andActivatetimeNotIn(List<Date> values) {
            addCriterion("activateTime not in", values, "activatetime");
            return (Criteria) this;
        }

        public Criteria andActivatetimeBetween(Date value1, Date value2) {
            addCriterion("activateTime between", value1, value2, "activatetime");
            return (Criteria) this;
        }

        public Criteria andActivatetimeNotBetween(Date value1, Date value2) {
            addCriterion("activateTime not between", value1, value2, "activatetime");
            return (Criteria) this;
        }

        public Criteria andChannelidIsNull() {
            addCriterion("channelId is null");
            return (Criteria) this;
        }

        public Criteria andChannelidIsNotNull() {
            addCriterion("channelId is not null");
            return (Criteria) this;
        }

        public Criteria andChannelidEqualTo(Integer value) {
            addCriterion("channelId =", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidNotEqualTo(Integer value) {
            addCriterion("channelId <>", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidGreaterThan(Integer value) {
            addCriterion("channelId >", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidGreaterThanOrEqualTo(Integer value) {
            addCriterion("channelId >=", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidLessThan(Integer value) {
            addCriterion("channelId <", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidLessThanOrEqualTo(Integer value) {
            addCriterion("channelId <=", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidIn(List<Integer> values) {
            addCriterion("channelId in", values, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidNotIn(List<Integer> values) {
            addCriterion("channelId not in", values, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidBetween(Integer value1, Integer value2) {
            addCriterion("channelId between", value1, value2, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidNotBetween(Integer value1, Integer value2) {
            addCriterion("channelId not between", value1, value2, "channelid");
            return (Criteria) this;
        }

        public Criteria andPubsubIsNull() {
            addCriterion("pubSub is null");
            return (Criteria) this;
        }

        public Criteria andPubsubIsNotNull() {
            addCriterion("pubSub is not null");
            return (Criteria) this;
        }

        public Criteria andPubsubEqualTo(String value) {
            addCriterion("pubSub =", value, "pubsub");
            return (Criteria) this;
        }

        public Criteria andPubsubNotEqualTo(String value) {
            addCriterion("pubSub <>", value, "pubsub");
            return (Criteria) this;
        }

        public Criteria andPubsubGreaterThan(String value) {
            addCriterion("pubSub >", value, "pubsub");
            return (Criteria) this;
        }

        public Criteria andPubsubGreaterThanOrEqualTo(String value) {
            addCriterion("pubSub >=", value, "pubsub");
            return (Criteria) this;
        }

        public Criteria andPubsubLessThan(String value) {
            addCriterion("pubSub <", value, "pubsub");
            return (Criteria) this;
        }

        public Criteria andPubsubLessThanOrEqualTo(String value) {
            addCriterion("pubSub <=", value, "pubsub");
            return (Criteria) this;
        }

        public Criteria andPubsubLike(String value) {
            addCriterion("pubSub like", value, "pubsub");
            return (Criteria) this;
        }

        public Criteria andPubsubNotLike(String value) {
            addCriterion("pubSub not like", value, "pubsub");
            return (Criteria) this;
        }

        public Criteria andPubsubIn(List<String> values) {
            addCriterion("pubSub in", values, "pubsub");
            return (Criteria) this;
        }

        public Criteria andPubsubNotIn(List<String> values) {
            addCriterion("pubSub not in", values, "pubsub");
            return (Criteria) this;
        }

        public Criteria andPubsubBetween(String value1, String value2) {
            addCriterion("pubSub between", value1, value2, "pubsub");
            return (Criteria) this;
        }

        public Criteria andPubsubNotBetween(String value1, String value2) {
            addCriterion("pubSub not between", value1, value2, "pubsub");
            return (Criteria) this;
        }

        public Criteria andSubid1IsNull() {
            addCriterion("subId1 is null");
            return (Criteria) this;
        }

        public Criteria andSubid1IsNotNull() {
            addCriterion("subId1 is not null");
            return (Criteria) this;
        }

        public Criteria andSubid1EqualTo(String value) {
            addCriterion("subId1 =", value, "subid1");
            return (Criteria) this;
        }

        public Criteria andSubid1NotEqualTo(String value) {
            addCriterion("subId1 <>", value, "subid1");
            return (Criteria) this;
        }

        public Criteria andSubid1GreaterThan(String value) {
            addCriterion("subId1 >", value, "subid1");
            return (Criteria) this;
        }

        public Criteria andSubid1GreaterThanOrEqualTo(String value) {
            addCriterion("subId1 >=", value, "subid1");
            return (Criteria) this;
        }

        public Criteria andSubid1LessThan(String value) {
            addCriterion("subId1 <", value, "subid1");
            return (Criteria) this;
        }

        public Criteria andSubid1LessThanOrEqualTo(String value) {
            addCriterion("subId1 <=", value, "subid1");
            return (Criteria) this;
        }

        public Criteria andSubid1Like(String value) {
            addCriterion("subId1 like", value, "subid1");
            return (Criteria) this;
        }

        public Criteria andSubid1NotLike(String value) {
            addCriterion("subId1 not like", value, "subid1");
            return (Criteria) this;
        }

        public Criteria andSubid1In(List<String> values) {
            addCriterion("subId1 in", values, "subid1");
            return (Criteria) this;
        }

        public Criteria andSubid1NotIn(List<String> values) {
            addCriterion("subId1 not in", values, "subid1");
            return (Criteria) this;
        }

        public Criteria andSubid1Between(String value1, String value2) {
            addCriterion("subId1 between", value1, value2, "subid1");
            return (Criteria) this;
        }

        public Criteria andSubid1NotBetween(String value1, String value2) {
            addCriterion("subId1 not between", value1, value2, "subid1");
            return (Criteria) this;
        }

        public Criteria andExtinfoIsNull() {
            addCriterion("extinfo is null");
            return (Criteria) this;
        }

        public Criteria andExtinfoIsNotNull() {
            addCriterion("extinfo is not null");
            return (Criteria) this;
        }

        public Criteria andExtinfoEqualTo(String value) {
            addCriterion("extinfo =", value, "extinfo");
            return (Criteria) this;
        }

        public Criteria andExtinfoNotEqualTo(String value) {
            addCriterion("extinfo <>", value, "extinfo");
            return (Criteria) this;
        }

        public Criteria andExtinfoGreaterThan(String value) {
            addCriterion("extinfo >", value, "extinfo");
            return (Criteria) this;
        }

        public Criteria andExtinfoGreaterThanOrEqualTo(String value) {
            addCriterion("extinfo >=", value, "extinfo");
            return (Criteria) this;
        }

        public Criteria andExtinfoLessThan(String value) {
            addCriterion("extinfo <", value, "extinfo");
            return (Criteria) this;
        }

        public Criteria andExtinfoLessThanOrEqualTo(String value) {
            addCriterion("extinfo <=", value, "extinfo");
            return (Criteria) this;
        }

        public Criteria andExtinfoLike(String value) {
            addCriterion("extinfo like", value, "extinfo");
            return (Criteria) this;
        }

        public Criteria andExtinfoNotLike(String value) {
            addCriterion("extinfo not like", value, "extinfo");
            return (Criteria) this;
        }

        public Criteria andExtinfoIn(List<String> values) {
            addCriterion("extinfo in", values, "extinfo");
            return (Criteria) this;
        }

        public Criteria andExtinfoNotIn(List<String> values) {
            addCriterion("extinfo not in", values, "extinfo");
            return (Criteria) this;
        }

        public Criteria andExtinfoBetween(String value1, String value2) {
            addCriterion("extinfo between", value1, value2, "extinfo");
            return (Criteria) this;
        }

        public Criteria andExtinfoNotBetween(String value1, String value2) {
            addCriterion("extinfo not between", value1, value2, "extinfo");
            return (Criteria) this;
        }

        public Criteria andCosttypeIsNull() {
            addCriterion("costType is null");
            return (Criteria) this;
        }

        public Criteria andCosttypeIsNotNull() {
            addCriterion("costType is not null");
            return (Criteria) this;
        }

        public Criteria andCosttypeEqualTo(String value) {
            addCriterion("costType =", value, "costtype");
            return (Criteria) this;
        }

        public Criteria andCosttypeNotEqualTo(String value) {
            addCriterion("costType <>", value, "costtype");
            return (Criteria) this;
        }

        public Criteria andCosttypeGreaterThan(String value) {
            addCriterion("costType >", value, "costtype");
            return (Criteria) this;
        }

        public Criteria andCosttypeGreaterThanOrEqualTo(String value) {
            addCriterion("costType >=", value, "costtype");
            return (Criteria) this;
        }

        public Criteria andCosttypeLessThan(String value) {
            addCriterion("costType <", value, "costtype");
            return (Criteria) this;
        }

        public Criteria andCosttypeLessThanOrEqualTo(String value) {
            addCriterion("costType <=", value, "costtype");
            return (Criteria) this;
        }

        public Criteria andCosttypeLike(String value) {
            addCriterion("costType like", value, "costtype");
            return (Criteria) this;
        }

        public Criteria andCosttypeNotLike(String value) {
            addCriterion("costType not like", value, "costtype");
            return (Criteria) this;
        }

        public Criteria andCosttypeIn(List<String> values) {
            addCriterion("costType in", values, "costtype");
            return (Criteria) this;
        }

        public Criteria andCosttypeNotIn(List<String> values) {
            addCriterion("costType not in", values, "costtype");
            return (Criteria) this;
        }

        public Criteria andCosttypeBetween(String value1, String value2) {
            addCriterion("costType between", value1, value2, "costtype");
            return (Criteria) this;
        }

        public Criteria andCosttypeNotBetween(String value1, String value2) {
            addCriterion("costType not between", value1, value2, "costtype");
            return (Criteria) this;
        }

        public Criteria andEventIsNull() {
            addCriterion("event is null");
            return (Criteria) this;
        }

        public Criteria andEventIsNotNull() {
            addCriterion("event is not null");
            return (Criteria) this;
        }

        public Criteria andEventEqualTo(String value) {
            addCriterion("event =", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventNotEqualTo(String value) {
            addCriterion("event <>", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventGreaterThan(String value) {
            addCriterion("event >", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventGreaterThanOrEqualTo(String value) {
            addCriterion("event >=", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventLessThan(String value) {
            addCriterion("event <", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventLessThanOrEqualTo(String value) {
            addCriterion("event <=", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventLike(String value) {
            addCriterion("event like", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventNotLike(String value) {
            addCriterion("event not like", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventIn(List<String> values) {
            addCriterion("event in", values, "event");
            return (Criteria) this;
        }

        public Criteria andEventNotIn(List<String> values) {
            addCriterion("event not in", values, "event");
            return (Criteria) this;
        }

        public Criteria andEventBetween(String value1, String value2) {
            addCriterion("event between", value1, value2, "event");
            return (Criteria) this;
        }

        public Criteria andEventNotBetween(String value1, String value2) {
            addCriterion("event not between", value1, value2, "event");
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

        public Criteria andNoticestatusIsNull() {
            addCriterion("noticeStatus is null");
            return (Criteria) this;
        }

        public Criteria andNoticestatusIsNotNull() {
            addCriterion("noticeStatus is not null");
            return (Criteria) this;
        }

        public Criteria andNoticestatusEqualTo(Byte value) {
            addCriterion("noticeStatus =", value, "noticestatus");
            return (Criteria) this;
        }

        public Criteria andNoticestatusNotEqualTo(Byte value) {
            addCriterion("noticeStatus <>", value, "noticestatus");
            return (Criteria) this;
        }

        public Criteria andNoticestatusGreaterThan(Byte value) {
            addCriterion("noticeStatus >", value, "noticestatus");
            return (Criteria) this;
        }

        public Criteria andNoticestatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("noticeStatus >=", value, "noticestatus");
            return (Criteria) this;
        }

        public Criteria andNoticestatusLessThan(Byte value) {
            addCriterion("noticeStatus <", value, "noticestatus");
            return (Criteria) this;
        }

        public Criteria andNoticestatusLessThanOrEqualTo(Byte value) {
            addCriterion("noticeStatus <=", value, "noticestatus");
            return (Criteria) this;
        }

        public Criteria andNoticestatusIn(List<Byte> values) {
            addCriterion("noticeStatus in", values, "noticestatus");
            return (Criteria) this;
        }

        public Criteria andNoticestatusNotIn(List<Byte> values) {
            addCriterion("noticeStatus not in", values, "noticestatus");
            return (Criteria) this;
        }

        public Criteria andNoticestatusBetween(Byte value1, Byte value2) {
            addCriterion("noticeStatus between", value1, value2, "noticestatus");
            return (Criteria) this;
        }

        public Criteria andNoticestatusNotBetween(Byte value1, Byte value2) {
            addCriterion("noticeStatus not between", value1, value2, "noticestatus");
            return (Criteria) this;
        }

        public Criteria andNoticetimeIsNull() {
            addCriterion("noticeTime is null");
            return (Criteria) this;
        }

        public Criteria andNoticetimeIsNotNull() {
            addCriterion("noticeTime is not null");
            return (Criteria) this;
        }

        public Criteria andNoticetimeEqualTo(Date value) {
            addCriterion("noticeTime =", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeNotEqualTo(Date value) {
            addCriterion("noticeTime <>", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeGreaterThan(Date value) {
            addCriterion("noticeTime >", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("noticeTime >=", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeLessThan(Date value) {
            addCriterion("noticeTime <", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeLessThanOrEqualTo(Date value) {
            addCriterion("noticeTime <=", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeIn(List<Date> values) {
            addCriterion("noticeTime in", values, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeNotIn(List<Date> values) {
            addCriterion("noticeTime not in", values, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeBetween(Date value1, Date value2) {
            addCriterion("noticeTime between", value1, value2, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeNotBetween(Date value1, Date value2) {
            addCriterion("noticeTime not between", value1, value2, "noticetime");
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

        public Criteria andSourceAffiliateIdEqualTo(String value) {
            addCriterion("source_affiliate_id =", value, "sourceAffiliateId");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdNotEqualTo(String value) {
            addCriterion("source_affiliate_id <>", value, "sourceAffiliateId");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdGreaterThan(String value) {
            addCriterion("source_affiliate_id >", value, "sourceAffiliateId");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdGreaterThanOrEqualTo(String value) {
            addCriterion("source_affiliate_id >=", value, "sourceAffiliateId");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdLessThan(String value) {
            addCriterion("source_affiliate_id <", value, "sourceAffiliateId");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdLessThanOrEqualTo(String value) {
            addCriterion("source_affiliate_id <=", value, "sourceAffiliateId");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdLike(String value) {
            addCriterion("source_affiliate_id like", value, "sourceAffiliateId");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdNotLike(String value) {
            addCriterion("source_affiliate_id not like", value, "sourceAffiliateId");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdIn(List<String> values) {
            addCriterion("source_affiliate_id in", values, "sourceAffiliateId");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdNotIn(List<String> values) {
            addCriterion("source_affiliate_id not in", values, "sourceAffiliateId");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdBetween(String value1, String value2) {
            addCriterion("source_affiliate_id between", value1, value2, "sourceAffiliateId");
            return (Criteria) this;
        }

        public Criteria andSourceAffiliateIdNotBetween(String value1, String value2) {
            addCriterion("source_affiliate_id not between", value1, value2, "sourceAffiliateId");
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

        public Criteria andAdvpayoutIsNull() {
            addCriterion("advpayout is null");
            return (Criteria) this;
        }

        public Criteria andAdvpayoutIsNotNull() {
            addCriterion("advpayout is not null");
            return (Criteria) this;
        }

        public Criteria andAdvpayoutEqualTo(Float value) {
            addCriterion("advpayout =", value, "advpayout");
            return (Criteria) this;
        }

        public Criteria andAdvpayoutNotEqualTo(Float value) {
            addCriterion("advpayout <>", value, "advpayout");
            return (Criteria) this;
        }

        public Criteria andAdvpayoutGreaterThan(Float value) {
            addCriterion("advpayout >", value, "advpayout");
            return (Criteria) this;
        }

        public Criteria andAdvpayoutGreaterThanOrEqualTo(Float value) {
            addCriterion("advpayout >=", value, "advpayout");
            return (Criteria) this;
        }

        public Criteria andAdvpayoutLessThan(Float value) {
            addCriterion("advpayout <", value, "advpayout");
            return (Criteria) this;
        }

        public Criteria andAdvpayoutLessThanOrEqualTo(Float value) {
            addCriterion("advpayout <=", value, "advpayout");
            return (Criteria) this;
        }

        public Criteria andAdvpayoutIn(List<Float> values) {
            addCriterion("advpayout in", values, "advpayout");
            return (Criteria) this;
        }

        public Criteria andAdvpayoutNotIn(List<Float> values) {
            addCriterion("advpayout not in", values, "advpayout");
            return (Criteria) this;
        }

        public Criteria andAdvpayoutBetween(Float value1, Float value2) {
            addCriterion("advpayout between", value1, value2, "advpayout");
            return (Criteria) this;
        }

        public Criteria andAdvpayoutNotBetween(Float value1, Float value2) {
            addCriterion("advpayout not between", value1, value2, "advpayout");
            return (Criteria) this;
        }

        public Criteria andPubpayoutIsNull() {
            addCriterion("pubpayout is null");
            return (Criteria) this;
        }

        public Criteria andPubpayoutIsNotNull() {
            addCriterion("pubpayout is not null");
            return (Criteria) this;
        }

        public Criteria andPubpayoutEqualTo(Float value) {
            addCriterion("pubpayout =", value, "pubpayout");
            return (Criteria) this;
        }

        public Criteria andPubpayoutNotEqualTo(Float value) {
            addCriterion("pubpayout <>", value, "pubpayout");
            return (Criteria) this;
        }

        public Criteria andPubpayoutGreaterThan(Float value) {
            addCriterion("pubpayout >", value, "pubpayout");
            return (Criteria) this;
        }

        public Criteria andPubpayoutGreaterThanOrEqualTo(Float value) {
            addCriterion("pubpayout >=", value, "pubpayout");
            return (Criteria) this;
        }

        public Criteria andPubpayoutLessThan(Float value) {
            addCriterion("pubpayout <", value, "pubpayout");
            return (Criteria) this;
        }

        public Criteria andPubpayoutLessThanOrEqualTo(Float value) {
            addCriterion("pubpayout <=", value, "pubpayout");
            return (Criteria) this;
        }

        public Criteria andPubpayoutIn(List<Float> values) {
            addCriterion("pubpayout in", values, "pubpayout");
            return (Criteria) this;
        }

        public Criteria andPubpayoutNotIn(List<Float> values) {
            addCriterion("pubpayout not in", values, "pubpayout");
            return (Criteria) this;
        }

        public Criteria andPubpayoutBetween(Float value1, Float value2) {
            addCriterion("pubpayout between", value1, value2, "pubpayout");
            return (Criteria) this;
        }

        public Criteria andPubpayoutNotBetween(Float value1, Float value2) {
            addCriterion("pubpayout not between", value1, value2, "pubpayout");
            return (Criteria) this;
        }

        public Criteria andActivecntIsNull() {
            addCriterion("activecnt is null");
            return (Criteria) this;
        }

        public Criteria andActivecntIsNotNull() {
            addCriterion("activecnt is not null");
            return (Criteria) this;
        }

        public Criteria andActivecntEqualTo(Integer value) {
            addCriterion("activecnt =", value, "activecnt");
            return (Criteria) this;
        }

        public Criteria andActivecntNotEqualTo(Integer value) {
            addCriterion("activecnt <>", value, "activecnt");
            return (Criteria) this;
        }

        public Criteria andActivecntGreaterThan(Integer value) {
            addCriterion("activecnt >", value, "activecnt");
            return (Criteria) this;
        }

        public Criteria andActivecntGreaterThanOrEqualTo(Integer value) {
            addCriterion("activecnt >=", value, "activecnt");
            return (Criteria) this;
        }

        public Criteria andActivecntLessThan(Integer value) {
            addCriterion("activecnt <", value, "activecnt");
            return (Criteria) this;
        }

        public Criteria andActivecntLessThanOrEqualTo(Integer value) {
            addCriterion("activecnt <=", value, "activecnt");
            return (Criteria) this;
        }

        public Criteria andActivecntIn(List<Integer> values) {
            addCriterion("activecnt in", values, "activecnt");
            return (Criteria) this;
        }

        public Criteria andActivecntNotIn(List<Integer> values) {
            addCriterion("activecnt not in", values, "activecnt");
            return (Criteria) this;
        }

        public Criteria andActivecntBetween(Integer value1, Integer value2) {
            addCriterion("activecnt between", value1, value2, "activecnt");
            return (Criteria) this;
        }

        public Criteria andActivecntNotBetween(Integer value1, Integer value2) {
            addCriterion("activecnt not between", value1, value2, "activecnt");
            return (Criteria) this;
        }

        public Criteria andDeductcntIsNull() {
            addCriterion("deductcnt is null");
            return (Criteria) this;
        }

        public Criteria andDeductcntIsNotNull() {
            addCriterion("deductcnt is not null");
            return (Criteria) this;
        }

        public Criteria andDeductcntEqualTo(Integer value) {
            addCriterion("deductcnt =", value, "deductcnt");
            return (Criteria) this;
        }

        public Criteria andDeductcntNotEqualTo(Integer value) {
            addCriterion("deductcnt <>", value, "deductcnt");
            return (Criteria) this;
        }

        public Criteria andDeductcntGreaterThan(Integer value) {
            addCriterion("deductcnt >", value, "deductcnt");
            return (Criteria) this;
        }

        public Criteria andDeductcntGreaterThanOrEqualTo(Integer value) {
            addCriterion("deductcnt >=", value, "deductcnt");
            return (Criteria) this;
        }

        public Criteria andDeductcntLessThan(Integer value) {
            addCriterion("deductcnt <", value, "deductcnt");
            return (Criteria) this;
        }

        public Criteria andDeductcntLessThanOrEqualTo(Integer value) {
            addCriterion("deductcnt <=", value, "deductcnt");
            return (Criteria) this;
        }

        public Criteria andDeductcntIn(List<Integer> values) {
            addCriterion("deductcnt in", values, "deductcnt");
            return (Criteria) this;
        }

        public Criteria andDeductcntNotIn(List<Integer> values) {
            addCriterion("deductcnt not in", values, "deductcnt");
            return (Criteria) this;
        }

        public Criteria andDeductcntBetween(Integer value1, Integer value2) {
            addCriterion("deductcnt between", value1, value2, "deductcnt");
            return (Criteria) this;
        }

        public Criteria andDeductcntNotBetween(Integer value1, Integer value2) {
            addCriterion("deductcnt not between", value1, value2, "deductcnt");
            return (Criteria) this;
        }

        public Criteria andInactivecntIsNull() {
            addCriterion("inactivecnt is null");
            return (Criteria) this;
        }

        public Criteria andInactivecntIsNotNull() {
            addCriterion("inactivecnt is not null");
            return (Criteria) this;
        }

        public Criteria andInactivecntEqualTo(Integer value) {
            addCriterion("inactivecnt =", value, "inactivecnt");
            return (Criteria) this;
        }

        public Criteria andInactivecntNotEqualTo(Integer value) {
            addCriterion("inactivecnt <>", value, "inactivecnt");
            return (Criteria) this;
        }

        public Criteria andInactivecntGreaterThan(Integer value) {
            addCriterion("inactivecnt >", value, "inactivecnt");
            return (Criteria) this;
        }

        public Criteria andInactivecntGreaterThanOrEqualTo(Integer value) {
            addCriterion("inactivecnt >=", value, "inactivecnt");
            return (Criteria) this;
        }

        public Criteria andInactivecntLessThan(Integer value) {
            addCriterion("inactivecnt <", value, "inactivecnt");
            return (Criteria) this;
        }

        public Criteria andInactivecntLessThanOrEqualTo(Integer value) {
            addCriterion("inactivecnt <=", value, "inactivecnt");
            return (Criteria) this;
        }

        public Criteria andInactivecntIn(List<Integer> values) {
            addCriterion("inactivecnt in", values, "inactivecnt");
            return (Criteria) this;
        }

        public Criteria andInactivecntNotIn(List<Integer> values) {
            addCriterion("inactivecnt not in", values, "inactivecnt");
            return (Criteria) this;
        }

        public Criteria andInactivecntBetween(Integer value1, Integer value2) {
            addCriterion("inactivecnt between", value1, value2, "inactivecnt");
            return (Criteria) this;
        }

        public Criteria andInactivecntNotBetween(Integer value1, Integer value2) {
            addCriterion("inactivecnt not between", value1, value2, "inactivecnt");
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