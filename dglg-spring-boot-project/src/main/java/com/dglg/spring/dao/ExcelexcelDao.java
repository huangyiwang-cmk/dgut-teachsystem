package com.dglg.spring.dao;

import com.dglg.spring.model.Exportexcel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ExcelexcelDao {
    @Select("select student_id,student_name,gender,grade,class as banji,major from student")
    List<Exportexcel> finAll();
}
