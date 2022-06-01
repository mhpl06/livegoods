package com.livegoods.login.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 用户登录验证码
 */
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class ValidateCode {
    private String phone; // 手机号
    private String validateCode; // 验证码
}
