package com.qnym.business.dojob;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qnym.business.HttpClientUtil;
import com.qnym.business.repository.entity.DisDataCase;
import com.qnym.business.repository.entity.DisDataCaseDetail;
import com.qnym.business.repository.entity.DisDataCaseDetailPic;
import com.qnym.business.service.DepSevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DoJob3 {

    private static final Logger logger = LoggerFactory.getLogger(DoJob3.class);

    @Autowired
    private DepSevice depSevice;

//    @PostConstruct
    public void spider() throws Exception {

        String token = "8a1df843b0fb13354d800932e4af2d2d";
        String userId = "881211";



        List<DisDataCase> list = depSevice.findAllCase();
        int i = 1;
        for (DisDataCase disDataCase : list) {
            String firstUrl = "https://api.meditool.cn/Apicaselibrary/casedetail?caseid=%s&usertoken=%s&userid=%s";

            firstUrl = String.format(firstUrl, disDataCase.getId(), token, userId);
            String res = HttpClientUtil.doGet(firstUrl);
            JSONObject jsb = JSONObject.parseObject(res);
            JSONObject data = jsb.getJSONObject("data");
            JSONArray recommend = jsb.getJSONArray("recommend");
            String  shareUrl = jsb.getString("shareurl");

            logger.error("shareUlr {} ",shareUrl);
//            String htmlContent = HttpClientUtil.doGet(shareUrl);

            DisDataCaseDetail caseDetail = new DisDataCaseDetail();
            caseDetail.setId(disDataCase.getId());
            caseDetail.setCaseId(disDataCase.getId());
            caseDetail.setData(data.toString());
            caseDetail.setRecommend(recommend.toString());
            caseDetail.setShareUrl(shareUrl);
            caseDetail.setResult(res);


            JSONArray a1 = data.getJSONArray("BingShiPic");
            JSONArray a2 = data.getJSONArray("LinChuangPic");
            JSONArray a3 = data.getJSONArray("JianChaPic");
            JSONArray a4 = data.getJSONArray("ZhenDuanPic");


            List<DisDataCaseDetailPic> picList = new ArrayList();
            if(a1!=null&&a1.size()>0){
                warp(a1,picList,disDataCase.getId());
            }
            if(a2!=null&&a2.size()>0){
                warp(a2,picList,disDataCase.getId());

            }
            if(a3!=null&&a3.size()>0){
                warp(a3,picList,disDataCase.getId());

            }
            if(a4!=null&&a4.size()>0){
                warp(a4,picList,disDataCase.getId());
            }

//            depSevice.save(caseDetail);
            if(picList.size()>1){
                logger.info("caseId {} size {}",caseDetail.getCaseId(),picList.size());
            }
            picList.forEach(pic->depSevice.save(pic));

            logger.info("剩余{} 已处理 {} ",list.size()-i,i++);

        }

    }

    private void warp(JSONArray jsonArray,List<DisDataCaseDetailPic> picList,Long caseId ){
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jb = jsonArray.getJSONObject(i);
            DisDataCaseDetailPic pic = new DisDataCaseDetailPic();
            picList.add(pic);
            pic.setCaseDetailId(caseId);
            pic.setAccesseryName(jb.getString("AccesseryName"));
            pic.setPicUrl(jb.getString("ccesseryName"));
            pic.setItemId(jb.getString("ItemID"));
            pic.setStatus(1);
          }
    }


}
