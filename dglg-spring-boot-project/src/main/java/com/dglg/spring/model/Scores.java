package com.dglg.spring.model;

import lombok.Data;

@Data
public class Scores {

    public int attendance_points;//出勤分
    public int guidance_points;//辅导教学分
    public int classpeformance_score;//课堂表现分

    public int teachergroup_score_1;//界面美观
    public int teachergroup_score_2;//文档
    public int teachergroup_score_3;//成果水平
    public int teachergroup_score_4;//ppt

    public int expertpanel_rating_1;//数学与专业基础
    public int expertpanel_rating_2;//实验设计
    public int expertpanel_rating_3;//工具使用
    public int expertpanel_rating_4;//设计算法
    public int expertpanel_rating_5;//项目管理
    public int expertpanel_rating_6;//解决复杂问题
    public int expertpanel_rating_7;//技术前沿
    public int expertpanel_rating_8;//职业伦理

    public double teachergroup_score;//教师小组评分
    public double expertpanel_rating;//专家小组评分

    public double Individual_scores;//个人分数
    public double group_scores;//小组分数
    public double composite_score;//综合分数
}
