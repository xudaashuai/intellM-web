package com.cug.intellM.web.po;

import java.util.ArrayList;
import java.util.List;

public class ModelAlgorithmExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModelAlgorithmExample() {
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

        public Criteria andModelIdIsNull() {
            addCriterion("Model_ID is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("Model_ID is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(String value) {
            addCriterion("Model_ID =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(String value) {
            addCriterion("Model_ID <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(String value) {
            addCriterion("Model_ID >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(String value) {
            addCriterion("Model_ID >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(String value) {
            addCriterion("Model_ID <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(String value) {
            addCriterion("Model_ID <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLike(String value) {
            addCriterion("Model_ID like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotLike(String value) {
            addCriterion("Model_ID not like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<String> values) {
            addCriterion("Model_ID in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<String> values) {
            addCriterion("Model_ID not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(String value1, String value2) {
            addCriterion("Model_ID between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(String value1, String value2) {
            addCriterion("Model_ID not between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("Model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("Model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("Model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("Model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("Model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("Model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("Model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("Model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("Model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("Model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("Model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("Model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("Model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("Model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andAlgorithmIsNull() {
            addCriterion("Algorithm is null");
            return (Criteria) this;
        }

        public Criteria andAlgorithmIsNotNull() {
            addCriterion("Algorithm is not null");
            return (Criteria) this;
        }

        public Criteria andAlgorithmEqualTo(String value) {
            addCriterion("Algorithm =", value, "algorithm");
            return (Criteria) this;
        }

        public Criteria andAlgorithmNotEqualTo(String value) {
            addCriterion("Algorithm <>", value, "algorithm");
            return (Criteria) this;
        }

        public Criteria andAlgorithmGreaterThan(String value) {
            addCriterion("Algorithm >", value, "algorithm");
            return (Criteria) this;
        }

        public Criteria andAlgorithmGreaterThanOrEqualTo(String value) {
            addCriterion("Algorithm >=", value, "algorithm");
            return (Criteria) this;
        }

        public Criteria andAlgorithmLessThan(String value) {
            addCriterion("Algorithm <", value, "algorithm");
            return (Criteria) this;
        }

        public Criteria andAlgorithmLessThanOrEqualTo(String value) {
            addCriterion("Algorithm <=", value, "algorithm");
            return (Criteria) this;
        }

        public Criteria andAlgorithmLike(String value) {
            addCriterion("Algorithm like", value, "algorithm");
            return (Criteria) this;
        }

        public Criteria andAlgorithmNotLike(String value) {
            addCriterion("Algorithm not like", value, "algorithm");
            return (Criteria) this;
        }

        public Criteria andAlgorithmIn(List<String> values) {
            addCriterion("Algorithm in", values, "algorithm");
            return (Criteria) this;
        }

        public Criteria andAlgorithmNotIn(List<String> values) {
            addCriterion("Algorithm not in", values, "algorithm");
            return (Criteria) this;
        }

        public Criteria andAlgorithmBetween(String value1, String value2) {
            addCriterion("Algorithm between", value1, value2, "algorithm");
            return (Criteria) this;
        }

        public Criteria andAlgorithmNotBetween(String value1, String value2) {
            addCriterion("Algorithm not between", value1, value2, "algorithm");
            return (Criteria) this;
        }

        public Criteria andRmarkIsNull() {
            addCriterion("Rmark is null");
            return (Criteria) this;
        }

        public Criteria andRmarkIsNotNull() {
            addCriterion("Rmark is not null");
            return (Criteria) this;
        }

        public Criteria andRmarkEqualTo(String value) {
            addCriterion("Rmark =", value, "rmark");
            return (Criteria) this;
        }

        public Criteria andRmarkNotEqualTo(String value) {
            addCriterion("Rmark <>", value, "rmark");
            return (Criteria) this;
        }

        public Criteria andRmarkGreaterThan(String value) {
            addCriterion("Rmark >", value, "rmark");
            return (Criteria) this;
        }

        public Criteria andRmarkGreaterThanOrEqualTo(String value) {
            addCriterion("Rmark >=", value, "rmark");
            return (Criteria) this;
        }

        public Criteria andRmarkLessThan(String value) {
            addCriterion("Rmark <", value, "rmark");
            return (Criteria) this;
        }

        public Criteria andRmarkLessThanOrEqualTo(String value) {
            addCriterion("Rmark <=", value, "rmark");
            return (Criteria) this;
        }

        public Criteria andRmarkLike(String value) {
            addCriterion("Rmark like", value, "rmark");
            return (Criteria) this;
        }

        public Criteria andRmarkNotLike(String value) {
            addCriterion("Rmark not like", value, "rmark");
            return (Criteria) this;
        }

        public Criteria andRmarkIn(List<String> values) {
            addCriterion("Rmark in", values, "rmark");
            return (Criteria) this;
        }

        public Criteria andRmarkNotIn(List<String> values) {
            addCriterion("Rmark not in", values, "rmark");
            return (Criteria) this;
        }

        public Criteria andRmarkBetween(String value1, String value2) {
            addCriterion("Rmark between", value1, value2, "rmark");
            return (Criteria) this;
        }

        public Criteria andRmarkNotBetween(String value1, String value2) {
            addCriterion("Rmark not between", value1, value2, "rmark");
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