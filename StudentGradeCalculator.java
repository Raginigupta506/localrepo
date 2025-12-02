import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // --- Input ---
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = input.nextInt();

        int[] marks = new int[numberOfSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = input.nextInt();
            // Input validation to ensure marks are out of 100
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks entered. Please enter marks between 0 and 100.");
                // You might want to handle this more robustly, e.g., by re-prompting or exiting
                i--; // Decrement to re-prompt for the same subject
            } else {
                // --- Calculate Total Marks ---
                totalMarks += marks[i];
            }
        }

        // --- Calculate Average Percentage ---
        // Use double for accurate division
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // --- Grade Calculation ---
        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        // --- Display Results ---
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);

        input.close();
    }
}