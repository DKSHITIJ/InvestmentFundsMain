package com.app1.domain;

public class Fund {
	private double monthlyFundAmount;
	private double interestRate;
	private String fundName;
	private String goal;
	//private double noOfYears = FundCalculator.NO_OF_YEARS;
	private double noOfYears = 20;
	private double fundAmount;
	private String totalFundDetails;

	public Fund(String fundName, double monthyFundAmount, double interstRate, String goal) {
		super();
		this.monthlyFundAmount = monthyFundAmount;
		this.interestRate = interstRate;
		this.fundName = fundName;
		this.goal = goal;
	}

	public Fund(String fundName, double monthyFundAmount, double interstRate, String goal, double noOfYears) {
		super();
		this.monthlyFundAmount = monthyFundAmount;
		this.interestRate = interstRate;
		this.fundName = fundName;
		this.goal = goal;
		this.noOfYears = noOfYears;
	}

	public Fund(String fundName, double monthyFundAmount, double fundAmount, double noOfYears) {
		super();
		this.monthlyFundAmount = monthyFundAmount;
		this.fundName = fundName;
		this.noOfYears = noOfYears;
		this.fundAmount = fundAmount;
	}

	public double getMonthlyFundAmount() {
		return monthlyFundAmount;
	}

	public double getInterestRate() {
		if(interestRate <= 0) {
			interestRate = (Math.pow((getFundAmount()/(monthlyFundAmount * 12 * noOfYears)), (1/(noOfYears-1))) - 1) * 100;
		}
		return interestRate;
	}

	public String getFundName() {
		return fundName;
	}

	public String getGoal() {
		return goal;
	}

	public double getNoOfYears() {
		return noOfYears;
	}

	public double getFundAmount() {
		if (fundAmount <= 0) {
			double interstAmount = 0;

			for (int i = 1; i <= noOfYears; i++) {
				fundAmount = fundAmount + (monthlyFundAmount * 12);
				interstAmount = fundAmount * (interestRate / 100);
				fundAmount = Math.round(fundAmount + interstAmount);
			}
		}
		return fundAmount;
	}

	public double getAbsoluteReturns() {
		double finalAmount = 0;
		double interstAmount = 0;

		for (int i = 1; i <= noOfYears; i++) {
			finalAmount = finalAmount + (monthlyFundAmount * 12);
			finalAmount = Math.round(finalAmount + interstAmount);
		}
		double profit = getFundAmount() - finalAmount;
		return (profit / finalAmount) * 100;
	}

	@Override
	public String toString() {
		return getFundName();
	}

	public String getTotalFundDetails() {
		return totalFundDetails;
	}

	public void setTotalFundDetails(String totalFundDetails) {
		this.totalFundDetails = totalFundDetails;
	}

}
