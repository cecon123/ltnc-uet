package bank_system;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Manages customers in the bank system. */
public class Bank {
  private static final Logger LOGGER = LoggerFactory.getLogger(Bank.class);

  private List<Customer> customers;

  public Bank() {
    customers = new ArrayList<>();
  }

  public List<Customer> getCustomerList() {
    return customers;
  }

  public void setCustomerList(List<Customer> customers) {
    this.customers = customers == null ? new ArrayList<>() : customers;
  }

  public void addCustomer(Customer customer) {
    if (customer != null) {
      customers.add(customer);
      LOGGER.info("Customer {} was added", customer.getIdNumber());
    } else {
      LOGGER.warn("Ignored null customer");
    }
  }

  public String getCustomersInfoByIdOrder() {
    return customers.stream()
        .sorted(Comparator.comparingLong(Customer::getIdNumber))
        .map(Customer::getCustomerInfo)
        .collect(Collectors.joining(System.lineSeparator()));
  }

  public String getCustomersInfoByNameOrder() {
    return customers.stream()
        .sorted(
            Comparator.comparing(Customer::getFullName)
                .thenComparingLong(Customer::getIdNumber))
        .map(Customer::getCustomerInfo)
        .collect(Collectors.joining(System.lineSeparator()));
  }
}
