package topic08.interfaces.measurable;

public class DataSetCoin { // modified for Coin objects
  private Coin maximum;
  private int count;

  /**
   * Add a Coin to the data set.
   * @param x the coin to be add
   */  
  public void add(Coin x) {
    if (this.count == 0 || this.maximum.getValue() < x.getValue()) {
      this.maximum = x;
    }  
    this.count++;
  }

  public Coin getMaximum() {
    return this.maximum;
  }
}
