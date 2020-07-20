package com.entertainment.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.entertainment.test.base.RespEntity;
import com.entertainment.test.base.RespState;
import com.entertainment.test.entity.DramaSeriesEntity;
import com.entertainment.test.repo.DramaSeriesRepo;
import com.entertainment.test.service.DramaSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/series")
public class DramaSeriesController {
    @Autowired
    private DramaSeriesRepo dramaSeriesRepo;
    @Autowired
    private DramaSeriesService dramaSeriesService;

    @RequestMapping(value = "/getSeriesByState/{seriesState}", method = RequestMethod.GET)
    public RespEntity getSeriesByState(@PathVariable Integer seriesState) {
        RespEntity respEntity = RespEntity.One();
        try {
            if (seriesState != null && seriesState >= 0) {
                List<DramaSeriesEntity> all = dramaSeriesRepo.findBySeriesState(seriesState);
                respEntity.data = all;
            } else {
                respEntity.code = RespState.badParams;
                respEntity.message = "请求参数错误!";
            }

        } catch (Exception e) {
            respEntity.code = RespState.exception;
            respEntity.message = e.getMessage();
        }
        return respEntity;
    }

    /**
     * 查询周几更新什么节目
     *
     * @param weeks 周几
     * @return
     */
    @RequestMapping(value = "/{weeks}", method = RequestMethod.GET)
    public RespEntity getForWeek(@PathVariable int weeks) {
        RespEntity respEntity = dramaSeriesService.getDramaSeries(weeks);
        return respEntity;
    }

    //保存节目及更新时间
    @RequestMapping(method = RequestMethod.POST)
    public RespEntity save(String data) {
        RespEntity respEntity = RespEntity.One();
        try {
            DramaSeriesEntity dramaSeriesEntity = JSONObject.parseObject(data, DramaSeriesEntity.class);
            respEntity = dramaSeriesService.save(dramaSeriesEntity);
        } catch (Exception e) {
            respEntity.code = RespState.exception;
            respEntity.message = e.getMessage();
        }
        return respEntity;
    }
}
