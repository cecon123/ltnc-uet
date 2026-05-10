package bank_system;

import java.util.Locale;

/** Exception thrown when a transaction amount is invalid. */
public class InvalidFundingAmountException extends BankException {
  public InvalidFundingAmountException(double amount) {
    super("So tien khong hop le: $" + String.format(Locale.US, "%.2f", amount));
  }
}
