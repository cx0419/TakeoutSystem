package com.cx.springboot02.controller;


import com.cx.springboot02.pojo.Business;
import com.cx.springboot02.service.IBusinessMsgService;
import com.cx.springboot02.service.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 陈翔
 * @since 2022-10-05
 */
@RestController
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    IBusinessService iBusinessMsgService;

    @GetMapping("{id}")
    public Business selectBusinessById(@PathVariable Long id){
        Business business = iBusinessMsgService.selectBusinessById(id);
        return business;
    }

}

