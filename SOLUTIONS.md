# STEP Assignment 10 — Complete Solutions (QLA)
**Program:** STEP SEM-3 · CodInClub | Powered by BridgeLabz  
**Category:** Category C (Java Programming: Control Flow, Arrays, Strings, OOP Basics & Polymorphism)

---

## Table of Contents
1. [Part A — Coding Problems](#part-a--coding-problems)
   - [Problem 1: Vowel and Consonant Counter](#problem-1-vowel-and-consonant-counter)
   - [Problem 2: Word Reverser and Palindrome Checker](#problem-2-word-reverser-and-palindrome-checker)
   - [Problem 3: Even and Odd Numbers in a List](#problem-3-even-and-odd-numbers-in-a-list)
   - [Problem 4: In-Place Array Reversal](#problem-4-in-place-array-reversal)
   - [Problem 5: Digit Sum and Number Reversal](#problem-5-digit-sum-and-number-reversal)
   - [Problem 6: Prime Number Checker](#problem-6-prime-number-checker)
   - [Problem 7: Factorial Calculation](#problem-7-factorial-calculation)
   - [Problem 8: Student Grade Assignment](#problem-8-student-grade-assignment)
   - [Problem 9: Leap Year Detector](#problem-9-leap-year-detector)
   - [Problem 10: Student Result Card Generator](#problem-10-student-result-card-generator)
2. [Part B — Quiz Solutions](#part-b--quiz-solutions)
3. [Part C — Concept Questions](#part-c--concept-questions)

---

# Part A — Coding Problems

---

### Problem 1: Vowel and Consonant Counter

#### Problem Description
Write a program that reads a single word and then counts and prints the total number of vowels and consonants in that word. Assume the input word contains only alphabetic characters (case-insensitive).

#### Example
- **Sample Input:** `Programming`
- **Expected Output:**
  ```text
  Vowels: 3
  Consonants: 8
  ```

#### Algorithm & Design
1. Convert each character to lowercase using `Character.toLowerCase(ch)`.
2. Check if the character is a vowel (`'a'`, `'e'`, `'i'`, `'o'`, `'u'`).
3. If it is an alphabetic character and not a vowel, count it as a consonant.
4. Output the formatted counts.

#### Java Implementation
```java
package problem1;

import java.util.Scanner;

public class VowelConsonantCounter {

    public static class CountResult {
        private final int vowels;
        private final int consonants;

        public CountResult(int vowels, int consonants) {
            this.vowels = vowels;
            this.consonants = consonants;
        }

        public int getVowels() { return vowels; }
        public int getConsonants() { return consonants; }

        @Override
        public String toString() {
            return "Vowels: " + vowels + "\nConsonants: " + consonants;
        }
    }

    public static CountResult count(String word) {
        if (word == null) return new CountResult(0, 0);

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
            System.out.println(count(word));
        }
        scanner.close();
    }
}
```

---

### Problem 2: Word Reverser and Palindrome Checker

#### Problem Description
Create a program that reads a word, reverses it using a mutable text builder (like `StringBuilder` in Java), and then prints the reversed word. Additionally, determine and print whether the original word reads the same forwards and backwards (is a palindrome).

#### Example
- **Sample Input:**
  ```text
  level
  java
  ```
- **Expected Output:**
  ```text
  level - palindrome
  avaj - not a palindrome
  ```

#### Algorithm & Design
1. Use `StringBuilder(word).reverse().toString()` to construct the reversed word in mutable memory.
2. Compare the original word and reversed word case-insensitively using `word.equalsIgnoreCase(reversed)`.
3. Format output as `<reversed> - palindrome` or `<reversed> - not a palindrome`.

#### Java Implementation
```java
package problem2;

import java.util.Scanner;

public class WordReverserPalindrome {

    public static String reverseWord(String word) {
        if (word == null) return "";
        return new StringBuilder(word).reverse().toString();
    }

    public static boolean isPalindrome(String word) {
        if (word == null) return false;
        String reversed = reverseWord(word);
        return word.equalsIgnoreCase(reversed);
    }

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
```

---

### Problem 3: Even and Odd Numbers in a List

#### Problem Description
Given a list of integers, write a program to count how many numbers in the list are even and how many are odd. Print the counts for both categories.

#### Example
- **Sample Input:** `[3, 8, 12, 5, 7, 10]`
- **Expected Output:**
  ```text
  Even: 3
  Odd: 3
  ```

#### Algorithm & Design
1. Parse integers from the input format (supporting brackets, commas, and whitespace).
2. For each number, test `num % 2 == 0`. If true, increment even count; otherwise increment odd count.
3. Print counts.

#### Java Implementation
```java
package problem3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EvenOddCounter {

    public static class CountResult {
        private final int evenCount;
        private final int oddCount;

        public CountResult(int evenCount, int oddCount) {
            this.evenCount = evenCount;
            this.oddCount = oddCount;
        }

        public int getEvenCount() { return evenCount; }
        public int getOddCount() { return oddCount; }

        @Override
        public String toString() {
            return "Even: " + evenCount + "\nOdd: " + oddCount;
        }
    }

    public static CountResult count(int[] numbers) {
        if (numbers == null) return new CountResult(0, 0);

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

    public static int[] parseNumbers(String input) {
        if (input == null || input.trim().isEmpty()) return new int[0];
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
            System.out.println(count(numbers));
        }
        scanner.close();
    }
}
```

---

### Problem 4: In-Place Array Reversal

#### Problem Description
Write a program that reverses the order of token numbers stored in a list. The reversal must be done 'in-place', meaning you should modify the original list directly without creating a second list.

#### Example
- **Sample Input:** `[11, 22, 33, 44]`
- **Expected Output:** `[44, 33, 22, 11]`

#### Algorithm & Design
1. Initialize two pointers: `left = 0` and `right = length - 1`.
2. While `left < right`:
   - Swap the element at `array[left]` with `array[right]`.
   - Increment `left` and decrement `right`.
3. Memory complexity is strictly $O(1)$ auxiliary space.

#### Java Implementation
```java
package problem4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InPlaceArrayReversal {

    public static void reverseInPlace(int[] array) {
        if (array == null || array.length <= 1) return;

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

    public static int[] parseNumbers(String input) {
        if (input == null || input.trim().isEmpty()) return new int[0];
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
            reverseInPlace(numbers);
            System.out.println(Arrays.toString(numbers));
        }
        scanner.close();
    }
}
```

---

### Problem 5: Digit Sum and Number Reversal

#### Problem Description
Write a program that reads a positive integer and performs two operations: it calculates and prints the sum of its digits, and it prints the number with its digits reversed.

#### Example
- **Sample Input:** `4721`
- **Expected Output:**
  ```text
  Sum of digits: 14
  Reverse: 1274
  ```

#### Algorithm & Design
1. Maintain `sum = 0` and `reversed = 0`.
2. Extract the last digit using `digit = n % 10`.
3. Add `digit` to `sum`, and shift reversed number: `reversed = reversed * 10 + digit`.
4. Divide `n` by 10 (`n = n / 10`) until `n == 0`.

#### Java Implementation
```java
package problem5;

import java.util.Scanner;

public class DigitSumAndReversal {

    public static class Result {
        private final int sumOfDigits;
        private final long reversedNumber;

        public Result(int sumOfDigits, long reversedNumber) {
            this.sumOfDigits = sumOfDigits;
            this.reversedNumber = reversedNumber;
        }

        public int getSumOfDigits() { return sumOfDigits; }
        public long getReversedNumber() { return reversedNumber; }

        @Override
        public String toString() {
            return "Sum of digits: " + sumOfDigits + "\nReverse: " + reversedNumber;
        }
    }

    public static Result process(long number) {
        if (number == 0) return new Result(0, 0);

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
            System.out.println(process(number));
        }
        scanner.close();
    }
}
```

---

### Problem 6: Prime Number Checker

#### Problem Description
Write a program that reads a number greater than 1 and determines whether it is a prime number. A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself. Print whether the number is prime or not.

#### Example
- **Sample Input:**
  ```text
  29
  21
  ```
- **Expected Output:**
  ```text
  29 is prime
  21 is not prime
  ```

#### Algorithm & Design
1. Any number $n \le 1$ is not prime.
2. For $n \in \{2, 3\}$, $n$ is prime.
3. If $n$ is divisible by 2 or 3, return false.
4. Iterate trial divisors from 5 up to $\lfloor\sqrt{n}\rfloor$ with step 6 testing $i$ and $i+2$.

#### Java Implementation
```java
package problem6;

import java.util.Scanner;

public class PrimeNumberChecker {

    public static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        long limit = (long) Math.sqrt(n);
        for (long i = 5; i <= limit; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

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
```

---

### Problem 7: Factorial Calculation

#### Problem Description
Write a program that reads a non-negative integer and calculates its factorial. The factorial of a non-negative integer $n$, denoted by $n!$, is the product of all positive integers less than or equal to $n$. The factorial of 0 is defined as 1.

#### Example
- **Sample Input:**
  ```text
  5
  0
  ```
- **Expected Output:**
  ```text
  120
  1
  ```

#### Algorithm & Design
1. Base cases: $0! = 1$ and $1! = 1$.
2. For $n \ge 2$, iterate $i$ from 2 to $n$, accumulating the product using `BigInteger` to avoid arithmetic overflow.

#### Java Implementation
```java
package problem7;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialCalculation {

    public static BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative integers: " + n);
        }
        if (n == 0 || n == 1) return BigInteger.ONE;

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
```

---

### Problem 8: Student Grade Assignment

#### Problem Description
Write a program that reads a student's marks (out of 100) and prints their corresponding grade based on the following criteria:
- **A:** 90 or above
- **B:** 75 to 89
- **C:** 60 to 74
- **D:** 40 to 59
- **F:** Below 40

#### Example
- **Sample Input:**
  ```text
  72
  95
  35
  ```
- **Expected Output:**
  ```text
  Grade C
  Grade A
  Grade F
  ```

#### Java Implementation
```java
package problem8;

import java.util.Scanner;

public class StudentGradeAssignment {

    public static String getGrade(double marks) {
        if (marks >= 90.0) {
            return "Grade A";
        } else if (marks >= 75.0) {
            return "Grade B";
        } else if (marks >= 60.0) {
            return "Grade C";
        } else if (marks >= 40.0) {
            return "Grade D";
        } else {
            return "Grade F";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextDouble()) {
            double marks = scanner.nextDouble();
            System.out.println(getGrade(marks));
        }
        scanner.close();
    }
}
```

---

### Problem 9: Leap Year Detector

#### Problem Description
Write a program that reads a year and determines if it is a leap year. A year is a leap year if it is divisible by 4, but not by 100, unless it is also divisible by 400.

#### Example
- **Sample Input:**
  ```text
  2024
  1900
  2000
  ```
- **Expected Output:**
  ```text
  Leap year
  Not a leap year
  Leap year
  ```

#### Algorithm & Design
- Condition: `(year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)`.
- If true, print `"Leap year"`; otherwise print `"Not a leap year"`.

#### Java Implementation
```java
package problem9;

import java.util.Scanner;

public class LeapYearDetector {

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

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
```

---

### Problem 10: Student Result Card Generator

#### Problem Description
Design a system for student result cards. Each student has a name and an array of three marks. Implement a method to calculate the student's average mark. Based on the average, assign a grade using the following conditions: `'B'` for an average of 75 or more, `'D'` for an average between 40 and 59 (inclusive), and other grades as per your design. Finally, print the student's name in capital letters, their average mark (one decimal place), and their assigned grade.

#### Example
- **Sample Input:**
  ```text
  Asha [80, 90, 70]
  Ravi [60, 55, 50]
  ```
- **Expected Output:**
  ```text
  ASHA: Average 80.0, Grade B
  RAVI: Average 55.0, Grade D
  ```

#### Key OOP Design
- `Student` class encapsulates `name` and `marks` fields.
- `calculateAverage()` sums marks and divides by `marks.length`.
- `getGrade()` assigns `'Grade B'` for $\ge 75$, `'Grade C'` for $60–74$, `'Grade D'` for $40–59$, and `'Grade F'` otherwise.
- Converts `name.toUpperCase()` and formats with `Locale.US` to one decimal place (`%.1f`).

#### Java Implementation
```java
package problem10;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentResultCardGenerator {

    public static class Student {
        private final String name;
        private final double[] marks;

        public Student(String name, double[] marks) {
            this.name = name;
            this.marks = marks != null ? marks.clone() : new double[0];
        }

        public String getName() { return name; }
        public double[] getMarks() { return marks.clone(); }

        public double calculateAverage() {
            if (marks == null || marks.length == 0) return 0.0;
            double sum = 0.0;
            for (double mark : marks) sum += mark;
            return sum / marks.length;
        }

        public String getGrade() {
            double avg = calculateAverage();
            if (avg >= 75.0) {
                return "Grade B";
            } else if (avg >= 60.0) {
                return "Grade C";
            } else if (avg >= 40.0) {
                return "Grade D";
            } else {
                return "Grade F";
            }
        }

        public String getResultCard() {
            return String.format(Locale.US, "%s: Average %.1f, %s",
                    name.toUpperCase(),
                    calculateAverage(),
                    getGrade());
        }

        @Override
        public String toString() {
            return getResultCard();
        }
    }

    public static Student parseStudent(String line) {
        if (line == null || line.trim().isEmpty()) return null;

        line = line.trim();
        String name;
        String numbersPart;

        if (line.contains("[")) {
            int bracketStart = line.indexOf('[');
            int bracketEnd = line.indexOf(']', bracketStart);
            name = line.substring(0, bracketStart).trim();
            numbersPart = bracketEnd != -1 ? line.substring(bracketStart + 1, bracketEnd) : line.substring(bracketStart + 1);
        } else {
            String[] parts = line.split("\\s+", 2);
            name = parts[0];
            numbersPart = parts.length > 1 ? parts[1] : "";
        }

        List<Double> marksList = new ArrayList<>();
        Matcher matcher = Pattern.compile("[-+]?\\d*\\.?\\d+").matcher(numbersPart);
        while (matcher.find()) {
            marksList.add(Double.parseDouble(matcher.group()));
        }

        double[] marks = new double[marksList.size()];
        for (int i = 0; i < marksList.size(); i++) {
            marks[i] = marksList.get(i);
        }

        return new Student(name, marks);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Student student = parseStudent(line);
            if (student != null) {
                System.out.println(student.getResultCard());
            }
        }
        scanner.close();
    }
}
```

---

# Part B — Quiz Solutions

| Question | Topic / Code Snippet | Correct Option | Correct Answer Text |
| :---: | :--- | :---: | :--- |
| **Q1** | String comparison: `new String("hello")` vs `new String("hello")` | **D** | `s1 == s2` is false, and `s1.equals(s2)` is true. |
| **Q2** | `StringBuilder`: append "Java", append " Lab", reverse() | **B** | `"baL avaJ"` |
| **Q3** | Constructor delegation: `new Student("Ravi")` | **B** | `public Student(String name)` |
| **Q4** | Reference aliasing: `w2 = w1; w2.add(200);` | **D** | `w1 balance: 700, w2 balance: 700` |
| **Q5** | Static counter in Visitor class after 3 instantiations | **C** | `3` |
| **Q6** | Array traversal `for (int i = 0; i < scores.length; i++)` | **A** | `45 78 92 60 85` |
| **Q7** | Loop control: `if (i == 3) continue;` for $1 \dots 5$ | **B** | `1 2 4 5` |
| **Q8** | Pass-by-value primitive: `change(int n) { n = 10; }` | **A** | `5` |
| **Q9** | Numeric promotion: `int total = 250; double count = 3; total / count` | **C** | `83.33333333333333` |
| **Q10** | Polymorphism & abstract override: `Payment p = new Card(); p.pay(500);` | **B** | `Paid 510.0 by card` |
| **Q11** | String immutability: `String upperName = name.toUpperCase();` | **B** | The name object's value remains "java", and a new String object "JAVA" is created for upperName. |
| **Q12** | String pool object count: `s1 = "hello"; s2 = "hello"; s3 = new String("hello");` | **B** | `2` |
| **Q13** | String methods: `"Campus".length()` and `"Campus".charAt(2)` | **A** | `6 / m` |
| **Q14** | String searching: `"user@domain.com".indexOf("@")` | **A** | `4` |
| **Q15** | Default constructor: `Book b = new Book();` | **B** | `Title: Unknown, Price: 0.0` |
| **Q16** | Parameterized constructor: `new Book("Java Programming", 450.0)` | **A** | `Title: Java Programming, Price: 450.0` |
| **Q17** | Object allocation: `w1 = new Wallet(500); w2 = w1; w3 = new Wallet(500);` | **B** | `2` |
| **Q18** | Reference mutation: `w2 = w1; w2.add(200);` | **C** | `w1 balance: 700 / w2 balance: 700` |
| **Q19** | Independent instances: `s1.setName("Anu")` while `s2` is `"Ravi"` | **C** | `s1 name: Anu / s2 name: Ravi` |
| **Q20** | Static variable access: `Visitor.visitorCount` after 3 instances | **C** | `Total visitors: 3` |

---

### In-Depth Quiz Explanations

1. **Q1 — Option D (`s1 == s2` is false, and `s1.equals(s2)` is true):**  
   The `==` operator tests reference identity (whether two pointers refer to the exact same memory address). Because each `new String("hello")` explicitly constructs a new distinct object on the heap, `s1 == s2` evaluates to `false`. The `.equals()` method of `String` overrides `Object.equals()` to compare the character sequences; because both strings contain `"hello"`, `s1.equals(s2)` returns `true`.

2. **Q2 — Option B (`"baL avaJ"`):**  
   `sb.append("Java")` initializes the buffer with `"Java"`. `sb.append(" Lab")` mutates the buffer to `"Java Lab"`. Calling `sb.reverse()` reverses the character sequence in-place, yielding `"baL avaJ"`.

3. **Q3 — Option B (`public Student(String name)`):**  
   When `new Student("Ravi")` is called, Java compiler matches the single `String` parameter constructor signature `public Student(String name)`. That constructor is called directly, and inside its body it explicitly delegates via `this(name, "Not assigned")` to the two-parameter constructor.

4. **Q4 — Option D (`w1 balance: 700, w2 balance: 700`):**  
   In Java, assigning an object reference (`Wallet w2 = w1;`) does not clone or copy the underlying object; it copies the memory reference. Both `w1` and `w2` point to the exact same `Wallet` instance on the heap. Mutating state via `w2.add(200)` alters the balance of that single instance from 500 to 700, which is visible through both references.

5. **Q5 — Option C (`3`):**  
   Static fields are class-level variables shared across all instances of a class. When `new Visitor("Asha")`, `new Visitor("Ravi")`, and `new Visitor("Neha")` are executed, the constructor increments the shared `count` variable three times ($0 \to 1 \to 2 \to 3$). `Visitor.getTotalVisitors()` returns 3.

6. **Q6 — Option A (`45 78 92 60 85`):**  
   The loop begins at index 0 and terminates when `i < scores.length` (index 4). It visits every element in order and prints each followed by a space.

7. **Q7 — Option B (`1 2 4 5`):**  
   The `continue` statement immediately skips the rest of the current loop iteration when `i == 3` and advances to `i++`. Thus, `3` is not printed, producing `1 2 4 5 `.

8. **Q8 — Option A (`5`):**  
   Java is strictly pass-by-value. When `change(x)` is invoked with primitive `int x = 5`, a copy of `5` is passed into the stack frame of `change`. Reassigning parameter `n = 10` modifies only the local parameter variable, leaving the original variable `x` in `main` completely unaffected.

9. **Q9 — Option C (`83.33333333333333`):**  
   In Java's binary numeric promotion rules (JLS §5.6.2), when an `int` (`total = 250`) and a `double` (`count = 3.0`) participate in arithmetic division, the `int` is widened to `double` ($250.0$). Floating-point division $250.0 / 3.0$ evaluates to IEEE 754 double precision `83.33333333333333`.

10. **Q10 — Option B (`Paid 510.0 by card`):**  
    Polymorphic method invocation dynamically binds `p.pay(500)` to `Card`'s concrete implementation at runtime. Fee is $500 \times 0.02 = 10.0$, making total amount $500 + 10.0 = 510.0$.

11. **Q11 — Option B (`The name object's value remains "java", and a new String object "JAVA" is created for upperName`):**  
    `java.lang.String` is immutable. Methods like `toUpperCase()` never mutate the existing instance; they instantiate and return a new `String` object containing the transformed characters.

12. **Q12 — Option B (`2`):**  
    The string literal `"hello"` is interned into the String Constant Pool once upon encounter; both `s1` and `s2` refer to this single pooled object. The explicit `new String("hello")` invocation creates a second, distinct `String` instance on the standard heap. Total: 2 objects.

13. **Q13 — Option A (`6 / m`):**  
    `"Campus".length()` returns 6 (number of UTF-16 code units). In zero-based indexing, `"Campus".charAt(2)` corresponds to: index 0='C', 1='a', 2='m'. Hence the output is 6 followed by m.

14. **Q14 — Option A (`4`):**  
    In `"user@domain.com"`, indices are: 'u' (0), 's' (1), 'e' (2), 'r' (3), and '@' (4). `indexOf("@")` returns index 4.

15. **Q15 — Option B (`Title: Unknown, Price: 0.0`):**  
    The no-argument constructor explicitly initializes `this.title = "Unknown"` and `this.price = 0.0`. `getDetails()` returns `"Title: Unknown, Price: 0.0"`.

16. **Q16 — Option A (`Title: Java Programming, Price: 450.0`):**  
    The parameterized constructor assigns `"Java Programming"` to `title` and `450.0` to `price`.

17. **Q17 — Option B (`2`):**  
    The `new` operator allocates memory for an object on the heap. Since `new Wallet(500)` is called exactly twice (`w1` and `w3`), only 2 objects exist. `w2 = w1` copies a reference, not creating a new object.

18. **Q18 — Option C (`w1 balance: 700 / w2 balance: 700`):**  
    Because `w2` aliases `w1`, `w2.add(200)` mutates the shared heap object. Both `w1.balance` and `w2.balance` read 700.

19. **Q19 — Option C (`s1 name: Anu / s2 name: Ravi`):**  
    `s1` and `s2` refer to distinct object instances. Calling `s1.setName("Anu")` modifies only `s1`'s internal state. `s2`'s state remains `"Ravi"`.

20. **Q20 — Option C (`Total visitors: 3`):**  
    The static variable `visitorCount` belongs to class `Visitor`. Each instance creation increments the single shared counter, reaching 3.

---

# Part C — Concept Questions

---

### Question 1
**Prompt:**  
*Explain the concept of String immutability in Java and discuss its impact on performance when a String object undergoes repeated modifications. How can this performance impact be mitigated?*

**Answer:**  
In Java, **String immutability** means that once a `String` object is created in memory, its internal state (character sequence) cannot be altered. Any method that appears to modify a string (such as `concat()`, `replace()`, or `toUpperCase()`) actually allocates and returns a completely new `String` object on the heap, leaving the original string unchanged.

**Performance Impact:**  
When strings undergo repeated modifications—such as in loops or iterative parsing—frequent string concatenations (e.g., using `+=`) lead to an $O(N^2)$ time complexity and severe memory churn. In each iteration:
1. A new `StringBuilder` is temporarily allocated.
2. Existing characters are copied over.
3. A new `String` object is allocated, and the old strings become eligible for garbage collection, resulting in high Garbage Collector (GC) pressure and CPU overhead.

**Mitigation:**  
To mitigate this performance degradation, developers should use mutable character sequence builders:
- **`StringBuilder`:** A high-performance, unsynchronized mutable sequence recommended for single-threaded environments and local method scopes.
- **`StringBuffer`:** A thread-safe, synchronized alternative for multi-threaded access.

Both classes maintain an internal resizable character array (`char[]` / `byte[]`), modifying characters in-place without generating intermediate garbage objects.

---

### Question 2
**Prompt:**  
*In a Java class constructor, when both an instance variable and a constructor parameter share the same name, how does the 'this' keyword resolve this ambiguity? Provide an example scenario to illustrate its use.*

**Answer:**  
In Java, when a constructor parameter or local variable shares the same identifier as an instance variable, the local parameter **shadows** the instance variable within that scope. Referencing the identifier unqualified refers strictly to the local parameter.

The **`this`** keyword represents a reference to the current object instance whose constructor or method is currently executing. By prefixing the field with `this.` (`this.fieldName`), the developer explicitly tells the Java compiler to target the instance variable rather than the local parameter, resolving the shadowing ambiguity.

**Example Scenario:**
```java
public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        // 'name' and 'salary' alone refer to the incoming parameters.
        // 'this.name' and 'this.salary' refer to the instance fields.
        this.name = name;
        this.salary = salary;
    }
}
```

---

### Question 3
**Prompt:**  
*Differentiate between an object and a reference variable in Java. Explain what occurs in memory when one reference variable is assigned the value of another, detailing the implications for object manipulation.*

**Answer:**  
- **Object:** An actual instance of a class allocated on the **Heap** memory. It occupies physical memory containing runtime data: object headers, instance fields, and method table pointers.
- **Reference Variable:** A variable (typically stored on the **Stack** or within another object's heap layout) that contains the **memory address** pointing to the object on the heap, rather than holding the object's data directly.

**Memory behavior during assignment (`ref2 = ref1`):**  
When `ref2 = ref1` executes, Java copies the bit pattern of `ref1`—which is the memory address—into `ref2`. No new object is allocated on the heap. Both `ref1` and `ref2` now point to the exact same heap memory block (an aliased reference).

**Implications for Object Manipulation:**  
Because both references address the identical object in heap memory:
1. Mutating the object's state via `ref2` (e.g., `ref2.setBalance(100)`) directly mutates the single shared instance.
2. The change is immediately visible when querying `ref1.getBalance()`.
3. Reassigning `ref2 = null` or `ref2 = new Object()` merely changes where `ref2` points; it does not destroy or mutate the object pointed to by `ref1`.

---

### Question 4
**Prompt:**  
*Discuss the appropriate use cases for static variables and instance variables in Java. Provide a scenario where a static member would be preferred and another where an instance member is more suitable, justifying your choices.*

**Answer:**  
- **Static Variables (Class Variables):** Belong to the class itself rather than any individual instance. There is only one copy in memory, loaded once into the JVM Metaspace/Heap, accessible by all instances.
  - *Appropriate Use Cases:* Class-wide counters, shared configuration constants, singleton references, and shared resource pools (e.g., database connection pools).
- **Instance Variables (Object Fields):** Belong to individual object instances. Every object allocated with `new` receives its own distinct copy of instance variables on the heap.
  - *Appropriate Use Cases:* State that varies between objects, representing an individual entity's properties.

**Scenarios:**
1. **Static Member Preference:** Tracking global bank statistics, such as `static double interestRate` or `static int totalAccountsOpened`. If the interest rate changes, updating `BankAccount.interestRate` updates the rate for all accounts simultaneously in $O(1)$ operations without needing to iterate over every account object.
2. **Instance Member Preference:** Storing a client's `accountNumber` and `currentBalance`. Each customer possesses distinct balances; if `currentBalance` were static, depositing money into one customer's account would overwrite the balance of every customer across the entire bank.

---

### Question 5
**Prompt:**  
*Compare and contrast the for, while, and do-while loops in Java. Describe specific programming scenarios where each type of loop would be the most suitable choice, explaining your reasoning.*

**Answer:**  
Java provides three primary looping constructs differing in iteration control and evaluation timing:

| Loop Construct | Condition Evaluation | Minimum Executions | Primary Characteristics |
| :--- | :--- | :---: | :--- |
| **`for` Loop** | Pre-test (before loop body) | 0 | Consolidates initialization, condition, and step update in a single compact header. |
| **`while` Loop** | Pre-test (before loop body) | 0 | Evaluates a boolean condition prior to executing the body; suitable when step logic is variable. |
| **`do-while` Loop** | Post-test (after loop body) | 1 | Executes the body at least once unconditionally before testing the condition. |

**Suitable Scenarios:**
1. **`for` Loop:** Traversing a fixed-size data structure (e.g., iterating through an array `for (int i = 0; i < arr.length; i++)`). The number of iterations is known in advance, and scoping the loop index variable `i` strictly within the loop header prevents variable leakage.
2. **`while` Loop:** Reading data from an I/O stream, network socket, or database cursor where the total number of records is unknown (e.g., `while (scanner.hasNextLine())` or `while (resultSet.next())`). If the stream is empty at the start, the loop body should never execute.
3. **`do-while` Loop:** Interactive console menus and user credential prompts (e.g., prompting the user to enter a valid password until complexity requirements are met). The prompt must display to the user at least once before validating their input.

---

### Question 6
**Prompt:**  
*Explain the concept of pass-by-value in Java. Differentiate its behavior and implications when a method receives a primitive data type as an argument versus when it receives an object reference.*

**Answer:**  
In Java, **all parameters are passed strictly by value**. This means that when a method is invoked, Java always creates a copy of the argument's bits and passes that copy into the method's local stack frame.

**Behavior Differences:**
1. **Primitive Data Types (`int`, `double`, `boolean`, etc.):**
   - The actual literal value (e.g., the number `5`) is copied onto the callee's stack frame.
   - Any reassignments or modifications made to the parameter inside the method affect only the local copy; the caller's original variable remains completely unchanged.
2. **Object References (`String`, `List`, `CustomObject`, etc.):**
   - The value being copied is the **memory address (pointer)** referencing the object on the heap, NOT the object itself.
   - **Implication 1 (Object Mutation):** If the method invokes mutator methods or modifies fields of the object (e.g., `list.add("item")`), the changes alter the shared heap object and are visible to the caller.
   - **Implication 2 (Reference Reassignment):** If the method reassigns the parameter variable to a new object (e.g., `param = new CustomObject()`), it only overwrites its local copy of the memory address. The caller's original reference continues pointing to the original object.

---

### Question 7
**Prompt:**  
*Describe how integer division operates in Java, specifically how it handles fractional results. Explain why an explicit type cast might be necessary to obtain a precise floating-point result from an arithmetic expression involving integers.*

**Answer:**  
In Java, when the division operator `/` is applied between two integer operands (such as `int` or `long`), Java performs **integer division**. Integer division discards (truncates) any fractional or decimal portion, retaining only the integer quotient. For example, `7 / 2` evaluates to `3`, not `3.5`. This truncation is not rounding; it discards all digits after the decimal point toward zero.

**Why Explicit Type Casting is Necessary:**  
According to Java's binary numeric promotion rules, an expression is evaluated based on the types of its operands before assignment. If two integers are divided, the division is evaluated entirely in integer arithmetic *first*, producing a truncated integer, even if the result is subsequently assigned to a `double` variable:
```java
int total = 7;
int count = 2;
double avg = total / count; // 7 / 2 evaluates to 3 first, then widens to 3.0!
```
To obtain a precise floating-point result ($3.5$), at least one operand must be explicitly cast to a floating-point type (`double` or `float`):
```java
double avg = (double) total / count; // total is widened to 7.0, triggering floating-point division (7.0 / 2.0 = 3.5)
```
The explicit cast `(double) total` promotes the operand to `double`, which compels Java to promote the second operand `count` to `double`, executing true IEEE 754 floating-point division.

---

### Question 8
**Prompt:**  
*Elaborate on the principle of encapsulation in Object-Oriented Programming. Discuss how Java's access modifiers (e.g., private) combined with getter and setter methods contribute to enforcing encapsulation and ensuring data integrity.*

**Answer:**  
**Encapsulation** is the object-oriented design principle of packaging an object's state (data fields) and behavior (methods) into a cohesive unit while hiding its internal implementation details from external direct access (data hiding).

**Enforcement via Access Modifiers and Accessors/Mutators:**
1. **Access Modifiers (`private`):** Declaring instance variables `private` creates a defensive boundary around the object. External classes cannot directly inspect or modify the object's internal fields, preventing external code from corrupting state or bypassing invariants.
2. **Getter and Setter Methods:**
   - **Data Validation & Business Rules:** Setters allow the class to validate incoming values before updating state (e.g., verifying that `age >= 0` or `balance >= withdrawalAmount`). If validation fails, the setter rejects the change or throws an exception.
   - **Immutability and Read-Only State:** By providing a getter without a setter, a field becomes read-only to external consumers.
   - **Decoupling & Flexibility:** The internal representation of data can be refactored (e.g., storing a birth date instead of age) without breaking external code, as long as the public getter contract remains consistent.

---

### Question 9
**Prompt:**  
*Explain the fundamental distinction between using the == operator and the equals() method when comparing two objects in Java. Illustrate how overriding the equals() method affects object comparison.*

**Answer:**  
- **`==` Operator (Reference Equality):** Compares the memory addresses of two object reference variables. `a == b` returns `true` if and only if both references point to the exact same object location in heap memory.
- **`equals()` Method (Logical / Value Equality):** Defined in `java.lang.Object`. The default implementation in `Object` simply performs `this == obj` (reference equality). However, subclasses can override `equals()` to compare the meaningful internal field values of the two objects.

**Illustration of Overriding `equals()`:**
```java
class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Check reference equality first
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && (name != null ? name.equals(student.name) : student.name == null);
    }
}
```
**Effect:**
```java
Student s1 = new Student(101, "Asha");
Student s2 = new Student(101, "Asha");

System.out.println(s1 == s2);      // false: Distinct heap allocations
System.out.println(s1.equals(s2));  // true: Overridden equals() validates identical id and name values
```

---

### Question 10
**Prompt:**  
*Differentiate between method overloading and method overriding in Java, both of which are forms of polymorphism. Explain when each is resolved (compile-time vs. run-time) and provide a concise example for each concept.*

**Answer:**  
Both method overloading and method overriding achieve polymorphism, but operate under completely different mechanisms:

| Feature | Method Overloading (Compile-Time Polymorphism) | Method Overriding (Run-Time Polymorphism) |
| :--- | :--- | :--- |
| **Location** | Within the **same class** | Across a **parent and subclass** hierarchy |
| **Signature** | Same method name, **different parameter lists** (types, count, order) | **Identical** method name, parameter list, and return type |
| **Resolution Time** | **Compile-time** (Static Binding) based on reference type and arguments | **Run-time** (Dynamic Dispatch) based on actual heap object type |
| **Keyword** | N/A | Annotated with `@Override` |

**Concise Examples:**

**1. Method Overloading:**
```java
class Calculator {
    // Overloaded add methods
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }
}
```

**2. Method Overriding:**
```java
class Animal {
    public void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}

// Runtime resolution:
Animal myPet = new Dog();
myPet.makeSound(); // Prints "Bark" via dynamic method dispatch
```
