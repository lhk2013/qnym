package com.qnym.business.dojob;

import com.alibaba.fastjson.JSONObject;
import com.qnym.business.repository.entity.Dep;
import com.qnym.business.service.DepSevice;
import com.qnym.business.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DoJob implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(DoJob.class);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        DepSevice depSevice = applicationContext.getBean(DepSevice.class);
        List<Dep> list = depSevice.findAll();
        logger.error("===============================");
        logger.error(JSONObject.toJSONString(list));

    }
}
