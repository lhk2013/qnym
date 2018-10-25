package com.qnym.business;

import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.qnym.common.util.DateParserUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liuhaikuo on 2017/10/30.
 */
@Slf4j
public class TestRegStr {

    private static Logger logger = LoggerFactory.getLogger(TestRegStr.class);


    @Test
    public  void testPinyin(){
        String srcStr = "<script type=\"text/javascript\" src=\"./files/common/js/common.js\"></script>\n" +
                "<!--\n" +
                "-->\n" +
                "<!---->\n" +
                "<div class=\"alert alert-block\" id=\"alert-block\" style=\"padding-top:16px;margin-left:auto;margin-right:auto;width:450px;text-align:center;\">\n" +
                "    <strong>15021140009</strong>当前属于[楼玉娥]\n" +
                "    状态<span class=\"alert alert-block\" style=\"padding-top:16px;margin-left:auto;margin-right:auto;width:450px;text-align:center;\">[接触中] </span><br/>\n" +
                "    <p>由<strong>[楼玉娥]</strong>于<strong>2018-09-25 16:56:58</strong>创建</p>\n" +
                "</div>\n" +
                "<!---->  \n" +
                "<!---->";

        Pattern pattern = Pattern.compile("(([\\u4e00-\\u9fa5]|\\[|\\]|[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])\\s+(20|21|22|23|[0-1]\\d):[0-5]\\d:[0-5]\\d))");
        Matcher matcher = pattern.matcher(srcStr);
        String ss2 ="";
        while (matcher.find()) {
            ss2 += matcher.group(1);
        }
        logger.info("dtstr2 {}",ss2);


    }

}
