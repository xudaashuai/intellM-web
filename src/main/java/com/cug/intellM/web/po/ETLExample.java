package com.cug.intellM.web.po;

import java.util.ArrayList;
import java.util.List;

public class ETLExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ETLExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStrategynameIsNull() {
            addCriterion("StrategyName is null");
            return (Criteria) this;
        }

        public Criteria andStrategynameIsNotNull() {
            addCriterion("StrategyName is not null");
            return (Criteria) this;
        }

        public Criteria andStrategynameEqualTo(String value) {
            addCriterion("StrategyName =", value, "strategyname");
            return (Criteria) this;
        }

        public Criteria andStrategynameNotEqualTo(String value) {
            addCriterion("StrategyName <>", value, "strategyname");
            return (Criteria) this;
        }

        public Criteria andStrategynameGreaterThan(String value) {
            addCriterion("StrategyName >", value, "strategyname");
            return (Criteria) this;
        }

        public Criteria andStrategynameGreaterThanOrEqualTo(String value) {
            addCriterion("StrategyName >=", value, "strategyname");
            return (Criteria) this;
        }

        public Criteria andStrategynameLessThan(String value) {
            addCriterion("StrategyName <", value, "strategyname");
            return (Criteria) this;
        }

        public Criteria andStrategynameLessThanOrEqualTo(String value) {
            addCriterion("StrategyName <=", value, "strategyname");
            return (Criteria) this;
        }

        public Criteria andStrategynameLike(String value) {
            addCriterion("StrategyName like", value, "strategyname");
            return (Criteria) this;
        }

        public Criteria andStrategynameNotLike(String value) {
            addCriterion("StrategyName not like", value, "strategyname");
            return (Criteria) this;
        }

        public Criteria andStrategynameIn(List<String> values) {
            addCriterion("StrategyName in", values, "strategyname");
            return (Criteria) this;
        }

        public Criteria andStrategynameNotIn(List<String> values) {
            addCriterion("StrategyName not in", values, "strategyname");
            return (Criteria) this;
        }

        public Criteria andStrategynameBetween(String value1, String value2) {
            addCriterion("StrategyName between", value1, value2, "strategyname");
            return (Criteria) this;
        }

        public Criteria andStrategynameNotBetween(String value1, String value2) {
            addCriterion("StrategyName not between", value1, value2, "strategyname");
            return (Criteria) this;
        }

        public Criteria andExtractresourceIsNull() {
            addCriterion("ExtractResource is null");
            return (Criteria) this;
        }

        public Criteria andExtractresourceIsNotNull() {
            addCriterion("ExtractResource is not null");
            return (Criteria) this;
        }

        public Criteria andExtractresourceEqualTo(Integer value) {
            addCriterion("ExtractResource =", value, "extractresource");
            return (Criteria) this;
        }

        public Criteria andExtractresourceNotEqualTo(Integer value) {
            addCriterion("ExtractResource <>", value, "extractresource");
            return (Criteria) this;
        }

        public Criteria andExtractresourceGreaterThan(Integer value) {
            addCriterion("ExtractResource >", value, "extractresource");
            return (Criteria) this;
        }

        public Criteria andExtractresourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("ExtractResource >=", value, "extractresource");
            return (Criteria) this;
        }

        public Criteria andExtractresourceLessThan(Integer value) {
            addCriterion("ExtractResource <", value, "extractresource");
            return (Criteria) this;
        }

        public Criteria andExtractresourceLessThanOrEqualTo(Integer value) {
            addCriterion("ExtractResource <=", value, "extractresource");
            return (Criteria) this;
        }

        public Criteria andExtractresourceIn(List<Integer> values) {
            addCriterion("ExtractResource in", values, "extractresource");
            return (Criteria) this;
        }

        public Criteria andExtractresourceNotIn(List<Integer> values) {
            addCriterion("ExtractResource not in", values, "extractresource");
            return (Criteria) this;
        }

        public Criteria andExtractresourceBetween(Integer value1, Integer value2) {
            addCriterion("ExtractResource between", value1, value2, "extractresource");
            return (Criteria) this;
        }

        public Criteria andExtractresourceNotBetween(Integer value1, Integer value2) {
            addCriterion("ExtractResource not between", value1, value2, "extractresource");
            return (Criteria) this;
        }

        public Criteria andExtratdetailsIsNull() {
            addCriterion("ExtratDetails is null");
            return (Criteria) this;
        }

        public Criteria andExtratdetailsIsNotNull() {
            addCriterion("ExtratDetails is not null");
            return (Criteria) this;
        }

        public Criteria andExtratdetailsEqualTo(String value) {
            addCriterion("ExtratDetails =", value, "extratdetails");
            return (Criteria) this;
        }

        public Criteria andExtratdetailsNotEqualTo(String value) {
            addCriterion("ExtratDetails <>", value, "extratdetails");
            return (Criteria) this;
        }

        public Criteria andExtratdetailsGreaterThan(String value) {
            addCriterion("ExtratDetails >", value, "extratdetails");
            return (Criteria) this;
        }

        public Criteria andExtratdetailsGreaterThanOrEqualTo(String value) {
            addCriterion("ExtratDetails >=", value, "extratdetails");
            return (Criteria) this;
        }

        public Criteria andExtratdetailsLessThan(String value) {
            addCriterion("ExtratDetails <", value, "extratdetails");
            return (Criteria) this;
        }

        public Criteria andExtratdetailsLessThanOrEqualTo(String value) {
            addCriterion("ExtratDetails <=", value, "extratdetails");
            return (Criteria) this;
        }

        public Criteria andExtratdetailsLike(String value) {
            addCriterion("ExtratDetails like", value, "extratdetails");
            return (Criteria) this;
        }

        public Criteria andExtratdetailsNotLike(String value) {
            addCriterion("ExtratDetails not like", value, "extratdetails");
            return (Criteria) this;
        }

        public Criteria andExtratdetailsIn(List<String> values) {
            addCriterion("ExtratDetails in", values, "extratdetails");
            return (Criteria) this;
        }

        public Criteria andExtratdetailsNotIn(List<String> values) {
            addCriterion("ExtratDetails not in", values, "extratdetails");
            return (Criteria) this;
        }

        public Criteria andExtratdetailsBetween(String value1, String value2) {
            addCriterion("ExtratDetails between", value1, value2, "extratdetails");
            return (Criteria) this;
        }

        public Criteria andExtratdetailsNotBetween(String value1, String value2) {
            addCriterion("ExtratDetails not between", value1, value2, "extratdetails");
            return (Criteria) this;
        }

        public Criteria andLoadresourceIsNull() {
            addCriterion("LoadResource is null");
            return (Criteria) this;
        }

        public Criteria andLoadresourceIsNotNull() {
            addCriterion("LoadResource is not null");
            return (Criteria) this;
        }

        public Criteria andLoadresourceEqualTo(Integer value) {
            addCriterion("LoadResource =", value, "loadresource");
            return (Criteria) this;
        }

        public Criteria andLoadresourceNotEqualTo(Integer value) {
            addCriterion("LoadResource <>", value, "loadresource");
            return (Criteria) this;
        }

        public Criteria andLoadresourceGreaterThan(Integer value) {
            addCriterion("LoadResource >", value, "loadresource");
            return (Criteria) this;
        }

        public Criteria andLoadresourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("LoadResource >=", value, "loadresource");
            return (Criteria) this;
        }

        public Criteria andLoadresourceLessThan(Integer value) {
            addCriterion("LoadResource <", value, "loadresource");
            return (Criteria) this;
        }

        public Criteria andLoadresourceLessThanOrEqualTo(Integer value) {
            addCriterion("LoadResource <=", value, "loadresource");
            return (Criteria) this;
        }

        public Criteria andLoadresourceIn(List<Integer> values) {
            addCriterion("LoadResource in", values, "loadresource");
            return (Criteria) this;
        }

        public Criteria andLoadresourceNotIn(List<Integer> values) {
            addCriterion("LoadResource not in", values, "loadresource");
            return (Criteria) this;
        }

        public Criteria andLoadresourceBetween(Integer value1, Integer value2) {
            addCriterion("LoadResource between", value1, value2, "loadresource");
            return (Criteria) this;
        }

        public Criteria andLoadresourceNotBetween(Integer value1, Integer value2) {
            addCriterion("LoadResource not between", value1, value2, "loadresource");
            return (Criteria) this;
        }

        public Criteria andLoaddetailsIsNull() {
            addCriterion("LoadDetails is null");
            return (Criteria) this;
        }

        public Criteria andLoaddetailsIsNotNull() {
            addCriterion("LoadDetails is not null");
            return (Criteria) this;
        }

        public Criteria andLoaddetailsEqualTo(String value) {
            addCriterion("LoadDetails =", value, "loaddetails");
            return (Criteria) this;
        }

        public Criteria andLoaddetailsNotEqualTo(String value) {
            addCriterion("LoadDetails <>", value, "loaddetails");
            return (Criteria) this;
        }

        public Criteria andLoaddetailsGreaterThan(String value) {
            addCriterion("LoadDetails >", value, "loaddetails");
            return (Criteria) this;
        }

        public Criteria andLoaddetailsGreaterThanOrEqualTo(String value) {
            addCriterion("LoadDetails >=", value, "loaddetails");
            return (Criteria) this;
        }

        public Criteria andLoaddetailsLessThan(String value) {
            addCriterion("LoadDetails <", value, "loaddetails");
            return (Criteria) this;
        }

        public Criteria andLoaddetailsLessThanOrEqualTo(String value) {
            addCriterion("LoadDetails <=", value, "loaddetails");
            return (Criteria) this;
        }

        public Criteria andLoaddetailsLike(String value) {
            addCriterion("LoadDetails like", value, "loaddetails");
            return (Criteria) this;
        }

        public Criteria andLoaddetailsNotLike(String value) {
            addCriterion("LoadDetails not like", value, "loaddetails");
            return (Criteria) this;
        }

        public Criteria andLoaddetailsIn(List<String> values) {
            addCriterion("LoadDetails in", values, "loaddetails");
            return (Criteria) this;
        }

        public Criteria andLoaddetailsNotIn(List<String> values) {
            addCriterion("LoadDetails not in", values, "loaddetails");
            return (Criteria) this;
        }

        public Criteria andLoaddetailsBetween(String value1, String value2) {
            addCriterion("LoadDetails between", value1, value2, "loaddetails");
            return (Criteria) this;
        }

        public Criteria andLoaddetailsNotBetween(String value1, String value2) {
            addCriterion("LoadDetails not between", value1, value2, "loaddetails");
            return (Criteria) this;
        }

        public Criteria andExecutioncycleIsNull() {
            addCriterion("ExecutionCycle is null");
            return (Criteria) this;
        }

        public Criteria andExecutioncycleIsNotNull() {
            addCriterion("ExecutionCycle is not null");
            return (Criteria) this;
        }

        public Criteria andExecutioncycleEqualTo(String value) {
            addCriterion("ExecutionCycle =", value, "executioncycle");
            return (Criteria) this;
        }

        public Criteria andExecutioncycleNotEqualTo(String value) {
            addCriterion("ExecutionCycle <>", value, "executioncycle");
            return (Criteria) this;
        }

        public Criteria andExecutioncycleGreaterThan(String value) {
            addCriterion("ExecutionCycle >", value, "executioncycle");
            return (Criteria) this;
        }

        public Criteria andExecutioncycleGreaterThanOrEqualTo(String value) {
            addCriterion("ExecutionCycle >=", value, "executioncycle");
            return (Criteria) this;
        }

        public Criteria andExecutioncycleLessThan(String value) {
            addCriterion("ExecutionCycle <", value, "executioncycle");
            return (Criteria) this;
        }

        public Criteria andExecutioncycleLessThanOrEqualTo(String value) {
            addCriterion("ExecutionCycle <=", value, "executioncycle");
            return (Criteria) this;
        }

        public Criteria andExecutioncycleLike(String value) {
            addCriterion("ExecutionCycle like", value, "executioncycle");
            return (Criteria) this;
        }

        public Criteria andExecutioncycleNotLike(String value) {
            addCriterion("ExecutionCycle not like", value, "executioncycle");
            return (Criteria) this;
        }

        public Criteria andExecutioncycleIn(List<String> values) {
            addCriterion("ExecutionCycle in", values, "executioncycle");
            return (Criteria) this;
        }

        public Criteria andExecutioncycleNotIn(List<String> values) {
            addCriterion("ExecutionCycle not in", values, "executioncycle");
            return (Criteria) this;
        }

        public Criteria andExecutioncycleBetween(String value1, String value2) {
            addCriterion("ExecutionCycle between", value1, value2, "executioncycle");
            return (Criteria) this;
        }

        public Criteria andExecutioncycleNotBetween(String value1, String value2) {
            addCriterion("ExecutionCycle not between", value1, value2, "executioncycle");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("Remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("Remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("Remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("Remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("Remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("Remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("Remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("Remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("Remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("Remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("Remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("Remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("Remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("Remark not between", value1, value2, "remark");
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