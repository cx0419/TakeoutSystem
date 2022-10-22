package com.cx.springboot02.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.springboot02.service.IBusinessMsgService;
import com.cx.springboot02.mapper.Business_msgMapper;
import com.cx.springboot02.pojo.BusinessMsg;
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
public class BusinessMsgServiceImpl extends ServiceImpl<Business_msgMapper, BusinessMsg> implements IBusinessMsgService {

}
