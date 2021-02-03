package com.hoe.sentient.heart.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hoe.sentient.common.base.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 *
 * 计划表
 *
 * @author: Gavin
 * @date: 2021-01-28 16:44:20
 */
@Data
@TableName("plan")
@EqualsAndHashCode(callSuper = true)
public class Plan extends AbstractEntity {

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
     * 是否需要合作
     */
    private Integer needPartner;
    /**
     * 好友Id
     */
    private Long partnerId;
    /**
     * 标题
     */
    private String title;
    /**
     * 副标题
     */
    private String subTitle;
    /**
     * 描述
     */
    private String desc;
    /**
     * 计划类型
     */
    private Integer planType;
    /**
     * 预计执行时间
     */
    private LocalDateTime expectExecuteTime;
    /**
     * 实际执行时间
     */
    private LocalDateTime realExecuteTime;
    /**
     * 计划制定时间
     */
    private LocalDateTime planTime;
    /**
     * 结果
     */
    private Integer result;
    /**
     * 满意度
     */
    private Integer satisfaction;
    /**
     * 好友满意度
     */
    private Integer partnerSatisfaction;
}
