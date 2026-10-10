package tests;

import problem1.VowelConsonantCounter;
import problem2.WordReverserPalindrome;
import problem3.EvenOddCounter;
import problem4.InPlaceArrayReversal;
import problem5.DigitSumAndReversal;
import problem6.PrimeNumberChecker;
import problem7.FactorialCalculation;
import problem8.StudentGradeAssignment;
import problem9.LeapYearDetector;
import problem10.StudentResultCardGenerator;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Automated Test Suite for STEP Assignment 10
 * Validates all 10 problems against required example inputs and edge cases.
 */
public class AssignmentTestSuite {

    private static int totalPassed = 0;
    private static int totalFailed = 0;

    private static void assertEquals(String testName, Object expected, Object actual) {
        if (expected == null && actual == null) {
            System.out.println("  [PASS] " + testName);
            totalPassed++;
        } else if (expected != null && expected.equals(actual)) {
            System.out.println("  [PASS] " + testName);
            totalPassed++;
        } else {
            System.err.println("  [FAIL] " + testName + " | Expected: " + expected + ", Got: " + actual);
            totalFailed++;
        }
    }

    private static void testProblem1() {
        System.out.println("\n--- Testing Problem 1: Vowel and Consonant Counter ---");
        VowelConsonantCounter.CountResult r1 = VowelConsonantCounter.count("Programming");
        assertEquals("Programming vowels", 3, r1.getVowels());
        assertEquals("Programming consonants", 8, r1.getConsonants());

        VowelConsonantCounter.CountResult r2 = VowelConsonantCounter.count("AEIOU");
        assertEquals("AEIOU vowels", 5, r2.getVowels());
        assertEquals("AEIOU consonants", 0, r2.getConsonants());

        VowelConsonantCounter.CountResult r3 = VowelConsonantCounter.count("rhythm");
        assertEquals("rhythm vowels", 0, r3.getVowels());
        assertEquals("rhythm consonants", 6, r3.getConsonants());
    }

    private static void testProblem2() {
        System.out.println("\n--- Testing Problem 2: Word Reverser and Palindrome Checker ---");
        assertEquals("level", "level - palindrome", WordReverserPalindrome.evaluate("level"));
        assertEquals("java", "avaj - not a palindrome", WordReverserPalindrome.evaluate("java"));
        assertEquals("Radar", "radaR - palindrome", WordReverserPalindrome.evaluate("Radar"));
    }

    private static void testProblem3() {
        System.out.println("\n--- Testing Problem 3: Even and Odd Numbers in a List ---");
        int[] arr1 = EvenOddCounter.parseNumbers("[3, 8, 12, 5, 7, 10]");
        EvenOddCounter.CountResult r1 = EvenOddCounter.count(arr1);
        assertEquals("Sample even count", 3, r1.getEvenCount());
        assertEquals("Sample odd count", 3, r1.getOddCount());

        int[] arr2 = EvenOddCounter.parseNumbers("[2, 4, 6, 8]");
        EvenOddCounter.CountResult r2 = EvenOddCounter.count(arr2);
        assertEquals("All even count", 4, r2.getEvenCount());
        assertEquals("All odd count", 0, r2.getOddCount());
    }

    private static void testProblem4() {
        System.out.println("\n--- Testing Problem 4: In-Place Array Reversal ---");
        int[] arr1 = {11, 22, 33, 44};
        InPlaceArrayReversal.reverseInPlace(arr1);
        assertEquals("Even length reverse", "[44, 33, 22, 11]", Arrays.toString(arr1));

        int[] arr2 = {1, 2, 3, 4, 5};
        InPlaceArrayReversal.reverseInPlace(arr2);
        assertEquals("Odd length reverse", "[5, 4, 3, 2, 1]", Arrays.toString(arr2));

        int[] arr3 = {42};
        InPlaceArrayReversal.reverseInPlace(arr3);
        assertEquals("Single element reverse", "[42]", Arrays.toString(arr3));
    }

