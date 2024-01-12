package com.hoe.sentient.facade.user;

import com.hoe.sentient.common.util.GeneralAssembler;
import com.hoe.sentient.facade.user.dto.UserDTO;
import com.hoe.sentient.user.dao.UserRepository;
import com.hoe.sentient.user.domain.entity.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 用户表Facade
 *
 * @author: Gavin
 * @date: 2021-01-28 16:43:34
 */
@Component
public class UserFacade {
    @Resource
    private UserRepository userRepository;

    public UserDTO getUser(Long id) {
        User user = userRepository.getById(id);
        if(user == null || user.getStopFlag()){
            user = null;
        }
        return new GeneralAssembler<>(UserDTO.class).convertFrom(user);
    }
}
