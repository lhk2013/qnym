package com.qnym.business;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liuhaikuo on 2017/10/16.
 */
public class TestForm {

    private static Logger logger = LoggerFactory.getLogger(TestForm.class);

    @Test
    public  void formTest(){
        StringBuilder sb = new StringBuilder();

        SignInfo signInfo = new SignInfo();
        sb.append("<body>\n");
        sb.append("<form action=\"").append(signInfo.getActionUrl()).append("\" id=\"signForm\" method=\"post\">\n<div>\n");

        sb.append("<input type=\"hidden\" name=\"api_key\" value=\"").append(signInfo.getApiKey()).append("\"/>\n");
        sb.append("<input type=\"hidden\" name=\"api_secret\" value=\"").append(signInfo.getApiSecret()).append("\"/>\n");
        sb.append("<input type=\"hidden\" name=\"return_url\" value=\"").append(signInfo.getReturnUrl()).append("\"/>\n");
        sb.append("<input type=\"hidden\" name=\"document_no\" value=\"").append(signInfo.getDocumentNo()).append("\"/>\n");
        sb.append("<input type=\"hidden\" name=\"picture\" value=\"").append(signInfo.getPicture()).append("\"/>\n");
        sb.append("<input type=\"hidden\" name=\"seal_strategy_id\" value=\"").append(signInfo.getSealStrategyId()).append("\"/>\n");
        sb.append("<input type=\"hidden\" name=\"pdf\" value=\"").append(signInfo.getPdf()).append("\"/>\n");
        sb.append("<input type=\"hidden\" name=\"pdfFile\" value=\"").append(signInfo.getPdfFile()).append("\"/>\n");
        sb.append("<input type=\"hidden\" name=\"guid\" value=\"").append(signInfo.getGuid()).append("\"/>\n");
        sb.append("<input type=\"hidden\" name=\"position\" value=\"").append(signInfo.getPosition()).append("\"/>\n");
        sb.append("<input type=\"hidden\" name=\"time\" value=\"").append(signInfo.getTime()).append("\"/>\n");
        sb.append("<input type=\"hidden\" name=\"api_sign\" value=\"").append(signInfo.getApiSign()).append("\"/>\n");

        sb.append("</div>\n<div>\n<input type=\"submit\" value=\"签章\"/>\n</div>\n</form>\n");
        sb.append("<script type=\"text/javascript\">\n" +
                "window.onload=function autoSubmit(){\n" +
                "  document.getElementById('signForm').submit();\n" +
                "};\n" +
                "</script>");
        sb.append("</body>\n");
        logger.info(sb.toString());
    }


    @Test
    public  void sumTest(){

        logger.info("{}",1&3);
        logger.info("{}",1|3123213);


    }
}
