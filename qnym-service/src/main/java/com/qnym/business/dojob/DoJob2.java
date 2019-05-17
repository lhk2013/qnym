package com.qnym.business.dojob;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qnym.business.HttpClientUtil;
import com.qnym.business.repository.entity.Dep;
import com.qnym.business.repository.entity.DisData;
import com.qnym.business.repository.entity.DisDataCase;
import com.qnym.business.service.DepSevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DoJob2 {

    private static final Logger logger = LoggerFactory.getLogger(DoJob2.class);

    @Autowired
    private DepSevice depSevice;

//    @PostConstruct
    public void spider() throws Exception {

        String token = "8a1df843b0fb13354d800932e4af2d2d";
        String userId = "881211";

        List<Dep> list = depSevice.findAll();
        logger.error("===============================");
        logger.error(JSONObject.toJSONString(list));
        String firstUrl = "https://api.meditool.cn/Apicaselibrary/deplist?depid=%s&usertoken=%s&userid=%s";

        firstUrl = String.format(firstUrl, 0, token, userId);
        //获取类目1层
        String res = HttpClientUtil.doGet(firstUrl);
//        String res = "{\"status\":0,\"msg\":\"success\",\"data\":[{\"ID\":\"5\",\"DepName\":\"\\u513f\\u79d1\",\"DataMsg\":\"http:\\/\\/meditool.cn\\/upload\\/depimgs\\/case_erke.png\"},{\"ID\":\"9\",\"DepName\":\"\\u5185\\u79d1\",\"DataMsg\":\"http:\\/\\/meditool.cn\\/upload\\/depimgs\\/case_neike.png\"},{\"ID\":\"12\",\"DepName\":\"\\u53e3\\u8154\\u79d1\",\"DataMsg\":\"http:\\/\\/meditool.cn\\/upload\\/depimgs\\/case_kqk.png\"},{\"ID\":\"14\",\"DepName\":\"\\u5916\\u79d1\",\"DataMsg\":\"http:\\/\\/meditool.cn\\/upload\\/depimgs\\/case_waike.png\"},{\"ID\":\"17\",\"DepName\":\"\\u5987\\u4ea7\\u79d1\",\"DataMsg\":\"http:\\/\\/meditool.cn\\/upload\\/depimgs\\/case_fck.png\"},{\"ID\":\"38\",\"DepName\":\"\\u6025\\u8bca\\u79d1\",\"DataMsg\":\"http:\\/\\/meditool.cn\\/upload\\/depimgs\\/case_jzk.png\"},{\"ID\":\"39\",\"DepName\":\"\\u611f\\u67d3\\u79d1\",\"DataMsg\":\"http:\\/\\/meditool.cn\\/upload\\/depimgs\\/case_crk.png\"},{\"ID\":\"54\",\"DepName\":\"\\u76ae\\u80a4\\u6027\\u75c5\\u79d1\",\"DataMsg\":\"http:\\/\\/meditool.cn\\/upload\\/depimgs\\/case_pifuke.png\"},{\"ID\":\"55\",\"DepName\":\"\\u773c\\u79d1\",\"DataMsg\":\"http:\\/\\/meditool.cn\\/upload\\/depimgs\\/case_yanke.png\"},{\"ID\":\"58\",\"DepName\":\"\\u7cbe\\u795e\\u5fc3\\u7406\\u79d1\",\"DataMsg\":\"http:\\/\\/meditool.cn\\/upload\\/depimgs\\/case_jsk.png\"},{\"ID\":\"60\",\"DepName\":\"\\u8033\\u9f3b\\u54bd\\u5589\\u5934\\u9888\\u79d1\",\"DataMsg\":\"http:\\/\\/meditool.cn\\/upload\\/depimgs\\/case_ebyh.png\"},{\"ID\":\"64\",\"DepName\":\"\\u80bf\\u7624\\u79d1\",\"DataMsg\":\"http:\\/\\/meditool.cn\\/upload\\/depimgs\\/case_zhongliu.png\"},{\"ID\":\"72\",\"DepName\":\"\\u91cd\\u75c7\\u533b\\u5b66\\u79d1\",\"DataMsg\":\"http:\\/\\/meditool.cn\\/upload\\/depimgs\\/case_zhongzhegn.png\"},{\"ID\":\"75\",\"DepName\":\"\\u9aa8\\u79d1\",\"DataMsg\":\"http:\\/\\/meditool.cn\\/upload\\/depimgs\\/case_guke.png\"},{\"ID\":\"76\",\"DepName\":\"\\u9ebb\\u9189\\u75bc\\u75db\\u79d1\",\"DataMsg\":\"http:\\/\\/meditool.cn\\/upload\\/depimgs\\/case_mazuike.png\"}]}";
        JSONObject jsb = JSONObject.parseObject(res);

        List<Dep> dlist1 = new ArrayList<>();
        List<Dep> dlist2 = new ArrayList<>();
        List<DisData> disList = new ArrayList<>();
        List<DisDataCase> caseList = new ArrayList<>();


        JSONArray jsonArray = jsb.getJSONArray("data");
        if (jsonArray.size() > 0) {

            for (int i = 0; i < jsonArray.size(); i++) {

                JSONObject js1 = jsonArray.getJSONObject(i);

                Dep dep = new Dep();
                dep.setId(js1.getLong("ID"));
                dep.setDepName(js1.getString("DepName"));
                dep.setData_msg(js1.getString("DataMsg"));
                dep.setLevel(1);
                depSevice.save(dep);

                dlist1.add(dep);


                //获取类目2层
                String secondUrl = "https://api.meditool.cn/Apicaselibrary/deplist?depid=%s&usertoken=%s&userid=%s";
                secondUrl = String.format(secondUrl, dep.getId(), token, userId);
                res = HttpClientUtil.doGet(secondUrl);
                jsb = JSONObject.parseObject(res);
                JSONArray sendCondArray = jsb.getJSONArray("data");
                if (sendCondArray.size() > 0) {

                    for (int j = 0; j < sendCondArray.size(); j++) {

                        JSONObject js2 = sendCondArray.getJSONObject(j);
                        Dep dep2 = new Dep();
                        dep2.setId(js2.getLong("ID"));
                        dep2.setDepName(js2.getString("DepName"));
                        dep2.setLevel(2);
                        dep2.setPid(dep.getId());
                        depSevice.save(dep2);
                        dlist2.add(dep2);

                        JSONArray thirdArray = js2.getJSONArray("DisData");
                        if (thirdArray.size() > 0) {

                            for (int k = 0; k < thirdArray.size(); k++) {


                                DisData disData = new DisData();
                                JSONObject js3 = thirdArray.getJSONObject(k);
                                disData.setId(js3.getLong("ID"));
                                disData.setDepId(dep2.getId());
                                disData.setName(js3.getString("DisName"));

                                depSevice.save(disData);

                                disList.add(disData);
                                Random random = new Random();
                                Thread.sleep(random.nextInt(100)+200);

                                //获取三级分类信息
                                int cpage = 1;
                                while (true) {
                                    String thirdUrl = "https://api.meditool.cn/Apicaselibrary/caselist?typemsg=%s&cpage=%s&usertoken=%s&userid=%s";
                                    thirdUrl = String.format(thirdUrl, URLEncoder.encode(disData.getName(),"utf-8"), cpage, token, userId);
                                    res = HttpClientUtil.doGet(thirdUrl);
                                    try {
                                        JSONObject js4 = JSONObject.parseObject(res);
                                        JSONArray fourthArray = js4.getJSONArray("data");


                                        if (fourthArray.size() < 1) {
                                            break;
                                        }
                                        for (int m = 0; m < fourthArray.size(); m++) {
                                            try {
                                                JSONObject js41 = fourthArray.getJSONObject(m);
                                                logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>");
                                                logger.info(js41.toString());

                                                DisDataCase disDataCase = new DisDataCase();

                                                disDataCase.setId(js41.getLong("ID"));
                                                disDataCase.setKeyWords(js41.getString("KeyWords"));
                                                disDataCase.setRemark(js41.getString("Remark"));
                                                disDataCase.setCaseLabel(js41.getString("CaseLabel"));
                                                disDataCase.setReadNum(js41.getString("ReadNum"));
                                                disDataCase.setGuid(js41.getString("Guid"));
                                                disDataCase.setBingshi(js41.getString("BingShi"));
                                                disDataCase.setPicUrl(js41.getString("PicUrl"));
                                                disDataCase.setPraiseNum(js41.getString("PraiseNum"));
                                                disDataCase.setPlNum(js41.getString("PLNum"));
                                                disDataCase.setDisdataId(disData.getId());
                                                depSevice.save(disDataCase);

                                                caseList.add(disDataCase);


                                            }catch (Exception e){
                                                logger.error("--------------------------  {}",fourthArray.getJSONObject(m));
                                                logger.error("处理失败",e);

                                            }

                                        }
                                    }catch (Exception e){
                                        logger.error("-------------------------- thirdUrl {}",thirdUrl);
                                        logger.error("处理失败",e);

                                    }


                                    cpage++;
                                }
                            }



                        }




                    }
                }

            }
        }

        logger.info("dep1 size {}",dlist1.size());
        logger.info("dep2 size {}",dlist1.size());
        logger.info("disdata size {}",disList.size());
        logger.info("caseData size {}",caseList.size());

    }


}
