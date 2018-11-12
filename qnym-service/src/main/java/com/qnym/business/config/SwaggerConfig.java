package com.qnym.business.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket qnymApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("qnym").apiInfo(this.einvoiceApiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.qnym.business.controller")).paths(this.loginPath()).build();
    }

    //PathSelectors.any()

    @SuppressWarnings("unchecked")
    private Predicate<String> loginPath() {
        //此处使用正则 注意正则范围
        return Predicates.or(PathSelectors.regex(".*.*"));
    }

    private ApiInfo einvoiceApiInfo() {
        return new ApiInfoBuilder().title("qnym相关api").description("提供登录验证相关业务")
                .termsOfServiceUrl("http://springfox.io").license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .version("2.0").build();
    }

}
