package com.cx.springboot02;

import com.cx.springboot02.controller.BookController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication(scanBasePackages={"com.cx.springboot02.*"})
@MapperScan(basePackages = "com.cx.springboot02.mapper")
public class SSMPApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SSMPApplication.class, args);
        BookController bookController = ctx.getBean(BookController.class) ;
    }

}
