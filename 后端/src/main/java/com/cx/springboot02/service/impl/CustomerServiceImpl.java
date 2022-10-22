package com.cx.springboot02.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.springboot02.pojo.Customer;
import com.cx.springboot02.service.ICustomerService;
import com.cx.springboot02.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 陈翔
 * @since 2022-10-05
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {
    @Autowired
    public CustomerMapper customerMapper;

    /**
     * 登录
     * @return
     */
    @Override
    public boolean login(String name,String password){
        return customerMapper.checkCustomer(name,password) != null;
    }


    /**
     * 通过customer的name属性查询一个Customer对象
     * @param name
     * @return
     */
    @Override
    public Customer selectCustomerByName(String name) {
        return customerMapper.selectCustomerByName(name);
    }


    /**
     * 注册
     * @param name
     * @param password
     * @param code
     */
    @Override
    public void register(String name, String password, String code) {

    }

    @Override
    public void forget(String name, String password, String code) {

    }
}
