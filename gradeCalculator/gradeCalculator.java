import java.util.Scanner;
/**
 *
 * @author Ayush kumar
 */
class gradeCalculator {

    public static void main(String[] args) {

        //Taking Marks of the Subjects out of 100
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the total number of subjects: ");
        int totalSubjects = scanner.nextInt();

        int[] marks = new int[totalSubjects];
        for (int i = 0; i < totalSubjects; i++) {
            System.out.println("Enter the marks obtained out of 100 in subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        // Calculate the total marks
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        // Calculate the average percentage
        float averagePercentage = (float) totalMarks / totalSubjects;

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

        // Display the results
        System.out.println("Total marks: " + totalMarks + "/" + (totalSubjects * 100));
        System.out.println("Average percentage: " + averagePercentage);
        System.out.println("Grade: " + grade);

    }
}

		
