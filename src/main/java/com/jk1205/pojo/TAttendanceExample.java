package com.jk1205.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TAttendanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAttendanceExample() {
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

        public Criteria andKidIsNull() {
            addCriterion("kid is null");
            return (Criteria) this;
        }

        public Criteria andKidIsNotNull() {
            addCriterion("kid is not null");
            return (Criteria) this;
        }

        public Criteria andKidEqualTo(Integer value) {
            addCriterion("kid =", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidNotEqualTo(Integer value) {
            addCriterion("kid <>", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidGreaterThan(Integer value) {
            addCriterion("kid >", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidGreaterThanOrEqualTo(Integer value) {
            addCriterion("kid >=", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidLessThan(Integer value) {
            addCriterion("kid <", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidLessThanOrEqualTo(Integer value) {
            addCriterion("kid <=", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidIn(List<Integer> values) {
            addCriterion("kid in", values, "kid");
            return (Criteria) this;
        }

        public Criteria andKidNotIn(List<Integer> values) {
            addCriterion("kid not in", values, "kid");
            return (Criteria) this;
        }

        public Criteria andKidBetween(Integer value1, Integer value2) {
            addCriterion("kid between", value1, value2, "kid");
            return (Criteria) this;
        }

        public Criteria andKidNotBetween(Integer value1, Integer value2) {
            addCriterion("kid not between", value1, value2, "kid");
            return (Criteria) this;
        }

        public Criteria andAttendanceDayIsNull() {
            addCriterion("attendance_day is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceDayIsNotNull() {
            addCriterion("attendance_day is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceDayEqualTo(String value) {
            addCriterion("attendance_day =", value, "attendanceDay");
            return (Criteria) this;
        }

        public Criteria andAttendanceDayNotEqualTo(String value) {
            addCriterion("attendance_day <>", value, "attendanceDay");
            return (Criteria) this;
        }

        public Criteria andAttendanceDayGreaterThan(String value) {
            addCriterion("attendance_day >", value, "attendanceDay");
            return (Criteria) this;
        }

        public Criteria andAttendanceDayGreaterThanOrEqualTo(String value) {
            addCriterion("attendance_day >=", value, "attendanceDay");
            return (Criteria) this;
        }

        public Criteria andAttendanceDayLessThan(String value) {
            addCriterion("attendance_day <", value, "attendanceDay");
            return (Criteria) this;
        }

        public Criteria andAttendanceDayLessThanOrEqualTo(String value) {
            addCriterion("attendance_day <=", value, "attendanceDay");
            return (Criteria) this;
        }

        public Criteria andAttendanceDayLike(String value) {
            addCriterion("attendance_day like", value, "attendanceDay");
            return (Criteria) this;
        }

        public Criteria andAttendanceDayNotLike(String value) {
            addCriterion("attendance_day not like", value, "attendanceDay");
            return (Criteria) this;
        }

        public Criteria andAttendanceDayIn(List<String> values) {
            addCriterion("attendance_day in", values, "attendanceDay");
            return (Criteria) this;
        }

        public Criteria andAttendanceDayNotIn(List<String> values) {
            addCriterion("attendance_day not in", values, "attendanceDay");
            return (Criteria) this;
        }

        public Criteria andAttendanceDayBetween(String value1, String value2) {
            addCriterion("attendance_day between", value1, value2, "attendanceDay");
            return (Criteria) this;
        }

        public Criteria andAttendanceDayNotBetween(String value1, String value2) {
            addCriterion("attendance_day not between", value1, value2, "attendanceDay");
            return (Criteria) this;
        }

        public Criteria andAttendanceEveryIsNull() {
            addCriterion("attendance_every is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceEveryIsNotNull() {
            addCriterion("attendance_every is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceEveryEqualTo(String value) {
            addCriterion("attendance_every =", value, "attendanceEvery");
            return (Criteria) this;
        }

        public Criteria andAttendanceEveryNotEqualTo(String value) {
            addCriterion("attendance_every <>", value, "attendanceEvery");
            return (Criteria) this;
        }

        public Criteria andAttendanceEveryGreaterThan(String value) {
            addCriterion("attendance_every >", value, "attendanceEvery");
            return (Criteria) this;
        }

        public Criteria andAttendanceEveryGreaterThanOrEqualTo(String value) {
            addCriterion("attendance_every >=", value, "attendanceEvery");
            return (Criteria) this;
        }

        public Criteria andAttendanceEveryLessThan(String value) {
            addCriterion("attendance_every <", value, "attendanceEvery");
            return (Criteria) this;
        }

        public Criteria andAttendanceEveryLessThanOrEqualTo(String value) {
            addCriterion("attendance_every <=", value, "attendanceEvery");
            return (Criteria) this;
        }

        public Criteria andAttendanceEveryLike(String value) {
            addCriterion("attendance_every like", value, "attendanceEvery");
            return (Criteria) this;
        }

        public Criteria andAttendanceEveryNotLike(String value) {
            addCriterion("attendance_every not like", value, "attendanceEvery");
            return (Criteria) this;
        }

        public Criteria andAttendanceEveryIn(List<String> values) {
            addCriterion("attendance_every in", values, "attendanceEvery");
            return (Criteria) this;
        }

        public Criteria andAttendanceEveryNotIn(List<String> values) {
            addCriterion("attendance_every not in", values, "attendanceEvery");
            return (Criteria) this;
        }

        public Criteria andAttendanceEveryBetween(String value1, String value2) {
            addCriterion("attendance_every between", value1, value2, "attendanceEvery");
            return (Criteria) this;
        }

        public Criteria andAttendanceEveryNotBetween(String value1, String value2) {
            addCriterion("attendance_every not between", value1, value2, "attendanceEvery");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeIsNull() {
            addCriterion("attendance_time is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeIsNotNull() {
            addCriterion("attendance_time is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeEqualTo(Date value) {
            addCriterion("attendance_time =", value, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeNotEqualTo(Date value) {
            addCriterion("attendance_time <>", value, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeGreaterThan(Date value) {
            addCriterion("attendance_time >", value, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("attendance_time >=", value, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeLessThan(Date value) {
            addCriterion("attendance_time <", value, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeLessThanOrEqualTo(Date value) {
            addCriterion("attendance_time <=", value, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeIn(List<Date> values) {
            addCriterion("attendance_time in", values, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeNotIn(List<Date> values) {
            addCriterion("attendance_time not in", values, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeBetween(Date value1, Date value2) {
            addCriterion("attendance_time between", value1, value2, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeNotBetween(Date value1, Date value2) {
            addCriterion("attendance_time not between", value1, value2, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andExceptionExplainIsNull() {
            addCriterion("exception_explain is null");
            return (Criteria) this;
        }

        public Criteria andExceptionExplainIsNotNull() {
            addCriterion("exception_explain is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionExplainEqualTo(String value) {
            addCriterion("exception_explain =", value, "exceptionExplain");
            return (Criteria) this;
        }

        public Criteria andExceptionExplainNotEqualTo(String value) {
            addCriterion("exception_explain <>", value, "exceptionExplain");
            return (Criteria) this;
        }

        public Criteria andExceptionExplainGreaterThan(String value) {
            addCriterion("exception_explain >", value, "exceptionExplain");
            return (Criteria) this;
        }

        public Criteria andExceptionExplainGreaterThanOrEqualTo(String value) {
            addCriterion("exception_explain >=", value, "exceptionExplain");
            return (Criteria) this;
        }

        public Criteria andExceptionExplainLessThan(String value) {
            addCriterion("exception_explain <", value, "exceptionExplain");
            return (Criteria) this;
        }

        public Criteria andExceptionExplainLessThanOrEqualTo(String value) {
            addCriterion("exception_explain <=", value, "exceptionExplain");
            return (Criteria) this;
        }

        public Criteria andExceptionExplainLike(String value) {
            addCriterion("exception_explain like", value, "exceptionExplain");
            return (Criteria) this;
        }

        public Criteria andExceptionExplainNotLike(String value) {
            addCriterion("exception_explain not like", value, "exceptionExplain");
            return (Criteria) this;
        }

        public Criteria andExceptionExplainIn(List<String> values) {
            addCriterion("exception_explain in", values, "exceptionExplain");
            return (Criteria) this;
        }

        public Criteria andExceptionExplainNotIn(List<String> values) {
            addCriterion("exception_explain not in", values, "exceptionExplain");
            return (Criteria) this;
        }

        public Criteria andExceptionExplainBetween(String value1, String value2) {
            addCriterion("exception_explain between", value1, value2, "exceptionExplain");
            return (Criteria) this;
        }

        public Criteria andExceptionExplainNotBetween(String value1, String value2) {
            addCriterion("exception_explain not between", value1, value2, "exceptionExplain");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionIsNull() {
            addCriterion("approval_opinion is null");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionIsNotNull() {
            addCriterion("approval_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionEqualTo(String value) {
            addCriterion("approval_opinion =", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionNotEqualTo(String value) {
            addCriterion("approval_opinion <>", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionGreaterThan(String value) {
            addCriterion("approval_opinion >", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("approval_opinion >=", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionLessThan(String value) {
            addCriterion("approval_opinion <", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionLessThanOrEqualTo(String value) {
            addCriterion("approval_opinion <=", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionLike(String value) {
            addCriterion("approval_opinion like", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionNotLike(String value) {
            addCriterion("approval_opinion not like", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionIn(List<String> values) {
            addCriterion("approval_opinion in", values, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionNotIn(List<String> values) {
            addCriterion("approval_opinion not in", values, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionBetween(String value1, String value2) {
            addCriterion("approval_opinion between", value1, value2, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionNotBetween(String value1, String value2) {
            addCriterion("approval_opinion not between", value1, value2, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andOpinionTimeIsNull() {
            addCriterion("opinion_time is null");
            return (Criteria) this;
        }

        public Criteria andOpinionTimeIsNotNull() {
            addCriterion("opinion_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpinionTimeEqualTo(Date value) {
            addCriterion("opinion_time =", value, "opinionTime");
            return (Criteria) this;
        }

        public Criteria andOpinionTimeNotEqualTo(Date value) {
            addCriterion("opinion_time <>", value, "opinionTime");
            return (Criteria) this;
        }

        public Criteria andOpinionTimeGreaterThan(Date value) {
            addCriterion("opinion_time >", value, "opinionTime");
            return (Criteria) this;
        }

        public Criteria andOpinionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("opinion_time >=", value, "opinionTime");
            return (Criteria) this;
        }

        public Criteria andOpinionTimeLessThan(Date value) {
            addCriterion("opinion_time <", value, "opinionTime");
            return (Criteria) this;
        }

        public Criteria andOpinionTimeLessThanOrEqualTo(Date value) {
            addCriterion("opinion_time <=", value, "opinionTime");
            return (Criteria) this;
        }

        public Criteria andOpinionTimeIn(List<Date> values) {
            addCriterion("opinion_time in", values, "opinionTime");
            return (Criteria) this;
        }

        public Criteria andOpinionTimeNotIn(List<Date> values) {
            addCriterion("opinion_time not in", values, "opinionTime");
            return (Criteria) this;
        }

        public Criteria andOpinionTimeBetween(Date value1, Date value2) {
            addCriterion("opinion_time between", value1, value2, "opinionTime");
            return (Criteria) this;
        }

        public Criteria andOpinionTimeNotBetween(Date value1, Date value2) {
            addCriterion("opinion_time not between", value1, value2, "opinionTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeIsNull() {
            addCriterion("attendance_type is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeIsNotNull() {
            addCriterion("attendance_type is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeEqualTo(Integer value) {
            addCriterion("attendance_type =", value, "attendanceType");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeNotEqualTo(Integer value) {
            addCriterion("attendance_type <>", value, "attendanceType");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeGreaterThan(Integer value) {
            addCriterion("attendance_type >", value, "attendanceType");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("attendance_type >=", value, "attendanceType");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeLessThan(Integer value) {
            addCriterion("attendance_type <", value, "attendanceType");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("attendance_type <=", value, "attendanceType");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeIn(List<Integer> values) {
            addCriterion("attendance_type in", values, "attendanceType");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeNotIn(List<Integer> values) {
            addCriterion("attendance_type not in", values, "attendanceType");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeBetween(Integer value1, Integer value2) {
            addCriterion("attendance_type between", value1, value2, "attendanceType");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("attendance_type not between", value1, value2, "attendanceType");
            return (Criteria) this;
        }

        public Criteria andEmpidIsNull() {
            addCriterion("empid is null");
            return (Criteria) this;
        }

        public Criteria andEmpidIsNotNull() {
            addCriterion("empid is not null");
            return (Criteria) this;
        }

        public Criteria andEmpidEqualTo(Integer value) {
            addCriterion("empid =", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotEqualTo(Integer value) {
            addCriterion("empid <>", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThan(Integer value) {
            addCriterion("empid >", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("empid >=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThan(Integer value) {
            addCriterion("empid <", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThanOrEqualTo(Integer value) {
            addCriterion("empid <=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidIn(List<Integer> values) {
            addCriterion("empid in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotIn(List<Integer> values) {
            addCriterion("empid not in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidBetween(Integer value1, Integer value2) {
            addCriterion("empid between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotBetween(Integer value1, Integer value2) {
            addCriterion("empid not between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andBossidIsNull() {
            addCriterion("bossid is null");
            return (Criteria) this;
        }

        public Criteria andBossidIsNotNull() {
            addCriterion("bossid is not null");
            return (Criteria) this;
        }

        public Criteria andBossidEqualTo(Integer value) {
            addCriterion("bossid =", value, "bossid");
            return (Criteria) this;
        }

        public Criteria andBossidNotEqualTo(Integer value) {
            addCriterion("bossid <>", value, "bossid");
            return (Criteria) this;
        }

        public Criteria andBossidGreaterThan(Integer value) {
            addCriterion("bossid >", value, "bossid");
            return (Criteria) this;
        }

        public Criteria andBossidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bossid >=", value, "bossid");
            return (Criteria) this;
        }

        public Criteria andBossidLessThan(Integer value) {
            addCriterion("bossid <", value, "bossid");
            return (Criteria) this;
        }

        public Criteria andBossidLessThanOrEqualTo(Integer value) {
            addCriterion("bossid <=", value, "bossid");
            return (Criteria) this;
        }

        public Criteria andBossidIn(List<Integer> values) {
            addCriterion("bossid in", values, "bossid");
            return (Criteria) this;
        }

        public Criteria andBossidNotIn(List<Integer> values) {
            addCriterion("bossid not in", values, "bossid");
            return (Criteria) this;
        }

        public Criteria andBossidBetween(Integer value1, Integer value2) {
            addCriterion("bossid between", value1, value2, "bossid");
            return (Criteria) this;
        }

        public Criteria andBossidNotBetween(Integer value1, Integer value2) {
            addCriterion("bossid not between", value1, value2, "bossid");
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