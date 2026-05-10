package bank_system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CustomerTest {
  @Test
  void addAccountShouldAddNewAccountOnlyOnce() {
    Customer customer = new Customer(123456789L, "Nguyen Van A");
    CheckingAccount account = new CheckingAccount(1001L, 100.0);

    customer.addAccount(account);
    customer.addAccount(account);

    assertEquals(1, customer.getAccountList().size());
    assertTrue(customer.getAccountList().contains(account));
  }

  @Test
  void removeAccountShouldRemoveExistingAccount() {
    Customer customer = new Customer(123456789L, "Nguyen Van A");
    CheckingAccount account = new CheckingAccount(1001L, 100.0);

    customer.addAccount(account);
    customer.removeAccount(account);

    assertTrue(customer.getAccountList().isEmpty());
  }

  @Test
  void getCustomerInfoShouldReturnFormattedText() {
    Customer customer = new Customer(123456789L, "Nguyen Van A");

    assertEquals("So CMND: 123456789. Ho ten: Nguyen Van A.", customer.getCustomerInfo());
  }
}
