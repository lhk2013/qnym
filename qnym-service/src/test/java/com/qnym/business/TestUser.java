package com.qnym.business;

import com.qnym.business.repository.entity.ExUser;
import com.qnym.business.repository.entity.IDCard;
import com.qnym.business.repository.entity.User;
import com.qnym.business.service.ExUserService;
import com.qnym.business.service.IDCardService;
import com.qnym.business.service.UserService;
import com.qnym.common.util.RandomUtils;
import com.qnym.common.util.SerializableUtils;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * Created by liuhaikuo on 2017/10/28.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestUser {

    @Autowired
    private UserService userService;

    @Autowired
    private ExUserService exUserService;

    @Test
    public  void testSaveUser()throws Exception{

        Long d1 = System.currentTimeMillis();
        log.info("");
        for (int i=2153716;i<10000000;i++){
            User user = new User();
            String account = RandomUtils.randomUniqueToken();
            Date dt = new Date();
            user.setAccount(account);
            user.setNickName("小飞侠".concat(String.valueOf(i)));
            user.setPhone(String.valueOf(i|18812345678L));
            user.setCreateTime(dt);
            user.setCreateTimeStamp(dt.getTime());
            user.setStatus(i&2);
            userService.save(user);
//            log.info("{}",i);
        }
        Long d2 = System.currentTimeMillis();
        log.info("fuck time {} ", d2-d1);

//        log.info("fuck {} ", SerializableUtils.OBJECT_MAPPER.writeValueAsString(user));

    }

    @Test
    public  void testSaveUser2()throws Exception{

        String url = "http://202.85.213.22:8090/admin.php?action=crm&oper=crmadd&ex=i";
        String cookie = "PHPSESSID_SUSERP=qjfb05th1eubei07l9f2v2jre3;td_cookie=18446744070499707755";

        List<ExUser> list = exUserService.listAll();
        list.clear();
        ExUser exUser1= new ExUser();
        exUser1.setMob("13917411153");
        exUser1.setName("樊韫杰");
        exUser1.setId(332L);
        list.add(exUser1);
        log.error(">>>>>>>>>>>>>当前数据 {}条",list.size());
        int index = 0;
        Random random = new Random();
        for (ExUser exUser : list) {
            log.info("doing 用户id:{} 手机号:{} 姓名:{} ",exUser.getId(),exUser.getMob(),exUser.getName());
            Map<String,String> map = new HashMap<>();


            map.put("realname",exUser.getName());
            map.put("mobile",exUser.getMob());
            map.put("ccid","0");
            map.put("pid","1");
            map.put("priority","0");
            map.put("cstatus","接触中");
            map.put("firstsource","数据分配");
            map.put("sex","2");
            map.put("age","0");
            map.put("reachedintent","");
            map.put("contactform","电话");
            map.put("nexttime","");
            map.put("contactplace","公司");



            String content = HttpUtils.doPostForm(url,cookie,FormUtils.ParseFormForMap(map));
            log.info("==================================>>");
            log.info("content:{}",content);
            exUser.setResult(content);
            exUserService.updateResultById(exUser.getResult(),exUser.getId());
            index++;
            Thread.sleep(random.nextInt(500));
            log.info("done 条 用户id:{} 手机号:{} 姓名:{} ",index,exUser.getId(),exUser.getMob(),exUser.getName());

        }


//        log.info("fuck {} ", SerializableUtils.OBJECT_MAPPER.writeValueAsString(user));

    }


    @Test
    public  void testFindUser3()throws Exception{

        String url = "http://202.85.213.22:8090/admin.php?action=crm&oper=mobilesearch&ex=s";
        String cookie = "PHPSESSID_SUSERP=tn06kj6t5p758h7ahan9nn68i4";

        List<ExUser> list = exUserService.listAll();
        log.error(">>>>>>>>>>>>>当前数据 {}条",list.size());
        int index = 0;
        Random random = new Random();
        for (ExUser exUser : list) {
            log.info("doing 用户id:{} 手机号:{} 姓名:{} ",exUser.getId(),exUser.getMob(),exUser.getName());
            Map<String,String> map = new HashMap<>();


            map.put("mobile","15921080799");




            String content = HttpUtils.doPostForm2(url,cookie,FormUtils.ParseFormForMap(map));
            log.info("==================================>>");
            log.info("content:{}",content);
            exUser.setResult(content);
//            exUserService.updateResultById(exUser.getResult(),exUser.getId());
            index++;
            Thread.sleep(random.nextInt(500));
            log.info("done 条 用户id:{} 手机号:{} 姓名:{} ",index,exUser.getId(),exUser.getMob(),exUser.getName());

        }


//        log.info("fuck {} ", SerializableUtils.OBJECT_MAPPER.writeValueAsString(user));

    }


}
