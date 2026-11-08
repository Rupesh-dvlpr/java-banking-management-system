package com.banking.model;

public class CurrentAccount extends Account {
	private double overdraftLimit;

	public CurrentAccount(String accountNumber, String accountHolderName, double balance, double overdraftLimit) {
		super(accountNumber, accountHolderName, balance);
		this.overdraftLimit = overdraftLimit;
	}
	
	@Override
	public void withdraw(double amount) {
		    if (amount <= 0) {
		        throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
		    }
		    if (amount > (getBalance() + overdraftLimit)) {
		        throw new IllegalArgumentException("Transaciton failed: Exceeds overdraft limit.");
		    }
		   setBalance(getBalance() - amount);
		}
	
	@Override
	public String getAccountType() {
		return "Current Account";
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	}

