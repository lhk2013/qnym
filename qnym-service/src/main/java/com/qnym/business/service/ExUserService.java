package com.qnym.business.service;

import com.qnym.business.repository.entity.ExUser;
import com.qnym.business.repository.entity.User;

import java.util.List;

/**
 * Created by liuhaikuo on 2017/10/13.
 * @author liuhaikuo
 */
public interface ExUserService {

    List<ExUser> listAll();

    void updateResultById(String result,Long id);

}
