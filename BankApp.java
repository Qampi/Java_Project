import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Superclass for BankAccount
class BankAccount {
    protected String accountNumber;
    protected String accountHolderName;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public void displayBalance() {
        System.out.println("Account Balance: $" + balance);
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        displayBalance();
    }
}

// Subclass for SavingsAccount
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest applied: $" + interest);
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Account Type: Savings");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Subclass for CheckingAccount
class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String accountHolderName, double balance, double overdraftLimit) {
        super(accountNumber, accountHolderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= (balance + overdraftLimit)) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or exceeds overdraft limit.");
        }
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Account Type: Checking");
        System.out.println("Overdraft Limit: $" + overdraftLimit);
    }
}

// Bank class to manage accounts
class Bank {
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.accountNumber.equals(accountNumber)) {
                return account;
            }
        }
        System.out.println("Account not found.");
        return null;
    }

    public void displayAllAccounts() {
        for (BankAccount account : accounts) {
            account.displayAccountDetails();
            System.out.println();
        }
    }
}

// Main class for user interaction
public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        // Adding sample accounts
        bank.addAccount(new SavingsAccount("S001", "Alice", 1000.0, 2.5));
        bank.addAccount(new CheckingAccount("C001", "Bob", 500.0, 200.0));

        while (true) {
            try {
                System.out.println("\nBank Application");
                System.out.println("1. Display All Accounts");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Apply Interest (Savings Accounts Only)");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear newline character

                switch (choice) {
                    case 1:
                        bank.displayAllAccounts();
                        break;
                    case 2:
                        System.out.print("Enter account number: ");
                        String depositAccountNumber = scanner.nextLine();
                        BankAccount depositAccount = bank.findAccount(depositAccountNumber);
                        if (depositAccount != null) {
                            System.out.print("Enter deposit amount: ");
                            double depositAmount = scanner.nextDouble();
                            depositAccount.deposit(depositAmount);
                        }
                        break;
                    case 3:
                        System.out.print("Enter account number: ");
                        String withdrawAccountNumber = scanner.nextLine();
                        BankAccount withdrawAccount = bank.findAccount(withdrawAccountNumber);
                        if (withdrawAccount != null) {
                            System.out.print("Enter withdrawal amount: ");
                            double withdrawAmount = scanner.nextDouble();
                            withdrawAccount.withdraw(withdrawAmount);
                        }
                        break;
                    case 4:
                        System.out.print("Enter savings account number: ");
                        String savingsAccountNumber = scanner.nextLine();
                        BankAccount savingsAccount = bank.findAccount(savingsAccountNumber);
                        if (savingsAccount instanceof SavingsAccount) {
                            ((SavingsAccount) savingsAccount).applyInterest();
                        } else {
                            System.out.println("This is not a savings account.");
                        }
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            } finally {
                System.out.println("Thank you for using the bank application.");
            }
        }
    }
}

