package com.hoe.sentient.user.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hoe.sentient.user.domain.entity.User;

/**
 *
 * 用户表Repository
 *
 * @author: Gavin
 * @date: 2021-01-28 16:43:34
 */
public interface UserRepository extends IService<User> {

    User getByUsername(String username);

    User getByEmail(String email);
}
