package com.qnym.business.service.impl;

import com.qnym.business.repository.ExUserRepostory;
import com.qnym.business.repository.UserRepostory;
import com.qnym.business.repository.entity.ExUser;
import com.qnym.business.repository.entity.User;
import com.qnym.business.service.ExUserService;
import com.qnym.business.service.UserService;
import com.qnym.common.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by liuhaikuo on 2017/10/14.
 * @author liuhaikuo
 */
@Service
public class ExUserServiceImpl implements ExUserService {

    @Autowired
    private ExUserRepostory exUserRepostory;

    @Override
    public List<ExUser> listAll() {
        return exUserRepostory.findAll();
    }

    @Override
    public void updateResultById(String result, Long id) {
         exUserRepostory.updateResultById(result,id);
    }

    @Override
    public void updateCinfoById(String cinfo, Long id) {
        exUserRepostory.updateCinfoById(cinfo,id);
    }
}
