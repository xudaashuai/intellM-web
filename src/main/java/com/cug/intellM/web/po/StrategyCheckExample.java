package com.cug.intellM.web.po;

import java.util.ArrayList;
import java.util.List;

public class StrategyCheckExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StrategyCheckExample() {
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

        public Criteria andStrategyidIsNull() {
            addCriterion("StrategyID is null");
            return (Criteria) this;
        }

        public Criteria andStrategyidIsNotNull() {
            addCriterion("StrategyID is not null");
            return (Criteria) this;
        }

        public Criteria andStrategyidEqualTo(Integer value) {
            addCriterion("StrategyID =", value, "strategyid");
            return (Criteria) this;
        }

        public Criteria andStrategyidNotEqualTo(Integer value) {
            addCriterion("StrategyID <>", value, "strategyid");
            return (Criteria) this;
        }

        public Criteria andStrategyidGreaterThan(Integer value) {
            addCriterion("StrategyID >", value, "strategyid");
            return (Criteria) this;
        }

        public Criteria andStrategyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("StrategyID >=", value, "strategyid");
            return (Criteria) this;
        }

        public Criteria andStrategyidLessThan(Integer value) {
            addCriterion("StrategyID <", value, "strategyid");
            return (Criteria) this;
        }

        public Criteria andStrategyidLessThanOrEqualTo(Integer value) {
            addCriterion("StrategyID <=", value, "strategyid");
            return (Criteria) this;
        }

        public Criteria andStrategyidIn(List<Integer> values) {
            addCriterion("StrategyID in", values, "strategyid");
            return (Criteria) this;
        }

        public Criteria andStrategyidNotIn(List<Integer> values) {
            addCriterion("StrategyID not in", values, "strategyid");
            return (Criteria) this;
        }

        public Criteria andStrategyidBetween(Integer value1, Integer value2) {
            addCriterion("StrategyID between", value1, value2, "strategyid");
            return (Criteria) this;
        }

        public Criteria andStrategyidNotBetween(Integer value1, Integer value2) {
            addCriterion("StrategyID not between", value1, value2, "strategyid");
            return (Criteria) this;
        }

        public Criteria andRuleidIsNull() {
            addCriterion("RuleID is null");
            return (Criteria) this;
        }

        public Criteria andRuleidIsNotNull() {
            addCriterion("RuleID is not null");
            return (Criteria) this;
        }

        public Criteria andRuleidEqualTo(Integer value) {
            addCriterion("RuleID =", value, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidNotEqualTo(Integer value) {
            addCriterion("RuleID <>", value, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidGreaterThan(Integer value) {
            addCriterion("RuleID >", value, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("RuleID >=", value, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidLessThan(Integer value) {
            addCriterion("RuleID <", value, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidLessThanOrEqualTo(Integer value) {
            addCriterion("RuleID <=", value, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidIn(List<Integer> values) {
            addCriterion("RuleID in", values, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidNotIn(List<Integer> values) {
            addCriterion("RuleID not in", values, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidBetween(Integer value1, Integer value2) {
            addCriterion("RuleID between", value1, value2, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidNotBetween(Integer value1, Integer value2) {
            addCriterion("RuleID not between", value1, value2, "ruleid");
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