    private static void testProblem5() {
        System.out.println("\n--- Testing Problem 5: Digit Sum and Number Reversal ---");
        DigitSumAndReversal.Result r1 = DigitSumAndReversal.process(4721);
        assertEquals("4721 sum of digits", 14, r1.getSumOfDigits());
        assertEquals("4721 reverse", 1274L, r1.getReversedNumber());

        DigitSumAndReversal.Result r2 = DigitSumAndReversal.process(100);
        assertEquals("100 sum of digits", 1, r2.getSumOfDigits());
        assertEquals("100 reverse", 1L, r2.getReversedNumber());
    }

    private static void testProblem6() {
        System.out.println("\n--- Testing Problem 6: Prime Number Checker ---");
        assertEquals("29", "29 is prime", PrimeNumberChecker.evaluate(29));
        assertEquals("21", "21 is not prime", PrimeNumberChecker.evaluate(21));
        assertEquals("2", "2 is prime", PrimeNumberChecker.evaluate(2));
        assertEquals("1", "1 is not prime", PrimeNumberChecker.evaluate(1));
    }

    private static void testProblem7() {
        System.out.println("\n--- Testing Problem 7: Factorial Calculation ---");
        assertEquals("5!", BigInteger.valueOf(120), FactorialCalculation.factorial(5));
        assertEquals("0!", BigInteger.ONE, FactorialCalculation.factorial(0));
        assertEquals("1!", BigInteger.ONE, FactorialCalculation.factorial(1));
        assertEquals("10!", BigInteger.valueOf(3628800), FactorialCalculation.factorial(10));
    }

    private static void testProblem8() {
        System.out.println("\n--- Testing Problem 8: Student Grade Assignment ---");
        assertEquals("72 marks", "Grade C", StudentGradeAssignment.getGrade(72));
        assertEquals("95 marks", "Grade A", StudentGradeAssignment.getGrade(95));
        assertEquals("35 marks", "Grade F", StudentGradeAssignment.getGrade(35));
        assertEquals("80 marks", "Grade B", StudentGradeAssignment.getGrade(80));
        assertEquals("55 marks", "Grade D", StudentGradeAssignment.getGrade(55));
    }

    private static void testProblem9() {
        System.out.println("\n--- Testing Problem 9: Leap Year Detector ---");
        assertEquals("2024", "Leap year", LeapYearDetector.evaluate(2024));
        assertEquals("1900", "Not a leap year", LeapYearDetector.evaluate(1900));
        assertEquals("2000", "Leap year", LeapYearDetector.evaluate(2000));
        assertEquals("2023", "Not a leap year", LeapYearDetector.evaluate(2023));
    }

    private static void testProblem10() {
        System.out.println("\n--- Testing Problem 10: Student Result Card Generator ---");
        StudentResultCardGenerator.Student s1 = StudentResultCardGenerator.parseStudent("Asha [80, 90, 70]");
        assertEquals("Asha result card", "ASHA: Average 80.0, Grade B", s1.getResultCard());

        StudentResultCardGenerator.Student s2 = StudentResultCardGenerator.parseStudent("Ravi [60, 55, 50]");
        assertEquals("Ravi result card", "RAVI: Average 55.0, Grade D", s2.getResultCard());
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   STEP Assignment 10 Automated Test Suite        ");
        System.out.println("==================================================");

        testProblem1();
        testProblem2();
        testProblem3();
        testProblem4();
        testProblem5();
        testProblem6();
        testProblem7();
        testProblem8();
        testProblem9();
        testProblem10();

        System.out.println("\n==================================================");
        System.out.println("TEST SUMMARY: Passed = " + totalPassed + ", Failed = " + totalFailed);
        System.out.println("==================================================");

        if (totalFailed > 0) {
            System.exit(1);
        }
    }
}
