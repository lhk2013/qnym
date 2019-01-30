package com.qnym.business;

import com.qnym.common.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;

@Slf4j
public class TestRandom {

    private static Logger logger = LoggerFactory.getLogger(TestRSA.class);

    @Test
    public void  testUniqueToken(){


        String token = RandomUtils.randomUniqueToken();
        log.info("token:{}",token);

        ByteBuffer buffer_ = ByteBuffer.allocate(4);

        int frameSize = buffer_.getInt(0);

        System.out.println(        Integer.MIN_VALUE);
    }



}