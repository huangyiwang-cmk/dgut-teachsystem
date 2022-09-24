package com.dglg.spring.dao;

import com.dglg.spring.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {

    int insert(User user);

    int update(User user);

    int delete(String student_id);

    User getUser(String student_id);

    List<Map<String, Object>> getData(int id);
}
