package com.hoe.sentient.facade.heart.dto;

import com.hoe.sentient.common.base.AbstractCreateAndUpdateDTO;
import lombok.Data;

import java.time.LocalDateTime;

/**
 *
 * 心动表DTO
 *
 * @author: Gavin
 * @date: 2021-01-28 16:45:43
 */
@Data
public class HeartBeatDTO extends AbstractCreateAndUpdateDTO {

    /**
     *
     */
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
