package com.dglg.spring.service.impl;

import com.dglg.spring.dao.EmployeeDao;
import com.dglg.spring.model.Employee;
import com.dglg.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Map<String, Object>> getData() {
        return this.employeeDao.getData();
    }

    @Override
    public List<Employee> getAll() {
        return this.employeeDao.getAll();
    }
}
