package com.qnym.business.controller;

import com.qnym.business.repository.entity.IDCard;
import com.qnym.business.repository.entity.User;
import com.qnym.business.service.IDCardService;
import com.qnym.business.service.UserService;
import com.qnym.common.domain.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuhaikuo on 2017/10/13.
 * @author liuhaikuo
 */
@RestController("idcard")
@Api(description = "身份证查询")
public class IDCardController {

    private static final Logger logger = LoggerFactory.getLogger(IDCardController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private IDCardService idCardService;


    @RequestMapping(value = "/find",method = RequestMethod.GET)
    @ApiOperation("查询身份证状态")
    public CommonResponse find(@RequestParam (required = false) String phone,@RequestParam(required = false) String idnum,HttpServletRequest request,HttpServletResponse response){
        CommonResponse result = null;
        IDCard idCard = null;
        if(!StringUtils.isEmpty(phone)){
            User user = userService.findUserByPhone(phone);
            if(user!=null){
                idCard = idCardService.findByUserId(user.getUserId());
            }
        }
        if(!StringUtils.isEmpty(idnum)){
            idCard = idCardService.findByIdNumber(idnum);
        }
        result = new CommonResponse();
        result.setData(idnum);
        return result;
    }
}
