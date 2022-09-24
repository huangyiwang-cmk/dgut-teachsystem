package com.dglg.spring.model;

import lombok.Data;

@Data
public class Class {

    private Integer id;
    private String class_name;
    private String period;
    private String grade;
    private String teacher_name;
    private String start_time;
    private String end_time;
}
