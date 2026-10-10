package problem5;

import java.util.Scanner;

/**
 * Problem 5: Digit Sum and Number Reversal
 * Reads a positive integer, calculates the sum of its digits,
 * and prints the number with its digits reversed.
 */
public class DigitSumAndReversal {

    public static class Result {
        private final int sumOfDigits;
        private final long reversedNumber;

        public Result(int sumOfDigits, long reversedNumber) {
            this.sumOfDigits = sumOfDigits;
            this.reversedNumber = reversedNumber;
        }

        public int getSumOfDigits() {
            return sumOfDigits;
        }

        public long getReversedNumber() {
            return reversedNumber;
        }

        @Override
        public String toString() {
            return "Sum of digits: " + sumOfDigits + "\nReverse: " + reversedNumber;
        }
    }

    /**
     * Calculates the sum of digits and reversed value of a number using modulo and division.
     *
     * @param number positive integer
     * @return Result containing sum of digits and reversed number
     */
    public static Result process(long number) {
        if (number == 0) {
            return new Result(0, 0);
        }

        long temp = Math.abs(number);
        int sum = 0;
        long reversed = 0;

        while (temp > 0) {
            int digit = (int) (temp % 10);
            sum += digit;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }

        return new Result(sum, reversed);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            Result result = process(number);
            System.out.println(result);
        }
        scanner.close();
    }
}
