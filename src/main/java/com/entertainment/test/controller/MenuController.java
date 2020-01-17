package com.entertainment.test.controller;
import com.alibaba.fastjson.JSON;
import com.entertainment.test.entity.MenuEntity;
import com.entertainment.test.repo.MenuRepo;
import com.entertainment.test.utility.DateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuRepo menuRepo;
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public MenuEntity saveMenu(String data) {
        System.out.println(data);
        MenuEntity menuEntity= JSON.parseObject(data,MenuEntity.class);
        menuEntity.setCreateTime(DateUtility.now());
        menuEntity.setUpdateTime(DateUtility.now());
        menuRepo.saveAndFlush(menuEntity);
        return menuEntity;
    }
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<MenuEntity> getAll(){
        List<MenuEntity> menuEntities=menuRepo.findAll();
        return menuEntities;
    }
}
