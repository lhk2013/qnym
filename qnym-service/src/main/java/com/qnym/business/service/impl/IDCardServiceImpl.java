package com.qnym.business.service.impl;

import com.qnym.business.repository.IDCardRepostory;
import com.qnym.business.repository.entity.IDCard;
import com.qnym.business.service.IDCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liuhaikuo on 2017/10/24.
 */
@Service
public class IDCardServiceImpl implements IDCardService{

    @Autowired
    private IDCardRepostory idCardRepostory;


    @Override
    public IDCard findByUserId(Long userId) {
        return idCardRepostory.findByUserId(userId);
    }

    @Override
    public IDCard findByIdNumber(String idNumber) {
        return idCardRepostory.findOne(idNumber);
    }
}
