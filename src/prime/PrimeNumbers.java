package prime;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

    public static void getCertainPrime(long prime){
        List<Long> primes = new ArrayList<>();
        long done = 0;
        if(prime != 0){
            //System.out.println(2L);
            primes.add(2L);
            done++;
        }
        for(long i = 3; done < prime; i+=2) {
            boolean is_prime = true;

            for (long k = 3; k * k <= i; k += 2) {
                if(i%k == 0){
                    is_prime = false;
                    break;
                }
            }

            if(is_prime){
                primes.add(i);
                done++;
                //System.out.println(i);
            }
        }

        System.out.println(primes.get(primes.size() - 1));
    }
}
