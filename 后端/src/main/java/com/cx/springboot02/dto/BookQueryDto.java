package com.cx.springboot02.dto;

import com.cx.springboot02.mapper.CustomerMapper;
import com.cx.springboot02.pojo.Customer;
import com.cx.springboot02.service.ICustomerService;
import com.cx.springboot02.service.impl.CustomerServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;


@Data
public class BookQueryDto {
    String name;
    Integer[] price;
    int size;
    int page;

    public int offset(){
        return (page-1)*size;
    }
    public int limit(){
        return size;
    }
}


