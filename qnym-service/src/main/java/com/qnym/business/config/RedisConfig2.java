package com.qnym.business.config;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = {"classpath:db.properties"})
@ConfigurationProperties(prefix = "redis")
public class RedisConfig2 {

        private String host;
        private String port;
        private Integer database;
        private Integer timeout;
        private Integer maxActive;
        private Integer max_active;
        @Length(min = 9,max = 11)
        private String mobile;
}

