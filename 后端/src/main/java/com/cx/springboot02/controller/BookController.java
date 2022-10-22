package com.cx.springboot02.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.api.R;
import com.cx.springboot02.dto.BookQueryDto;
import com.cx.springboot02.mapper.BookMapper;
import com.cx.springboot02.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.soap.SAAJResult;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookMapper bookMapper;

    /**
     * 查询单个
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public String getById(@PathVariable String id){
        System.out.println("id为:"+id);
        return "ok";
    }

    @GetMapping("")
    public String getById(){
        HashMap<String,Object> mp =new HashMap<>();
        List<Book> list = bookMapper.selectList(null);
        System.out.println(list.toString());
        mp.put("data", list);
        mp.put("message", "成功");
        return new JSONObject(mp).toString();
    }

    @GetMapping("/fy/1")
    public String getfenye(BookQueryDto bookQueryDto){
        HashMap<String,Object> mp =new HashMap<>();
        List<Book> list = bookMapper.selectList(null);
        System.out.println(list.toString());
        mp.put("data", list);
        mp.put("total", bookMapper.selectCount(null));
        mp.put("message", "成功");
        return new JSONObject(mp).toString();
    }

    /**
     * 删除
     * @return
     */
    @DeleteMapping("")
    public String deleteById(){
        return "ok";
    }

    /**
     * 增加
     * @return
     */
    @PostMapping("")
    public String add(){
        return "ok";
    }


    /**
     * 改
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public String updateAll(@PathVariable String id){
        System.out.println("enter boot...");
        return "ok";
    }



    /**
     * 改
     * @param id
     * @return
     */
    @PatchMapping("/{id}")
    public String update(@PathVariable String id){
        System.out.println("enter boot...");
        return "ok";
    }
}
