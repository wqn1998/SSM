package com.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FangyuanQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public FangyuanQuery() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andSalepriceIsNull() {
            addCriterion("saleprice is null");
            return (Criteria) this;
        }

        public Criteria andSalepriceIsNotNull() {
            addCriterion("saleprice is not null");
            return (Criteria) this;
        }

        public Criteria andSalepriceEqualTo(BigDecimal value) {
            addCriterion("saleprice =", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceNotEqualTo(BigDecimal value) {
            addCriterion("saleprice <>", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceGreaterThan(BigDecimal value) {
            addCriterion("saleprice >", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("saleprice >=", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceLessThan(BigDecimal value) {
            addCriterion("saleprice <", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("saleprice <=", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceIn(List<BigDecimal> values) {
            addCriterion("saleprice in", values, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceNotIn(List<BigDecimal> values) {
            addCriterion("saleprice not in", values, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("saleprice between", value1, value2, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("saleprice not between", value1, value2, "saleprice");
            return (Criteria) this;
        }

        public Criteria andRentpriceIsNull() {
            addCriterion("rentprice is null");
            return (Criteria) this;
        }

        public Criteria andRentpriceIsNotNull() {
            addCriterion("rentprice is not null");
            return (Criteria) this;
        }

        public Criteria andRentpriceEqualTo(BigDecimal value) {
            addCriterion("rentprice =", value, "rentprice");
            return (Criteria) this;
        }

        public Criteria andRentpriceNotEqualTo(BigDecimal value) {
            addCriterion("rentprice <>", value, "rentprice");
            return (Criteria) this;
        }

        public Criteria andRentpriceGreaterThan(BigDecimal value) {
            addCriterion("rentprice >", value, "rentprice");
            return (Criteria) this;
        }

        public Criteria andRentpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rentprice >=", value, "rentprice");
            return (Criteria) this;
        }

        public Criteria andRentpriceLessThan(BigDecimal value) {
            addCriterion("rentprice <", value, "rentprice");
            return (Criteria) this;
        }

        public Criteria andRentpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rentprice <=", value, "rentprice");
            return (Criteria) this;
        }

        public Criteria andRentpriceIn(List<BigDecimal> values) {
            addCriterion("rentprice in", values, "rentprice");
            return (Criteria) this;
        }

        public Criteria andRentpriceNotIn(List<BigDecimal> values) {
            addCriterion("rentprice not in", values, "rentprice");
            return (Criteria) this;
        }

        public Criteria andRentpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rentprice between", value1, value2, "rentprice");
            return (Criteria) this;
        }

        public Criteria andRentpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rentprice not between", value1, value2, "rentprice");
            return (Criteria) this;
        }

        public Criteria andHuxingIsNull() {
            addCriterion("huxing is null");
            return (Criteria) this;
        }

        public Criteria andHuxingIsNotNull() {
            addCriterion("huxing is not null");
            return (Criteria) this;
        }

        public Criteria andHuxingEqualTo(String value) {
            addCriterion("huxing =", value, "huxing");
            return (Criteria) this;
        }

        public Criteria andHuxingNotEqualTo(String value) {
            addCriterion("huxing <>", value, "huxing");
            return (Criteria) this;
        }

        public Criteria andHuxingGreaterThan(String value) {
            addCriterion("huxing >", value, "huxing");
            return (Criteria) this;
        }

        public Criteria andHuxingGreaterThanOrEqualTo(String value) {
            addCriterion("huxing >=", value, "huxing");
            return (Criteria) this;
        }

        public Criteria andHuxingLessThan(String value) {
            addCriterion("huxing <", value, "huxing");
            return (Criteria) this;
        }

        public Criteria andHuxingLessThanOrEqualTo(String value) {
            addCriterion("huxing <=", value, "huxing");
            return (Criteria) this;
        }

        public Criteria andHuxingLike(String value) {
            addCriterion("huxing like", value, "huxing");
            return (Criteria) this;
        }

        public Criteria andHuxingNotLike(String value) {
            addCriterion("huxing not like", value, "huxing");
            return (Criteria) this;
        }

        public Criteria andHuxingIn(List<String> values) {
            addCriterion("huxing in", values, "huxing");
            return (Criteria) this;
        }

        public Criteria andHuxingNotIn(List<String> values) {
            addCriterion("huxing not in", values, "huxing");
            return (Criteria) this;
        }

        public Criteria andHuxingBetween(String value1, String value2) {
            addCriterion("huxing between", value1, value2, "huxing");
            return (Criteria) this;
        }

        public Criteria andHuxingNotBetween(String value1, String value2) {
            addCriterion("huxing not between", value1, value2, "huxing");
            return (Criteria) this;
        }

        public Criteria andMianjiIsNull() {
            addCriterion("mianji is null");
            return (Criteria) this;
        }

        public Criteria andMianjiIsNotNull() {
            addCriterion("mianji is not null");
            return (Criteria) this;
        }

        public Criteria andMianjiEqualTo(Double value) {
            addCriterion("mianji =", value, "mianji");
            return (Criteria) this;
        }

        public Criteria andMianjiNotEqualTo(Double value) {
            addCriterion("mianji <>", value, "mianji");
            return (Criteria) this;
        }

        public Criteria andMianjiGreaterThan(Double value) {
            addCriterion("mianji >", value, "mianji");
            return (Criteria) this;
        }

        public Criteria andMianjiGreaterThanOrEqualTo(Double value) {
            addCriterion("mianji >=", value, "mianji");
            return (Criteria) this;
        }

        public Criteria andMianjiLessThan(Double value) {
            addCriterion("mianji <", value, "mianji");
            return (Criteria) this;
        }

        public Criteria andMianjiLessThanOrEqualTo(Double value) {
            addCriterion("mianji <=", value, "mianji");
            return (Criteria) this;
        }

        public Criteria andMianjiIn(List<Double> values) {
            addCriterion("mianji in", values, "mianji");
            return (Criteria) this;
        }

        public Criteria andMianjiNotIn(List<Double> values) {
            addCriterion("mianji not in", values, "mianji");
            return (Criteria) this;
        }

        public Criteria andMianjiBetween(Double value1, Double value2) {
            addCriterion("mianji between", value1, value2, "mianji");
            return (Criteria) this;
        }

        public Criteria andMianjiNotBetween(Double value1, Double value2) {
            addCriterion("mianji not between", value1, value2, "mianji");
            return (Criteria) this;
        }

        public Criteria andChaoxiangIsNull() {
            addCriterion("chaoxiang is null");
            return (Criteria) this;
        }

        public Criteria andChaoxiangIsNotNull() {
            addCriterion("chaoxiang is not null");
            return (Criteria) this;
        }

        public Criteria andChaoxiangEqualTo(String value) {
            addCriterion("chaoxiang =", value, "chaoxiang");
            return (Criteria) this;
        }

        public Criteria andChaoxiangNotEqualTo(String value) {
            addCriterion("chaoxiang <>", value, "chaoxiang");
            return (Criteria) this;
        }

        public Criteria andChaoxiangGreaterThan(String value) {
            addCriterion("chaoxiang >", value, "chaoxiang");
            return (Criteria) this;
        }

        public Criteria andChaoxiangGreaterThanOrEqualTo(String value) {
            addCriterion("chaoxiang >=", value, "chaoxiang");
            return (Criteria) this;
        }

        public Criteria andChaoxiangLessThan(String value) {
            addCriterion("chaoxiang <", value, "chaoxiang");
            return (Criteria) this;
        }

        public Criteria andChaoxiangLessThanOrEqualTo(String value) {
            addCriterion("chaoxiang <=", value, "chaoxiang");
            return (Criteria) this;
        }

        public Criteria andChaoxiangLike(String value) {
            addCriterion("chaoxiang like", value, "chaoxiang");
            return (Criteria) this;
        }

        public Criteria andChaoxiangNotLike(String value) {
            addCriterion("chaoxiang not like", value, "chaoxiang");
            return (Criteria) this;
        }

        public Criteria andChaoxiangIn(List<String> values) {
            addCriterion("chaoxiang in", values, "chaoxiang");
            return (Criteria) this;
        }

        public Criteria andChaoxiangNotIn(List<String> values) {
            addCriterion("chaoxiang not in", values, "chaoxiang");
            return (Criteria) this;
        }

        public Criteria andChaoxiangBetween(String value1, String value2) {
            addCriterion("chaoxiang between", value1, value2, "chaoxiang");
            return (Criteria) this;
        }

        public Criteria andChaoxiangNotBetween(String value1, String value2) {
            addCriterion("chaoxiang not between", value1, value2, "chaoxiang");
            return (Criteria) this;
        }

        public Criteria andLoucengIsNull() {
            addCriterion("louceng is null");
            return (Criteria) this;
        }

        public Criteria andLoucengIsNotNull() {
            addCriterion("louceng is not null");
            return (Criteria) this;
        }

        public Criteria andLoucengEqualTo(String value) {
            addCriterion("louceng =", value, "louceng");
            return (Criteria) this;
        }

        public Criteria andLoucengNotEqualTo(String value) {
            addCriterion("louceng <>", value, "louceng");
            return (Criteria) this;
        }

        public Criteria andLoucengGreaterThan(String value) {
            addCriterion("louceng >", value, "louceng");
            return (Criteria) this;
        }

        public Criteria andLoucengGreaterThanOrEqualTo(String value) {
            addCriterion("louceng >=", value, "louceng");
            return (Criteria) this;
        }

        public Criteria andLoucengLessThan(String value) {
            addCriterion("louceng <", value, "louceng");
            return (Criteria) this;
        }

        public Criteria andLoucengLessThanOrEqualTo(String value) {
            addCriterion("louceng <=", value, "louceng");
            return (Criteria) this;
        }

        public Criteria andLoucengLike(String value) {
            addCriterion("louceng like", value, "louceng");
            return (Criteria) this;
        }

        public Criteria andLoucengNotLike(String value) {
            addCriterion("louceng not like", value, "louceng");
            return (Criteria) this;
        }

        public Criteria andLoucengIn(List<String> values) {
            addCriterion("louceng in", values, "louceng");
            return (Criteria) this;
        }

        public Criteria andLoucengNotIn(List<String> values) {
            addCriterion("louceng not in", values, "louceng");
            return (Criteria) this;
        }

        public Criteria andLoucengBetween(String value1, String value2) {
            addCriterion("louceng between", value1, value2, "louceng");
            return (Criteria) this;
        }

        public Criteria andLoucengNotBetween(String value1, String value2) {
            addCriterion("louceng not between", value1, value2, "louceng");
            return (Criteria) this;
        }

        public Criteria andZhuangxiuIsNull() {
            addCriterion("zhuangxiu is null");
            return (Criteria) this;
        }

        public Criteria andZhuangxiuIsNotNull() {
            addCriterion("zhuangxiu is not null");
            return (Criteria) this;
        }

        public Criteria andZhuangxiuEqualTo(String value) {
            addCriterion("zhuangxiu =", value, "zhuangxiu");
            return (Criteria) this;
        }

        public Criteria andZhuangxiuNotEqualTo(String value) {
            addCriterion("zhuangxiu <>", value, "zhuangxiu");
            return (Criteria) this;
        }

        public Criteria andZhuangxiuGreaterThan(String value) {
            addCriterion("zhuangxiu >", value, "zhuangxiu");
            return (Criteria) this;
        }

        public Criteria andZhuangxiuGreaterThanOrEqualTo(String value) {
            addCriterion("zhuangxiu >=", value, "zhuangxiu");
            return (Criteria) this;
        }

        public Criteria andZhuangxiuLessThan(String value) {
            addCriterion("zhuangxiu <", value, "zhuangxiu");
            return (Criteria) this;
        }

        public Criteria andZhuangxiuLessThanOrEqualTo(String value) {
            addCriterion("zhuangxiu <=", value, "zhuangxiu");
            return (Criteria) this;
        }

        public Criteria andZhuangxiuLike(String value) {
            addCriterion("zhuangxiu like", value, "zhuangxiu");
            return (Criteria) this;
        }

        public Criteria andZhuangxiuNotLike(String value) {
            addCriterion("zhuangxiu not like", value, "zhuangxiu");
            return (Criteria) this;
        }

        public Criteria andZhuangxiuIn(List<String> values) {
            addCriterion("zhuangxiu in", values, "zhuangxiu");
            return (Criteria) this;
        }

        public Criteria andZhuangxiuNotIn(List<String> values) {
            addCriterion("zhuangxiu not in", values, "zhuangxiu");
            return (Criteria) this;
        }

        public Criteria andZhuangxiuBetween(String value1, String value2) {
            addCriterion("zhuangxiu between", value1, value2, "zhuangxiu");
            return (Criteria) this;
        }

        public Criteria andZhuangxiuNotBetween(String value1, String value2) {
            addCriterion("zhuangxiu not between", value1, value2, "zhuangxiu");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andFaburenidIsNull() {
            addCriterion("faburenid is null");
            return (Criteria) this;
        }

        public Criteria andFaburenidIsNotNull() {
            addCriterion("faburenid is not null");
            return (Criteria) this;
        }

        public Criteria andFaburenidEqualTo(Integer value) {
            addCriterion("faburenid =", value, "faburenid");
            return (Criteria) this;
        }

        public Criteria andFaburenidNotEqualTo(Integer value) {
            addCriterion("faburenid <>", value, "faburenid");
            return (Criteria) this;
        }

        public Criteria andFaburenidGreaterThan(Integer value) {
            addCriterion("faburenid >", value, "faburenid");
            return (Criteria) this;
        }

        public Criteria andFaburenidGreaterThanOrEqualTo(Integer value) {
            addCriterion("faburenid >=", value, "faburenid");
            return (Criteria) this;
        }

        public Criteria andFaburenidLessThan(Integer value) {
            addCriterion("faburenid <", value, "faburenid");
            return (Criteria) this;
        }

        public Criteria andFaburenidLessThanOrEqualTo(Integer value) {
            addCriterion("faburenid <=", value, "faburenid");
            return (Criteria) this;
        }

        public Criteria andFaburenidIn(List<Integer> values) {
            addCriterion("faburenid in", values, "faburenid");
            return (Criteria) this;
        }

        public Criteria andFaburenidNotIn(List<Integer> values) {
            addCriterion("faburenid not in", values, "faburenid");
            return (Criteria) this;
        }

        public Criteria andFaburenidBetween(Integer value1, Integer value2) {
            addCriterion("faburenid between", value1, value2, "faburenid");
            return (Criteria) this;
        }

        public Criteria andFaburenidNotBetween(Integer value1, Integer value2) {
            addCriterion("faburenid not between", value1, value2, "faburenid");
            return (Criteria) this;
        }

        public Criteria andWeituorenidIsNull() {
            addCriterion("weituorenid is null");
            return (Criteria) this;
        }

        public Criteria andWeituorenidIsNotNull() {
            addCriterion("weituorenid is not null");
            return (Criteria) this;
        }

        public Criteria andWeituorenidEqualTo(Integer value) {
            addCriterion("weituorenid =", value, "weituorenid");
            return (Criteria) this;
        }

        public Criteria andWeituorenidNotEqualTo(Integer value) {
            addCriterion("weituorenid <>", value, "weituorenid");
            return (Criteria) this;
        }

        public Criteria andWeituorenidGreaterThan(Integer value) {
            addCriterion("weituorenid >", value, "weituorenid");
            return (Criteria) this;
        }

        public Criteria andWeituorenidGreaterThanOrEqualTo(Integer value) {
            addCriterion("weituorenid >=", value, "weituorenid");
            return (Criteria) this;
        }

        public Criteria andWeituorenidLessThan(Integer value) {
            addCriterion("weituorenid <", value, "weituorenid");
            return (Criteria) this;
        }

        public Criteria andWeituorenidLessThanOrEqualTo(Integer value) {
            addCriterion("weituorenid <=", value, "weituorenid");
            return (Criteria) this;
        }

        public Criteria andWeituorenidIn(List<Integer> values) {
            addCriterion("weituorenid in", values, "weituorenid");
            return (Criteria) this;
        }

        public Criteria andWeituorenidNotIn(List<Integer> values) {
            addCriterion("weituorenid not in", values, "weituorenid");
            return (Criteria) this;
        }

        public Criteria andWeituorenidBetween(Integer value1, Integer value2) {
            addCriterion("weituorenid between", value1, value2, "weituorenid");
            return (Criteria) this;
        }

        public Criteria andWeituorenidNotBetween(Integer value1, Integer value2) {
            addCriterion("weituorenid not between", value1, value2, "weituorenid");
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

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andXujiacountIsNull() {
            addCriterion("xujiacount is null");
            return (Criteria) this;
        }

        public Criteria andXujiacountIsNotNull() {
            addCriterion("xujiacount is not null");
            return (Criteria) this;
        }

        public Criteria andXujiacountEqualTo(Integer value) {
            addCriterion("xujiacount =", value, "xujiacount");
            return (Criteria) this;
        }

        public Criteria andXujiacountNotEqualTo(Integer value) {
            addCriterion("xujiacount <>", value, "xujiacount");
            return (Criteria) this;
        }

        public Criteria andXujiacountGreaterThan(Integer value) {
            addCriterion("xujiacount >", value, "xujiacount");
            return (Criteria) this;
        }

        public Criteria andXujiacountGreaterThanOrEqualTo(Integer value) {
            addCriterion("xujiacount >=", value, "xujiacount");
            return (Criteria) this;
        }

        public Criteria andXujiacountLessThan(Integer value) {
            addCriterion("xujiacount <", value, "xujiacount");
            return (Criteria) this;
        }

        public Criteria andXujiacountLessThanOrEqualTo(Integer value) {
            addCriterion("xujiacount <=", value, "xujiacount");
            return (Criteria) this;
        }

        public Criteria andXujiacountIn(List<Integer> values) {
            addCriterion("xujiacount in", values, "xujiacount");
            return (Criteria) this;
        }

        public Criteria andXujiacountNotIn(List<Integer> values) {
            addCriterion("xujiacount not in", values, "xujiacount");
            return (Criteria) this;
        }

        public Criteria andXujiacountBetween(Integer value1, Integer value2) {
            addCriterion("xujiacount between", value1, value2, "xujiacount");
            return (Criteria) this;
        }

        public Criteria andXujiacountNotBetween(Integer value1, Integer value2) {
            addCriterion("xujiacount not between", value1, value2, "xujiacount");
            return (Criteria) this;
        }

        public Criteria andPicsIsNull() {
            addCriterion("pics is null");
            return (Criteria) this;
        }

        public Criteria andPicsIsNotNull() {
            addCriterion("pics is not null");
            return (Criteria) this;
        }

        public Criteria andPicsEqualTo(String value) {
            addCriterion("pics =", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsNotEqualTo(String value) {
            addCriterion("pics <>", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsGreaterThan(String value) {
            addCriterion("pics >", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsGreaterThanOrEqualTo(String value) {
            addCriterion("pics >=", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsLessThan(String value) {
            addCriterion("pics <", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsLessThanOrEqualTo(String value) {
            addCriterion("pics <=", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsLike(String value) {
            addCriterion("pics like", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsNotLike(String value) {
            addCriterion("pics not like", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsIn(List<String> values) {
            addCriterion("pics in", values, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsNotIn(List<String> values) {
            addCriterion("pics not in", values, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsBetween(String value1, String value2) {
            addCriterion("pics between", value1, value2, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsNotBetween(String value1, String value2) {
            addCriterion("pics not between", value1, value2, "pics");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
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