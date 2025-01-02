package atm;
import java.util.Scanner;

class Deposit {
    private double balance;
    private TransactionHistory history;
    Scanner scanner = new Scanner(System.in);

    public Deposit(double balance, TransactionHistory history) {
        this.balance = balance;
        this.history = history;
    }

    public double performDeposit() {
        System.out.print("\nEnter amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            history.addTransaction("Deposited: $" + amount);
            System.out.println("Successfully Deposited $" + amount);
        } else {
            System.out.println("Invalid amount.");
        }
        return balance;
    }
}
