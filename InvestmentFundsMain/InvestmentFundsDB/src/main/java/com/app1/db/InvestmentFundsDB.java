package com.app1.db;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.app1.domain.Fund;

@Repository
public class InvestmentFundsDB {

	private double noOfNumbers = 20;
	public InvestmentFundsDB() {
		super();
	}

	List<Fund> funds = new ArrayList<>();
	
	public void addFunds() {
		funds.add(new Fund("Employee Provident Fund", 10000, 7, "Retirement", noOfNumbers));
		//funds.add(new Fund("Public Provident Fund", 10000, 7, "Retirement", noOfNumbers));
		//funds.add(new Fund("Fixed Deposit", 10000, 6, "Retirement", noOfNumbers));
		funds.add(new Fund("Mutual Fund", 50000, 15, "Retirement", noOfNumbers));
	}
	
	public List<Fund> getTotalFunds() {
		return funds;
	}
	
	public List<Fund> addAndGetTotalFunds() {
		addFunds();
		return getTotalFunds();
	}
}
