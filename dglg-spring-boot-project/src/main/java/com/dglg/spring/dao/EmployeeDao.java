package com.dglg.spring.dao;

import com.dglg.spring.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmployeeDao {

    Employee getEmployee(int empno);

    Employee getEmployeeByEname(String ename);

    /**
     * @param sql: select * from employee where empno = 7369
     */
    Employee getEmployeeBySQL(String sql);

    List<Employee> getEmployees();

    List<Employee> getEmployeesByParams(@Param("ename") String ename, @Param("job") String job);

    List<Employee> getEmployeesByFilter(@Param("ename") String ename, @Param("job") String job);

    List<Employee> getEmployeesByIds(List<Integer> ids);

    List<Map<String,Object>> getData();

    List<Employee> getAll();
}
