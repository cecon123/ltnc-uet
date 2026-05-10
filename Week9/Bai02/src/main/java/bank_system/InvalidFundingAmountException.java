package bank_system;

import java.util.Locale;

/** Exception thrown when a transaction amount is invalid. */
public class InvalidFundingAmountException extends BankException {
  /** Creates an exception for an invalid transaction amount. */
  public InvalidFundingAmountException(double amount) {
    super("Số tiền không hợp lệ: $" + String.format(Locale.US, "%.2f", amount));
  }
}
