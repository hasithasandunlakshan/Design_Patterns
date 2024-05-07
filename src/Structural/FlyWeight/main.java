package Structural.FlyWeight;

// BankAccount interface representing bank account operations
interface BankAccount {
    void deposit(double amount);

    void withdraw(double amount);

    double getBalance();
}

// RealBankAccount representing the actual bank account on the remote server
class RealBankAccount implements BankAccount {
    private double balance;

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

// BankAccountProxy representing the proxy for accessing the remote bank account
class BankAccountProxy implements BankAccount {
    private RealBankAccount realAccount;

    @Override
    public void deposit(double amount) {
        initializeRealAccount();
        realAccount.deposit(amount);
    }

    @Override
    public void withdraw(double amount) {
        initializeRealAccount();
        realAccount.withdraw(amount);
    }

    @Override
    public double getBalance() {
        initializeRealAccount();
        return realAccount.getBalance();
    }

    private void initializeRealAccount() {
        if (realAccount == null) {
            // Simulate establishing a connection with the remote server
            System.out.println("Connecting to remote server...");
            realAccount = new RealBankAccount();
            System.out.println("Connection established.");
        }
    }
}

// Client code
public class main {
    public static void main(String[] args) {
        // Create a proxy for accessing the remote bank account
        BankAccount account = new BankAccountProxy();

        // Perform operations on the bank account
        account.deposit(1000);
        account.withdraw(500);
        double balance = account.getBalance();
        System.out.println("Current balance: " + balance);
        BankAccount account1 = new BankAccountProxy();
        account1.deposit(1000);
    }
}
