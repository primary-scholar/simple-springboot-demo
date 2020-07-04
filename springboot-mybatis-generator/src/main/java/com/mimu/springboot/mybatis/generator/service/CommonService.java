package com.mimu.springboot.mybatis.generator.service;

import com.mimu.springboot.mybatis.generator.mapper.school.CourseInfoMapper;
import com.mimu.springboot.mybatis.generator.mapper.school.SchoolInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author: mimu
 * date: 2019/7/29
 */
@Service
public class CommonService {

    private CourseInfoMapper courseInfoMapper;
    private SchoolInfoMapper schoolInfoMapper;

    @Autowired
    public void setCourseInfoMapper(CourseInfoMapper courseInfoMapper) {
        this.courseInfoMapper = courseInfoMapper;
    }

    @Autowired
    public void setSchoolInfoMapper(SchoolInfoMapper schoolInfoMapper) {
        this.schoolInfoMapper = schoolInfoMapper;
    }


}
