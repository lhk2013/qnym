package com.qnym.business.service;

import com.qnym.business.repository.DepRepostory;
import com.qnym.business.repository.DisDataCaseRepostory;
import com.qnym.business.repository.DisDataRepostory;
import com.qnym.business.repository.entity.Dep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepSevice {

    @Autowired
    private DepRepostory depRepostory;

    @Autowired
    private DisDataRepostory disDataRepostory;

    @Autowired
    private DisDataCaseRepostory disDataCaseRepostory;

    public List<Dep> findAll(){
        return depRepostory.findAll();
    }


}
