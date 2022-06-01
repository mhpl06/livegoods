package com.livegoods.login.redisdao;

import com.livegoods.login.pojo.ValidateCode;

// 用户登录验证码数据访问接口， 访问redis
public interface ValidateCodeDao {
    // 存储验证码到redis。 验证码有效时间设置为2分钟。
    void set(String key, Object value);
    // 根据用户手机号，从redis中查询验证码
    ValidateCode get(String key);
    // 删除验证码
    Boolean delete(String key);
}
