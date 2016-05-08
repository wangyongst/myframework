package com.myweb.pojo.mybatis;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CaijiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CaijiExample() {
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

        public Criteria andLaorenidIsNull() {
            addCriterion("laorenid is null");
            return (Criteria) this;
        }

        public Criteria andLaorenidIsNotNull() {
            addCriterion("laorenid is not null");
            return (Criteria) this;
        }

        public Criteria andLaorenidEqualTo(Integer value) {
            addCriterion("laorenid =", value, "laorenid");
            return (Criteria) this;
        }

        public Criteria andLaorenidNotEqualTo(Integer value) {
            addCriterion("laorenid <>", value, "laorenid");
            return (Criteria) this;
        }

        public Criteria andLaorenidGreaterThan(Integer value) {
            addCriterion("laorenid >", value, "laorenid");
            return (Criteria) this;
        }

        public Criteria andLaorenidGreaterThanOrEqualTo(Integer value) {
            addCriterion("laorenid >=", value, "laorenid");
            return (Criteria) this;
        }

        public Criteria andLaorenidLessThan(Integer value) {
            addCriterion("laorenid <", value, "laorenid");
            return (Criteria) this;
        }

        public Criteria andLaorenidLessThanOrEqualTo(Integer value) {
            addCriterion("laorenid <=", value, "laorenid");
            return (Criteria) this;
        }

        public Criteria andLaorenidIn(List<Integer> values) {
            addCriterion("laorenid in", values, "laorenid");
            return (Criteria) this;
        }

        public Criteria andLaorenidNotIn(List<Integer> values) {
            addCriterion("laorenid not in", values, "laorenid");
            return (Criteria) this;
        }

        public Criteria andLaorenidBetween(Integer value1, Integer value2) {
            addCriterion("laorenid between", value1, value2, "laorenid");
            return (Criteria) this;
        }

        public Criteria andLaorenidNotBetween(Integer value1, Integer value2) {
            addCriterion("laorenid not between", value1, value2, "laorenid");
            return (Criteria) this;
        }

        public Criteria andLaorennameIsNull() {
            addCriterion("laorenname is null");
            return (Criteria) this;
        }

        public Criteria andLaorennameIsNotNull() {
            addCriterion("laorenname is not null");
            return (Criteria) this;
        }

        public Criteria andLaorennameEqualTo(String value) {
            addCriterion("laorenname =", value, "laorenname");
            return (Criteria) this;
        }

        public Criteria andLaorennameNotEqualTo(String value) {
            addCriterion("laorenname <>", value, "laorenname");
            return (Criteria) this;
        }

        public Criteria andLaorennameGreaterThan(String value) {
            addCriterion("laorenname >", value, "laorenname");
            return (Criteria) this;
        }

        public Criteria andLaorennameGreaterThanOrEqualTo(String value) {
            addCriterion("laorenname >=", value, "laorenname");
            return (Criteria) this;
        }

        public Criteria andLaorennameLessThan(String value) {
            addCriterion("laorenname <", value, "laorenname");
            return (Criteria) this;
        }

        public Criteria andLaorennameLessThanOrEqualTo(String value) {
            addCriterion("laorenname <=", value, "laorenname");
            return (Criteria) this;
        }

        public Criteria andLaorennameLike(String value) {
            addCriterion("laorenname like", value, "laorenname");
            return (Criteria) this;
        }

        public Criteria andLaorennameNotLike(String value) {
            addCriterion("laorenname not like", value, "laorenname");
            return (Criteria) this;
        }

        public Criteria andLaorennameIn(List<String> values) {
            addCriterion("laorenname in", values, "laorenname");
            return (Criteria) this;
        }

        public Criteria andLaorennameNotIn(List<String> values) {
            addCriterion("laorenname not in", values, "laorenname");
            return (Criteria) this;
        }

        public Criteria andLaorennameBetween(String value1, String value2) {
            addCriterion("laorenname between", value1, value2, "laorenname");
            return (Criteria) this;
        }

        public Criteria andLaorennameNotBetween(String value1, String value2) {
            addCriterion("laorenname not between", value1, value2, "laorenname");
            return (Criteria) this;
        }

        public Criteria andGaoyaIsNull() {
            addCriterion("gaoya is null");
            return (Criteria) this;
        }

        public Criteria andGaoyaIsNotNull() {
            addCriterion("gaoya is not null");
            return (Criteria) this;
        }

        public Criteria andGaoyaEqualTo(Integer value) {
            addCriterion("gaoya =", value, "gaoya");
            return (Criteria) this;
        }

        public Criteria andGaoyaNotEqualTo(Integer value) {
            addCriterion("gaoya <>", value, "gaoya");
            return (Criteria) this;
        }

        public Criteria andGaoyaGreaterThan(Integer value) {
            addCriterion("gaoya >", value, "gaoya");
            return (Criteria) this;
        }

        public Criteria andGaoyaGreaterThanOrEqualTo(Integer value) {
            addCriterion("gaoya >=", value, "gaoya");
            return (Criteria) this;
        }

        public Criteria andGaoyaLessThan(Integer value) {
            addCriterion("gaoya <", value, "gaoya");
            return (Criteria) this;
        }

        public Criteria andGaoyaLessThanOrEqualTo(Integer value) {
            addCriterion("gaoya <=", value, "gaoya");
            return (Criteria) this;
        }

        public Criteria andGaoyaIn(List<Integer> values) {
            addCriterion("gaoya in", values, "gaoya");
            return (Criteria) this;
        }

        public Criteria andGaoyaNotIn(List<Integer> values) {
            addCriterion("gaoya not in", values, "gaoya");
            return (Criteria) this;
        }

        public Criteria andGaoyaBetween(Integer value1, Integer value2) {
            addCriterion("gaoya between", value1, value2, "gaoya");
            return (Criteria) this;
        }

        public Criteria andGaoyaNotBetween(Integer value1, Integer value2) {
            addCriterion("gaoya not between", value1, value2, "gaoya");
            return (Criteria) this;
        }

        public Criteria andDiyaIsNull() {
            addCriterion("diya is null");
            return (Criteria) this;
        }

        public Criteria andDiyaIsNotNull() {
            addCriterion("diya is not null");
            return (Criteria) this;
        }

        public Criteria andDiyaEqualTo(Integer value) {
            addCriterion("diya =", value, "diya");
            return (Criteria) this;
        }

        public Criteria andDiyaNotEqualTo(Integer value) {
            addCriterion("diya <>", value, "diya");
            return (Criteria) this;
        }

        public Criteria andDiyaGreaterThan(Integer value) {
            addCriterion("diya >", value, "diya");
            return (Criteria) this;
        }

        public Criteria andDiyaGreaterThanOrEqualTo(Integer value) {
            addCriterion("diya >=", value, "diya");
            return (Criteria) this;
        }

        public Criteria andDiyaLessThan(Integer value) {
            addCriterion("diya <", value, "diya");
            return (Criteria) this;
        }

        public Criteria andDiyaLessThanOrEqualTo(Integer value) {
            addCriterion("diya <=", value, "diya");
            return (Criteria) this;
        }

        public Criteria andDiyaIn(List<Integer> values) {
            addCriterion("diya in", values, "diya");
            return (Criteria) this;
        }

        public Criteria andDiyaNotIn(List<Integer> values) {
            addCriterion("diya not in", values, "diya");
            return (Criteria) this;
        }

        public Criteria andDiyaBetween(Integer value1, Integer value2) {
            addCriterion("diya between", value1, value2, "diya");
            return (Criteria) this;
        }

        public Criteria andDiyaNotBetween(Integer value1, Integer value2) {
            addCriterion("diya not between", value1, value2, "diya");
            return (Criteria) this;
        }

        public Criteria andXuetangIsNull() {
            addCriterion("xuetang is null");
            return (Criteria) this;
        }

        public Criteria andXuetangIsNotNull() {
            addCriterion("xuetang is not null");
            return (Criteria) this;
        }

        public Criteria andXuetangEqualTo(BigDecimal value) {
            addCriterion("xuetang =", value, "xuetang");
            return (Criteria) this;
        }

        public Criteria andXuetangNotEqualTo(BigDecimal value) {
            addCriterion("xuetang <>", value, "xuetang");
            return (Criteria) this;
        }

        public Criteria andXuetangGreaterThan(BigDecimal value) {
            addCriterion("xuetang >", value, "xuetang");
            return (Criteria) this;
        }

        public Criteria andXuetangGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("xuetang >=", value, "xuetang");
            return (Criteria) this;
        }

        public Criteria andXuetangLessThan(BigDecimal value) {
            addCriterion("xuetang <", value, "xuetang");
            return (Criteria) this;
        }

        public Criteria andXuetangLessThanOrEqualTo(BigDecimal value) {
            addCriterion("xuetang <=", value, "xuetang");
            return (Criteria) this;
        }

        public Criteria andXuetangIn(List<BigDecimal> values) {
            addCriterion("xuetang in", values, "xuetang");
            return (Criteria) this;
        }

        public Criteria andXuetangNotIn(List<BigDecimal> values) {
            addCriterion("xuetang not in", values, "xuetang");
            return (Criteria) this;
        }

        public Criteria andXuetangBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("xuetang between", value1, value2, "xuetang");
            return (Criteria) this;
        }

        public Criteria andXuetangNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("xuetang not between", value1, value2, "xuetang");
            return (Criteria) this;
        }

        public Criteria andMaiboIsNull() {
            addCriterion("maibo is null");
            return (Criteria) this;
        }

        public Criteria andMaiboIsNotNull() {
            addCriterion("maibo is not null");
            return (Criteria) this;
        }

        public Criteria andMaiboEqualTo(Integer value) {
            addCriterion("maibo =", value, "maibo");
            return (Criteria) this;
        }

        public Criteria andMaiboNotEqualTo(Integer value) {
            addCriterion("maibo <>", value, "maibo");
            return (Criteria) this;
        }

        public Criteria andMaiboGreaterThan(Integer value) {
            addCriterion("maibo >", value, "maibo");
            return (Criteria) this;
        }

        public Criteria andMaiboGreaterThanOrEqualTo(Integer value) {
            addCriterion("maibo >=", value, "maibo");
            return (Criteria) this;
        }

        public Criteria andMaiboLessThan(Integer value) {
            addCriterion("maibo <", value, "maibo");
            return (Criteria) this;
        }

        public Criteria andMaiboLessThanOrEqualTo(Integer value) {
            addCriterion("maibo <=", value, "maibo");
            return (Criteria) this;
        }

        public Criteria andMaiboIn(List<Integer> values) {
            addCriterion("maibo in", values, "maibo");
            return (Criteria) this;
        }

        public Criteria andMaiboNotIn(List<Integer> values) {
            addCriterion("maibo not in", values, "maibo");
            return (Criteria) this;
        }

        public Criteria andMaiboBetween(Integer value1, Integer value2) {
            addCriterion("maibo between", value1, value2, "maibo");
            return (Criteria) this;
        }

        public Criteria andMaiboNotBetween(Integer value1, Integer value2) {
            addCriterion("maibo not between", value1, value2, "maibo");
            return (Criteria) this;
        }

        public Criteria andXueyangIsNull() {
            addCriterion("xueyang is null");
            return (Criteria) this;
        }

        public Criteria andXueyangIsNotNull() {
            addCriterion("xueyang is not null");
            return (Criteria) this;
        }

        public Criteria andXueyangEqualTo(Integer value) {
            addCriterion("xueyang =", value, "xueyang");
            return (Criteria) this;
        }

        public Criteria andXueyangNotEqualTo(Integer value) {
            addCriterion("xueyang <>", value, "xueyang");
            return (Criteria) this;
        }

        public Criteria andXueyangGreaterThan(Integer value) {
            addCriterion("xueyang >", value, "xueyang");
            return (Criteria) this;
        }

        public Criteria andXueyangGreaterThanOrEqualTo(Integer value) {
            addCriterion("xueyang >=", value, "xueyang");
            return (Criteria) this;
        }

        public Criteria andXueyangLessThan(Integer value) {
            addCriterion("xueyang <", value, "xueyang");
            return (Criteria) this;
        }

        public Criteria andXueyangLessThanOrEqualTo(Integer value) {
            addCriterion("xueyang <=", value, "xueyang");
            return (Criteria) this;
        }

        public Criteria andXueyangIn(List<Integer> values) {
            addCriterion("xueyang in", values, "xueyang");
            return (Criteria) this;
        }

        public Criteria andXueyangNotIn(List<Integer> values) {
            addCriterion("xueyang not in", values, "xueyang");
            return (Criteria) this;
        }

        public Criteria andXueyangBetween(Integer value1, Integer value2) {
            addCriterion("xueyang between", value1, value2, "xueyang");
            return (Criteria) this;
        }

        public Criteria andXueyangNotBetween(Integer value1, Integer value2) {
            addCriterion("xueyang not between", value1, value2, "xueyang");
            return (Criteria) this;
        }

        public Criteria andTizhongIsNull() {
            addCriterion("tizhong is null");
            return (Criteria) this;
        }

        public Criteria andTizhongIsNotNull() {
            addCriterion("tizhong is not null");
            return (Criteria) this;
        }

        public Criteria andTizhongEqualTo(BigDecimal value) {
            addCriterion("tizhong =", value, "tizhong");
            return (Criteria) this;
        }

        public Criteria andTizhongNotEqualTo(BigDecimal value) {
            addCriterion("tizhong <>", value, "tizhong");
            return (Criteria) this;
        }

        public Criteria andTizhongGreaterThan(BigDecimal value) {
            addCriterion("tizhong >", value, "tizhong");
            return (Criteria) this;
        }

        public Criteria andTizhongGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tizhong >=", value, "tizhong");
            return (Criteria) this;
        }

        public Criteria andTizhongLessThan(BigDecimal value) {
            addCriterion("tizhong <", value, "tizhong");
            return (Criteria) this;
        }

        public Criteria andTizhongLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tizhong <=", value, "tizhong");
            return (Criteria) this;
        }

        public Criteria andTizhongIn(List<BigDecimal> values) {
            addCriterion("tizhong in", values, "tizhong");
            return (Criteria) this;
        }

        public Criteria andTizhongNotIn(List<BigDecimal> values) {
            addCriterion("tizhong not in", values, "tizhong");
            return (Criteria) this;
        }

        public Criteria andTizhongBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tizhong between", value1, value2, "tizhong");
            return (Criteria) this;
        }

        public Criteria andTizhongNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tizhong not between", value1, value2, "tizhong");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("time like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("time not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("time not between", value1, value2, "time");
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

        public Criteria andCreateuserEqualTo(Integer value) {
            addCriterion("createuser =", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotEqualTo(Integer value) {
            addCriterion("createuser <>", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThan(Integer value) {
            addCriterion("createuser >", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThanOrEqualTo(Integer value) {
            addCriterion("createuser >=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThan(Integer value) {
            addCriterion("createuser <", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThanOrEqualTo(Integer value) {
            addCriterion("createuser <=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserIn(List<Integer> values) {
            addCriterion("createuser in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotIn(List<Integer> values) {
            addCriterion("createuser not in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserBetween(Integer value1, Integer value2) {
            addCriterion("createuser between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotBetween(Integer value1, Integer value2) {
            addCriterion("createuser not between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateusernameIsNull() {
            addCriterion("createusername is null");
            return (Criteria) this;
        }

        public Criteria andCreateusernameIsNotNull() {
            addCriterion("createusername is not null");
            return (Criteria) this;
        }

        public Criteria andCreateusernameEqualTo(String value) {
            addCriterion("createusername =", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameNotEqualTo(String value) {
            addCriterion("createusername <>", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameGreaterThan(String value) {
            addCriterion("createusername >", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameGreaterThanOrEqualTo(String value) {
            addCriterion("createusername >=", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameLessThan(String value) {
            addCriterion("createusername <", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameLessThanOrEqualTo(String value) {
            addCriterion("createusername <=", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameLike(String value) {
            addCriterion("createusername like", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameNotLike(String value) {
            addCriterion("createusername not like", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameIn(List<String> values) {
            addCriterion("createusername in", values, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameNotIn(List<String> values) {
            addCriterion("createusername not in", values, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameBetween(String value1, String value2) {
            addCriterion("createusername between", value1, value2, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameNotBetween(String value1, String value2) {
            addCriterion("createusername not between", value1, value2, "createusername");
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

        public Criteria andCreatetimeEqualTo(String value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(String value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(String value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(String value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLike(String value) {
            addCriterion("createtime like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotLike(String value) {
            addCriterion("createtime not like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<String> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<String> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(String value1, String value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
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