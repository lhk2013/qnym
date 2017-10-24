package com.qnym.business.repository;

import com.qnym.business.repository.entity.IDCard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by liuhaikuo on 2017/10/14.
 * @author liuhaikuo
 */
public interface IDCardRepostory extends JpaRepository<IDCard,String>{

    /**
     * 根据账户查询用户信息
     * @param userId
     * @return
     */
    IDCard findByUserId(Long userId);

}
