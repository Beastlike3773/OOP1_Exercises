package topic08.interfaces.measurer;

import java.awt.Rectangle;

public class DataSetAnonymousTester {
  /**
   * Main method.
   * @param args unused
   */
  public static void main(String[] args) {
    Measurer m = new Measurer() {
      @Override
      public double measure(Object obj) {
        Rectangle rect = (Rectangle) obj;
        return rect.getWidth() * rect.getHeight();
      }
    };
    DataSet2 data = new DataSet2(m);
    data.add(new Rectangle(5, 10, 20, 25));
    data.add(new Rectangle(10, 20, 30, 40));
    Rectangle rect = (Rectangle) data.getMaximum();

    System.out.println(rect.getWidth()); // 30.0 expected
  }
}
