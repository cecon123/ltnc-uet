package bank_system;

import java.util.Locale;

/** Represents a single bank transaction. */
public class Transaction {
  /** Deposit transaction for checking accounts. */
  public static final int TYPE_DEPOSIT_CHECKING = 1;

  /** Withdraw transaction for checking accounts. */
  public static final int TYPE_WITHDRAW_CHECKING = 2;

  /** Deposit transaction for savings accounts. */
  public static final int TYPE_DEPOSIT_SAVINGS = 3;

  /** Withdraw transaction for savings accounts. */
  public static final int TYPE_WITHDRAW_SAVINGS = 4;

  private final int type;
  private final double amount;
  private final double initialBalance;
  private final double finalBalance;

  /** Creates a transaction. */
  public Transaction(int type, double amount, double initialBalance, double finalBalance) {
    this.type = type;
    this.amount = amount;
    this.initialBalance = initialBalance;
    this.finalBalance = finalBalance;
  }

  /** Returns the transaction type. */
  public int getType() {
    return type;
  }

  /** Returns the transaction amount. */
  public double getAmount() {
    return amount;
  }

  /** Returns the balance before the transaction. */
  public double getInitialBalance() {
    return initialBalance;
  }

  /** Returns the balance after the transaction. */
  public double getFinalBalance() {
    return finalBalance;
  }

  /** Returns the Vietnamese description of a transaction type. */
  public static String getTypeString(int type) {
    switch (type) {
      case TYPE_DEPOSIT_CHECKING:
        return "Nạp tiền vãng lai";
      case TYPE_WITHDRAW_CHECKING:
        return "Rút tiền vãng lai";
      case TYPE_DEPOSIT_SAVINGS:
        return "Nạp tiền tiết kiệm";
      case TYPE_WITHDRAW_SAVINGS:
        return "Rút tiền tiết kiệm";
      default:
        return "Không rõ";
    }
  }

  /** Returns a readable summary for this transaction. */
  public String getTransactionSummary() {
    return String.format(
        Locale.US,
        "- Kiểu giao dịch: %s. Số dư ban đầu: $%.2f. Số tiền: $%.2f. Số dư cuối: $%.2f.",
        getTypeString(type),
        initialBalance,
        amount,
        finalBalance);
  }
}
