package com.qnym.business.config;

import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "redis")
public class RedisConfig {

        private String host;
        private String port;
        private Integer database;
        private Integer timeout;
        private Integer max_active;
        private Integer maxActive;


}

