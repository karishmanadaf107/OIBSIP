package atm;

import java.util.ArrayList;

class TransactionHistory {
    private ArrayList<String> transactions = new ArrayList<>();

    // Add a transaction
    public void addTransaction(String transaction) {
        transactions.add(transaction);
    }

    // Display transaction history
    public void showTransactionHistory() {
        System.out.println("\nTransaction History:");
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }
}

