package bank_system;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BankTest {
  @Test
  void customersShouldBeReturnedByIdOrder() {
    Bank bank = new Bank();
    bank.addCustomer(new Customer(3L, "Tran C"));
    bank.addCustomer(new Customer(1L, "Nguyen A"));

    assertEquals(
        "So CMND: 1. Ho ten: Nguyen A."
            + System.lineSeparator()
            + "So CMND: 3. Ho ten: Tran C.",
        bank.getCustomersInfoByIdOrder());
  }

  @Test
  void customersShouldBeReturnedByNameOrder() {
    Bank bank = new Bank();
    bank.addCustomer(new Customer(3L, "Tran C"));
    bank.addCustomer(new Customer(1L, "Nguyen A"));

    assertEquals(
        "So CMND: 1. Ho ten: Nguyen A."
            + System.lineSeparator()
            + "So CMND: 3. Ho ten: Tran C.",
        bank.getCustomersInfoByNameOrder());
  }
}
