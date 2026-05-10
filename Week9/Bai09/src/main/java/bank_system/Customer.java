package bank_system;

import java.util.ArrayList;
import java.util.List;

/** Represents a bank customer. */
public class Customer {
  private long idNumber;
  private String fullName;
  private List<Account> accountList;

  public Customer() {
    this(0L, "");
  }

  public Customer(long idNumber, String fullName) {
    this.idNumber = idNumber;
    this.fullName = fullName;
    this.accountList = new ArrayList<>();
  }

  public long getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(long idNumber) {
    this.idNumber = idNumber;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public List<Account> getAccountList() {
    return accountList;
  }

  public void setAccountList(List<Account> accountList) {
    this.accountList = accountList == null ? new ArrayList<>() : accountList;
  }

  public void addAccount(Account account) {
    if (account != null && !accountList.contains(account)) {
      accountList.add(account);
    }
  }

  public void removeAccount(Account account) {
    accountList.remove(account);
  }

  public String getCustomerInfo() {
    return "So CMND: " + idNumber + ". Ho ten: " + fullName + ".";
  }
}
