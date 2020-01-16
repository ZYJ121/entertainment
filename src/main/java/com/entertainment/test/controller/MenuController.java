package com.entertainment.test.controller;

import com.entertainment.test.repo.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuRepo menuRepo;
    @RequestMapping("/getAll")
    public String saveMenu() {
//        System.out.println(data);
        return "12";
    }
}
