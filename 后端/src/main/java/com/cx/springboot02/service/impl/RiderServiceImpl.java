package com.cx.springboot02.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.springboot02.service.IRiderService;
import com.cx.springboot02.mapper.RiderMapper;
import com.cx.springboot02.pojo.Rider;
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
public class RiderServiceImpl extends ServiceImpl<RiderMapper, Rider> implements IRiderService {

}
