package com.cx.springboot02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;

    //访问和传值方式：http://127.0.0.1:8080/redis/addName?key=a&value=123456
    //问号后面就是传值
    @GetMapping("addName")
    public String addNmae(@RequestParam String key,@RequestParam String value){
        System.out.println("enter");
        //设置一个值
        redisTemplate.opsForValue().set(key,value);
        //获取一个值
        return redisTemplate.opsForValue().get(key).toString();
    }
    //访问和传值方式：http://127.0.0.1:8080/redis/addName?key=a&value=123456
    //问号后面就是传值
    @GetMapping("deleteName")
    public String deleteNmae(@RequestParam String key){
        //删除一个值,true成功，false失败
        boolean isSuccess=redisTemplate.delete(key);
        //这里测试的话可以获取一个值，看是否删除成功
        Object obj=redisTemplate.opsForValue().get(key);
        return obj==null?"删除成功":"删除失败";
    }
}
