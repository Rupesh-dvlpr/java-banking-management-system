package com.banking.ui;

import java.util.Scanner;

import com.banking.model.Account;
import com.banking.model.CurrentAccount;
import com.banking.model.Customer;
import com.banking.model.SavingsAccount;
import com.banking.service.BankOperations;
import com.banking.service.BankService;

public class BankingMenu {
	private BankOperations bankService = new BankService();
	private Scanner scanner = new Scanner(System.in);

	public void start() {
		boolean run = true;
		while (run) {
			try {
				System.out.println("======================================================");
				System.out.println("		BANKING MANAGEMENT SYSTEM			  ");
				System.out.println("======================================================");
				System.out.println("1. Create Account");
				System.out.println("2. Deposit Funds");
				System.out.println("3. Withdraw Funds");
				System.out.println("4. Transfer Funds");
				System.out.println("5. Display Account Details");
				System.out.println("6. Display transaction History");
				System.out.println("7. Exit");
				System.out.print("Enter your Choice (1-7): ");
				String inputChoice = scanner.nextLine().trim();
		        int choice;

		        try {
		            choice = Integer.parseInt(inputChoice);
		        } catch (NumberFormatException e) {
		            throw new IllegalArgumentException("Invalid input! Please enter a numeric choice between 1 and 7.");
		        }
				switch (choice) {
				case 1: {
					System.out.println("=====================================================");
					System.out.println("		CREATE ACCOUNT					  ");
					System.out.println("======================================================");
					System.out.print("Enter your choice (1/2) => [1. Saving Account] [2. CurrentAccount] : ");
					int accountTypeChoice = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Enter Customer Id: ");
					String customerId = scanner.nextLine();
					System.out.print("Enter Customer Name: ");
					String customerName = scanner.nextLine();
					System.out.print("Enter Customer Email: ");
					String customerEmail = scanner.nextLine();
					System.out.print("Enter Customer Phone: ");
					String customerPhone = scanner.nextLine();
					System.out.print("Enter Customer Account Number: ");
					String customerAccountNumber = scanner.nextLine();
					System.out.print("Enter Initial Balance: ");
					Double customerBalance = scanner.nextDouble();
					scanner.nextLine();

					if (accountTypeChoice == 1) {
						System.out.print("Enter Interest Rate: ");
						double interestRate = scanner.nextDouble();
						Account account = new SavingsAccount(customerAccountNumber, customerName, customerBalance,
								interestRate);
						Customer customer = new Customer(customerId, customerName, customerEmail, customerPhone,
								account);
						bankService.createCustomer(customer);
					} else if (accountTypeChoice == 2) {
						System.out.print("Enter Overdraft Limit: ");
						double overdraftLimit = scanner.nextDouble();
						Account account = new CurrentAccount(customerAccountNumber, customerName, customerBalance,
								overdraftLimit);
						Customer customer = new Customer(customerId, customerName, customerPhone, customerEmail,
								account);
						bankService.createCustomer(customer);
					} else {
						throw new IllegalArgumentException(
								"Invalid Account Type choice!!! Enter 1 => [1. Saving Account], 2=> [2. CurrentAccount] :");
					}

					System.out.println("Account created Successfully!!!");
					break;
				}

				case 2: {
					System.out.println("=====================================================");
					System.out.println("		DEPOSIT MONEY			  		");
					System.out.println("======================================================");

					System.out.print("Enter your account number: ");
					String accountNumber = scanner.nextLine();
					System.out.print("Enter amount to deposit: ");
					double amount = scanner.nextDouble();
					bankService.deposit(accountNumber, amount);
					System.out.println("Deposit Successfully!!!");

					break;
				}

				case 3: {
					System.out.println("=====================================================");
					System.out.println("		WITHDRAW MONEY					  ");
					System.out.println("======================================================");

					System.out.print("Enter your account number: ");
					String accountNumber = scanner.nextLine();
					System.out.print("Enter amount to withdraw: ");
					double amount = scanner.nextDouble();
					bankService.withdraw(accountNumber, amount);
					System.out.println("Withdraw Successfull!!!");

					break;
				}

				case 4: {
					System.out.println("=====================================================");
					System.out.println("		TRANSFER MONEY					  ");
					System.out.println("======================================================");

					System.out.print("Enter sender account number: ");
					String SenderAccountNumber = scanner.nextLine();
					System.out.print("Enter receiver account number: ");
					String receiverAccountNumber = scanner.nextLine();
					System.out.print("Enter amount to transfer: ");
					double amount = scanner.nextDouble();
					bankService.transfer(SenderAccountNumber, receiverAccountNumber, amount);
					System.out.println("Transfer Successfully!!!");
					System.out.println("Customer not found!!!");

					break;
				}

				case 5: {
					System.out.println("=====================================================");
					System.out.println("		ACCOUNT DETAILS				  ");
					System.out.println("======================================================");
					System.out.print("Enter your account number: ");
					String accountNumber = scanner.nextLine();
					bankService.displayAccountDetails(accountNumber);
					break;
				}

				case 6: {
					System.out.println("=====================================================");
					System.out.println("		TRANSACTION HISTORY				  ");
					System.out.println("======================================================");
					System.out.print("Enter your account number: ");
					String accountNumber = scanner.nextLine();
					bankService.displayTransactionHistory(accountNumber);
					break;
				}

				case 7: {
					run = false;
					System.out.println(
							"================== Thankyou for Banking with us Please visit again ======================");
					break;
				}

				default: {
					throw new IllegalArgumentException("Invalid choice!!! please try again Enter valild choice...");
				}
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}
