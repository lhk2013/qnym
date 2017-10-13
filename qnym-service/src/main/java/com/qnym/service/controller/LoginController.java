package com.qnym.service.controller;

import com.qnym.common.domain.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuhaikuo on 2017/10/13.
 */
@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public CommonResponse login(){
        logger.info("login time {} ",System.currentTimeMillis());
        return new CommonResponse(200,"ok");
    }
}
