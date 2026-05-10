package bank_system;

import java.util.Locale;

/** Represents a bank transaction. */
public class Transaction {
  public static final int TYPE_DEPOSIT_CHECKING = 1;
  public static final int TYPE_WITHDRAW_CHECKING = 2;
  public static final int TYPE_DEPOSIT_SAVINGS = 3;
  public static final int TYPE_WITHDRAW_SAVINGS = 4;

  private final int type;
  private final double amount;
  private final double initialBalance;
  private final double finalBalance;

  public Transaction(int type, double amount, double initialBalance, double finalBalance) {
    this.type = type;
    this.amount = amount;
    this.initialBalance = initialBalance;
    this.finalBalance = finalBalance;
  }

  public int getType() {
    return type;
  }

  public double getAmount() {
    return amount;
  }

  public double getInitialBalance() {
    return initialBalance;
  }

  public double getFinalBalance() {
    return finalBalance;
  }

  public static String getTypeString(int type) {
    return switch (type) {
      case TYPE_DEPOSIT_CHECKING -> "Nap tien vang lai";
      case TYPE_WITHDRAW_CHECKING -> "Rut tien vang lai";
      case TYPE_DEPOSIT_SAVINGS -> "Nap tien tiet kiem";
      case TYPE_WITHDRAW_SAVINGS -> "Rut tien tiet kiem";
      default -> "Khong ro";
    };
  }

  public String getTransactionSummary() {
    return "- Kieu giao dich: "
        + getTypeString(type)
        + ". So du ban dau: $"
        + String.format(Locale.US, "%.2f", initialBalance)
        + ". So tien: $"
        + String.format(Locale.US, "%.2f", amount)
        + ". So du cuoi: $"
        + String.format(Locale.US, "%.2f", finalBalance)
        + ".";
  }
}
