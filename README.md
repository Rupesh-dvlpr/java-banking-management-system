# Banking Management System (Core Java & OOP)

A robust, layered Console Banking Application built using Core Java, demonstrating key Object-Oriented Programming (OOP) principles, clean architecture, and defensive programming.

---

## 🏗️ Architecture & Package Structure

The project follows a decoupled multi-layer architecture:

```text
com.banking
 ├── model/           # Core domain models (Account, SavingsAccount, CurrentAccount, Customer, Transaction)
 ├── service/         # Business logic layer (BankOperations interface & BankService implementation)
 ├── ui/              # User interface layer (BankingMenu console CLI)
 └── main/            # Application entry point (BankingApplication)
 ```
## ✨ Features & Business Rules
Account Creation: Supports opening Savings Accounts (with interest calculation) and Current Accounts (with configurable overdraft limits).

Deposits & Withdrawals: Enforces defensive input validation (positive amounts only) and overdraft checks.

Fund Transfers: Atomic transfer logic between accounts with double-entry transaction record generation.

Audit Trail: Immutable, formatted LocalDateTime timestamped transaction logs for every transaction (DEPOSIT, WITHDRAWAL, TRANSFER_IN, TRANSFER_OUT).

Resilient CLI Menu: Buffer-safe String reading and global exception handling to prevent runtime menu crashes.

##🛠️ Tech Stack & Key Concepts Demonstrated
Language: Java 8+

IDE: Eclipse

Version Control: Git & GitHub

OOP Concepts: Encapsulation, Inheritance, Polymorphism, Abstraction, Aggregation/Composition

Design Patterns: Interface-based programming, Layered Architecture, Defensive Programming

##🚀 How to Run
Clone the Repository:

```Bash
git clone https://github me/<your-username>/java-banking-management-system.git
cd java-banking-management-system
Import into Eclipse IDE:

File -> Import -> Existing Projects into Workspace -> Select project directory.

Run Application:

Navigate to com.banking.main.BankingApplication.java

Right-click -> Run As -> Java Application
```
##📈 Next Up (Phase 2 Roadmap)
[ ] Refactor array storage (Customer[], Transaction[]) to Java Collections Framework (ArrayList, HashMap).

[ ] Implement Custom User-Defined Exceptions (InsufficientFundsException, AccountNotFoundException).

[ ] Persistent Storage via File I/O & JDBC / MySQL integration.

[ ] Transition to Spring Boot REST API & Spring Security.