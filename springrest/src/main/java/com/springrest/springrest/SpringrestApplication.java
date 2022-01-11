package com.springrest.springrest;

import java.util.Collection;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@SpringBootApplication
@Configuration
public class SpringrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringrestApplication.class, args);
	}
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select() 
          .paths(PathSelectors.any()) 
          .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))                            
          .build()
          .apiInfo(apiInfo());
          
    }

	private ApiInfo apiInfo() {
		
		return new ApiInfo(
				"Springrest API Service", 
				"API made for practice perpose only.", 
				"API TOS", 
				"Terms of Service", 
				new Contact("Soni Kumari", "www.example.com", "myeaddress@company.com"), 
				"License", 
				"License URL", 
				Collections.emptyList());
		
	}

}
