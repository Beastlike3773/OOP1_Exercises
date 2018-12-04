package topic08.interfaces.measurer;

public class BankAccount {
  private double balance;

  public BankAccount() {
    this.balance = 0;
  }

  public BankAccount(double initialBalance) {
    this.balance = initialBalance;
  }

  public void deposit(double amount) {
    double newBalance = this.balance + amount;
    this.balance = newBalance;
  }

  public void withdraw(double amount) {
    double newBalance = this.balance - amount;
    this.balance = newBalance;
  }

  public double getBalance() {
    return this.balance;
  }

}
