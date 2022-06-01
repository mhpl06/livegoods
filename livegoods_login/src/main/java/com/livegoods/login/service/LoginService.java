package com.livegoods.login.service;

import com.livegoods.commons.vo.LivegoodsResult;

// 用户登录相关服务接口
public interface LoginService {
    // 发送验证码
    LivegoodsResult sendyzm(String phone);
    // 用户登录
    LivegoodsResult login(String username, String password);
}
