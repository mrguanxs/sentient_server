package com.hoe.sentient.common.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * ID生成工具
 *
 * @Author Gavin
 * @Date 2021/2/3 10:40 上午
 */
public class IDUtils {

    public static Long generateId() {
        Snowflake snowflake = IdUtil.getSnowflake(1L, 1L);
        return snowflake.nextId();
    }
}
