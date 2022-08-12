package com.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class YuyueQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public YuyueQuery() {
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

    public void setPageNo(Integer pageNo) {
        this.pageNo=pageNo;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setStartRow(Integer startRow) {
        this.startRow=startRow;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize=pageSize;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setFields(String fields) {
        this.fields=fields;
    }

    public String getFields() {
        return fields;
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

        public Criteria andYidIsNull() {
            addCriterion("yid is null");
            return (Criteria) this;
        }

        public Criteria andYidIsNotNull() {
            addCriterion("yid is not null");
            return (Criteria) this;
        }

        public Criteria andYidEqualTo(Integer value) {
            addCriterion("yid =", value, "yid");
            return (Criteria) this;
        }

        public Criteria andYidNotEqualTo(Integer value) {
            addCriterion("yid <>", value, "yid");
            return (Criteria) this;
        }

        public Criteria andYidGreaterThan(Integer value) {
            addCriterion("yid >", value, "yid");
            return (Criteria) this;
        }

        public Criteria andYidGreaterThanOrEqualTo(Integer value) {
            addCriterion("yid >=", value, "yid");
            return (Criteria) this;
        }

        public Criteria andYidLessThan(Integer value) {
            addCriterion("yid <", value, "yid");
            return (Criteria) this;
        }

        public Criteria andYidLessThanOrEqualTo(Integer value) {
            addCriterion("yid <=", value, "yid");
            return (Criteria) this;
        }

        public Criteria andYidIn(List<Integer> values) {
            addCriterion("yid in", values, "yid");
            return (Criteria) this;
        }

        public Criteria andYidNotIn(List<Integer> values) {
            addCriterion("yid not in", values, "yid");
            return (Criteria) this;
        }

        public Criteria andYidBetween(Integer value1, Integer value2) {
            addCriterion("yid between", value1, value2, "yid");
            return (Criteria) this;
        }

        public Criteria andYidNotBetween(Integer value1, Integer value2) {
            addCriterion("yid not between", value1, value2, "yid");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andFidIsNull() {
            addCriterion("fid is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("fid is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Integer value) {
            addCriterion("fid =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Integer value) {
            addCriterion("fid <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Integer value) {
            addCriterion("fid >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fid >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Integer value) {
            addCriterion("fid <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Integer value) {
            addCriterion("fid <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Integer> values) {
            addCriterion("fid in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Integer> values) {
            addCriterion("fid not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(Integer value1, Integer value2) {
            addCriterion("fid between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Integer value1, Integer value2) {
            addCriterion("fid not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andYmessageIsNull() {
            addCriterion("ymessage is null");
            return (Criteria) this;
        }

        public Criteria andYmessageIsNotNull() {
            addCriterion("ymessage is not null");
            return (Criteria) this;
        }

        public Criteria andYmessageEqualTo(String value) {
            addCriterion("ymessage =", value, "ymessage");
            return (Criteria) this;
        }

        public Criteria andYmessageNotEqualTo(String value) {
            addCriterion("ymessage <>", value, "ymessage");
            return (Criteria) this;
        }

        public Criteria andYmessageGreaterThan(String value) {
            addCriterion("ymessage >", value, "ymessage");
            return (Criteria) this;
        }

        public Criteria andYmessageGreaterThanOrEqualTo(String value) {
            addCriterion("ymessage >=", value, "ymessage");
            return (Criteria) this;
        }

        public Criteria andYmessageLessThan(String value) {
            addCriterion("ymessage <", value, "ymessage");
            return (Criteria) this;
        }

        public Criteria andYmessageLessThanOrEqualTo(String value) {
            addCriterion("ymessage <=", value, "ymessage");
            return (Criteria) this;
        }

        public Criteria andYmessageLike(String value) {
            addCriterion("ymessage like", value, "ymessage");
            return (Criteria) this;
        }

        public Criteria andYmessageNotLike(String value) {
            addCriterion("ymessage not like", value, "ymessage");
            return (Criteria) this;
        }

        public Criteria andYmessageIn(List<String> values) {
            addCriterion("ymessage in", values, "ymessage");
            return (Criteria) this;
        }

        public Criteria andYmessageNotIn(List<String> values) {
            addCriterion("ymessage not in", values, "ymessage");
            return (Criteria) this;
        }

        public Criteria andYmessageBetween(String value1, String value2) {
            addCriterion("ymessage between", value1, value2, "ymessage");
            return (Criteria) this;
        }

        public Criteria andYmessageNotBetween(String value1, String value2) {
            addCriterion("ymessage not between", value1, value2, "ymessage");
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

        public Criteria andReceiveIsNull() {
            addCriterion("receive is null");
            return (Criteria) this;
        }

        public Criteria andReceiveIsNotNull() {
            addCriterion("receive is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveEqualTo(String value) {
            addCriterion("receive =", value, "receive");
            return (Criteria) this;
        }

        public Criteria andReceiveNotEqualTo(String value) {
            addCriterion("receive <>", value, "receive");
            return (Criteria) this;
        }

        public Criteria andReceiveGreaterThan(String value) {
            addCriterion("receive >", value, "receive");
            return (Criteria) this;
        }

        public Criteria andReceiveGreaterThanOrEqualTo(String value) {
            addCriterion("receive >=", value, "receive");
            return (Criteria) this;
        }

        public Criteria andReceiveLessThan(String value) {
            addCriterion("receive <", value, "receive");
            return (Criteria) this;
        }

        public Criteria andReceiveLessThanOrEqualTo(String value) {
            addCriterion("receive <=", value, "receive");
            return (Criteria) this;
        }

        public Criteria andReceiveLike(String value) {
            addCriterion("receive like", value, "receive");
            return (Criteria) this;
        }

        public Criteria andReceiveNotLike(String value) {
            addCriterion("receive not like", value, "receive");
            return (Criteria) this;
        }

        public Criteria andReceiveIn(List<String> values) {
            addCriterion("receive in", values, "receive");
            return (Criteria) this;
        }

        public Criteria andReceiveNotIn(List<String> values) {
            addCriterion("receive not in", values, "receive");
            return (Criteria) this;
        }

        public Criteria andReceiveBetween(String value1, String value2) {
            addCriterion("receive between", value1, value2, "receive");
            return (Criteria) this;
        }

        public Criteria andReceiveNotBetween(String value1, String value2) {
            addCriterion("receive not between", value1, value2, "receive");
            return (Criteria) this;
        }

        public Criteria andReceivetimeIsNull() {
            addCriterion("receivetime is null");
            return (Criteria) this;
        }

        public Criteria andReceivetimeIsNotNull() {
            addCriterion("receivetime is not null");
            return (Criteria) this;
        }

        public Criteria andReceivetimeEqualTo(Date value) {
            addCriterion("receivetime =", value, "receivetime");
            return (Criteria) this;
        }

        public Criteria andReceivetimeNotEqualTo(Date value) {
            addCriterion("receivetime <>", value, "receivetime");
            return (Criteria) this;
        }

        public Criteria andReceivetimeGreaterThan(Date value) {
            addCriterion("receivetime >", value, "receivetime");
            return (Criteria) this;
        }

        public Criteria andReceivetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("receivetime >=", value, "receivetime");
            return (Criteria) this;
        }

        public Criteria andReceivetimeLessThan(Date value) {
            addCriterion("receivetime <", value, "receivetime");
            return (Criteria) this;
        }

        public Criteria andReceivetimeLessThanOrEqualTo(Date value) {
            addCriterion("receivetime <=", value, "receivetime");
            return (Criteria) this;
        }

        public Criteria andReceivetimeIn(List<Date> values) {
            addCriterion("receivetime in", values, "receivetime");
            return (Criteria) this;
        }

        public Criteria andReceivetimeNotIn(List<Date> values) {
            addCriterion("receivetime not in", values, "receivetime");
            return (Criteria) this;
        }

        public Criteria andReceivetimeBetween(Date value1, Date value2) {
            addCriterion("receivetime between", value1, value2, "receivetime");
            return (Criteria) this;
        }

        public Criteria andReceivetimeNotBetween(Date value1, Date value2) {
            addCriterion("receivetime not between", value1, value2, "receivetime");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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