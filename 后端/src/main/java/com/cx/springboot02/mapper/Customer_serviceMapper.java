package com.cx.springboot02.mapper;

import com.cx.springboot02.pojo.CustomerService;
import com.cx.springboot02.pojo.CustomerServiceMsg;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 陈翔
 * @since 2022-10-05
 */
@Mapper
public interface Customer_serviceMapper extends BaseMapper<CustomerService> {
    CustomerService checkCustomerService(@Param("name") String name, @Param("password")String password);
}
