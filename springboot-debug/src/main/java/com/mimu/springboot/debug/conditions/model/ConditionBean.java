package com.mimu.springboot.debug.conditions.model;

import java.util.Objects;

/**
 * author: mimu
 * date: 2019/7/26
 */
public class ConditionBean {
    private String flag;

    public ConditionBean(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flag);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConditionBean other = (ConditionBean) obj;
        return other.getFlag().equals(this.getFlag());
    }
}
