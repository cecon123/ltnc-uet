package bank_system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Checking account implementation. */
public class CheckingAccount extends Account {
  private static final Logger LOGGER = LoggerFactory.getLogger(CheckingAccount.class);

  public CheckingAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public void deposit(double amount) throws BankException {
    double initialBalance = getBalance();
    doDepositing(amount);
    addTransaction(
        new Transaction(
            Transaction.TYPE_DEPOSIT_CHECKING, amount, initialBalance, getBalance()));
    LOGGER.info("Deposit completed for checking account {}", getAccountNumber());
  }

  @Override
  public void withdraw(double amount) throws BankException {
    double initialBalance = getBalance();
    doWithdrawing(amount);
    addTransaction(
        new Transaction(
            Transaction.TYPE_WITHDRAW_CHECKING, amount, initialBalance, getBalance()));
    LOGGER.info("Withdraw completed for checking account {}", getAccountNumber());
  }
}
