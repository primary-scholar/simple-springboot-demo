package com.mimu.springboot.demo.model;

import java.io.Serializable;
import java.util.Objects;

public class StudentStudentInfo implements Serializable {
    private int id;
    private int no;
    private String name;
    private int sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentStudentInfo that = (StudentStudentInfo) o;
        return id == that.id &&
                no == that.no &&
                sex == that.sex &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, no, name, sex);
    }

    @Override
    public String toString() {
        return "StudentStudentInfo{" +
                "id=" + id +
                ", no=" + no +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
