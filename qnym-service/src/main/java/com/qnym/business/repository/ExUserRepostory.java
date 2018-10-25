package com.qnym.business.repository;

import com.qnym.business.repository.entity.ExUser;
import com.qnym.business.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by liuhaikuo on 2017/10/14.
 * @author liuhaikuo
 */
public interface ExUserRepostory extends JpaRepository<ExUser,Long>{

    /**
     * 根据账户查询用户信息
     * @param account
     * @return
     */
     User findBymob(String account);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update ExUser e set e.result=?1 where e.id = ?2")
    int updateResultById( String result,  Long id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update ExUser e set e.cinfo=?1 where e.id = ?2")
    int updateCinfoById( String cinfo,  Long id);

}
