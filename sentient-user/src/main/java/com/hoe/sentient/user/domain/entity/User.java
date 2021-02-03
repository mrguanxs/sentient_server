package com.hoe.sentient.user.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hoe.sentient.common.base.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 *
 * 用户表
 *
 * @author: Gavin
 * @date: 2021-01-28 16:43:34
 */
@Data
@TableName("user")
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity {

    /**
     *
     */
    @TableId
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
