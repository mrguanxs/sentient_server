package com.hoe.sentient.user.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hoe.sentient.user.domain.entity.UserExtension;
import com.hoe.sentient.user.mapper.UserExtensionMapper;
import com.hoe.sentient.user.dao.UserExtensionRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户扩展表Repository实现
 *
 * @author: Gavin
 * @date: 2021-01-28 16:44:00
 */
@Repository
public class UserExtensionRepositoryImpl extends ServiceImpl<UserExtensionMapper, UserExtension> implements UserExtensionRepository {

}


