package bank_system;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/** Manages customers in the bank system. */
public class Bank {
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
