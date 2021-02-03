package com.hoe.sentient.common.base;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @Author Gavin
 * @Date 2021/1/28 6:57 下午
 */
@Data
public class AbstractCreateDTO {
    @TableField("created_at")
    private LocalDateTime createdAt;
    @TableField("created_by")
    private String createdBy;
}
