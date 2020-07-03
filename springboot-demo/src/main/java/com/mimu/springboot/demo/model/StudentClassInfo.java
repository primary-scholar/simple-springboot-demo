package com.mimu.springboot.demo.model;

import java.io.Serializable;
import java.util.Objects;

public class StudentClassInfo implements Serializable {
    private int id;
    private String academy;
    private String grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentClassInfo that = (StudentClassInfo) o;
        return id == that.id &&
                Objects.equals(academy, that.academy) &&
                Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, academy, grade);
    }

    @Override
    public String toString() {
        return "StudentClassInfo{" +
                "id=" + id +
                ", academy='" + academy + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
