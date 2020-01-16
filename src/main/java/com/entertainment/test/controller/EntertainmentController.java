package com.entertainment.test.controller;

import com.entertainment.test.entity.EntertainmentEntity;
import com.entertainment.test.repo.EntertainmentRepo;
import com.entertainment.test.service.EntertainmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entertainment")
public class EntertainmentController {
    @Autowired
    private EntertainmentRepo entertainmentRepo;
    @Autowired
    private EntertainmentService entertainmentService;

    @Autowired
    @Qualifier("redisTemplateCustomize")
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping("/getAll")
    public List<EntertainmentEntity> getAll() {
        return entertainmentRepo.findAll();
    }

    @RequestMapping("deleteCache")
    public void deleteCache(String key) {
        if(key!=null&&!"".equals(key)){
            entertainmentService.deleteCache(key);
        }
    }

    @RequestMapping("/getValue")
    public String redisCode(String key, String value) {
        if (key != null) {
            if (redisTemplate.hasKey(key)) {
                value = redisTemplate.opsForValue().get(key).toString();
                System.out.println(value);
            } else {
//                redisTemplate.opsForValue().set(key, value);
                value = entertainmentService.cacheData(key);
            }

            return "key = " + key + " value = " + value;
        } else {
            return "没有参数";
        }

    }
}
