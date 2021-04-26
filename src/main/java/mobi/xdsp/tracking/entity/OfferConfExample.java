package mobi.xdsp.tracking.entity;

import java.util.ArrayList;
import java.util.List;

public class OfferConfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public OfferConfExample() {
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

        public Criteria andP360IsNull() {
            addCriterion("p360 is null");
            return (Criteria) this;
        }

        public Criteria andP360IsNotNull() {
            addCriterion("p360 is not null");
            return (Criteria) this;
        }

        public Criteria andP360EqualTo(Integer value) {
            addCriterion("p360 =", value, "p360");
            return (Criteria) this;
        }

        public Criteria andP360NotEqualTo(Integer value) {
            addCriterion("p360 <>", value, "p360");
            return (Criteria) this;
        }

        public Criteria andP360GreaterThan(Integer value) {
            addCriterion("p360 >", value, "p360");
            return (Criteria) this;
        }

        public Criteria andP360GreaterThanOrEqualTo(Integer value) {
            addCriterion("p360 >=", value, "p360");
            return (Criteria) this;
        }

        public Criteria andP360LessThan(Integer value) {
            addCriterion("p360 <", value, "p360");
            return (Criteria) this;
        }

        public Criteria andP360LessThanOrEqualTo(Integer value) {
            addCriterion("p360 <=", value, "p360");
            return (Criteria) this;
        }

        public Criteria andP360In(List<Integer> values) {
            addCriterion("p360 in", values, "p360");
            return (Criteria) this;
        }

        public Criteria andP360NotIn(List<Integer> values) {
            addCriterion("p360 not in", values, "p360");
            return (Criteria) this;
        }

        public Criteria andP360Between(Integer value1, Integer value2) {
            addCriterion("p360 between", value1, value2, "p360");
            return (Criteria) this;
        }

        public Criteria andP360NotBetween(Integer value1, Integer value2) {
            addCriterion("p360 not between", value1, value2, "p360");
            return (Criteria) this;
        }

        public Criteria andStrongkpiIsNull() {
            addCriterion("strongkpi is null");
            return (Criteria) this;
        }

        public Criteria andStrongkpiIsNotNull() {
            addCriterion("strongkpi is not null");
            return (Criteria) this;
        }

        public Criteria andStrongkpiEqualTo(Integer value) {
            addCriterion("strongkpi =", value, "strongkpi");
            return (Criteria) this;
        }

        public Criteria andStrongkpiNotEqualTo(Integer value) {
            addCriterion("strongkpi <>", value, "strongkpi");
            return (Criteria) this;
        }

        public Criteria andStrongkpiGreaterThan(Integer value) {
            addCriterion("strongkpi >", value, "strongkpi");
            return (Criteria) this;
        }

        public Criteria andStrongkpiGreaterThanOrEqualTo(Integer value) {
            addCriterion("strongkpi >=", value, "strongkpi");
            return (Criteria) this;
        }

        public Criteria andStrongkpiLessThan(Integer value) {
            addCriterion("strongkpi <", value, "strongkpi");
            return (Criteria) this;
        }

        public Criteria andStrongkpiLessThanOrEqualTo(Integer value) {
            addCriterion("strongkpi <=", value, "strongkpi");
            return (Criteria) this;
        }

        public Criteria andStrongkpiIn(List<Integer> values) {
            addCriterion("strongkpi in", values, "strongkpi");
            return (Criteria) this;
        }

        public Criteria andStrongkpiNotIn(List<Integer> values) {
            addCriterion("strongkpi not in", values, "strongkpi");
            return (Criteria) this;
        }

        public Criteria andStrongkpiBetween(Integer value1, Integer value2) {
            addCriterion("strongkpi between", value1, value2, "strongkpi");
            return (Criteria) this;
        }

        public Criteria andStrongkpiNotBetween(Integer value1, Integer value2) {
            addCriterion("strongkpi not between", value1, value2, "strongkpi");
            return (Criteria) this;
        }

