package com.livegoods.login.dao.impl;

import com.bjsxt.livegoods.pojo.LoginLog;
import com.livegoods.login.dao.LoginLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

// 用户登录日志数据访问实现
@Repository
public class LoginLogDaoImpl implements LoginLogDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    // 新增登录日志到MongoDB数据库
    @Override
    public void insertLoginLog(LoginLog loginLog) {
        mongoTemplate.save(loginLog);
    }
}
