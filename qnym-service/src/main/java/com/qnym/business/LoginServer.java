package com.qnym.business;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author liuhaikuo
 */

@SpringBootApplication
@EnableSwagger2
@ImportResource({"/spring-mvc.xml"})
public class LoginServer {
	final static Logger logger = LoggerFactory.getLogger(LoginServer.class);

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication
            .run(LoginServer.class, args);
		logger.info("----------->QNYM LOGIN Server Start Success<----------");
		context.registerShutdownHook();
	}

	@Bean
	public Docket qnymApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("qnym").apiInfo(this.einvoiceApiInfo())
			.select().apis(RequestHandlerSelectors.basePackage("com.qnym.business.controller")).paths(this.loginPath()).build();
	}

	@SuppressWarnings("unchecked")
	private Predicate<String> loginPath() {
		//此处使用正则 注意正则范围
		return Predicates.or(PathSelectors.regex(".*login.*"));
	}
	private ApiInfo einvoiceApiInfo() {
		return new ApiInfoBuilder().title("qnym相关api").description("提供登录验证相关业务")
			.termsOfServiceUrl("http://springfox.io").license("Apache License Version 2.0")
			.licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
			.version("2.0").build();
	}
}
