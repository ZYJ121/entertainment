package com.entertainment.test.service;

import com.entertainment.test.entity.DramaSeriesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class DramaWeekService {
    @Autowired
    private EntityManager entityManager;
    public List<Integer> getWeeks(){
        List<Integer> weeksList=new ArrayList<>();
        String sqlString = "SELECT `week` FROM `drama_week` group by `week` order by `week`";
        System.out.print(sqlString);

        weeksList = entityManager.createNativeQuery(sqlString).getResultList();

        return weeksList;
    }
}
