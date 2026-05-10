package bank_system;

/** Base exception for the banking system. */
public class BankException extends Exception {
  /** Creates a bank exception with a message. */
  public BankException(String message) {
    super(message);
  }
}
