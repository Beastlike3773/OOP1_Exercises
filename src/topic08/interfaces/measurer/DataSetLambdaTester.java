package topic08.interfaces.measurer;

import java.awt.Rectangle;

public class DataSetLambdaTester {

  /**
   * Main method.
   * 
   * @param args unused
   */
  public static void main(String[] args) {
    Measurer m1 = (Object obj) -> {
      Rectangle rect = (Rectangle) obj;
      return rect.getWidth() * rect.getHeight();
    };
    
    Measurer m2 = obj -> ((Rectangle) obj).getWidth() * ((Rectangle) obj).getHeight();

    DataSet2 data = new DataSet2(m1);
    data.add(new Rectangle(5, 10, 20, 25));
    data.add(new Rectangle(10, 20, 30, 40));
    Rectangle rect = (Rectangle) data.getMaximum();
    System.out.println(rect.getWidth()); // 30.0 expected
  }
}
