package com.banking.service;

import com.banking.model.Account;
import com.banking.model.Customer;
import com.banking.model.Transaction;

public class BankService implements BankOperations {
	private Customer[] customers = new Customer[100];
	private int customerCount = 0;
	private int transactionSequence = 1000;

	private Customer findCustomer(String accountNumber) {
		if (accountNumber == null || accountNumber.trim().isEmpty()) {
			return null;
		}

		for (int i = 0; i < customerCount; i++) {
			Customer customer = customers[i];
			if (customer != null && customer.getAccount() != null) {
				if (customer.getAccount().getAccountNumber().equals(accountNumber)) {
					return customer;
				}
			}
		}
		return null;
	}

	public void createCustomer(Customer customer) {
		if (customerCount < customers.length) {
			customers[customerCount++] = customer;
		}
	}

	public Customer getCustomer(String accountNumber) {
		return findCustomer(accountNumber);
	}

	@Override
	public void deposit(String accountNumber, double amount) {
		Customer account = findCustomer(accountNumber);
		if (account != null) {
			account.getAccount().deposit(amount);
		} else {
			throw new IllegalArgumentException("Customer not found");
		}
		Transaction transaction = new Transaction(("TXN" + (++transactionSequence)), "DEPOSIT", amount,
				account.getAccount().getBalance());
		account.getAccount().addTransaction(transaction);
	}

	@Override
	public void withdraw(String accountNumber, double amount) {
		Customer account = findCustomer(accountNumber);
		if (account != null) {
			account.getAccount().withdraw(amount);
		} else {
			throw new IllegalArgumentException("Customer not found");
		}
		Transaction transaction = new Transaction(("TXN" + (++transactionSequence)), "WITHDRAWAL", amount,
				account.getAccount().getBalance());
		account.getAccount().addTransaction(transaction);

	}

	@Override
	public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
		Customer sender = findCustomer(fromAccountNumber);
		Customer receiver = findCustomer(toAccountNumber);
		if (sender == null)
			throw new IllegalArgumentException("Sender account not found.");
		if (receiver == null)
			throw new IllegalArgumentException("Receiver account not found.");

		sender.getAccount().withdraw(amount);
		receiver.getAccount().deposit(amount);
		Transaction transaction = new Transaction(("TXN" + (++transactionSequence)), "TRANSFER_OUT", amount,
				sender.getAccount().getBalance());
		sender.getAccount().addTransaction(transaction);
		Transaction transaction2 = new Transaction(("TXN" + (++transactionSequence)), "TRANSFER_IN", amount,
				receiver.getAccount().getBalance());
		receiver.getAccount().addTransaction(transaction2);

	}

	@Override
	public void displayAccountDetails(String accountNumber) {
		Customer customer = findCustomer(accountNumber);
		if (customer == null) {
			throw new IllegalArgumentException("Account " + accountNumber + " not found.");
		}
		customer.displayCustomerDetails();

	}

	@Override
	public void displayTransactionHistory(String accountNumber) {
		Customer customer = findCustomer(accountNumber);
		if (customer == null) {
			throw new IllegalArgumentException("Error: Account " + accountNumber + " not found. ");
		}

		Account account = customer.getAccount();
		Transaction[] transactions = account.getTransactions();

		System.out.println(
				"====================Transaction History (" + accountNumber + ") ============================");
		for (int i = 0; i < customer.getAccount().getTransactionCount(); i++) {
			transactions[i].displayTransaction();
		}
		System.out
				.println("===========================================================================================");
	}

}
