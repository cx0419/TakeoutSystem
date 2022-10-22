package com.cx.springboot02.controller;


import com.cx.springboot02.common.JsonResult;
import com.cx.springboot02.common.ResultCode;
import com.cx.springboot02.common.ResultTool;
import com.cx.springboot02.common.utils.*;
import com.cx.springboot02.pojo.Customer;
import com.cx.springboot02.pojo.Result;
import com.cx.springboot02.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 陈翔
 * @since 2022-10-05
 */
@RestController
@RequestMapping("/customer")
@PreAuthorize(values = {AuthorizeType.CUSTOMER})
public class CustomerController {

    @Autowired
    RedisOperator redisOperator;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    ICustomerService iCustomerService;
    //登录请求

    @GetMapping("/{name}")
    public  JsonResult<Object> login(@PathVariable String name){
        JsonResult<Object> jsonResult = new JsonResult<>();
        System.out.println("enter");
        Customer customer = iCustomerService.selectCustomerByName(name);
        jsonResult.setData(customer);
        return jsonResult;
    }

    @PostMapping("/login")
    @Unobstructed
    public JsonResult<Object> login(String name, String password){
        if(iCustomerService.login(name, password)){
            //生成token
            String token = jwtUtils.createToken(name, password);
            //存入redis
            redisOperator.set(name+":token", token);
            return ResultTool.success(null);
        }else{
            return ResultTool.fail(ResultCode.USER_CREDENTIALS_ERROR);
        }
    }


    public  JsonResult<Object>  getCustomer(String name){
        JsonResult<Object> jsonResult = new JsonResult<>();
        HashMap<String,Object> mp = new HashMap<>();

        return jsonResult;
    }


}

