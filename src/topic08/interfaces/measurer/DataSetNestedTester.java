package topic08.interfaces.measurer;

import java.awt.Rectangle;

public class DataSetNestedTester {
  private static class RectangleMeasurer implements Measurer {
    @Override
    public double measure(Object obj) {
      Rectangle rect = (Rectangle) obj;
      return rect.getWidth() * rect.getHeight(); 
    }
  }

  /**
   * Main method.
   * @param args unused
   */
  public static void main(String[] args) {
    DataSet2 rectangles = new DataSet2(new RectangleMeasurer());
    rectangles.add(new Rectangle(5, 10, 20, 25));
    rectangles.add(new Rectangle(10, 20, 30, 40));
    Rectangle rect = (Rectangle) rectangles.getMaximum();
    System.out.println("The biggest Rectangle: "+rect.getWidth()); // 30.0 expected
  }
}
