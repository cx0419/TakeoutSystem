package com.cx.springboot02.controller;

import com.cx.springboot02.pojo.Customer;
import com.cx.springboot02.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class HelloController {
//    @Autowired
//    private ICustomerService iCustomerService;
//
//
//    @GetMapping("/get-user")
//    public Customer getUser(@RequestParam String name){
//        return iCustomerService.selectCustomerByName(name);
//    }
//
//    @PreAuthorize("hasAnyRole('user')") // 只能user角色才能访问该方法
//    @GetMapping("/user")
//    public String user(){
//        return "user角色访问";
//    }
//
//    @PreAuthorize("hasAnyRole('admin')") // 只能admin角色才能访问该方法
//    @GetMapping("/admin")
//    public String admin(){
//        return "admin角色访问";
//    }
}
