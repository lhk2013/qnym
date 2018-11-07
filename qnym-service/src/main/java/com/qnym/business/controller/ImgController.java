package com.qnym.business.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author LiuHaiKuo 2018-10-11 13:38:28
 */

@RestController
@RequestMapping("/pic")
@Api(value = "图片上传接口")
public class ImgController {

    private Logger logger = LoggerFactory.getLogger(ImgController.class);


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ApiOperation(value = "上传图片", httpMethod = "POST", notes = "上传图片返回url")
    public void picUplod(@RequestParam("file") MultipartFile img) {
        String s = "";
        String ss2 = img.getName();
        if (img == null) {

            logger.info("图片是空的");
        }

    }


}
