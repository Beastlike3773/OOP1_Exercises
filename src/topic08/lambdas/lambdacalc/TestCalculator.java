package topic08.lambdas.lambdacalc;

/**
 * Class testing the LambdaCalculator with different lambdas.
 * 
 * @author lua
 */
public class TestCalculator {

  /**
   * Main method.
   * @param args unused
   */
  public static void main(String[] args) {
    // Add
    System.out.println(LambdaCalculator.useLambda(5, 2, (i1, i2) -> i1 + i2));
    // Subtract
    System.out.println(LambdaCalculator.useLambda(5, 2, (i1, i2) -> i1 - i2));
    // Multiply
    System.out.println(LambdaCalculator.useLambda(5, 2, (i1, i2) -> i1 * i2));
  }
}
