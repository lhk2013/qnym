package com.qnym.business;

import com.alibaba.fastjson.JSONObject;
import com.qnym.business.config.RedisConfig;
import com.qnym.business.config.RedisConfig2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestConfig {

    @Autowired
    private RedisConfig redisConfig;
    @Autowired
    private RedisConfig2 redisConfig2;


    @Test
    public void testConfig() throws Exception {

        log.error(1111111111+"》》》》》》》》》》》》");
        log.info("{} {} {} ", JSONObject.toJSONString(redisConfig));
        log.error(1111111111+"《《《《《《《《《《《《");
        log.info("{} {} {} ", JSONObject.toJSONString(redisConfig2));
        log.error(1111111111+"《《《《《《《《《《《《");

    }
}
