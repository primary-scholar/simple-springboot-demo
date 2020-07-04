package com.mimu.springboot.mybatis.generator.mapper.student;

import com.mimu.springboot.mybatis.generator.model.student.StudentInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface StudentInfoMapper {
    @Delete({
            "delete from student_info",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into student_info (no, name, ",
            "sex)",
            "values (#{no,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
            "#{sex,jdbcType=SMALLINT})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    @Select({
            "select",
            "id, no, name, sex",
            "from student_info",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.mimu.springboot.mybatis.generator.mapper.student.StudentInfoMapper.BaseResultMap")
    StudentInfo selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, no, name, sex",
            "from student_info",
            "where no = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.mimu.springboot.mybatis.generator.mapper.student.StudentInfoMapper.BaseResultMap")
    StudentInfo selectByNo(Integer id);

    int updateByPrimaryKeySelective(StudentInfo record);

    @Update({
            "update student_info",
            "set no = #{no,jdbcType=INTEGER},",
            "name = #{name,jdbcType=VARCHAR},",
            "sex = #{sex,jdbcType=SMALLINT}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(StudentInfo record);
}