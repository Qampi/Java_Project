This Java code implements a basic banking system with the following features: 
Classes: 
1.⁠ ⁠BankAccount (Superclass): 
Represents a generic bank account with attributes: account number, account holder name, and balance. 
Methods: deposit, withdraw, display balance, and display account details. 
2.⁠ ⁠SavingsAccount (Subclass): 
Extends BankAccount, adds interest rate attribute, and applies interest method. 
3.⁠ ⁠CheckingAccount (Subclass): 
Extends BankAccount, adds overdraft limit attribute, and overrides withdraw method. 
4.⁠ ⁠Bank: 
Manages a list of bank accounts. 
Methods: add account, find account by number, and display all accounts. 
5.⁠ ⁠BankApp (Main class): 
Provides user interaction through a menu-driven interface.

Functionality: 
1.⁠ ⁠Account Management: Create savings and checking accounts, deposit, withdraw, and apply interest. 
2.⁠ ⁠Account Information: Display account details, balance, and type. 
3.⁠ ⁠Error Handling: Input validation for invalid inputs and account not found. 
Key Concepts: 1.⁠ ⁠Inheritance: SavingsAccount and CheckingAccount inherit from BankAccount. 
2.⁠ ⁠Polymorphism: Method overriding (withdraw) and method overloading (displayAccountDetails). 
3.⁠ ⁠Encapsulation: Data hiding through private attributes and public methods. 
4.⁠ ⁠Exception Handling: InputMismatchException for invalid inputs.

Running the Code: Prerequisites: 
•⁠ ⁠Java Development Kit (JDK) installed on your system. 
•⁠ ⁠Java IDE (e.g., Eclipse, IntelliJ IDEA, NetBeans) or a text editor. 
Steps: 
1.⁠ ⁠Save the code in a file named ⁠ BankApp.java ⁠. 
2.⁠ ⁠Compile the code using the command: ⁠ javac BankApp.java ⁠ (in the terminal/command prompt). 
3.⁠ ⁠Run the code using the command: ⁠ java BankApp ⁠ (in the terminal/command prompt). 
4.⁠ ⁠Interact with the banking system through the menu-driven interface.

Example Usage: 
1.⁠ ⁠Run the BankApp class. 
2.⁠ ⁠Choose options from the menu: 
- Display all accounts
- Deposit into an account 
- Withdraw from an account 
- Apply interest to a savings account 
- Exit the application This code demonstrates object-oriented programming principles, exception handling, and basic banking operations.

Made use of if else statement:
If the if condition is false, the block of code inside the else statement will execute.

class: A class in Java is a blueprint for creating objects.
Superclass (Parent Class): The class whose properties and methods are inherited by another class.
Subclass (Child Class): The class that inherits properties and methods from the superclass.
extends Keyword: Used to define a subclass that inherits from a superclass.
