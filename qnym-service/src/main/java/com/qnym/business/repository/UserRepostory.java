package com.qnym.business.repository;

import com.qnym.business.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by liuhaikuo on 2017/10/14.
 * @author liuhaikuo
 */
public interface UserRepostory extends JpaRepository<User,Long>{

    /**
     * 根据账户查询用户信息
     * @param account
     * @return
     */
    User findByAccount(String account);
}
