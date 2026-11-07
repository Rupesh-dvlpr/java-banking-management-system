package com.banking.model;

public abstract class Account {
	private String accountNumber;
	private String accountHolderName;
	private double balance;
	public Account(String accountNumber, String accountHolderName, double balance) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		if(balance>=0) {
		this.balance = balance;
		}
		else {
			throw new IllegalArgumentException("Invalid opening balance");
		}
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String getAccountHolderName() {
		return accountHolderName;
	}
	
	public double getBalance() {
		return balance;
	}
	
	
	
	public void deposit(double amount) {
		if(amount>0) {
		this.balance = balance + amount;
		}
		else {
			throw new IllegalArgumentException("Invalid deposit amount");
		}
	}
	
	public void withdraw(double amount) {
		if(amount>0 && amount<=balance) {
		this.balance = balance - amount;
		}
		else {
			throw new IllegalArgumentException("Invalid withdraw amount");
		}
	}
	
	public abstract String getAccountType();
}
