package com.qnym.service.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by liuhaikuo on 2017/10/13.
 */
@Entity
@Table(name = "t_user")
public class User {

    @Column(name = "")
    private Long userId;

    private String account;

    private String pwd;

    private String nickName;

    private String phone;
}
