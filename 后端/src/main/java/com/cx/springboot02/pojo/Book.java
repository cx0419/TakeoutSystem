package com.cx.springboot02.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("book")//mp注解 entry对应的table
public class Book {
    @TableField(value = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String type;

    private String name;

    private String description;

//    @TableField(value = "id",select = false,exist = false)
//    private String password;

//    @TableField(exist = false)
//    private Boolean online;

//    @TableLogic(value = "0",delval = "1")//逻辑删除注解 可以在yml当中配置
//    private Integer delete;
//
//    @Version
//    private Integer version;


}
