package com.hoe.sentient.common.base;

import com.baomidou.mybatisplus.annotation.TableField;

import java.time.LocalDateTime;

/**
 * TODO
 *
 * @Author Gavin
 * @Date 2021/1/28 6:56 下午
 */
public class AbstractCreateAndUpdateDTO extends AbstractCreateDTO {
    @TableField("updated_at")
    private LocalDateTime updatedAt;
    @TableField("updated_by")
    private String updatedBy;
}
