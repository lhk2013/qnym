package com.qnym.business;

import com.qnym.common.util.RSAUtils;
import java.util.Map;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liuhaikuo on 2017/10/16.
 */
public class TestRSA {

    private static Logger logger = LoggerFactory.getLogger(TestRSA.class);

    @Test
    public  void compare(){

        Long ss= 99L;
        Long s1 = 99L;
        Integer s4 = 99;
        Double d1 = 99.2;
        Double d3= 99.2;
        Double d2= 99.20;

        if(ss == s1){
            System.out.print(1111);
        }
        if(d1 == d3){
            System.out.print(22222);
        }
    }

    @Test
    public  void testRSA()throws Exception{
        String accout = "lhk2013";
        String pwd = "lhk1990211";
        Map<String, byte[]> mp =  RSAUtils.initKey();
        String pubKey = new String(RSAUtils.encryptBASE64(mp.get(RSAUtils.PUBLIC_KEY)));
        String priKey = new String(RSAUtils.encryptBASE64(mp.get(RSAUtils.PRIVATE_KEY)));

        logger.info("ff: {}",new String(mp.get(RSAUtils.PUBLIC_KEY)));
        logger.info("public_key: {}",pubKey);
        logger.info("private_key: {}",priKey);

        byte[] rsaAcc = RSAUtils.encryptByPublicKey(accout.getBytes(),pubKey);
        byte[] rsaPwd = RSAUtils.encryptByPublicKey(pwd.getBytes(),pubKey);
        String acc1 = RSAUtils.encryptBASE64(rsaAcc);
        String pwd1 = RSAUtils.encryptBASE64(rsaPwd);
        logger.info(acc1);
        logger.info(pwd1);

        byte[] deRsaAcc=RSAUtils.decryptByPrivateKey(RSAUtils.decryptBASE64(acc1),priKey);
        byte[] deRsaPwd=RSAUtils.decryptByPrivateKey(RSAUtils.decryptBASE64(pwd1),priKey);

        String acc2 = new String(deRsaAcc);
        String pwd2 = new String(deRsaPwd);
        logger.info(acc2);
        logger.info(pwd2);
    }

}
