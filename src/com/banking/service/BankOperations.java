package com.banking.service;

import com.banking.model.Customer;

public interface BankOperations {
	void createCustomer(Customer customer);

	Customer getCustomer(String accountNumber);

	void deposit(String accountNumber, double amount);

	void withdraw(String accountNumber, double amount);

	void transfer(String fromAccountNumber, String toAccountNumber, double amount);

	void displayAccountDetails(String accountNumber);

	void displayTransactionHistory(String accountNumber);
}
