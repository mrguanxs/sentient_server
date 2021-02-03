package com.hoe.sentient.user.service.impl;

import com.hoe.sentient.user.dao.UserRepository;
import com.hoe.sentient.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户表Service实现
 *
 * @author: Gavin
 * @date: 2021-01-28 16:43:34
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

}
