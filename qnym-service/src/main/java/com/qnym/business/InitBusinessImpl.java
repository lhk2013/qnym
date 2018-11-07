package com.qnym.business;

import com.alibaba.fastjson.JSONObject;
import com.qnym.business.repository.entity.User;
import com.qnym.business.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class InitBusinessImpl implements ApplicationListener<ContextRefreshedEvent>{

    private final static Logger logger = LoggerFactory.getLogger(InitBusinessImpl.class);


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        final ApplicationContext app = event.getApplicationContext();
        UserService userService = app.getBean(UserService.class);
        try {
            logger.info("InitBusinessImpl start >>>>>>>>>>>>>>>>>>>>>>>>");
            User user = userService.findUserByAccount("FC275D857848ED6DC92CAC05B5AE691D");
            logger.info("findUserByAccount user {}", JSONObject.toJSONString(user));
            logger.info("InitBusinessImpl success <<<<<<<<<<<<<<<<<<<<<<<<");

        } catch (Exception e) {
            logger.error("InitBusinessImpl error --------------", e);
        }
    }
}
