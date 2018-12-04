package topic08.interfaces.measurable;

public class Coin implements Measurable {
  private double value;
  private String name;

  /*
   * Creates a coin with value and name.
   * @param value value of the coin in cents
   * @param name name of the coin
   */
  public Coin(double value, String name) {
    this.value = value;
    this.name = name;
  }

  public double getValue() {
    return this.value;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public double getMeasure() {
    return this.value;
  }


}
