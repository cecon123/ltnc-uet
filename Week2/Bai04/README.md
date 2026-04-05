# Bài 2.4 – Composition & Deep Copy

## 1. Tóm tắt ý tưởng chính của lời giải

Bài toán yêu cầu:

- Tạo lớp `MyDate` (day, month, year)
- Tạo lớp `Employee` gồm:
  - name (String)
  - birthday (MyDate)
- Viết Copy Constructor cho Employee
- Đảm bảo khi thay đổi emp1 thì emp2 không bị thay đổi theo

### Thiết kế Composition

Lớp `Employee` chứa một đối tượng `MyDate`, thể hiện mối quan hệ **Composition**:

```java
String name;
MyDate birthday;
```

Điều này có nghĩa:
- Employee "có một" MyDate.
- Đây là quan hệ HAS-A trong OOP.

---

### Copy Constructor và Deep Copy

Copy constructor của `Employee`:

```java
public Employee(Employee other) {
    this.name = other.name;
    this.birthday = new MyDate(other.birthday);
}
```

Thay vì:

```java
this.birthday = other.birthday; // Shallow Copy (Sai trong bài này)
```

Ta sử dụng:

```java
new MyDate(other.birthday);
```

Điều này tạo ra một đối tượng MyDate mới hoàn toàn trong bộ nhớ → gọi là **Deep Copy**.

---

### Kiểm chứng trong main

Các bước:

1. Tạo `emp1` với ngày sinh 1/1/2000
2. Tạo `emp2` bằng copy constructor
3. Thay đổi ngày sinh của `emp1`
4. In ngày sinh của `emp2`

Kết quả:
- Ngày sinh của `emp2` không bị thay đổi
- Chứng minh Deep Copy hoạt động đúng

---

## 2. Lý do lựa chọn hướng tiếp cận & Ưu điểm

### Sự khác biệt giữa Shallow Copy và Deep Copy

#### Shallow Copy
- Chỉ sao chép tham chiếu.
- Hai object dùng chung một vùng nhớ.
- Thay đổi một object → object còn lại cũng bị ảnh hưởng.

#### Deep Copy
- Tạo object mới hoàn toàn.
- Không chia sẻ bộ nhớ.
- Hai object độc lập với nhau.

Trong bài này, nếu dùng Shallow Copy:

```java
this.birthday = other.birthday;
```

Thì khi sửa `emp1.birthday`, `emp2.birthday` sẽ bị thay đổi theo.

Điều này vi phạm yêu cầu đề bài.

---

### Ưu điểm của Deep Copy

- Đảm bảo tính độc lập giữa các đối tượng.
- An toàn khi làm việc với dữ liệu nhạy cảm.
- Tránh lỗi side-effect trong hệ thống lớn.

Trong thực tế:
- Deep Copy rất quan trọng trong các hệ thống quản lý nhân sự, tài chính, dữ liệu nhạy cảm.

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

Chương trình sẽ tạo hai đối tượng Employee và chứng minh rằng việc thay đổi emp1 không ảnh hưởng đến emp2.
