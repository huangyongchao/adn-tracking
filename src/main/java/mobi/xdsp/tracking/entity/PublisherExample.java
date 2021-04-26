package mobi.xdsp.tracking.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PublisherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public PublisherExample() {
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

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andCompanynameIsNull() {
            addCriterion("companyname is null");
            return (Criteria) this;
        }

        public Criteria andCompanynameIsNotNull() {
            addCriterion("companyname is not null");
            return (Criteria) this;
        }

        public Criteria andCompanynameEqualTo(String value) {
            addCriterion("companyname =", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotEqualTo(String value) {
            addCriterion("companyname <>", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameGreaterThan(String value) {
            addCriterion("companyname >", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameGreaterThanOrEqualTo(String value) {
            addCriterion("companyname >=", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLessThan(String value) {
            addCriterion("companyname <", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLessThanOrEqualTo(String value) {
            addCriterion("companyname <=", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLike(String value) {
            addCriterion("companyname like", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotLike(String value) {
            addCriterion("companyname not like", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameIn(List<String> values) {
            addCriterion("companyname in", values, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotIn(List<String> values) {
            addCriterion("companyname not in", values, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameBetween(String value1, String value2) {
            addCriterion("companyname between", value1, value2, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotBetween(String value1, String value2) {
            addCriterion("companyname not between", value1, value2, "companyname");
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

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddress2IsNull() {
            addCriterion("address2 is null");
            return (Criteria) this;
        }

        public Criteria andAddress2IsNotNull() {
            addCriterion("address2 is not null");
            return (Criteria) this;
        }

        public Criteria andAddress2EqualTo(String value) {
            addCriterion("address2 =", value, "address2");
            return (Criteria) this;
        }

        public Criteria andAddress2NotEqualTo(String value) {
            addCriterion("address2 <>", value, "address2");
            return (Criteria) this;
        }

        public Criteria andAddress2GreaterThan(String value) {
            addCriterion("address2 >", value, "address2");
            return (Criteria) this;
        }

        public Criteria andAddress2GreaterThanOrEqualTo(String value) {
            addCriterion("address2 >=", value, "address2");
            return (Criteria) this;
        }

        public Criteria andAddress2LessThan(String value) {
            addCriterion("address2 <", value, "address2");
            return (Criteria) this;
        }

        public Criteria andAddress2LessThanOrEqualTo(String value) {
            addCriterion("address2 <=", value, "address2");
            return (Criteria) this;
        }

        public Criteria andAddress2Like(String value) {
            addCriterion("address2 like", value, "address2");
            return (Criteria) this;
        }

        public Criteria andAddress2NotLike(String value) {
            addCriterion("address2 not like", value, "address2");
            return (Criteria) this;
        }

        public Criteria andAddress2In(List<String> values) {
            addCriterion("address2 in", values, "address2");
            return (Criteria) this;
        }

        public Criteria andAddress2NotIn(List<String> values) {
            addCriterion("address2 not in", values, "address2");
            return (Criteria) this;
        }

        public Criteria andAddress2Between(String value1, String value2) {
            addCriterion("address2 between", value1, value2, "address2");
            return (Criteria) this;
        }

        public Criteria andAddress2NotBetween(String value1, String value2) {
            addCriterion("address2 not between", value1, value2, "address2");
            return (Criteria) this;
        }

        public Criteria andWorkphoneIsNull() {
            addCriterion("workphone is null");
            return (Criteria) this;
        }

        public Criteria andWorkphoneIsNotNull() {
            addCriterion("workphone is not null");
            return (Criteria) this;
        }

        public Criteria andWorkphoneEqualTo(String value) {
            addCriterion("workphone =", value, "workphone");
            return (Criteria) this;
        }

        public Criteria andWorkphoneNotEqualTo(String value) {
            addCriterion("workphone <>", value, "workphone");
            return (Criteria) this;
        }

        public Criteria andWorkphoneGreaterThan(String value) {
            addCriterion("workphone >", value, "workphone");
            return (Criteria) this;
        }

        public Criteria andWorkphoneGreaterThanOrEqualTo(String value) {
            addCriterion("workphone >=", value, "workphone");
            return (Criteria) this;
        }

        public Criteria andWorkphoneLessThan(String value) {
            addCriterion("workphone <", value, "workphone");
            return (Criteria) this;
        }

        public Criteria andWorkphoneLessThanOrEqualTo(String value) {
            addCriterion("workphone <=", value, "workphone");
            return (Criteria) this;
        }

        public Criteria andWorkphoneLike(String value) {
            addCriterion("workphone like", value, "workphone");
            return (Criteria) this;
        }

        public Criteria andWorkphoneNotLike(String value) {
            addCriterion("workphone not like", value, "workphone");
            return (Criteria) this;
        }

        public Criteria andWorkphoneIn(List<String> values) {
            addCriterion("workphone in", values, "workphone");
            return (Criteria) this;
        }

        public Criteria andWorkphoneNotIn(List<String> values) {
            addCriterion("workphone not in", values, "workphone");
            return (Criteria) this;
        }

        public Criteria andWorkphoneBetween(String value1, String value2) {
            addCriterion("workphone between", value1, value2, "workphone");
            return (Criteria) this;
        }

        public Criteria andWorkphoneNotBetween(String value1, String value2) {
            addCriterion("workphone not between", value1, value2, "workphone");
            return (Criteria) this;
        }

        public Criteria andBillinginfoIsNull() {
            addCriterion("billinginfo is null");
            return (Criteria) this;
        }

        public Criteria andBillinginfoIsNotNull() {
            addCriterion("billinginfo is not null");
            return (Criteria) this;
        }

        public Criteria andBillinginfoEqualTo(String value) {
            addCriterion("billinginfo =", value, "billinginfo");
            return (Criteria) this;
        }

        public Criteria andBillinginfoNotEqualTo(String value) {
            addCriterion("billinginfo <>", value, "billinginfo");
            return (Criteria) this;
        }

        public Criteria andBillinginfoGreaterThan(String value) {
            addCriterion("billinginfo >", value, "billinginfo");
            return (Criteria) this;
        }

        public Criteria andBillinginfoGreaterThanOrEqualTo(String value) {
            addCriterion("billinginfo >=", value, "billinginfo");
            return (Criteria) this;
        }

        public Criteria andBillinginfoLessThan(String value) {
            addCriterion("billinginfo <", value, "billinginfo");
            return (Criteria) this;
        }

        public Criteria andBillinginfoLessThanOrEqualTo(String value) {
            addCriterion("billinginfo <=", value, "billinginfo");
            return (Criteria) this;
        }

        public Criteria andBillinginfoLike(String value) {
            addCriterion("billinginfo like", value, "billinginfo");
            return (Criteria) this;
        }

        public Criteria andBillinginfoNotLike(String value) {
            addCriterion("billinginfo not like", value, "billinginfo");
            return (Criteria) this;
        }

        public Criteria andBillinginfoIn(List<String> values) {
            addCriterion("billinginfo in", values, "billinginfo");
            return (Criteria) this;
        }

        public Criteria andBillinginfoNotIn(List<String> values) {
            addCriterion("billinginfo not in", values, "billinginfo");
            return (Criteria) this;
        }

        public Criteria andBillinginfoBetween(String value1, String value2) {
            addCriterion("billinginfo between", value1, value2, "billinginfo");
            return (Criteria) this;
        }

        public Criteria andBillinginfoNotBetween(String value1, String value2) {
            addCriterion("billinginfo not between", value1, value2, "billinginfo");
            return (Criteria) this;
        }

        public Criteria andApplytypeIsNull() {
            addCriterion("applytype is null");
            return (Criteria) this;
        }

        public Criteria andApplytypeIsNotNull() {
            addCriterion("applytype is not null");
            return (Criteria) this;
        }

        public Criteria andApplytypeEqualTo(Integer value) {
            addCriterion("applytype =", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotEqualTo(Integer value) {
            addCriterion("applytype <>", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeGreaterThan(Integer value) {
            addCriterion("applytype >", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("applytype >=", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeLessThan(Integer value) {
            addCriterion("applytype <", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeLessThanOrEqualTo(Integer value) {
            addCriterion("applytype <=", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeIn(List<Integer> values) {
            addCriterion("applytype in", values, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotIn(List<Integer> values) {
            addCriterion("applytype not in", values, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeBetween(Integer value1, Integer value2) {
            addCriterion("applytype between", value1, value2, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotBetween(Integer value1, Integer value2) {
            addCriterion("applytype not between", value1, value2, "applytype");
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

        public Criteria andDailybudgetEqualTo(BigDecimal value) {
            addCriterion("dailybudget =", value, "dailybudget");
            return (Criteria) this;
        }

        public Criteria andDailybudgetNotEqualTo(BigDecimal value) {
            addCriterion("dailybudget <>", value, "dailybudget");
            return (Criteria) this;
        }

        public Criteria andDailybudgetGreaterThan(BigDecimal value) {
            addCriterion("dailybudget >", value, "dailybudget");
            return (Criteria) this;
        }

        public Criteria andDailybudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dailybudget >=", value, "dailybudget");
            return (Criteria) this;
        }

        public Criteria andDailybudgetLessThan(BigDecimal value) {
            addCriterion("dailybudget <", value, "dailybudget");
            return (Criteria) this;
        }

        public Criteria andDailybudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dailybudget <=", value, "dailybudget");
            return (Criteria) this;
        }

        public Criteria andDailybudgetIn(List<BigDecimal> values) {
            addCriterion("dailybudget in", values, "dailybudget");
            return (Criteria) this;
        }

        public Criteria andDailybudgetNotIn(List<BigDecimal> values) {
            addCriterion("dailybudget not in", values, "dailybudget");
            return (Criteria) this;
        }

        public Criteria andDailybudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dailybudget between", value1, value2, "dailybudget");
            return (Criteria) this;
        }

        public Criteria andDailybudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dailybudget not between", value1, value2, "dailybudget");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetIsNull() {
            addCriterion("monthbudget is null");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetIsNotNull() {
            addCriterion("monthbudget is not null");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetEqualTo(BigDecimal value) {
            addCriterion("monthbudget =", value, "monthbudget");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetNotEqualTo(BigDecimal value) {
            addCriterion("monthbudget <>", value, "monthbudget");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetGreaterThan(BigDecimal value) {
            addCriterion("monthbudget >", value, "monthbudget");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("monthbudget >=", value, "monthbudget");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetLessThan(BigDecimal value) {
            addCriterion("monthbudget <", value, "monthbudget");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("monthbudget <=", value, "monthbudget");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetIn(List<BigDecimal> values) {
            addCriterion("monthbudget in", values, "monthbudget");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetNotIn(List<BigDecimal> values) {
            addCriterion("monthbudget not in", values, "monthbudget");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthbudget between", value1, value2, "monthbudget");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthbudget not between", value1, value2, "monthbudget");
            return (Criteria) this;
        }

        public Criteria andDailycapIsNull() {
            addCriterion("dailycap is null");
            return (Criteria) this;
        }

        public Criteria andDailycapIsNotNull() {
            addCriterion("dailycap is not null");
            return (Criteria) this;
        }

        public Criteria andDailycapEqualTo(Integer value) {
            addCriterion("dailycap =", value, "dailycap");
            return (Criteria) this;
        }

        public Criteria andDailycapNotEqualTo(Integer value) {
            addCriterion("dailycap <>", value, "dailycap");
            return (Criteria) this;
        }

        public Criteria andDailycapGreaterThan(Integer value) {
            addCriterion("dailycap >", value, "dailycap");
            return (Criteria) this;
        }

        public Criteria andDailycapGreaterThanOrEqualTo(Integer value) {
            addCriterion("dailycap >=", value, "dailycap");
            return (Criteria) this;
        }

        public Criteria andDailycapLessThan(Integer value) {
            addCriterion("dailycap <", value, "dailycap");
            return (Criteria) this;
        }

        public Criteria andDailycapLessThanOrEqualTo(Integer value) {
            addCriterion("dailycap <=", value, "dailycap");
            return (Criteria) this;
        }

        public Criteria andDailycapIn(List<Integer> values) {
            addCriterion("dailycap in", values, "dailycap");
            return (Criteria) this;
        }

        public Criteria andDailycapNotIn(List<Integer> values) {
            addCriterion("dailycap not in", values, "dailycap");
            return (Criteria) this;
        }

        public Criteria andDailycapBetween(Integer value1, Integer value2) {
            addCriterion("dailycap between", value1, value2, "dailycap");
            return (Criteria) this;
        }

        public Criteria andDailycapNotBetween(Integer value1, Integer value2) {
            addCriterion("dailycap not between", value1, value2, "dailycap");
            return (Criteria) this;
        }

        public Criteria andMonthcapIsNull() {
            addCriterion("monthcap is null");
            return (Criteria) this;
        }

        public Criteria andMonthcapIsNotNull() {
            addCriterion("monthcap is not null");
            return (Criteria) this;
        }

        public Criteria andMonthcapEqualTo(Integer value) {
            addCriterion("monthcap =", value, "monthcap");
            return (Criteria) this;
        }

        public Criteria andMonthcapNotEqualTo(Integer value) {
            addCriterion("monthcap <>", value, "monthcap");
            return (Criteria) this;
        }

        public Criteria andMonthcapGreaterThan(Integer value) {
            addCriterion("monthcap >", value, "monthcap");
            return (Criteria) this;
        }

        public Criteria andMonthcapGreaterThanOrEqualTo(Integer value) {
            addCriterion("monthcap >=", value, "monthcap");
            return (Criteria) this;
        }

        public Criteria andMonthcapLessThan(Integer value) {
            addCriterion("monthcap <", value, "monthcap");
            return (Criteria) this;
        }

        public Criteria andMonthcapLessThanOrEqualTo(Integer value) {
            addCriterion("monthcap <=", value, "monthcap");
            return (Criteria) this;
        }

        public Criteria andMonthcapIn(List<Integer> values) {
            addCriterion("monthcap in", values, "monthcap");
            return (Criteria) this;
        }

        public Criteria andMonthcapNotIn(List<Integer> values) {
            addCriterion("monthcap not in", values, "monthcap");
            return (Criteria) this;
        }

        public Criteria andMonthcapBetween(Integer value1, Integer value2) {
            addCriterion("monthcap between", value1, value2, "monthcap");
            return (Criteria) this;
        }

        public Criteria andMonthcapNotBetween(Integer value1, Integer value2) {
            addCriterion("monthcap not between", value1, value2, "monthcap");
            return (Criteria) this;
        }

        public Criteria andClickcapIsNull() {
            addCriterion("clickcap is null");
            return (Criteria) this;
        }

        public Criteria andClickcapIsNotNull() {
            addCriterion("clickcap is not null");
            return (Criteria) this;
        }

        public Criteria andClickcapEqualTo(Integer value) {
            addCriterion("clickcap =", value, "clickcap");
            return (Criteria) this;
        }

        public Criteria andClickcapNotEqualTo(Integer value) {
            addCriterion("clickcap <>", value, "clickcap");
            return (Criteria) this;
        }

        public Criteria andClickcapGreaterThan(Integer value) {
            addCriterion("clickcap >", value, "clickcap");
            return (Criteria) this;
        }

        public Criteria andClickcapGreaterThanOrEqualTo(Integer value) {
            addCriterion("clickcap >=", value, "clickcap");
            return (Criteria) this;
        }

        public Criteria andClickcapLessThan(Integer value) {
            addCriterion("clickcap <", value, "clickcap");
            return (Criteria) this;
        }

        public Criteria andClickcapLessThanOrEqualTo(Integer value) {
            addCriterion("clickcap <=", value, "clickcap");
            return (Criteria) this;
        }

        public Criteria andClickcapIn(List<Integer> values) {
            addCriterion("clickcap in", values, "clickcap");
            return (Criteria) this;
        }

        public Criteria andClickcapNotIn(List<Integer> values) {
            addCriterion("clickcap not in", values, "clickcap");
            return (Criteria) this;
        }

        public Criteria andClickcapBetween(Integer value1, Integer value2) {
            addCriterion("clickcap between", value1, value2, "clickcap");
            return (Criteria) this;
        }

        public Criteria andClickcapNotBetween(Integer value1, Integer value2) {
            addCriterion("clickcap not between", value1, value2, "clickcap");
            return (Criteria) this;
        }

        public Criteria andPayoutrateIsNull() {
            addCriterion("payoutrate is null");
            return (Criteria) this;
        }

        public Criteria andPayoutrateIsNotNull() {
            addCriterion("payoutrate is not null");
            return (Criteria) this;
        }

        public Criteria andPayoutrateEqualTo(Integer value) {
            addCriterion("payoutrate =", value, "payoutrate");
            return (Criteria) this;
        }

        public Criteria andPayoutrateNotEqualTo(Integer value) {
            addCriterion("payoutrate <>", value, "payoutrate");
            return (Criteria) this;
        }

        public Criteria andPayoutrateGreaterThan(Integer value) {
            addCriterion("payoutrate >", value, "payoutrate");
            return (Criteria) this;
        }

        public Criteria andPayoutrateGreaterThanOrEqualTo(Integer value) {
            addCriterion("payoutrate >=", value, "payoutrate");
            return (Criteria) this;
        }

        public Criteria andPayoutrateLessThan(Integer value) {
            addCriterion("payoutrate <", value, "payoutrate");
            return (Criteria) this;
        }

        public Criteria andPayoutrateLessThanOrEqualTo(Integer value) {
            addCriterion("payoutrate <=", value, "payoutrate");
            return (Criteria) this;
        }

        public Criteria andPayoutrateIn(List<Integer> values) {
            addCriterion("payoutrate in", values, "payoutrate");
            return (Criteria) this;
        }

        public Criteria andPayoutrateNotIn(List<Integer> values) {
            addCriterion("payoutrate not in", values, "payoutrate");
            return (Criteria) this;
        }

        public Criteria andPayoutrateBetween(Integer value1, Integer value2) {
            addCriterion("payoutrate between", value1, value2, "payoutrate");
            return (Criteria) this;
        }

        public Criteria andPayoutrateNotBetween(Integer value1, Integer value2) {
            addCriterion("payoutrate not between", value1, value2, "payoutrate");
            return (Criteria) this;
        }

        public Criteria andRedirectIsNull() {
            addCriterion("redirect is null");
            return (Criteria) this;
        }

        public Criteria andRedirectIsNotNull() {
            addCriterion("redirect is not null");
            return (Criteria) this;
        }

        public Criteria andRedirectEqualTo(Integer value) {
            addCriterion("redirect =", value, "redirect");
            return (Criteria) this;
        }

        public Criteria andRedirectNotEqualTo(Integer value) {
            addCriterion("redirect <>", value, "redirect");
            return (Criteria) this;
        }

        public Criteria andRedirectGreaterThan(Integer value) {
            addCriterion("redirect >", value, "redirect");
            return (Criteria) this;
        }

        public Criteria andRedirectGreaterThanOrEqualTo(Integer value) {
            addCriterion("redirect >=", value, "redirect");
            return (Criteria) this;
        }

        public Criteria andRedirectLessThan(Integer value) {
            addCriterion("redirect <", value, "redirect");
            return (Criteria) this;
        }

        public Criteria andRedirectLessThanOrEqualTo(Integer value) {
            addCriterion("redirect <=", value, "redirect");
            return (Criteria) this;
        }

        public Criteria andRedirectIn(List<Integer> values) {
            addCriterion("redirect in", values, "redirect");
            return (Criteria) this;
        }

        public Criteria andRedirectNotIn(List<Integer> values) {
            addCriterion("redirect not in", values, "redirect");
            return (Criteria) this;
        }

        public Criteria andRedirectBetween(Integer value1, Integer value2) {
            addCriterion("redirect between", value1, value2, "redirect");
            return (Criteria) this;
        }

        public Criteria andRedirectNotBetween(Integer value1, Integer value2) {
            addCriterion("redirect not between", value1, value2, "redirect");
            return (Criteria) this;
        }

        public Criteria andPostbackurlIsNull() {
            addCriterion("postbackurl is null");
            return (Criteria) this;
        }

        public Criteria andPostbackurlIsNotNull() {
            addCriterion("postbackurl is not null");
            return (Criteria) this;
        }

        public Criteria andPostbackurlEqualTo(String value) {
            addCriterion("postbackurl =", value, "postbackurl");
            return (Criteria) this;
        }

        public Criteria andPostbackurlNotEqualTo(String value) {
            addCriterion("postbackurl <>", value, "postbackurl");
            return (Criteria) this;
        }

        public Criteria andPostbackurlGreaterThan(String value) {
            addCriterion("postbackurl >", value, "postbackurl");
            return (Criteria) this;
        }

        public Criteria andPostbackurlGreaterThanOrEqualTo(String value) {
            addCriterion("postbackurl >=", value, "postbackurl");
            return (Criteria) this;
        }

        public Criteria andPostbackurlLessThan(String value) {
            addCriterion("postbackurl <", value, "postbackurl");
            return (Criteria) this;
        }

        public Criteria andPostbackurlLessThanOrEqualTo(String value) {
            addCriterion("postbackurl <=", value, "postbackurl");
            return (Criteria) this;
        }

        public Criteria andPostbackurlLike(String value) {
            addCriterion("postbackurl like", value, "postbackurl");
            return (Criteria) this;
        }

        public Criteria andPostbackurlNotLike(String value) {
            addCriterion("postbackurl not like", value, "postbackurl");
            return (Criteria) this;
        }

        public Criteria andPostbackurlIn(List<String> values) {
            addCriterion("postbackurl in", values, "postbackurl");
            return (Criteria) this;
        }

        public Criteria andPostbackurlNotIn(List<String> values) {
            addCriterion("postbackurl not in", values, "postbackurl");
            return (Criteria) this;
        }

        public Criteria andPostbackurlBetween(String value1, String value2) {
            addCriterion("postbackurl between", value1, value2, "postbackurl");
            return (Criteria) this;
        }

        public Criteria andPostbackurlNotBetween(String value1, String value2) {
            addCriterion("postbackurl not between", value1, value2, "postbackurl");
            return (Criteria) this;
        }

        public Criteria andPostbackeventurlIsNull() {
            addCriterion("postbackeventurl is null");
            return (Criteria) this;
        }

        public Criteria andPostbackeventurlIsNotNull() {
            addCriterion("postbackeventurl is not null");
            return (Criteria) this;
        }

        public Criteria andPostbackeventurlEqualTo(String value) {
            addCriterion("postbackeventurl =", value, "postbackeventurl");
            return (Criteria) this;
        }

        public Criteria andPostbackeventurlNotEqualTo(String value) {
            addCriterion("postbackeventurl <>", value, "postbackeventurl");
            return (Criteria) this;
        }

        public Criteria andPostbackeventurlGreaterThan(String value) {
            addCriterion("postbackeventurl >", value, "postbackeventurl");
            return (Criteria) this;
        }

        public Criteria andPostbackeventurlGreaterThanOrEqualTo(String value) {
            addCriterion("postbackeventurl >=", value, "postbackeventurl");
            return (Criteria) this;
        }

        public Criteria andPostbackeventurlLessThan(String value) {
            addCriterion("postbackeventurl <", value, "postbackeventurl");
            return (Criteria) this;
        }

        public Criteria andPostbackeventurlLessThanOrEqualTo(String value) {
            addCriterion("postbackeventurl <=", value, "postbackeventurl");
            return (Criteria) this;
        }

        public Criteria andPostbackeventurlLike(String value) {
            addCriterion("postbackeventurl like", value, "postbackeventurl");
            return (Criteria) this;
        }

        public Criteria andPostbackeventurlNotLike(String value) {
            addCriterion("postbackeventurl not like", value, "postbackeventurl");
            return (Criteria) this;
        }

        public Criteria andPostbackeventurlIn(List<String> values) {
            addCriterion("postbackeventurl in", values, "postbackeventurl");
            return (Criteria) this;
        }

        public Criteria andPostbackeventurlNotIn(List<String> values) {
            addCriterion("postbackeventurl not in", values, "postbackeventurl");
            return (Criteria) this;
        }

        public Criteria andPostbackeventurlBetween(String value1, String value2) {
            addCriterion("postbackeventurl between", value1, value2, "postbackeventurl");
            return (Criteria) this;
        }

        public Criteria andPostbackeventurlNotBetween(String value1, String value2) {
            addCriterion("postbackeventurl not between", value1, value2, "postbackeventurl");
            return (Criteria) this;
        }

        public Criteria andPostbackstatusIsNull() {
            addCriterion("postbackstatus is null");
            return (Criteria) this;
        }

        public Criteria andPostbackstatusIsNotNull() {
            addCriterion("postbackstatus is not null");
            return (Criteria) this;
        }

        public Criteria andPostbackstatusEqualTo(Integer value) {
            addCriterion("postbackstatus =", value, "postbackstatus");
            return (Criteria) this;
        }

        public Criteria andPostbackstatusNotEqualTo(Integer value) {
            addCriterion("postbackstatus <>", value, "postbackstatus");
            return (Criteria) this;
        }

        public Criteria andPostbackstatusGreaterThan(Integer value) {
            addCriterion("postbackstatus >", value, "postbackstatus");
            return (Criteria) this;
        }

        public Criteria andPostbackstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("postbackstatus >=", value, "postbackstatus");
            return (Criteria) this;
        }

        public Criteria andPostbackstatusLessThan(Integer value) {
            addCriterion("postbackstatus <", value, "postbackstatus");
            return (Criteria) this;
        }

        public Criteria andPostbackstatusLessThanOrEqualTo(Integer value) {
            addCriterion("postbackstatus <=", value, "postbackstatus");
            return (Criteria) this;
        }

        public Criteria andPostbackstatusIn(List<Integer> values) {
            addCriterion("postbackstatus in", values, "postbackstatus");
            return (Criteria) this;
        }

        public Criteria andPostbackstatusNotIn(List<Integer> values) {
            addCriterion("postbackstatus not in", values, "postbackstatus");
            return (Criteria) this;
        }

        public Criteria andPostbackstatusBetween(Integer value1, Integer value2) {
            addCriterion("postbackstatus between", value1, value2, "postbackstatus");
            return (Criteria) this;
        }

        public Criteria andPostbackstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("postbackstatus not between", value1, value2, "postbackstatus");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andLastnameIsNull() {
            addCriterion("lastname is null");
            return (Criteria) this;
        }

        public Criteria andLastnameIsNotNull() {
            addCriterion("lastname is not null");
            return (Criteria) this;
        }

        public Criteria andLastnameEqualTo(String value) {
            addCriterion("lastname =", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameNotEqualTo(String value) {
            addCriterion("lastname <>", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameGreaterThan(String value) {
            addCriterion("lastname >", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameGreaterThanOrEqualTo(String value) {
            addCriterion("lastname >=", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameLessThan(String value) {
            addCriterion("lastname <", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameLessThanOrEqualTo(String value) {
            addCriterion("lastname <=", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameLike(String value) {
            addCriterion("lastname like", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameNotLike(String value) {
            addCriterion("lastname not like", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameIn(List<String> values) {
            addCriterion("lastname in", values, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameNotIn(List<String> values) {
            addCriterion("lastname not in", values, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameBetween(String value1, String value2) {
            addCriterion("lastname between", value1, value2, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameNotBetween(String value1, String value2) {
            addCriterion("lastname not between", value1, value2, "lastname");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNull() {
            addCriterion("createuser is null");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNotNull() {
            addCriterion("createuser is not null");
            return (Criteria) this;
        }

        public Criteria andCreateuserEqualTo(String value) {
            addCriterion("createuser =", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotEqualTo(String value) {
            addCriterion("createuser <>", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThan(String value) {
            addCriterion("createuser >", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("createuser >=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThan(String value) {
            addCriterion("createuser <", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThanOrEqualTo(String value) {
            addCriterion("createuser <=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLike(String value) {
            addCriterion("createuser like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotLike(String value) {
            addCriterion("createuser not like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserIn(List<String> values) {
            addCriterion("createuser in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotIn(List<String> values) {
            addCriterion("createuser not in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserBetween(String value1, String value2) {
            addCriterion("createuser between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotBetween(String value1, String value2) {
            addCriterion("createuser not between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIsNull() {
            addCriterion("updateuser is null");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIsNotNull() {
            addCriterion("updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateuserEqualTo(String value) {
            addCriterion("updateuser =", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotEqualTo(String value) {
            addCriterion("updateuser <>", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserGreaterThan(String value) {
            addCriterion("updateuser >", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("updateuser >=", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLessThan(String value) {
            addCriterion("updateuser <", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("updateuser <=", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLike(String value) {
            addCriterion("updateuser like", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotLike(String value) {
            addCriterion("updateuser not like", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIn(List<String> values) {
            addCriterion("updateuser in", values, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotIn(List<String> values) {
            addCriterion("updateuser not in", values, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserBetween(String value1, String value2) {
            addCriterion("updateuser between", value1, value2, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotBetween(String value1, String value2) {
            addCriterion("updateuser not between", value1, value2, "updateuser");
            return (Criteria) this;
        }

        public Criteria andManageruserIsNull() {
            addCriterion("manageruser is null");
            return (Criteria) this;
        }

        public Criteria andManageruserIsNotNull() {
            addCriterion("manageruser is not null");
            return (Criteria) this;
        }

        public Criteria andManageruserEqualTo(String value) {
            addCriterion("manageruser =", value, "manageruser");
            return (Criteria) this;
        }

        public Criteria andManageruserNotEqualTo(String value) {
            addCriterion("manageruser <>", value, "manageruser");
            return (Criteria) this;
        }

        public Criteria andManageruserGreaterThan(String value) {
            addCriterion("manageruser >", value, "manageruser");
            return (Criteria) this;
        }

        public Criteria andManageruserGreaterThanOrEqualTo(String value) {
            addCriterion("manageruser >=", value, "manageruser");
            return (Criteria) this;
        }

        public Criteria andManageruserLessThan(String value) {
            addCriterion("manageruser <", value, "manageruser");
            return (Criteria) this;
        }

        public Criteria andManageruserLessThanOrEqualTo(String value) {
            addCriterion("manageruser <=", value, "manageruser");
            return (Criteria) this;
        }

        public Criteria andManageruserLike(String value) {
            addCriterion("manageruser like", value, "manageruser");
            return (Criteria) this;
        }

        public Criteria andManageruserNotLike(String value) {
            addCriterion("manageruser not like", value, "manageruser");
            return (Criteria) this;
        }

        public Criteria andManageruserIn(List<String> values) {
            addCriterion("manageruser in", values, "manageruser");
            return (Criteria) this;
        }

        public Criteria andManageruserNotIn(List<String> values) {
            addCriterion("manageruser not in", values, "manageruser");
            return (Criteria) this;
        }

        public Criteria andManageruserBetween(String value1, String value2) {
            addCriterion("manageruser between", value1, value2, "manageruser");
            return (Criteria) this;
        }

        public Criteria andManageruserNotBetween(String value1, String value2) {
            addCriterion("manageruser not between", value1, value2, "manageruser");
            return (Criteria) this;
        }

        public Criteria andRefadvidIsNull() {
            addCriterion("refadvid is null");
            return (Criteria) this;
        }

        public Criteria andRefadvidIsNotNull() {
            addCriterion("refadvid is not null");
            return (Criteria) this;
        }

        public Criteria andRefadvidEqualTo(Integer value) {
            addCriterion("refadvid =", value, "refadvid");
            return (Criteria) this;
        }

        public Criteria andRefadvidNotEqualTo(Integer value) {
            addCriterion("refadvid <>", value, "refadvid");
            return (Criteria) this;
        }

        public Criteria andRefadvidGreaterThan(Integer value) {
            addCriterion("refadvid >", value, "refadvid");
            return (Criteria) this;
        }

        public Criteria andRefadvidGreaterThanOrEqualTo(Integer value) {
            addCriterion("refadvid >=", value, "refadvid");
            return (Criteria) this;
        }

        public Criteria andRefadvidLessThan(Integer value) {
            addCriterion("refadvid <", value, "refadvid");
            return (Criteria) this;
        }

        public Criteria andRefadvidLessThanOrEqualTo(Integer value) {
            addCriterion("refadvid <=", value, "refadvid");
            return (Criteria) this;
        }

        public Criteria andRefadvidIn(List<Integer> values) {
            addCriterion("refadvid in", values, "refadvid");
            return (Criteria) this;
        }

        public Criteria andRefadvidNotIn(List<Integer> values) {
            addCriterion("refadvid not in", values, "refadvid");
            return (Criteria) this;
        }

        public Criteria andRefadvidBetween(Integer value1, Integer value2) {
            addCriterion("refadvid between", value1, value2, "refadvid");
            return (Criteria) this;
        }

        public Criteria andRefadvidNotBetween(Integer value1, Integer value2) {
            addCriterion("refadvid not between", value1, value2, "refadvid");
            return (Criteria) this;
        }

        public Criteria andInnercompanyIsNull() {
            addCriterion("innercompany is null");
            return (Criteria) this;
        }

        public Criteria andInnercompanyIsNotNull() {
            addCriterion("innercompany is not null");
            return (Criteria) this;
        }

        public Criteria andInnercompanyEqualTo(Integer value) {
            addCriterion("innercompany =", value, "innercompany");
            return (Criteria) this;
        }

        public Criteria andInnercompanyNotEqualTo(Integer value) {
            addCriterion("innercompany <>", value, "innercompany");
            return (Criteria) this;
        }

        public Criteria andInnercompanyGreaterThan(Integer value) {
            addCriterion("innercompany >", value, "innercompany");
            return (Criteria) this;
        }

        public Criteria andInnercompanyGreaterThanOrEqualTo(Integer value) {
            addCriterion("innercompany >=", value, "innercompany");
            return (Criteria) this;
        }

        public Criteria andInnercompanyLessThan(Integer value) {
            addCriterion("innercompany <", value, "innercompany");
            return (Criteria) this;
        }

        public Criteria andInnercompanyLessThanOrEqualTo(Integer value) {
            addCriterion("innercompany <=", value, "innercompany");
            return (Criteria) this;
        }

        public Criteria andInnercompanyIn(List<Integer> values) {
            addCriterion("innercompany in", values, "innercompany");
            return (Criteria) this;
        }

        public Criteria andInnercompanyNotIn(List<Integer> values) {
            addCriterion("innercompany not in", values, "innercompany");
            return (Criteria) this;
        }

        public Criteria andInnercompanyBetween(Integer value1, Integer value2) {
            addCriterion("innercompany between", value1, value2, "innercompany");
            return (Criteria) this;
        }

        public Criteria andInnercompanyNotBetween(Integer value1, Integer value2) {
            addCriterion("innercompany not between", value1, value2, "innercompany");
            return (Criteria) this;
        }

        public Criteria andSubemalIsNull() {
            addCriterion("subemal is null");
            return (Criteria) this;
        }

        public Criteria andSubemalIsNotNull() {
            addCriterion("subemal is not null");
            return (Criteria) this;
        }

        public Criteria andSubemalEqualTo(Integer value) {
            addCriterion("subemal =", value, "subemal");
            return (Criteria) this;
        }

        public Criteria andSubemalNotEqualTo(Integer value) {
            addCriterion("subemal <>", value, "subemal");
            return (Criteria) this;
        }

        public Criteria andSubemalGreaterThan(Integer value) {
            addCriterion("subemal >", value, "subemal");
            return (Criteria) this;
        }

        public Criteria andSubemalGreaterThanOrEqualTo(Integer value) {
            addCriterion("subemal >=", value, "subemal");
            return (Criteria) this;
        }

        public Criteria andSubemalLessThan(Integer value) {
            addCriterion("subemal <", value, "subemal");
            return (Criteria) this;
        }

        public Criteria andSubemalLessThanOrEqualTo(Integer value) {
            addCriterion("subemal <=", value, "subemal");
            return (Criteria) this;
        }

        public Criteria andSubemalIn(List<Integer> values) {
            addCriterion("subemal in", values, "subemal");
            return (Criteria) this;
        }

        public Criteria andSubemalNotIn(List<Integer> values) {
            addCriterion("subemal not in", values, "subemal");
            return (Criteria) this;
        }

        public Criteria andSubemalBetween(Integer value1, Integer value2) {
            addCriterion("subemal between", value1, value2, "subemal");
            return (Criteria) this;
        }

        public Criteria andSubemalNotBetween(Integer value1, Integer value2) {
            addCriterion("subemal not between", value1, value2, "subemal");
            return (Criteria) this;
        }

        public Criteria andOpmanagerIsNull() {
            addCriterion("opmanager is null");
            return (Criteria) this;
        }

        public Criteria andOpmanagerIsNotNull() {
            addCriterion("opmanager is not null");
            return (Criteria) this;
        }

        public Criteria andOpmanagerEqualTo(String value) {
            addCriterion("opmanager =", value, "opmanager");
            return (Criteria) this;
        }

        public Criteria andOpmanagerNotEqualTo(String value) {
            addCriterion("opmanager <>", value, "opmanager");
            return (Criteria) this;
        }

        public Criteria andOpmanagerGreaterThan(String value) {
            addCriterion("opmanager >", value, "opmanager");
            return (Criteria) this;
        }

        public Criteria andOpmanagerGreaterThanOrEqualTo(String value) {
            addCriterion("opmanager >=", value, "opmanager");
            return (Criteria) this;
        }

        public Criteria andOpmanagerLessThan(String value) {
            addCriterion("opmanager <", value, "opmanager");
            return (Criteria) this;
        }

        public Criteria andOpmanagerLessThanOrEqualTo(String value) {
            addCriterion("opmanager <=", value, "opmanager");
            return (Criteria) this;
        }

        public Criteria andOpmanagerLike(String value) {
            addCriterion("opmanager like", value, "opmanager");
            return (Criteria) this;
        }

        public Criteria andOpmanagerNotLike(String value) {
            addCriterion("opmanager not like", value, "opmanager");
            return (Criteria) this;
        }

        public Criteria andOpmanagerIn(List<String> values) {
            addCriterion("opmanager in", values, "opmanager");
            return (Criteria) this;
        }

        public Criteria andOpmanagerNotIn(List<String> values) {
            addCriterion("opmanager not in", values, "opmanager");
            return (Criteria) this;
        }

        public Criteria andOpmanagerBetween(String value1, String value2) {
            addCriterion("opmanager between", value1, value2, "opmanager");
            return (Criteria) this;
        }

        public Criteria andOpmanagerNotBetween(String value1, String value2) {
            addCriterion("opmanager not between", value1, value2, "opmanager");
            return (Criteria) this;
        }

        public Criteria andBdmanagerIsNull() {
            addCriterion("bdmanager is null");
            return (Criteria) this;
        }

        public Criteria andBdmanagerIsNotNull() {
            addCriterion("bdmanager is not null");
            return (Criteria) this;
        }

        public Criteria andBdmanagerEqualTo(String value) {
            addCriterion("bdmanager =", value, "bdmanager");
            return (Criteria) this;
        }

        public Criteria andBdmanagerNotEqualTo(String value) {
            addCriterion("bdmanager <>", value, "bdmanager");
            return (Criteria) this;
        }

        public Criteria andBdmanagerGreaterThan(String value) {
            addCriterion("bdmanager >", value, "bdmanager");
            return (Criteria) this;
        }

        public Criteria andBdmanagerGreaterThanOrEqualTo(String value) {
            addCriterion("bdmanager >=", value, "bdmanager");
            return (Criteria) this;
        }

        public Criteria andBdmanagerLessThan(String value) {
            addCriterion("bdmanager <", value, "bdmanager");
            return (Criteria) this;
        }

        public Criteria andBdmanagerLessThanOrEqualTo(String value) {
            addCriterion("bdmanager <=", value, "bdmanager");
            return (Criteria) this;
        }

        public Criteria andBdmanagerLike(String value) {
            addCriterion("bdmanager like", value, "bdmanager");
            return (Criteria) this;
        }

        public Criteria andBdmanagerNotLike(String value) {
            addCriterion("bdmanager not like", value, "bdmanager");
            return (Criteria) this;
        }

        public Criteria andBdmanagerIn(List<String> values) {
            addCriterion("bdmanager in", values, "bdmanager");
            return (Criteria) this;
        }

        public Criteria andBdmanagerNotIn(List<String> values) {
            addCriterion("bdmanager not in", values, "bdmanager");
            return (Criteria) this;
        }

        public Criteria andBdmanagerBetween(String value1, String value2) {
            addCriterion("bdmanager between", value1, value2, "bdmanager");
            return (Criteria) this;
        }

        public Criteria andBdmanagerNotBetween(String value1, String value2) {
            addCriterion("bdmanager not between", value1, value2, "bdmanager");
            return (Criteria) this;
        }

        public Criteria andAutorunIsNull() {
            addCriterion("autorun is null");
            return (Criteria) this;
        }

        public Criteria andAutorunIsNotNull() {
            addCriterion("autorun is not null");
            return (Criteria) this;
        }

        public Criteria andAutorunEqualTo(Integer value) {
            addCriterion("autorun =", value, "autorun");
            return (Criteria) this;
        }

        public Criteria andAutorunNotEqualTo(Integer value) {
            addCriterion("autorun <>", value, "autorun");
            return (Criteria) this;
        }

        public Criteria andAutorunGreaterThan(Integer value) {
            addCriterion("autorun >", value, "autorun");
            return (Criteria) this;
        }

        public Criteria andAutorunGreaterThanOrEqualTo(Integer value) {
            addCriterion("autorun >=", value, "autorun");
            return (Criteria) this;
        }

        public Criteria andAutorunLessThan(Integer value) {
            addCriterion("autorun <", value, "autorun");
            return (Criteria) this;
        }

        public Criteria andAutorunLessThanOrEqualTo(Integer value) {
            addCriterion("autorun <=", value, "autorun");
            return (Criteria) this;
        }

        public Criteria andAutorunIn(List<Integer> values) {
            addCriterion("autorun in", values, "autorun");
            return (Criteria) this;
        }

        public Criteria andAutorunNotIn(List<Integer> values) {
            addCriterion("autorun not in", values, "autorun");
            return (Criteria) this;
        }

        public Criteria andAutorunBetween(Integer value1, Integer value2) {
            addCriterion("autorun between", value1, value2, "autorun");
            return (Criteria) this;
        }

        public Criteria andAutorunNotBetween(Integer value1, Integer value2) {
            addCriterion("autorun not between", value1, value2, "autorun");
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

        public Criteria andAutocloseIsNull() {
            addCriterion("autoclose is null");
            return (Criteria) this;
        }

        public Criteria andAutocloseIsNotNull() {
            addCriterion("autoclose is not null");
            return (Criteria) this;
        }

        public Criteria andAutocloseEqualTo(Integer value) {
            addCriterion("autoclose =", value, "autoclose");
            return (Criteria) this;
        }

        public Criteria andAutocloseNotEqualTo(Integer value) {
            addCriterion("autoclose <>", value, "autoclose");
            return (Criteria) this;
        }

        public Criteria andAutocloseGreaterThan(Integer value) {
            addCriterion("autoclose >", value, "autoclose");
            return (Criteria) this;
        }

        public Criteria andAutocloseGreaterThanOrEqualTo(Integer value) {
            addCriterion("autoclose >=", value, "autoclose");
            return (Criteria) this;
        }

        public Criteria andAutocloseLessThan(Integer value) {
            addCriterion("autoclose <", value, "autoclose");
            return (Criteria) this;
        }

        public Criteria andAutocloseLessThanOrEqualTo(Integer value) {
            addCriterion("autoclose <=", value, "autoclose");
            return (Criteria) this;
        }

        public Criteria andAutocloseIn(List<Integer> values) {
            addCriterion("autoclose in", values, "autoclose");
            return (Criteria) this;
        }

        public Criteria andAutocloseNotIn(List<Integer> values) {
            addCriterion("autoclose not in", values, "autoclose");
            return (Criteria) this;
        }

        public Criteria andAutocloseBetween(Integer value1, Integer value2) {
            addCriterion("autoclose between", value1, value2, "autoclose");
            return (Criteria) this;
        }

        public Criteria andAutocloseNotBetween(Integer value1, Integer value2) {
            addCriterion("autoclose not between", value1, value2, "autoclose");
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

        public Criteria andPlatformlevelEqualTo(String value) {
            addCriterion("platformlevel =", value, "platformlevel");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelNotEqualTo(String value) {
            addCriterion("platformlevel <>", value, "platformlevel");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelGreaterThan(String value) {
            addCriterion("platformlevel >", value, "platformlevel");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelGreaterThanOrEqualTo(String value) {
            addCriterion("platformlevel >=", value, "platformlevel");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelLessThan(String value) {
            addCriterion("platformlevel <", value, "platformlevel");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelLessThanOrEqualTo(String value) {
            addCriterion("platformlevel <=", value, "platformlevel");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelLike(String value) {
            addCriterion("platformlevel like", value, "platformlevel");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelNotLike(String value) {
            addCriterion("platformlevel not like", value, "platformlevel");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelIn(List<String> values) {
            addCriterion("platformlevel in", values, "platformlevel");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelNotIn(List<String> values) {
            addCriterion("platformlevel not in", values, "platformlevel");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelBetween(String value1, String value2) {
            addCriterion("platformlevel between", value1, value2, "platformlevel");
            return (Criteria) this;
        }

        public Criteria andPlatformlevelNotBetween(String value1, String value2) {
            addCriterion("platformlevel not between", value1, value2, "platformlevel");
            return (Criteria) this;
        }

        public Criteria andStrategy1IsNull() {
            addCriterion("strategy1 is null");
            return (Criteria) this;
        }

        public Criteria andStrategy1IsNotNull() {
            addCriterion("strategy1 is not null");
            return (Criteria) this;
        }

        public Criteria andStrategy1EqualTo(String value) {
            addCriterion("strategy1 =", value, "strategy1");
            return (Criteria) this;
        }

        public Criteria andStrategy1NotEqualTo(String value) {
            addCriterion("strategy1 <>", value, "strategy1");
            return (Criteria) this;
        }

        public Criteria andStrategy1GreaterThan(String value) {
            addCriterion("strategy1 >", value, "strategy1");
            return (Criteria) this;
        }

        public Criteria andStrategy1GreaterThanOrEqualTo(String value) {
            addCriterion("strategy1 >=", value, "strategy1");
            return (Criteria) this;
        }

        public Criteria andStrategy1LessThan(String value) {
            addCriterion("strategy1 <", value, "strategy1");
            return (Criteria) this;
        }

        public Criteria andStrategy1LessThanOrEqualTo(String value) {
            addCriterion("strategy1 <=", value, "strategy1");
            return (Criteria) this;
        }

        public Criteria andStrategy1Like(String value) {
            addCriterion("strategy1 like", value, "strategy1");
            return (Criteria) this;
        }

        public Criteria andStrategy1NotLike(String value) {
            addCriterion("strategy1 not like", value, "strategy1");
            return (Criteria) this;
        }

        public Criteria andStrategy1In(List<String> values) {
            addCriterion("strategy1 in", values, "strategy1");
            return (Criteria) this;
        }

        public Criteria andStrategy1NotIn(List<String> values) {
            addCriterion("strategy1 not in", values, "strategy1");
            return (Criteria) this;
        }

        public Criteria andStrategy1Between(String value1, String value2) {
            addCriterion("strategy1 between", value1, value2, "strategy1");
            return (Criteria) this;
        }

        public Criteria andStrategy1NotBetween(String value1, String value2) {
            addCriterion("strategy1 not between", value1, value2, "strategy1");
            return (Criteria) this;
        }

        public Criteria andStrategy2IsNull() {
            addCriterion("strategy2 is null");
            return (Criteria) this;
        }

        public Criteria andStrategy2IsNotNull() {
            addCriterion("strategy2 is not null");
            return (Criteria) this;
        }

        public Criteria andStrategy2EqualTo(String value) {
            addCriterion("strategy2 =", value, "strategy2");
            return (Criteria) this;
        }

        public Criteria andStrategy2NotEqualTo(String value) {
            addCriterion("strategy2 <>", value, "strategy2");
            return (Criteria) this;
        }

        public Criteria andStrategy2GreaterThan(String value) {
            addCriterion("strategy2 >", value, "strategy2");
            return (Criteria) this;
        }

        public Criteria andStrategy2GreaterThanOrEqualTo(String value) {
            addCriterion("strategy2 >=", value, "strategy2");
            return (Criteria) this;
        }

        public Criteria andStrategy2LessThan(String value) {
            addCriterion("strategy2 <", value, "strategy2");
            return (Criteria) this;
        }

        public Criteria andStrategy2LessThanOrEqualTo(String value) {
            addCriterion("strategy2 <=", value, "strategy2");
            return (Criteria) this;
        }

        public Criteria andStrategy2Like(String value) {
            addCriterion("strategy2 like", value, "strategy2");
            return (Criteria) this;
        }

        public Criteria andStrategy2NotLike(String value) {
            addCriterion("strategy2 not like", value, "strategy2");
            return (Criteria) this;
        }

        public Criteria andStrategy2In(List<String> values) {
            addCriterion("strategy2 in", values, "strategy2");
            return (Criteria) this;
        }

        public Criteria andStrategy2NotIn(List<String> values) {
            addCriterion("strategy2 not in", values, "strategy2");
            return (Criteria) this;
        }

        public Criteria andStrategy2Between(String value1, String value2) {
            addCriterion("strategy2 between", value1, value2, "strategy2");
            return (Criteria) this;
        }

        public Criteria andStrategy2NotBetween(String value1, String value2) {
            addCriterion("strategy2 not between", value1, value2, "strategy2");
            return (Criteria) this;
        }

        public Criteria andStrategy3IsNull() {
            addCriterion("strategy3 is null");
            return (Criteria) this;
        }

        public Criteria andStrategy3IsNotNull() {
            addCriterion("strategy3 is not null");
            return (Criteria) this;
        }

        public Criteria andStrategy3EqualTo(String value) {
            addCriterion("strategy3 =", value, "strategy3");
            return (Criteria) this;
        }

        public Criteria andStrategy3NotEqualTo(String value) {
            addCriterion("strategy3 <>", value, "strategy3");
            return (Criteria) this;
        }

        public Criteria andStrategy3GreaterThan(String value) {
            addCriterion("strategy3 >", value, "strategy3");
            return (Criteria) this;
        }

        public Criteria andStrategy3GreaterThanOrEqualTo(String value) {
            addCriterion("strategy3 >=", value, "strategy3");
            return (Criteria) this;
        }

        public Criteria andStrategy3LessThan(String value) {
            addCriterion("strategy3 <", value, "strategy3");
            return (Criteria) this;
        }

        public Criteria andStrategy3LessThanOrEqualTo(String value) {
            addCriterion("strategy3 <=", value, "strategy3");
            return (Criteria) this;
        }

        public Criteria andStrategy3Like(String value) {
            addCriterion("strategy3 like", value, "strategy3");
            return (Criteria) this;
        }

        public Criteria andStrategy3NotLike(String value) {
            addCriterion("strategy3 not like", value, "strategy3");
            return (Criteria) this;
        }

        public Criteria andStrategy3In(List<String> values) {
            addCriterion("strategy3 in", values, "strategy3");
            return (Criteria) this;
        }

        public Criteria andStrategy3NotIn(List<String> values) {
            addCriterion("strategy3 not in", values, "strategy3");
            return (Criteria) this;
        }

        public Criteria andStrategy3Between(String value1, String value2) {
            addCriterion("strategy3 between", value1, value2, "strategy3");
            return (Criteria) this;
        }

        public Criteria andStrategy3NotBetween(String value1, String value2) {
            addCriterion("strategy3 not between", value1, value2, "strategy3");
            return (Criteria) this;
        }

        public Criteria andAutoparam1IsNull() {
            addCriterion("autoparam1 is null");
            return (Criteria) this;
        }

        public Criteria andAutoparam1IsNotNull() {
            addCriterion("autoparam1 is not null");
            return (Criteria) this;
        }

        public Criteria andAutoparam1EqualTo(String value) {
            addCriterion("autoparam1 =", value, "autoparam1");
            return (Criteria) this;
        }

        public Criteria andAutoparam1NotEqualTo(String value) {
            addCriterion("autoparam1 <>", value, "autoparam1");
            return (Criteria) this;
        }

        public Criteria andAutoparam1GreaterThan(String value) {
            addCriterion("autoparam1 >", value, "autoparam1");
            return (Criteria) this;
        }

        public Criteria andAutoparam1GreaterThanOrEqualTo(String value) {
            addCriterion("autoparam1 >=", value, "autoparam1");
            return (Criteria) this;
        }

        public Criteria andAutoparam1LessThan(String value) {
            addCriterion("autoparam1 <", value, "autoparam1");
            return (Criteria) this;
        }

        public Criteria andAutoparam1LessThanOrEqualTo(String value) {
            addCriterion("autoparam1 <=", value, "autoparam1");
            return (Criteria) this;
        }

        public Criteria andAutoparam1Like(String value) {
            addCriterion("autoparam1 like", value, "autoparam1");
            return (Criteria) this;
        }

        public Criteria andAutoparam1NotLike(String value) {
            addCriterion("autoparam1 not like", value, "autoparam1");
            return (Criteria) this;
        }

        public Criteria andAutoparam1In(List<String> values) {
            addCriterion("autoparam1 in", values, "autoparam1");
            return (Criteria) this;
        }

        public Criteria andAutoparam1NotIn(List<String> values) {
            addCriterion("autoparam1 not in", values, "autoparam1");
            return (Criteria) this;
        }

        public Criteria andAutoparam1Between(String value1, String value2) {
            addCriterion("autoparam1 between", value1, value2, "autoparam1");
            return (Criteria) this;
        }

        public Criteria andAutoparam1NotBetween(String value1, String value2) {
            addCriterion("autoparam1 not between", value1, value2, "autoparam1");
            return (Criteria) this;
        }

        public Criteria andAutoparam2IsNull() {
            addCriterion("autoparam2 is null");
            return (Criteria) this;
        }

        public Criteria andAutoparam2IsNotNull() {
            addCriterion("autoparam2 is not null");
            return (Criteria) this;
        }

        public Criteria andAutoparam2EqualTo(String value) {
            addCriterion("autoparam2 =", value, "autoparam2");
            return (Criteria) this;
        }

        public Criteria andAutoparam2NotEqualTo(String value) {
            addCriterion("autoparam2 <>", value, "autoparam2");
            return (Criteria) this;
        }

        public Criteria andAutoparam2GreaterThan(String value) {
            addCriterion("autoparam2 >", value, "autoparam2");
            return (Criteria) this;
        }

        public Criteria andAutoparam2GreaterThanOrEqualTo(String value) {
            addCriterion("autoparam2 >=", value, "autoparam2");
            return (Criteria) this;
        }

        public Criteria andAutoparam2LessThan(String value) {
            addCriterion("autoparam2 <", value, "autoparam2");
            return (Criteria) this;
        }

        public Criteria andAutoparam2LessThanOrEqualTo(String value) {
            addCriterion("autoparam2 <=", value, "autoparam2");
            return (Criteria) this;
        }

        public Criteria andAutoparam2Like(String value) {
            addCriterion("autoparam2 like", value, "autoparam2");
            return (Criteria) this;
        }

        public Criteria andAutoparam2NotLike(String value) {
            addCriterion("autoparam2 not like", value, "autoparam2");
            return (Criteria) this;
        }

        public Criteria andAutoparam2In(List<String> values) {
            addCriterion("autoparam2 in", values, "autoparam2");
            return (Criteria) this;
        }

        public Criteria andAutoparam2NotIn(List<String> values) {
            addCriterion("autoparam2 not in", values, "autoparam2");
            return (Criteria) this;
        }

        public Criteria andAutoparam2Between(String value1, String value2) {
            addCriterion("autoparam2 between", value1, value2, "autoparam2");
            return (Criteria) this;
        }

        public Criteria andAutoparam2NotBetween(String value1, String value2) {
            addCriterion("autoparam2 not between", value1, value2, "autoparam2");
            return (Criteria) this;
        }

        public Criteria andAutoparam3IsNull() {
            addCriterion("autoparam3 is null");
            return (Criteria) this;
        }

        public Criteria andAutoparam3IsNotNull() {
            addCriterion("autoparam3 is not null");
            return (Criteria) this;
        }

        public Criteria andAutoparam3EqualTo(String value) {
            addCriterion("autoparam3 =", value, "autoparam3");
            return (Criteria) this;
        }

        public Criteria andAutoparam3NotEqualTo(String value) {
            addCriterion("autoparam3 <>", value, "autoparam3");
            return (Criteria) this;
        }

        public Criteria andAutoparam3GreaterThan(String value) {
            addCriterion("autoparam3 >", value, "autoparam3");
            return (Criteria) this;
        }

        public Criteria andAutoparam3GreaterThanOrEqualTo(String value) {
            addCriterion("autoparam3 >=", value, "autoparam3");
            return (Criteria) this;
        }

        public Criteria andAutoparam3LessThan(String value) {
            addCriterion("autoparam3 <", value, "autoparam3");
            return (Criteria) this;
        }

        public Criteria andAutoparam3LessThanOrEqualTo(String value) {
            addCriterion("autoparam3 <=", value, "autoparam3");
            return (Criteria) this;
        }

        public Criteria andAutoparam3Like(String value) {
            addCriterion("autoparam3 like", value, "autoparam3");
            return (Criteria) this;
        }

        public Criteria andAutoparam3NotLike(String value) {
            addCriterion("autoparam3 not like", value, "autoparam3");
            return (Criteria) this;
        }

        public Criteria andAutoparam3In(List<String> values) {
            addCriterion("autoparam3 in", values, "autoparam3");
            return (Criteria) this;
        }

        public Criteria andAutoparam3NotIn(List<String> values) {
            addCriterion("autoparam3 not in", values, "autoparam3");
            return (Criteria) this;
        }

        public Criteria andAutoparam3Between(String value1, String value2) {
            addCriterion("autoparam3 between", value1, value2, "autoparam3");
            return (Criteria) this;
        }

        public Criteria andAutoparam3NotBetween(String value1, String value2) {
            addCriterion("autoparam3 not between", value1, value2, "autoparam3");
            return (Criteria) this;
        }

        public Criteria andInstructionsIsNull() {
            addCriterion("instructions is null");
            return (Criteria) this;
        }

        public Criteria andInstructionsIsNotNull() {
            addCriterion("instructions is not null");
            return (Criteria) this;
        }

        public Criteria andInstructionsEqualTo(String value) {
            addCriterion("instructions =", value, "instructions");
            return (Criteria) this;
        }

        public Criteria andInstructionsNotEqualTo(String value) {
            addCriterion("instructions <>", value, "instructions");
            return (Criteria) this;
        }

        public Criteria andInstructionsGreaterThan(String value) {
            addCriterion("instructions >", value, "instructions");
            return (Criteria) this;
        }

        public Criteria andInstructionsGreaterThanOrEqualTo(String value) {
            addCriterion("instructions >=", value, "instructions");
            return (Criteria) this;
        }

        public Criteria andInstructionsLessThan(String value) {
            addCriterion("instructions <", value, "instructions");
            return (Criteria) this;
        }

        public Criteria andInstructionsLessThanOrEqualTo(String value) {
            addCriterion("instructions <=", value, "instructions");
            return (Criteria) this;
        }

        public Criteria andInstructionsLike(String value) {
            addCriterion("instructions like", value, "instructions");
            return (Criteria) this;
        }

        public Criteria andInstructionsNotLike(String value) {
            addCriterion("instructions not like", value, "instructions");
            return (Criteria) this;
        }

        public Criteria andInstructionsIn(List<String> values) {
            addCriterion("instructions in", values, "instructions");
            return (Criteria) this;
        }

        public Criteria andInstructionsNotIn(List<String> values) {
            addCriterion("instructions not in", values, "instructions");
            return (Criteria) this;
        }

        public Criteria andInstructionsBetween(String value1, String value2) {
            addCriterion("instructions between", value1, value2, "instructions");
            return (Criteria) this;
        }

        public Criteria andInstructionsNotBetween(String value1, String value2) {
            addCriterion("instructions not between", value1, value2, "instructions");
            return (Criteria) this;
        }

        public Criteria andContactpersonIsNull() {
            addCriterion("contactperson is null");
            return (Criteria) this;
        }

        public Criteria andContactpersonIsNotNull() {
            addCriterion("contactperson is not null");
            return (Criteria) this;
        }

        public Criteria andContactpersonEqualTo(String value) {
            addCriterion("contactperson =", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonNotEqualTo(String value) {
            addCriterion("contactperson <>", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonGreaterThan(String value) {
            addCriterion("contactperson >", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonGreaterThanOrEqualTo(String value) {
            addCriterion("contactperson >=", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonLessThan(String value) {
            addCriterion("contactperson <", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonLessThanOrEqualTo(String value) {
            addCriterion("contactperson <=", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonLike(String value) {
            addCriterion("contactperson like", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonNotLike(String value) {
            addCriterion("contactperson not like", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonIn(List<String> values) {
            addCriterion("contactperson in", values, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonNotIn(List<String> values) {
            addCriterion("contactperson not in", values, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonBetween(String value1, String value2) {
            addCriterion("contactperson between", value1, value2, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonNotBetween(String value1, String value2) {
            addCriterion("contactperson not between", value1, value2, "contactperson");
            return (Criteria) this;
        }

        public Criteria andFinancepersonIsNull() {
            addCriterion("financeperson is null");
            return (Criteria) this;
        }

        public Criteria andFinancepersonIsNotNull() {
            addCriterion("financeperson is not null");
            return (Criteria) this;
        }

        public Criteria andFinancepersonEqualTo(String value) {
            addCriterion("financeperson =", value, "financeperson");
            return (Criteria) this;
        }

        public Criteria andFinancepersonNotEqualTo(String value) {
            addCriterion("financeperson <>", value, "financeperson");
            return (Criteria) this;
        }

        public Criteria andFinancepersonGreaterThan(String value) {
            addCriterion("financeperson >", value, "financeperson");
            return (Criteria) this;
        }

        public Criteria andFinancepersonGreaterThanOrEqualTo(String value) {
            addCriterion("financeperson >=", value, "financeperson");
            return (Criteria) this;
        }

        public Criteria andFinancepersonLessThan(String value) {
            addCriterion("financeperson <", value, "financeperson");
            return (Criteria) this;
        }

        public Criteria andFinancepersonLessThanOrEqualTo(String value) {
            addCriterion("financeperson <=", value, "financeperson");
            return (Criteria) this;
        }

        public Criteria andFinancepersonLike(String value) {
            addCriterion("financeperson like", value, "financeperson");
            return (Criteria) this;
        }

        public Criteria andFinancepersonNotLike(String value) {
            addCriterion("financeperson not like", value, "financeperson");
            return (Criteria) this;
        }

        public Criteria andFinancepersonIn(List<String> values) {
            addCriterion("financeperson in", values, "financeperson");
            return (Criteria) this;
        }

        public Criteria andFinancepersonNotIn(List<String> values) {
            addCriterion("financeperson not in", values, "financeperson");
            return (Criteria) this;
        }

        public Criteria andFinancepersonBetween(String value1, String value2) {
            addCriterion("financeperson between", value1, value2, "financeperson");
            return (Criteria) this;
        }

        public Criteria andFinancepersonNotBetween(String value1, String value2) {
            addCriterion("financeperson not between", value1, value2, "financeperson");
            return (Criteria) this;
        }

        public Criteria andContactemalIsNull() {
            addCriterion("contactemal is null");
            return (Criteria) this;
        }

        public Criteria andContactemalIsNotNull() {
            addCriterion("contactemal is not null");
            return (Criteria) this;
        }

        public Criteria andContactemalEqualTo(String value) {
            addCriterion("contactemal =", value, "contactemal");
            return (Criteria) this;
        }

        public Criteria andContactemalNotEqualTo(String value) {
            addCriterion("contactemal <>", value, "contactemal");
            return (Criteria) this;
        }

        public Criteria andContactemalGreaterThan(String value) {
            addCriterion("contactemal >", value, "contactemal");
            return (Criteria) this;
        }

        public Criteria andContactemalGreaterThanOrEqualTo(String value) {
            addCriterion("contactemal >=", value, "contactemal");
            return (Criteria) this;
        }

        public Criteria andContactemalLessThan(String value) {
            addCriterion("contactemal <", value, "contactemal");
            return (Criteria) this;
        }

        public Criteria andContactemalLessThanOrEqualTo(String value) {
            addCriterion("contactemal <=", value, "contactemal");
            return (Criteria) this;
        }

        public Criteria andContactemalLike(String value) {
            addCriterion("contactemal like", value, "contactemal");
            return (Criteria) this;
        }

        public Criteria andContactemalNotLike(String value) {
            addCriterion("contactemal not like", value, "contactemal");
            return (Criteria) this;
        }

        public Criteria andContactemalIn(List<String> values) {
            addCriterion("contactemal in", values, "contactemal");
            return (Criteria) this;
        }

        public Criteria andContactemalNotIn(List<String> values) {
            addCriterion("contactemal not in", values, "contactemal");
            return (Criteria) this;
        }

        public Criteria andContactemalBetween(String value1, String value2) {
            addCriterion("contactemal between", value1, value2, "contactemal");
            return (Criteria) this;
        }

        public Criteria andContactemalNotBetween(String value1, String value2) {
            addCriterion("contactemal not between", value1, value2, "contactemal");
            return (Criteria) this;
        }

        public Criteria andFinanceemailIsNull() {
            addCriterion("financeemail is null");
            return (Criteria) this;
        }

        public Criteria andFinanceemailIsNotNull() {
            addCriterion("financeemail is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceemailEqualTo(String value) {
            addCriterion("financeemail =", value, "financeemail");
            return (Criteria) this;
        }

        public Criteria andFinanceemailNotEqualTo(String value) {
            addCriterion("financeemail <>", value, "financeemail");
            return (Criteria) this;
        }

        public Criteria andFinanceemailGreaterThan(String value) {
            addCriterion("financeemail >", value, "financeemail");
            return (Criteria) this;
        }

        public Criteria andFinanceemailGreaterThanOrEqualTo(String value) {
            addCriterion("financeemail >=", value, "financeemail");
            return (Criteria) this;
        }

        public Criteria andFinanceemailLessThan(String value) {
            addCriterion("financeemail <", value, "financeemail");
            return (Criteria) this;
        }

        public Criteria andFinanceemailLessThanOrEqualTo(String value) {
            addCriterion("financeemail <=", value, "financeemail");
            return (Criteria) this;
        }

        public Criteria andFinanceemailLike(String value) {
            addCriterion("financeemail like", value, "financeemail");
            return (Criteria) this;
        }

        public Criteria andFinanceemailNotLike(String value) {
            addCriterion("financeemail not like", value, "financeemail");
            return (Criteria) this;
        }

        public Criteria andFinanceemailIn(List<String> values) {
            addCriterion("financeemail in", values, "financeemail");
            return (Criteria) this;
        }

        public Criteria andFinanceemailNotIn(List<String> values) {
            addCriterion("financeemail not in", values, "financeemail");
            return (Criteria) this;
        }

        public Criteria andFinanceemailBetween(String value1, String value2) {
            addCriterion("financeemail between", value1, value2, "financeemail");
            return (Criteria) this;
        }

        public Criteria andFinanceemailNotBetween(String value1, String value2) {
            addCriterion("financeemail not between", value1, value2, "financeemail");
            return (Criteria) this;
        }

        public Criteria andInvoicetplIsNull() {
            addCriterion("invoicetpl is null");
            return (Criteria) this;
        }

        public Criteria andInvoicetplIsNotNull() {
            addCriterion("invoicetpl is not null");
            return (Criteria) this;
        }

        public Criteria andInvoicetplEqualTo(String value) {
            addCriterion("invoicetpl =", value, "invoicetpl");
            return (Criteria) this;
        }

        public Criteria andInvoicetplNotEqualTo(String value) {
            addCriterion("invoicetpl <>", value, "invoicetpl");
            return (Criteria) this;
        }

        public Criteria andInvoicetplGreaterThan(String value) {
            addCriterion("invoicetpl >", value, "invoicetpl");
            return (Criteria) this;
        }

        public Criteria andInvoicetplGreaterThanOrEqualTo(String value) {
            addCriterion("invoicetpl >=", value, "invoicetpl");
            return (Criteria) this;
        }

        public Criteria andInvoicetplLessThan(String value) {
            addCriterion("invoicetpl <", value, "invoicetpl");
            return (Criteria) this;
        }

        public Criteria andInvoicetplLessThanOrEqualTo(String value) {
            addCriterion("invoicetpl <=", value, "invoicetpl");
            return (Criteria) this;
        }

        public Criteria andInvoicetplLike(String value) {
            addCriterion("invoicetpl like", value, "invoicetpl");
            return (Criteria) this;
        }

        public Criteria andInvoicetplNotLike(String value) {
            addCriterion("invoicetpl not like", value, "invoicetpl");
            return (Criteria) this;
        }

        public Criteria andInvoicetplIn(List<String> values) {
            addCriterion("invoicetpl in", values, "invoicetpl");
            return (Criteria) this;
        }

        public Criteria andInvoicetplNotIn(List<String> values) {
            addCriterion("invoicetpl not in", values, "invoicetpl");
            return (Criteria) this;
        }

        public Criteria andInvoicetplBetween(String value1, String value2) {
            addCriterion("invoicetpl between", value1, value2, "invoicetpl");
            return (Criteria) this;
        }

        public Criteria andInvoicetplNotBetween(String value1, String value2) {
            addCriterion("invoicetpl not between", value1, value2, "invoicetpl");
            return (Criteria) this;
        }

        public Criteria andMixrateIsNull() {
            addCriterion("mixrate is null");
            return (Criteria) this;
        }

        public Criteria andMixrateIsNotNull() {
            addCriterion("mixrate is not null");
            return (Criteria) this;
        }

        public Criteria andMixrateEqualTo(Integer value) {
            addCriterion("mixrate =", value, "mixrate");
            return (Criteria) this;
        }

        public Criteria andMixrateNotEqualTo(Integer value) {
            addCriterion("mixrate <>", value, "mixrate");
            return (Criteria) this;
        }

        public Criteria andMixrateGreaterThan(Integer value) {
            addCriterion("mixrate >", value, "mixrate");
            return (Criteria) this;
        }

        public Criteria andMixrateGreaterThanOrEqualTo(Integer value) {
            addCriterion("mixrate >=", value, "mixrate");
            return (Criteria) this;
        }

        public Criteria andMixrateLessThan(Integer value) {
            addCriterion("mixrate <", value, "mixrate");
            return (Criteria) this;
        }

        public Criteria andMixrateLessThanOrEqualTo(Integer value) {
            addCriterion("mixrate <=", value, "mixrate");
            return (Criteria) this;
        }

        public Criteria andMixrateIn(List<Integer> values) {
            addCriterion("mixrate in", values, "mixrate");
            return (Criteria) this;
        }

        public Criteria andMixrateNotIn(List<Integer> values) {
            addCriterion("mixrate not in", values, "mixrate");
            return (Criteria) this;
        }

        public Criteria andMixrateBetween(Integer value1, Integer value2) {
            addCriterion("mixrate between", value1, value2, "mixrate");
            return (Criteria) this;
        }

        public Criteria andMixrateNotBetween(Integer value1, Integer value2) {
            addCriterion("mixrate not between", value1, value2, "mixrate");
            return (Criteria) this;
        }

        public Criteria andRedirectrateIsNull() {
            addCriterion("redirectrate is null");
            return (Criteria) this;
        }

        public Criteria andRedirectrateIsNotNull() {
            addCriterion("redirectrate is not null");
            return (Criteria) this;
        }

        public Criteria andRedirectrateEqualTo(Integer value) {
            addCriterion("redirectrate =", value, "redirectrate");
            return (Criteria) this;
        }

        public Criteria andRedirectrateNotEqualTo(Integer value) {
            addCriterion("redirectrate <>", value, "redirectrate");
            return (Criteria) this;
        }

        public Criteria andRedirectrateGreaterThan(Integer value) {
            addCriterion("redirectrate >", value, "redirectrate");
            return (Criteria) this;
        }

        public Criteria andRedirectrateGreaterThanOrEqualTo(Integer value) {
            addCriterion("redirectrate >=", value, "redirectrate");
            return (Criteria) this;
        }

        public Criteria andRedirectrateLessThan(Integer value) {
            addCriterion("redirectrate <", value, "redirectrate");
            return (Criteria) this;
        }

        public Criteria andRedirectrateLessThanOrEqualTo(Integer value) {
            addCriterion("redirectrate <=", value, "redirectrate");
            return (Criteria) this;
        }

        public Criteria andRedirectrateIn(List<Integer> values) {
            addCriterion("redirectrate in", values, "redirectrate");
            return (Criteria) this;
        }

        public Criteria andRedirectrateNotIn(List<Integer> values) {
            addCriterion("redirectrate not in", values, "redirectrate");
            return (Criteria) this;
        }

        public Criteria andRedirectrateBetween(Integer value1, Integer value2) {
            addCriterion("redirectrate between", value1, value2, "redirectrate");
            return (Criteria) this;
        }

        public Criteria andRedirectrateNotBetween(Integer value1, Integer value2) {
            addCriterion("redirectrate not between", value1, value2, "redirectrate");
            return (Criteria) this;
        }

        public Criteria andDeductrateIsNull() {
            addCriterion("deductrate is null");
            return (Criteria) this;
        }

        public Criteria andDeductrateIsNotNull() {
            addCriterion("deductrate is not null");
            return (Criteria) this;
        }

        public Criteria andDeductrateEqualTo(Integer value) {
            addCriterion("deductrate =", value, "deductrate");
            return (Criteria) this;
        }

        public Criteria andDeductrateNotEqualTo(Integer value) {
            addCriterion("deductrate <>", value, "deductrate");
            return (Criteria) this;
        }

        public Criteria andDeductrateGreaterThan(Integer value) {
            addCriterion("deductrate >", value, "deductrate");
            return (Criteria) this;
        }

        public Criteria andDeductrateGreaterThanOrEqualTo(Integer value) {
            addCriterion("deductrate >=", value, "deductrate");
            return (Criteria) this;
        }

        public Criteria andDeductrateLessThan(Integer value) {
            addCriterion("deductrate <", value, "deductrate");
            return (Criteria) this;
        }

        public Criteria andDeductrateLessThanOrEqualTo(Integer value) {
            addCriterion("deductrate <=", value, "deductrate");
            return (Criteria) this;
        }

        public Criteria andDeductrateIn(List<Integer> values) {
            addCriterion("deductrate in", values, "deductrate");
            return (Criteria) this;
        }

        public Criteria andDeductrateNotIn(List<Integer> values) {
            addCriterion("deductrate not in", values, "deductrate");
            return (Criteria) this;
        }

        public Criteria andDeductrateBetween(Integer value1, Integer value2) {
            addCriterion("deductrate between", value1, value2, "deductrate");
            return (Criteria) this;
        }

        public Criteria andDeductrateNotBetween(Integer value1, Integer value2) {
            addCriterion("deductrate not between", value1, value2, "deductrate");
            return (Criteria) this;
        }

        public Criteria andSysuseridIsNull() {
            addCriterion("sysuserid is null");
            return (Criteria) this;
        }

        public Criteria andSysuseridIsNotNull() {
            addCriterion("sysuserid is not null");
            return (Criteria) this;
        }

        public Criteria andSysuseridEqualTo(Integer value) {
            addCriterion("sysuserid =", value, "sysuserid");
            return (Criteria) this;
        }

        public Criteria andSysuseridNotEqualTo(Integer value) {
            addCriterion("sysuserid <>", value, "sysuserid");
            return (Criteria) this;
        }

        public Criteria andSysuseridGreaterThan(Integer value) {
            addCriterion("sysuserid >", value, "sysuserid");
            return (Criteria) this;
        }

        public Criteria andSysuseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("sysuserid >=", value, "sysuserid");
            return (Criteria) this;
        }

        public Criteria andSysuseridLessThan(Integer value) {
            addCriterion("sysuserid <", value, "sysuserid");
            return (Criteria) this;
        }

        public Criteria andSysuseridLessThanOrEqualTo(Integer value) {
            addCriterion("sysuserid <=", value, "sysuserid");
            return (Criteria) this;
        }

        public Criteria andSysuseridIn(List<Integer> values) {
            addCriterion("sysuserid in", values, "sysuserid");
            return (Criteria) this;
        }

        public Criteria andSysuseridNotIn(List<Integer> values) {
            addCriterion("sysuserid not in", values, "sysuserid");
            return (Criteria) this;
        }

        public Criteria andSysuseridBetween(Integer value1, Integer value2) {
            addCriterion("sysuserid between", value1, value2, "sysuserid");
            return (Criteria) this;
        }

        public Criteria andSysuseridNotBetween(Integer value1, Integer value2) {
            addCriterion("sysuserid not between", value1, value2, "sysuserid");
            return (Criteria) this;
        }

        public Criteria andUtcIsNull() {
            addCriterion("utc is null");
            return (Criteria) this;
        }

        public Criteria andUtcIsNotNull() {
            addCriterion("utc is not null");
            return (Criteria) this;
        }

        public Criteria andUtcEqualTo(Integer value) {
            addCriterion("utc =", value, "utc");
            return (Criteria) this;
        }

        public Criteria andUtcNotEqualTo(Integer value) {
            addCriterion("utc <>", value, "utc");
            return (Criteria) this;
        }

        public Criteria andUtcGreaterThan(Integer value) {
            addCriterion("utc >", value, "utc");
            return (Criteria) this;
        }

        public Criteria andUtcGreaterThanOrEqualTo(Integer value) {
            addCriterion("utc >=", value, "utc");
            return (Criteria) this;
        }

        public Criteria andUtcLessThan(Integer value) {
            addCriterion("utc <", value, "utc");
            return (Criteria) this;
        }

        public Criteria andUtcLessThanOrEqualTo(Integer value) {
            addCriterion("utc <=", value, "utc");
            return (Criteria) this;
        }

        public Criteria andUtcIn(List<Integer> values) {
            addCriterion("utc in", values, "utc");
            return (Criteria) this;
        }

        public Criteria andUtcNotIn(List<Integer> values) {
            addCriterion("utc not in", values, "utc");
            return (Criteria) this;
        }

        public Criteria andUtcBetween(Integer value1, Integer value2) {
            addCriterion("utc between", value1, value2, "utc");
            return (Criteria) this;
        }

        public Criteria andUtcNotBetween(Integer value1, Integer value2) {
            addCriterion("utc not between", value1, value2, "utc");
            return (Criteria) this;
        }

        public Criteria andDeleteflagIsNull() {
            addCriterion("deleteflag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteflagIsNotNull() {
            addCriterion("deleteflag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteflagEqualTo(Integer value) {
            addCriterion("deleteflag =", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagNotEqualTo(Integer value) {
            addCriterion("deleteflag <>", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagGreaterThan(Integer value) {
            addCriterion("deleteflag >", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("deleteflag >=", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagLessThan(Integer value) {
            addCriterion("deleteflag <", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagLessThanOrEqualTo(Integer value) {
            addCriterion("deleteflag <=", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagIn(List<Integer> values) {
            addCriterion("deleteflag in", values, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagNotIn(List<Integer> values) {
            addCriterion("deleteflag not in", values, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagBetween(Integer value1, Integer value2) {
            addCriterion("deleteflag between", value1, value2, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagNotBetween(Integer value1, Integer value2) {
            addCriterion("deleteflag not between", value1, value2, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
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