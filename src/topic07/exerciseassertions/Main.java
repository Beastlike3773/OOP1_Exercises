package topic07.exerciseassertions;

public class Main {
    public static void main(String[] args){
        sqrt(-1);
    }

    /**
     *
     * @param x number to take the square root of
     * @return the square root of x
     * (Precondition: x >= 0)
     */
    public static double sqrt(double x){
        assert x >= 0;  // Precondition

        return Math.sqrt(x);
    }

    /**
     *
     * @param n number to change to a roman numeral
     * @return
     * (Precondition: n > 0)
     */
    public static String romanNumeral(int n){
       assert n > 0;    // Precondition

       return "";
    }

    /**
     *
     * @param day day to be converted in a week day
     * @return the weekday name
     * (Precondition: day >= 1 && day <= 7)
     */
    public static String weekday(int day){
        assert day >= 1 && day <= 7;    // Precondition
        return "";
    }
}
