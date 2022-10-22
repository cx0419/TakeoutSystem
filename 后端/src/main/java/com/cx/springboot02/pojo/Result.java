package com.cx.springboot02.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


/**
 * <p>
 *封装控制器返回对象
 * </p>
 * @author 陈翔
 * @since 2022-10-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Result implements Serializable {
    //返回码
    private Integer code;
    //信息
    private String message;
    //数据
    private Object data;


}
