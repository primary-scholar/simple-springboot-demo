package com.mimu.springboot.demo.model;

import java.io.Serializable;
import java.util.Objects;

public class SchoolCourseInfo implements Serializable {
    private int id;
    private int no;
    private String name;
    private int hour;

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

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolCourseInfo that = (SchoolCourseInfo) o;
        return id == that.id &&
                no == that.no &&
                hour == that.hour &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, no, name, hour);
    }

    @Override
    public String toString() {
        return "SchoolCourseInfo{" +
                "id=" + id +
                ", no=" + no +
                ", name='" + name + '\'' +
                ", hour=" + hour +
                '}';
    }
}
