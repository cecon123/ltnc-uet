# Bài 2.2 – Student

## 1. Tóm tắt ý tưởng chính của lời giải

Bài toán yêu cầu xây dựng lớp `Student` mô tả một sinh viên với các thuộc tính:

- id (mã sinh viên)
- name (tên)
- email
- gpa (điểm trung bình)

### Thiết kế lớp

Tất cả các thuộc tính được khai báo `private` để đảm bảo nguyên tắc **Encapsulation (Đóng gói)**.

```java
private String id;
private String name;
private String email;
private double gpa;
```

### Constructor

Lớp có 4 constructor:

1. Constructor không tham số  
   → Khởi tạo giá trị mặc định rỗng và gpa = 0.0

2. Constructor 2 tham số (id, name)  
   → Gán id và name, các giá trị còn lại mặc định

3. Constructor đầy đủ tham số  
   → Gán tất cả giá trị, riêng gpa được gán thông qua `setGpa()` để đảm bảo kiểm tra hợp lệ

4. Copy Constructor  
   ```java
   public Student(Student other)
   ```
   → Sao chép toàn bộ dữ liệu từ một đối tượng khác

### Validation

Phương thức `setGpa(double gpa)`:

- Chỉ chấp nhận giá trị từ 0.0 đến 4.0
- Nếu không hợp lệ → in thông báo lỗi và giữ nguyên giá trị cũ

Điều này đảm bảo:
- Không tồn tại sinh viên có GPA âm hoặc lớn hơn 4.0
- Bảo vệ tính hợp lệ của dữ liệu

### Hàm main kiểm thử

Trong `main()`:

- Tạo 3 sinh viên theo 3 cách khác nhau
- Thử gán GPA âm để kiểm tra validation
- In thông tin bằng phương thức `toString()`

---

## 2. Lý do lựa chọn hướng tiếp cận & Ưu điểm

### Hướng tiếp cận

Giải pháp áp dụng các nguyên tắc OOP quan trọng:

- Encapsulation
- Constructor Overloading
- Copy Constructor
- Data Validation

Việc dùng `setGpa()` trong constructor thay vì gán trực tiếp giúp đảm bảo mọi giá trị GPA đều được kiểm tra.

### Ưu điểm

1. Dữ liệu được bảo vệ:
   - Không thể truy cập trực tiếp thuộc tính từ bên ngoài.
   - GPA luôn nằm trong khoảng hợp lệ.

2. Linh hoạt khi khởi tạo:
   - Có thể tạo đối tượng theo nhiều cách khác nhau.
   - Copy constructor giúp sao chép đối tượng dễ dàng.

3. An toàn dữ liệu:
   - Nếu nhập GPA sai → không làm hỏng trạng thái đối tượng.
   - Giữ nguyên giá trị cũ khi dữ liệu không hợp lệ.

So với cách không kiểm tra dữ liệu:
- Có thể tạo sinh viên với GPA -5 hoặc 100
- Dữ liệu hệ thống sẽ mất tính tin cậy

Thiết kế hiện tại đảm bảo tính toàn vẹn dữ liệu.

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

Chương trình sẽ biên dịch và chạy lớp `Student`, sau đó in thông tin các sinh viên ra màn hình.
