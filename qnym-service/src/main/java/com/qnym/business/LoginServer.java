package com.qnym.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LoginServer {
	final static Logger logger = LoggerFactory.getLogger(LoginServer.class);

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication
            .run(LoginServer.class, args);
		logger.info("----------->Member SSO Login Server Start Success<----------");
		context.registerShutdownHook();
	}
}
