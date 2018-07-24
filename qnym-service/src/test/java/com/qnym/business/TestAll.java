package com.qnym.business;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JavaType;
import com.qnym.business.domain.IDCardInfo;
import com.qnym.common.util.ConsistentHash;
import com.qnym.common.util.HashFunction;
import com.qnym.common.util.SerializableUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by liuhaikuo on 2017/10/16.
 */
public class TestAll {

    private static Logger logger = LoggerFactory.getLogger(TestAll.class);



    @Test
    public void testRSA2()throws Exception{
        Integer x = 0XF;
        Integer y = 0xff;

//        KETAMA_HASH;
        logger.info("{}",(109&0xFF)<<30);
        logger.info("{}",Integer.toBinaryString(x));

    }

    @Test
    public void  testmain() {
        Set<String> nodes = new HashSet<String>();
        nodes.add("A");
        nodes.add("B");
        nodes.add("C");

        ConsistentHash<String> consistentHash = new ConsistentHash<String>(new HashFunction(), 1, nodes);
        consistentHash.add("D");

        System.out.println("hash circle size: " + consistentHash.getSize());
        System.out.println("location of each node are follows: ");
        consistentHash.testBalance();
        System.out.println("hash circle size: "+consistentHash.get("229881"));
    }


    @Test
    public void  testStr2Big() throws Exception{
        Object s1 = "0";
        Object s2 = "0.0";
        Object s3 = "0.00";
        Object s4 = "0.01";
//        BigDecimal b1 = (BigDecimal)s1;
//        BigDecimal b2 = (BigDecimal)s2;
//        BigDecimal b3 = (BigDecimal)s3;
//        BigDecimal b4 = (BigDecimal)s4;
//
//        logger.info("b1 b2 b3 b4 : {} {} {} {}",b1,b2,b3,b4);

        Object s5 = new BigDecimal("0.01");
        BigDecimal b5 = (BigDecimal)s5;

        logger.info("b5 {}",b5);

        String ss1 = "{\"salesInfo\":[{\"idNumber\":0,\"realName\":\"100000\"}]}\n";
        String ss2 = "{\"salesInfo\":[]}";

        Object ob1 = ss1;
        Object ob2 = ss2;

        JSONObject jb1 = JSONObject.parseObject( String.valueOf(ob1));
        JSONObject jb2 = JSONObject.parseObject(ob2.toString());



        String listJson =jb1.get("salesInfo").toString();
        JavaType javaType = SerializableUtils.OBJECT_MAPPER.getTypeFactory().constructParametricType(ArrayList.class, IDCardInfo.class);
        List<IDCardInfo> infoList = (List<IDCardInfo>)SerializableUtils.OBJECT_MAPPER.readValue(listJson, javaType);


        LoginServer loginServer = new LoginServer();
        logger.info(loginServer.toString());
        logger.info("{} -- {}",jb1,jb2);

    }


}
