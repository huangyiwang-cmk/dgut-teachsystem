package com.dglg.spring.controller;


import com.dglg.spring.dao.DepartmentDao;
import com.dglg.spring.model.User;
import com.dglg.spring.service.EmployeeService;
import com.dglg.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentDao departmentDao;

    @PostMapping("/insert")
    public int insert(User user) {
        return this.userService.insert(user);
    }

    @PostMapping("/update")
    public int update(User user) {
        return this.userService.update(user);
    }

    @GetMapping("/delete/{student_id}")
    public int delete(@PathVariable("student_id") String student_id) {
        return this.userService.delete(student_id);
    }

    @GetMapping("/getUser/{student_id}")
    public User getUser(@PathVariable("student_id") String student_id) {
        return this.userService.getUser(student_id);
    }


//    @GetMapping("/getData1/{id}")
//    public Map<String, Object> getData1(@PathVariable("id") int id) {
//        Map<String, Object> result = new HashMap<>();
//        result.put("code", 20000);
//        result.put("msg", "Operate Success !");
//        result.put("data", this.userService.getData(id));
//        return result;
//    }
//
//    @GetMapping("/getData2")
//    public Map<String, Object> getData2() {
//        Map<String, Object> result = new HashMap<>();
//        result.put("code", 20000);
//        result.put("msg", "Operate Success !");
//        result.put("data", this.employeeService.getData());
//        return result;
//    }
//
//
//    @GetMapping("/getData3")
//    public Map<String, Object> getData3() {
//        Map<String, Object> result = new HashMap<>();
//        result.put("code", 20000);
//        result.put("msg", "Operate Success !");
//        result.put("data", this.employeeService.getAll());
//        return result;
//    }

    @GetMapping("/getData4/{id}")
    public Map<String, Object> getData4(@PathVariable("id") int id) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 20000);
        result.put("msg", "Operate Success !");
        result.put("data", this.departmentDao.getDepartment(id));
        return result;
    }
}
