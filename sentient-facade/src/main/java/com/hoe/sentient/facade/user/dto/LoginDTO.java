package com.hoe.sentient.facade.user.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 *
 * 登录DTO
 *
 * @author: Gavin
 * @date: 2021-01-28 16:43:34
 */
@Data
public class LoginDTO {

    /**
     *
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 令牌
     */
    private String token;

}
