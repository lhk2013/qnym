package com.qnym.business.repository;

import com.qnym.business.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by liuhaikuo on 2017/10/14.
 */
public interface UserRepostory extends JpaRepository<User,Long>{

    User findByAccount(String account);
}
