package com.lc.rabbit.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * api doc -- springfox swagger configuration
 */
@Configuration
@EnableSwagger2
//@Profile({"dev","localhost"})
public class Swagger2Configuration {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(paths())
                .build()
                .apiInfo(apiInfo());
    }

    private Predicate<String> paths() {
        return or(
                regex("/message.*")
                //,regex("/account.*")
        );
    }

    private ApiInfo apiInfo() {
        String title = "rabbit-service";
        String description = "消息队列";
        String version = "1.0.0-snapshot";
        Contact contact = new Contact("lc", "", "rabbit-service.com");
        ApiInfo apiInfo = new ApiInfo(title, description, version,
                "terms of rabbit", contact, "", "");
        return apiInfo;
    }
}
