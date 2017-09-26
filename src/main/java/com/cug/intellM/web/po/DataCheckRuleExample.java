package com.cug.intellM.web.po;

import java.util.ArrayList;
import java.util.List;

public class DataCheckRuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DataCheckRuleExample() {
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

        public Criteria andCheckruleIsNull() {
            addCriterion("CheckRule is null");
            return (Criteria) this;
        }

        public Criteria andCheckruleIsNotNull() {
            addCriterion("CheckRule is not null");
            return (Criteria) this;
        }

        public Criteria andCheckruleEqualTo(Integer value) {
            addCriterion("CheckRule =", value, "checkrule");
            return (Criteria) this;
        }

        public Criteria andCheckruleNotEqualTo(Integer value) {
            addCriterion("CheckRule <>", value, "checkrule");
            return (Criteria) this;
        }

        public Criteria andCheckruleGreaterThan(Integer value) {
            addCriterion("CheckRule >", value, "checkrule");
            return (Criteria) this;
        }

        public Criteria andCheckruleGreaterThanOrEqualTo(Integer value) {
            addCriterion("CheckRule >=", value, "checkrule");
            return (Criteria) this;
        }

        public Criteria andCheckruleLessThan(Integer value) {
            addCriterion("CheckRule <", value, "checkrule");
            return (Criteria) this;
        }

        public Criteria andCheckruleLessThanOrEqualTo(Integer value) {
            addCriterion("CheckRule <=", value, "checkrule");
            return (Criteria) this;
        }

        public Criteria andCheckruleIn(List<Integer> values) {
            addCriterion("CheckRule in", values, "checkrule");
            return (Criteria) this;
        }

        public Criteria andCheckruleNotIn(List<Integer> values) {
            addCriterion("CheckRule not in", values, "checkrule");
            return (Criteria) this;
        }

        public Criteria andCheckruleBetween(Integer value1, Integer value2) {
            addCriterion("CheckRule between", value1, value2, "checkrule");
            return (Criteria) this;
        }

        public Criteria andCheckruleNotBetween(Integer value1, Integer value2) {
            addCriterion("CheckRule not between", value1, value2, "checkrule");
            return (Criteria) this;
        }

        public Criteria andChecktypeIsNull() {
            addCriterion("CheckType is null");
            return (Criteria) this;
        }

        public Criteria andChecktypeIsNotNull() {
            addCriterion("CheckType is not null");
            return (Criteria) this;
        }

