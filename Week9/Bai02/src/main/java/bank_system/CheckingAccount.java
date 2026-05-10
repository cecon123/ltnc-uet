package bank_system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Represents a checking account. */
public class CheckingAccount extends Account {
  private static final Logger LOGGER = LoggerFactory.getLogger(CheckingAccount.class);

  /** Creates a checking account. */
  public CheckingAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public void deposit(double amount) {
    double initialBalance = getBalance();
    try {
      doDepositing(amount);
      addTransaction(
          new Transaction(
              Transaction.TYPE_DEPOSIT_CHECKING, amount, initialBalance, getBalance()));
      LOGGER.info("Deposited {} into checking account {}", amount, getAccountNumber());
    } catch (BankException exception) {
      LOGGER.warn("Cannot deposit into checking account {}", getAccountNumber(), exception);
    }
  }

  @Override
  public void withdraw(double amount) {
    double initialBalance = getBalance();
    try {
      doWithdrawing(amount);
      addTransaction(
          new Transaction(
              Transaction.TYPE_WITHDRAW_CHECKING, amount, initialBalance, getBalance()));
      LOGGER.info("Withdrew {} from checking account {}", amount, getAccountNumber());
    } catch (BankException exception) {
      LOGGER.warn("Cannot withdraw from checking account {}", getAccountNumber(), exception);
    }
  }
}
