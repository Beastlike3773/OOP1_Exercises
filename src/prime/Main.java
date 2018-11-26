package prime;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        while (true) {
            Scanner s = new Scanner(System.in);
            long n = s.nextLong();
            PrimeNumbers.getCertainPrime(n);
        }
    }
}
