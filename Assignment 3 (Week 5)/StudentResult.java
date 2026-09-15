import java.util.Scanner;

class InvalidMarksException extends Exception {

    InvalidMarksException(String message) {
        super(message);
    }
}

public class StudentResult {

    static void validateMarks(int marks)
            throws InvalidMarksException {

        if (marks < 0 || marks > 100) {

            throw new InvalidMarksException(
                    "Marks must be between 0 and 100"
            );
        }
    }

    static char calculateGrade(double percentage) {

        if (percentage >= 90) {
            return 'A';
        } 
        else if (percentage >= 80) {
            return 'B';
        } 
        else if (percentage >= 70) {
            return 'C';
        } 
        else if (percentage >= 60) {
            return 'D';
        } 
        else if (percentage >= 40) {
            return 'E';
        } 
        else {
            return 'F';
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter number of subjects: ");
            int subjects = Integer.parseInt(sc.nextLine());

            if (subjects <= 0) {

                throw new InvalidMarksException(
                        "Number of subjects must be greater than zero"
                );
            }

            int total = 0;

            for (int i = 1; i <= subjects; i++) {

                System.out.print(
                        "Enter marks for subject " + i + ": "
                );

                int marks = Integer.parseInt(sc.nextLine());

                validateMarks(marks);

                total = total + marks;
            }

            double percentage =
                    (double) total / (subjects * 100) * 100;

            char grade = calculateGrade(percentage);

            System.out.println("\n----- Student Result -----");
            System.out.println("Total Marks: " + total);
            System.out.println("Percentage: " + percentage + "%");
            System.out.println("Grade: " + grade);
        }

        catch (NumberFormatException e) {

            System.out.println(
                    "Error: Please enter numbers only"
            );
        }

        catch (InvalidMarksException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }

        finally {

            sc.close();

            System.out.println(
                    "Result processing completed"
            );
        }
    }
}