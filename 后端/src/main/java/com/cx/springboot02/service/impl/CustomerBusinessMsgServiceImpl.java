package com.cx.springboot02.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.springboot02.pojo.CustomerBusinessMsg;
import com.cx.springboot02.service.ICustomerBusinessMsgService;
import com.cx.springboot02.mapper.Customer_business_msgMapper;

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
public class CustomerBusinessMsgServiceImpl extends ServiceImpl<Customer_business_msgMapper, CustomerBusinessMsg> implements ICustomerBusinessMsgService {

}
