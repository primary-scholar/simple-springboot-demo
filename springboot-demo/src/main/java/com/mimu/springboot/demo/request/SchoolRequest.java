package com.mimu.springboot.demo.request;


import java.util.Objects;

/**
 * author: mimu
 * date: 2019/10/9
 */

public class SchoolRequest {
   private int serial;

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolRequest that = (SchoolRequest) o;
        return serial == that.serial;
    }

    @Override
    public int hashCode() {
        return Objects.hash(serial);
    }

    @Override
    public String toString() {
        return "SchoolRequest{" +
                "serial=" + serial +
                '}';
    }
}
