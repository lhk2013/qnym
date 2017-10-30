package com.qnym.business;

import com.qnym.business.repository.entity.IDCard;
import com.qnym.business.service.IDCardService;
import com.qnym.common.util.SerializableUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by liuhaikuo on 2017/10/28.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestIDCard {

    @Autowired
    private IDCardService idCardService;

    @Test
    public  void testFindIDCard()throws Exception{

        IDCard idCard = idCardService.findByIdNumber("11010219901236891x");
        log.info("fuck {} ", SerializableUtils.OBJECT_MAPPER.writeValueAsString(idCard));

    }
}
