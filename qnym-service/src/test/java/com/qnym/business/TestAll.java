package com.qnym.business;

import com.qnym.common.util.ConsistentHash;
import com.qnym.common.util.HashFunction;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
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

}
