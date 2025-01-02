package atm;

import java.util.Scanner;

class ATM {
    private static final int USER_ID = 1234;  // User ID for demo
    private static final int PIN = 4321;      // PIN for demo
    private double balance = 1000.0;          // Default account balance
    
    Scanner scanner = new Scanner(System.in);
    TransactionHistory history = new TransactionHistory(); // To manage transactions
    
    // Authentication Method
    public boolean authenticateUser() {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();

        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();

        if (userId == USER_ID && pin == PIN) {
            System.out.println("Authentication Successful. Access Granted!\n");
            return true;
        } else {
            System.out.println("Invalid User ID or PIN. Try Again!\n");
            return false;
        }
    }

    // Show Menu
    public void showMenu() {
        int choice;
        do {
            System.out.println("\nATM Operations Menu:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    history.showTransactionHistory();
                    break;
                case 2:
                    Withdraw withdraw = new Withdraw(balance, history);
                    balance = withdraw.performWithdrawal();
                    break;
                case 3:
                    Deposit deposit = new Deposit(balance, history);
                    balance = deposit.performDeposit();
                    break;
                case 4:
                    Transfer transfer = new Transfer(balance, history);
                    balance = transfer.performTransfer();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid Option. Please try again.");
            }
        } while (choice != 5);
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        System.out.println("Welcome to the ATM System!");

        if (atm.authenticateUser()) {
            atm.showMenu();
        } else {
            System.out.println("Access Denied. Exiting...");
        }
    }
}
