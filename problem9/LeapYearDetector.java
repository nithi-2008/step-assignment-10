package problem9;

import java.util.Scanner;

/**
 * Problem 9: Leap Year Detector
 * Determines whether a given year is a leap year according to the Gregorian calendar:
 * divisible by 4, but not by 100, unless also divisible by 400.
 */
public class LeapYearDetector {

    /**
     * Checks if the given year is a leap year.
     *
     * @param year calendar year
     * @return true if leap year, false otherwise
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * Evaluates and formats result matching example output:
     * "Leap year" or "Not a leap year".
     *
     * @param year calendar year
     * @return result message
     */
    public static String evaluate(int year) {
        return isLeapYear(year) ? "Leap year" : "Not a leap year";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int year = scanner.nextInt();
            System.out.println(evaluate(year));
        }
        scanner.close();
    }
}
