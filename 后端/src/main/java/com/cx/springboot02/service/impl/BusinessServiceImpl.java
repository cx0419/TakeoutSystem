package com.cx.springboot02.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.springboot02.service.IBusinessService;
import com.cx.springboot02.mapper.BusinessMapper;
import com.cx.springboot02.pojo.Business;
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
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements IBusinessService {

    @Autowired
    BusinessMapper businessMapper;

    @Override
    public Business selectBusinessById(Long id) {
        return businessMapper.selectBusinessById(id);
    }

    @Override
    public boolean login(String name, String password) {
        return businessMapper.checkBusiness(name,password) != null;
    }
}
