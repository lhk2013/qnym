package com.qnym.business.repository;

import com.qnym.business.repository.entity.DisDataCaseDetailPic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by liuhaikuo on 2018/5/14.
 * @author liuhaikuo
 */
public interface DisDataCaseDetailPicRepostory extends JpaRepository<DisDataCaseDetailPic,Long>{

    public List<DisDataCaseDetailPic> findByStatus(Integer status);

    @Modifying
    @Transactional
    @Query("update DisDataCaseDetailPic p set p.status = ?1 where p.id = ?2")
    public void  updateStatusById(Integer status,Long id);


}
