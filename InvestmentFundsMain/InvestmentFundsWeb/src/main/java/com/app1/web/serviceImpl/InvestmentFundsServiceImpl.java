package com.app1.web.serviceImpl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.app1.db.InvestmentFundsDB;
import com.app1.domain.Fund;
import com.app1.web.service.InvestmentFundsService;

//http://www.mkyong.com/webservices/jax-rs/jax-rs-path-uri-matching-example/

//@CrossOrigin
@Component
public class InvestmentFundsServiceImpl implements InvestmentFundsService {
	public static final double NO_OF_YEARS = 20;
	public static final DecimalFormat NUMBER_FORMAT = new DecimalFormat("#.###");

	@Autowired
	InvestmentFundsDB investmentFundsDB;

	//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public List<Fund> getTotalFunds() {
		addFunds();
		List<Fund> funds = investmentFundsDB.getTotalFunds();
		return calculateFunds(funds);
	}

	public void addFunds() {
		investmentFundsDB.addFunds();
	}

	private List<Fund> calculateFunds(List<Fund> funds) {
		double finalAmount = 0;
		double totalAmountInvestedPerMonth = 0;
		double finalAmountWithEPF = 0;
		double totalAmountInvestedPerMonthWithEPF = 0;
		List<Fund> totalFunds = new ArrayList<Fund>();

		for (Fund f : funds) {
			updateTotalFundDetails(f);

			totalAmountInvestedPerMonthWithEPF = totalAmountInvestedPerMonthWithEPF
					+ f.getMonthlyFundAmount();
			finalAmountWithEPF = finalAmountWithEPF + f.getFundAmount();

			if (!f.getFundName().equals("Employee Provident Fund")) {
				totalAmountInvestedPerMonth = totalAmountInvestedPerMonth
						+ f.getMonthlyFundAmount();
				finalAmount = finalAmount + f.getFundAmount();
			}
		}

		Fund f1 = new Fund("Total without Employee Provident Fund",
				totalAmountInvestedPerMonth, finalAmount, NO_OF_YEARS);
		Fund f2 = new Fund("Total with Employee Provident Fund",
				totalAmountInvestedPerMonthWithEPF, finalAmountWithEPF,
				NO_OF_YEARS);
		updateTotalFundDetails(f1);
		updateTotalFundDetails(f2);
		totalFunds.add(f1);
		totalFunds.add(f2);

		return totalFunds;
	}

	private void updateTotalFundDetails(Fund f) {
		StringBuilder fundString = new StringBuilder();
		fundString.append(f.getFundName() + "........\n");
		fundString.append("Amount invested every month : "
				+ NUMBER_FORMAT.format(f.getMonthlyFundAmount()) + "\n");
		fundString.append("Amount invested every year  : "
				+ NUMBER_FORMAT.format(f.getMonthlyFundAmount() * 12) + "\n");
		fundString.append("Total amount invested       : "
				+ NUMBER_FORMAT.format(f.getMonthlyFundAmount() * 12
						* f.getNoOfYears()) + "\n");
		fundString.append("Absolute Returns            : "
				+ NUMBER_FORMAT.format(f.getAbsoluteReturns()) + "\n");
		fundString.append("Final Amount                : "
				+ NUMBER_FORMAT.format(f.getFundAmount()) + "\n");
		fundString.append("Annualised Returns          : "
				+ NUMBER_FORMAT.format(f.getInterestRate()) + "\n");
		fundString
				.append("------------------------------------------------------");

		f.setTotalFundDetails(fundString.toString());
	}
}
