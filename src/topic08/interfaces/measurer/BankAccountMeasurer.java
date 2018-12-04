package topic08.interfaces.measurer;

public class BankAccountMeasurer implements Measurer {
  @Override
  public double measure(Object obj) {
    BankAccount account = (BankAccount) obj; // cast is necessary
    return account.getBalance();
  }
}
