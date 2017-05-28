package com.app1.web.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.app1.domain.Fund;

//http://www.mkyong.com/webservices/jax-rs/jax-rs-path-uri-matching-example/

//@Service
@Path("/fundsservice")
@Produces(MediaType.APPLICATION_JSON)
public interface InvestmentFundsService {
	
	@GET
	@Path("/totalfunds")
	public List<Fund> getTotalFunds() ;

}
