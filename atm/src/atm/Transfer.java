package atm;

import java.util.Scanner;

class Transfer {
    private double balance;
    private TransactionHistory history;
    Scanner scanner = new Scanner(System.in);

    public Transfer(double balance, TransactionHistory history) {
        this.balance = balance;
        this.history = history;
    }

    public double performTransfer() {
        System.out.print("\nEnter recipient's account number: ");
        int accountNumber = scanner.nextInt();

        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            history.addTransaction("Transferred $" + amount + " to Account: " + accountNumber);
            System.out.println("Successfully Transferred $" + amount + " to Account: " + accountNumber);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
        return balance;
    }
}






