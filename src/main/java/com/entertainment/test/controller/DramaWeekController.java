package com.entertainment.test.controller;

import com.entertainment.test.base.RespEntity;
import com.entertainment.test.base.RespState;
import com.entertainment.test.service.DramaWeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/drama/week")
public class DramaWeekController {
    @Autowired
    private DramaWeekService dramaWeekService;
    @RequestMapping(method = RequestMethod.GET)
    public RespEntity getWeeks(){
        RespEntity respEntity=RespEntity.One();
        try{
            respEntity.data=dramaWeekService.getWeeks();
        }catch (Exception e){
            respEntity.code= RespState.exception;
            respEntity.message=e.getMessage();
        }
        return respEntity;
    }
}
