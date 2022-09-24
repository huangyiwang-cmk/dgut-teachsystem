package com.dglg.spring.service.impl;

import com.dglg.spring.dao.ScoresDao;
import com.dglg.spring.model.Scores;
import com.dglg.spring.service.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoresServiceIml implements ScoresService {
    @Autowired
    private ScoresDao scoresDao;

    @Override
    public int addScores(Scores scores) {
        return 0;
    }
}
