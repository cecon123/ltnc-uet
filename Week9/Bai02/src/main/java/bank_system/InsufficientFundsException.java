package bank_system;

import java.util.Locale;

/** Exception thrown when an account does not have enough balance. */
public class InsufficientFundsException extends BankException {
  /** Creates an exception for an amount that cannot be withdrawn. */
  public InsufficientFundsException(double amount) {
    super(
        "Số dư tài khoản không đủ $"
            + String.format(Locale.US, "%.2f", amount)
            + " để thực hiện giao dịch");
  }
}