        public Criteria andAutoblackIsNull() {
            addCriterion("autoblack is null");
            return (Criteria) this;
        }

        public Criteria andAutoblackIsNotNull() {
            addCriterion("autoblack is not null");
            return (Criteria) this;
        }

        public Criteria andAutoblackEqualTo(Integer value) {
            addCriterion("autoblack =", value, "autoblack");
            return (Criteria) this;
        }

        public Criteria andAutoblackNotEqualTo(Integer value) {
            addCriterion("autoblack <>", value, "autoblack");
            return (Criteria) this;
        }

        public Criteria andAutoblackGreaterThan(Integer value) {
            addCriterion("autoblack >", value, "autoblack");
            return (Criteria) this;
        }

        public Criteria andAutoblackGreaterThanOrEqualTo(Integer value) {
            addCriterion("autoblack >=", value, "autoblack");
            return (Criteria) this;
        }

        public Criteria andAutoblackLessThan(Integer value) {
            addCriterion("autoblack <", value, "autoblack");
            return (Criteria) this;
        }

        public Criteria andAutoblackLessThanOrEqualTo(Integer value) {
            addCriterion("autoblack <=", value, "autoblack");
            return (Criteria) this;
        }

        public Criteria andAutoblackIn(List<Integer> values) {
            addCriterion("autoblack in", values, "autoblack");
            return (Criteria) this;
        }

        public Criteria andAutoblackNotIn(List<Integer> values) {
            addCriterion("autoblack not in", values, "autoblack");
            return (Criteria) this;
        }

        public Criteria andAutoblackBetween(Integer value1, Integer value2) {
            addCriterion("autoblack between", value1, value2, "autoblack");
            return (Criteria) this;
        }

        public Criteria andAutoblackNotBetween(Integer value1, Integer value2) {
            addCriterion("autoblack not between", value1, value2, "autoblack");
            return (Criteria) this;
        }

        public Criteria andAutoredirectIsNull() {
            addCriterion("autoredirect is null");
            return (Criteria) this;
        }

        public Criteria andAutoredirectIsNotNull() {
            addCriterion("autoredirect is not null");
            return (Criteria) this;
        }

        public Criteria andAutoredirectEqualTo(Integer value) {
            addCriterion("autoredirect =", value, "autoredirect");
            return (Criteria) this;
        }

        public Criteria andAutoredirectNotEqualTo(Integer value) {
            addCriterion("autoredirect <>", value, "autoredirect");
            return (Criteria) this;
        }

        public Criteria andAutoredirectGreaterThan(Integer value) {
            addCriterion("autoredirect >", value, "autoredirect");
            return (Criteria) this;
        }

        public Criteria andAutoredirectGreaterThanOrEqualTo(Integer value) {
            addCriterion("autoredirect >=", value, "autoredirect");
            return (Criteria) this;
        }

        public Criteria andAutoredirectLessThan(Integer value) {
            addCriterion("autoredirect <", value, "autoredirect");
            return (Criteria) this;
        }

        public Criteria andAutoredirectLessThanOrEqualTo(Integer value) {
            addCriterion("autoredirect <=", value, "autoredirect");
            return (Criteria) this;
        }

        public Criteria andAutoredirectIn(List<Integer> values) {
            addCriterion("autoredirect in", values, "autoredirect");
            return (Criteria) this;
        }

        public Criteria andAutoredirectNotIn(List<Integer> values) {
            addCriterion("autoredirect not in", values, "autoredirect");
            return (Criteria) this;
        }

        public Criteria andAutoredirectBetween(Integer value1, Integer value2) {
            addCriterion("autoredirect between", value1, value2, "autoredirect");
            return (Criteria) this;
        }

        public Criteria andAutoredirectNotBetween(Integer value1, Integer value2) {
            addCriterion("autoredirect not between", value1, value2, "autoredirect");
            return (Criteria) this;
        }

        public Criteria andBlackpubIsNull() {
            addCriterion("blackpub is null");
            return (Criteria) this;
        }

        public Criteria andBlackpubIsNotNull() {
            addCriterion("blackpub is not null");
            return (Criteria) this;
        }

