package com.hoe.sentient.facade.user;

import com.hoe.sentient.user.dao.UserExtensionRepository;
import com.hoe.sentient.user.service.UserExtensionService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 用户扩展表Facade
 *
 * @author: Gavin
 * @date: 2021-01-28 16:44:00
 */
@Component
public class UserExtensionFacade {
    @Resource
    private UserExtensionService userExtensionService;
    @Resource
    private UserExtensionRepository userExtensionRepository;


}
