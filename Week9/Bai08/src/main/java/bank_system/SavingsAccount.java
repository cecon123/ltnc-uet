package bank_system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Savings account implementation with withdrawal limits. */
public class SavingsAccount extends Account {
  private static final Logger LOGGER = LoggerFactory.getLogger(SavingsAccount.class);
  private static final double MAX_WITHDRAW_AMOUNT = 1000.0;
  private static final double MIN_BALANCE = 5000.0;

  public SavingsAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public void deposit(double amount) throws BankException {
    double initialBalance = getBalance();
    doDepositing(amount);
    addTransaction(
        new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS, amount, initialBalance, getBalance()));
    LOGGER.info("Deposit completed for savings account {}", getAccountNumber());
  }

  @Override
  public void withdraw(double amount) throws BankException {
    if (amount > MAX_WITHDRAW_AMOUNT || getBalance() - amount < MIN_BALANCE) {
      LOGGER.warn("Rejected savings withdrawal for account {}", getAccountNumber());
      throw new InsufficientFundsException(amount);
    }
    double initialBalance = getBalance();
    doWithdrawing(amount);
    addTransaction(
        new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS, amount, initialBalance, getBalance()));
    LOGGER.info("Withdraw completed for savings account {}", getAccountNumber());
  }
}
