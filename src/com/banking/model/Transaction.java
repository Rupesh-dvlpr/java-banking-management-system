package com.banking.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
	private final String transactionId;
	private final String transactionType;
	private final double amount;
	private final double balanceAfterTransaction;
	private final LocalDateTime timestamp;
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public Transaction(String transactionId, String transactionType, double amount, double balanceAfterTransaction) {
		if (transactionId == null || transactionId.trim().isEmpty()) {
			throw new IllegalArgumentException("Transaction Id cannot be null or Empty");
		}
		this.transactionId = transactionId;

		if (transactionType == null || transactionType.trim().isEmpty()) {
			throw new IllegalArgumentException("Transaction type cannot be null or Empty");
		}
		this.transactionType = transactionType;
		if (amount <= 0) {
			throw new IllegalArgumentException("Transaction amount must be greater than 0");
		}
		this.amount = amount;
		this.balanceAfterTransaction = balanceAfterTransaction;
		this.timestamp = LocalDateTime.now();
	}

	public String getTransactionId() {
		return transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public double getBalanceAfterTransaction() {
		return balanceAfterTransaction;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void displayTransaction() {
		String formattedTime = timestamp.format(formatter);
		System.out.println("[" + formattedTime + "] TXN: " + transactionId + " | Type: " + transactionType
				+ " | Amount: $" + amount + " | Balance: $" + balanceAfterTransaction);
	}

}
