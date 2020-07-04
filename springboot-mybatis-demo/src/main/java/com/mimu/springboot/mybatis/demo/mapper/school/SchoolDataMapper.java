package com.mimu.springboot.mybatis.demo.mapper.school;

import com.mimu.springboot.mybatis.demo.model.SchoolSchoolInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

/**
 * author: mimu
 * date: 2019/7/30
 */

/**
 * here @Repository 是否添加都可以，不添加时 idea 进行 CommonService @Autowired 注入时 会提示错误，
 * 实际上 没有问题
 */
@Repository
public interface SchoolDataMapper {

    @Select("select * from school_info where serial=#{serial}")
    @Results(value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER),
            @Result(column = "serial", property = "serial", jdbcType = JdbcType.INTEGER),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "address", property = "address", jdbcType = JdbcType.VARCHAR)
    })
    SchoolSchoolInfo getSchoolInfo(@Param(value = "serial") int serial);
}
