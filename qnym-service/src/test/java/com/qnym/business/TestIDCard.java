package com.qnym.business;

import com.qnym.business.service.IDCardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by liuhaikuo on 2017/10/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ImportResource({"/spring-mvc.xml"})
public class TestIDCard {

    @Autowired
    private IDCardService idCardService;

    @Test
    public  void testFindIDCard()throws Exception{

//        IDCard idCard = idCardService.findByIdNumber("11010219901236891x");
//        log.info("fuck {} ", SerializableUtils.OBJECT_MAPPER.writeValueAsString(idCard));

    }
}
