package com.qnym.business.controller;

import com.qnym.business.domain.IDCardInfo;
import com.qnym.business.repository.entity.IDCard;
import com.qnym.business.repository.entity.User;
import com.qnym.business.service.IDCardService;
import com.qnym.business.service.UserService;
import com.qnym.common.domain.CommonResponse;
import com.qnym.common.domain.IDCardStatus;
import com.qnym.common.domain.WebResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
@RestController
@RequestMapping("idcard")
@Api(description = "身份证查询")
public class IDCardController {

    private static final Logger logger = LoggerFactory.getLogger(IDCardController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private IDCardService idCardService;


    @RequestMapping(value = "/find",method = RequestMethod.GET)
    @ApiOperation("查询身份证状态")
    public WebResponse<IDCardInfo> find(@RequestParam (required = false) String phone,@RequestParam(required = false) String idnum,HttpServletRequest request,HttpServletResponse response){
        WebResponse result = null;
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
        if (idCard !=null){
            IDCardInfo idCardInfo= new IDCardInfo();
            BeanUtils.copyProperties(idCard,idCardInfo);
            result = new WebResponse<IDCardInfo>(idCardInfo);
        }

        return result;
    }

    @RequestMapping(value = "/modStatus",method = RequestMethod.GET)
    @ApiOperation("修改状态")
    public CommonResponse modStatus(@RequestParam(required = true) String idnum,@RequestParam(required = true) Integer status,HttpServletRequest request,HttpServletResponse response){
        CommonResponse result = new CommonResponse();

        if(!StringUtils.isEmpty(idnum)) {
            Integer count = idCardService.updateStatus(status, idnum);

        }else {
            result.setRpco (IDCardStatus.UPDATE_FAIL.getCode());
            result.setMsg(IDCardStatus.UPDATE_FAIL.getMsg());
        }

        return result;
    }

}
