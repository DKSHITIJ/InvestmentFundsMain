package com.app1.web;

//https://github.com/dangeabunea/RomanianCoderExamples/blob/master/SpringBootMultipleMavenModules/web/src/main/java/rc/web/HotelController.java
//http://cxf.apache.org/docs/springboot.html#SpringBoot-AutoConfiguration
//https://dzone.com/articles/using-jax-rs-with-spring-boot-instead-of-mvc

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = { "com.app1" })
@EnableDiscoveryClient
public class InvestmentFundsMainApplication {
	
	//http://localhost:8080/services/fundsservice/totalfunds
	//http://localhost:8080/v1/fundsservice/totalfunds
	public static void main(String[] args) {
		SpringApplication.run(InvestmentFundsMainApplication.class, args);
	}
	
	/*@Autowired
    private Bus bus;
	
	*//**
	 * If this method is commented out then make sure in application.properties component scan for cxf is set to true
	 *//*
	 @Bean
	    public Server rsServer() {
	        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
	        endpoint.setBus(bus);
	        endpoint.setAddress("/");
	        endpoint.setProvider(new JacksonJsonProvider());
	        endpoint.setServiceBean(new InvestmentFundsServiceImpl());
	        //endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
	        return endpoint.create();
	    }*/
	 

		
}
