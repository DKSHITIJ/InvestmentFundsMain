package com.app1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//This will work only if we have spring-boot-starter-web in maven pom.xml
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
/*@Override
public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping("/**");
.allowedOrigins("*")
.allowedMethods("GET", "POST", "PUT", "DELETE")
.allowedHeaders("header1", "header2", "header3")
.exposedHeaders("header1", "header2")
.allowCredentials(false).maxAge(3600);
}*/
}
