package com.livegoods.login.controller;

import com.livegoods.commons.vo.LivegoodsResult;
import com.livegoods.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录服务控制器
 */
@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
     * 用户登录
     * @param username 手机号
     * @param password 验证码
     * @return
     */
    @PostMapping("/login")
    public LivegoodsResult login(String username, String password){
        return loginService.login(username, password);
    }

    /**
     * 发送验证码
     * @param phone 手机号码
     * @return
     */
    @PostMapping("/sendyzm")
    public LivegoodsResult sendyzm(String phone){
        return loginService.sendyzm(phone);
    }
}
