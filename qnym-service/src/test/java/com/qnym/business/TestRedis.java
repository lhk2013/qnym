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
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisSentinelPool;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;

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
//        operations.set("com.lhk1", user);

//        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        boolean exists=redisTemplate.hasKey("com.lhk.temp");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }

    }


    @Test
    public void  testAll(){

        stringRedisTemplate.opsForValue().set("aaa", "2222");
        log.error(stringRedisTemplate.opsForValue().get("aaa"));

        //TODO 操作hash

        redisTemplate.opsForHash().put("redisHash","name","tom");
        redisTemplate.opsForHash().put("redisHash","age",26);
        redisTemplate.opsForHash().put("redisHash","class","6");

        Map<String,Object> testMap = new HashMap();
        testMap.put("name","jack");
        testMap.put("age",27);
        testMap.put("class","1");
        redisTemplate.opsForHash().putAll("redisHash1",testMap);

        //TODO 操作list
        ListOperations<String,User> listOperations = redisTemplate.opsForList();
        listOperations.leftPush("lhk1",new User("lhk1","老大1"));
        listOperations.leftPush("lhk1",new User("lhk2","老大2"));
        listOperations.leftPushAll("lhk1",new User("lhk2","老大2"));



        //TODO 操作set
        redisTemplate.opsForSet().add("redisSet","22",121,888,999,372);
        log.error("redisSet {}",redisTemplate.opsForSet().members("redisSet"));

        //TODO 操作Zset
        redisTemplate.opsForZSet().add("redisZSet",11,12.00);
        redisTemplate.opsForZSet().add("redisZSet",22,45.00);
        redisTemplate.opsForZSet().add("redisZSet",55,36.00);
        redisTemplate.opsForZSet().add("redisZSet",27,39.00);

        redisTemplate.opsForZSet().add("redisZSet",1111,25.00);
        log.error("redisZSet{}",redisTemplate.opsForZSet().rangeByScore("redisZSet",30,40));
    }

}
