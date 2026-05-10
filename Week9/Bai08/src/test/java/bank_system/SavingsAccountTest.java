package bank_system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class SavingsAccountTest {
  @Test
  void depositShouldIncreaseBalance() throws BankException {
    SavingsAccount account = new SavingsAccount(2001L, 6000.0);

    account.deposit(500.0);

    assertEquals(6500.0, account.getBalance());
  }

  @Test
  void withdrawShouldDecreaseBalanceWhenRulesAreValid() throws BankException {
    SavingsAccount account = new SavingsAccount(2001L, 7000.0);

    account.withdraw(1000.0);

    assertEquals(6000.0, account.getBalance());
  }

  @Test
  void withdrawShouldFailWhenMinimumBalanceWouldBeBroken() {
    SavingsAccount account = new SavingsAccount(2001L, 5500.0);

    assertThrows(InsufficientFundsException.class, () -> account.withdraw(800.0));
  }

  @Test
  void withdrawShouldFailWhenAmountIsGreaterThanLimit() {
    SavingsAccount account = new SavingsAccount(2001L, 10000.0);

    assertThrows(InsufficientFundsException.class, () -> account.withdraw(1500.0));
  }
}
