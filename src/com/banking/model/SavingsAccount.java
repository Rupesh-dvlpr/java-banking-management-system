package com.banking.model;

public class SavingsAccount extends Account {
	private double interestRate;

	public SavingsAccount(String accountNumber, String accountHolderName, double balance, double interestRate) {
		super(accountNumber, accountHolderName, balance);
		if (interestRate > 0) {
			this.interestRate = interestRate;
		} else {
			throw new IllegalArgumentException("InterestRate must be greater than zero");
		}
	}

	public void applyInterest() {
		double amount = getBalance() * interestRate / 100;
		deposit(amount);
	}
	
	@Override
	public String getAccountType() {
		return "Savings Account";
	}
}
