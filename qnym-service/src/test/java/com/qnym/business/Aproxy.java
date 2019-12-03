package com.qnym.business;

import com.qnym.business.repository.entity.IDCard;
import com.qnym.business.service.IDCardService;
import com.qnym.common.util.SerializableUtils;
import lombok.extern.slf4j.Slf4j;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.InetSocketAddress;
import java.net.URL;
import java.net.URLDecoder;

/**
 * Created by liuhaikuo on 2017/10/28.
 */
public class Aproxy {

    @Autowired
    private IDCardService idCardService;

    @Test
    public void testFindIDCard() throws Exception {

        // open yahoo.com
        String base_url = "https://h5.waimai.meituan.com/waimai/mindex/menu?mtShopId=934294019092390&initialLat=23.125207&initialLng=113.302035&actualLat=31.201409&actualLng=121.58195&source=searchresult";


        BrowserMobProxy server = new BrowserMobProxyServer();
        server.enableHarCaptureTypes(CaptureType.REQUEST_BINARY_CONTENT.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        server.start();
        int port = server.getPort();
        server.addRequestFilter((request, content, info) -> {
            try {
                String q = URLDecoder.decode(info.getOriginalUrl(), "UTF-8");
                System.out.println("Request: " + q);
            } catch (Exception e) {

            }
            return null;
        });

        server.addResponseFilter((response, content, info) -> {
            String type = response.headers().get("Content-Type");
            System.out.println("Response: " + info.getOriginalRequest());
            System.out.println(type);
        });

        Proxy proxy = ClientUtil.createSeleniumProxy(server);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(CapabilityType.PROXY, proxy);
        capabilities.setCapability("marionette", true);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
        FirefoxProfile fp = new FirefoxProfile();
        capabilities.setCapability(FirefoxDriver.PROFILE, fp);
        String gecko = "d:/Programming/java/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", gecko);
        FirefoxDriver driver = new FirefoxDriver(capabilities);
        driver.get("https://google.com");
        ;


    }

    @Test
    public void tt() {
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(0);

        // get the Selenium proxy object
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        // configure it as a desired capability
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

        // start the browser up
        WebDriver driver = new ChromeDriver(capabilities);

        // enable more detailed HAR capture, if desired (see CaptureType for the complete list)
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

        // create a new HAR with the label "yahoo.com"
        proxy.newHar("baidu.com");

        // open yahoo.com
        driver.get("http://www.baidu.com");

        // get the HAR data
        Har har = proxy.getHar();
    }
}
