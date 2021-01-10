package com.richy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * TODO
 * jwt配置类
 * @author Richy
 * @date 2021-01-10 17:43
 */
@ConfigurationProperties(prefix="jwt",ignoreInvalidFields = true)
@Component
@Data
public class JWTConfig {
    //cookie过期时间
    private String cookiemaxage;
    //秘钥
    private String secret;
    //cookiepath
    private String cookiePath;
    //域名
    private String domain;
}
