package problem1;

import java.util.Scanner;

/**
 * Problem 1: Vowel and Consonant Counter
 * Reads a single word and counts the number of vowels and consonants
 * using case-insensitive character evaluation.
 */
public class VowelConsonantCounter {

    public static class CountResult {
        private final int vowels;
        private final int consonants;

        public CountResult(int vowels, int consonants) {
            this.vowels = vowels;
            this.consonants = consonants;
        }

        public int getVowels() {
            return vowels;
        }

        public int getConsonants() {
            return consonants;
        }

        @Override
        public String toString() {
            return "Vowels: " + vowels + "\nConsonants: " + consonants;
        }
    }

    /**
     * Counts vowels and consonants in the given word.
     * Assumes alphabetic characters (case-insensitive).
     *
     * @param word the input word
     * @return CountResult containing vowel and consonant counts
     */
    public static CountResult count(String word) {
        if (word == null) {
            return new CountResult(0, 0);
        }

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = Character.toLowerCase(word.charAt(i));
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        return new CountResult(vowels, consonants);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String word = scanner.next();
            CountResult result = count(word);
            System.out.println(result);
        }
        scanner.close();
    }
}