        public Criteria andBlackpubEqualTo(String value) {
            addCriterion("blackpub =", value, "blackpub");
            return (Criteria) this;
        }

        public Criteria andBlackpubNotEqualTo(String value) {
            addCriterion("blackpub <>", value, "blackpub");
            return (Criteria) this;
        }

        public Criteria andBlackpubGreaterThan(String value) {
            addCriterion("blackpub >", value, "blackpub");
            return (Criteria) this;
        }

        public Criteria andBlackpubGreaterThanOrEqualTo(String value) {
            addCriterion("blackpub >=", value, "blackpub");
            return (Criteria) this;
        }

        public Criteria andBlackpubLessThan(String value) {
            addCriterion("blackpub <", value, "blackpub");
            return (Criteria) this;
        }

        public Criteria andBlackpubLessThanOrEqualTo(String value) {
            addCriterion("blackpub <=", value, "blackpub");
            return (Criteria) this;
        }

        public Criteria andBlackpubLike(String value) {
            addCriterion("blackpub like", value, "blackpub");
            return (Criteria) this;
        }

        public Criteria andBlackpubNotLike(String value) {
            addCriterion("blackpub not like", value, "blackpub");
            return (Criteria) this;
        }

        public Criteria andBlackpubIn(List<String> values) {
            addCriterion("blackpub in", values, "blackpub");
            return (Criteria) this;
        }

        public Criteria andBlackpubNotIn(List<String> values) {
            addCriterion("blackpub not in", values, "blackpub");
            return (Criteria) this;
        }

        public Criteria andBlackpubBetween(String value1, String value2) {
            addCriterion("blackpub between", value1, value2, "blackpub");
            return (Criteria) this;
        }

        public Criteria andBlackpubNotBetween(String value1, String value2) {
            addCriterion("blackpub not between", value1, value2, "blackpub");
            return (Criteria) this;
        }

        public Criteria andWhitepubIsNull() {
            addCriterion("whitepub is null");
            return (Criteria) this;
        }

        public Criteria andWhitepubIsNotNull() {
            addCriterion("whitepub is not null");
            return (Criteria) this;
        }

        public Criteria andWhitepubEqualTo(String value) {
            addCriterion("whitepub =", value, "whitepub");
            return (Criteria) this;
        }

        public Criteria andWhitepubNotEqualTo(String value) {
            addCriterion("whitepub <>", value, "whitepub");
            return (Criteria) this;
        }

        public Criteria andWhitepubGreaterThan(String value) {
            addCriterion("whitepub >", value, "whitepub");
            return (Criteria) this;
        }

        public Criteria andWhitepubGreaterThanOrEqualTo(String value) {
            addCriterion("whitepub >=", value, "whitepub");
            return (Criteria) this;
        }

        public Criteria andWhitepubLessThan(String value) {
            addCriterion("whitepub <", value, "whitepub");
            return (Criteria) this;
        }

        public Criteria andWhitepubLessThanOrEqualTo(String value) {
            addCriterion("whitepub <=", value, "whitepub");
            return (Criteria) this;
        }

        public Criteria andWhitepubLike(String value) {
            addCriterion("whitepub like", value, "whitepub");
            return (Criteria) this;
        }

        public Criteria andWhitepubNotLike(String value) {
            addCriterion("whitepub not like", value, "whitepub");
            return (Criteria) this;
        }

        public Criteria andWhitepubIn(List<String> values) {
            addCriterion("whitepub in", values, "whitepub");
            return (Criteria) this;
        }

        public Criteria andWhitepubNotIn(List<String> values) {
            addCriterion("whitepub not in", values, "whitepub");
            return (Criteria) this;
        }

        public Criteria andWhitepubBetween(String value1, String value2) {
            addCriterion("whitepub between", value1, value2, "whitepub");
            return (Criteria) this;
        }

        public Criteria andWhitepubNotBetween(String value1, String value2) {
            addCriterion("whitepub not between", value1, value2, "whitepub");
            return (Criteria) this;
        }

