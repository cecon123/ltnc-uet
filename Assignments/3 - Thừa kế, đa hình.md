# Bài tập về thừa kế, đa hình

**Yêu cầu:** Code chạy đúng là chưa đủ. Sinh viên phải giải thích được TẠI SAO nó chạy như vậy khi được hỏi vấn đáp

---

# Bài 1: The constructor chain

## Mô tả chi tiết:

### 1. Thiết kế Class:

- Tạo lớp **Person**:
  - Thuộc tính: `String name`, `String dob`.
  - Constructor mặc định (không tham số): In ra màn hình dòng chữ **“1. Person is created”**.

- Tạo lớp **Employee** kế thừa **Person**:
  - Thuộc tính: `double salary`.
  - Constructor mặc định: In ra màn hình dòng chữ **“2. Employee is created”**.

- Tạo lớp **Manager** kế thừa **Employee**:
  - Thuộc tính: `String department`.
  - Constructor mặc định: In ra màn hình dòng chữ **“3. Manager is created”**.

### 2. Hàm main:

- Trong hàm main, viết đúng một dòng lệnh:

```java
Manager m = new Manager();
```

- Chạy chương trình và ghi lại kết quả in ra màn hình.

### 3. Nâng cao (Bắt buộc):

- Sửa lớp **Person**: Xóa constructor mặc định đi, thay bằng constructor có tham số:

```java
public Person(String name) { ... }
```

- Quan sát: Lúc này lớp **Employee** và **Manager** có báo lỗi không? Tại sao?
- Sửa lỗi: Hãy dùng từ khóa **super(...)** để sửa lỗi biên dịch cho lớp con.

### 4. Ví dụ:

**Input:** (No input)

**Output:**

```
1. Person is created
2. Employee is created
3. Manager is created
```

---

# Bài 2: The polymorphic zoo

## Mô tả chi tiết:

### 1. Thiết kế Class:

- Tạo lớp **Animal**:
  - Phương thức:

```java
public void makeSound()
```

→ In ra `"Animal sound"`.

- Tạo lớp **Dog** kế thừa **Animal**:
  - Ghi đè (Override) hàm `makeSound()` → In ra `"Woof woof"`.

- Tạo lớp **Cat** kế thừa **Animal**:
  - Ghi đè hàm `makeSound()` → In ra `"Meows meows"`.

- Tạo lớp **Duck** kế thừa **Animal**:
  - **KHÔNG** ghi đè hàm `makeSound()`.

### 2. Thực hành (Trong hàm Main):

- Tạo một mảng động vật:

```java
Animal[] zoo = new Animal[4];
```

- Gán các phần tử ngẫu nhiên:

```java
zoo[0] = new Dog();
zoo[1] = new Cat();
zoo[2] = new Duck();
zoo[3] = new Dog();
```

- Dùng vòng lặp `for` (hoặc `foreach`) duyệt qua mảng `zoo`. Với mỗi phần tử, gọi lệnh:

```java
zoo[i].makeSound();
```

### 3. Yêu cầu quan sát:

- Quan sát xem con **Vịt (Duck)** kêu như thế nào? Tại sao nó lại kêu như vậy?

### 4. Ví dụ:

**Input:** (No input)

**Output:**

```
Woof woof
Meows meows
Animal Sound
Woof woof
```

---

# Bài 3: The math challenge (Overloading vs Overriding)

## Mô tả chi tiết:

### 1. Thiết kế Class:

- Tạo lớp **MathUtils**:
  - Hàm:

```java
public int sum(int a, int b)
```

Trả về `a + b`.

- Tạo lớp **AdvancedMath** kế thừa **MathUtils**:

  - **Override:** Viết lại hàm:

```java
sum(int a, int b)
```

Trả về `a + b + 10` (Ví dụ logic khác biệt).

  - **Overload:** Viết thêm hàm:

```java
sum(double a, double b)
```

Trả về `a + b`.

### 2. Thực hành:

Trong hàm `main`:

```java
MathUtils m = new AdvancedMath();
System.out.println(m.sum(5, 5)); // (A)
// System.out.println(m.sum(5.5, 5.5)); // (B) -> Dòng này có lỗi không?
```

- Quan sát kết quả dòng **(A)**. Nó ra **10** hay **20**? Tại sao?
- Bỏ comment dòng **(B)**. Trình biên dịch có báo lỗi không? Tại sao đối tượng là `AdvancedMath` (có hàm `sum double`) mà biến `m` lại không gọi được?

### 3. Ví dụ:

**Input:** (No input)

**Output:**

```
20
```

---

# Bài 4: Bẫy ép kiểu

**Mục tiêu:** Hiểu sự nguy hiểm của Downcasting và lỗi Runtime `ClassCastException`.

## Mô tả chi tiết:

