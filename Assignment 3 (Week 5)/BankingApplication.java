import java.util.Scanner;

class InsufficientBalanceException extends Exception {

    InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {

    InvalidAmountException(String message) {
        super(message);
    }
}

class AccountNotFoundException extends Exception {

    AccountNotFoundException(String message) {
        super(message);
    }
}

public class BankingApplication {

    private double balance;
    private final String accountNumber;

    BankingApplication(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount)
            throws InvalidAmountException {

        if (amount <= 0) {

            throw new InvalidAmountException(
                    "Deposit amount must be greater than zero"
            );
        }

        balance = balance + amount;

        System.out.println(
                "Amount deposited successfully: " + amount
        );
    }

    public void withdraw(double amount)
            throws InvalidAmountException,
                   InsufficientBalanceException {

        if (amount <= 0) {

            throw new InvalidAmountException(
                    "Withdrawal amount must be greater than zero"
            );
        }

        if (amount > balance) {

            throw new InsufficientBalanceException(
                    "Insufficient balance"
            );
        }

        balance = balance - amount;

        System.out.println(
                "Amount withdrawn successfully: " + amount
        );
    }

    public void displayBalance() {

        System.out.println(
                "Current balance: " + balance
        );
    }

    public static void findAccount(String enteredAccount,
                                   BankingApplication account)
            throws AccountNotFoundException {

        if (!enteredAccount.equals(account.accountNumber)) {

            throw new AccountNotFoundException(
                    "Account not found"
            );
        }

        System.out.println("Account found successfully");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankingApplication account =
                new BankingApplication("ACC101", 5000);

        try {

            System.out.print("Enter account number: ");
            String enteredAccount = sc.nextLine();

            findAccount(enteredAccount, account);

            System.out.print("Enter deposit amount: ");
            double depositAmount =
                    Double.parseDouble(sc.nextLine());

            account.deposit(depositAmount);

            account.displayBalance();

            System.out.print("Enter withdrawal amount: ");
            double withdrawalAmount =
                    Double.parseDouble(sc.nextLine());

            account.withdraw(withdrawalAmount);

            account.displayBalance();
        }

        catch (NumberFormatException e) {

            System.out.println(
                    "Error: Please enter a valid numeric amount"
            );
        }

        catch (AccountNotFoundException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }

        catch (InvalidAmountException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }

        catch (InsufficientBalanceException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }

        finally {

            sc.close();

            System.out.println(
                    "Banking application completed"
            );
        }
    }
}