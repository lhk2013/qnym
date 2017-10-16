package com.qnym.business.controller;

import com.qnym.business.domain.LoginUserInfo;
import com.qnym.business.repository.entity.User;
import com.qnym.business.service.UserService;
import com.qnym.common.domain.CommonResponse;
import com.qnym.common.domain.LoginStatus;
import com.qnym.common.util.CookieOperator;
import com.qnym.common.util.SerializableUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.net.URLEncoder;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuhaikuo on 2017/10/13.
 */
@RestController
@Api(description = "登录业务")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation("用户登录")
    public CommonResponse login(@RequestBody LoginUserInfo loginUser,HttpServletRequest request,HttpServletResponse response){
        CommonResponse result = null;
        logger.info("login time {} ",System.currentTimeMillis());
        if(loginUser==null){
            return new CommonResponse(LoginStatus.ACCOUNT_EMPTY.getCode(), LoginStatus.ACCOUNT_EMPTY.getMsg());
        }

        if(StringUtils.isEmpty(loginUser.getAccount())){
            return  new CommonResponse(LoginStatus.ACCOUNT_EMPTY.getCode(), LoginStatus.ACCOUNT_EMPTY.getMsg());
        }

        if(StringUtils.isEmpty(loginUser.getPwd())){
            return  new CommonResponse(LoginStatus.PWD_EMPTY.getCode(), LoginStatus.PWD_EMPTY.getMsg());
        }

        User user = userService.findUserByAccount(loginUser.getAccount());
        if(user==null){
            return new CommonResponse(LoginStatus.ACCOUNT_NOT_EXIST.getCode(), LoginStatus.ACCOUNT_NOT_EXIST.getMsg());
        }

        if(loginUser.getPwd().trim().equals(user.getPwd())){
            //验证成功写入cookie
            String domain = request.getServerName();
            try {
                String value = SerializableUtils.json.writeValueAsString(user);
                logger.info("value {}",value);
                Cookie cookie = CookieOperator.writeCookie(response,null,domain,user.getUserId().toString()+"|"+user.getNickName(),10);
                String cookieCan = SerializableUtils.json.writeValueAsString(cookie);
                logger.info("cookieCan {}",cookieCan);
                result = new CommonResponse(LoginStatus.SUCCESS.getCode(), LoginStatus.SUCCESS.getMsg());
            }catch (Exception e){
                logger.info("login error :{}",e);
                result = new CommonResponse(LoginStatus.LOGIN_FAILD.getCode(), LoginStatus.LOGIN_FAILD.getMsg());
            }

        }else {
            result = new CommonResponse(LoginStatus.ACCOUNT_PWD_NOT_MATCH.getCode(), LoginStatus.ACCOUNT_PWD_NOT_MATCH.getMsg());
        }

        return result;
    }
    @RequestMapping(value = "/login2",method = RequestMethod.GET)
    @ApiOperation("用户登录v2")
    public CommonResponse login2(String account,String pwd,HttpServletRequest request,HttpServletResponse response){
        CommonResponse result = null;
        User loginUser = new User();
        loginUser.setAccount(account);
        loginUser.setPwd(pwd);
        logger.info("login time {} ",System.currentTimeMillis());
        if(loginUser==null){
            return new CommonResponse(LoginStatus.ACCOUNT_EMPTY.getCode(), LoginStatus.ACCOUNT_EMPTY.getMsg());
        }

        if(StringUtils.isEmpty(loginUser.getAccount())){
            return  new CommonResponse(LoginStatus.ACCOUNT_EMPTY.getCode(), LoginStatus.ACCOUNT_EMPTY.getMsg());
        }

        if(StringUtils.isEmpty(loginUser.getPwd())){
            return  new CommonResponse(LoginStatus.PWD_EMPTY.getCode(), LoginStatus.PWD_EMPTY.getMsg());
        }

        User user = userService.findUserByAccount(loginUser.getAccount());
        if(user==null){
            return new CommonResponse(LoginStatus.ACCOUNT_NOT_EXIST.getCode(), LoginStatus.ACCOUNT_NOT_EXIST.getMsg());
        }

        if(loginUser.getPwd().trim().equals(user.getPwd())){
            //验证成功写入cookie
            String domain = request.getServerName();
            try {
                String value = SerializableUtils.json.writeValueAsString(user);
                logger.info("value {}",value);
                Cookie cookie = CookieOperator.writeCookie(response,null,domain,
                    user.getUserId().toString()+"|"+ URLEncoder.encode(user.getNickName(),"utf-8"),10);
                String cookieCan = SerializableUtils.json.writeValueAsString(cookie);
                logger.info("cookieCan {}",cookieCan);
                result = new CommonResponse(LoginStatus.SUCCESS.getCode(), LoginStatus.SUCCESS.getMsg());
            }catch (Exception e){
                logger.info("login error :{}",e);
                result = new CommonResponse(LoginStatus.LOGIN_FAILD.getCode(), LoginStatus.LOGIN_FAILD.getMsg());
            }

        }else {
            result = new CommonResponse(LoginStatus.ACCOUNT_PWD_NOT_MATCH.getCode(), LoginStatus.ACCOUNT_PWD_NOT_MATCH.getMsg());
        }

        return result;
    }
}
