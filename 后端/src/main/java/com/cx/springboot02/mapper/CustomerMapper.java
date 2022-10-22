package com.cx.springboot02.mapper;

import com.cx.springboot02.pojo.Customer;
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
public interface CustomerMapper extends BaseMapper<Customer> {

    Customer checkCustomer(@Param("name") String name,@Param("password")String password);

    Customer selectCustomerByName(@Param("name") String name);


}
