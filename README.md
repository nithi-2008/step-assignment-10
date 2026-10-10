# STEP Assignment 10: Control Flow, Arrays, Strings, OOP Basics & Polymorphism

This repository contains complete implementations, automated tests, and written solutions for **STEP SEM-3 · CodInClub | Powered by BridgeLabz — Category C (Assignment 10)**.

---

## Repository Structure

```text
step-assignment-10/
├── .gitignore                                 # Standard Java ignore rules
├── README.md                                  # Project overview & running instructions
├── SOLUTIONS.md                               # Complete QLA solutions (Parts A, B, and C)
│
├── problem1/
│   └── VowelConsonantCounter.java             # Problem 1: Vowel and Consonant Counter
├── problem2/
│   └── WordReverserPalindrome.java            # Problem 2: Word Reverser & Palindrome Checker
├── problem3/
│   └── EvenOddCounter.java                    # Problem 3: Even and Odd Numbers in a List
├── problem4/
│   └── InPlaceArrayReversal.java              # Problem 4: In-Place Array Reversal
├── problem5/
│   └── DigitSumAndReversal.java               # Problem 5: Digit Sum and Number Reversal
├── problem6/
│   └── PrimeNumberChecker.java                # Problem 6: Prime Number Checker
├── problem7/
│   └── FactorialCalculation.java              # Problem 7: Factorial Calculation
├── problem8/
│   └── StudentGradeAssignment.java            # Problem 8: Student Grade Assignment
├── problem9/
│   └── LeapYearDetector.java                  # Problem 9: Leap Year Detector
├── problem10/
│   └── StudentResultCardGenerator.java        # Problem 10: Student Result Card Generator
│
└── tests/
    └── AssignmentTestSuite.java               # Automated End-to-End Test Suite
```

---

## Part A: Coding Problems Summary

| Problem | Title | Concept Demonstrated | Primary Design / Algorithm |
| :---: | :--- | :--- | :--- |
| **1** | **Vowel & Consonant Counter** | String traversal & character conditionals | Evaluates characters case-insensitively, counting vowels (`a, e, i, o, u`) and consonants. |
| **2** | **Word Reverser & Palindrome Checker** | Mutable strings & palindrome logic | In-place string reversal with `StringBuilder`, comparing original vs. reversed. |
| **3** | **Even and Odd Numbers in a List** | Modulo arithmetic & list processing | Tests `num % 2 == 0` across integer streams and parses bracketed integer collections. |
| **4** | **In-Place Array Reversal** | Two-pointer technique & $O(1)$ memory | Modifies the source array in-place by swapping symmetrical boundary pointers. |
| **5** | **Digit Sum and Number Reversal** | Digit extraction & arithmetic loops | Uses repeated `% 10` and `/ 10` operations to compute digit sum and reconstructed reverse. |
| **6** | **Prime Number Checker** | Primality testing & $O(\sqrt{n})$ math | Efficient square root divisor check skipping even and multiple-of-3 candidates. |
| **7** | **Factorial Calculation** | Iterative accumulation & overflow safety | Computes $n!$ with $0! = 1$ base case, backed by `BigInteger` for arbitrary-length products. |
| **8** | **Student Grade Assignment** | Conditional branching ladder | Strict descending ladder checking $90\dots 100 \to \text{A}$, $75\dots 89 \to \text{B}$, $60\dots 74 \to \text{C}$, $40\dots 59 \to \text{D}$, $<40 \to \text{F}$. |
| **9** | **Leap Year Detector** | Boolean logic & calendar algorithms | Evaluates `(year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)`. |
| **10** | **Student Result Card Generator** | OOP encapsulation & data aggregation | Encapsulates student data in a `Student` class, calculates averages, assigns grades, and formats cards. |

---

## Part B: Quiz Summary

Complete answers and in-depth explanations for all 20 quiz questions are documented in [SOLUTIONS.md](SOLUTIONS.md#part-b--quiz-solutions).

- **Q1:** Option **D** — `s1 == s2` is false, and `s1.equals(s2)` is true
- **Q2:** Option **B** — `"baL avaJ"`
- **Q3:** Option **B** — `public Student(String name)`
- **Q4:** Option **D** — `w1 balance: 700, w2 balance: 700`
- **Q5:** Option **C** — `3`
- **Q6:** Option **A** — `45 78 92 60 85`
- **Q7:** Option **B** — `1 2 4 5`
- **Q8:** Option **A** — `5`
- **Q9:** Option **C** — `83.33333333333333`
- **Q10:** Option **B** — `Paid 510.0 by card`
- **Q11:** Option **B** — `The name object's value remains "java", and a new String object "JAVA" is created for upperName`
- **Q12:** Option **B** — `2`
- **Q13:** Option **A** — `6 / m`
- **Q14:** Option **A** — `4`
- **Q15:** Option **B** — `Title: Unknown, Price: 0.0`
- **Q16:** Option **A** — `Title: Java Programming, Price: 450.0`
- **Q17:** Option **B** — `2`
- **Q18:** Option **C** — `w1 balance: 700 / w2 balance: 700`
- **Q19:** Option **C** — `s1 name: Anu / s2 name: Ravi`
- **Q20:** Option **C** — `Total visitors: 3`

---

## Part C: Concept Questions Summary

Rigorous academic explanations and code snippets for all 10 concept questions are documented in [SOLUTIONS.md](SOLUTIONS.md#part-c--concept-questions):
1. **String Immutability & Performance Optimization** (`StringBuilder` / `StringBuffer`)
2. **Variable Shadowing Resolution with `this`**
3. **Object vs. Reference Variable & Memory Assignment Implications**
4. **Static Variables vs. Instance Variables Use Cases**
5. **Loop Comparisons (`for`, `while`, `do-while`) & Suitable Scenarios**
6. **Pass-by-Value Mechanics for Primitives vs. Object References**
7. **Integer Division Truncation & Explicit Floating-Point Casting**
8. **Encapsulation, Access Modifiers (`private`), and Data Integrity**
9. **`==` Reference Equality vs. `equals()` Value Equality Overriding**
10. **Method Overloading (Compile-Time) vs. Method Overriding (Run-Time)**

---

## How to Compile and Run

### Prerequisites
- Java Development Kit (JDK 8 or higher)

### 1. Compile All Files
From the root of the repository:
```bash
javac problem1/*.java problem2/*.java problem3/*.java problem4/*.java problem5/*.java problem6/*.java problem7/*.java problem8/*.java problem9/*.java problem10/*.java tests/*.java
```

### 2. Run the Automated Test Suite
```bash
java tests.AssignmentTestSuite
```

### 3. Run Individual Problems
```bash
# Problem 1
java problem1.VowelConsonantCounter

# Problem 2
java problem2.WordReverserPalindrome

# Problem 3
java problem3.EvenOddCounter

# Problem 4
java problem4.InPlaceArrayReversal

# Problem 5
java problem5.DigitSumAndReversal

# Problem 6
java problem6.PrimeNumberChecker

# Problem 7
java problem7.FactorialCalculation

# Problem 8
java problem8.StudentGradeAssignment

# Problem 9
java problem9.LeapYearDetector

# Problem 10
java problem10.StudentResultCardGenerator
```
