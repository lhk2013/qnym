package com.qnym.business.controller;

import com.qnym.business.domain.LoginUserInfo;
import com.qnym.business.repository.entity.User;
import com.qnym.business.service.UserService;
import com.qnym.common.domain.CommonResponse;
import com.qnym.common.domain.LoginStatus;
import com.qnym.common.domain.WebResponse;
import com.qnym.common.util.CookieOperator;
import com.qnym.common.util.SerializableUtils;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * Created by liuhaikuo on 2018/11/18.
 * @author liuhaikuo
 */
@RestController
@Api(value = "测试业务", tags={"业务1","业务2"},description = "swagger应用",  produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    @ApiOperation(value = "测试接口",notes="这个接口不用了")
    public CommonResponse login(@RequestBody LoginUserInfo loginUser,HttpServletRequest request,HttpServletResponse response){

        return  new WebResponse<>("成功了");
    }

    @RequestMapping(value = "/test2",method = RequestMethod.POST)
    @ApiOperation(value = "测试接口",notes="这个接口不用了")
    public CommonResponse swaggerTest(@ApiParam(name="id",value="用户id",required=true) Long id){
        return  new WebResponse<>("成功了2");
    }

    @RequestMapping(value="/apiImplicitParamsTest", method= RequestMethod.GET)
    @ApiOperation(value="获取apiImplicitParams信息",httpMethod = "GET",notes="apiImplicitParams注意问题点",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名字", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "id", value = "用户id", required = false, dataType = "long", paramType = "query")})
    public CommonResponse apiImplicitParamsTest(Long id,String name ){
        return  new WebResponse<>("成功了3apiImplicitParamsTest");
    }

}
