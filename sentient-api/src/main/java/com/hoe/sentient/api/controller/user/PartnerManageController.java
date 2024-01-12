package com.hoe.sentient.api.controller.user;

import com.hoe.sentient.common.base.ItemListRecord;
import com.hoe.sentient.common.result.Result;
import com.hoe.sentient.facade.user.PartnerFacade;
import com.hoe.sentient.facade.user.dto.PartnerDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 * 好友表 Controller
 *
 * @author: Gavin
 * @date: 2021-01-28 16:44:38
 */
@RestController
@Validated
@RequestMapping("/api/vs/manage-partner")
public class PartnerManageController {
    @Resource
    private PartnerFacade partnerFacade;

    /**
     * 查询好友表列表
     *
     * @param userId userId
     * @return 好友表列表
     */
    @GetMapping("/partners")
//    @ApiOperation(valu "查询好友表", notes = "查询好友表")
    public Result<ItemListRecord> queryPartners(
            @RequestParam(value = "userId") Long userId) {
        ItemListRecord<PartnerDTO> dtoItemListRecord = partnerFacade.queryPartners(userId);
        return Result.success(dtoItemListRecord);
    }
}
