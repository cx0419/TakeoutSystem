package com.cx.springboot02.mapper;

import com.cx.springboot02.pojo.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface GoodsMapper extends BaseMapper<Goods> {

}
