package com.mimu.springboot.demo.controller;

import com.mimu.springboot.demo.model.StudentStudentInfo;
import com.mimu.springboot.demo.request.StudentRequest;
import com.mimu.springboot.demo.service.StudentService;
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
    public StudentStudentInfo getStudentInfo(StudentRequest request) {
        StudentStudentInfo studentInfo = studentService.getStudentInfo(request);
        logger.info("request={},result={}", request, studentInfo);
        return studentInfo;
    }
}
