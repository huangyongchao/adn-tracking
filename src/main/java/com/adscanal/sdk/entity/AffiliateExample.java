package com.adscanal.sdk.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AffiliateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AffiliateExample() {
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

        public Criteria andPublisheridIsNull() {
            addCriterion("publisherId is null");
            return (Criteria) this;
        }

        public Criteria andPublisheridIsNotNull() {
            addCriterion("publisherId is not null");
            return (Criteria) this;
        }

        public Criteria andPublisheridEqualTo(String value) {
            addCriterion("publisherId =", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridNotEqualTo(String value) {
            addCriterion("publisherId <>", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridGreaterThan(String value) {
            addCriterion("publisherId >", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridGreaterThanOrEqualTo(String value) {
            addCriterion("publisherId >=", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridLessThan(String value) {
            addCriterion("publisherId <", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridLessThanOrEqualTo(String value) {
            addCriterion("publisherId <=", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridLike(String value) {
            addCriterion("publisherId like", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridNotLike(String value) {
            addCriterion("publisherId not like", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridIn(List<String> values) {
            addCriterion("publisherId in", values, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridNotIn(List<String> values) {
            addCriterion("publisherId not in", values, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridBetween(String value1, String value2) {
            addCriterion("publisherId between", value1, value2, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridNotBetween(String value1, String value2) {
            addCriterion("publisherId not between", value1, value2, "publisherid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andLoginurlIsNull() {
            addCriterion("loginUrl is null");
            return (Criteria) this;
        }

        public Criteria andLoginurlIsNotNull() {
            addCriterion("loginUrl is not null");
            return (Criteria) this;
        }

        public Criteria andLoginurlEqualTo(String value) {
            addCriterion("loginUrl =", value, "loginurl");
            return (Criteria) this;
        }

        public Criteria andLoginurlNotEqualTo(String value) {
            addCriterion("loginUrl <>", value, "loginurl");
            return (Criteria) this;
        }

        public Criteria andLoginurlGreaterThan(String value) {
            addCriterion("loginUrl >", value, "loginurl");
            return (Criteria) this;
        }

        public Criteria andLoginurlGreaterThanOrEqualTo(String value) {
            addCriterion("loginUrl >=", value, "loginurl");
            return (Criteria) this;
        }

        public Criteria andLoginurlLessThan(String value) {
            addCriterion("loginUrl <", value, "loginurl");
            return (Criteria) this;
        }

        public Criteria andLoginurlLessThanOrEqualTo(String value) {
            addCriterion("loginUrl <=", value, "loginurl");
            return (Criteria) this;
        }

        public Criteria andLoginurlLike(String value) {
            addCriterion("loginUrl like", value, "loginurl");
            return (Criteria) this;
        }

        public Criteria andLoginurlNotLike(String value) {
            addCriterion("loginUrl not like", value, "loginurl");
            return (Criteria) this;
        }

        public Criteria andLoginurlIn(List<String> values) {
            addCriterion("loginUrl in", values, "loginurl");
            return (Criteria) this;
        }

        public Criteria andLoginurlNotIn(List<String> values) {
            addCriterion("loginUrl not in", values, "loginurl");
            return (Criteria) this;
        }

        public Criteria andLoginurlBetween(String value1, String value2) {
            addCriterion("loginUrl between", value1, value2, "loginurl");
            return (Criteria) this;
        }

        public Criteria andLoginurlNotBetween(String value1, String value2) {
            addCriterion("loginUrl not between", value1, value2, "loginurl");
            return (Criteria) this;
        }

        public Criteria andTokenIsNull() {
            addCriterion("token is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("token is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("token =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("token <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("token >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("token >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("token <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("token <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLike(String value) {
            addCriterion("token like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("token not like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("token in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("token not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("token between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("token not between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andParastrackIsNull() {
            addCriterion("parasTrack is null");
            return (Criteria) this;
        }

        public Criteria andParastrackIsNotNull() {
            addCriterion("parasTrack is not null");
            return (Criteria) this;
        }

        public Criteria andParastrackEqualTo(String value) {
            addCriterion("parasTrack =", value, "parastrack");
            return (Criteria) this;
        }

        public Criteria andParastrackNotEqualTo(String value) {
            addCriterion("parasTrack <>", value, "parastrack");
            return (Criteria) this;
        }

        public Criteria andParastrackGreaterThan(String value) {
            addCriterion("parasTrack >", value, "parastrack");
            return (Criteria) this;
        }

        public Criteria andParastrackGreaterThanOrEqualTo(String value) {
            addCriterion("parasTrack >=", value, "parastrack");
            return (Criteria) this;
        }

        public Criteria andParastrackLessThan(String value) {
            addCriterion("parasTrack <", value, "parastrack");
            return (Criteria) this;
        }

        public Criteria andParastrackLessThanOrEqualTo(String value) {
            addCriterion("parasTrack <=", value, "parastrack");
            return (Criteria) this;
        }

        public Criteria andParastrackLike(String value) {
            addCriterion("parasTrack like", value, "parastrack");
            return (Criteria) this;
        }

        public Criteria andParastrackNotLike(String value) {
            addCriterion("parasTrack not like", value, "parastrack");
            return (Criteria) this;
        }

        public Criteria andParastrackIn(List<String> values) {
            addCriterion("parasTrack in", values, "parastrack");
            return (Criteria) this;
        }

        public Criteria andParastrackNotIn(List<String> values) {
            addCriterion("parasTrack not in", values, "parastrack");
            return (Criteria) this;
        }

        public Criteria andParastrackBetween(String value1, String value2) {
            addCriterion("parasTrack between", value1, value2, "parastrack");
            return (Criteria) this;
        }

        public Criteria andParastrackNotBetween(String value1, String value2) {
            addCriterion("parasTrack not between", value1, value2, "parastrack");
            return (Criteria) this;
        }

        public Criteria andApiurlIsNull() {
            addCriterion("apiUrl is null");
            return (Criteria) this;
        }

        public Criteria andApiurlIsNotNull() {
            addCriterion("apiUrl is not null");
            return (Criteria) this;
        }

        public Criteria andApiurlEqualTo(String value) {
            addCriterion("apiUrl =", value, "apiurl");
            return (Criteria) this;
        }

        public Criteria andApiurlNotEqualTo(String value) {
            addCriterion("apiUrl <>", value, "apiurl");
            return (Criteria) this;
        }

        public Criteria andApiurlGreaterThan(String value) {
            addCriterion("apiUrl >", value, "apiurl");
            return (Criteria) this;
        }

        public Criteria andApiurlGreaterThanOrEqualTo(String value) {
            addCriterion("apiUrl >=", value, "apiurl");
            return (Criteria) this;
        }

        public Criteria andApiurlLessThan(String value) {
            addCriterion("apiUrl <", value, "apiurl");
            return (Criteria) this;
        }

        public Criteria andApiurlLessThanOrEqualTo(String value) {
            addCriterion("apiUrl <=", value, "apiurl");
            return (Criteria) this;
        }

        public Criteria andApiurlLike(String value) {
            addCriterion("apiUrl like", value, "apiurl");
            return (Criteria) this;
        }

        public Criteria andApiurlNotLike(String value) {
            addCriterion("apiUrl not like", value, "apiurl");
            return (Criteria) this;
        }

        public Criteria andApiurlIn(List<String> values) {
            addCriterion("apiUrl in", values, "apiurl");
            return (Criteria) this;
        }

        public Criteria andApiurlNotIn(List<String> values) {
            addCriterion("apiUrl not in", values, "apiurl");
            return (Criteria) this;
        }

        public Criteria andApiurlBetween(String value1, String value2) {
            addCriterion("apiUrl between", value1, value2, "apiurl");
            return (Criteria) this;
        }

        public Criteria andApiurlNotBetween(String value1, String value2) {
            addCriterion("apiUrl not between", value1, value2, "apiurl");
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

        public Criteria andChecklevelIsNull() {
            addCriterion("checkLevel is null");
            return (Criteria) this;
        }

        public Criteria andChecklevelIsNotNull() {
            addCriterion("checkLevel is not null");
            return (Criteria) this;
        }

        public Criteria andChecklevelEqualTo(Byte value) {
            addCriterion("checkLevel =", value, "checklevel");
            return (Criteria) this;
        }

        public Criteria andChecklevelNotEqualTo(Byte value) {
            addCriterion("checkLevel <>", value, "checklevel");
            return (Criteria) this;
        }

        public Criteria andChecklevelGreaterThan(Byte value) {
            addCriterion("checkLevel >", value, "checklevel");
            return (Criteria) this;
        }

        public Criteria andChecklevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("checkLevel >=", value, "checklevel");
            return (Criteria) this;
        }

        public Criteria andChecklevelLessThan(Byte value) {
            addCriterion("checkLevel <", value, "checklevel");
            return (Criteria) this;
        }

        public Criteria andChecklevelLessThanOrEqualTo(Byte value) {
            addCriterion("checkLevel <=", value, "checklevel");
            return (Criteria) this;
        }

        public Criteria andChecklevelIn(List<Byte> values) {
            addCriterion("checkLevel in", values, "checklevel");
            return (Criteria) this;
        }

        public Criteria andChecklevelNotIn(List<Byte> values) {
            addCriterion("checkLevel not in", values, "checklevel");
            return (Criteria) this;
        }

        public Criteria andChecklevelBetween(Byte value1, Byte value2) {
            addCriterion("checkLevel between", value1, value2, "checklevel");
            return (Criteria) this;
        }

        public Criteria andChecklevelNotBetween(Byte value1, Byte value2) {
            addCriterion("checkLevel not between", value1, value2, "checklevel");
            return (Criteria) this;
        }

        public Criteria andRunlevelIsNull() {
            addCriterion("runLevel is null");
            return (Criteria) this;
        }

        public Criteria andRunlevelIsNotNull() {
            addCriterion("runLevel is not null");
            return (Criteria) this;
        }

        public Criteria andRunlevelEqualTo(Byte value) {
            addCriterion("runLevel =", value, "runlevel");
            return (Criteria) this;
        }

        public Criteria andRunlevelNotEqualTo(Byte value) {
            addCriterion("runLevel <>", value, "runlevel");
            return (Criteria) this;
        }

        public Criteria andRunlevelGreaterThan(Byte value) {
            addCriterion("runLevel >", value, "runlevel");
            return (Criteria) this;
        }

        public Criteria andRunlevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("runLevel >=", value, "runlevel");
            return (Criteria) this;
        }

        public Criteria andRunlevelLessThan(Byte value) {
            addCriterion("runLevel <", value, "runlevel");
            return (Criteria) this;
        }

        public Criteria andRunlevelLessThanOrEqualTo(Byte value) {
            addCriterion("runLevel <=", value, "runlevel");
            return (Criteria) this;
        }

        public Criteria andRunlevelIn(List<Byte> values) {
            addCriterion("runLevel in", values, "runlevel");
            return (Criteria) this;
        }

        public Criteria andRunlevelNotIn(List<Byte> values) {
            addCriterion("runLevel not in", values, "runlevel");
            return (Criteria) this;
        }

        public Criteria andRunlevelBetween(Byte value1, Byte value2) {
            addCriterion("runLevel between", value1, value2, "runlevel");
            return (Criteria) this;
        }

        public Criteria andRunlevelNotBetween(Byte value1, Byte value2) {
            addCriterion("runLevel not between", value1, value2, "runlevel");
            return (Criteria) this;
        }

        public Criteria andCampaignmaxIsNull() {
            addCriterion("campaignMax is null");
            return (Criteria) this;
        }

        public Criteria andCampaignmaxIsNotNull() {
            addCriterion("campaignMax is not null");
            return (Criteria) this;
        }

        public Criteria andCampaignmaxEqualTo(Integer value) {
            addCriterion("campaignMax =", value, "campaignmax");
            return (Criteria) this;
        }

        public Criteria andCampaignmaxNotEqualTo(Integer value) {
            addCriterion("campaignMax <>", value, "campaignmax");
            return (Criteria) this;
        }

        public Criteria andCampaignmaxGreaterThan(Integer value) {
            addCriterion("campaignMax >", value, "campaignmax");
            return (Criteria) this;
        }

        public Criteria andCampaignmaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("campaignMax >=", value, "campaignmax");
            return (Criteria) this;
        }

        public Criteria andCampaignmaxLessThan(Integer value) {
            addCriterion("campaignMax <", value, "campaignmax");
            return (Criteria) this;
        }

        public Criteria andCampaignmaxLessThanOrEqualTo(Integer value) {
            addCriterion("campaignMax <=", value, "campaignmax");
            return (Criteria) this;
        }

        public Criteria andCampaignmaxIn(List<Integer> values) {
            addCriterion("campaignMax in", values, "campaignmax");
            return (Criteria) this;
        }

        public Criteria andCampaignmaxNotIn(List<Integer> values) {
            addCriterion("campaignMax not in", values, "campaignmax");
            return (Criteria) this;
        }

        public Criteria andCampaignmaxBetween(Integer value1, Integer value2) {
            addCriterion("campaignMax between", value1, value2, "campaignmax");
            return (Criteria) this;
        }

        public Criteria andCampaignmaxNotBetween(Integer value1, Integer value2) {
            addCriterion("campaignMax not between", value1, value2, "campaignmax");
            return (Criteria) this;
        }

        public Criteria andClickmaxIsNull() {
            addCriterion("clickMax is null");
            return (Criteria) this;
        }

        public Criteria andClickmaxIsNotNull() {
            addCriterion("clickMax is not null");
            return (Criteria) this;
        }

        public Criteria andClickmaxEqualTo(Integer value) {
            addCriterion("clickMax =", value, "clickmax");
            return (Criteria) this;
        }

        public Criteria andClickmaxNotEqualTo(Integer value) {
            addCriterion("clickMax <>", value, "clickmax");
            return (Criteria) this;
        }

        public Criteria andClickmaxGreaterThan(Integer value) {
            addCriterion("clickMax >", value, "clickmax");
            return (Criteria) this;
        }

        public Criteria andClickmaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("clickMax >=", value, "clickmax");
            return (Criteria) this;
        }

        public Criteria andClickmaxLessThan(Integer value) {
            addCriterion("clickMax <", value, "clickmax");
            return (Criteria) this;
        }

        public Criteria andClickmaxLessThanOrEqualTo(Integer value) {
            addCriterion("clickMax <=", value, "clickmax");
            return (Criteria) this;
        }

        public Criteria andClickmaxIn(List<Integer> values) {
            addCriterion("clickMax in", values, "clickmax");
            return (Criteria) this;
        }

        public Criteria andClickmaxNotIn(List<Integer> values) {
            addCriterion("clickMax not in", values, "clickmax");
            return (Criteria) this;
        }

        public Criteria andClickmaxBetween(Integer value1, Integer value2) {
            addCriterion("clickMax between", value1, value2, "clickmax");
            return (Criteria) this;
        }

        public Criteria andClickmaxNotBetween(Integer value1, Integer value2) {
            addCriterion("clickMax not between", value1, value2, "clickmax");
            return (Criteria) this;
        }

        public Criteria andJumpminIsNull() {
            addCriterion("jumpMin is null");
            return (Criteria) this;
        }

        public Criteria andJumpminIsNotNull() {
            addCriterion("jumpMin is not null");
            return (Criteria) this;
        }

        public Criteria andJumpminEqualTo(Byte value) {
            addCriterion("jumpMin =", value, "jumpmin");
            return (Criteria) this;
        }

        public Criteria andJumpminNotEqualTo(Byte value) {
            addCriterion("jumpMin <>", value, "jumpmin");
            return (Criteria) this;
        }

        public Criteria andJumpminGreaterThan(Byte value) {
            addCriterion("jumpMin >", value, "jumpmin");
            return (Criteria) this;
        }

        public Criteria andJumpminGreaterThanOrEqualTo(Byte value) {
            addCriterion("jumpMin >=", value, "jumpmin");
            return (Criteria) this;
        }

        public Criteria andJumpminLessThan(Byte value) {
            addCriterion("jumpMin <", value, "jumpmin");
            return (Criteria) this;
        }

        public Criteria andJumpminLessThanOrEqualTo(Byte value) {
            addCriterion("jumpMin <=", value, "jumpmin");
            return (Criteria) this;
        }

        public Criteria andJumpminIn(List<Byte> values) {
            addCriterion("jumpMin in", values, "jumpmin");
            return (Criteria) this;
        }

        public Criteria andJumpminNotIn(List<Byte> values) {
            addCriterion("jumpMin not in", values, "jumpmin");
            return (Criteria) this;
        }

        public Criteria andJumpminBetween(Byte value1, Byte value2) {
            addCriterion("jumpMin between", value1, value2, "jumpmin");
            return (Criteria) this;
        }

        public Criteria andJumpminNotBetween(Byte value1, Byte value2) {
            addCriterion("jumpMin not between", value1, value2, "jumpmin");
            return (Criteria) this;
        }

        public Criteria andJumpmaxIsNull() {
            addCriterion("jumpMax is null");
            return (Criteria) this;
        }

        public Criteria andJumpmaxIsNotNull() {
            addCriterion("jumpMax is not null");
            return (Criteria) this;
        }

        public Criteria andJumpmaxEqualTo(Byte value) {
            addCriterion("jumpMax =", value, "jumpmax");
            return (Criteria) this;
        }

        public Criteria andJumpmaxNotEqualTo(Byte value) {
            addCriterion("jumpMax <>", value, "jumpmax");
            return (Criteria) this;
        }

        public Criteria andJumpmaxGreaterThan(Byte value) {
            addCriterion("jumpMax >", value, "jumpmax");
            return (Criteria) this;
        }

        public Criteria andJumpmaxGreaterThanOrEqualTo(Byte value) {
            addCriterion("jumpMax >=", value, "jumpmax");
            return (Criteria) this;
        }

        public Criteria andJumpmaxLessThan(Byte value) {
            addCriterion("jumpMax <", value, "jumpmax");
            return (Criteria) this;
        }

        public Criteria andJumpmaxLessThanOrEqualTo(Byte value) {
            addCriterion("jumpMax <=", value, "jumpmax");
            return (Criteria) this;
        }

        public Criteria andJumpmaxIn(List<Byte> values) {
            addCriterion("jumpMax in", values, "jumpmax");
            return (Criteria) this;
        }

        public Criteria andJumpmaxNotIn(List<Byte> values) {
            addCriterion("jumpMax not in", values, "jumpmax");
            return (Criteria) this;
        }

        public Criteria andJumpmaxBetween(Byte value1, Byte value2) {
            addCriterion("jumpMax between", value1, value2, "jumpmax");
            return (Criteria) this;
        }

        public Criteria andJumpmaxNotBetween(Byte value1, Byte value2) {
            addCriterion("jumpMax not between", value1, value2, "jumpmax");
            return (Criteria) this;
        }

        public Criteria andRegisterdateIsNull() {
            addCriterion("registerDate is null");
            return (Criteria) this;
        }

        public Criteria andRegisterdateIsNotNull() {
            addCriterion("registerDate is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterdateEqualTo(Date value) {
            addCriterion("registerDate =", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateNotEqualTo(Date value) {
            addCriterion("registerDate <>", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateGreaterThan(Date value) {
            addCriterion("registerDate >", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateGreaterThanOrEqualTo(Date value) {
            addCriterion("registerDate >=", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateLessThan(Date value) {
            addCriterion("registerDate <", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateLessThanOrEqualTo(Date value) {
            addCriterion("registerDate <=", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateIn(List<Date> values) {
            addCriterion("registerDate in", values, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateNotIn(List<Date> values) {
            addCriterion("registerDate not in", values, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateBetween(Date value1, Date value2) {
            addCriterion("registerDate between", value1, value2, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateNotBetween(Date value1, Date value2) {
            addCriterion("registerDate not between", value1, value2, "registerdate");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNull() {
            addCriterion("createUser is null");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNotNull() {
            addCriterion("createUser is not null");
            return (Criteria) this;
        }

        public Criteria andCreateuserEqualTo(String value) {
            addCriterion("createUser =", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotEqualTo(String value) {
            addCriterion("createUser <>", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThan(String value) {
            addCriterion("createUser >", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("createUser >=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThan(String value) {
            addCriterion("createUser <", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThanOrEqualTo(String value) {
            addCriterion("createUser <=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLike(String value) {
            addCriterion("createUser like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotLike(String value) {
            addCriterion("createUser not like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserIn(List<String> values) {
            addCriterion("createUser in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotIn(List<String> values) {
            addCriterion("createUser not in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserBetween(String value1, String value2) {
            addCriterion("createUser between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotBetween(String value1, String value2) {
            addCriterion("createUser not between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIsNull() {
            addCriterion("updateUser is null");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIsNotNull() {
            addCriterion("updateUser is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateuserEqualTo(String value) {
            addCriterion("updateUser =", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotEqualTo(String value) {
            addCriterion("updateUser <>", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserGreaterThan(String value) {
            addCriterion("updateUser >", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("updateUser >=", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLessThan(String value) {
            addCriterion("updateUser <", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("updateUser <=", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLike(String value) {
            addCriterion("updateUser like", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotLike(String value) {
            addCriterion("updateUser not like", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIn(List<String> values) {
            addCriterion("updateUser in", values, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotIn(List<String> values) {
            addCriterion("updateUser not in", values, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserBetween(String value1, String value2) {
            addCriterion("updateUser between", value1, value2, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotBetween(String value1, String value2) {
            addCriterion("updateUser not between", value1, value2, "updateuser");
            return (Criteria) this;
        }

        public Criteria andManageruserIsNull() {
            addCriterion("managerUser is null");
            return (Criteria) this;
        }

        public Criteria andManageruserIsNotNull() {
            addCriterion("managerUser is not null");
            return (Criteria) this;
        }

        public Criteria andManageruserEqualTo(String value) {
            addCriterion("managerUser =", value, "manageruser");
            return (Criteria) this;
        }

        public Criteria andManageruserNotEqualTo(String value) {
            addCriterion("managerUser <>", value, "manageruser");
            return (Criteria) this;
        }

        public Criteria andManageruserGreaterThan(String value) {
            addCriterion("managerUser >", value, "manageruser");
            return (Criteria) this;
        }

        public Criteria andManageruserGreaterThanOrEqualTo(String value) {
            addCriterion("managerUser >=", value, "manageruser");
            return (Criteria) this;
        }

        public Criteria andManageruserLessThan(String value) {
            addCriterion("managerUser <", value, "manageruser");
            return (Criteria) this;
        }

        public Criteria andManageruserLessThanOrEqualTo(String value) {
            addCriterion("managerUser <=", value, "manageruser");
            return (Criteria) this;
        }

        public Criteria andManageruserLike(String value) {
            addCriterion("managerUser like", value, "manageruser");
            return (Criteria) this;
        }

        public Criteria andManageruserNotLike(String value) {
            addCriterion("managerUser not like", value, "manageruser");
            return (Criteria) this;
        }

        public Criteria andManageruserIn(List<String> values) {
            addCriterion("managerUser in", values, "manageruser");
            return (Criteria) this;
        }

        public Criteria andManageruserNotIn(List<String> values) {
            addCriterion("managerUser not in", values, "manageruser");
            return (Criteria) this;
        }

        public Criteria andManageruserBetween(String value1, String value2) {
            addCriterion("managerUser between", value1, value2, "manageruser");
            return (Criteria) this;
        }

        public Criteria andManageruserNotBetween(String value1, String value2) {
            addCriterion("managerUser not between", value1, value2, "manageruser");
            return (Criteria) this;
        }

        public Criteria andOpuserIsNull() {
            addCriterion("opuser is null");
            return (Criteria) this;
        }

        public Criteria andOpuserIsNotNull() {
            addCriterion("opuser is not null");
            return (Criteria) this;
        }

        public Criteria andOpuserEqualTo(String value) {
            addCriterion("opuser =", value, "opuser");
            return (Criteria) this;
        }

        public Criteria andOpuserNotEqualTo(String value) {
            addCriterion("opuser <>", value, "opuser");
            return (Criteria) this;
        }

        public Criteria andOpuserGreaterThan(String value) {
            addCriterion("opuser >", value, "opuser");
            return (Criteria) this;
        }

        public Criteria andOpuserGreaterThanOrEqualTo(String value) {
            addCriterion("opuser >=", value, "opuser");
            return (Criteria) this;
        }

        public Criteria andOpuserLessThan(String value) {
            addCriterion("opuser <", value, "opuser");
            return (Criteria) this;
        }

        public Criteria andOpuserLessThanOrEqualTo(String value) {
            addCriterion("opuser <=", value, "opuser");
            return (Criteria) this;
        }

        public Criteria andOpuserLike(String value) {
            addCriterion("opuser like", value, "opuser");
            return (Criteria) this;
        }

        public Criteria andOpuserNotLike(String value) {
            addCriterion("opuser not like", value, "opuser");
            return (Criteria) this;
        }

        public Criteria andOpuserIn(List<String> values) {
            addCriterion("opuser in", values, "opuser");
            return (Criteria) this;
        }

        public Criteria andOpuserNotIn(List<String> values) {
            addCriterion("opuser not in", values, "opuser");
            return (Criteria) this;
        }

        public Criteria andOpuserBetween(String value1, String value2) {
            addCriterion("opuser between", value1, value2, "opuser");
            return (Criteria) this;
        }

        public Criteria andOpuserNotBetween(String value1, String value2) {
            addCriterion("opuser not between", value1, value2, "opuser");
            return (Criteria) this;
        }

        public Criteria andBduserIsNull() {
            addCriterion("bduser is null");
            return (Criteria) this;
        }

        public Criteria andBduserIsNotNull() {
            addCriterion("bduser is not null");
            return (Criteria) this;
        }

        public Criteria andBduserEqualTo(String value) {
            addCriterion("bduser =", value, "bduser");
            return (Criteria) this;
        }

        public Criteria andBduserNotEqualTo(String value) {
            addCriterion("bduser <>", value, "bduser");
            return (Criteria) this;
        }

        public Criteria andBduserGreaterThan(String value) {
            addCriterion("bduser >", value, "bduser");
            return (Criteria) this;
        }

        public Criteria andBduserGreaterThanOrEqualTo(String value) {
            addCriterion("bduser >=", value, "bduser");
            return (Criteria) this;
        }

        public Criteria andBduserLessThan(String value) {
            addCriterion("bduser <", value, "bduser");
            return (Criteria) this;
        }

        public Criteria andBduserLessThanOrEqualTo(String value) {
            addCriterion("bduser <=", value, "bduser");
            return (Criteria) this;
        }

        public Criteria andBduserLike(String value) {
            addCriterion("bduser like", value, "bduser");
            return (Criteria) this;
        }

        public Criteria andBduserNotLike(String value) {
            addCriterion("bduser not like", value, "bduser");
            return (Criteria) this;
        }

        public Criteria andBduserIn(List<String> values) {
            addCriterion("bduser in", values, "bduser");
            return (Criteria) this;
        }

        public Criteria andBduserNotIn(List<String> values) {
            addCriterion("bduser not in", values, "bduser");
            return (Criteria) this;
        }

        public Criteria andBduserBetween(String value1, String value2) {
            addCriterion("bduser between", value1, value2, "bduser");
            return (Criteria) this;
        }

        public Criteria andBduserNotBetween(String value1, String value2) {
            addCriterion("bduser not between", value1, value2, "bduser");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelIsNull() {
            addCriterion("platformlevel is null");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelIsNotNull() {
            addCriterion("platformlevel is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelEqualTo(Integer value) {
            addCriterion("platformlevel =", value, "platformlevel");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelNotEqualTo(Integer value) {
            addCriterion("platformlevel <>", value, "platformlevel");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelGreaterThan(Integer value) {
            addCriterion("platformlevel >", value, "platformlevel");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("platformlevel >=", value, "platformlevel");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelLessThan(Integer value) {
            addCriterion("platformlevel <", value, "platformlevel");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelLessThanOrEqualTo(Integer value) {
            addCriterion("platformlevel <=", value, "platformlevel");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelIn(List<Integer> values) {
            addCriterion("platformlevel in", values, "platformlevel");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelNotIn(List<Integer> values) {
            addCriterion("platformlevel not in", values, "platformlevel");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelBetween(Integer value1, Integer value2) {
            addCriterion("platformlevel between", value1, value2, "platformlevel");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelNotBetween(Integer value1, Integer value2) {
            addCriterion("platformlevel not between", value1, value2, "platformlevel");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andGeneratesubidIsNull() {
            addCriterion("generatesubid is null");
            return (Criteria) this;
        }

        public Criteria andGeneratesubidIsNotNull() {
            addCriterion("generatesubid is not null");
            return (Criteria) this;
        }

        public Criteria andGeneratesubidEqualTo(Integer value) {
            addCriterion("generatesubid =", value, "generatesubid");
            return (Criteria) this;
        }

        public Criteria andGeneratesubidNotEqualTo(Integer value) {
            addCriterion("generatesubid <>", value, "generatesubid");
            return (Criteria) this;
        }

        public Criteria andGeneratesubidGreaterThan(Integer value) {
            addCriterion("generatesubid >", value, "generatesubid");
            return (Criteria) this;
        }

        public Criteria andGeneratesubidGreaterThanOrEqualTo(Integer value) {
            addCriterion("generatesubid >=", value, "generatesubid");
            return (Criteria) this;
        }

        public Criteria andGeneratesubidLessThan(Integer value) {
            addCriterion("generatesubid <", value, "generatesubid");
            return (Criteria) this;
        }

        public Criteria andGeneratesubidLessThanOrEqualTo(Integer value) {
            addCriterion("generatesubid <=", value, "generatesubid");
            return (Criteria) this;
        }

        public Criteria andGeneratesubidIn(List<Integer> values) {
            addCriterion("generatesubid in", values, "generatesubid");
            return (Criteria) this;
        }

        public Criteria andGeneratesubidNotIn(List<Integer> values) {
            addCriterion("generatesubid not in", values, "generatesubid");
            return (Criteria) this;
        }

        public Criteria andGeneratesubidBetween(Integer value1, Integer value2) {
            addCriterion("generatesubid between", value1, value2, "generatesubid");
            return (Criteria) this;
        }

        public Criteria andGeneratesubidNotBetween(Integer value1, Integer value2) {
            addCriterion("generatesubid not between", value1, value2, "generatesubid");
            return (Criteria) this;
        }

        public Criteria andAutoopenIsNull() {
            addCriterion("autoopen is null");
            return (Criteria) this;
        }

        public Criteria andAutoopenIsNotNull() {
            addCriterion("autoopen is not null");
            return (Criteria) this;
        }

        public Criteria andAutoopenEqualTo(Integer value) {
            addCriterion("autoopen =", value, "autoopen");
            return (Criteria) this;
        }

        public Criteria andAutoopenNotEqualTo(Integer value) {
            addCriterion("autoopen <>", value, "autoopen");
            return (Criteria) this;
        }

        public Criteria andAutoopenGreaterThan(Integer value) {
            addCriterion("autoopen >", value, "autoopen");
            return (Criteria) this;
        }

        public Criteria andAutoopenGreaterThanOrEqualTo(Integer value) {
            addCriterion("autoopen >=", value, "autoopen");
            return (Criteria) this;
        }

        public Criteria andAutoopenLessThan(Integer value) {
            addCriterion("autoopen <", value, "autoopen");
            return (Criteria) this;
        }

        public Criteria andAutoopenLessThanOrEqualTo(Integer value) {
            addCriterion("autoopen <=", value, "autoopen");
            return (Criteria) this;
        }

        public Criteria andAutoopenIn(List<Integer> values) {
            addCriterion("autoopen in", values, "autoopen");
            return (Criteria) this;
        }

        public Criteria andAutoopenNotIn(List<Integer> values) {
            addCriterion("autoopen not in", values, "autoopen");
            return (Criteria) this;
        }

        public Criteria andAutoopenBetween(Integer value1, Integer value2) {
            addCriterion("autoopen between", value1, value2, "autoopen");
            return (Criteria) this;
        }

        public Criteria andAutoopenNotBetween(Integer value1, Integer value2) {
            addCriterion("autoopen not between", value1, value2, "autoopen");
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

        public Criteria andPostbackIsNull() {
            addCriterion("postback is null");
            return (Criteria) this;
        }

        public Criteria andPostbackIsNotNull() {
            addCriterion("postback is not null");
            return (Criteria) this;
        }

        public Criteria andPostbackEqualTo(String value) {
            addCriterion("postback =", value, "postback");
            return (Criteria) this;
        }

        public Criteria andPostbackNotEqualTo(String value) {
            addCriterion("postback <>", value, "postback");
            return (Criteria) this;
        }

        public Criteria andPostbackGreaterThan(String value) {
            addCriterion("postback >", value, "postback");
            return (Criteria) this;
        }

        public Criteria andPostbackGreaterThanOrEqualTo(String value) {
            addCriterion("postback >=", value, "postback");
            return (Criteria) this;
        }

        public Criteria andPostbackLessThan(String value) {
            addCriterion("postback <", value, "postback");
            return (Criteria) this;
        }

        public Criteria andPostbackLessThanOrEqualTo(String value) {
            addCriterion("postback <=", value, "postback");
            return (Criteria) this;
        }

        public Criteria andPostbackLike(String value) {
            addCriterion("postback like", value, "postback");
            return (Criteria) this;
        }

        public Criteria andPostbackNotLike(String value) {
            addCriterion("postback not like", value, "postback");
            return (Criteria) this;
        }

        public Criteria andPostbackIn(List<String> values) {
            addCriterion("postback in", values, "postback");
            return (Criteria) this;
        }

        public Criteria andPostbackNotIn(List<String> values) {
            addCriterion("postback not in", values, "postback");
            return (Criteria) this;
        }

        public Criteria andPostbackBetween(String value1, String value2) {
            addCriterion("postback between", value1, value2, "postback");
            return (Criteria) this;
        }

        public Criteria andPostbackNotBetween(String value1, String value2) {
            addCriterion("postback not between", value1, value2, "postback");
            return (Criteria) this;
        }

        public Criteria andDirectguestIsNull() {
            addCriterion("directguest is null");
            return (Criteria) this;
        }

        public Criteria andDirectguestIsNotNull() {
            addCriterion("directguest is not null");
            return (Criteria) this;
        }

        public Criteria andDirectguestEqualTo(Integer value) {
            addCriterion("directguest =", value, "directguest");
            return (Criteria) this;
        }

        public Criteria andDirectguestNotEqualTo(Integer value) {
            addCriterion("directguest <>", value, "directguest");
            return (Criteria) this;
        }

        public Criteria andDirectguestGreaterThan(Integer value) {
            addCriterion("directguest >", value, "directguest");
            return (Criteria) this;
        }

        public Criteria andDirectguestGreaterThanOrEqualTo(Integer value) {
            addCriterion("directguest >=", value, "directguest");
            return (Criteria) this;
        }

        public Criteria andDirectguestLessThan(Integer value) {
            addCriterion("directguest <", value, "directguest");
            return (Criteria) this;
        }

        public Criteria andDirectguestLessThanOrEqualTo(Integer value) {
            addCriterion("directguest <=", value, "directguest");
            return (Criteria) this;
        }

        public Criteria andDirectguestIn(List<Integer> values) {
            addCriterion("directguest in", values, "directguest");
            return (Criteria) this;
        }

        public Criteria andDirectguestNotIn(List<Integer> values) {
            addCriterion("directguest not in", values, "directguest");
            return (Criteria) this;
        }

        public Criteria andDirectguestBetween(Integer value1, Integer value2) {
            addCriterion("directguest between", value1, value2, "directguest");
            return (Criteria) this;
        }

        public Criteria andDirectguestNotBetween(Integer value1, Integer value2) {
            addCriterion("directguest not between", value1, value2, "directguest");
            return (Criteria) this;
        }

        public Criteria andPayeventIsNull() {
            addCriterion("payevent is null");
            return (Criteria) this;
        }

        public Criteria andPayeventIsNotNull() {
            addCriterion("payevent is not null");
            return (Criteria) this;
        }

        public Criteria andPayeventEqualTo(String value) {
            addCriterion("payevent =", value, "payevent");
            return (Criteria) this;
        }

        public Criteria andPayeventNotEqualTo(String value) {
            addCriterion("payevent <>", value, "payevent");
            return (Criteria) this;
        }

        public Criteria andPayeventGreaterThan(String value) {
            addCriterion("payevent >", value, "payevent");
            return (Criteria) this;
        }

        public Criteria andPayeventGreaterThanOrEqualTo(String value) {
            addCriterion("payevent >=", value, "payevent");
            return (Criteria) this;
        }

        public Criteria andPayeventLessThan(String value) {
            addCriterion("payevent <", value, "payevent");
            return (Criteria) this;
        }

        public Criteria andPayeventLessThanOrEqualTo(String value) {
            addCriterion("payevent <=", value, "payevent");
            return (Criteria) this;
        }

        public Criteria andPayeventLike(String value) {
            addCriterion("payevent like", value, "payevent");
            return (Criteria) this;
        }

        public Criteria andPayeventNotLike(String value) {
            addCriterion("payevent not like", value, "payevent");
            return (Criteria) this;
        }

        public Criteria andPayeventIn(List<String> values) {
            addCriterion("payevent in", values, "payevent");
            return (Criteria) this;
        }

        public Criteria andPayeventNotIn(List<String> values) {
            addCriterion("payevent not in", values, "payevent");
            return (Criteria) this;
        }

        public Criteria andPayeventBetween(String value1, String value2) {
            addCriterion("payevent between", value1, value2, "payevent");
            return (Criteria) this;
        }

        public Criteria andPayeventNotBetween(String value1, String value2) {
            addCriterion("payevent not between", value1, value2, "payevent");
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