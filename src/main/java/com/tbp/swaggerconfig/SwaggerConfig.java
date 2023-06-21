package com.tbp.swaggerconfig;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2
//@EnableSwagger2WebMvc
public class SwaggerConfig {

 @Bean
 public Docket api() {
  
  return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
            .paths(PathSelectors.any())
            .build();
  
  /*
  return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tbp.crud.controller"))
                .paths(PathSelectors.any())
                .build();
  */
  /*
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
      .select()
      .apis(RequestHandlerSelectors.basePackage("com.tbp.crud.controller"))
      .build();
    
  */
  
  
 }

 /*
     private ApiInfo apiInfo() {
        return new ApiInfo(
                "My API",
                "Descripción de mi API",
                "API v1",
                "Términos de servicio",
                new Contact("Nombre del contacto", "URL del contacto", "email@contacto.com"),
                "Licencia de API",
                "URL de licencia",
                Collections.emptyList());
    }
     */
}