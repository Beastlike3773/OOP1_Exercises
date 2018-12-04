package topic08.interfaces.measurer;

public class DataSet2 {
  private int count;
  private Object maximum;
  private Measurer measurer;

  /**
   * Construct a DataSet2 from a given Measurer object.
   * 
   * @param m the given object
   */
  public DataSet2(Measurer m) {
    this.count = 0;
    this.maximum = null;
    this.measurer = m;
  }

  /**
   * Adds an object to the DataSetMeasurer.
   * 
   * @param x the new object
   */
  public void add(Object x) {
    if (this.count == 0 || this.measurer.measure(this.maximum) < this.measurer.measure(x)) {
      this.maximum = x;
    }
    this.count++;
  }

  public Object getMaximum() {
    return this.maximum;
  }
}
