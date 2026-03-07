# Bài 2.5 – Equals Method

## 1. Tóm tắt ý tưởng chính của lời giải

Bài toán yêu cầu:

- Tạo lớp `Book` gồm:
  - title (String)
  - author (String)
  - price (double)
- Override phương thức `equals(Object obj)`
- So sánh sự khác nhau giữa `==` và `equals()`

### Thiết kế lớp

Các thuộc tính được khai báo `private` để đảm bảo tính đóng gói:

```java
private String title;
private String author;
private double price;
```

Constructor nhận đủ 3 tham số để khởi tạo đối tượng.

---

### Override phương thức equals()

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    Book book = (Book) obj;

    return Double.compare(book.price, price) == 0 &&
           title.equals(book.title) &&
           author.equals(book.author);
}
```

### Các bước xử lý trong equals:

1. Kiểm tra cùng tham chiếu (`this == obj`)
2. Kiểm tra null và cùng kiểu dữ liệu
3. Ép kiểu về Book
4. So sánh từng thuộc tính:
   - price dùng `Double.compare()`
   - title và author dùng `String.equals()`

Điều này đảm bảo so sánh nội dung thay vì so sánh địa chỉ bộ nhớ.

---

### Kiểm thử trong main

Trong `main()`:

- Tạo 2 object có cùng dữ liệu
- So sánh bằng `==`
- So sánh bằng `equals()`

Kết quả:

```
Using == : false
Using equals : true
```

---

## 2. Lý do lựa chọn hướng tiếp cận & Ưu điểm

### Sự khác nhau giữa `==` và `equals()`

| Toán tử | So sánh gì? |
|----------|------------|
| `==` | So sánh địa chỉ bộ nhớ (tham chiếu) |
| `equals()` | So sánh nội dung (có thể override) |

Trong Java:

- `==` kiểm tra hai biến có trỏ tới cùng một object hay không.
- `equals()` có thể được override để so sánh nội dung logic.

### Vì sao cần override equals()?

Nếu không override:

```java
book1.equals(book2)
```

Sẽ giống như:

```java
book1 == book2
```

→ Kết quả sẽ là `false` dù dữ liệu giống nhau.

Override giúp:

- So sánh đúng theo logic nghiệp vụ.
- Phù hợp khi làm việc với Collection (HashSet, HashMap…).
- Tránh lỗi logic trong hệ thống lớn.

---

### Ưu điểm của cách cài đặt

- Kiểm tra null an toàn.
- Kiểm tra đúng kiểu đối tượng.
- So sánh chính xác giá trị double bằng `Double.compare()`.
- Tuân thủ nguyên tắc override chuẩn trong Java.

Thiết kế này đảm bảo tính chính xác và an toàn khi so sánh object.

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

Chương trình sẽ in kết quả so sánh giữa `==` và `equals()` để minh họa sự khác biệt.
