package com.cx.springboot02.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.springboot02.pojo.CustomerServiceMsg;
import com.cx.springboot02.service.ICustomerServiceMsgService;
import com.cx.springboot02.mapper.Customer_service_msgMapper;
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
public class CustomerServiceMsgServiceImpl extends ServiceImpl<Customer_service_msgMapper, CustomerServiceMsg> implements ICustomerServiceMsgService {

}
