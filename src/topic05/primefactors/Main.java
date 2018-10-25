package topic05.primefactors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Get the input number from the User
        System.out.println("Enter your number:");
        Scanner sc = new Scanner(System.in);
        long number = sc.nextInt();

        // Create a list to put all prime factors and get the prime factors
        List<Integer> primeFactors = getPrimeFactors(number);

        // Create the output string
        String factors = number + ": ";

        // Add each prime factor to the string
        for (Integer factor : primeFactors) {
            factors += factor + ", ";
        }

        // Remove the last ", " from the string
        factors = factors.substring(0, factors.length() - 2);

        // Print the output string in the console
        System.out.println(factors);
    }

    public static List<Integer> getPrimeFactors(long number){

        // Create a local list for all prime factors
        List<Integer> primeFactors = new ArrayList<Integer>();

        // Copy the original number to be able to manipulate it and still have a reference
        long refNumber = number;

        // Loop through all the numbers smaller than our number
        // to find all prime factors
        for(int i = 2; i < refNumber; i++){
            // Create a boolean to be able to check if a number is a prime number
            // or not
            boolean prime = true;

            // Ignore all even numbers except 2, because they are not prime numbers
            if(i != 2 && i % 2 == 0){
                continue;
            }

            // Ignore all uneven numbers that are not prime numbers
            for(int c = 3; c < i; c += 2){
                if(i % c == 0){
                    prime = false;
                    break;
                }
            }

            // While the modulo of our number and the current iteration number equals 0 add that number
            // to the prime factor list if it is a prime number
            while(prime && number % i == 0){
                primeFactors.add(i);
                number /= i;
            }
        }

        // Return the resulting prime factors
        return primeFactors;
    }
}