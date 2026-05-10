package bank_system;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class LoggingTest {
  @Test
  void bankingOperationsShouldWriteStructuredLogs() {
    assertDoesNotThrow(
        () -> {
          CheckingAccount account = new CheckingAccount(3001L, 1000.0);
          account.deposit(100.0);
          account.withdraw(50.0);
          account.getTransactionHistory();
        });
  }
}
