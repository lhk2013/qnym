package com.qnym.business.service.impl;

import com.qnym.business.repository.UserRepostory;
import com.qnym.business.repository.entity.User;
import com.qnym.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liuhaikuo on 2017/10/14.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepostory userRepostory;

    @Override
    public User findUserByAccount(String account) {
        return userRepostory.findByAccount(account);
    }
}
