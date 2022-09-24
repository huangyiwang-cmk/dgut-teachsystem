package com.dglg.spring.controller;

import com.dglg.spring.model.Scores;
import com.dglg.spring.service.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ScoresController {
    @Autowired
    private ScoresService scoresService;

    Scores scores = new Scores();

    @RequestMapping(value = "/IndividualScoresImport", method = RequestMethod.POST)
    public Scores addIndividualscores(@RequestBody Map<String, Integer> map) {

        scores.setAttendance_points(map.get("attendance_points"));
        scores.setGuidance_points(map.get("guidance_points"));
        scores.setClasspeformance_score(map.get("classpeformance_score"));

        scores.Individual_scores = (double) (scores.attendance_points * 0.3 + scores.guidance_points * 0.3 + scores.classpeformance_score *0.4);//个人得分
        System.out.println(scores);
        return scores;
    }

    @RequestMapping(value = "/TeachergroupScoresImport", method = RequestMethod.POST)
    public Scores addteachergroupscores(@RequestBody Map<String, Integer> map) {

        scores.setTeachergroup_score_1(map.get("teachergroup_score_1"));
        scores.setTeachergroup_score_2(map.get("teachergroup_score_2"));
        scores.setTeachergroup_score_3(map.get("teachergroup_score_3"));
        scores.setTeachergroup_score_4(map.get("teachergroup_score_4"));

        scores.teachergroup_score =(double)(scores.teachergroup_score_1 * 0.2 + scores.teachergroup_score_2 * 0.2+
                scores.teachergroup_score_3 * 0.5+ scores.teachergroup_score_4 * 0.1);//教师小组评分
        System.out.println(scores);
        return scores;
    }

    @RequestMapping(value = "/ExpertpanelScoresImport", method = RequestMethod.POST)
    public Scores addexpertpanel_rating(@RequestBody Map<String, Integer> map) {

        scores.setExpertpanel_rating_1(map.get("expertpanel_rating_1"));
        scores.setExpertpanel_rating_2(map.get("expertpanel_rating_2"));
        scores.setExpertpanel_rating_3(map.get("expertpanel_rating_3"));
        scores.setExpertpanel_rating_4(map.get("expertpanel_rating_4"));
        scores.setExpertpanel_rating_5(map.get("expertpanel_rating_5"));
        scores.setExpertpanel_rating_6(map.get("expertpanel_rating_6"));
        scores.setExpertpanel_rating_7(map.get("expertpanel_rating_7"));
        scores.setExpertpanel_rating_8(map.get("expertpanel_rating_8"));

        scores.expertpanel_rating =(double)(scores.expertpanel_rating_1 * 0.1 + scores.expertpanel_rating_2 * 0.1+
                scores.expertpanel_rating_3 * 0.1+ scores.expertpanel_rating_4 * 0.2 + scores.expertpanel_rating_5 *0.1 + scores.expertpanel_rating_6 *0.2+
                scores.expertpanel_rating_7 * 0.1 + scores.expertpanel_rating_8 * 0.1);//专家小组评分

        scores.group_scores = scores.teachergroup_score * 0.5 + scores.expertpanel_rating * 0.5;//小组得分
        scores.composite_score =scores.Individual_scores * 0.3 + scores.group_scores * 0.3 + scores.expertpanel_rating * 0.4;//综合得分
        System.out.println(scores);
        return scores;
    }




}
