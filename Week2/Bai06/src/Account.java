import java.util.Arrays;

public class Account {
    private String accountId;
    private double balance;
    private Transaction[] history;
    private int transactionCount;

    public Account(String accountId) {
        this.accountId = accountId;
        this.balance = 0.0;
        this.history = new Transaction[100]; 
        this.transactionCount = 0;
    }

    public void addTransaction(Transaction t) {
        if (transactionCount < history.length) {
            history[transactionCount] = t;
            balance += t.getAmount();
            transactionCount++;
        }
    }

    public Transaction[] getHistory() {
        return Arrays.copyOf(this.history, this.transactionCount);
    }

    public void printHistory() {
        System.out.println("--- Account: " + accountId + " ---");
        for (int i = 0; i < transactionCount; i++) {
            System.out.println(history[i].getTransactionId() + " | Amount: " + history[i].getAmount());
        }
    }
    public static void main(String[] args) {
        Account myAccount = new Account("ACC_001");
        myAccount.addTransaction(new Transaction("TXN_1", 5000.0, "2023-10-26"));
        myAccount.addTransaction(new Transaction("TXN_2", 2000.0, "2023-10-27"));

        System.out.println("BEFORE HACKER ATTACK:");
        myAccount.printHistory();

        Transaction[] hackedHistory = myAccount.getHistory();

        System.out.println("\n[!] The hacker is trying to assign hackedHistory[0] = null...");
        if (hackedHistory.length > 0) {
            hackedHistory[0] = null; 
        }

        System.out.println("\nAFTER HACKER ATTACK:");
        myAccount.printHistory();
    }
}