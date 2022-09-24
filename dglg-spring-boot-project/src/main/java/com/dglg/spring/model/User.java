package com.dglg.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
//学生信息类
public class User {

    private String student_id;
    private String student_name;
    private String gender;
    private String grade;
    private String banji;
    private String major;
//    private String training_class_name;

}
