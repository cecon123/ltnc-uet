# Bài 1.3: Phân tích Object

a) Lớp BankAccount
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
* Định danh (Identity):
  - Định danh là cách phân biệt đối tượng này với đối tượng khác trong bộ nhớ. Trong đoạn mã này, định danh chính là biến tham chiếu đối tượng được tạo ra trong hàm main: myAccount.

* Trạng thái (State):
  - Trạng thái được thể hiện qua các thuộc tính (dữ liệu/biến) của lớp. Đối với BankAccount, trạng thái bao gồm:
    + accountNumber (Số tài khoản)
    + ownerName (Tên chủ tài khoản)
    + balance (Số dư tài khoản)

* Hành vi (Behavior):
  - Hành vi được thể hiện qua các phương thức (hàm) mà đối tượng có thể thực hiện để thay đổi trạng thái hoặc tương tác. Đối với BankAccount, hành vi bao gồm:
    + openAccount(String accNum, String owner): Mở tài khoản (thiết lập số tài khoản và tên chủ).
    + deposit(double amount): Gửi tiền (tăng số dư).
    + withdraw(double amount): Rút tiền (giảm số dư nếu đủ tiền).

--------------------------------------------------

b) Lớp SmartFan
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

* Định danh (Identity):
  - Trong đoạn mã này, có hai đối tượng SmartFan được khởi tạo trong hàm main, do đó chúng ta có hai định danh: 
    + livingRoomFan (Quạt phòng khách)
    + bedroomFan (Quạt phòng ngủ)

* Trạng thái (State):
  - Trạng thái của mỗi chiếc quạt thông minh được lưu trữ qua các thuộc tính:
    + brand (Thương hiệu, mặc định là "Xiaomi")
    + isPowerOn (Tình trạng bật/tắt nguồn)
    + speedLevel (Mức tốc độ của quạt)

* Hành vi (Behavior):
  - Các hành động mà quạt thông minh có thể thực hiện bao gồm:
    + turnOn(): Bật quạt (đổi trạng thái isPowerOn thành true).
    + turnOff(): Tắt quạt (đổi trạng thái isPowerOn thành false và trả speedLevel về 0).
    + setSpeed(int newSpeed): Chỉnh tốc độ (chỉ thực hiện cập nhật speedLevel nếu quạt đang bật).
