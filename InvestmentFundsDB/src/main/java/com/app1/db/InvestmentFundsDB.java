package com.app1.db;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.app1.domain.Fund;

@Repository
public class InvestmentFundsDB {

	public InvestmentFundsDB() {
		super();
	}

	List<Fund> funds = new ArrayList<>();
	
	public void addFunds() {
		funds.add(new Fund("Employee Provident Fund", 10000, 10, "Retirement"));
		funds.add(new Fund("Public Provident Fund", 10000, 10, "Retirement"));
		funds.add(new Fund("Fixed Deposit", 10000, 10, "Retirement"));
		funds.add(new Fund("Mutual Fund", 20000, 10, "Retirement"));
		funds.add(new Fund("TESTING", 50, 10, "Retirement", 4));
	}
	
	public List<Fund> getTotalFunds() {
		return funds;
	}
}
