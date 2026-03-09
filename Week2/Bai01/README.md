# Bài 2.1 – Bank Account

## 1. Tóm tắt ý tưởng chính của lời giải

Bài toán yêu cầu xây dựng một lớp `BankAccount` mô phỏng tài khoản ngân hàng với các chức năng cơ bản:
- Tạo tài khoản
- Nạp tiền
- Rút tiền
- Xem số dư

### Thiết kế lớp

Lớp gồm các thuộc tính:

- `accountNumber` (String): Mã tài khoản (không thay đổi sau khi tạo).
- `ownerName` (String): Tên chủ tài khoản.
- `balance` (double): Số dư tài khoản.

Tất cả thuộc tính đều khai báo `private` để đảm bảo **Encapsulation**.

`accountNumber` được khai báo `final` để đảm bảo tính bất biến (immutable) sau khi khởi tạo.

### Constructor

Có 2 constructor:

1. Constructor 2 tham số:
   - Khởi tạo tài khoản với số dư mặc định = 0.

2. Constructor 3 tham số:
   - Nếu số dư ban đầu < 0 → in thông báo lỗi và gán về 0.
   - Nếu hợp lệ → gán bình thường.

Điều này đảm bảo ngay từ khi tạo đối tượng, dữ liệu đã hợp lệ.

### Các phương thức chính

#### deposit(double amount)

- Chỉ cho phép nạp tiền nếu `amount > 0`.
- Nếu hợp lệ → cộng vào số dư.
- Nếu không hợp lệ → in thông báo lỗi.
- Không cho phép nạp tiền âm.

#### withdraw(double amount)

- Chỉ cho phép rút nếu:
  - `amount > 0`
  - `amount <= balance`
- Nếu hợp lệ → trừ tiền và trả về `true`.
- Nếu không hợp lệ → in lỗi và trả về `false`.

Phương thức này đảm bảo:
- Không bao giờ xảy ra số dư âm.
- Có kiểm soát trạng thái tài khoản.

#### getBalance()

- Chỉ cho phép xem số dư.
- Không có setter → bên ngoài không thể chỉnh sửa trực tiếp `balance`.

### Kiểm thử trong main

Chương trình minh họa các tình huống:

1. Nạp tiền âm → bị từ chối.
2. Nạp tiền hợp lệ → thành công.
3. Rút quá số dư → thất bại.
4. Rút hợp lệ → thành công.

Qua đó chứng minh cơ chế bảo vệ dữ liệu hoạt động đúng.

---

## 2. Lý do lựa chọn hướng tiếp cận & Ưu điểm

### Lý do lựa chọn

Giải pháp được xây dựng theo nguyên tắc:

- Đóng gói dữ liệu (Encapsulation)
- Bảo vệ tính toàn vẹn dữ liệu (Data Integrity)
- Kiểm tra dữ liệu đầu vào (Validation)
- Thiết kế phòng thủ (Defensive Programming)

Mọi thay đổi trạng thái đều phải đi qua phương thức kiểm tra logic.

### Ưu điểm so với cách làm kém an toàn

Nếu để thuộc tính `balance` là public hoặc có setter:

- Có thể gán số dư âm
- Có thể phá vỡ logic hệ thống
- Không kiểm soát được trạng thái đối tượng

Với cách hiện tại:

- Không thể rút quá số dư
- Không thể nạp tiền âm
- Không thể thay đổi mã tài khoản sau khi tạo
- Đảm bảo trạng thái đối tượng luôn hợp lệ

Thiết kế này phù hợp với các hệ thống tài chính thực tế, nơi dữ liệu phải được bảo vệ nghiêm ngặt.

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

Chương trình sẽ tự động biên dịch và chạy lớp `BankAccount`.
