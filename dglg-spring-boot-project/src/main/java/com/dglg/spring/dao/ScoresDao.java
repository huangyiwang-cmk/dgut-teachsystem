package com.dglg.spring.dao;

import com.dglg.spring.model.Scores;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScoresDao {
    int addScores(Scores scores);
}
