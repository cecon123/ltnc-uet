# Bài 10 – Quản lý nhân sự và tính thưởng

## 1. Tóm tắt ý tưởng chính của lời giải

Bài toán mô phỏng hệ thống quản lý nhân sự và tính thưởng cuối năm cho nhân viên trong công ty phần mềm.

Có 3 loại nhân viên:

1. **Employee (Nhân viên thường)**
2. **Developer (Lập trình viên)**
3. **Tester (Kiểm thử viên)**

Mỗi loại nhân viên có **cách tính thưởng khác nhau**, vì vậy hệ thống được thiết kế bằng:

- Inheritance
- Method Overriding
- Polymorphism
- Runtime Type Checking (`instanceof`)

---

# Thiết kế lớp

## Lớp Employee

Lớp `Employee` là lớp cha chứa thông tin chung của tất cả nhân viên. :contentReference[oaicite:4]{index=4}

```java
public class Employee {

    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculateBonus() {
        return baseSalary * 0.1;
    }
}
```

### Thuộc tính

```
name
baseSalary
```

### Công thức thưởng mặc định

```
bonus = 10% * baseSalary
```

---

# Lớp Developer

Lớp `Developer` kế thừa từ `Employee`. :contentReference[oaicite:5]{index=5}

### Thuộc tính riêng

```
overtimeHours
```

### Công thức thưởng

```
bonus = 10% * baseSalary + overtimeHours * 200000
```

### Implementation

```java
@Override
public double calculateBonus() {
    return baseSalary * 0.1 + overtimeHours * 200000;
}
```

---

# Lớp Tester

Lớp `Tester` kế thừa từ `Employee`. :contentReference[oaicite:6]{index=6}

### Thuộc tính riêng

```
bugsFound
```

### Công thức thưởng

```
bonus = 10% * baseSalary + bugsFound * 50000
```

### Implementation

```java
@Override
public double calculateBonus() {
    return baseSalary * 0.1 + bugsFound * 50000;
}
```

---

# Sơ đồ lớp hệ thống

```mermaid
classDiagram

class Employee {
    #name : String
    #baseSalary : double
    +calculateBonus() double
}

class Developer {
    -overtimeHours : int
    +calculateBonus()
}

class Tester {
    -bugsFound : int
    +calculateBonus()
}

Employee <|-- Developer
Employee <|-- Tester
```

---

# Áp dụng Polymorphism

Trong chương trình:

```java
ArrayList<Employee> employees = new ArrayList<>();
```

Danh sách này có thể chứa nhiều loại nhân viên:

```
Developer
Tester
Employee
```

Khi gọi:

```
e.calculateBonus()
```

Java sẽ tự động gọi đúng phương thức của object thực tế.

---

# Thực hành trong main

Danh sách nhân viên được tạo như sau: :contentReference[oaicite:7]{index=7}

```java
employees.add(new Developer("Alice", 20000000, 10));
employees.add(new Developer("Bob", 18000000, 5));
employees.add(new Tester("Charlie", 15000000, 20));
employees.add(new Tester("David", 14000000, 15));
employees.add(new Employee("Eve", 16000000));
```

Sau đó duyệt danh sách:

```java
for (Employee e : employees) {
    System.out.println(e.name + " bonus: " + e.calculateBonus());
}
```

---

# Phần nâng cao – Chính sách thưởng đặc biệt

Công ty có chính sách cuối năm:

| Loại nhân viên | Phần thưởng |
|---|---|
Developer | Khóa học AWS |
Tester | Tool Test mới |

Để kiểm tra loại nhân viên, chương trình dùng:

```
instanceof
```

### Implementation

```java
if (e instanceof Developer) {
    System.out.println("Tặng khóa học AWS");
}

if (e instanceof Tester) {
    System.out.println("Tặng tool Test");
}
```

---

# Ví dụ kết quả chương trình

```
Alice bonus: 4000000.0
Tặng khóa học AWS
-------------------

Bob bonus: 2800000.0
Tặng khóa học AWS
-------------------

Charlie bonus: 2500000.0
Tặng tool Test
-------------------

David bonus: 2150000.0
Tặng tool Test
-------------------

Eve bonus: 1600000.0
-------------------
```

---

# Ý nghĩa bài học

Bài này minh họa nhiều khái niệm OOP quan trọng:

### Inheritance

```
Developer extends Employee
Tester extends Employee
```

---

### Method Overriding

Các lớp con định nghĩa lại:

```
calculateBonus()
```

---

### Polymorphism

Danh sách `ArrayList<Employee>` chứa nhiều loại object khác nhau.

---

### Runtime Type Checking

Sử dụng:

```
instanceof
```

để xác định loại object tại runtime.

---

# Ưu điểm thiết kế

Hệ thống rất dễ mở rộng.

Nếu sau này thêm:

```
Manager
Designer
DevOps
```

chỉ cần:

```
extends Employee
override calculateBonus()
```

không cần sửa code cũ.

---

## 3. Cách chạy chương trình

1. **Cấp quyền thực thi cho script:**
   ```bash
   chmod +x run.sh
   ```

2. **Chạy chương trình:**
   ```bash
   ./run.sh
   ```
