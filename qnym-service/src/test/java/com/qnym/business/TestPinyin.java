package com.qnym.business;

import com.github.stuxuhai.jpinyin.PinyinHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created by liuhaikuo on 2017/10/30.
 */
@Slf4j
public class TestPinyin {

    @Test
    public  void testPinyin(){
        String srcStr = "最长的电影是生长在乡村的樱花";
        String pinStr = PinyinHelper.getShortPinyin(srcStr);
        log.info(pinStr);
    }

}
