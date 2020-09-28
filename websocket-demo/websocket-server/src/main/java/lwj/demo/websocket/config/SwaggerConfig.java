package lwj.demo.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

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

	public static final String SWAGGER_SCAN_BASE_PACKAGE = "lwj.demo.websocket.controller";

	@Bean
	public Docket v1Api() {
		List<Parameter> pars = new ArrayList<Parameter>();
		ParameterBuilder uidPar = new ParameterBuilder();
		uidPar.name("uid").description("uid").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
		pars.add(uidPar.build());
		ParameterBuilder cityIdPar = new ParameterBuilder();
		cityIdPar.name("city-id").description("city-id").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
		pars.add(cityIdPar.build());
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("v1")
				.genericModelSubstitutes(DeferredResult.class)
				.genericModelSubstitutes(ResponseEntity.class)
				.useDefaultResponseMessages(false)
				.forCodeGeneration(true)
				.pathMapping("/")	// base，最终调用接口后会和paths拼接在一起
				.select()
				.apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
				// .paths(or(regex("/api/.*")))//过滤的接口
				.build()
				.globalOperationParameters(pars)
				.apiInfo(v1ApiInfo());
	}

	private ApiInfo v1ApiInfo() {
		return new ApiInfoBuilder().title("websocket")
				.description("websocket")
				.version("0.0.1")
				.build();
	}
}
