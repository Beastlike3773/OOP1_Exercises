package topic08.interfaces.measurable;

public class DataSetBankAccount { // modified for BankAccount objects
  private BankAccount maximum;
  private int count;

  /**
   * Adds a BankAccount to the data set.
   * @param x the BankAccount to be add
   */  
  public void add(BankAccount x) {
    if (this.count == 0 || maximum.getBalance() < x.getBalance()) {
      this.maximum = x;
    }
    this.count++;
  }

  public BankAccount getMaximum() {
    return this.maximum;
  }
}
