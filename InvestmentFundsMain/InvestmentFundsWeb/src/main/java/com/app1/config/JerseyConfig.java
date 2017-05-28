package com.app1.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

//http://shengwangi.blogspot.in/2016/08/jersey-in-spring-boothello-world-example.html
@Component
@ApplicationPath("/v1")
public class JerseyConfig extends ResourceConfig {
	@Autowired
	  public JerseyConfig() {
	    // register endpoints
	    packages("com.app1.web");
	    
	    // register jackson for json 
	   // register(new ObjectMapperContextResolver(objectMapper));
	  }
	
	/*@Provider
	  public static class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {
	 
	    private final ObjectMapper mapper;
	 
	    public ObjectMapperContextResolver(ObjectMapper mapper) {
	      this.mapper = mapper;
	    }
	 
	    @Override
	    public ObjectMapper getContext(Class<?> type) {
	      return mapper;
	    }
	  }*/
}
