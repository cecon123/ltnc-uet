package bank_system;

import java.util.Locale;

/** Exception thrown when an account does not have enough balance. */
public class InsufficientFundsException extends BankException {
  public InsufficientFundsException(double amount) {
    super("So du tai khoan khong du $" + String.format(Locale.US, "%.2f", amount));
  }
}
