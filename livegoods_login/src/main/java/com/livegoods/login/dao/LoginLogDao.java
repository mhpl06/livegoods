package com.livegoods.login.dao;

import com.bjsxt.livegoods.pojo.LoginLog;

// 用户登录数据访问接口
public interface LoginLogDao {
    // 新增登录日志到MongoDB
    void insertLoginLog(LoginLog loginLog);
}
