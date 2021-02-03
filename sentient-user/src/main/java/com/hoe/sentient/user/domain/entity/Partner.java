package com.hoe.sentient.user.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hoe.sentient.common.base.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * 好友表
 *
 * @author: Gavin
 * @date: 2021-01-28 16:44:38
 */
@Data
@TableName("partner")
@EqualsAndHashCode(callSuper = true)
public class Partner extends AbstractEntity {

    /**
     *
     */
    @TableId
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
