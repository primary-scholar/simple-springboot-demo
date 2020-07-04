package com.mimu.springboot.mybatis.generator.mapper.student;

import com.mimu.springboot.mybatis.generator.model.student.ClassInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface ClassInfoMapper {
    @Delete({
            "delete from class_info",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into class_info (academy, grade)",
            "values (#{academy,jdbcType=VARCHAR}, #{grade,jdbcType=VARCHAR})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(ClassInfo record);

    int insertSelective(ClassInfo record);

    @Select({
            "select",
            "id, academy, grade",
            "from class_info",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.mimu.springboot.mybatis.generator.mapper.student.ClassInfoMapper.BaseResultMap")
    ClassInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassInfo record);

    @Update({
            "update class_info",
            "set academy = #{academy,jdbcType=VARCHAR},",
            "grade = #{grade,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ClassInfo record);
}