package com.qnym.business.repository;

import com.qnym.business.repository.entity.IDCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by liuhaikuo on 2018/10/14.
 * @author liuhaikuo
 */
public interface IDCardRepostory extends JpaRepository<IDCard,String>{

    /**
     * 根据账户查询用户信息
     * @param userId
     * @return
     */
    IDCard findByUserId(Long userId);
    /**
     * 更新状态
     */
    @Modifying
    @Query("update IDCard ic set ic.status = ?1 where ic.idNumber = ?2")
    @Transactional
    Integer updateStatus(Integer status,String idNumber);

}
