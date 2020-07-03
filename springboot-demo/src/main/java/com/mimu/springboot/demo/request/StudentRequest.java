package com.mimu.springboot.demo.request;

import java.util.Objects;

/**
 * author: mimu
 * date: 2019/11/1
 */
public class StudentRequest {
    private int no;
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentRequest that = (StudentRequest) o;
        return no == that.no &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, name);
    }

    @Override
    public String toString() {
        return "StudentRequest{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
