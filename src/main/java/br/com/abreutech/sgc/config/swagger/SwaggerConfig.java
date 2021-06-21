package br.com.abreutech.sgc.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer
{ 
	public static final String URL_DOCUMENTATION = "/docs";
	
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()
		  .apis(RequestHandlerSelectors.basePackage("br.com.abreutech.gs3.controller"))
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(metaData());                                           
    }

    private ApiInfo metaData() {
		return new ApiInfoBuilder()
				.title("API REST GS3")
				.description("API REST do Projeto GS3")
				.version("1.0.0")
				.license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
				.build();
	}
	
    @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry
	    	.addResourceHandler(URL_DOCUMENTATION + "/**")
	    	.addResourceLocations("classpath:/META-INF/resources/");
	}
}
