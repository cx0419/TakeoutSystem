package com.cx.springboot02.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cx.springboot02.pojo.Customer;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 陈翔
 * @since 2022-10-05
 */
public interface ICustomerService extends IService<Customer> {
    //验证登录
    boolean login(String name,String password);
    //通过name获取customer信息
    Customer selectCustomerByName(String name);

    void register(String name,String password,String code);


    void forget(String name,String password,String code);

}
