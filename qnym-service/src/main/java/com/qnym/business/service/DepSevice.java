package com.qnym.business.service;

import com.qnym.business.repository.*;
import com.qnym.business.repository.entity.*;
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

    @Autowired
    private DisDataCaseDetailRepostory caseDetailRepostory;

    @Autowired
    private DisDataCaseDetailPicRepostory picRepostory;

    public List<Dep> findAll(){
        return depRepostory.findAll();
    }

    public void save(Dep dep){

        depRepostory.save(dep);
    }

    public void  save(DisData disData){
        disDataRepostory.save(disData);
    }

    public void save(DisDataCase disDataCase){
        disDataCaseRepostory.save(disDataCase);
    }

    public void save(DisDataCaseDetail disDataCaseDetail){
        caseDetailRepostory.save(disDataCaseDetail);
    }


    public void save(DisDataCaseDetailPic disDataCaseDetailPic){
        picRepostory.save(disDataCaseDetailPic);
    }


    public List<DisDataCase> findAllCase(){
        return disDataCaseRepostory.findAll();
    }

    public List<DisDataCaseDetailPic> findAllCasePic(Integer status){
        return picRepostory.findByStatus(status);
    }

    public void updateStatusById(Integer status,Long id){
        picRepostory.updateStatusById(status,id);
    }
}
