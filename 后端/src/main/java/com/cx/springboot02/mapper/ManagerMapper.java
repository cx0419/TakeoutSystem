package com.cx.springboot02.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cx.springboot02.pojo.Manager;
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
public interface ManagerMapper extends BaseMapper<Manager> {
    Manager checkManage(@Param("name") String name, @Param("password")String password);
}
