package lambdaarraylist;

import java.util.ArrayList;

public class LambdaIntArrayList {

  /**
   * Main method.
   * @param args unused
   */
  public static void main(String[] args) {

    ArrayList<Integer> a1 = new ArrayList<Integer>();
    a1.add(1);
    a1.add(2);
    a1.add(3);
    a1.add(4);
    // Iterate the arraylist
    a1.forEach(a -> System.out.println("Element: " + a));

    // Remove all odd numbers
    a1.removeIf(a -> a % 2 == 1);
    System.out.println(a1);

    // Multiply all elements with 11 
    a1.replaceAll(a -> a = a * 11);
    System.out.println(a1);
    
  }
}
