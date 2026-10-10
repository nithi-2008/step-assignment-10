package problem7;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Problem 7: Factorial Calculation
 * Calculates the factorial of a non-negative integer 'n' (n!),
 * handling n = 0 as 1 and arbitrary large numbers using BigInteger.
 */
public class FactorialCalculation {

    /**
     * Calculates the factorial of non-negative integer n.
     *
     * @param n non-negative integer
     * @return factorial as BigInteger
     */
    public static BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative integers: " + n);
        }
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }

        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            System.out.println(factorial(n));
        }
        scanner.close();
    }
}
