package com.cx.springboot02.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.springboot02.pojo.OrderGoods;
import com.cx.springboot02.service.IOrderGoodsService;
import com.cx.springboot02.mapper.Order_goodsMapper;
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
public class OrderGoodsServiceImpl extends ServiceImpl<Order_goodsMapper, OrderGoods> implements IOrderGoodsService {

}
