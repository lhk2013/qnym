package com.qnym.business;

import com.qnym.business.repository.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisSentinelPool;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

//    @Resource(name = "redisTemplate")
//    private RedisTemplate redisTemplate;

    @Test
    public void testRedis() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "2222");
        Assert.assertEquals("2222", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testRedisHash()throws Exception{
        User user=new User();
        user.setNickName("刘大叶");
        user.setPhone("19882811212");
//        redisTemplate.setDefaultSerializer(null);
//        redisTemplate.setValueSerializer(null);
        ValueOperations<String, User> operations=redisTemplate.opsForValue();
        operations.set("com.lhk", user);
        operations.set("com.lhk.temp", user,100L, TimeUnit.SECONDS);
        operations.set("com.lhk1", user);
        operations.set("com.lhk2", user);
        operations.set("com.lhk3", user);
//        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        boolean exists=redisTemplate.hasKey("com.lhk.temp");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }

    }

}
