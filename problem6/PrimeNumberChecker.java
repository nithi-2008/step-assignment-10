package problem6;

import java.util.Scanner;

/**
 * Problem 6: Prime Number Checker
 * Determines whether a number greater than 1 is prime by checking divisors
 * up to the square root of the number.
 */
public class PrimeNumberChecker {

    /**
     * Checks if a number greater than 1 is prime.
     *
     * @param n the number to test
     * @return true if prime, false otherwise
     */
    public static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        long limit = (long) Math.sqrt(n);
        for (long i = 5; i <= limit; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Evaluates and formats the result string: "<n> is prime" or "<n> is not prime".
     */
    public static String evaluate(long n) {
        return n + (isPrime(n) ? " is prime" : " is not prime");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLong()) {
            long n = scanner.nextLong();
            System.out.println(evaluate(n));
        }
        scanner.close();
    }
}
