package library.util;

public class InputValidator {

    public static boolean isValidResourceId(int resourceId) {
        return resourceId > 0;
    }

    public static boolean isValidFineDays(int days) {
        return days >= 0;
    }
}