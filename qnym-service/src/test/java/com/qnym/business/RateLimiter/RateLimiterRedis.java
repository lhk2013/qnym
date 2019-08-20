package com.qnym.business.RateLimiter;

import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.qnym.business.DateUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import redis.clients.jedis.Jedis;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Set;

public class RateLimiterRedis{

    private Logger logger = LoggerFactory.getLogger(RateLimiterRedis.class);


    @Test
    public void sss()throws Exception{

        String s = "7pCO";
        BASE64Decoder decoder = new BASE64Decoder();
        String s1 = new String(  decoder.decodeBuffer(s),"utf-8");

        String key = "RateLimit_"+"_wxid_love";

        while (true){
            boolean ss = ratelimite(key);
            if(ss){
                System.out.println("可以发送");
//                Thread.sleep(1000);
            }else {
                System.out.println("限流中 请稍后");
                Thread.sleep(1000);
            }


        }

    }

    private boolean ratelimite(String key){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.select(8);
        Long now = System.currentTimeMillis() - DateUtil.YEAR_MILLSECONDS_2019;
        Long minute = now  - DateUtil.ONE_MIN_MILLSECONDS; // 一分钟内
        Long hour = now - DateUtil.ONE_HOUR_MILLSECONDS; // 一小时内
        Long day = now - DateUtil.ONE_DAY_MILLSECONDS; // 一天内
        Set<String> minuteSet = jedis.zrangeByScore(key,minute,now);
        Set<String> hourSet = jedis.zrangeByScore(key,hour,now);
        Set<String> daySet = jedis.zrangeByScore(key,day,now);
        jedis.zremrangeByScore(key,0,minute);

        if(minuteSet.size()>=5){
            return false;
        }
        if(hourSet.size()>=20){
            return false;
        }
        if(daySet.size()>=100){
            return false;
        }
        System.out.println("执行了一次");
        logger.error("{} {} {}",now,now);
        jedis.zremrangeByScore(key,0,day);

        jedis.zadd(key,now.doubleValue() , now+"");
        //清除一天前的数据
        return true;
    }


    @Test
    public void sss2()throws Exception{

        while (true){
            System.out.println(acquire());
        }

    }

    public static boolean acquire() throws Exception {
        File file = ResourceUtils.getFile("classpath:limit.lua");
        String luaScript = Files.toString(file, Charset.defaultCharset());
        Jedis jedis = new Jedis("127.0.0.1",6379);
        String key = "ip:" + System.currentTimeMillis()/ 1000; //此处将当前时间戳取秒数
        String limit = "3"; //限流大小
        return (Long)jedis.eval(luaScript, Lists.newArrayList(key), Lists.newArrayList(limit)) == 1;
    }
}
