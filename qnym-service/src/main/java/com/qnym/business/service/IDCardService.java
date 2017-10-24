package com.qnym.business.service;

import com.qnym.business.repository.entity.IDCard;

/**
 * Created by liuhaikuo on 2017/10/24.
 */
public interface IDCardService {

    IDCard findByUserId(Long userId);

    IDCard findByIdNumber(String idNumber);
}
