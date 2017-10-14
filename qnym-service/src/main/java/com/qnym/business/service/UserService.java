package com.qnym.business.service;

import com.qnym.business.repository.entity.User;

/**
 * Created by liuhaikuo on 2017/10/13.
 */
public interface UserService {

    User findUserByAccount(String account);
}
