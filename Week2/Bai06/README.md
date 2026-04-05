# Bài 2.6 – Immutable Object & Deep Copy

## 1. Tóm tắt ý tưởng chính của lời giải

Bài toán yêu cầu xây dựng:

- Lớp `Transaction` (bất biến – immutable)
- Lớp `Account` quản lý danh sách giao dịch
- Ngăn chặn việc chỉnh sửa dữ liệu từ bên ngoài (giả lập hacker)

---

### Thiết kế lớp Transaction (Immutable Object)

```java
private final String transactionId;
private final double amount;
private final String timestamp;
```

Đặc điểm:

- Tất cả thuộc tính khai báo `private final`
- Không có setter
- Chỉ có getter
- Giá trị chỉ được gán duy nhất trong constructor

=> Sau khi tạo, một `Transaction` không thể bị thay đổi.

Đây chính là **Immutable Object**.

---

### Thiết kế lớp Account

Thuộc tính chính:

```java
private Transaction[] history;
private int transactionCount;
```

- Sử dụng mảng để lưu lịch sử giao dịch
- Có biến đếm số lượng giao dịch thực tế

### addTransaction(Transaction t)

- Thêm giao dịch vào mảng
- Cập nhật balance theo amount

---

### Cơ chế bảo vệ dữ liệu – Defensive Copy

Phương thức:

```java
public Transaction[] getHistory() {
    return Arrays.copyOf(this.history, this.transactionCount);
}
```

Thay vì trả về trực tiếp:

```java
return this.history; // RẤT NGUY HIỂM
```

Ta trả về một bản sao của mảng.

Điều này đảm bảo:
- Hacker chỉ có bản sao
- Không thể sửa mảng gốc bên trong Account

---

### Kiểm thử hacker trong main

Trong main:

1. Tạo account và thêm 2 transaction
2. Lấy mảng history thông qua getHistory()
3. Hacker gán hackedHistory[0] = null
4. In lại lịch sử

Kết quả:
- Lịch sử gốc bên trong Account không bị thay đổi
- Hệ thống vẫn an toàn

---

## 2. Lý do lựa chọn hướng tiếp cận & Ưu điểm

### Vì sao cần Immutable Object?

Nếu Transaction có setter:

- Hacker có thể sửa amount thành 9999999
- Làm sai lệch số dư tài khoản
- Phá vỡ toàn bộ hệ thống tài chính

Immutable giúp:

- Bảo vệ dữ liệu tuyệt đối
- Tránh side-effect
- An toàn trong môi trường đa luồng

---

### Vì sao cần Defensive Copy?

Nếu getHistory() trả về mảng gốc:

```java
Transaction[] hacked = myAccount.getHistory();
hacked[0] = null;
```

=> Lịch sử thật sẽ bị thay đổi.

Sử dụng:

```java
Arrays.copyOf(...)
```

=> Hacker chỉ sửa bản sao.

---

### Ưu điểm của thiết kế này

- Bảo vệ dữ liệu khỏi truy cập trái phép
- Tuân thủ nguyên tắc Encapsulation
- Tránh rò rỉ tham chiếu nội bộ (Reference Leak)
- Phù hợp với hệ thống ngân hàng thực tế

Đây là kỹ thuật rất quan trọng trong:

- Hệ thống tài chính
- API công khai
- Thiết kế thư viện an toàn

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

Chương trình sẽ:

- In lịch sử trước khi hacker can thiệp
- Giả lập hacker chỉnh sửa dữ liệu
- In lại lịch sử để chứng minh dữ liệu gốc không bị thay đổi
