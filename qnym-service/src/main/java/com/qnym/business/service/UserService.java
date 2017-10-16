package com.qnym.business.service;

import com.qnym.business.repository.entity.User;

/**
 * Created by liuhaikuo on 2017/10/13.
 * @author liuhaikuo
 */
public interface UserService {

    /**
     * 根据账户查询用户信息
     * @param account
     * @return
     */
    User findUserByAccount(String account);
}
