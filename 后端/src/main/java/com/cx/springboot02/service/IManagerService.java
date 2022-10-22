package com.cx.springboot02.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cx.springboot02.pojo.Manager;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 陈翔
 * @since 2022-10-05
 */
public interface IManagerService extends IService<Manager> {
    boolean login(String name,String password);
}
