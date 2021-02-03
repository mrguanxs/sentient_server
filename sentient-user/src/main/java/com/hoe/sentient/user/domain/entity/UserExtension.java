package com.hoe.sentient.user.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hoe.sentient.common.base.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * 用户扩展表
 *
 * @author: Gavin
 * @date: 2021-01-28 16:44:00
 */
@Data
@TableName("user_extension")
@EqualsAndHashCode(callSuper = true)
public class UserExtension extends AbstractEntity {

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
     * 昵称
     */
    private String alias;
    /**
     * 座右铭
     */
    private String motto;
    /**
     * 头像
     */
    private String headPic;
    /**
     * 社区别名
     */
    private String communityAlias;
    /**
     * 社区头像
     */
    private String communityHeadPic;
    /**
     * 社区座右铭
     */
    private String communityMotto;
}
