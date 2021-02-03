package com.hoe.sentient.facade.user.dto;

import com.hoe.sentient.common.base.AbstractCreateAndUpdateDTO;
import lombok.Data;

/**
 *
 * 好友表DTO
 *
 * @author: Gavin
 * @date: 2021-01-28 16:44:38
 */
@Data
public class PartnerDTO extends AbstractCreateAndUpdateDTO {

    /**
     *
     */
    private Long id;
    /**
     * 用户Id
     */
    private Long userId;
    /**
     * 好友Id
     */
    private Long partnerId;
    /**
     * 好友类型
     */
    private Integer partnerType;
    /**
     * 备注
     */
    private String remark;

}