        public Criteria andChecktypeEqualTo(Integer value) {
            addCriterion("CheckType =", value, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeNotEqualTo(Integer value) {
            addCriterion("CheckType <>", value, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeGreaterThan(Integer value) {
            addCriterion("CheckType >", value, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("CheckType >=", value, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeLessThan(Integer value) {
            addCriterion("CheckType <", value, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeLessThanOrEqualTo(Integer value) {
            addCriterion("CheckType <=", value, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeIn(List<Integer> values) {
            addCriterion("CheckType in", values, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeNotIn(List<Integer> values) {
            addCriterion("CheckType not in", values, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeBetween(Integer value1, Integer value2) {
            addCriterion("CheckType between", value1, value2, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeNotBetween(Integer value1, Integer value2) {
            addCriterion("CheckType not between", value1, value2, "checktype");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNull() {
            addCriterion("TableName is null");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNotNull() {
            addCriterion("TableName is not null");
            return (Criteria) this;
        }

        public Criteria andTablenameEqualTo(String value) {
            addCriterion("TableName =", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotEqualTo(String value) {
            addCriterion("TableName <>", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThan(String value) {
            addCriterion("TableName >", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThanOrEqualTo(String value) {
            addCriterion("TableName >=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThan(String value) {
            addCriterion("TableName <", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThanOrEqualTo(String value) {
            addCriterion("TableName <=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLike(String value) {
            addCriterion("TableName like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotLike(String value) {
            addCriterion("TableName not like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameIn(List<String> values) {
            addCriterion("TableName in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotIn(List<String> values) {
            addCriterion("TableName not in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameBetween(String value1, String value2) {
            addCriterion("TableName between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotBetween(String value1, String value2) {
            addCriterion("TableName not between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andFieldnameIsNull() {
            addCriterion("FieldName is null");
            return (Criteria) this;
        }

        public Criteria andFieldnameIsNotNull() {
            addCriterion("FieldName is not null");
            return (Criteria) this;
        }

        public Criteria andFieldnameEqualTo(String value) {
            addCriterion("FieldName =", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameNotEqualTo(String value) {
            addCriterion("FieldName <>", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameGreaterThan(String value) {
            addCriterion("FieldName >", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameGreaterThanOrEqualTo(String value) {
            addCriterion("FieldName >=", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameLessThan(String value) {
            addCriterion("FieldName <", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameLessThanOrEqualTo(String value) {
            addCriterion("FieldName <=", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameLike(String value) {
            addCriterion("FieldName like", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameNotLike(String value) {
            addCriterion("FieldName not like", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameIn(List<String> values) {
            addCriterion("FieldName in", values, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameNotIn(List<String> values) {
            addCriterion("FieldName not in", values, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameBetween(String value1, String value2) {
            addCriterion("FieldName between", value1, value2, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameNotBetween(String value1, String value2) {
            addCriterion("FieldName not between", value1, value2, "fieldname");
            return (Criteria) this;
        }

        public Criteria andJudgeFormulaIsNull() {
            addCriterion("Judge_formula is null");
            return (Criteria) this;
        }

        public Criteria andJudgeFormulaIsNotNull() {
            addCriterion("Judge_formula is not null");
            return (Criteria) this;
        }

        public Criteria andJudgeFormulaEqualTo(String value) {
            addCriterion("Judge_formula =", value, "judgeFormula");
            return (Criteria) this;
        }

        public Criteria andJudgeFormulaNotEqualTo(String value) {
            addCriterion("Judge_formula <>", value, "judgeFormula");
            return (Criteria) this;
        }

        public Criteria andJudgeFormulaGreaterThan(String value) {
            addCriterion("Judge_formula >", value, "judgeFormula");
            return (Criteria) this;
        }

        public Criteria andJudgeFormulaGreaterThanOrEqualTo(String value) {
            addCriterion("Judge_formula >=", value, "judgeFormula");
            return (Criteria) this;
        }

        public Criteria andJudgeFormulaLessThan(String value) {
            addCriterion("Judge_formula <", value, "judgeFormula");
            return (Criteria) this;
        }

        public Criteria andJudgeFormulaLessThanOrEqualTo(String value) {
            addCriterion("Judge_formula <=", value, "judgeFormula");
            return (Criteria) this;
        }

        public Criteria andJudgeFormulaLike(String value) {
            addCriterion("Judge_formula like", value, "judgeFormula");
            return (Criteria) this;
        }

        public Criteria andJudgeFormulaNotLike(String value) {
            addCriterion("Judge_formula not like", value, "judgeFormula");
            return (Criteria) this;
        }

        public Criteria andJudgeFormulaIn(List<String> values) {
            addCriterion("Judge_formula in", values, "judgeFormula");
            return (Criteria) this;
        }

        public Criteria andJudgeFormulaNotIn(List<String> values) {
            addCriterion("Judge_formula not in", values, "judgeFormula");
            return (Criteria) this;
        }

        public Criteria andJudgeFormulaBetween(String value1, String value2) {
            addCriterion("Judge_formula between", value1, value2, "judgeFormula");
            return (Criteria) this;
        }

        public Criteria andJudgeFormulaNotBetween(String value1, String value2) {
            addCriterion("Judge_formula not between", value1, value2, "judgeFormula");
            return (Criteria) this;
        }

        public Criteria andResultFormulaIsNull() {
            addCriterion("Result_formula is null");
            return (Criteria) this;
        }

        public Criteria andResultFormulaIsNotNull() {
            addCriterion("Result_formula is not null");
            return (Criteria) this;
        }

        public Criteria andResultFormulaEqualTo(String value) {
            addCriterion("Result_formula =", value, "resultFormula");
            return (Criteria) this;
        }

        public Criteria andResultFormulaNotEqualTo(String value) {
            addCriterion("Result_formula <>", value, "resultFormula");
            return (Criteria) this;
        }

        public Criteria andResultFormulaGreaterThan(String value) {
            addCriterion("Result_formula >", value, "resultFormula");
            return (Criteria) this;
        }

        public Criteria andResultFormulaGreaterThanOrEqualTo(String value) {
            addCriterion("Result_formula >=", value, "resultFormula");
            return (Criteria) this;
        }

        public Criteria andResultFormulaLessThan(String value) {
            addCriterion("Result_formula <", value, "resultFormula");
            return (Criteria) this;
        }

        public Criteria andResultFormulaLessThanOrEqualTo(String value) {
            addCriterion("Result_formula <=", value, "resultFormula");
            return (Criteria) this;
        }

        public Criteria andResultFormulaLike(String value) {
            addCriterion("Result_formula like", value, "resultFormula");
            return (Criteria) this;
        }

        public Criteria andResultFormulaNotLike(String value) {
            addCriterion("Result_formula not like", value, "resultFormula");
            return (Criteria) this;
        }

        public Criteria andResultFormulaIn(List<String> values) {
            addCriterion("Result_formula in", values, "resultFormula");
            return (Criteria) this;
        }

        public Criteria andResultFormulaNotIn(List<String> values) {
            addCriterion("Result_formula not in", values, "resultFormula");
            return (Criteria) this;
        }

        public Criteria andResultFormulaBetween(String value1, String value2) {
            addCriterion("Result_formula between", value1, value2, "resultFormula");
            return (Criteria) this;
        }

        public Criteria andResultFormulaNotBetween(String value1, String value2) {
            addCriterion("Result_formula not between", value1, value2, "resultFormula");
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