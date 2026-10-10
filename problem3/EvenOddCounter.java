package problem3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Problem 3: Even and Odd Numbers in a List
 * Counts how many numbers in a given list of integers are even and how many are odd.
 */
public class EvenOddCounter {

    public static class CountResult {
        private final int evenCount;
        private final int oddCount;

        public CountResult(int evenCount, int oddCount) {
            this.evenCount = evenCount;
            this.oddCount = oddCount;
        }

        public int getEvenCount() {
            return evenCount;
        }

        public int getOddCount() {
            return oddCount;
        }

        @Override
        public String toString() {
            return "Even: " + evenCount + "\nOdd: " + oddCount;
        }
    }

    /**
     * Counts even and odd numbers in the provided array.
     *
     * @param numbers array of integers
     * @return CountResult with even and odd counts
     */
    public static CountResult count(int[] numbers) {
        if (numbers == null) {
            return new CountResult(0, 0);
        }

        int even = 0;
        int odd = 0;

        for (int num : numbers) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        return new CountResult(even, odd);
    }

    /**
     * Parses an input string such as "[3, 8, 12, 5, 7, 10]" or "3 8 12 5 7 10".
     *
     * @param input raw input string
     * @return integer array
     */
    public static int[] parseNumbers(String input) {
        if (input == null || input.trim().isEmpty()) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();
        Matcher matcher = Pattern.compile("-?\\d+").matcher(input);
        while (matcher.find()) {
            list.add(Integer.parseInt(matcher.group()));
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int[] numbers = parseNumbers(line);
            CountResult result = count(numbers);
            System.out.println(result);
        }
        scanner.close();
    }
}
