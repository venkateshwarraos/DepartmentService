package com.dept.main.swagger;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class DepartmentSwagger {
	
	public Docket departmentApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.basePackage("com.dept.main"))
				.paths(PathSelectors.any())
				.build().apiInfo(metaData());
	}
	
	@SuppressWarnings("deprecation")
	private ApiInfo metaData()  {
		ApiInfo apiInfo = new ApiInfo("DepartmentService" , "This service used to manage department details", "1.0" , "http://localhost:8091/dept/department", "venkyrao1986@gmail.com", "", "");
		return apiInfo;
	}

}
