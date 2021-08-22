package io.k8clusters.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

import static springfox.documentation.builders.RequestHandlerSelectors.any;

@Configuration
public class SpringFoxConfig implements WebMvcConfigurer {
    @Bean
    public Docket greetApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("greet")
                .apiInfo(metadata("sample-service", "sample-service deployment to cloud and test"))
                .select()
                .apis(any())
                .paths(PathSelectors.ant("/greet/**"))
                .build();
    }

    private ApiInfo metadata(String name, String description) {
        ApiInfo apiInfo = new ApiInfo(name, description, "v1",
                null, new Contact("Amit Kshirsagar", null, "amit.kshirsagar.13@gmail.com"), null, null,
                Collections.emptyList());
        return apiInfo;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
