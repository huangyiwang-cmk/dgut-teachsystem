package com.dglg.spring.service.impl;

import com.dglg.spring.dao.UserDao;
import com.dglg.spring.model.User;
import com.dglg.spring.service.EmployeeService;
import com.dglg.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;


    @Override
    public int insert(User user) {
        return this.userDao.insert(user);
    }

    @Override
    public int update(User user) {
        return this.userDao.update(user);
    }

    @Override
    public int delete(String student_id) {
        return this.userDao.delete(student_id);
    }

    @Override
    public User getUser(String student_id) {
        return this.userDao.getUser(student_id);
    }

    @Override
    public List<Map<String, Object>> getData(int id) {
        return this.userDao.getData(id);
    }
}
