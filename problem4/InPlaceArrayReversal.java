package problem4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Problem 4: In-Place Array Reversal
 * Reverses the order of token numbers in an array/list directly 'in-place'
 * using two pointers without allocating a secondary list.
 */
public class InPlaceArrayReversal {

    /**
     * Reverses an integer array in-place using two pointers.
     *
     * @param array array to reverse
     */
    public static void reverseInPlace(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * Reverses a generic List in-place using two pointers.
     *
     * @param list list to reverse
     * @param <T> element type
     */
    public static <T> void reverseInPlace(List<T> list) {
        if (list == null || list.size() <= 1) {
            return;
        }

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    /**
     * Parses input string such as "[11, 22, 33, 44]" into an integer array.
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

    /**
     * Formats integer array as "[11, 22, 33, 44]".
     */
    public static String formatArray(int[] array) {
        return Arrays.toString(array);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int[] numbers = parseNumbers(line);
            reverseInPlace(numbers);
            System.out.println(formatArray(numbers));
        }
        scanner.close();
    }
}
