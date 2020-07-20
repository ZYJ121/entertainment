package com.entertainment.test.service;

import com.entertainment.test.base.RespEntity;
import com.entertainment.test.base.RespState;
import com.entertainment.test.controller.order.OrderCell;
import com.entertainment.test.entity.DramaSeriesEntity;
import com.entertainment.test.entity.DramaWeekEntity;
import com.entertainment.test.repo.DramaSeriesRepo;
import com.entertainment.test.repo.DramaWeekRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class DramaSeriesService {
    @Autowired
    private DramaSeriesRepo dramaSeriesRepo;
    @Autowired
    private DramaWeekRepo dramaWeekRepo;
    @Autowired
    private EntityManager entityManager;

    //保存dramaSeriesEntity，同时保存更新日期表
    @Transactional(rollbackFor = Exception.class)
    // public DramaSeriesEntity save(DramaSeriesEntity dramaSeriesEntity) {
    public RespEntity save(DramaSeriesEntity dramaSeriesEntity) {
        RespEntity respEntity = RespEntity.One();
        DramaSeriesEntity newDrama = new DramaSeriesEntity();
        try {
            DramaSeriesEntity oldName = dramaSeriesRepo.findByName(dramaSeriesEntity.getName());
            //作品名不重复
            if (oldName == null) {
                dramaSeriesEntity.setCreateTime(new Date());
                dramaSeriesEntity.setUpdateTime(new Date());
                newDrama = dramaSeriesRepo.save(dramaSeriesEntity);
                respEntity.data = newDrama;
                if (dramaSeriesEntity.getRenew() != null && !dramaSeriesEntity.getRenew().equals("")) {
                    String[] renew = dramaSeriesEntity.getRenew().split(",");
                    List<DramaWeekEntity> dwList = new LinkedList<DramaWeekEntity>();
                    for (String weekId : renew) {
                        DramaWeekEntity dramaWeekEntity = new DramaWeekEntity();
                        dramaWeekEntity.setDramaSeriesId(newDrama.getId());
                        dramaWeekEntity.setWeek(Integer.parseInt(weekId));
                        dwList.add(dramaWeekEntity);
                    }
                    if (dwList.size() > 0) {
                        dramaWeekRepo.save(dwList);
                    }
                } else {
                    respEntity.code = RespState.badParams;
                    respEntity.message = "更新日期未填写！";
                }
            } else {
                respEntity.code = RespState.badParams;
                respEntity.message = "作品名重复！";
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respEntity;
    }

    public RespEntity getDramaSeries(int weeks) {
        RespEntity respEntity = RespEntity.One();
        try {
            if (weeks > 0) {
                String sqlString = "SELECT series.* FROM drama_series series LEFT JOIN drama_week weeks ON series.id=weeks.drama_series_id \n" +
                        "WHERE `week`=:weeks ORDER BY series.type";
                System.out.print(sqlString);

                Query query = entityManager.createNativeQuery(sqlString, DramaSeriesEntity.class);

                query.setParameter("weeks", weeks);
                List<DramaSeriesEntity> seriesList = query.getResultList();
                respEntity.data = seriesList;
            }

        } catch (Exception e) {
            respEntity.code = RespState.exception;
            respEntity.message = e.getMessage();
        }
        return respEntity;
    }
}
