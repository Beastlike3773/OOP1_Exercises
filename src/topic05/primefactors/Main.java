package topic05.primefactors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true) {
            // Get the input number from the User
            System.out.println("Enter your number:");
            Scanner sc = new Scanner(System.in);
            long number = sc.nextInt();

            try{

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
            }catch(Exception e){

                // Print exception message
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> getPrimeFactors(long number) throws Exception{

        // Throw exception when number smaller than 2 because it has no prime factors
        if(number < 2){
            throw new Exception("The number: " + number + " has no prime factors.");
        }
        // Create a boolean to be able to check if a number is a prime number
        // or not
        boolean prime = true;

        // Create a local list for all prime factors
        List<Integer> primeFactors = new ArrayList<Integer>();

        // Copy the original number to be able to manipulate it and still have a reference
        long refNumber = number;

        // Check if the given number is a prime number and return itself as the only prim factor
        if(number % 2 != 0){
            for(int i = 3; i <= refNumber/2 + 1; i += 2){
                if(refNumber % i == 0){
                    prime = false;
                    break;
                }
            }
            if(prime) {
                primeFactors.add((int) refNumber);
                return primeFactors;
            }
        }

        // Loop through all the numbers smaller than our number
        // to find all prime factors
        for(int i = 2; i <=  refNumber/2 + 1; i++){
            // Reset prime flag
            prime = true;

            // Ignore all even numbers except 2, because they are not prime numbers
            if(i != 2 && i % 2 == 0){
                continue;
            }

            // Ignore all uneven numbers that are not prime numbers
            for(int c = 3; c <= i/2 + 1; c += 2){
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