        public Criteria andConvertionflowIsNull() {
            addCriterion("convertionflow is null");
            return (Criteria) this;
        }

        public Criteria andConvertionflowIsNotNull() {
            addCriterion("convertionflow is not null");
            return (Criteria) this;
        }

        public Criteria andConvertionflowEqualTo(String value) {
            addCriterion("convertionflow =", value, "convertionflow");
            return (Criteria) this;
        }

        public Criteria andConvertionflowNotEqualTo(String value) {
            addCriterion("convertionflow <>", value, "convertionflow");
            return (Criteria) this;
        }

        public Criteria andConvertionflowGreaterThan(String value) {
            addCriterion("convertionflow >", value, "convertionflow");
            return (Criteria) this;
        }

        public Criteria andConvertionflowGreaterThanOrEqualTo(String value) {
            addCriterion("convertionflow >=", value, "convertionflow");
            return (Criteria) this;
        }

        public Criteria andConvertionflowLessThan(String value) {
            addCriterion("convertionflow <", value, "convertionflow");
            return (Criteria) this;
        }

        public Criteria andConvertionflowLessThanOrEqualTo(String value) {
            addCriterion("convertionflow <=", value, "convertionflow");
            return (Criteria) this;
        }

        public Criteria andConvertionflowLike(String value) {
            addCriterion("convertionflow like", value, "convertionflow");
            return (Criteria) this;
        }

        public Criteria andConvertionflowNotLike(String value) {
            addCriterion("convertionflow not like", value, "convertionflow");
            return (Criteria) this;
        }

        public Criteria andConvertionflowIn(List<String> values) {
            addCriterion("convertionflow in", values, "convertionflow");
            return (Criteria) this;
        }

        public Criteria andConvertionflowNotIn(List<String> values) {
            addCriterion("convertionflow not in", values, "convertionflow");
            return (Criteria) this;
        }

        public Criteria andConvertionflowBetween(String value1, String value2) {
            addCriterion("convertionflow between", value1, value2, "convertionflow");
            return (Criteria) this;
        }

        public Criteria andConvertionflowNotBetween(String value1, String value2) {
            addCriterion("convertionflow not between", value1, value2, "convertionflow");
            return (Criteria) this;
        }

        public Criteria andEvent1IsNull() {
            addCriterion("event1 is null");
            return (Criteria) this;
        }

        public Criteria andEvent1IsNotNull() {
            addCriterion("event1 is not null");
            return (Criteria) this;
        }

        public Criteria andEvent1EqualTo(String value) {
            addCriterion("event1 =", value, "event1");
            return (Criteria) this;
        }

        public Criteria andEvent1NotEqualTo(String value) {
            addCriterion("event1 <>", value, "event1");
            return (Criteria) this;
        }

        public Criteria andEvent1GreaterThan(String value) {
            addCriterion("event1 >", value, "event1");
            return (Criteria) this;
        }

        public Criteria andEvent1GreaterThanOrEqualTo(String value) {
            addCriterion("event1 >=", value, "event1");
            return (Criteria) this;
        }

        public Criteria andEvent1LessThan(String value) {
            addCriterion("event1 <", value, "event1");
            return (Criteria) this;
        }

        public Criteria andEvent1LessThanOrEqualTo(String value) {
            addCriterion("event1 <=", value, "event1");
            return (Criteria) this;
        }

        public Criteria andEvent1Like(String value) {
            addCriterion("event1 like", value, "event1");
            return (Criteria) this;
        }

        public Criteria andEvent1NotLike(String value) {
            addCriterion("event1 not like", value, "event1");
            return (Criteria) this;
        }

        public Criteria andEvent1In(List<String> values) {
            addCriterion("event1 in", values, "event1");
            return (Criteria) this;
        }

        public Criteria andEvent1NotIn(List<String> values) {
            addCriterion("event1 not in", values, "event1");
            return (Criteria) this;
        }

