package com.AulaCube.Employee_Management.Configuraction;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {

	 @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.basePackage("com.example.controller")) // Replace with your controller package
	            .paths(PathSelectors.any())
	            .build();
	        
	        
/*	        Access Swagger UI:
	        	Once you've configured Swagger, you can access the Swagger UI by navigating to the following URL:
	        	http://localhost:8080/swagger-ui.html
	        	*/

	  /*       Generate API Documentation:
	   * Swagger also provides an API documentation in JSON format. You can access it by navigating to:
	        http://localhost:8080/v2/api-docs
	        */
	    }
}
