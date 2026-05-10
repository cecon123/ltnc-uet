package bank_system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Entry point for the bank system demo. */
public final class Main {
  private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

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

    LOGGER.info("Bank system demo completed");
    LOGGER.info("Customers by id:{}{}", System.lineSeparator(), bank.getCustomersInfoByIdOrder());
    LOGGER.info(
        "Checking account history:{}{}",
        System.lineSeparator(),
        checkingAccount.getTransactionHistory());
    LOGGER.info(
        "Savings account history:{}{}",
        System.lineSeparator(),
        savingsAccount.getTransactionHistory());
  }
}
