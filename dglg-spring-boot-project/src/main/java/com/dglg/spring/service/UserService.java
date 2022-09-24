package com.dglg.spring.service;

import com.dglg.spring.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    int insert(User user);

    int update(User user);

    int delete(String student_id);

    User getUser(String student_id);

    List<Map<String, Object>> getData(int id);


}
