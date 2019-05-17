package com.qnym.business;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class HttpClientUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
    /**
     * 连接超时时间
     */
    public static final int CONNECTION_TIMEOUT_MS = 360000;

    /**
     * 读取数据超时时间
     */
    public static final int SO_TIMEOUT_MS = 360000;

    private static final String imgUploadPath = "img/health/applet/wxcode/";

    private HttpClientUtil() {
    }
    private static final String CHARSET = CharEncoding.UTF_8;
    private static CloseableHttpClient httpClient = null;
    private static RequestConfig requestConfig=null;
    static {
        httpClient= HttpClients.createDefault();
        requestConfig= RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setMaxRedirects(2)
                .build();

    }

    /**
     * 绕过验证
     *
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance("SSLv3");

        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };

        sc.init(null, new TrustManager[] { trustManager }, null);
        return sc;
    }
    public static String doPostHttps(String uri, String reqStr, Header[] headers, String charset ){
        //采用绕过验证的方式处理https请求
        HttpPost httpPost = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        StringEntity stringEntity = null;
        CloseableHttpClient client=null;
        try{
            SSLContext sslcontext = createIgnoreVerifySSL();
            // 设置协议http和https对应的处理socket链接工厂的对象
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", new SSLConnectionSocketFactory(sslcontext))
                    .build();
            PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            HttpClients.custom().setConnectionManager(connManager);
            //创建自定义的httpclient对象
            client = HttpClients.custom().setConnectionManager(connManager).build();
            httpPost = new HttpPost(StringUtils.trim(uri));
            if(headers !=null){
                httpPost.setHeaders(headers);
            }
            if(StringUtils.isEmpty(charset)){
                charset=CHARSET;
            }
            stringEntity = new StringEntity(reqStr, charset);
            httpPost.setEntity(stringEntity);
            httpPost.setConfig(requestConfig);
            response = client.execute(httpPost);
            int status = response.getStatusLine().getStatusCode();
            // 获取响应内容
            String retData = null;
            if (null != response) {
                entity = response.getEntity();
                retData = StringEscapeUtils.unescapeJava(StringUtils.trim(EntityUtils.toString(entity, charset)));
            }
            if (HttpStatus.SC_OK == status) { // 请求成功
                logger.info("请求结果："+retData);
                return retData;
            }

        } catch (Exception e) { // 读取响应错误
            e.printStackTrace();
        } finally {
            try {
                if (null != stringEntity)
                    EntityUtils.consume(stringEntity);
                if (httpPost != null)
                    httpPost.abort();  // 释放连接资源
                if (response!=null)
                    response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "error";
    }

    public static String doPost(String uri, String reqStr, Header[] headers, String charset ){

        HttpPost httpPost = null;
        HttpResponse response = null;
        HttpEntity entity = null;
        StringEntity stringEntity = null;
        try {
            httpPost = new HttpPost(StringUtils.trim(uri));
            if(headers !=null){
                httpPost.setHeaders(headers);
            }
            if(StringUtils.isEmpty(charset)){
                charset=CHARSET;
            }
            stringEntity = new StringEntity(reqStr, charset);
            httpPost.setEntity(stringEntity);
            httpPost.setConfig(requestConfig);
            response = httpClient.execute(httpPost);
            int status = response.getStatusLine().getStatusCode();
            // 获取响应内容
            String retData = null;
            if (null != response) {
                entity = response.getEntity();
                retData = StringEscapeUtils.unescapeJava(StringUtils.trim(EntityUtils.toString(entity, charset)));
            }
            logger.info("请求结果：status="+status+" retData=" +retData);
            if (HttpStatus.SC_OK == status) { // 请求成功
                return retData;
            }
        } catch (Exception e) { // 读取响应错误
            e.printStackTrace();
        } finally {
            try {
                if (null != stringEntity){
                    EntityUtils.consume(stringEntity);
                }
                if (httpPost != null){
                    httpPost.abort();  // 释放连接资源
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "error";
    }


    public static String doGet(String uri){

        HttpGet httpGet = null;
        HttpResponse response = null;
        HttpEntity entity = null;
        StringEntity stringEntity = null;
        try {
            httpGet = new HttpGet(StringUtils.trim(uri));
            httpGet.setConfig(requestConfig);
            response = httpClient.execute(httpGet);
            int status = response.getStatusLine().getStatusCode();
            // 获取响应内容
            String retData = null;
            if (null != response) {
                entity = response.getEntity();
                retData = StringUtils.trim(EntityUtils.toString(entity, CHARSET));
//                retData = StringEscapeUtils.unescapeJava(result);
            }
            if (HttpStatus.SC_OK == status) { // 请求成功
                return retData;
            }
        } catch (Exception e) { // 读取响应错误
            e.printStackTrace();
        } finally {
            try {
                if (null != stringEntity)
                    EntityUtils.consume(stringEntity);
                if (httpGet != null)
                    httpGet.abort();  // 释放连接资源
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "error";
    }
}
