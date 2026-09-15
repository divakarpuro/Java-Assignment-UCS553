class NestedTryCatch {

    public static void main(String[] args) {

        try {

            System.out.println("Outer try started");

            try {

                System.out.println("Inner try started");

                int result = 10 / 0;

                System.out.println("Result: " + result);
            }

            catch (ArithmeticException e) {

                System.out.println(
                    "Inner catch: Cannot divide by zero"
                );
            }

            System.out.println("Outer try continues");

            int[] numbers = {10, 20, 30};

            System.out.println(numbers[5]);
        }

        catch (ArrayIndexOutOfBoundsException e) {

            System.out.println(
                "Outer catch: Invalid array index"
            );
        }

        System.out.println("Program completed");
    }
}