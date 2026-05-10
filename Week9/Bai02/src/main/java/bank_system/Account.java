package bank_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Represents a common bank account. */
public abstract class Account {
  /** Checking account type. */
  public static final String CHECKING_TYPE = "CHECKING";

  /** Savings account type. */
  public static final String SAVINGS_TYPE = "SAVINGS";

  private static final Logger LOGGER = LoggerFactory.getLogger(Account.class);

  private long accountNumber;
  private double balance;
  private List<Transaction> transactionList;

  /** Creates an account with account number and opening balance. */
  protected Account(long accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.transactionList = new ArrayList<>();
  }

  /** Returns the account number. */
  public long getAccountNumber() {
    return accountNumber;
  }

  /** Updates the account number. */
  public void setAccountNumber(long accountNumber) {
    this.accountNumber = accountNumber;
  }

  /** Returns the current balance. */
  public double getBalance() {
    return balance;
  }

  /** Updates the current balance. */
  protected void setBalance(double balance) {
    this.balance = balance;
  }

  /** Returns transactions of this account. */
  public List<Transaction> getTransactionList() {
    return new ArrayList<>(transactionList);
  }

  /** Replaces the transaction list. */
  public void setTransactionList(List<Transaction> transactionList) {
    if (transactionList == null) {
      this.transactionList = new ArrayList<>();
    } else {
      this.transactionList = new ArrayList<>(transactionList);
    }
  }

  /** Deposits money into the account. */
  public abstract void deposit(double amount);

  /** Withdraws money from the account. */
  public abstract void withdraw(double amount);

  /** Performs the common deposit validation and balance update. */
  protected void doDepositing(double amount) throws InvalidFundingAmountException {
    if (amount <= 0) {
      throw new InvalidFundingAmountException(amount);
    }
    balance += amount;
  }

  /** Performs the common withdraw validation and balance update. */
  protected void doWithdrawing(double amount) throws BankException {
    if (amount <= 0) {
      throw new InvalidFundingAmountException(amount);
    }
    if (amount > balance) {
      throw new InsufficientFundsException(amount);
    }
    balance -= amount;
  }

  /** Adds a transaction to this account. */
  public void addTransaction(Transaction transaction) {
    if (transaction != null) {
      transactionList.add(transaction);
    }
  }

  /** Returns a formatted transaction history. */
  public String getTransactionHistory() {
    StringBuilder builder = new StringBuilder();
    builder.append("Lịch sử giao dịch của tài khoản ").append(accountNumber).append(":\n");

    for (int index = 0; index < transactionList.size(); index++) {
      builder.append(transactionList.get(index).getTransactionSummary());
      if (index < transactionList.size() - 1) {
        builder.append('\n');
      }
    }

    LOGGER.debug("Loaded transaction history for account {}", accountNumber);
    return builder.toString();
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof Account)) {
      return false;
    }
    Account other = (Account) object;
    return accountNumber == other.accountNumber;
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNumber);
  }
}
