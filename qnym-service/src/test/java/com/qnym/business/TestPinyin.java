package com.qnym.business;

import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.qnym.common.util.DateParserUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        Date date = new Date();date.toLocaleString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String dtStr = simpleDateFormat.format(date);
        log.info(date.toGMTString());
        log.info(dtStr);
        String dtStr2 = DateParserUtils.parseAHSDateString(date);
        log.info("dtstr2 {}",dtStr2);
    }

}
