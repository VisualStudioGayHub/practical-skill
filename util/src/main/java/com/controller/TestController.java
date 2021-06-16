package com.controller;

import com.jwt.AuthorizationAdminInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zsg
 * @Date: 2021/6/16
 */
@RestController
@RequestMapping("/test")
public class TestController {

    /*
    请求头中放入参数Authorization
    值为token，请求此接口就可以获得用户相关信息
    示例值：eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6ImMwN2Y2MzkxOTJiMWIwNjAwOTFhMzBhOGIzNjkxZDVjIiwicm9sZUlkcyI6IjEzMjE2NDc3NTk5Njc2MTcwMzEiLCJuYW1lIjoiYmpiajAwMDAwMTQiLCJyb2xlTmFtZSI6IuS8geS4mui0puWPtyIsImlkIjo1MzIxLCJleHAiOjE2MjY0MTk3MzEsImlhdCI6MTYyMzgyNzczMSwianRpIjoiNTMyMSJ9.7UXrkWrS-q9Vehv2APrb0_CEis4VIoVAnALLpmyVyN4
     */
    @GetMapping(value = "/jwt")
    public Long jwt(){
        Long userId = AuthorizationAdminInfo.getUserId();
        String account = AuthorizationAdminInfo.getName();
        System.out.println(userId);
        System.out.println(account);
        return userId;
    }

}
