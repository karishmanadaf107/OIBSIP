package atm;

import java.util.Scanner;

class Withdraw {
    private double balance;
    private TransactionHistory history;
    Scanner scanner = new Scanner(System.in);

    public Withdraw(double balance, TransactionHistory history) {
        this.balance = balance;
        this.history = history;
    }

    public double performWithdrawal() {
        System.out.print("\nEnter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            history.addTransaction("Withdrawn: $" + amount);
            System.out.println("Successfully Withdrawn $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
        return balance;
    }
}