        public Criteria andEvent1Between(String value1, String value2) {
            addCriterion("event1 between", value1, value2, "event1");
            return (Criteria) this;
        }

        public Criteria andEvent1NotBetween(String value1, String value2) {
            addCriterion("event1 not between", value1, value2, "event1");
            return (Criteria) this;
        }

        public Criteria andEvent1payoutIsNull() {
            addCriterion("event1payout is null");
            return (Criteria) this;
        }

        public Criteria andEvent1payoutIsNotNull() {
            addCriterion("event1payout is not null");
            return (Criteria) this;
        }

        public Criteria andEvent1payoutEqualTo(Float value) {
            addCriterion("event1payout =", value, "event1payout");
            return (Criteria) this;
        }

        public Criteria andEvent1payoutNotEqualTo(Float value) {
            addCriterion("event1payout <>", value, "event1payout");
            return (Criteria) this;
        }

        public Criteria andEvent1payoutGreaterThan(Float value) {
            addCriterion("event1payout >", value, "event1payout");
            return (Criteria) this;
        }

        public Criteria andEvent1payoutGreaterThanOrEqualTo(Float value) {
            addCriterion("event1payout >=", value, "event1payout");
            return (Criteria) this;
        }

        public Criteria andEvent1payoutLessThan(Float value) {
            addCriterion("event1payout <", value, "event1payout");
            return (Criteria) this;
        }

        public Criteria andEvent1payoutLessThanOrEqualTo(Float value) {
            addCriterion("event1payout <=", value, "event1payout");
            return (Criteria) this;
        }

        public Criteria andEvent1payoutIn(List<Float> values) {
            addCriterion("event1payout in", values, "event1payout");
            return (Criteria) this;
        }

        public Criteria andEvent1payoutNotIn(List<Float> values) {
            addCriterion("event1payout not in", values, "event1payout");
            return (Criteria) this;
        }

        public Criteria andEvent1payoutBetween(Float value1, Float value2) {
            addCriterion("event1payout between", value1, value2, "event1payout");
            return (Criteria) this;
        }

        public Criteria andEvent1payoutNotBetween(Float value1, Float value2) {
            addCriterion("event1payout not between", value1, value2, "event1payout");
            return (Criteria) this;
        }

        public Criteria andEvent2IsNull() {
            addCriterion("event2 is null");
            return (Criteria) this;
        }

        public Criteria andEvent2IsNotNull() {
            addCriterion("event2 is not null");
            return (Criteria) this;
        }

        public Criteria andEvent2EqualTo(String value) {
            addCriterion("event2 =", value, "event2");
            return (Criteria) this;
        }

        public Criteria andEvent2NotEqualTo(String value) {
            addCriterion("event2 <>", value, "event2");
            return (Criteria) this;
        }

        public Criteria andEvent2GreaterThan(String value) {
            addCriterion("event2 >", value, "event2");
            return (Criteria) this;
        }

        public Criteria andEvent2GreaterThanOrEqualTo(String value) {
            addCriterion("event2 >=", value, "event2");
            return (Criteria) this;
        }

        public Criteria andEvent2LessThan(String value) {
            addCriterion("event2 <", value, "event2");
            return (Criteria) this;
        }

        public Criteria andEvent2LessThanOrEqualTo(String value) {
            addCriterion("event2 <=", value, "event2");
            return (Criteria) this;
        }

        public Criteria andEvent2Like(String value) {
            addCriterion("event2 like", value, "event2");
            return (Criteria) this;
        }

        public Criteria andEvent2NotLike(String value) {
            addCriterion("event2 not like", value, "event2");
            return (Criteria) this;
        }

        public Criteria andEvent2In(List<String> values) {
            addCriterion("event2 in", values, "event2");
            return (Criteria) this;
        }

        public Criteria andEvent2NotIn(List<String> values) {
            addCriterion("event2 not in", values, "event2");
            return (Criteria) this;
        }

        public Criteria andEvent2Between(String value1, String value2) {
            addCriterion("event2 between", value1, value2, "event2");
            return (Criteria) this;
        }

