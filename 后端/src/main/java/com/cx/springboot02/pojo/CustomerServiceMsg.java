package com.cx.springboot02.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 陈翔
 * @since 2022-10-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerServiceMsg implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 顾客id
     */
    private Long customerId;

    /**
     * 客服id
     */
    private Long serviceId;

    /**
     * 内容
     */
    private String content;

    /**
     * 发送者是否为顾客
     */
    private Boolean isCustomer;

    /**
     * 是否被删除
     */
    private Boolean isDelete;


}
