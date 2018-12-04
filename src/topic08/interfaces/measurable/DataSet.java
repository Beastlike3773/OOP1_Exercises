package topic08.interfaces.measurable;

public class DataSet {
  private Measurable maximum;
  private int count;

  public DataSet() {
    this.count = 0;
    this.maximum = null;
  }

  /**
   * Add a Measurable object to the data set.
   * @param x the object to be add
   */  
  public void add(Measurable x) {
    if (this.count == 0 || this.maximum.getMeasure() < x.getMeasure()) {
      this.maximum = x;
    }  
    this.count++;
  }

  public Measurable getMaximum() {
    return this.maximum;
  }
}
