package com.qnym.business.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * Created by liuhaikuo on 2017/10/13.
 * @author liuhaikuo
 */
@Data
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String account;

    private String pwd;

    @Column(name = "nick_name")
    private String nickName;

    /**
     * 绑定手机 一个手机只能被一个账户绑定 可以用来登录
     */
    private String phone;

}