        public Criteria andEvent2NotBetween(String value1, String value2) {
            addCriterion("event2 not between", value1, value2, "event2");
            return (Criteria) this;
        }

        public Criteria andEvent2payoutIsNull() {
            addCriterion("event2payout is null");
            return (Criteria) this;
        }

        public Criteria andEvent2payoutIsNotNull() {
            addCriterion("event2payout is not null");
            return (Criteria) this;
        }

        public Criteria andEvent2payoutEqualTo(Float value) {
            addCriterion("event2payout =", value, "event2payout");
            return (Criteria) this;
        }

        public Criteria andEvent2payoutNotEqualTo(Float value) {
            addCriterion("event2payout <>", value, "event2payout");
            return (Criteria) this;
        }

        public Criteria andEvent2payoutGreaterThan(Float value) {
            addCriterion("event2payout >", value, "event2payout");
            return (Criteria) this;
        }

        public Criteria andEvent2payoutGreaterThanOrEqualTo(Float value) {
            addCriterion("event2payout >=", value, "event2payout");
            return (Criteria) this;
        }

        public Criteria andEvent2payoutLessThan(Float value) {
            addCriterion("event2payout <", value, "event2payout");
            return (Criteria) this;
        }

        public Criteria andEvent2payoutLessThanOrEqualTo(Float value) {
            addCriterion("event2payout <=", value, "event2payout");
            return (Criteria) this;
        }

        public Criteria andEvent2payoutIn(List<Float> values) {
            addCriterion("event2payout in", values, "event2payout");
            return (Criteria) this;
        }

        public Criteria andEvent2payoutNotIn(List<Float> values) {
            addCriterion("event2payout not in", values, "event2payout");
            return (Criteria) this;
        }

        public Criteria andEvent2payoutBetween(Float value1, Float value2) {
            addCriterion("event2payout between", value1, value2, "event2payout");
            return (Criteria) this;
        }

        public Criteria andEvent2payoutNotBetween(Float value1, Float value2) {
            addCriterion("event2payout not between", value1, value2, "event2payout");
            return (Criteria) this;
        }

        public Criteria andSingularIsNull() {
            addCriterion("singular is null");
            return (Criteria) this;
        }

        public Criteria andSingularIsNotNull() {
            addCriterion("singular is not null");
            return (Criteria) this;
        }

        public Criteria andSingularEqualTo(Integer value) {
            addCriterion("singular =", value, "singular");
            return (Criteria) this;
        }

        public Criteria andSingularNotEqualTo(Integer value) {
            addCriterion("singular <>", value, "singular");
            return (Criteria) this;
        }

        public Criteria andSingularGreaterThan(Integer value) {
            addCriterion("singular >", value, "singular");
            return (Criteria) this;
        }

        public Criteria andSingularGreaterThanOrEqualTo(Integer value) {
            addCriterion("singular >=", value, "singular");
            return (Criteria) this;
        }

        public Criteria andSingularLessThan(Integer value) {
            addCriterion("singular <", value, "singular");
            return (Criteria) this;
        }

        public Criteria andSingularLessThanOrEqualTo(Integer value) {
            addCriterion("singular <=", value, "singular");
            return (Criteria) this;
        }

        public Criteria andSingularIn(List<Integer> values) {
            addCriterion("singular in", values, "singular");
            return (Criteria) this;
        }

        public Criteria andSingularNotIn(List<Integer> values) {
            addCriterion("singular not in", values, "singular");
            return (Criteria) this;
        }

        public Criteria andSingularBetween(Integer value1, Integer value2) {
            addCriterion("singular between", value1, value2, "singular");
            return (Criteria) this;
        }

        public Criteria andSingularNotBetween(Integer value1, Integer value2) {
            addCriterion("singular not between", value1, value2, "singular");
            return (Criteria) this;
        }

        public Criteria andMutigeoIsNull() {
            addCriterion("mutigeo is null");
            return (Criteria) this;
        }

        public Criteria andMutigeoIsNotNull() {
            addCriterion("mutigeo is not null");
            return (Criteria) this;
        }

