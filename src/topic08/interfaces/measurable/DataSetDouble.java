package topic08.interfaces.measurable;

public class DataSetDouble {
  private double sum = 0;
  private double maximum = 0;
  private int count = 0;

  /**
   * Add a double value to the data set.
   * @param x the double value to be add
   */  
  public void add(double x) {
    this.sum = this.sum + x;
    if (this.count == 0 || this.maximum < x) {
      this.maximum = x;
    }
    this.count++;
  }

  /**
   * Computes the average of the data set.
   */  
  public double getAverage() {
    if (this.count == 0) {
      return 0;
    } else {
      return this.sum / this.count;
    }
  }

  public double getMaximum() {
    return this.maximum;
  }
}
