# Bài 2.3 – The Swap Trick

## 1. Tóm tắt ý tưởng chính của lời giải

Bài toán yêu cầu:

- Tạo lớp `NumberWrapper` chứa một biến nguyên `int value`
- Viết phương thức `swap(NumberWrapper a, NumberWrapper b)` để hoán đổi hai tham số
- Kiểm tra kết quả trong hàm `main`

### Thiết kế lớp

Lớp `NumberWrapper` gồm:

```java
private int value;
```

- Có constructor để khởi tạo giá trị
- Có getter và setter để truy cập và thay đổi giá trị

### Phương thức swap

```java
public static void swap(NumberWrapper a, NumberWrapper b) {
    NumberWrapper temp = a;
    a = b;
    b = temp;
}
```

Phương thức này thực hiện hoán đổi tham chiếu `a` và `b` bên trong phương thức.

### Kiểm thử trong main

Trong `main()`:

- Tạo hai đối tượng:
  - `n1 = 5`
  - `n2 = 10`
- Gọi `swap(n1, n2)`
- In giá trị trước và sau khi swap

Kết quả cho thấy giá trị **không thay đổi** sau khi gọi swap.

---

## 2. Lý do lựa chọn hướng tiếp cận & Ưu điểm

### Hướng tiếp cận

Bài tập nhằm mục đích minh họa cơ chế **Pass-by-Value trong Java**.

Trong Java:

- Mọi tham số đều được truyền theo giá trị (pass-by-value).
- Với object, giá trị được truyền là **bản sao của tham chiếu**.
- Do đó, khi hoán đổi `a` và `b` bên trong phương thức, chỉ có bản sao tham chiếu bị đổi — không ảnh hưởng đến biến gốc bên ngoài.

### Ý nghĩa quan trọng

- Giúp hiểu rõ cách Java quản lý bộ nhớ.
- Tránh hiểu nhầm rằng Java là pass-by-reference.
- Là nền tảng quan trọng khi học về Deep Copy và Shallow Copy.

### Ưu điểm của cách minh họa này

- Đơn giản, dễ quan sát.
- Thể hiện rõ sự khác biệt giữa:
  - Hoán đổi tham chiếu
  - Hoán đổi giá trị bên trong object

Nếu muốn hoán đổi thật sự giá trị, ta phải:

```java
int temp = a.value;
a.value = b.value;
b.value = temp;
```

Chứ không phải hoán đổi tham chiếu.

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

Chương trình sẽ in ra giá trị trước và sau khi gọi `swap()` để minh họa cơ chế hoạt động.
