package com.mimu.springboot.mybatis.generator.service;

import com.mimu.springboot.mybatis.generator.mapper.school.CourseInfoMapper;
import com.mimu.springboot.mybatis.generator.mapper.school.SchoolInfoMapper;
import com.mimu.springboot.mybatis.generator.mapper.student.StudentInfoMapper;
import com.mimu.springboot.mybatis.generator.model.school.SchoolInfo;
import com.mimu.springboot.mybatis.generator.model.student.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author: mimu
 * date: 2019/7/29
 */
@Service
public class CommonService {

    private StudentInfoMapper studentInfoMapper;
    private SchoolInfoMapper schoolInfoMapper;

    @Autowired
    public void setStudentInfoMapper(StudentInfoMapper studentInfoMapper) {
        this.studentInfoMapper = studentInfoMapper;
    }

    @Autowired
    public void setSchoolInfoMapper(SchoolInfoMapper schoolInfoMapper) {
        this.schoolInfoMapper = schoolInfoMapper;
    }

    public SchoolInfo getSchoolInfo(int serial) {
        return schoolInfoMapper.selectBySerial(serial);
    }

    public StudentInfo getStudentInfo(int no) {
        return studentInfoMapper.selectByNo(no);
    }

}
