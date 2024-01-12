package com.hoe.sentient.api.controller.user;

import com.hoe.sentient.common.result.Result;
import com.hoe.sentient.facade.user.UserFacade;
import com.hoe.sentient.facade.user.dto.UserDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 *
 * 用户表 Controller
 *
 * @author: Gavin
 * @date: 2021-01-28 16:43:34
 */
@RestController
@Validated
@RequestMapping("/api/vs/manage-user")
public class UserManageController {
    @Resource
    private UserFacade userFacade;

    /**
     * 获取单个用户表
     *
     * @param id
     * @return 用户表
     */
//    @ApiOperation(value = "获取单个用户表", notes = "获取单个用户表")
    @GetMapping("/users/{id}")
    public Result<UserDTO> getUser(
            @PathVariable(value = "id") Long id) {
        UserDTO entityDTO = userFacade.getUser(id);
        return Result.success(entityDTO);
    }

}
