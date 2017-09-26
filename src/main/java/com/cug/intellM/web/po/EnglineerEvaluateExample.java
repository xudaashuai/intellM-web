package com.cug.intellM.web.po;

import java.util.ArrayList;
import java.util.List;

public class EnglineerEvaluateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnglineerEvaluateExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAvgEvaluationIsNull() {
            addCriterion("AVG_EVALUATION is null");
            return (Criteria) this;
        }

        public Criteria andAvgEvaluationIsNotNull() {
            addCriterion("AVG_EVALUATION is not null");
            return (Criteria) this;
        }

        public Criteria andAvgEvaluationEqualTo(Double value) {
            addCriterion("AVG_EVALUATION =", value, "avgEvaluation");
            return (Criteria) this;
        }

        public Criteria andAvgEvaluationNotEqualTo(Double value) {
            addCriterion("AVG_EVALUATION <>", value, "avgEvaluation");
            return (Criteria) this;
        }

        public Criteria andAvgEvaluationGreaterThan(Double value) {
            addCriterion("AVG_EVALUATION >", value, "avgEvaluation");
            return (Criteria) this;
        }

        public Criteria andAvgEvaluationGreaterThanOrEqualTo(Double value) {
            addCriterion("AVG_EVALUATION >=", value, "avgEvaluation");
            return (Criteria) this;
        }

        public Criteria andAvgEvaluationLessThan(Double value) {
            addCriterion("AVG_EVALUATION <", value, "avgEvaluation");
            return (Criteria) this;
        }

        public Criteria andAvgEvaluationLessThanOrEqualTo(Double value) {
            addCriterion("AVG_EVALUATION <=", value, "avgEvaluation");
            return (Criteria) this;
        }

        public Criteria andAvgEvaluationIn(List<Double> values) {
            addCriterion("AVG_EVALUATION in", values, "avgEvaluation");
            return (Criteria) this;
        }

        public Criteria andAvgEvaluationNotIn(List<Double> values) {
            addCriterion("AVG_EVALUATION not in", values, "avgEvaluation");
            return (Criteria) this;
        }

        public Criteria andAvgEvaluationBetween(Double value1, Double value2) {
            addCriterion("AVG_EVALUATION between", value1, value2, "avgEvaluation");
            return (Criteria) this;
        }

        public Criteria andAvgEvaluationNotBetween(Double value1, Double value2) {
            addCriterion("AVG_EVALUATION not between", value1, value2, "avgEvaluation");
            return (Criteria) this;
        }

        public Criteria andAvgArrivalTimeIsNull() {
            addCriterion("AVG_ARRIVAL_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAvgArrivalTimeIsNotNull() {
            addCriterion("AVG_ARRIVAL_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAvgArrivalTimeEqualTo(String value) {
            addCriterion("AVG_ARRIVAL_TIME =", value, "avgArrivalTime");
            return (Criteria) this;
        }

        public Criteria andAvgArrivalTimeNotEqualTo(String value) {
            addCriterion("AVG_ARRIVAL_TIME <>", value, "avgArrivalTime");
            return (Criteria) this;
        }

        public Criteria andAvgArrivalTimeGreaterThan(String value) {
            addCriterion("AVG_ARRIVAL_TIME >", value, "avgArrivalTime");
            return (Criteria) this;
        }

        public Criteria andAvgArrivalTimeGreaterThanOrEqualTo(String value) {
            addCriterion("AVG_ARRIVAL_TIME >=", value, "avgArrivalTime");
            return (Criteria) this;
        }

        public Criteria andAvgArrivalTimeLessThan(String value) {
            addCriterion("AVG_ARRIVAL_TIME <", value, "avgArrivalTime");
            return (Criteria) this;
        }

        public Criteria andAvgArrivalTimeLessThanOrEqualTo(String value) {
            addCriterion("AVG_ARRIVAL_TIME <=", value, "avgArrivalTime");
            return (Criteria) this;
        }

        public Criteria andAvgArrivalTimeLike(String value) {
            addCriterion("AVG_ARRIVAL_TIME like", value, "avgArrivalTime");
            return (Criteria) this;
        }

        public Criteria andAvgArrivalTimeNotLike(String value) {
            addCriterion("AVG_ARRIVAL_TIME not like", value, "avgArrivalTime");
            return (Criteria) this;
        }

        public Criteria andAvgArrivalTimeIn(List<String> values) {
            addCriterion("AVG_ARRIVAL_TIME in", values, "avgArrivalTime");
            return (Criteria) this;
        }

        public Criteria andAvgArrivalTimeNotIn(List<String> values) {
            addCriterion("AVG_ARRIVAL_TIME not in", values, "avgArrivalTime");
            return (Criteria) this;
        }

        public Criteria andAvgArrivalTimeBetween(String value1, String value2) {
            addCriterion("AVG_ARRIVAL_TIME between", value1, value2, "avgArrivalTime");
            return (Criteria) this;
        }

        public Criteria andAvgArrivalTimeNotBetween(String value1, String value2) {
            addCriterion("AVG_ARRIVAL_TIME not between", value1, value2, "avgArrivalTime");
            return (Criteria) this;
        }

        public Criteria andAvgRepairTimeIsNull() {
            addCriterion("AVG_REPAIR_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAvgRepairTimeIsNotNull() {
            addCriterion("AVG_REPAIR_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAvgRepairTimeEqualTo(String value) {
            addCriterion("AVG_REPAIR_TIME =", value, "avgRepairTime");
            return (Criteria) this;
        }

        public Criteria andAvgRepairTimeNotEqualTo(String value) {
            addCriterion("AVG_REPAIR_TIME <>", value, "avgRepairTime");
            return (Criteria) this;
        }

        public Criteria andAvgRepairTimeGreaterThan(String value) {
            addCriterion("AVG_REPAIR_TIME >", value, "avgRepairTime");
            return (Criteria) this;
        }

        public Criteria andAvgRepairTimeGreaterThanOrEqualTo(String value) {
            addCriterion("AVG_REPAIR_TIME >=", value, "avgRepairTime");
            return (Criteria) this;
        }

        public Criteria andAvgRepairTimeLessThan(String value) {
            addCriterion("AVG_REPAIR_TIME <", value, "avgRepairTime");
            return (Criteria) this;
        }

        public Criteria andAvgRepairTimeLessThanOrEqualTo(String value) {
            addCriterion("AVG_REPAIR_TIME <=", value, "avgRepairTime");
            return (Criteria) this;
        }

        public Criteria andAvgRepairTimeLike(String value) {
            addCriterion("AVG_REPAIR_TIME like", value, "avgRepairTime");
            return (Criteria) this;
        }

        public Criteria andAvgRepairTimeNotLike(String value) {
            addCriterion("AVG_REPAIR_TIME not like", value, "avgRepairTime");
            return (Criteria) this;
        }

        public Criteria andAvgRepairTimeIn(List<String> values) {
            addCriterion("AVG_REPAIR_TIME in", values, "avgRepairTime");
            return (Criteria) this;
        }

        public Criteria andAvgRepairTimeNotIn(List<String> values) {
            addCriterion("AVG_REPAIR_TIME not in", values, "avgRepairTime");
            return (Criteria) this;
        }

        public Criteria andAvgRepairTimeBetween(String value1, String value2) {
            addCriterion("AVG_REPAIR_TIME between", value1, value2, "avgRepairTime");
            return (Criteria) this;
        }

        public Criteria andAvgRepairTimeNotBetween(String value1, String value2) {
            addCriterion("AVG_REPAIR_TIME not between", value1, value2, "avgRepairTime");
            return (Criteria) this;
        }

        public Criteria andTroubletypecodeIsNull() {
            addCriterion("TROUBLETYPECODE is null");
            return (Criteria) this;
        }

        public Criteria andTroubletypecodeIsNotNull() {
            addCriterion("TROUBLETYPECODE is not null");
            return (Criteria) this;
        }

        public Criteria andTroubletypecodeEqualTo(String value) {
            addCriterion("TROUBLETYPECODE =", value, "troubletypecode");
            return (Criteria) this;
        }

        public Criteria andTroubletypecodeNotEqualTo(String value) {
            addCriterion("TROUBLETYPECODE <>", value, "troubletypecode");
            return (Criteria) this;
        }

        public Criteria andTroubletypecodeGreaterThan(String value) {
            addCriterion("TROUBLETYPECODE >", value, "troubletypecode");
            return (Criteria) this;
        }

        public Criteria andTroubletypecodeGreaterThanOrEqualTo(String value) {
            addCriterion("TROUBLETYPECODE >=", value, "troubletypecode");
            return (Criteria) this;
        }

        public Criteria andTroubletypecodeLessThan(String value) {
            addCriterion("TROUBLETYPECODE <", value, "troubletypecode");
            return (Criteria) this;
        }

        public Criteria andTroubletypecodeLessThanOrEqualTo(String value) {
            addCriterion("TROUBLETYPECODE <=", value, "troubletypecode");
            return (Criteria) this;
        }

        public Criteria andTroubletypecodeLike(String value) {
            addCriterion("TROUBLETYPECODE like", value, "troubletypecode");
            return (Criteria) this;
        }

        public Criteria andTroubletypecodeNotLike(String value) {
            addCriterion("TROUBLETYPECODE not like", value, "troubletypecode");
            return (Criteria) this;
        }

        public Criteria andTroubletypecodeIn(List<String> values) {
            addCriterion("TROUBLETYPECODE in", values, "troubletypecode");
            return (Criteria) this;
        }

        public Criteria andTroubletypecodeNotIn(List<String> values) {
            addCriterion("TROUBLETYPECODE not in", values, "troubletypecode");
            return (Criteria) this;
        }

        public Criteria andTroubletypecodeBetween(String value1, String value2) {
            addCriterion("TROUBLETYPECODE between", value1, value2, "troubletypecode");
            return (Criteria) this;
        }

        public Criteria andTroubletypecodeNotBetween(String value1, String value2) {
            addCriterion("TROUBLETYPECODE not between", value1, value2, "troubletypecode");
            return (Criteria) this;
        }

        public Criteria andTotalNumberIsNull() {
            addCriterion("TOTAL_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andTotalNumberIsNotNull() {
            addCriterion("TOTAL_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andTotalNumberEqualTo(Integer value) {
            addCriterion("TOTAL_NUMBER =", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberNotEqualTo(Integer value) {
            addCriterion("TOTAL_NUMBER <>", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberGreaterThan(Integer value) {
            addCriterion("TOTAL_NUMBER >", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("TOTAL_NUMBER >=", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberLessThan(Integer value) {
            addCriterion("TOTAL_NUMBER <", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberLessThanOrEqualTo(Integer value) {
            addCriterion("TOTAL_NUMBER <=", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberIn(List<Integer> values) {
            addCriterion("TOTAL_NUMBER in", values, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberNotIn(List<Integer> values) {
            addCriterion("TOTAL_NUMBER not in", values, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberBetween(Integer value1, Integer value2) {
            addCriterion("TOTAL_NUMBER between", value1, value2, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("TOTAL_NUMBER not between", value1, value2, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andServicetroublenumIsNull() {
            addCriterion("SERVICETROUBLENUM is null");
            return (Criteria) this;
        }

        public Criteria andServicetroublenumIsNotNull() {
            addCriterion("SERVICETROUBLENUM is not null");
            return (Criteria) this;
        }

        public Criteria andServicetroublenumEqualTo(Integer value) {
            addCriterion("SERVICETROUBLENUM =", value, "servicetroublenum");
            return (Criteria) this;
        }

        public Criteria andServicetroublenumNotEqualTo(Integer value) {
            addCriterion("SERVICETROUBLENUM <>", value, "servicetroublenum");
            return (Criteria) this;
        }

        public Criteria andServicetroublenumGreaterThan(Integer value) {
            addCriterion("SERVICETROUBLENUM >", value, "servicetroublenum");
            return (Criteria) this;
        }

        public Criteria andServicetroublenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERVICETROUBLENUM >=", value, "servicetroublenum");
            return (Criteria) this;
        }

        public Criteria andServicetroublenumLessThan(Integer value) {
            addCriterion("SERVICETROUBLENUM <", value, "servicetroublenum");
            return (Criteria) this;
        }

        public Criteria andServicetroublenumLessThanOrEqualTo(Integer value) {
            addCriterion("SERVICETROUBLENUM <=", value, "servicetroublenum");
            return (Criteria) this;
        }

        public Criteria andServicetroublenumIn(List<Integer> values) {
            addCriterion("SERVICETROUBLENUM in", values, "servicetroublenum");
            return (Criteria) this;
        }

        public Criteria andServicetroublenumNotIn(List<Integer> values) {
            addCriterion("SERVICETROUBLENUM not in", values, "servicetroublenum");
            return (Criteria) this;
        }

        public Criteria andServicetroublenumBetween(Integer value1, Integer value2) {
            addCriterion("SERVICETROUBLENUM between", value1, value2, "servicetroublenum");
            return (Criteria) this;
        }

        public Criteria andServicetroublenumNotBetween(Integer value1, Integer value2) {
            addCriterion("SERVICETROUBLENUM not between", value1, value2, "servicetroublenum");
            return (Criteria) this;
        }

        public Criteria andServicetypenumIsNull() {
            addCriterion("SERVICETYPENUM is null");
            return (Criteria) this;
        }

        public Criteria andServicetypenumIsNotNull() {
            addCriterion("SERVICETYPENUM is not null");
            return (Criteria) this;
        }

        public Criteria andServicetypenumEqualTo(Integer value) {
            addCriterion("SERVICETYPENUM =", value, "servicetypenum");
            return (Criteria) this;
        }

        public Criteria andServicetypenumNotEqualTo(Integer value) {
            addCriterion("SERVICETYPENUM <>", value, "servicetypenum");
            return (Criteria) this;
        }

        public Criteria andServicetypenumGreaterThan(Integer value) {
            addCriterion("SERVICETYPENUM >", value, "servicetypenum");
            return (Criteria) this;
        }

        public Criteria andServicetypenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERVICETYPENUM >=", value, "servicetypenum");
            return (Criteria) this;
        }

        public Criteria andServicetypenumLessThan(Integer value) {
            addCriterion("SERVICETYPENUM <", value, "servicetypenum");
            return (Criteria) this;
        }

        public Criteria andServicetypenumLessThanOrEqualTo(Integer value) {
            addCriterion("SERVICETYPENUM <=", value, "servicetypenum");
            return (Criteria) this;
        }

        public Criteria andServicetypenumIn(List<Integer> values) {
            addCriterion("SERVICETYPENUM in", values, "servicetypenum");
            return (Criteria) this;
        }

        public Criteria andServicetypenumNotIn(List<Integer> values) {
            addCriterion("SERVICETYPENUM not in", values, "servicetypenum");
            return (Criteria) this;
        }

        public Criteria andServicetypenumBetween(Integer value1, Integer value2) {
            addCriterion("SERVICETYPENUM between", value1, value2, "servicetypenum");
            return (Criteria) this;
        }

        public Criteria andServicetypenumNotBetween(Integer value1, Integer value2) {
            addCriterion("SERVICETYPENUM not between", value1, value2, "servicetypenum");
            return (Criteria) this;
        }

        public Criteria andUnfinishedIsNull() {
            addCriterion("UNFINISHED is null");
            return (Criteria) this;
        }

        public Criteria andUnfinishedIsNotNull() {
            addCriterion("UNFINISHED is not null");
            return (Criteria) this;
        }

        public Criteria andUnfinishedEqualTo(Integer value) {
            addCriterion("UNFINISHED =", value, "unfinished");
            return (Criteria) this;
        }

        public Criteria andUnfinishedNotEqualTo(Integer value) {
            addCriterion("UNFINISHED <>", value, "unfinished");
            return (Criteria) this;
        }

        public Criteria andUnfinishedGreaterThan(Integer value) {
            addCriterion("UNFINISHED >", value, "unfinished");
            return (Criteria) this;
        }

        public Criteria andUnfinishedGreaterThanOrEqualTo(Integer value) {
            addCriterion("UNFINISHED >=", value, "unfinished");
            return (Criteria) this;
        }

        public Criteria andUnfinishedLessThan(Integer value) {
            addCriterion("UNFINISHED <", value, "unfinished");
            return (Criteria) this;
        }

        public Criteria andUnfinishedLessThanOrEqualTo(Integer value) {
            addCriterion("UNFINISHED <=", value, "unfinished");
            return (Criteria) this;
        }

        public Criteria andUnfinishedIn(List<Integer> values) {
            addCriterion("UNFINISHED in", values, "unfinished");
            return (Criteria) this;
        }

        public Criteria andUnfinishedNotIn(List<Integer> values) {
            addCriterion("UNFINISHED not in", values, "unfinished");
            return (Criteria) this;
        }

        public Criteria andUnfinishedBetween(Integer value1, Integer value2) {
            addCriterion("UNFINISHED between", value1, value2, "unfinished");
            return (Criteria) this;
        }

        public Criteria andUnfinishedNotBetween(Integer value1, Integer value2) {
            addCriterion("UNFINISHED not between", value1, value2, "unfinished");
            return (Criteria) this;
        }

        public Criteria andActualDistanceIsNull() {
            addCriterion("ACTUAL_DISTANCE is null");
            return (Criteria) this;
        }

        public Criteria andActualDistanceIsNotNull() {
            addCriterion("ACTUAL_DISTANCE is not null");
            return (Criteria) this;
        }

        public Criteria andActualDistanceEqualTo(Double value) {
            addCriterion("ACTUAL_DISTANCE =", value, "actualDistance");
            return (Criteria) this;
        }

        public Criteria andActualDistanceNotEqualTo(Double value) {
            addCriterion("ACTUAL_DISTANCE <>", value, "actualDistance");
            return (Criteria) this;
        }

        public Criteria andActualDistanceGreaterThan(Double value) {
            addCriterion("ACTUAL_DISTANCE >", value, "actualDistance");
            return (Criteria) this;
        }

        public Criteria andActualDistanceGreaterThanOrEqualTo(Double value) {
            addCriterion("ACTUAL_DISTANCE >=", value, "actualDistance");
            return (Criteria) this;
        }

        public Criteria andActualDistanceLessThan(Double value) {
            addCriterion("ACTUAL_DISTANCE <", value, "actualDistance");
            return (Criteria) this;
        }

        public Criteria andActualDistanceLessThanOrEqualTo(Double value) {
            addCriterion("ACTUAL_DISTANCE <=", value, "actualDistance");
            return (Criteria) this;
        }

        public Criteria andActualDistanceIn(List<Double> values) {
            addCriterion("ACTUAL_DISTANCE in", values, "actualDistance");
            return (Criteria) this;
        }

        public Criteria andActualDistanceNotIn(List<Double> values) {
            addCriterion("ACTUAL_DISTANCE not in", values, "actualDistance");
            return (Criteria) this;
        }

        public Criteria andActualDistanceBetween(Double value1, Double value2) {
            addCriterion("ACTUAL_DISTANCE between", value1, value2, "actualDistance");
            return (Criteria) this;
        }

        public Criteria andActualDistanceNotBetween(Double value1, Double value2) {
            addCriterion("ACTUAL_DISTANCE not between", value1, value2, "actualDistance");
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