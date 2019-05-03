package com.zjh.yummy.common.db;

import java.util.ArrayList;
import java.util.List;

public class SimpleQuery {

    protected String order;
    protected String sort;
    protected Integer offset;
    protected Integer limit;

    protected List<Condition> conditionList;

    public SimpleQuery() {
        this.conditionList = new ArrayList<>();
    }

    public static SimpleQuery create(){
        return new SimpleQuery();
    }

    public SimpleQuery and(String condition,Object value) {
        if (condition == null || condition.equals("")) {
            return this;
        }
        conditionList.add(new Condition(condition, value));
        return this;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<Condition> getConditionList() {
        return conditionList;
    }

    public void setConditionList(List<Condition> conditionList) {
        this.conditionList = conditionList;
    }

    public static class Condition{
        private String condition;
        private Object value;

        public Condition(String condition, Object value) {
            this.condition = condition;
            this.value = value;
        }

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }
}
