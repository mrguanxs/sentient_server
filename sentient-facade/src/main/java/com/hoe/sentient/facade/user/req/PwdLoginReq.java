package com.hoe.sentient.facade.user.req;

import lombok.Data;

/**
 * 密码登录请求
 *
 * @Author Gavin
 * @Date 2021/2/3 10:09 上午
 */
@Data
public class PwdLoginReq {

    private String username;

    private String password;
}
