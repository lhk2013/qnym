package com.qnym.business;

import com.qnym.common.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TestRandom {

    @Test
    public void  testUniqueToken(){
        String token = RandomUtils.randomUniqueToken();
        log.info("token:{}",token);
    }
}