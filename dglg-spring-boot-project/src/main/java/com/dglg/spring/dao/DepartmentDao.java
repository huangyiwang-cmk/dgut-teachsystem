package com.dglg.spring.dao;

import com.dglg.spring.model.Department;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentDao {

    Department getDepartment(int deptno);

}
