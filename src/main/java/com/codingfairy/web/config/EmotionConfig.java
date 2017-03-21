package com.codingfairy.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * emotion test config
 */
@Data
@Component
@ConfigurationProperties(prefix="emotion")
public class EmotionConfig {
    private String token1;
    private String token2;
    private String api;
}
