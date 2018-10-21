package com.qnym.business;

import com.qnym.business.repository.entity.IDCard;
import com.qnym.business.repository.entity.User;
import com.qnym.business.service.IDCardService;
import com.qnym.business.service.UserService;
import com.qnym.common.util.RandomUtils;
import com.qnym.common.util.SerializableUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by liuhaikuo on 2017/10/28.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestUser {

    @Autowired
    private UserService userService;

    @Test
    public  void testSaveUser()throws Exception{

        Long d1 = System.currentTimeMillis();
        log.info("");
        for (int i=2153716;i<10000000;i++){
            User user = new User();
            String account = RandomUtils.randomUniqueToken();
            Date dt = new Date();
            user.setAccount(account);
            user.setNickName("小飞侠".concat(String.valueOf(i)));
            user.setPhone(String.valueOf(i|18812345678L));
            user.setCreateTime(dt);
            user.setCreateTimeStamp(dt.getTime());
            user.setStatus(i&2);
            userService.save(user);
//            log.info("{}",i);
        }
        Long d2 = System.currentTimeMillis();
        log.info("fuck time {} ", d2-d1);

//        log.info("fuck {} ", SerializableUtils.OBJECT_MAPPER.writeValueAsString(user));

    }

    @Test
    public  void testSaveUser2()throws Exception{

        Long d1 = System.currentTimeMillis();
        userService.save();


        Long d2 = System.currentTimeMillis();
        log.info("fuck time {} ", d2-d1);

//        log.info("fuck {} ", SerializableUtils.OBJECT_MAPPER.writeValueAsString(user));

    }
}
