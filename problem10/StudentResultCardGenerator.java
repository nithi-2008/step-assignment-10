package problem10;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Problem 10: Student Result Card Generator
 * Encapsulates student information and marks array in a Student class,
 * computes average marks, assigns grades, and prints formatted uppercase result cards.
 */
public class StudentResultCardGenerator {

    public static class Student {
        private final String name;
        private final double[] marks;

        public Student(String name, double[] marks) {
            this.name = name;
            this.marks = marks != null ? marks.clone() : new double[0];
        }

        public String getName() {
            return name;
        }

        public double[] getMarks() {
            return marks.clone();
        }

        /**
         * Calculates the average of the student's marks.
         *
         * @return average mark, or 0.0 if no marks
         */
        public double calculateAverage() {
            if (marks == null || marks.length == 0) {
                return 0.0;
            }
            double sum = 0.0;
            for (double mark : marks) {
                sum += mark;
            }
            return sum / marks.length;
        }

        /**
         * Assigns a grade based on average:
         * - 'Grade B' for an average of 75 or more
         * - 'Grade C' for an average between 60 and 74 (inclusive)
         * - 'Grade D' for an average between 40 and 59 (inclusive)
         * - 'Grade F' for an average below 40
         *
         * @return grade string (e.g. "Grade B")
         */
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

        /**
         * Generates the result card string:
         * e.g., "ASHA: Average 80.0, Grade B"
         */
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

    /**
     * Parses a line such as "Asha [80, 90, 70]" or "Ravi 60 55 50" into a Student object.
     */
    public static Student parseStudent(String line) {
        if (line == null || line.trim().isEmpty()) {
            return null;
        }

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
