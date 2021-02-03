package com.hoe.sentient.heart.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hoe.sentient.common.base.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 *
 * 心动表
 *
 * @author: Gavin
 * @date: 2021-01-28 16:45:43
 */
@Data
@TableName("heart_beat")
@EqualsAndHashCode(callSuper = true)
public class HeartBeat extends AbstractEntity {

    /**
     *
     */
    @TableId
    private Long id;
    /**
     * 对谁心动
     */
    private Long userId;
    /**
     * 时间
     */
    private LocalDateTime beatTime;
    /**
     * 原因
     */
    private String reason;
    /**
     * 原因类型
     */
    private Integer reasonType;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 描述
     */
    private String desc;
    /**
     * 图片
     */
    private String pics;
    /**
     * 想要做什么
     */
    private String want;
    /**
     * want类型
     */
    private Integer wantType;
}
