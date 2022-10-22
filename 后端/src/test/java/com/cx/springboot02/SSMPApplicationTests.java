package com.cx.springboot02;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.springboot02.mapper.BookMapper;
import com.cx.springboot02.pojo.Book;
import com.cx.springboot02.pojo.Business;
import com.cx.springboot02.pojo.Customer;
import com.cx.springboot02.service.IBusinessService;
import com.cx.springboot02.service.ICustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SSMPApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws Exception{
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        System.out.println(dataSource.toString());
        //template模板，拿来即用
        connection.close();
    }

    @Autowired
    BookMapper bookMapper;
    @Test
    public void toTest(){

//        Book book = bookMapper.selectById(1);
//        System.out.println(book.toString());
        List<Book> list = bookMapper.selectList(null);
        System.out.println(list.toString());

    }

    @Test
    public void MPadd(){
        Book book = new Book();
        book.setName("三国演义");
        book.setType("历史");
        book.setDescription("111");
        bookMapper.insert(book);
    }

    @Test
    public void update(){
        Book book = new Book();
        book.setId(2);
        book.setType("小说");
        bookMapper.updateById(book);
    }
    @Test
    public void delete(){
        bookMapper.deleteById(1);

    }

    @Test
    public void FenYeTest(){
        Integer i = 0;
        Page<Book> page = new Page(1,10);
        //方式1
        QueryWrapper queryWrapper = new QueryWrapper();
        List<Book> list = (List<Book>) bookMapper.selectPage(page,queryWrapper);
        //方式2
        QueryWrapper<Book> queryWrapper1 = new QueryWrapper();
        queryWrapper1.lambda().lt(Book::getId, 1);


        //方式3
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        //10 - 30 之间
        lqw.lt(Book::getId, 30).gt(Book::getId,10);
        // <=10 or >=30
        lqw.lt(Book::getId, 10).or().gt(Book::getId, 30);



        List<Book> list1 = bookMapper.selectList(lqw);

    }

    @Test
    public void NullCheck(){
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
//        投影
//        lqw.select(Book::getId,Book::getName,Book::getType);
        lqw.gt(Book::getId, 1).lt(Book::getId,3);
        List<Book> list = bookMapper.selectList(lqw);
        System.out.println(list.toString());
        List<Map<String,Object>> mapList = bookMapper.selectMaps(lqw);

        QueryWrapper<Book> qw = new QueryWrapper();

        qw.select("count(*)");
        List<Map<String,Object>> mapList1 = bookMapper.selectMaps(lqw);
        System.out.println(mapList1.toString());
    }

    /**
     * 多行删除
     */
    @Test
    public void DeleteMuch(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        bookMapper.deleteBatchIds(list);
    }


    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    IBusinessService iBusinessMsgService;
    @Test
    public void selectCustomer(){
        Customer customer = iCustomerService.selectCustomerByName("123");
        Business business = iBusinessMsgService.selectBusinessById(1L);
        System.out.println(customer);
        System.out.println(business);

    }







}
