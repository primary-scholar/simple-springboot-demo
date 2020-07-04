package com.mimu.springboot.mybatis.demo.service;

import com.mimu.springboot.mybatis.demo.mapper.student.StudentDataMapper;
import com.mimu.springboot.mybatis.demo.model.StudentStudentInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author: mimu
 * date: 2020/4/27
 */

/**
 * spring cache 必须使用代理对象进行访问才会生效(内部调用不生效)
 */
@Service
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private StudentDataMapper studentDataMapper;

    @Autowired
    public void setStudentDataMapper(StudentDataMapper studentDataMapper) {
        this.studentDataMapper = studentDataMapper;
    }

    public StudentStudentInfo getStudentInfo(int no) {
        StudentStudentInfo studentInfo = studentDataMapper.getStudentInfo(no);
        logger.info("{}", studentInfo);
        return studentInfo;
    }
}
