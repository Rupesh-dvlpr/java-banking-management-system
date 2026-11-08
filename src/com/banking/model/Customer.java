package com.banking.model;

public class Customer {
	private String customerId;
	private String name;
	private String email;
	private String phone;
	private Account account;

	public Customer(String customerId, String name, String email, String phone, Account account) {
		if (customerId == null || customerId.trim().isEmpty()) {
			throw new IllegalArgumentException("CustomerId cannot be null or Empty");
		}
		this.customerId = customerId;

		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Name cannot be null or Empty");
		}
		this.name = name;

		this.email = email;
		this.phone = phone;
		if (account == null) {
			throw new IllegalArgumentException("Account cannot be null or Empty");
		}
		this.account = account;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		if (account == null) {
			throw new IllegalArgumentException("Account cannot be null or Empty");
		}
		this.account = account;

	}

	public String getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public void displayCustomerDetails() {
		System.out.println("================Customer Details======================");
		System.out.println("Customer ID: " + customerId);
		System.out.println("Customer Name: " + name);
		System.out.println("Customer Email: " + email);
		System.out.println("Customer Phone: " + phone);
		System.out.println("Customer Account Number: " + account.getAccountNumber());
		System.out.println("Customer Account Type: " + account.getAccountType());
		System.out.println("Customer Account Balance: " + account.getBalance());
	}

}
