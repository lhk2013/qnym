package com.qnym.business;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.Cookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpUtils {

    /**
     * 发送POST请求
     *
     * @param url  请求url
     * @param data 请求数据
     * @return 结果
     */
    @SuppressWarnings("deprecation")
    public static String doPost(String url, String data) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(10000).setConnectTimeout(20000)
                .setConnectionRequestTimeout(10000).build();
        httpPost.setConfig(requestConfig);
        String context = StringUtils.EMPTY;
        if (!StringUtils.isEmpty(data)) {
            StringEntity body = new StringEntity(data, "utf-8");
            httpPost.setEntity(body);
        }


        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        //传递2个参数  name和password
        nvps.add(new BasicNameValuePair("name","王五"));
        nvps.add(new BasicNameValuePair("password","12345"));
        //转码  封装成请求实体
        HttpEntity reqEntity = new UrlEncodedFormEntity(nvps, Consts.UTF_8);

        httpPost.setEntity(reqEntity);


        // 设置回调接口接收的消息头
        httpPost.addHeader("Content-Type", "application/json");
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            context = EntityUtils.toString(entity, HTTP.UTF_8);
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                response.close();
                httpPost.abort();
                httpClient.close();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        return context;
    }

    /**
     * 解析出url参数中的键值对
     *
     * @param url url参数
     * @return 键值对
     */
    public static Map<String, String> getRequestParam(String url) {

        Map<String, String> map = new HashMap<String, String>();
        String[] arrSplit = null;

        // 每个键值为一组
        arrSplit = url.split("[&]");
        for (String strSplit : arrSplit) {
            String[] arrSplitEqual = null;
            arrSplitEqual = strSplit.split("[=]");

            // 解析出键值
            if (arrSplitEqual.length > 1) {
                // 正确解析
                map.put(arrSplitEqual[0], arrSplitEqual[1]);
            } else {
                if (arrSplitEqual[0] != "") {
                    map.put(arrSplitEqual[0], "");
                }
            }
        }
        return map;
    }
    /**
     * 发送POST请求
     *
     * @param url  请求url
     * @return 结果
     */
    @SuppressWarnings("deprecation")
    public static String doPostForm(String url, String cookie, List<NameValuePair> valuePairs) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(10000).setConnectTimeout(20000)
                .setConnectionRequestTimeout(10000).build();
        httpPost.setConfig(requestConfig);
        String context = StringUtils.EMPTY;

        //转码  封装成请求实体
        HttpEntity reqEntity = new UrlEncodedFormEntity(valuePairs, Consts.UTF_8);
        httpPost.setEntity(reqEntity);

        // 设置回调接口接收的消息头
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;");
        httpPost.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        httpPost.addHeader("Cache-Control","no-cache");
        httpPost.addHeader("Origin","chrome-extension://aicmkgpgakddgnaphhhpliifpcfhicfo");
        httpPost.addHeader("Accept","*");
        httpPost.addHeader("Accept-Encoding","gzip, deflate");
        httpPost.addHeader("Accept-language","zh-CN,zh;q=0.9");
        httpPost.addHeader("Cookie",cookie);
        httpPost.addHeader("Connection","keep-alive");
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            context = EntityUtils.toString(entity, HTTP.UTF_8);
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                response.close();
                httpPost.abort();
                httpClient.close();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        return context;
    }


    /**
     * 发送POST请求
     *
     * @param url  请求url
     * @return 结果
     */
    @SuppressWarnings("deprecation")
    public static String doPostForm2(String url, String cookie, List<NameValuePair> valuePairs) throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(10000).setConnectTimeout(20000)
                .setConnectionRequestTimeout(10000).build();
//        httpPost.setConfig(requestConfig);
        String context = StringUtils.EMPTY;




        URI uri = URIUtils.createURI("http", "202.85.213.22", 8090, "/admin.php?action=crm&oper=crmadd&ex=i",
                URLEncodedUtils.format(valuePairs, "UTF-8"), null);
        HttpPost httpPost = new HttpPost(uri);

        // 设置回调接口接收的消息头
        httpPost.addHeader("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundarybwiPA0VvaKsxSvxH");
        httpPost.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        httpPost.addHeader("Cache-Control","no-cache");
        httpPost.addHeader("Origin","chrome-extension://aicmkgpgakddgnaphhhpliifpcfhicfo");
        httpPost.addHeader("Accept","*");
        httpPost.addHeader("Accept-Encoding","gzip, deflate");
        httpPost.addHeader("Accept-language","zh-CN,zh;q=0.9");
        httpPost.addHeader("Cookie",cookie);
        httpPost.addHeader("Connection","keep-alive");
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            context = EntityUtils.toString(entity, HTTP.UTF_8);
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                response.close();
                httpPost.abort();
                httpClient.close();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        return context;
    }


    public static void main(String[] args) {

    }
}


