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

    @Test
    public void testRSA2()throws Exception{
        String key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCUOGHXUxQhYt6f8hWguLXAUBCZQRNNHJ3aos+Gwi1bjciPBVRWQYAGBzLfQUyRIDj8C4sukeZ+uZOgqT4W+MgF2xpRPfIF93dXBJ8PNqL7prgLn3DnZ+b+QyiDamUaNLbIeGGhGxsQsfjR/0QjStoZlSQwVVHzu400f4R+goyEDEbyz/n2FS96fF8g/EWIK87yFYETYJ8nNjAOdXvu571+cBPbeBJtbOncl5vKkcRzPA0EjZbehdP/2n522/gJUx4XSIm3hyuyHW7epHwbXf9a+d6zB0gtFqTfNEhJO0GY7hViHHoLYRERuw9ZDM3lQ/Gr5/PIU9RWnJkC0cM4oEC9AgMBAAECggEAFBg0w5GC2CfkUMDsR7bjBSiVp4FYEYtAp2SNSBLJPXFScHljfrIwniCZuATNUZuRvjH+c5jaK/IS3qQzQ8AEti6HOd5xEngDWOvKeLCKlh17NDAwiV7fxTbrpi1leZEN+s2/Rq07FR9bwXSfEz3Rpcg/eMIIc0fJFAX5u4ENddVTaTgxSOhGC0cm6XzLT6dj2mWqt7+bI7jdt1m8nnaAmIDVJFvgPK6FauJ+XBuH/OttYtAaFOBG4KLUlAyI47KKBSWwUvzjx3UH9oUT8GljylQNoNGP18OPLZVN4CnWy1BCsv43+4GZIXF96fd4z9NWcN3OJNEw+/89z+L+8Ng04QKBgQDKnXRnDn2/WOTtBPiN4g8xdEqQ+2hmS+l6MnalRvEIz63Eb8btl6FtiuxFu1CfIAH0TkSNoemaDvqeL4DPi+DUYCT4N3GdDT7ngE79fUjLReNokcmAO5szUENjdQ3AmY66bmmN1kIkr0z1viYJc5UlR+bhbOXJ6YZJ9UZCZY3QBQKBgQC7RfRS4VK4qlv/9trPLQVgrJHFNWDB6KPE+s/YlK8/tAxXDO1CNTqrrN0eB9LvUToWdS7+FkAXOWd9qBsF6IBxbZ4YRCXX0WtEKWAOO/dnx8Jb09+/FqONaoIJ3kyYCxGeVlsLgYPdSRX7FE5/xmqXXpvwbUFUS9S1P14SGi1jWQKBgQCcDiwymBG4SFKCT/rU5RGIqKYqBsmBSOS6LpX9dKd/ft2619Di/I/kHEUg7EYLWY7HyWS5pcST2QekwLe4o2b2jFrNJ38FVMdnbQbp7Q4dKmYeC3OkpcRDAIX225hNCLjK1PHNwgHN2YswF1WaoAB252tnowVVv9yjqBuGVkuktQKBgQCm0bLJnXO9keuwACp7wIP40OBtBpZxRRWVY0KAkDnoCi+v35D9mELyKGMz3A5XJkkTNkGtDw76YSVCNtwTkD/SSq44uYPoUuE1b5HkPCCv7q7Ac+Ts6HK6hzTdK4uZKMsB+7TQdAeNuAv/g+BFS+8pdZp9OiWmvIH3DkJy56SkyQKBgDd9BDGsyUQHjJJ1nF1Nd1Adpl1b9qDmt4IsbCvd0rCBfw1lbInNOWEkM9DGD88vRkmnnu8lC0CIhOnzlHCwDEy1IiKefDircnBaYQW4E6qptNZrGW/01yYP5e9pQs698vzem2rgAqoFRo+DqpAn2vACM1af3HLSHzmlt5EofKDk";
        String value = "AxOFLUbarIw+5XmT4tIJYH+mPign6eGCuAcCeAflOvxURvcmp9OlE+CNd/r2+NhM/q/hrTmB98OnEeYe/zzeQQ9vJrW2mB/ePpik80AICr0uf2kwPwdIZBxKNiUoo0+t1j1XJm0nRD6hXSoqHM4LcMlOTd19StIGP0Cx89324FCuWAvB0sP44b3+GPpwVNZoI9rVoYmMfyaI7IRp1wV9A86w5VFrS5UQ4Uh3iK+UoSPvcCtARgNZv4t8sU3y81avrvM9oKxz67aXHbBGt1ITrc/7QSf1/W8izS50INPPnU8dMTX5S0e9TkvI3167qMfAmosOz5PHzt0UrX6ojvZkPA==";
        byte[] deRsaPwd=RSAUtils.decryptByPrivateKey(RSAUtils.decryptBASE64(value),key);
        String pwd2 = new String(deRsaPwd);

        logger.info("f decode {}",pwd2);

    }

}
