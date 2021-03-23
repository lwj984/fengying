package lwj.demo.drools.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String SWAGGER_SCAN_BASE_PACKAGE = "lwj.demo.drools.controller";

    @Bean
    public Docket v1Api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("v1")
                .genericModelSubstitutes(DeferredResult.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .build()
                .apiInfo(v1ApiInfo());
    }

    private ApiInfo v1ApiInfo() {
        return new ApiInfoBuilder().title("模拟接口")
                .description("模拟接口")
                .version("1.0")
                .build();
    }
}

