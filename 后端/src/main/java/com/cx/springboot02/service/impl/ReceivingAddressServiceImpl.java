package com.cx.springboot02.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.springboot02.pojo.ReceivingAddress;
import com.cx.springboot02.service.IReceivingAddressService;
import com.cx.springboot02.mapper.Receiving_addressMapper;
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
public class ReceivingAddressServiceImpl extends ServiceImpl<Receiving_addressMapper, ReceivingAddress> implements IReceivingAddressService {

}
