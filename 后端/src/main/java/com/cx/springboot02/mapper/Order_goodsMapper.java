package com.cx.springboot02.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cx.springboot02.pojo.OrderGoods;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 陈翔
 * @since 2022-10-05
 */
@Mapper
public interface Order_goodsMapper extends BaseMapper<OrderGoods> {

}
