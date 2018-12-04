package topic08.interfaces.customcalc;

public class CustomCalcTester implements CustomCalculator {
  public static void main(String[] args) {
    CustomCalculator demo = new CustomCalcTester();
    int sumOfEvens = demo.addEvenNumbers(1, 2, 3, 4, 5, 6, 7, 8, 9);
    System.out.println(sumOfEvens);
    int sumOfOdds = demo.addOddNumbers(1, 2, 3, 4, 5, 6, 7, 8, 9);
    System.out.println(sumOfOdds);
  }
}
