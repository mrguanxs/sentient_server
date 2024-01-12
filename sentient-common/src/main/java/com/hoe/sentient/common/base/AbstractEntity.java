package com.hoe.sentient.common.base;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * TODO
 *
 * @Author Gavin
 * @Date 2021/1/28 6:23 下午
 */
@Data
public abstract class AbstractEntity {

    @TableField("created_at")
    private Date createdAt;
    @TableField("updated_at")
    private Date updatedAt;
    @TableField("created_by")
    private String createdBy;
    @TableField("updated_by")
    private String updatedBy;
    @TableField("stop_flag")
    private Boolean stopFlag;

    public void markNew(String operateBy) {
        this.setCreatedAt(new Date());
        this.setUpdatedAt(new Date());
        this.setCreatedBy(operateBy);
        this.setUpdatedBy(operateBy);
    }

    public void markDirty(String operateBy) {
        this.setUpdatedBy(operateBy);
        this.setUpdatedAt(new Date());
    }
}
