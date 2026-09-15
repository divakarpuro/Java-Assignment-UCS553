// package Exception Week 5;


public class ExceptionHierarchyDemo {

    public static void main(String[] args) {

        try {
            int result = 70 / 0;
        }
        catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        }

        try {
            String str = null;
            System.out.println(str.length());
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }

     
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        }


        try {
            String str = "Divakar";
            int number = Integer.parseInt(str);
        }
        catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
        }

    }
}

