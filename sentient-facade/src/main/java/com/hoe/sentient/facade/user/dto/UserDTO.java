package com.hoe.sentient.facade.user.dto;

import com.hoe.sentient.common.base.AbstractCreateAndUpdateDTO;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * 用户表DTO
 *
 * @author: Gavin
 * @date: 2021-01-28 16:43:34
 */
@Data
public class UserDTO extends AbstractCreateAndUpdateDTO {

    /**
     *
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 国别号
     */
    private String region;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 生日
     */
    private LocalDate birthday;

}
