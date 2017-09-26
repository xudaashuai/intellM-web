package com.cug.intellM.web.po;

import java.util.ArrayList;
import java.util.List;

public class TransformRuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransformRuleExample() {
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

        public Criteria andTransRuleIsNull() {
            addCriterion("Trans_Rule is null");
            return (Criteria) this;
        }

        public Criteria andTransRuleIsNotNull() {
            addCriterion("Trans_Rule is not null");
            return (Criteria) this;
        }

        public Criteria andTransRuleEqualTo(Integer value) {
            addCriterion("Trans_Rule =", value, "transRule");
            return (Criteria) this;
        }

        public Criteria andTransRuleNotEqualTo(Integer value) {
            addCriterion("Trans_Rule <>", value, "transRule");
            return (Criteria) this;
        }

        public Criteria andTransRuleGreaterThan(Integer value) {
            addCriterion("Trans_Rule >", value, "transRule");
            return (Criteria) this;
        }

        public Criteria andTransRuleGreaterThanOrEqualTo(Integer value) {
            addCriterion("Trans_Rule >=", value, "transRule");
            return (Criteria) this;
        }

        public Criteria andTransRuleLessThan(Integer value) {
            addCriterion("Trans_Rule <", value, "transRule");
            return (Criteria) this;
        }

        public Criteria andTransRuleLessThanOrEqualTo(Integer value) {
            addCriterion("Trans_Rule <=", value, "transRule");
            return (Criteria) this;
        }

        public Criteria andTransRuleIn(List<Integer> values) {
            addCriterion("Trans_Rule in", values, "transRule");
            return (Criteria) this;
        }

        public Criteria andTransRuleNotIn(List<Integer> values) {
            addCriterion("Trans_Rule not in", values, "transRule");
            return (Criteria) this;
        }

        public Criteria andTransRuleBetween(Integer value1, Integer value2) {
            addCriterion("Trans_Rule between", value1, value2, "transRule");
            return (Criteria) this;
        }

        public Criteria andTransRuleNotBetween(Integer value1, Integer value2) {
            addCriterion("Trans_Rule not between", value1, value2, "transRule");
            return (Criteria) this;
        }

        public Criteria andTransTypeIsNull() {
            addCriterion("Trans_Type is null");
            return (Criteria) this;
        }

        public Criteria andTransTypeIsNotNull() {
            addCriterion("Trans_Type is not null");
            return (Criteria) this;
        }

        public Criteria andTransTypeEqualTo(Integer value) {
            addCriterion("Trans_Type =", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotEqualTo(Integer value) {
            addCriterion("Trans_Type <>", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeGreaterThan(Integer value) {
            addCriterion("Trans_Type >", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Trans_Type >=", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeLessThan(Integer value) {
            addCriterion("Trans_Type <", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeLessThanOrEqualTo(Integer value) {
            addCriterion("Trans_Type <=", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeIn(List<Integer> values) {
            addCriterion("Trans_Type in", values, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotIn(List<Integer> values) {
            addCriterion("Trans_Type not in", values, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeBetween(Integer value1, Integer value2) {
            addCriterion("Trans_Type between", value1, value2, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("Trans_Type not between", value1, value2, "transType");
            return (Criteria) this;
        }

        public Criteria andTablefieldIsNull() {
            addCriterion("TableField is null");
            return (Criteria) this;
        }

        public Criteria andTablefieldIsNotNull() {
            addCriterion("TableField is not null");
            return (Criteria) this;
        }

        public Criteria andTablefieldEqualTo(String value) {
            addCriterion("TableField =", value, "tablefield");
            return (Criteria) this;
        }

        public Criteria andTablefieldNotEqualTo(String value) {
            addCriterion("TableField <>", value, "tablefield");
            return (Criteria) this;
        }

        public Criteria andTablefieldGreaterThan(String value) {
            addCriterion("TableField >", value, "tablefield");
            return (Criteria) this;
        }

        public Criteria andTablefieldGreaterThanOrEqualTo(String value) {
            addCriterion("TableField >=", value, "tablefield");
            return (Criteria) this;
        }

        public Criteria andTablefieldLessThan(String value) {
            addCriterion("TableField <", value, "tablefield");
            return (Criteria) this;
        }

        public Criteria andTablefieldLessThanOrEqualTo(String value) {
            addCriterion("TableField <=", value, "tablefield");
            return (Criteria) this;
        }

        public Criteria andTablefieldLike(String value) {
            addCriterion("TableField like", value, "tablefield");
            return (Criteria) this;
        }

        public Criteria andTablefieldNotLike(String value) {
            addCriterion("TableField not like", value, "tablefield");
            return (Criteria) this;
        }

        public Criteria andTablefieldIn(List<String> values) {
            addCriterion("TableField in", values, "tablefield");
            return (Criteria) this;
        }

        public Criteria andTablefieldNotIn(List<String> values) {
            addCriterion("TableField not in", values, "tablefield");
            return (Criteria) this;
        }

        public Criteria andTablefieldBetween(String value1, String value2) {
            addCriterion("TableField between", value1, value2, "tablefield");
            return (Criteria) this;
        }

        public Criteria andTablefieldNotBetween(String value1, String value2) {
            addCriterion("TableField not between", value1, value2, "tablefield");
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