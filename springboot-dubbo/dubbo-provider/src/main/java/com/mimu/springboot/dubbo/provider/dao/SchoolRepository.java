package com.mimu.springboot.dubbo.provider.dao;

import com.mimu.springboot.dubbo.provider.model.SchoolSchoolInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * author: mimu
 * date: 2019/7/7
 */
@Repository
public class SchoolRepository {
    private JdbcTemplate schoolJdbcTemplate;

    @Autowired
    public void setSchoolJdbcTemplate(JdbcTemplate schoolJdbcTemplate) {
        this.schoolJdbcTemplate = schoolJdbcTemplate;
    }

    public SchoolSchoolInfo getSchoolInfo(long serial) {
        String sql = "select * from school_info where serial=?";
        List<SchoolSchoolInfo> schoolInfoList = schoolJdbcTemplate.queryForList(sql, SchoolSchoolInfo.class, serial);
        return schoolInfoList.isEmpty() ? new SchoolSchoolInfo() : schoolInfoList.get(0);
    }

    public boolean addSchoolInfo(int serial, String name, String address) {
        String sql = "insert into school_info (`serial`, `name`, `address`) values (?,?,?)";
        return schoolJdbcTemplate.update(sql, serial, name, address) > 0;
    }

    public boolean addCourseInfo(int no, String name, int hour) {
        String sql = "insert into course_info (`no`, `name`, `hour`) values (?,?,?)";
        return schoolJdbcTemplate.update(sql, no, name, hour) > 0;
    }
}
