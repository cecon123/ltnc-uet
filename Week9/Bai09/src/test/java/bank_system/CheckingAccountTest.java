package bank_system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CheckingAccountTest {
  @Test
  void depositShouldIncreaseBalance() throws BankException {
    CheckingAccount account = new CheckingAccount(1001L, 100.0);

    account.deposit(50.0);

    assertEquals(150.0, account.getBalance());
    assertEquals(1, account.getTransactionList().size());
  }

  @Test
  void withdrawShouldDecreaseBalance() throws BankException {
    CheckingAccount account = new CheckingAccount(1001L, 100.0);

    account.withdraw(40.0);

    assertEquals(60.0, account.getBalance());
    assertEquals(1, account.getTransactionList().size());
  }

  @Test
  void withdrawShouldFailWhenBalanceIsNotEnough() {
    CheckingAccount account = new CheckingAccount(1001L, 100.0);

    assertThrows(InsufficientFundsException.class, () -> account.withdraw(200.0));
  }

  @Test
  void depositShouldFailWhenAmountIsInvalid() {
    CheckingAccount account = new CheckingAccount(1001L, 100.0);

    assertThrows(InvalidFundingAmountException.class, () -> account.deposit(0.0));
  }
}
