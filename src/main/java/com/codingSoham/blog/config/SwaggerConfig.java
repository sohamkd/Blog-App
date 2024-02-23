package com.codingSoham.blog.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	public static final String AUTHORIZTION_HEADER="Authorization";
	
	private ApiKey apiKeys()
	{
		return new ApiKey("JWT", AUTHORIZTION_HEADER, "header");
	}
	
	private List<SecurityContext> securitycontexts()
	{
		return Arrays.asList(SecurityContext.builder().securityReferences(sf()).build());
	}
	
	private List<SecurityReference> sf()
	{
		AuthorizationScope scope=new AuthorizationScope("global", "accessEverything");
		return Arrays.asList(new SecurityReference("JWT", new AuthorizationScope[] {scope}));
	}
	
	@Bean
	public Docket api()
	{
		
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getInfo())
				.securityContexts(securitycontexts())
				.securitySchemes(Arrays.asList(apiKeys()))
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
		
	}

	private ApiInfo getInfo() {
		
		return new ApiInfo("Blogging Application:Backend Course", "This project is developed by soham", "1.0", "Terms of Service", new Contact("Soham", "https://codingBySoham.com","soham231998@gmail.com"), "License of APIs", "API license URL", Collections.emptyList());
	};

}
