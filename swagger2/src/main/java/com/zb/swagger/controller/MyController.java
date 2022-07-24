package com.zb.swagger.controller;

import com.zb.swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO
 * @author: ZB
 * @create: 2022-07-24 21:24
 */
@Api(tags = "测试swagger2相关的控制类")
@RestController
public class MyController {

    @GetMapping("/get")
    public String get() {
        return "get";
    }

    @ApiOperation("POST测试方法")
    @PostMapping("/post")
    public User post(@ApiParam("密码")String password) {
        return new User("zhaobin", password);
    }

//    @RequestMapping("/hello")
//    public String hello(){
//        return "hello";
//    }

}

