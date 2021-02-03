package com.hoe.sentient.mood.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hoe.sentient.common.base.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * 评论表
 *
 * @author: Gavin
 * @date: 2021-01-28 16:46:24
 */
@Data
@TableName("comment")
@EqualsAndHashCode(callSuper = true)
public class Comment extends AbstractEntity {

    /**
     *
     */
    @TableId
    private Long id;
    /**
     * 动态Id
     */
    private Long moodId;
    /**
     * 父Id
     */
    private Long pId;
    /**
     * 评论
     */
    private String msg;
}
