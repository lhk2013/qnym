package com.qnym.business.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by liuhaikuo on 2017/10/16.
 * @author liuhaikuo
 */
@Data
public class LoginUserInfo {

    @ApiModelProperty(value = "账户",required = true)
    private String account;

    @ApiModelProperty(value = "密码",required = true)
    private String pwd;

}
