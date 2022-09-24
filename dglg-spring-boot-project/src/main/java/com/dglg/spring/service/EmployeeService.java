package com.dglg.spring.service;

import com.dglg.spring.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<Map<String,Object>> getData();

    List<Employee> getAll();

}
