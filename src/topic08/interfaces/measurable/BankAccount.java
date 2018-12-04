package topic08.interfaces.measurable;

public class BankAccount implements Measurable {
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

  @Override
  public double getMeasure() {
    return this.balance;
  }


}
