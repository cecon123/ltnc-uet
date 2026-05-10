package bank_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Base class for bank accounts. */
public abstract class Account {
  public static final String CHECKING_TYPE = "CHECKING";
  public static final String SAVINGS_TYPE = "SAVINGS";

  private long accountNumber;
  private double balance;
  private List<Transaction> transactions;

  protected Account(long accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.transactions = new ArrayList<>();
  }

  public long getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(long accountNumber) {
    this.accountNumber = accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  protected void setBalance(double balance) {
    this.balance = balance;
  }

  public List<Transaction> getTransactionList() {
    return transactions;
  }

  public void setTransactionList(List<Transaction> transactions) {
    this.transactions = transactions == null ? new ArrayList<>() : transactions;
  }

  public abstract void deposit(double amount) throws BankException;

  public abstract void withdraw(double amount) throws BankException;

  protected void doDepositing(double amount) throws InvalidFundingAmountException {
    if (amount <= 0) {
      throw new InvalidFundingAmountException(amount);
    }
    balance += amount;
  }

  protected void doWithdrawing(double amount) throws BankException {
    if (amount <= 0) {
      throw new InvalidFundingAmountException(amount);
    }
    if (amount > balance) {
      throw new InsufficientFundsException(amount);
    }
    balance -= amount;
  }

  protected void addTransaction(Transaction transaction) {
    if (transaction != null) {
      transactions.add(transaction);
    }
  }

  public String getTransactionHistory() {
    StringBuilder builder = new StringBuilder();
    builder.append("Lich su giao dich cua tai khoan ").append(accountNumber).append(":");
    for (Transaction transaction : transactions) {
      builder.append(System.lineSeparator()).append(transaction.getTransactionSummary());
    }
    return builder.toString();
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof Account account)) {
      return false;
    }
    return accountNumber == account.accountNumber;
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNumber);
  }
}
