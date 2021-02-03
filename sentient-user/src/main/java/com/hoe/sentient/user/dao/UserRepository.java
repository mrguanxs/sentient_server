package com.hoe.sentient.user.dao;

import com.hoe.sentient.common.base.IRepository;
import com.hoe.sentient.user.domain.entity.User;

/**
 *
 * 用户表Repository
 *
 * @author: Gavin
 * @date: 2021-01-28 16:43:34
 */
public interface UserRepository extends IRepository<User> {

    User getByUsername(String username);

    User getByEmail(String email);
}