        public Criteria andMutigeoEqualTo(String value) {
            addCriterion("mutigeo =", value, "mutigeo");
            return (Criteria) this;
        }

        public Criteria andMutigeoNotEqualTo(String value) {
            addCriterion("mutigeo <>", value, "mutigeo");
            return (Criteria) this;
        }

        public Criteria andMutigeoGreaterThan(String value) {
            addCriterion("mutigeo >", value, "mutigeo");
            return (Criteria) this;
        }

        public Criteria andMutigeoGreaterThanOrEqualTo(String value) {
            addCriterion("mutigeo >=", value, "mutigeo");
            return (Criteria) this;
        }

        public Criteria andMutigeoLessThan(String value) {
            addCriterion("mutigeo <", value, "mutigeo");
            return (Criteria) this;
        }

        public Criteria andMutigeoLessThanOrEqualTo(String value) {
            addCriterion("mutigeo <=", value, "mutigeo");
            return (Criteria) this;
        }

        public Criteria andMutigeoLike(String value) {
            addCriterion("mutigeo like", value, "mutigeo");
            return (Criteria) this;
        }

        public Criteria andMutigeoNotLike(String value) {
            addCriterion("mutigeo not like", value, "mutigeo");
            return (Criteria) this;
        }

        public Criteria andMutigeoIn(List<String> values) {
            addCriterion("mutigeo in", values, "mutigeo");
            return (Criteria) this;
        }

        public Criteria andMutigeoNotIn(List<String> values) {
            addCriterion("mutigeo not in", values, "mutigeo");
            return (Criteria) this;
        }

        public Criteria andMutigeoBetween(String value1, String value2) {
            addCriterion("mutigeo between", value1, value2, "mutigeo");
            return (Criteria) this;
        }

        public Criteria andMutigeoNotBetween(String value1, String value2) {
            addCriterion("mutigeo not between", value1, value2, "mutigeo");
            return (Criteria) this;
        }

        public Criteria andMutiosIsNull() {
            addCriterion("mutios is null");
            return (Criteria) this;
        }

        public Criteria andMutiosIsNotNull() {
            addCriterion("mutios is not null");
            return (Criteria) this;
        }

        public Criteria andMutiosEqualTo(String value) {
            addCriterion("mutios =", value, "mutios");
            return (Criteria) this;
        }

        public Criteria andMutiosNotEqualTo(String value) {
            addCriterion("mutios <>", value, "mutios");
            return (Criteria) this;
        }

        public Criteria andMutiosGreaterThan(String value) {
            addCriterion("mutios >", value, "mutios");
            return (Criteria) this;
        }

        public Criteria andMutiosGreaterThanOrEqualTo(String value) {
            addCriterion("mutios >=", value, "mutios");
            return (Criteria) this;
        }

        public Criteria andMutiosLessThan(String value) {
            addCriterion("mutios <", value, "mutios");
            return (Criteria) this;
        }

        public Criteria andMutiosLessThanOrEqualTo(String value) {
            addCriterion("mutios <=", value, "mutios");
            return (Criteria) this;
        }

        public Criteria andMutiosLike(String value) {
            addCriterion("mutios like", value, "mutios");
            return (Criteria) this;
        }

        public Criteria andMutiosNotLike(String value) {
            addCriterion("mutios not like", value, "mutios");
            return (Criteria) this;
        }

        public Criteria andMutiosIn(List<String> values) {
            addCriterion("mutios in", values, "mutios");
            return (Criteria) this;
        }

        public Criteria andMutiosNotIn(List<String> values) {
            addCriterion("mutios not in", values, "mutios");
            return (Criteria) this;
        }

        public Criteria andMutiosBetween(String value1, String value2) {
            addCriterion("mutios between", value1, value2, "mutios");
            return (Criteria) this;
        }

        public Criteria andMutiosNotBetween(String value1, String value2) {
            addCriterion("mutios not between", value1, value2, "mutios");
            return (Criteria) this;
        }

