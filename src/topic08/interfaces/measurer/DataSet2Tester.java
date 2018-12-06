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

    m = new BankAccountMeasurer2();
    DataSet2 bas = new DataSet2(m);
    bas.add(new BankAccount(12810));
    bas.add(new BankAccount(234110));
    bas.add(new BankAccount(24510));
    bas.add(new BankAccount(2345345));
    BankAccount ba = (BankAccount) bas.getMaximum();
    System.out.println("The highest balance: " + ba.getBalance());
  }
}
