package com.hoe.sentient.mood.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hoe.sentient.common.base.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 *
 * 空间表
 *
 * @author: Gavin
 * @date: 2021-01-28 16:44:56
 */
@Data
@TableName("mood")
@EqualsAndHashCode(callSuper = true)
public class Mood extends AbstractEntity {

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
     * 是否发布
     */
    private Integer publish;
    /**
     * 发布时间
     */
    private LocalDateTime publishTime;
    /**
     * 描述
     */
    private String desc;
    /**
     *  图片
     */
    private String pics;
    /**
     * 空间类型
     */
    private Integer moodType;
}
