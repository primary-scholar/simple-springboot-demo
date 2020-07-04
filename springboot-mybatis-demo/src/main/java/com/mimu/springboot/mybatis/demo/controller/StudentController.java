package com.mimu.springboot.mybatis.demo.controller;

import com.mimu.springboot.mybatis.demo.model.StudentStudentInfo;
import com.mimu.springboot.mybatis.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/student.do", method = RequestMethod.GET)
    public StudentStudentInfo getStudentInfo(int no) {
        StudentStudentInfo studentInfo = studentService.getStudentInfo(no);
        logger.info("request={},result={}", no, studentInfo);
        return studentInfo;
    }

}
