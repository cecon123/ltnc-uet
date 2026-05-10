package bank_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Manages customers and their accounts. */
public class Bank {
  private static final Logger LOGGER = LoggerFactory.getLogger(Bank.class);
  private static final Pattern CUSTOMER_ID_PATTERN = Pattern.compile("\\d{9}");
  private static final int ACCOUNT_NUMBER_INDEX = 0;
  private static final int ACCOUNT_TYPE_INDEX = 1;
  private static final int BALANCE_INDEX = 2;
  private static final int MIN_ACCOUNT_PARTS = 3;

  private List<Customer> customerList;

  /** Creates an empty bank. */
  public Bank() {
    this.customerList = new ArrayList<>();
  }

  /** Returns all customers. */
  public List<Customer> getCustomerList() {
    return new ArrayList<>(customerList);
  }

  /** Replaces the customer list. */
  public void setCustomerList(List<Customer> customerList) {
    if (customerList == null) {
      this.customerList = new ArrayList<>();
    } else {
      this.customerList = new ArrayList<>(customerList);
    }
  }

  /** Reads customers and accounts from an input stream. */
  public void readCustomerList(InputStream inputStream) {
    if (inputStream == null) {
      LOGGER.warn("Input stream is null; no customer data was loaded");
      return;
    }

    LOGGER.info("Start reading customer data");
    try (BufferedReader reader =
        new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
      readLines(reader);
    } catch (IOException exception) {
      LOGGER.error("Cannot read customer data", exception);
    }
  }

  /** Returns customer information sorted by identity number. */
  public String getCustomersInfoByIdOrder() {
    List<Customer> sortedCustomers = new ArrayList<>(customerList);
    sortedCustomers.sort(Comparator.comparingLong(Customer::getIdNumber));
    return joinCustomerInfo(sortedCustomers);
  }

  /** Returns customer information sorted by full name and then identity number. */
  public String getCustomersInfoByNameOrder() {
    List<Customer> sortedCustomers = new ArrayList<>(customerList);
    sortedCustomers.sort(
        Comparator.comparing(Customer::getFullName).thenComparingLong(Customer::getIdNumber));
    return joinCustomerInfo(sortedCustomers);
  }

  private void readLines(BufferedReader reader) throws IOException {
    String line;
    Customer currentCustomer = null;

    while ((line = reader.readLine()) != null) {
      String trimmedLine = line.trim();
      if (trimmedLine.isEmpty()) {
        continue;
      }

      Customer newCustomer = parseCustomer(trimmedLine);
      if (newCustomer != null) {
        currentCustomer = newCustomer;
        customerList.add(currentCustomer);
        LOGGER.info("Added customer {}", currentCustomer.getFullName());
        continue;
      }

      if (currentCustomer != null) {
        addAccountToCustomer(currentCustomer, trimmedLine);
      }
    }
  }

  private Customer parseCustomer(String line) {
    int lastSpaceIndex = line.lastIndexOf(' ');
    if (lastSpaceIndex <= 0) {
      return null;
    }

    String idToken = line.substring(lastSpaceIndex + 1).trim();
    if (!CUSTOMER_ID_PATTERN.matcher(idToken).matches()) {
      return null;
    }

    String fullName = line.substring(0, lastSpaceIndex).trim();
    return new Customer(Long.parseLong(idToken), fullName);
  }

  private void addAccountToCustomer(Customer customer, String line) {
    String[] parts = line.split("\\s+");
    if (parts.length < MIN_ACCOUNT_PARTS) {
      LOGGER.warn("Skipped invalid account line: {}", line);
      return;
    }

    try {
      long accountNumber = Long.parseLong(parts[ACCOUNT_NUMBER_INDEX]);
      String accountType = parts[ACCOUNT_TYPE_INDEX];
      double balance = Double.parseDouble(parts[BALANCE_INDEX]);
      Account account = createAccount(accountNumber, accountType, balance);

      if (account != null) {
        customer.addAccount(account);
        LOGGER.info("Added {} account {}", accountType, accountNumber);
      }
    } catch (NumberFormatException exception) {
      LOGGER.warn("Skipped invalid account line: {}", line, exception);
    }
  }

  private Account createAccount(long accountNumber, String accountType, double balance) {
    if (Account.CHECKING_TYPE.equals(accountType)) {
      return new CheckingAccount(accountNumber, balance);
    }
    if (Account.SAVINGS_TYPE.equals(accountType)) {
      return new SavingsAccount(accountNumber, balance);
    }

    LOGGER.warn("Unsupported account type: {}", accountType);
    return null;
  }

  private String joinCustomerInfo(List<Customer> customers) {
    StringBuilder builder = new StringBuilder();
    for (int index = 0; index < customers.size(); index++) {
      builder.append(customers.get(index).getCustomerInfo());
      if (index < customers.size() - 1) {
        builder.append('\n');
      }
    }
    return builder.toString();
  }
}
