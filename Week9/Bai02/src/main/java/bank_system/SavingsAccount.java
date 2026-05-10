package bank_system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Represents a savings account with withdrawal constraints. */
public class SavingsAccount extends Account {
  private static final double MAX_WITHDRAW_AMOUNT = 1000.0;
  private static final double MIN_REMAINING_BALANCE = 5000.0;
  private static final Logger LOGGER = LoggerFactory.getLogger(SavingsAccount.class);

  /** Creates a savings account. */
  public SavingsAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public void deposit(double amount) {
    double initialBalance = getBalance();
    try {
      doDepositing(amount);
      addTransaction(
          new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS, amount, initialBalance, getBalance()));
      LOGGER.info("Deposited {} into savings account {}", amount, getAccountNumber());
    } catch (BankException exception) {
      LOGGER.warn("Cannot deposit into savings account {}", getAccountNumber(), exception);
    }
  }

  @Override
  public void withdraw(double amount) {
    double initialBalance = getBalance();
    try {
      validateSavingsWithdrawal(amount);
      doWithdrawing(amount);
      addTransaction(
          new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS, amount, initialBalance, getBalance()));
      LOGGER.info("Withdrew {} from savings account {}", amount, getAccountNumber());
    } catch (BankException exception) {
      LOGGER.warn("Cannot withdraw from savings account {}", getAccountNumber(), exception);
    }
  }

  private void validateSavingsWithdrawal(double amount) throws BankException {
    if (amount > MAX_WITHDRAW_AMOUNT) {
      throw new InvalidFundingAmountException(amount);
    }
    if (getBalance() - amount < MIN_REMAINING_BALANCE) {
      throw new InsufficientFundsException(amount);
    }
  }
}
