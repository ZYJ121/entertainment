package com.entertainment.test.service;

import com.entertainment.test.repo.EntertainmentRepo;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EntertainmentService {
    @Autowired
    @Qualifier("redisTemplateCustomize")
    private RedisTemplate<String,Object> redisTemplate;
//    @Resource
//    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private EntertainmentRepo entertainmentRepo;

    @Cacheable(cacheNames = "male", key = "#key")
    public String cacheData(String key) {
        String value = entertainmentRepo.findById(1).getMaleLead();
        System.out.println(value);
        return value;
    }
    @CacheEvict(cacheNames = "male", key = "#key")
    public void deleteCache(String key){
        redisTemplate.delete(key);
    }
}
