package lwj.demo.quklive.swagger;

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
 * SwaggerConfig
 * 
 * @author liuweijia
 * @date 2017年10月12日 下午5:50:26
 * @since 1.0.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final String SWAGGER_SCAN_BASE_PACKAGE = "lwj.demo.quklive.controller";

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
				// .paths(or(regex("/api/.*")))//过滤的接口
				.build().apiInfo(v1ApiInfo());
	}

	private ApiInfo v1ApiInfo() {
		return new ApiInfoBuilder().title("趣看服务")
				.description("趣看服务")
				.version("1.0")
				.build();
	}
}
