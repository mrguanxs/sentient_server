package com.hoe.sentient.facade.user.dto;

import lombok.Data;

/**
 * 注册Req
 *
 * @Author Gavin
 * @Date 2021/2/3 10:27 上午
 */
@Data
public class RegisterReq {

    private String username;

    private String email;

    private String password;
}
