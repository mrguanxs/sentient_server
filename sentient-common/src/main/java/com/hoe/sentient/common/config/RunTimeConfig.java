package com.hoe.sentient.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author guan
 * @date 2024/1/11
 */
@Slf4j
@Configuration
public class RunTimeConfig {

    @Value("${spring.profiles.active}")
    public String env;

    /**
     * 是否测试环境
     */
    public boolean isDebug() {
        if (env.startsWith("test") || env.startsWith("dev")) {
            return true;
        }
        return false;
    }

    /**
     * 是否开发环境
     */
    public boolean isDev() {
        if (env.startsWith("dev")) {
            return true;
        }
        return false;
    }
}
