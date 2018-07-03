package com.qnym.business;

import com.qnym.common.util.SignatureUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class TestSignatureUtil {

    private static final Logger logger = LoggerFactory.getLogger(TestSignatureUtil.class);

    @Test
    public void testSignature(){
        String appid="1200";
        String signature="";
        String secret = "yhyc#fxjr4TEST"; //签名秘钥
        long timestamp= System.currentTimeMillis()/1000;  //当前时间 :秒
        String signature_method="md5";
        Map<String,String> params = new HashMap<String,String>();
        params.put("appid", appid);
        params.put("enterprise_id", "1001");
        params.put("timestamp",String.valueOf( timestamp));
        params.put("signature_method", signature_method);

        try {
            signature = SignatureUtils.getSignature(params,secret);
            logger.info("appid={}&signature={}&timestamp={}&signature_method=md5&enterprise_id=1001",appid,signature,
                    ""+timestamp);
        }catch (Exception e){

        }
     }
}
