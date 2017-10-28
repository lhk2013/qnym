package com.qnym.business.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by liuhaikuo on 2017/10/28.
 */
@Data
public class IDCardInfo {

    @ApiModelProperty(name = "身份证号",value = "身份证1",notes = "方法",required = false)
    private String idNumber;

    @ApiModelProperty(name = "用户id")
    private Long userId;

    @ApiModelProperty("真是名字")
    private String realName;

    @ApiModelProperty("状态")
    private Integer status;

}
