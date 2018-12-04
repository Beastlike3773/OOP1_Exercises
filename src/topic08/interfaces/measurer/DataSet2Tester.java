package topic08.interfaces.measurer;

import java.awt.Rectangle;

public class DataSet2Tester {

  /**
   * Main method.
   * @param args unused
   */
  public static void main(String[] args) {
    Measurer m = new RectangleMeasurer();
    DataSet2 rectangles = new DataSet2(m);
    rectangles.add(new Rectangle(5, 10, 20, 25));
    rectangles.add(new Rectangle(10, 20, 30, 40));
    Rectangle rect = (Rectangle) rectangles.getMaximum();
    System.out.println("The biggest Rectangle: "+rect.getWidth()); // 30.0 expected
  }
}
