package bank_system;

/** Entry point used to run the bank system from an executable jar. */
public final class Main {

  public static void main(String[] args) throws BankException {
    Bank bank = new Bank();
    Customer customer = new Customer(123456789L, "Nguyen Van A");
    CheckingAccount checkingAccount = new CheckingAccount(1001L, 1000.0);
    SavingsAccount savingsAccount = new SavingsAccount(2001L, 10000.0);

    customer.addAccount(checkingAccount);
    customer.addAccount(savingsAccount);
    bank.addCustomer(customer);

    checkingAccount.deposit(500.0);
    checkingAccount.withdraw(200.0);
    savingsAccount.deposit(1000.0);
    savingsAccount.withdraw(500.0);

    System.out.println("=== BANK SYSTEM DEMO ===");
    System.out.println(bank.getCustomersInfoByIdOrder());
    System.out.println();
    System.out.println(checkingAccount.getTransactionHistory());
    System.out.println();
    System.out.println(savingsAccount.getTransactionHistory());
  }
}
