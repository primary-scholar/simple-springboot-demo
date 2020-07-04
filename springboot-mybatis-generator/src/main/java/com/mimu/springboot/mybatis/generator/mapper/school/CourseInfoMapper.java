package com.mimu.springboot.mybatis.generator.mapper.school;

import com.mimu.springboot.mybatis.generator.model.school.CourseInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface CourseInfoMapper {
    @Delete({
        "delete from course_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into course_info (no, name, ",
        "hour)",
        "values (#{no,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{hour,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(CourseInfo record);

    int insertSelective(CourseInfo record);

    @Select({
        "select",
        "id, no, name, hour",
        "from course_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.mimu.springboot.mybatis.generator.mapper.school.CourseInfoMapper.BaseResultMap")
    CourseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseInfo record);

    @Update({
        "update course_info",
        "set no = #{no,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "hour = #{hour,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CourseInfo record);
}