        public Criteria andTargetcityIsNull() {
            addCriterion("targetcity is null");
            return (Criteria) this;
        }

        public Criteria andTargetcityIsNotNull() {
            addCriterion("targetcity is not null");
            return (Criteria) this;
        }

        public Criteria andTargetcityEqualTo(String value) {
            addCriterion("targetcity =", value, "targetcity");
            return (Criteria) this;
        }

        public Criteria andTargetcityNotEqualTo(String value) {
            addCriterion("targetcity <>", value, "targetcity");
            return (Criteria) this;
        }

        public Criteria andTargetcityGreaterThan(String value) {
            addCriterion("targetcity >", value, "targetcity");
            return (Criteria) this;
        }

        public Criteria andTargetcityGreaterThanOrEqualTo(String value) {
            addCriterion("targetcity >=", value, "targetcity");
            return (Criteria) this;
        }

        public Criteria andTargetcityLessThan(String value) {
            addCriterion("targetcity <", value, "targetcity");
            return (Criteria) this;
        }

        public Criteria andTargetcityLessThanOrEqualTo(String value) {
            addCriterion("targetcity <=", value, "targetcity");
            return (Criteria) this;
        }

        public Criteria andTargetcityLike(String value) {
            addCriterion("targetcity like", value, "targetcity");
            return (Criteria) this;
        }

        public Criteria andTargetcityNotLike(String value) {
            addCriterion("targetcity not like", value, "targetcity");
            return (Criteria) this;
        }

        public Criteria andTargetcityIn(List<String> values) {
            addCriterion("targetcity in", values, "targetcity");
            return (Criteria) this;
        }

        public Criteria andTargetcityNotIn(List<String> values) {
            addCriterion("targetcity not in", values, "targetcity");
            return (Criteria) this;
        }

        public Criteria andTargetcityBetween(String value1, String value2) {
            addCriterion("targetcity between", value1, value2, "targetcity");
            return (Criteria) this;
        }

        public Criteria andTargetcityNotBetween(String value1, String value2) {
            addCriterion("targetcity not between", value1, value2, "targetcity");
            return (Criteria) this;
        }

        public Criteria andIos14paramsIsNull() {
            addCriterion("ios14params is null");
            return (Criteria) this;
        }

        public Criteria andIos14paramsIsNotNull() {
            addCriterion("ios14params is not null");
            return (Criteria) this;
        }

        public Criteria andIos14paramsEqualTo(Integer value) {
            addCriterion("ios14params =", value, "ios14params");
            return (Criteria) this;
        }

        public Criteria andIos14paramsNotEqualTo(Integer value) {
            addCriterion("ios14params <>", value, "ios14params");
            return (Criteria) this;
        }

        public Criteria andIos14paramsGreaterThan(Integer value) {
            addCriterion("ios14params >", value, "ios14params");
            return (Criteria) this;
        }

        public Criteria andIos14paramsGreaterThanOrEqualTo(Integer value) {
            addCriterion("ios14params >=", value, "ios14params");
            return (Criteria) this;
        }

        public Criteria andIos14paramsLessThan(Integer value) {
            addCriterion("ios14params <", value, "ios14params");
            return (Criteria) this;
        }

        public Criteria andIos14paramsLessThanOrEqualTo(Integer value) {
            addCriterion("ios14params <=", value, "ios14params");
            return (Criteria) this;
        }

        public Criteria andIos14paramsIn(List<Integer> values) {
            addCriterion("ios14params in", values, "ios14params");
            return (Criteria) this;
        }

        public Criteria andIos14paramsNotIn(List<Integer> values) {
            addCriterion("ios14params not in", values, "ios14params");
            return (Criteria) this;
        }

        public Criteria andIos14paramsBetween(Integer value1, Integer value2) {
            addCriterion("ios14params between", value1, value2, "ios14params");
            return (Criteria) this;
        }

        public Criteria andIos14paramsNotBetween(Integer value1, Integer value2) {
            addCriterion("ios14params not between", value1, value2, "ios14params");
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