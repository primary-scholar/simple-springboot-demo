package com.mimu.springboot.mybatis.demo.mapper.student;

import com.mimu.springboot.mybatis.demo.model.StudentStudentInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

/**
 * author: mimu
 * date: 2019/8/1
 */

/**
 * here @Repository 是否添加都可以，不添加时 idea 进行 CommonService @Autowired 注入时 会提示错误，
 * 实际上 没有问题
 */
@Repository
public interface StudentDataMapper {

    @Select("select * from student_info where no=#{no}")
    @Results(value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER),
            @Result(column = "no", property = "no", jdbcType = JdbcType.INTEGER),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sex", property = "sex", jdbcType = JdbcType.SMALLINT)
    })
    StudentStudentInfo getStudentInfo(@Param(value = "no") int no);
}
