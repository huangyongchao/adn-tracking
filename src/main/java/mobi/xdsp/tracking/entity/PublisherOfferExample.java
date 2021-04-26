package mobi.xdsp.tracking.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PublisherOfferExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public PublisherOfferExample() {
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

        public Criteria andOfferidIsNull() {
            addCriterion("offerid is null");
            return (Criteria) this;
        }

        public Criteria andOfferidIsNotNull() {
            addCriterion("offerid is not null");
            return (Criteria) this;
        }

        public Criteria andOfferidEqualTo(Integer value) {
            addCriterion("offerid =", value, "offerid");
            return (Criteria) this;
        }

        public Criteria andOfferidNotEqualTo(Integer value) {
            addCriterion("offerid <>", value, "offerid");
            return (Criteria) this;
        }

        public Criteria andOfferidGreaterThan(Integer value) {
            addCriterion("offerid >", value, "offerid");
            return (Criteria) this;
        }

        public Criteria andOfferidGreaterThanOrEqualTo(Integer value) {
            addCriterion("offerid >=", value, "offerid");
            return (Criteria) this;
        }

        public Criteria andOfferidLessThan(Integer value) {
            addCriterion("offerid <", value, "offerid");
            return (Criteria) this;
        }

        public Criteria andOfferidLessThanOrEqualTo(Integer value) {
            addCriterion("offerid <=", value, "offerid");
            return (Criteria) this;
        }

        public Criteria andOfferidIn(List<Integer> values) {
            addCriterion("offerid in", values, "offerid");
            return (Criteria) this;
        }

        public Criteria andOfferidNotIn(List<Integer> values) {
            addCriterion("offerid not in", values, "offerid");
            return (Criteria) this;
        }

        public Criteria andOfferidBetween(Integer value1, Integer value2) {
            addCriterion("offerid between", value1, value2, "offerid");
            return (Criteria) this;
        }

        public Criteria andOfferidNotBetween(Integer value1, Integer value2) {
            addCriterion("offerid not between", value1, value2, "offerid");
            return (Criteria) this;
        }

        public Criteria andPublisheridIsNull() {
            addCriterion("publisherid is null");
            return (Criteria) this;
        }

        public Criteria andPublisheridIsNotNull() {
            addCriterion("publisherid is not null");
            return (Criteria) this;
        }

        public Criteria andPublisheridEqualTo(Integer value) {
            addCriterion("publisherid =", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridNotEqualTo(Integer value) {
            addCriterion("publisherid <>", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridGreaterThan(Integer value) {
            addCriterion("publisherid >", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("publisherid >=", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridLessThan(Integer value) {
            addCriterion("publisherid <", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridLessThanOrEqualTo(Integer value) {
            addCriterion("publisherid <=", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridIn(List<Integer> values) {
            addCriterion("publisherid in", values, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridNotIn(List<Integer> values) {
            addCriterion("publisherid not in", values, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridBetween(Integer value1, Integer value2) {
            addCriterion("publisherid between", value1, value2, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridNotBetween(Integer value1, Integer value2) {
            addCriterion("publisherid not between", value1, value2, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPayoutIsNull() {
            addCriterion("payout is null");
            return (Criteria) this;
        }

        public Criteria andPayoutIsNotNull() {
            addCriterion("payout is not null");
            return (Criteria) this;
        }

        public Criteria andPayoutEqualTo(BigDecimal value) {
            addCriterion("payout =", value, "payout");
            return (Criteria) this;
        }

        public Criteria andPayoutNotEqualTo(BigDecimal value) {
            addCriterion("payout <>", value, "payout");
            return (Criteria) this;
        }

        public Criteria andPayoutGreaterThan(BigDecimal value) {
            addCriterion("payout >", value, "payout");
            return (Criteria) this;
        }

        public Criteria andPayoutGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("payout >=", value, "payout");
            return (Criteria) this;
        }

        public Criteria andPayoutLessThan(BigDecimal value) {
            addCriterion("payout <", value, "payout");
            return (Criteria) this;
        }

        public Criteria andPayoutLessThanOrEqualTo(BigDecimal value) {
            addCriterion("payout <=", value, "payout");
            return (Criteria) this;
        }

        public Criteria andPayoutIn(List<BigDecimal> values) {
            addCriterion("payout in", values, "payout");
            return (Criteria) this;
        }

        public Criteria andPayoutNotIn(List<BigDecimal> values) {
            addCriterion("payout not in", values, "payout");
            return (Criteria) this;
        }

        public Criteria andPayoutBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payout between", value1, value2, "payout");
            return (Criteria) this;
        }

        public Criteria andPayoutNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payout not between", value1, value2, "payout");
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

        public Criteria andMonthbudgetIsNull() {
            addCriterion("monthbudget is null");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetIsNotNull() {
            addCriterion("monthbudget is not null");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetEqualTo(Float value) {
            addCriterion("monthbudget =", value, "monthbudget");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetNotEqualTo(Float value) {
            addCriterion("monthbudget <>", value, "monthbudget");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetGreaterThan(Float value) {
            addCriterion("monthbudget >", value, "monthbudget");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetGreaterThanOrEqualTo(Float value) {
            addCriterion("monthbudget >=", value, "monthbudget");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetLessThan(Float value) {
            addCriterion("monthbudget <", value, "monthbudget");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetLessThanOrEqualTo(Float value) {
            addCriterion("monthbudget <=", value, "monthbudget");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetIn(List<Float> values) {
            addCriterion("monthbudget in", values, "monthbudget");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetNotIn(List<Float> values) {
            addCriterion("monthbudget not in", values, "monthbudget");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetBetween(Float value1, Float value2) {
            addCriterion("monthbudget between", value1, value2, "monthbudget");
            return (Criteria) this;
        }

        public Criteria andMonthbudgetNotBetween(Float value1, Float value2) {
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

        public Criteria andRedirectIsNull() {
            addCriterion("redirect is null");
            return (Criteria) this;
        }

        public Criteria andRedirectIsNotNull() {
            addCriterion("redirect is not null");
            return (Criteria) this;
        }

        public Criteria andRedirectEqualTo(Byte value) {
            addCriterion("redirect =", value, "redirect");
            return (Criteria) this;
        }

        public Criteria andRedirectNotEqualTo(Byte value) {
            addCriterion("redirect <>", value, "redirect");
            return (Criteria) this;
        }

        public Criteria andRedirectGreaterThan(Byte value) {
            addCriterion("redirect >", value, "redirect");
            return (Criteria) this;
        }

        public Criteria andRedirectGreaterThanOrEqualTo(Byte value) {
            addCriterion("redirect >=", value, "redirect");
            return (Criteria) this;
        }

        public Criteria andRedirectLessThan(Byte value) {
            addCriterion("redirect <", value, "redirect");
            return (Criteria) this;
        }

        public Criteria andRedirectLessThanOrEqualTo(Byte value) {
            addCriterion("redirect <=", value, "redirect");
            return (Criteria) this;
        }

        public Criteria andRedirectIn(List<Byte> values) {
            addCriterion("redirect in", values, "redirect");
            return (Criteria) this;
        }

        public Criteria andRedirectNotIn(List<Byte> values) {
            addCriterion("redirect not in", values, "redirect");
            return (Criteria) this;
        }

        public Criteria andRedirectBetween(Byte value1, Byte value2) {
            addCriterion("redirect between", value1, value2, "redirect");
            return (Criteria) this;
        }

        public Criteria andRedirectNotBetween(Byte value1, Byte value2) {
            addCriterion("redirect not between", value1, value2, "redirect");
            return (Criteria) this;
        }

        public Criteria andApplytimeIsNull() {
            addCriterion("applytime is null");
            return (Criteria) this;
        }

        public Criteria andApplytimeIsNotNull() {
            addCriterion("applytime is not null");
            return (Criteria) this;
        }

        public Criteria andApplytimeEqualTo(Date value) {
            addCriterion("applytime =", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotEqualTo(Date value) {
            addCriterion("applytime <>", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeGreaterThan(Date value) {
            addCriterion("applytime >", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("applytime >=", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeLessThan(Date value) {
            addCriterion("applytime <", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeLessThanOrEqualTo(Date value) {
            addCriterion("applytime <=", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeIn(List<Date> values) {
            addCriterion("applytime in", values, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotIn(List<Date> values) {
            addCriterion("applytime not in", values, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeBetween(Date value1, Date value2) {
            addCriterion("applytime between", value1, value2, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotBetween(Date value1, Date value2) {
            addCriterion("applytime not between", value1, value2, "applytime");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeIsNull() {
            addCriterion("approvaltime is null");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeIsNotNull() {
            addCriterion("approvaltime is not null");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeEqualTo(Date value) {
            addCriterion("approvaltime =", value, "approvaltime");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeNotEqualTo(Date value) {
            addCriterion("approvaltime <>", value, "approvaltime");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeGreaterThan(Date value) {
            addCriterion("approvaltime >", value, "approvaltime");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeGreaterThanOrEqualTo(Date value) {
            addCriterion("approvaltime >=", value, "approvaltime");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeLessThan(Date value) {
            addCriterion("approvaltime <", value, "approvaltime");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeLessThanOrEqualTo(Date value) {
            addCriterion("approvaltime <=", value, "approvaltime");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeIn(List<Date> values) {
            addCriterion("approvaltime in", values, "approvaltime");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeNotIn(List<Date> values) {
            addCriterion("approvaltime not in", values, "approvaltime");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeBetween(Date value1, Date value2) {
            addCriterion("approvaltime between", value1, value2, "approvaltime");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeNotBetween(Date value1, Date value2) {
            addCriterion("approvaltime not between", value1, value2, "approvaltime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andExpirationtimeIsNull() {
            addCriterion("expirationtime is null");
            return (Criteria) this;
        }

        public Criteria andExpirationtimeIsNotNull() {
            addCriterion("expirationtime is not null");
            return (Criteria) this;
        }

        public Criteria andExpirationtimeEqualTo(Date value) {
            addCriterion("expirationtime =", value, "expirationtime");
            return (Criteria) this;
        }

        public Criteria andExpirationtimeNotEqualTo(Date value) {
            addCriterion("expirationtime <>", value, "expirationtime");
            return (Criteria) this;
        }

        public Criteria andExpirationtimeGreaterThan(Date value) {
            addCriterion("expirationtime >", value, "expirationtime");
            return (Criteria) this;
        }

        public Criteria andExpirationtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expirationtime >=", value, "expirationtime");
            return (Criteria) this;
        }

        public Criteria andExpirationtimeLessThan(Date value) {
            addCriterion("expirationtime <", value, "expirationtime");
            return (Criteria) this;
        }

        public Criteria andExpirationtimeLessThanOrEqualTo(Date value) {
            addCriterion("expirationtime <=", value, "expirationtime");
            return (Criteria) this;
        }

        public Criteria andExpirationtimeIn(List<Date> values) {
            addCriterion("expirationtime in", values, "expirationtime");
            return (Criteria) this;
        }

        public Criteria andExpirationtimeNotIn(List<Date> values) {
            addCriterion("expirationtime not in", values, "expirationtime");
            return (Criteria) this;
        }

        public Criteria andExpirationtimeBetween(Date value1, Date value2) {
            addCriterion("expirationtime between", value1, value2, "expirationtime");
            return (Criteria) this;
        }

        public Criteria andExpirationtimeNotBetween(Date value1, Date value2) {
            addCriterion("expirationtime not between", value1, value2, "expirationtime");
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

        public Criteria andAdvertiseridIsNull() {
            addCriterion("advertiserid is null");
            return (Criteria) this;
        }

        public Criteria andAdvertiseridIsNotNull() {
            addCriterion("advertiserid is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertiseridEqualTo(Integer value) {
            addCriterion("advertiserid =", value, "advertiserid");
            return (Criteria) this;
        }

        public Criteria andAdvertiseridNotEqualTo(Integer value) {
            addCriterion("advertiserid <>", value, "advertiserid");
            return (Criteria) this;
        }

        public Criteria andAdvertiseridGreaterThan(Integer value) {
            addCriterion("advertiserid >", value, "advertiserid");
            return (Criteria) this;
        }

        public Criteria andAdvertiseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("advertiserid >=", value, "advertiserid");
            return (Criteria) this;
        }

        public Criteria andAdvertiseridLessThan(Integer value) {
            addCriterion("advertiserid <", value, "advertiserid");
            return (Criteria) this;
        }

        public Criteria andAdvertiseridLessThanOrEqualTo(Integer value) {
            addCriterion("advertiserid <=", value, "advertiserid");
            return (Criteria) this;
        }

        public Criteria andAdvertiseridIn(List<Integer> values) {
            addCriterion("advertiserid in", values, "advertiserid");
            return (Criteria) this;
        }

        public Criteria andAdvertiseridNotIn(List<Integer> values) {
            addCriterion("advertiserid not in", values, "advertiserid");
            return (Criteria) this;
        }

        public Criteria andAdvertiseridBetween(Integer value1, Integer value2) {
            addCriterion("advertiserid between", value1, value2, "advertiserid");
            return (Criteria) this;
        }

        public Criteria andAdvertiseridNotBetween(Integer value1, Integer value2) {
            addCriterion("advertiserid not between", value1, value2, "advertiserid");
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

        public Criteria andDailydummycapIsNull() {
            addCriterion("dailydummycap is null");
            return (Criteria) this;
        }

        public Criteria andDailydummycapIsNotNull() {
            addCriterion("dailydummycap is not null");
            return (Criteria) this;
        }

        public Criteria andDailydummycapEqualTo(Integer value) {
            addCriterion("dailydummycap =", value, "dailydummycap");
            return (Criteria) this;
        }

        public Criteria andDailydummycapNotEqualTo(Integer value) {
            addCriterion("dailydummycap <>", value, "dailydummycap");
            return (Criteria) this;
        }

        public Criteria andDailydummycapGreaterThan(Integer value) {
            addCriterion("dailydummycap >", value, "dailydummycap");
            return (Criteria) this;
        }

        public Criteria andDailydummycapGreaterThanOrEqualTo(Integer value) {
            addCriterion("dailydummycap >=", value, "dailydummycap");
            return (Criteria) this;
        }

        public Criteria andDailydummycapLessThan(Integer value) {
            addCriterion("dailydummycap <", value, "dailydummycap");
            return (Criteria) this;
        }

        public Criteria andDailydummycapLessThanOrEqualTo(Integer value) {
            addCriterion("dailydummycap <=", value, "dailydummycap");
            return (Criteria) this;
        }

        public Criteria andDailydummycapIn(List<Integer> values) {
            addCriterion("dailydummycap in", values, "dailydummycap");
            return (Criteria) this;
        }

        public Criteria andDailydummycapNotIn(List<Integer> values) {
            addCriterion("dailydummycap not in", values, "dailydummycap");
            return (Criteria) this;
        }

        public Criteria andDailydummycapBetween(Integer value1, Integer value2) {
            addCriterion("dailydummycap between", value1, value2, "dailydummycap");
            return (Criteria) this;
        }

        public Criteria andDailydummycapNotBetween(Integer value1, Integer value2) {
            addCriterion("dailydummycap not between", value1, value2, "dailydummycap");
            return (Criteria) this;
        }

        public Criteria andActioncodeIsNull() {
            addCriterion("actioncode is null");
            return (Criteria) this;
        }

        public Criteria andActioncodeIsNotNull() {
            addCriterion("actioncode is not null");
            return (Criteria) this;
        }

        public Criteria andActioncodeEqualTo(Integer value) {
            addCriterion("actioncode =", value, "actioncode");
            return (Criteria) this;
        }

        public Criteria andActioncodeNotEqualTo(Integer value) {
            addCriterion("actioncode <>", value, "actioncode");
            return (Criteria) this;
        }

        public Criteria andActioncodeGreaterThan(Integer value) {
            addCriterion("actioncode >", value, "actioncode");
            return (Criteria) this;
        }

        public Criteria andActioncodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("actioncode >=", value, "actioncode");
            return (Criteria) this;
        }

        public Criteria andActioncodeLessThan(Integer value) {
            addCriterion("actioncode <", value, "actioncode");
            return (Criteria) this;
        }

        public Criteria andActioncodeLessThanOrEqualTo(Integer value) {
            addCriterion("actioncode <=", value, "actioncode");
            return (Criteria) this;
        }

        public Criteria andActioncodeIn(List<Integer> values) {
            addCriterion("actioncode in", values, "actioncode");
            return (Criteria) this;
        }

        public Criteria andActioncodeNotIn(List<Integer> values) {
            addCriterion("actioncode not in", values, "actioncode");
            return (Criteria) this;
        }

        public Criteria andActioncodeBetween(Integer value1, Integer value2) {
            addCriterion("actioncode between", value1, value2, "actioncode");
            return (Criteria) this;
        }

        public Criteria andActioncodeNotBetween(Integer value1, Integer value2) {
            addCriterion("actioncode not between", value1, value2, "actioncode");
            return (Criteria) this;
        }

        public Criteria andActionlogIsNull() {
            addCriterion("actionlog is null");
            return (Criteria) this;
        }

        public Criteria andActionlogIsNotNull() {
            addCriterion("actionlog is not null");
            return (Criteria) this;
        }

        public Criteria andActionlogEqualTo(String value) {
            addCriterion("actionlog =", value, "actionlog");
            return (Criteria) this;
        }

        public Criteria andActionlogNotEqualTo(String value) {
            addCriterion("actionlog <>", value, "actionlog");
            return (Criteria) this;
        }

        public Criteria andActionlogGreaterThan(String value) {
            addCriterion("actionlog >", value, "actionlog");
            return (Criteria) this;
        }

        public Criteria andActionlogGreaterThanOrEqualTo(String value) {
            addCriterion("actionlog >=", value, "actionlog");
            return (Criteria) this;
        }

        public Criteria andActionlogLessThan(String value) {
            addCriterion("actionlog <", value, "actionlog");
            return (Criteria) this;
        }

        public Criteria andActionlogLessThanOrEqualTo(String value) {
            addCriterion("actionlog <=", value, "actionlog");
            return (Criteria) this;
        }

        public Criteria andActionlogLike(String value) {
            addCriterion("actionlog like", value, "actionlog");
            return (Criteria) this;
        }

        public Criteria andActionlogNotLike(String value) {
            addCriterion("actionlog not like", value, "actionlog");
            return (Criteria) this;
        }

        public Criteria andActionlogIn(List<String> values) {
            addCriterion("actionlog in", values, "actionlog");
            return (Criteria) this;
        }

        public Criteria andActionlogNotIn(List<String> values) {
            addCriterion("actionlog not in", values, "actionlog");
            return (Criteria) this;
        }

        public Criteria andActionlogBetween(String value1, String value2) {
            addCriterion("actionlog between", value1, value2, "actionlog");
            return (Criteria) this;
        }

        public Criteria andActionlogNotBetween(String value1, String value2) {
            addCriterion("actionlog not between", value1, value2, "actionlog");
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

        public Criteria andDirectrateIsNull() {
            addCriterion("directrate is null");
            return (Criteria) this;
        }

        public Criteria andDirectrateIsNotNull() {
            addCriterion("directrate is not null");
            return (Criteria) this;
        }

        public Criteria andDirectrateEqualTo(Integer value) {
            addCriterion("directrate =", value, "directrate");
            return (Criteria) this;
        }

        public Criteria andDirectrateNotEqualTo(Integer value) {
            addCriterion("directrate <>", value, "directrate");
            return (Criteria) this;
        }

        public Criteria andDirectrateGreaterThan(Integer value) {
            addCriterion("directrate >", value, "directrate");
            return (Criteria) this;
        }

        public Criteria andDirectrateGreaterThanOrEqualTo(Integer value) {
            addCriterion("directrate >=", value, "directrate");
            return (Criteria) this;
        }

        public Criteria andDirectrateLessThan(Integer value) {
            addCriterion("directrate <", value, "directrate");
            return (Criteria) this;
        }

        public Criteria andDirectrateLessThanOrEqualTo(Integer value) {
            addCriterion("directrate <=", value, "directrate");
            return (Criteria) this;
        }

        public Criteria andDirectrateIn(List<Integer> values) {
            addCriterion("directrate in", values, "directrate");
            return (Criteria) this;
        }

        public Criteria andDirectrateNotIn(List<Integer> values) {
            addCriterion("directrate not in", values, "directrate");
            return (Criteria) this;
        }

        public Criteria andDirectrateBetween(Integer value1, Integer value2) {
            addCriterion("directrate between", value1, value2, "directrate");
            return (Criteria) this;
        }

        public Criteria andDirectrateNotBetween(Integer value1, Integer value2) {
            addCriterion("directrate not between", value1, value2, "directrate");
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

        public Criteria andOaplacementsIsNull() {
            addCriterion("oaplacements is null");
            return (Criteria) this;
        }

        public Criteria andOaplacementsIsNotNull() {
            addCriterion("oaplacements is not null");
            return (Criteria) this;
        }

        public Criteria andOaplacementsEqualTo(String value) {
            addCriterion("oaplacements =", value, "oaplacements");
            return (Criteria) this;
        }

        public Criteria andOaplacementsNotEqualTo(String value) {
            addCriterion("oaplacements <>", value, "oaplacements");
            return (Criteria) this;
        }

        public Criteria andOaplacementsGreaterThan(String value) {
            addCriterion("oaplacements >", value, "oaplacements");
            return (Criteria) this;
        }

        public Criteria andOaplacementsGreaterThanOrEqualTo(String value) {
            addCriterion("oaplacements >=", value, "oaplacements");
            return (Criteria) this;
        }

        public Criteria andOaplacementsLessThan(String value) {
            addCriterion("oaplacements <", value, "oaplacements");
            return (Criteria) this;
        }

        public Criteria andOaplacementsLessThanOrEqualTo(String value) {
            addCriterion("oaplacements <=", value, "oaplacements");
            return (Criteria) this;
        }

        public Criteria andOaplacementsLike(String value) {
            addCriterion("oaplacements like", value, "oaplacements");
            return (Criteria) this;
        }

        public Criteria andOaplacementsNotLike(String value) {
            addCriterion("oaplacements not like", value, "oaplacements");
            return (Criteria) this;
        }

        public Criteria andOaplacementsIn(List<String> values) {
            addCriterion("oaplacements in", values, "oaplacements");
            return (Criteria) this;
        }

        public Criteria andOaplacementsNotIn(List<String> values) {
            addCriterion("oaplacements not in", values, "oaplacements");
            return (Criteria) this;
        }

        public Criteria andOaplacementsBetween(String value1, String value2) {
            addCriterion("oaplacements between", value1, value2, "oaplacements");
            return (Criteria) this;
        }

        public Criteria andOaplacementsNotBetween(String value1, String value2) {
            addCriterion("oaplacements not between", value1, value2, "oaplacements");
            return (Criteria) this;
        }

        public Criteria andDirectofferidsIsNull() {
            addCriterion("directofferids is null");
            return (Criteria) this;
        }

        public Criteria andDirectofferidsIsNotNull() {
            addCriterion("directofferids is not null");
            return (Criteria) this;
        }

        public Criteria andDirectofferidsEqualTo(String value) {
            addCriterion("directofferids =", value, "directofferids");
            return (Criteria) this;
        }

        public Criteria andDirectofferidsNotEqualTo(String value) {
            addCriterion("directofferids <>", value, "directofferids");
            return (Criteria) this;
        }

        public Criteria andDirectofferidsGreaterThan(String value) {
            addCriterion("directofferids >", value, "directofferids");
            return (Criteria) this;
        }

        public Criteria andDirectofferidsGreaterThanOrEqualTo(String value) {
            addCriterion("directofferids >=", value, "directofferids");
            return (Criteria) this;
        }

        public Criteria andDirectofferidsLessThan(String value) {
            addCriterion("directofferids <", value, "directofferids");
            return (Criteria) this;
        }

        public Criteria andDirectofferidsLessThanOrEqualTo(String value) {
            addCriterion("directofferids <=", value, "directofferids");
            return (Criteria) this;
        }

        public Criteria andDirectofferidsLike(String value) {
            addCriterion("directofferids like", value, "directofferids");
            return (Criteria) this;
        }

        public Criteria andDirectofferidsNotLike(String value) {
            addCriterion("directofferids not like", value, "directofferids");
            return (Criteria) this;
        }

        public Criteria andDirectofferidsIn(List<String> values) {
            addCriterion("directofferids in", values, "directofferids");
            return (Criteria) this;
        }

        public Criteria andDirectofferidsNotIn(List<String> values) {
            addCriterion("directofferids not in", values, "directofferids");
            return (Criteria) this;
        }

        public Criteria andDirectofferidsBetween(String value1, String value2) {
            addCriterion("directofferids between", value1, value2, "directofferids");
            return (Criteria) this;
        }

        public Criteria andDirectofferidsNotBetween(String value1, String value2) {
            addCriterion("directofferids not between", value1, value2, "directofferids");
            return (Criteria) this;
        }

        public Criteria andConfigflagIsNull() {
            addCriterion("configflag is null");
            return (Criteria) this;
        }

        public Criteria andConfigflagIsNotNull() {
            addCriterion("configflag is not null");
            return (Criteria) this;
        }

        public Criteria andConfigflagEqualTo(Integer value) {
            addCriterion("configflag =", value, "configflag");
            return (Criteria) this;
        }

        public Criteria andConfigflagNotEqualTo(Integer value) {
            addCriterion("configflag <>", value, "configflag");
            return (Criteria) this;
        }

        public Criteria andConfigflagGreaterThan(Integer value) {
            addCriterion("configflag >", value, "configflag");
            return (Criteria) this;
        }

        public Criteria andConfigflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("configflag >=", value, "configflag");
            return (Criteria) this;
        }

        public Criteria andConfigflagLessThan(Integer value) {
            addCriterion("configflag <", value, "configflag");
            return (Criteria) this;
        }

        public Criteria andConfigflagLessThanOrEqualTo(Integer value) {
            addCriterion("configflag <=", value, "configflag");
            return (Criteria) this;
        }

        public Criteria andConfigflagIn(List<Integer> values) {
            addCriterion("configflag in", values, "configflag");
            return (Criteria) this;
        }

        public Criteria andConfigflagNotIn(List<Integer> values) {
            addCriterion("configflag not in", values, "configflag");
            return (Criteria) this;
        }

        public Criteria andConfigflagBetween(Integer value1, Integer value2) {
            addCriterion("configflag between", value1, value2, "configflag");
            return (Criteria) this;
        }

        public Criteria andConfigflagNotBetween(Integer value1, Integer value2) {
            addCriterion("configflag not between", value1, value2, "configflag");
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