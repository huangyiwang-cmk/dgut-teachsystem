package com.dglg.spring.service.impl;

import com.dglg.spring.dao.ExcelDao;
import com.dglg.spring.model.Student;
import com.dglg.spring.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ExcelServicelmrl implements ExcelService {

    @Autowired
    public ExcelDao excelDao;
    @Override
    public Student student(int j, String cell,Student student) {
//        Student student = new Student();
        switch (j) {
            case 0:
                student.setStudent_id(cell);
                break;
            case 1:
                student.setStudent_name(cell);
                break;
            case 2:
                student.setGender(cell);
                break;
            case 3:
                student.setGrade(cell);
                break;
            case 4:
                student.setBanji(cell);
                break;
            case 5:
                student.setMajor(cell);
                break;
            default:
                student = null;
        }
        return student;
    }
    @Override
    public int addStudent(List<Student> list){
        return this.excelDao.addStudent(list);
    }
}
