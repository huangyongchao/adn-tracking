package mobi.xdsp.tracking.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PidMonitorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public PidMonitorExample() {
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

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("pid like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("pid not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andBlockingIsNull() {
            addCriterion("blocking is null");
            return (Criteria) this;
        }

        public Criteria andBlockingIsNotNull() {
            addCriterion("blocking is not null");
            return (Criteria) this;
        }

        public Criteria andBlockingEqualTo(Integer value) {
            addCriterion("blocking =", value, "blocking");
            return (Criteria) this;
        }

        public Criteria andBlockingNotEqualTo(Integer value) {
            addCriterion("blocking <>", value, "blocking");
            return (Criteria) this;
        }

        public Criteria andBlockingGreaterThan(Integer value) {
            addCriterion("blocking >", value, "blocking");
            return (Criteria) this;
        }

        public Criteria andBlockingGreaterThanOrEqualTo(Integer value) {
            addCriterion("blocking >=", value, "blocking");
            return (Criteria) this;
        }

        public Criteria andBlockingLessThan(Integer value) {
            addCriterion("blocking <", value, "blocking");
            return (Criteria) this;
        }

        public Criteria andBlockingLessThanOrEqualTo(Integer value) {
            addCriterion("blocking <=", value, "blocking");
            return (Criteria) this;
        }

        public Criteria andBlockingIn(List<Integer> values) {
            addCriterion("blocking in", values, "blocking");
            return (Criteria) this;
        }

        public Criteria andBlockingNotIn(List<Integer> values) {
            addCriterion("blocking not in", values, "blocking");
            return (Criteria) this;
        }

        public Criteria andBlockingBetween(Integer value1, Integer value2) {
            addCriterion("blocking between", value1, value2, "blocking");
            return (Criteria) this;
        }

        public Criteria andBlockingNotBetween(Integer value1, Integer value2) {
            addCriterion("blocking not between", value1, value2, "blocking");
            return (Criteria) this;
        }

        public Criteria andBlockstIsNull() {
            addCriterion("blockst is null");
            return (Criteria) this;
        }

        public Criteria andBlockstIsNotNull() {
            addCriterion("blockst is not null");
            return (Criteria) this;
        }

        public Criteria andBlockstEqualTo(Date value) {
            addCriterion("blockst =", value, "blockst");
            return (Criteria) this;
        }

        public Criteria andBlockstNotEqualTo(Date value) {
            addCriterion("blockst <>", value, "blockst");
            return (Criteria) this;
        }

        public Criteria andBlockstGreaterThan(Date value) {
            addCriterion("blockst >", value, "blockst");
            return (Criteria) this;
        }

        public Criteria andBlockstGreaterThanOrEqualTo(Date value) {
            addCriterion("blockst >=", value, "blockst");
            return (Criteria) this;
        }

        public Criteria andBlockstLessThan(Date value) {
            addCriterion("blockst <", value, "blockst");
            return (Criteria) this;
        }

        public Criteria andBlockstLessThanOrEqualTo(Date value) {
            addCriterion("blockst <=", value, "blockst");
            return (Criteria) this;
        }

        public Criteria andBlockstIn(List<Date> values) {
            addCriterion("blockst in", values, "blockst");
            return (Criteria) this;
        }

        public Criteria andBlockstNotIn(List<Date> values) {
            addCriterion("blockst not in", values, "blockst");
            return (Criteria) this;
        }

        public Criteria andBlockstBetween(Date value1, Date value2) {
            addCriterion("blockst between", value1, value2, "blockst");
            return (Criteria) this;
        }

        public Criteria andBlockstNotBetween(Date value1, Date value2) {
            addCriterion("blockst not between", value1, value2, "blockst");
            return (Criteria) this;
        }

        public Criteria andBlocketIsNull() {
            addCriterion("blocket is null");
            return (Criteria) this;
        }

        public Criteria andBlocketIsNotNull() {
            addCriterion("blocket is not null");
            return (Criteria) this;
        }

        public Criteria andBlocketEqualTo(Date value) {
            addCriterion("blocket =", value, "blocket");
            return (Criteria) this;
        }

        public Criteria andBlocketNotEqualTo(Date value) {
            addCriterion("blocket <>", value, "blocket");
            return (Criteria) this;
        }

        public Criteria andBlocketGreaterThan(Date value) {
            addCriterion("blocket >", value, "blocket");
            return (Criteria) this;
        }

        public Criteria andBlocketGreaterThanOrEqualTo(Date value) {
            addCriterion("blocket >=", value, "blocket");
            return (Criteria) this;
        }

        public Criteria andBlocketLessThan(Date value) {
            addCriterion("blocket <", value, "blocket");
            return (Criteria) this;
        }

        public Criteria andBlocketLessThanOrEqualTo(Date value) {
            addCriterion("blocket <=", value, "blocket");
            return (Criteria) this;
        }

        public Criteria andBlocketIn(List<Date> values) {
            addCriterion("blocket in", values, "blocket");
            return (Criteria) this;
        }

        public Criteria andBlocketNotIn(List<Date> values) {
            addCriterion("blocket not in", values, "blocket");
            return (Criteria) this;
        }

        public Criteria andBlocketBetween(Date value1, Date value2) {
            addCriterion("blocket between", value1, value2, "blocket");
            return (Criteria) this;
        }

        public Criteria andBlocketNotBetween(Date value1, Date value2) {
            addCriterion("blocket not between", value1, value2, "blocket");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andPwdIsNull() {
            addCriterion("pwd is null");
            return (Criteria) this;
        }

        public Criteria andPwdIsNotNull() {
            addCriterion("pwd is not null");
            return (Criteria) this;
        }

        public Criteria andPwdEqualTo(String value) {
            addCriterion("pwd =", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotEqualTo(String value) {
            addCriterion("pwd <>", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThan(String value) {
            addCriterion("pwd >", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThanOrEqualTo(String value) {
            addCriterion("pwd >=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThan(String value) {
            addCriterion("pwd <", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThanOrEqualTo(String value) {
            addCriterion("pwd <=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLike(String value) {
            addCriterion("pwd like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotLike(String value) {
            addCriterion("pwd not like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdIn(List<String> values) {
            addCriterion("pwd in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotIn(List<String> values) {
            addCriterion("pwd not in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdBetween(String value1, String value2) {
            addCriterion("pwd between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotBetween(String value1, String value2) {
            addCriterion("pwd not between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andCookieIsNull() {
            addCriterion("cookie is null");
            return (Criteria) this;
        }

        public Criteria andCookieIsNotNull() {
            addCriterion("cookie is not null");
            return (Criteria) this;
        }

        public Criteria andCookieEqualTo(String value) {
            addCriterion("cookie =", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotEqualTo(String value) {
            addCriterion("cookie <>", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieGreaterThan(String value) {
            addCriterion("cookie >", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieGreaterThanOrEqualTo(String value) {
            addCriterion("cookie >=", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieLessThan(String value) {
            addCriterion("cookie <", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieLessThanOrEqualTo(String value) {
            addCriterion("cookie <=", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieLike(String value) {
            addCriterion("cookie like", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotLike(String value) {
            addCriterion("cookie not like", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieIn(List<String> values) {
            addCriterion("cookie in", values, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotIn(List<String> values) {
            addCriterion("cookie not in", values, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieBetween(String value1, String value2) {
            addCriterion("cookie between", value1, value2, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotBetween(String value1, String value2) {
            addCriterion("cookie not between", value1, value2, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookie1IsNull() {
            addCriterion("cookie1 is null");
            return (Criteria) this;
        }

        public Criteria andCookie1IsNotNull() {
            addCriterion("cookie1 is not null");
            return (Criteria) this;
        }

        public Criteria andCookie1EqualTo(String value) {
            addCriterion("cookie1 =", value, "cookie1");
            return (Criteria) this;
        }

        public Criteria andCookie1NotEqualTo(String value) {
            addCriterion("cookie1 <>", value, "cookie1");
            return (Criteria) this;
        }

        public Criteria andCookie1GreaterThan(String value) {
            addCriterion("cookie1 >", value, "cookie1");
            return (Criteria) this;
        }

        public Criteria andCookie1GreaterThanOrEqualTo(String value) {
            addCriterion("cookie1 >=", value, "cookie1");
            return (Criteria) this;
        }

        public Criteria andCookie1LessThan(String value) {
            addCriterion("cookie1 <", value, "cookie1");
            return (Criteria) this;
        }

        public Criteria andCookie1LessThanOrEqualTo(String value) {
            addCriterion("cookie1 <=", value, "cookie1");
            return (Criteria) this;
        }

        public Criteria andCookie1Like(String value) {
            addCriterion("cookie1 like", value, "cookie1");
            return (Criteria) this;
        }

        public Criteria andCookie1NotLike(String value) {
            addCriterion("cookie1 not like", value, "cookie1");
            return (Criteria) this;
        }

        public Criteria andCookie1In(List<String> values) {
            addCriterion("cookie1 in", values, "cookie1");
            return (Criteria) this;
        }

        public Criteria andCookie1NotIn(List<String> values) {
            addCriterion("cookie1 not in", values, "cookie1");
            return (Criteria) this;
        }

        public Criteria andCookie1Between(String value1, String value2) {
            addCriterion("cookie1 between", value1, value2, "cookie1");
            return (Criteria) this;
        }

        public Criteria andCookie1NotBetween(String value1, String value2) {
            addCriterion("cookie1 not between", value1, value2, "cookie1");
            return (Criteria) this;
        }

        public Criteria andAmIsNull() {
            addCriterion("am is null");
            return (Criteria) this;
        }

        public Criteria andAmIsNotNull() {
            addCriterion("am is not null");
            return (Criteria) this;
        }

        public Criteria andAmEqualTo(String value) {
            addCriterion("am =", value, "am");
            return (Criteria) this;
        }

        public Criteria andAmNotEqualTo(String value) {
            addCriterion("am <>", value, "am");
            return (Criteria) this;
        }

        public Criteria andAmGreaterThan(String value) {
            addCriterion("am >", value, "am");
            return (Criteria) this;
        }

        public Criteria andAmGreaterThanOrEqualTo(String value) {
            addCriterion("am >=", value, "am");
            return (Criteria) this;
        }

        public Criteria andAmLessThan(String value) {
            addCriterion("am <", value, "am");
            return (Criteria) this;
        }

        public Criteria andAmLessThanOrEqualTo(String value) {
            addCriterion("am <=", value, "am");
            return (Criteria) this;
        }

        public Criteria andAmLike(String value) {
            addCriterion("am like", value, "am");
            return (Criteria) this;
        }

        public Criteria andAmNotLike(String value) {
            addCriterion("am not like", value, "am");
            return (Criteria) this;
        }

        public Criteria andAmIn(List<String> values) {
            addCriterion("am in", values, "am");
            return (Criteria) this;
        }

        public Criteria andAmNotIn(List<String> values) {
            addCriterion("am not in", values, "am");
            return (Criteria) this;
        }

        public Criteria andAmBetween(String value1, String value2) {
            addCriterion("am between", value1, value2, "am");
            return (Criteria) this;
        }

        public Criteria andAmNotBetween(String value1, String value2) {
            addCriterion("am not between", value1, value2, "am");
            return (Criteria) this;
        }

        public Criteria andAmemailIsNull() {
            addCriterion("amemail is null");
            return (Criteria) this;
        }

        public Criteria andAmemailIsNotNull() {
            addCriterion("amemail is not null");
            return (Criteria) this;
        }

        public Criteria andAmemailEqualTo(String value) {
            addCriterion("amemail =", value, "amemail");
            return (Criteria) this;
        }

        public Criteria andAmemailNotEqualTo(String value) {
            addCriterion("amemail <>", value, "amemail");
            return (Criteria) this;
        }

        public Criteria andAmemailGreaterThan(String value) {
            addCriterion("amemail >", value, "amemail");
            return (Criteria) this;
        }

        public Criteria andAmemailGreaterThanOrEqualTo(String value) {
            addCriterion("amemail >=", value, "amemail");
            return (Criteria) this;
        }

        public Criteria andAmemailLessThan(String value) {
            addCriterion("amemail <", value, "amemail");
            return (Criteria) this;
        }

        public Criteria andAmemailLessThanOrEqualTo(String value) {
            addCriterion("amemail <=", value, "amemail");
            return (Criteria) this;
        }

        public Criteria andAmemailLike(String value) {
            addCriterion("amemail like", value, "amemail");
            return (Criteria) this;
        }

        public Criteria andAmemailNotLike(String value) {
            addCriterion("amemail not like", value, "amemail");
            return (Criteria) this;
        }

        public Criteria andAmemailIn(List<String> values) {
            addCriterion("amemail in", values, "amemail");
            return (Criteria) this;
        }

        public Criteria andAmemailNotIn(List<String> values) {
            addCriterion("amemail not in", values, "amemail");
            return (Criteria) this;
        }

        public Criteria andAmemailBetween(String value1, String value2) {
            addCriterion("amemail between", value1, value2, "amemail");
            return (Criteria) this;
        }

        public Criteria andAmemailNotBetween(String value1, String value2) {
            addCriterion("amemail not between", value1, value2, "amemail");
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