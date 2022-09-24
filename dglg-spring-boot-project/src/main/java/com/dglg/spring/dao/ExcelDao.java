package com.dglg.spring.dao;

import com.dglg.spring.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface ExcelDao {
   public int addStudent(List<Student> list);
}

