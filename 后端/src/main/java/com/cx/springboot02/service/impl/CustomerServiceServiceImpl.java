package com.cx.springboot02.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.springboot02.mapper.Customer_service_msgMapper;
import com.cx.springboot02.service.ICustomerServiceService;
import com.cx.springboot02.mapper.Customer_serviceMapper;
import com.cx.springboot02.pojo.CustomerService;
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
public class CustomerServiceServiceImpl extends ServiceImpl<Customer_serviceMapper, CustomerService> implements ICustomerServiceService {

    @Autowired
    Customer_serviceMapper customer_serviceMapper;

    @Override
    public boolean login(String name, String password) {
        return customer_serviceMapper.checkCustomerService(name,password)!=null;
    }
}
