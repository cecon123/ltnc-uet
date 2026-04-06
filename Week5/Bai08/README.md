# Bài 3: Đọc và ghi dữ liệu

## 1. Tóm tắt ý tưởng chính của lời giải

Bài toán yêu cầu xây dựng hai chương trình riêng biệt:

- Chương trình **ghi dữ liệu**: nhập n số nguyên từ bàn phím và ghi vào tệp nhị phân bằng `DataOutputStream`.
- Chương trình **đọc dữ liệu**: đọc lại các số nguyên từ tệp bằng `DataInputStream` và in ra màn hình.

Giải pháp sử dụng luồng nhị phân của Java:
- Ghi dữ liệu bằng `writeInt()`
- Đọc dữ liệu bằng `readInt()`
- Kết thúc đọc bằng cách bắt `EOFException`

---

## 2. Thiết kế hệ thống

### Lớp `GhiDuLieu`

```java
public class GhiDuLieu
```

#### Thuộc tính
- Không có thuộc tính riêng, chỉ sử dụng biến cục bộ trong `main`.

#### Vai trò
- Nhận dữ liệu từ người dùng (tên file, số lượng phần tử, các số nguyên).
- Ghi tuần tự các số nguyên vào file nhị phân.

#### Logic xử lý
- Sử dụng `Scanner` để nhập dữ liệu.
- Mở file bằng `FileOutputStream`.
- Ghi dữ liệu bằng `DataOutputStream.writeInt()`.
- Đóng file sau khi ghi xong.

---

### Lớp `DocDuLieu`

```java
public class DocDuLieu
```

#### Thuộc tính
- Không có thuộc tính riêng.

#### Vai trò
- Đọc dữ liệu từ file nhị phân và hiển thị ra màn hình.

#### Logic xử lý
- Nhập tên file từ bàn phím.
- Mở file bằng `FileInputStream`.
- Đọc dữ liệu bằng `DataInputStream.readInt()`.
- Dùng vòng lặp vô hạn để đọc liên tục.
- Bắt `EOFException` để xác định kết thúc file.

---

## 3. Lý do lựa chọn hướng tiếp cận và ưu điểm

### Hướng tiếp cận
- Sử dụng luồng nhị phân (`DataOutputStream`, `DataInputStream`) để ghi/đọc dữ liệu kiểu nguyên.
- Tách riêng chương trình ghi và đọc giúp dễ kiểm thử và rõ ràng chức năng.

### Ưu điểm
- Ghi/đọc đúng kiểu dữ liệu (int) → tránh lỗi parse như file text.
- Hiệu suất cao hơn so với file văn bản.
- Xử lý kết thúc file chuẩn bằng `EOFException`.

### Kiến thức rút ra
- Sử dụng luồng nhị phân trong Java.
- Cách xử lý ngoại lệ `IOException` và `EOFException`.
- Nguyên tắc: ghi kiểu gì → đọc đúng kiểu đó.

---

## 4. Ví dụ

### Input (ghi dữ liệu)

```text
Nhap ten tep de ghi: numbers.dat
Nhap so luong so nguyen n: 3
Nhap so nguyen thu 1: 10
Nhap so nguyen thu 2: 20
Nhap so nguyen thu 3: 30
```

### Output (ghi)

```text
Ghi du lieu vao tep thanh cong!
```

---

### Input (đọc dữ liệu)

```text
Nhap ten tep can doc: numbers.dat
```

### Output (đọc)

```text
Cac so nguyen doc duoc tu tep:
10
20
30
Da doc het du lieu trong tep.
```

---

## 5. Kết luận

Bài toán đã xây dựng thành công hai chương trình:
- Một chương trình ghi dữ liệu vào file nhị phân
- Một chương trình đọc lại dữ liệu từ file

Giải pháp đảm bảo:
- Đúng kiểu dữ liệu
- Xử lý ngoại lệ đầy đủ
- Dễ mở rộng cho các kiểu dữ liệu khác

---

## 6. Cách chạy chương trình

1. **Biên dịch chương trình:**
   ```bash
   javac GhiDuLieu.java DocDuLieu.java
   ```

2. **Chạy chương trình ghi dữ liệu:**
   ```bash
   java GhiDuLieu
   ```

3. **Chạy chương trình đọc dữ liệu:**
   ```bash
   java DocDuLieu
   ```
