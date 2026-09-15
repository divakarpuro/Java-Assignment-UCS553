import java.util.Scanner;

class InvalidUsernameException extends Exception {

    InvalidUsernameException(String message) {
        super(message);
    }
}

class InvalidPasswordException extends Exception {

    InvalidPasswordException(String message) {
        super(message);
    }
}

class AccountLockedException extends Exception {

    AccountLockedException(String message) {
        super(message);
    }
}

public class LoginSystem {

    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "java123";

    private static final int MAX_ATTEMPTS = 3;

    public static void login(String username, String password,
                             int failedAttempts)
            throws InvalidUsernameException,
                   InvalidPasswordException,
                   AccountLockedException {

        if (failedAttempts >= MAX_ATTEMPTS) {

            throw new AccountLockedException(
                    "Account is locked due to too many failed attempts"
            );
        }

        if (!username.equals(CORRECT_USERNAME)) {

            throw new InvalidUsernameException(
                    "Invalid username"
            );
        }

        if (!password.equals(CORRECT_PASSWORD)) {

            throw new InvalidPasswordException(
                    "Invalid password"
            );
        }

        System.out.println("Login successful");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int failedAttempts = 0;
        boolean loginSuccessful = false;

        try {

            while (failedAttempts < MAX_ATTEMPTS) {

                System.out.print("Enter username: ");
                String username = sc.nextLine();

                System.out.print("Enter password: ");
                String password = sc.nextLine();

                try {

                    login(username, password, failedAttempts);

                    loginSuccessful = true;
                    break;
                }

                catch (InvalidUsernameException e) {

                    failedAttempts++;

                    System.out.println(
                            "Error: " + e.getMessage()
                    );
                }

                catch (InvalidPasswordException e) {

                    failedAttempts++;

                    System.out.println(
                            "Error: " + e.getMessage()
                    );
                }
            }

            if (!loginSuccessful) {

                throw new AccountLockedException(
                        "Account locked after 3 failed attempts"
                );
            }
        }

        catch (AccountLockedException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }

        finally {

            sc.close();

            System.out.println(
                    "Login process completed"
            );
        }
    }
}