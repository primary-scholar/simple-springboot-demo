package com.mimu.springboot.demo.dao;

import com.mimu.springboot.demo.model.StudentStudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author: mimu
 * date: 2019/7/7
 */
@Repository
public class StudentRepository {
    private JdbcTemplate studentJdbcTemplate;

    @Autowired
    public void setUserInfoJdbcTemplate(JdbcTemplate studentJdbcTemplate) {
        this.studentJdbcTemplate = studentJdbcTemplate;
    }

    public StudentStudentInfo getStudentInfo(int no) {
        String sql = "select * from student_info where no=?";
        List<StudentStudentInfo> studentInfoList = studentJdbcTemplate.queryForList(sql, StudentStudentInfo.class, no);
        return studentInfoList.isEmpty() ? null : studentInfoList.get(0);
    }

    public boolean updateStudent(int no, String name) {
        String sql = "update student_info set name=? where no=?";
        return studentJdbcTemplate.update(sql, name, no) > 0;
    }

    public boolean addStudentInfo(int no, String name, int sex) {
        String sql = "insert into student_info (`no`, `name`, `sex`) values (?,?,?)";
        return studentJdbcTemplate.update(sql, no, name, sex) > 0;
    }

    public boolean deleteStudentInfo(long no) {
        String sql = "delete from student_info where no=?";
        return studentJdbcTemplate.update(sql, no) > 0;
    }

}
