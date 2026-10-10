package problem8;

import java.util.Scanner;

/**
 * Problem 8: Student Grade Assignment
 * Assigns a letter grade (Grade A, B, C, D, F) based on student marks out of 100
 * using an ordered if-else if-else conditional ladder.
 */
public class StudentGradeAssignment {

    /**
     * Determines the grade label based on marks.
     *
     * Criteria:
     * - A: 90 or above
     * - B: 75 to 89
     * - C: 60 to 74
     * - D: 40 to 59
     * - F: Below 40
     *
     * @param marks marks obtained (0 to 100)
     * @return grade string (e.g. "Grade A")
     */
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
