package com.myweb.vo.mybatis;

import java.util.ArrayList;
import java.util.List;

public class TableinfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tableinfo
     *
     * @mbggenerated Sat May 07 01:00:37 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tableinfo
     *
     * @mbggenerated Sat May 07 01:00:37 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tableinfo
     *
     * @mbggenerated Sat May 07 01:00:37 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbggenerated Sat May 07 01:00:37 CST 2016
     */
    public TableinfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbggenerated Sat May 07 01:00:37 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbggenerated Sat May 07 01:00:37 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbggenerated Sat May 07 01:00:37 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbggenerated Sat May 07 01:00:37 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbggenerated Sat May 07 01:00:37 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbggenerated Sat May 07 01:00:37 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbggenerated Sat May 07 01:00:37 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbggenerated Sat May 07 01:00:37 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbggenerated Sat May 07 01:00:37 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbggenerated Sat May 07 01:00:37 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tableinfo
     *
     * @mbggenerated Sat May 07 01:00:37 CST 2016
     */
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

        public Criteria andTablenameIsNull() {
            addCriterion("tablename is null");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNotNull() {
            addCriterion("tablename is not null");
            return (Criteria) this;
        }

        public Criteria andTablenameEqualTo(String value) {
            addCriterion("tablename =", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotEqualTo(String value) {
            addCriterion("tablename <>", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThan(String value) {
            addCriterion("tablename >", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThanOrEqualTo(String value) {
            addCriterion("tablename >=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThan(String value) {
            addCriterion("tablename <", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThanOrEqualTo(String value) {
            addCriterion("tablename <=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLike(String value) {
            addCriterion("tablename like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotLike(String value) {
            addCriterion("tablename not like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameIn(List<String> values) {
            addCriterion("tablename in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotIn(List<String> values) {
            addCriterion("tablename not in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameBetween(String value1, String value2) {
            addCriterion("tablename between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotBetween(String value1, String value2) {
            addCriterion("tablename not between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andColumnnameIsNull() {
            addCriterion("columnname is null");
            return (Criteria) this;
        }

        public Criteria andColumnnameIsNotNull() {
            addCriterion("columnname is not null");
            return (Criteria) this;
        }

        public Criteria andColumnnameEqualTo(String value) {
            addCriterion("columnname =", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotEqualTo(String value) {
            addCriterion("columnname <>", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameGreaterThan(String value) {
            addCriterion("columnname >", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameGreaterThanOrEqualTo(String value) {
            addCriterion("columnname >=", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameLessThan(String value) {
            addCriterion("columnname <", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameLessThanOrEqualTo(String value) {
            addCriterion("columnname <=", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameLike(String value) {
            addCriterion("columnname like", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotLike(String value) {
            addCriterion("columnname not like", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameIn(List<String> values) {
            addCriterion("columnname in", values, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotIn(List<String> values) {
            addCriterion("columnname not in", values, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameBetween(String value1, String value2) {
            addCriterion("columnname between", value1, value2, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotBetween(String value1, String value2) {
            addCriterion("columnname not between", value1, value2, "columnname");
            return (Criteria) this;
        }

        public Criteria andChineseIsNull() {
            addCriterion("chinese is null");
            return (Criteria) this;
        }

        public Criteria andChineseIsNotNull() {
            addCriterion("chinese is not null");
            return (Criteria) this;
        }

        public Criteria andChineseEqualTo(String value) {
            addCriterion("chinese =", value, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseNotEqualTo(String value) {
            addCriterion("chinese <>", value, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseGreaterThan(String value) {
            addCriterion("chinese >", value, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseGreaterThanOrEqualTo(String value) {
            addCriterion("chinese >=", value, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseLessThan(String value) {
            addCriterion("chinese <", value, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseLessThanOrEqualTo(String value) {
            addCriterion("chinese <=", value, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseLike(String value) {
            addCriterion("chinese like", value, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseNotLike(String value) {
            addCriterion("chinese not like", value, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseIn(List<String> values) {
            addCriterion("chinese in", values, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseNotIn(List<String> values) {
            addCriterion("chinese not in", values, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseBetween(String value1, String value2) {
            addCriterion("chinese between", value1, value2, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseNotBetween(String value1, String value2) {
            addCriterion("chinese not between", value1, value2, "chinese");
            return (Criteria) this;
        }

        public Criteria andTabletypeIsNull() {
            addCriterion("tabletype is null");
            return (Criteria) this;
        }

        public Criteria andTabletypeIsNotNull() {
            addCriterion("tabletype is not null");
            return (Criteria) this;
        }

        public Criteria andTabletypeEqualTo(String value) {
            addCriterion("tabletype =", value, "tabletype");
            return (Criteria) this;
        }

        public Criteria andTabletypeNotEqualTo(String value) {
            addCriterion("tabletype <>", value, "tabletype");
            return (Criteria) this;
        }

        public Criteria andTabletypeGreaterThan(String value) {
            addCriterion("tabletype >", value, "tabletype");
            return (Criteria) this;
        }

        public Criteria andTabletypeGreaterThanOrEqualTo(String value) {
            addCriterion("tabletype >=", value, "tabletype");
            return (Criteria) this;
        }

        public Criteria andTabletypeLessThan(String value) {
            addCriterion("tabletype <", value, "tabletype");
            return (Criteria) this;
        }

        public Criteria andTabletypeLessThanOrEqualTo(String value) {
            addCriterion("tabletype <=", value, "tabletype");
            return (Criteria) this;
        }

        public Criteria andTabletypeLike(String value) {
            addCriterion("tabletype like", value, "tabletype");
            return (Criteria) this;
        }

        public Criteria andTabletypeNotLike(String value) {
            addCriterion("tabletype not like", value, "tabletype");
            return (Criteria) this;
        }

        public Criteria andTabletypeIn(List<String> values) {
            addCriterion("tabletype in", values, "tabletype");
            return (Criteria) this;
        }

        public Criteria andTabletypeNotIn(List<String> values) {
            addCriterion("tabletype not in", values, "tabletype");
            return (Criteria) this;
        }

        public Criteria andTabletypeBetween(String value1, String value2) {
            addCriterion("tabletype between", value1, value2, "tabletype");
            return (Criteria) this;
        }

        public Criteria andTabletypeNotBetween(String value1, String value2) {
            addCriterion("tabletype not between", value1, value2, "tabletype");
            return (Criteria) this;
        }

        public Criteria andInputtypeIsNull() {
            addCriterion("inputtype is null");
            return (Criteria) this;
        }

        public Criteria andInputtypeIsNotNull() {
            addCriterion("inputtype is not null");
            return (Criteria) this;
        }

        public Criteria andInputtypeEqualTo(String value) {
            addCriterion("inputtype =", value, "inputtype");
            return (Criteria) this;
        }

        public Criteria andInputtypeNotEqualTo(String value) {
            addCriterion("inputtype <>", value, "inputtype");
            return (Criteria) this;
        }

        public Criteria andInputtypeGreaterThan(String value) {
            addCriterion("inputtype >", value, "inputtype");
            return (Criteria) this;
        }

        public Criteria andInputtypeGreaterThanOrEqualTo(String value) {
            addCriterion("inputtype >=", value, "inputtype");
            return (Criteria) this;
        }

        public Criteria andInputtypeLessThan(String value) {
            addCriterion("inputtype <", value, "inputtype");
            return (Criteria) this;
        }

        public Criteria andInputtypeLessThanOrEqualTo(String value) {
            addCriterion("inputtype <=", value, "inputtype");
            return (Criteria) this;
        }

        public Criteria andInputtypeLike(String value) {
            addCriterion("inputtype like", value, "inputtype");
            return (Criteria) this;
        }

        public Criteria andInputtypeNotLike(String value) {
            addCriterion("inputtype not like", value, "inputtype");
            return (Criteria) this;
        }

        public Criteria andInputtypeIn(List<String> values) {
            addCriterion("inputtype in", values, "inputtype");
            return (Criteria) this;
        }

        public Criteria andInputtypeNotIn(List<String> values) {
            addCriterion("inputtype not in", values, "inputtype");
            return (Criteria) this;
        }

        public Criteria andInputtypeBetween(String value1, String value2) {
            addCriterion("inputtype between", value1, value2, "inputtype");
            return (Criteria) this;
        }

        public Criteria andInputtypeNotBetween(String value1, String value2) {
            addCriterion("inputtype not between", value1, value2, "inputtype");
            return (Criteria) this;
        }

        public Criteria andShunxuIsNull() {
            addCriterion("shunxu is null");
            return (Criteria) this;
        }

        public Criteria andShunxuIsNotNull() {
            addCriterion("shunxu is not null");
            return (Criteria) this;
        }

        public Criteria andShunxuEqualTo(Integer value) {
            addCriterion("shunxu =", value, "shunxu");
            return (Criteria) this;
        }

        public Criteria andShunxuNotEqualTo(Integer value) {
            addCriterion("shunxu <>", value, "shunxu");
            return (Criteria) this;
        }

        public Criteria andShunxuGreaterThan(Integer value) {
            addCriterion("shunxu >", value, "shunxu");
            return (Criteria) this;
        }

        public Criteria andShunxuGreaterThanOrEqualTo(Integer value) {
            addCriterion("shunxu >=", value, "shunxu");
            return (Criteria) this;
        }

        public Criteria andShunxuLessThan(Integer value) {
            addCriterion("shunxu <", value, "shunxu");
            return (Criteria) this;
        }

        public Criteria andShunxuLessThanOrEqualTo(Integer value) {
            addCriterion("shunxu <=", value, "shunxu");
            return (Criteria) this;
        }

        public Criteria andShunxuIn(List<Integer> values) {
            addCriterion("shunxu in", values, "shunxu");
            return (Criteria) this;
        }

        public Criteria andShunxuNotIn(List<Integer> values) {
            addCriterion("shunxu not in", values, "shunxu");
            return (Criteria) this;
        }

        public Criteria andShunxuBetween(Integer value1, Integer value2) {
            addCriterion("shunxu between", value1, value2, "shunxu");
            return (Criteria) this;
        }

        public Criteria andShunxuNotBetween(Integer value1, Integer value2) {
            addCriterion("shunxu not between", value1, value2, "shunxu");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tableinfo
     *
     * @mbggenerated do_not_delete_during_merge Sat May 07 01:00:37 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tableinfo
     *
     * @mbggenerated Sat May 07 01:00:37 CST 2016
     */
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