package com.qnym.inf.dubbo.domain;

import lombok.Data;

/**
 * Created by liuhaikuo on 2017/10/13.
 */
@Data
public class UserInfo {

    private Long userId;

    private String account;

    private String pwd;

    private String phone;
}
