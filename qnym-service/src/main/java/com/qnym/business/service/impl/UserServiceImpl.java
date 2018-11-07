package com.qnym.business.service.impl;

import com.qnym.business.repository.UserRepostory;
import com.qnym.business.repository.entity.User;
import com.qnym.business.service.UserService;
import com.qnym.common.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by liuhaikuo on 2017/10/14.
 * @author liuhaikuo
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepostory userRepostory;

    @Override
    public User findUserByAccount(String account) {
        return userRepostory.findByAccount(account);
    }

    @Override
    public User findUserByPhone(String phone) {
        return userRepostory.findByPhone(phone);
    }

    @Override
    @Transactional
    @Modifying
    public User save(User user) {
         return userRepostory.save(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    public User save() {
        User user = null;
        for (int i=2500000;i<2600000;i++){
            user = new User();
            String account = RandomUtils.randomUniqueToken();
            Date dt = new Date();
            user.setAccount(account);
            user.setNickName("小飞侠".concat(String.valueOf(i)));
            user.setPhone(String.valueOf(i|18812345678L));
            user.setCreateTime(dt);
            user.setCreateTimeStamp(dt.getTime());
            user.setStatus(i&2);
            userRepostory.save(user);
//            if (i%10==0){
//                throw  new RuntimeException();
//            }
        }
        return user;
    }
}
