package com.hoe.sentient.user.service.impl;

import com.hoe.sentient.user.dao.UserExtensionRepository;
import com.hoe.sentient.user.service.UserExtensionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户扩展表Service实现
 *
 * @author: Gavin
 * @date: 2021-01-28 16:44:00
 */
@Service
public class UserExtensionServiceImpl implements UserExtensionService {
    @Resource
    private UserExtensionRepository userExtensionRepository;

}
