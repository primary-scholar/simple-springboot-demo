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

    public boolean addUserInfo(long pid, String nickName) {
        String sql = "insert into user_info (`person_name`, `person_id`) values (?,?)";
        return studentJdbcTemplate.update(sql, pid, nickName) > 0;
    }

    public boolean deleteUserInfo(long pid) {
        String sql = "delete from user_info where person_id=?";
        return studentJdbcTemplate.update(sql, pid) > 0;
    }

    public boolean addTermInfo(long pid, int termId) {
        String sql = "insert into term_info (`term_id`, `person_id`) values (?,?)";
        return studentJdbcTemplate.update(sql, termId, pid) > 0;
    }

}
