package com.hoe.sentient.mood.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hoe.sentient.common.base.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * 留言表
 *
 * @author: Gavin
 * @date: 2021-01-28 16:46:01
 */
@Data
@TableName("guest_book")
@EqualsAndHashCode(callSuper = true)
public class GuestBook extends AbstractEntity {

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
     * 客户Id
     */
    private Long guestId;
    /**
     * 留言
     */
    private String msg;
    /**
     * 客户类型
     */
    private Integer guestType;
    /**
     * 父Id
     */
    private Long pId;
}
