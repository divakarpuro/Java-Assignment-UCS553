import java.util.Scanner;

class InvalidOperatorException extends Exception {

    InvalidOperatorException(String message) {
        super(message);
    }
}

public class CalculatorExceptionDemo {

    static double calculate(double a, double b, String operator)
            throws InvalidOperatorException {

        switch (operator) {

            case "+":
                return a + b;

            case "-":
                return a - b;

            case "*":
                return a * b;

            case "/":

                if (b == 0) {
                    throw new ArithmeticException(
                            "Cannot divide by zero"
                    );
                }

                return a / b;

            default:
                throw new InvalidOperatorException(
                        "Invalid operator entered"
                );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter first number: ");
            double a = Double.parseDouble(sc.nextLine());

            System.out.print("Enter second number: ");
            double b = Double.parseDouble(sc.nextLine());

            System.out.print("Enter operator (+, -, *, /): ");
            String operator = sc.nextLine();

            double result = calculate(a, b, operator);

            System.out.println("Result: " + result);
        }

        catch (NumberFormatException e) {

            System.out.println(
                    "Error: Please enter valid numbers"
            );
        }

        catch (ArithmeticException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }

        catch (InvalidOperatorException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }

        finally {

            sc.close();

            System.out.println(
                    "Calculator program completed"
            );
        }
    }
}