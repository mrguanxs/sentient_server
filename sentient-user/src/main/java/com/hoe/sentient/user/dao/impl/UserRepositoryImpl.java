package com.hoe.sentient.user.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hoe.sentient.user.dao.UserRepository;
import com.hoe.sentient.user.domain.entity.User;
import com.hoe.sentient.user.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
 * 用户表Repository实现
 *
 * @author: Gavin
 * @date: 2021-01-28 16:43:34
 */
@Repository
public class UserRepositoryImpl extends ServiceImpl<UserMapper, User> implements UserRepository {

}


