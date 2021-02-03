package com.hoe.sentient.api.user;

import com.hoe.sentient.common.base.ItemListRecord;
import com.hoe.sentient.common.result.Result;
import com.hoe.sentient.facade.user.AuthFacade;
import com.hoe.sentient.facade.user.UserFacade;
import com.hoe.sentient.facade.user.dto.LoginDTO;
import com.hoe.sentient.facade.user.dto.PartnerDTO;
import com.hoe.sentient.facade.user.dto.RegisterReq;
import com.hoe.sentient.facade.user.req.PwdLoginReq;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 * 登录 Controller
 *
 * @author: Gavin
 * @date: 2021-01-28 16:43:34
 */
@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/api/vs/manage-auth")
public class AuthController {

    @Resource
    private AuthFacade authFacade;

    @PostMapping("/pwd-login")
    public Result<LoginDTO> pwdLogin(@RequestBody PwdLoginReq pwdLoginReq) {
        LoginDTO loginDTO = authFacade.pwdLogin(pwdLoginReq.getUsername(), pwdLoginReq.getPassword());
        return Result.success(loginDTO);
    }

    @PostMapping("/register")
    public Result<LoginDTO> register(@RequestBody RegisterReq registerReq) {
        authFacade.register(registerReq);
        return Result.success();
    }
}
