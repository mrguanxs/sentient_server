package com.hoe.sentient.facade.user;

import com.hoe.sentient.common.util.GeneralAssembler;
import com.hoe.sentient.common.util.IDUtils;
import com.hoe.sentient.facade.user.dto.LoginDTO;
import com.hoe.sentient.facade.user.dto.RegisterReq;
import com.hoe.sentient.facade.user.dto.UserDTO;
import com.hoe.sentient.facade.user.req.PwdLoginReq;
import com.hoe.sentient.user.dao.UserRepository;
import com.hoe.sentient.user.domain.entity.User;
import com.hoe.sentient.user.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * 权限Facade
 *
 * @author: Gavin
 * @date: 2021-01-28 16:43:34
 */
@Component
public class AuthFacade {
    @Resource
    private UserService userService;
    @Resource
    private UserRepository userRepository;

    /**
     * 密码登录
     * @param username
     * @param password
     * @return
     */
    public LoginDTO pwdLogin(String username, String password) {
        User user = userRepository.getByUsername(username);
        LoginDTO loginDTO = null;
        if(user != null && !user.getStopFlag()){
            //todo 验证密码
            loginDTO =new LoginDTO();
            loginDTO.setId(user.getId());
            loginDTO.setUsername(user.getUsername());
        }else {
            throw new RuntimeException("登录失败");
        }

        return loginDTO;
    }

    public void register(RegisterReq registerReq) {
        User nameUser = null;
        if(!StringUtils.isEmpty(registerReq.getUsername())){
            nameUser = userRepository.getByUsername(registerReq.getUsername());
        }
        User emailUser = userRepository.getByEmail(registerReq.getEmail());
        if(nameUser != null || emailUser != null){
            throw new RuntimeException("用户已存在");
        }
        User user = new User();
        user.setId(IDUtils.generateId());
        user.setUsername(registerReq.getUsername());
        if(StringUtils.isEmpty(registerReq.getUsername())){
            user.setUsername(registerReq.getEmail().split("@")[0]);
        }
        user.setEmail(registerReq.getEmail());
        user.setPassword(registerReq.getPassword());
        userRepository.save(user);
    }
}
