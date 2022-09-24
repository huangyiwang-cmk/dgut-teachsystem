package com.dglg.spring.service;

import com.dglg.spring.model.Student;

import java.util.List;

public interface ExcelService {
    public Student student(int j,String cell,Student student);

    int addStudent(List<Student> list);
}
