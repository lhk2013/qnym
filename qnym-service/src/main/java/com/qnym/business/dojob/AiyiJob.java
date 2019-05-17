package com.qnym.business.dojob;

import com.qnym.business.HttpClientUtil;
import com.qnym.business.repository.entity.DisDataCaseDetailPic;
import com.qnym.business.service.DepSevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Component
public class AiyiJob {

    private static final Logger logger = LoggerFactory.getLogger(AiyiJob.class);

    @Autowired
    private DepSevice depSevice;

    @PostConstruct
    public void spider() throws Exception {

        String token = "8a1df843b0fb13354d800932e4af2d2d";
        String userId = "881211";

        String url = "bingli.iiyi.com/show/54450-1.html";


        String content = HttpClientUtil.doGet(url);
        logger.info("********************start*****************");
        logger.info(content);
        logger.info("********************end*****************");



    }

    /**
     * @param args
     * @throws Exception
     */
    public static void download(String urlString, String filename, String savePath) {

        try {


            // 构造URL
            URL url = new URL(urlString);
            // 打开连接
            URLConnection con = url.openConnection();
            // 设置请求超时为5s
            con.setConnectTimeout(5 * 1000);
            // 输入流
            InputStream is = con.getInputStream();
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流
            File sf = new File(savePath);
            if (!sf.exists()) {
                sf.mkdirs();
            }
            OutputStream os = new FileOutputStream(sf.getPath() + File.separatorChar + filename);
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            // 完毕，关闭所有链接
            os.close();
            is.close();
        } catch (Exception e) {
            logger.error("error 下载 ",e);
        }
    }


}
