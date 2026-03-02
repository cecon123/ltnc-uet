# Bài 1.3: Phân tích Object

## a) BankAccount
```java
public class BankAccount {
  private String accountNumber;
  private String ownerName;
  private double balance = 0.0;
  public void openAccount(String accNum, String owner) {
    this.accountNumber = accNum;
    this.ownerName = owner;
  }
  public void deposit(double amount) {
    this.balance += amount;
  }
  public boolean withdraw(double amount) {
    if (this.balance >= amount) {
      this.balance -= amount;
      return true;
    }
    return false;
  }
  public static void main(String[] args) {
    BankAccount myAccount = new BankAccount();
    myAccount.openAccount("101202303", "Nguyen Van A");
    myAccount.deposit(500.0);
    myAccount.withdraw(150.0);
  }
}
```
### 1. Trạng thái (State)
Là các biến instance (thuộc tính của đối tượng):
- accountNumber
- ownerName
- balance

→ Đại diện cho thông tin và dữ liệu của một tài khoản ngân hàng.

---

### 2. Hành vi (Behavior)
Là các phương thức:
- openAccount()
- deposit()
- withdraw()

→ Mô tả những hành động mà tài khoản có thể thực hiện (mở tài khoản, nạp tiền, rút tiền).

---

### 3. Định danh (Identity)
Là mỗi đối tượng được tạo bằng từ khóa `new`.

Ví dụ:
BankAccount myAccount = new BankAccount();

→ `myAccount` là một đối tượng cụ thể trong bộ nhớ.
Hai đối tượng khác nhau được tạo bằng `new` sẽ có định danh khác nhau dù cùng một lớp.

---

## b) SmartFan

```java
public class SmartFan {
  private String brand = "Xiaomi";
  private boolean isPowerOn = false;
  private int speedLevel = 0; // Mức từ 1 đến 3
  public void turnOn() {
    this.isPowerOn = true;
  }
  public void turnOff() {
    this.isPowerOn = false;
    this.speedLevel = 0;
  }
  public void setSpeed(int newSpeed) {
    // Chỉ đổi tốc độ nếu quạt đang bật
    if (this.isPowerOn == true) {
      this.speedLevel = newSpeed;
    }
  }
  public static void main(String[] args) {
    SmartFan livingRoomFan = new SmartFan();
    livingRoomFan.turnOn();
    livingRoomFan.setSpeed(2);
    SmartFan bedroomFan = new SmartFan();
    bedroomFan.setSpeed(3);
    bedroomFan.turnOn();
  }
}
```

### 1. Trạng thái (State)
Các biến instance:
- brand
- isPowerOn
- speedLevel

→ Thể hiện tình trạng hiện tại của quạt (hãng, bật/tắt, tốc độ).

---

### 2. Hành vi (Behavior)
Các phương thức:
- turnOn()
- turnOff()
- setSpeed()

→ Thể hiện những hành động quạt có thể thực hiện.

---

### 3. Định danh (Identity)
Ví dụ:
SmartFan livingRoomFan = new SmartFan();
SmartFan bedroomFan = new SmartFan();

→ Đây là hai đối tượng khác nhau.
Mỗi đối tượng có trạng thái riêng biệt dù cùng thuộc một lớp.

---

# Bài 1.4: Fibonacci

## Giải thích

Dãy Fibonacci:
F(0) = 0  
F(1) = 1  
F(n) = F(n-1) + F(n-2)

Ví dụ:
0 1 1 2 3 5 8 13 21 34 55

---

## 1. Cách dùng vòng lặp

- Sử dụng hai biến để lưu hai số trước đó.
- Mỗi vòng lặp tính số tiếp theo bằng cách cộng hai số trước.
- Độ phức tạp: O(n)
- Đây là cách tối ưu và nên sử dụng.

---

## 2. Cách dùng đệ quy

- Gọi lại chính nó theo công thức:
  F(n) = F(n-1) + F(n-2)
- Dễ hiểu về mặt toán học.
- Nhưng chậm vì lặp lại nhiều phép tính.
- Độ phức tạp: O(2^n)

---

## So sánh

Vòng lặp:
- Nhanh
- Hiệu quả
- Thực tế nên dùng

Đệ quy:
- Dễ hiểu
- Phù hợp minh họa công thức
- Không tối ưu nếu n lớn