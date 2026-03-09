public class BankAccount {
    private final String accountNumber;
    private double balance;
    private final String ownerName;

    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0;
    }

    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if (balance < 0) {
            System.out.println("Error: Initial balance cannot be negative. Defaulting to 0.");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposit successful: +" + amount);
        } else {
            System.out.println("Error: Deposit amount must be greater than 0.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Withdrawal successful: -" + amount);
            return true;
        } else {
            System.out.println("Error: Invalid amount or insufficient funds.");
            return false;
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        BankAccount myAcc = new BankAccount("VCB123", "Nguyen Van A");
        System.out.println("\n--- Step 1: Negative Deposit ---");
        myAcc.deposit(-100);
        System.out.println("\n--- Step 2: Valid Deposit ---");
        myAcc.deposit(1000);
        System.out.println("Current balance: " + myAcc.getBalance());
        System.out.println("\n--- Step 3: Overdraft Attempt (Withdraw more than balance) ---");
        boolean check1 = myAcc.withdraw(2000);
        System.out.println("Withdrawal status: " + (check1 ? "Success" : "Failed"));
        System.out.println("\n--- Step 4: Valid Withdrawal ---");
        boolean check2 = myAcc.withdraw(500);
        System.out.println("Withdrawal status: " + (check2 ? "Success" : "Failed"));
        System.out.println("Final balance: " + myAcc.getBalance());
    }
}