### 1. Yêu cầu code (Viết vào hàm Main):

Tại hàm main của **Bài 2 - The polymorphic zoo** hãy gõ lại đoạn code sau:

```java
// Bước 1: Upcasting (An toàn)
Animal a = new Dog(); // Dog kế thừa Animal (lấy từ Bài 2)

// Bước 2: Downcasting (Rủi ro) - Hãy viết dòng này:
Cat c = (Cat) a;

// Bước 3: Gọi hàm
c.makeSound();
```

### 2. Thực hành:

a. Biên dịch chương trình (`javac`). Có lỗi không? (Mong đợi: Không lỗi biên dịch).

b. Chạy chương trình (`java`). Có lỗi không? Ghi lại tên lỗi (**Exception**) xuất hiện.

### 3. Sửa lỗi:

a. Sử dụng cấu trúc `if` và toán tử `instanceof` để kiểm tra biến `a` có đúng là `Cat` hay không trước khi ép kiểu.

b. In ra thông báo:

```
"Đây không phải là Mèo!"
```

nếu ép kiểu không hợp lệ.

### 4. Ví dụ:

**Input:** (No input)

**Output:**

**Trước khi sửa:**

```
Exception …
```

**Sau khi sửa:**

```
Đây không phải là Mèo!
```

---

# Bài 5: Hệ thống tính lương Payroll System

**Mục tiêu:** Thiết kế lớp trừu tượng và áp dụng đa hình để xử lý nghiệp vụ tính toán khác nhau.

## Mô tả nghiệp vụ

Một công ty phần mềm cần quản lý trả lương cho nhân viên. Có 2 loại nhân viên **Employee**:

1. Nhân viên Full-time **FullTimeEmployee**  
   Lương được tính bằng:

```
baseSalary + (bonus - penalty)
```

2. Nhân viên Part-time **PartTimeEmployee**

```
workingHours * hourlyRate
```

## Yêu cầu thiết kế & Cài đặt

### 1. Phân tích

- Xác định lớp cha **Employee**.
- Lớp này chứa các thông tin chung của nhân viên (tên, ngày tháng năm sinh, mã số nhân viên).
- Xác định các lớp con **FullTimeEmployee** và **PartTimeEmployee**.
- Xác định các thuộc tính và phương thức riêng cần thiết cho từng loại.
- Vẽ sơ đồ lớp cho hệ thống.

### 2. Cài đặt

- Viết code Java hiện thực hóa sơ đồ trên.
- Trong hàm main: Cho một mảng `Employee[]` chứa thông tin của các nhân viên.
- In ra bảng lương chi tiết:

```
Tên - Loại NV - Lương thực nhận
```

### 3. Ví dụ

**Input**

```
3
F "Nguyễn Văn A" 1500 200 50
P "Trần Thị B" 80 10
F "Lê Văn C" 1400 100 50
```

**Output**

```
Nguyễn Văn A - Full-time - 1650.0
Trần Thị B - Part-time - 800.0
Lê Văn C - Full-time - 1450.0
```

---

# Bài 6: Cửa hàng trực tuyến

## Mô tả nghiệp vụ

Xây dựng module tính tiền cho đơn hàng gồm nhiều loại sản phẩm khác nhau:

1. **Electronics**
   - Giá bán cộng thêm **10% thuế VAT** và **phí bảo hành (nếu có)**.

2. **Food**
   - Không chịu thuế.
   - Nếu sản phẩm sắp hết hạn (**còn < 7 ngày**) → **giảm giá 20%**.

(Gợi ý: Dùng `java.time.LocalDate` để xử lý ngày tháng)

## Yêu cầu thiết kế & Cài đặt

### 1. Phân tích

- Thiết kế lớp cha **Product**
  - mã, tên, giá gốc
  - phương thức:

```
getFinalPrice()
```

trả về giá gốc.

- Thiết kế lớp con **Electronics** và **Food**.

- Vẽ sơ đồ lớp.

### 2. Cài đặt

- Tạo đơn hàng (**Order**) chứa danh sách sản phẩm hỗn hợp.
- Tính tổng tiền người dùng phải trả.

### 3. Ví dụ

**Input**

```
3
E "Laptop" 1000 50
F "Milk" 30 2025-03-15
F "Bread" 20 2025-03-05
```

**Output**

```
Laptop - Electronics - 1150.0
Milk - Food - 30.0
Bread - Food - 16.0
Total = 1196.0
```

---

# Bài 7: Quản lý khách sạn

## Bài toán

Một khách sạn có 2 hạng phòng:

1. **Standard**

```
500.000đ/đêm
```

2. **VIP**

```
2.000.000đ/đêm
```

Phòng VIP luôn được miễn phí ăn sáng.

## Chính sách

- Nếu thuê **quá 3 đêm**, phòng **Standard giảm 5%**.
- Phòng **VIP không giảm giá**.

