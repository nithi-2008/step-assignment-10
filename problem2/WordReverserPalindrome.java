package problem2;

import java.util.Scanner;

/**
 * Problem 2: Word Reverser and Palindrome Checker
 * Reverses an input word using a mutable StringBuilder and determines
 * whether the original word is a palindrome.
 */
public class WordReverserPalindrome {

    /**
     * Reverses the given word using StringBuilder.
     *
     * @param word input string
     * @return reversed string
     */
    public static String reverseWord(String word) {
        if (word == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }

    /**
     * Checks if a word is a palindrome by comparing original and reversed.
     *
     * @param word original word
     * @return true if palindrome (case-insensitive), false otherwise
     */
    public static boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }
        String reversed = reverseWord(word);
        return word.equalsIgnoreCase(reversed);
    }

    /**
     * Formats the result string matching problem specification:
     * e.g., "level - palindrome" or "avaj - not a palindrome".
     *
     * @param word input word
     * @return formatted result string
     */
    public static String evaluate(String word) {
        String reversed = reverseWord(word);
        boolean palindrome = isPalindrome(word);
        return reversed + " - " + (palindrome ? "palindrome" : "not a palindrome");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String word = scanner.next();
            System.out.println(evaluate(word));
        }
        scanner.close();
    }
}
