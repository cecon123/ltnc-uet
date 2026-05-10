package bank_system;

import java.util.ArrayList;
import java.util.List;

/** Represents a bank customer. */
public class Customer {
  private long idNumber;
  private String fullName;
  private List<Account> accountList;

  /** Creates an empty customer. */
  public Customer() {
    this(0L, "");
  }

  /** Creates a customer with identity number and full name. */
  public Customer(long idNumber, String fullName) {
    this.idNumber = idNumber;
    this.fullName = fullName;
    this.accountList = new ArrayList<>();
  }

  /** Returns the identity number. */
  public long getIdNumber() {
    return idNumber;
  }

  /** Updates the identity number. */
  public void setIdNumber(long idNumber) {
    this.idNumber = idNumber;
  }

  /** Returns the full name. */
  public String getFullName() {
    return fullName;
  }

  /** Updates the full name. */
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  /** Returns the account list. */
  public List<Account> getAccountList() {
    return new ArrayList<>(accountList);
  }

  /** Replaces the account list. */
  public void setAccountList(List<Account> accountList) {
    if (accountList == null) {
      this.accountList = new ArrayList<>();
    } else {
      this.accountList = new ArrayList<>(accountList);
    }
  }

  /** Adds an account to the customer. */
  public void addAccount(Account account) {
    if (account != null && !accountList.contains(account)) {
      accountList.add(account);
    }
  }

  /** Removes an account from the customer. */
  public void removeAccount(Account account) {
    if (account != null) {
      accountList.remove(account);
    }
  }

  /** Returns customer information as text. */
  public String getCustomerInfo() {
    return "Số CMND: " + idNumber + ". Họ tên: " + fullName + ".";
  }
}
