package com.dglg.spring.model;

import lombok.Data;

@Data
public class Exportexcel {
    private String student_id;
    private String student_name;
    private String gender;
    private String grade;
    private String banji;
    private String major;

    public String getstudent_id() {
        return student_id;
    }

    public void setstudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getstudent_name() {
        return student_name;
    }

    public void setstudent_name(String student_name) {
        this.student_name = student_name;

    }

    public String getgender() {
        return gender;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }

    public String getgrade() {
        return grade;
    }

    public void setgrade(String grade) {
        this.grade= grade;
    }
    public String getbanji() {
        return banji;
    }

    public void setbanji(String banji) {
        this.banji = banji;
    }
    public String getmajor() {
        return major;
    }

    public void setmajor(String major) {
        this.major = major;
    }
}