## Yêu cầu

- Thiết kế các lớp để quản lý việc tính tiền phòng.
- Viết chương trình nhập số đêm ở và loại phòng.

## Ví dụ

**Input**

Case 1

```
S 3
```

Case 2

```
S 4
```

Case 3

```
V 2
```

**Output**

Case 1

```
1500000
```

Case 2

```
1900000
```

Case 3

```
4000000
```

---

# Bài 8: Abstract Class and Interface

## Tình huống

Bạn đang lập trình cho một nhà máy chế tạo **Robot**.

## 1. Abstract Class

Tạo lớp trừu tượng **Robot**

Thuộc tính:

```
id (int)
modelName (String)
batteryLevel (int)
```

Constructor nhận `id` và `modelName`.

Phương thức:

```
void chargeBattery()
```

→ tăng pin lên 100%.

```
final void showIdentity()
```

→ In ra ID và Model.

Abstract method:

```
void performMainTask()
```

---

## 2. Interfaces

```
interface Flyable
void fly()
```

```
interface Swimmable
void swim()
```

```
interface GPS
void getCoordinates()
```

---

## 3. Lớp con

- **DroneRobot**

```
extends Robot
implements Flyable, GPS
```

- **FishRobot**

```
extends Robot
implements Swimmable
```

- **AmphibiousRobot**

```
extends Robot
implements Flyable, Swimmable, GPS
```

---

## 4. Hàm Main

- Tạo danh sách Robot
- Gọi `performMainTask()`
- Thử gọi `fly()`
- Downcasting
- Kiểm tra `instanceof`

Thử:

```
DroneRobot extends Robot và ElectronicDevice
```

→ Java có cho phép **extends 2 class không?**

Chuyển **ElectronicDevice → Interface**

---

## 5. Ví dụ

**Input**

```
3
DR 1 Drone-X
FR 2 Fish-A
AR 3 Amphibious-Z
```

**Output**

```
Drone-X performing main task
Drone-X flying
Drone-X getting coordinates
Fish-A performing main task
Fish-A swimming
Amphibious-Z performing main task
Amphibious-Z flying
Amphibious-Z swimming
Amphibious-Z getting coordinates
```

---

# Bài 9: Tính tổng chi phí

## Thiết kế Class

### Interface

```
IPayable
double getPaymentAmount()
```

### Abstract Class

```
Staff implements IPayable
```

Thuộc tính:

```
String id
String name
```

### Class

**PartTimeStaff**

```
workingHours
hourlyRate
```

Override:

```
getPaymentAmount()
```

→ `workingHours * hourlyRate`

---

**Invoice**

Thuộc tính

```
itemName
quantity
pricePerItem
```

Override

```
getPaymentAmount()
```

→ `quantity * pricePerItem`

---

## Hàm main

Tạo:

```
IPayable[] payableList
```

Tính tổng chi phí.

---

## Ví dụ

**Input**

```
3
S PT01 NguyenVanA 40 10
I Laptop 2 500
S PT02 TranThiB 20 12
```

**Output**

```
PartTimeStaff NguyenVanA - Payment: 400.0
Invoice Laptop - Payment: 1000.0
PartTimeStaff TranThiB - Payment: 240.0
Total Payment = 1640.0
```

---

# Bài 10: Quản lý nhân sự và tính thưởng

## Thiết kế Class

### Employee

Thuộc tính

```
String name
double baseSalary
```

Phương thức

```
public double calculateBonus()
```

→ trả về **10% baseSalary**

---

### Developer extends Employee

Thuộc tính

```
overtimeHours
```

Bonus

```
10% baseSalary + (overtimeHours * 200000)
```

---

### Tester extends Employee

Thuộc tính

```
bugsFound
```

Bonus

```
10% baseSalary + (bugsFound * 50000)
```

---

## Hàm main

Tạo

```
ArrayList<Employee>
```

Thêm:

```
2 Developer
2 Tester
1 Employee
```

In tiền thưởng.

---

## Nâng cao

Nếu là **Developer**

```
"Tặng khóa học AWS"
```

Nếu là **Tester**

```
"Tặng tool Test"
```

Dùng:

```
instanceof
```

---

## Ví dụ

**Input**

```
5
E NguyenVanA 10000000
D TranThiB 12000000 10
T LeVanC 9000000 20
D PhamVanD 15000000 5
T HoangThiE 8000000 10
```

**Output**

```
NguyenVanA - Bonus: 1000000.0
TranThiB - Bonus: 3200000.0
Tặng khóa học AWS
LeVanC - Bonus: 1900000.0
Tặng tool Test
PhamVanD - Bonus: 2500000.0
Tặng khóa học AWS
HoangThiE - Bonus: 1300000.0
Tặng tool Test
```
