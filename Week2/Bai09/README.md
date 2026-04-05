# Bài 2.9 – Static Methods & Standard IO

## 1. Tóm tắt ý tưởng chính của lời giải

Bài toán mô phỏng hệ thống quản lý sản phẩm cho một chuỗi cửa hàng, với mục tiêu:

- Quản lý từng sản phẩm riêng lẻ (Instance Fields)
- Quản lý thông tin chung toàn hệ thống (Static Fields)
- Thực hiện giao dịch bán hàng
- Tính tổng doanh thu toàn hệ thống

---

## Thiết kế lớp Product

### 1. Instance Fields (Thuộc tính riêng của từng sản phẩm)

```java
private String name;
private double price;
private int quantity;
private double discount;
```

- Mỗi sản phẩm có giá, tồn kho và mức giảm giá riêng.

---

### 2. Static Fields (Thuộc tính dùng chung toàn hệ thống)

```java
private static double taxRate = 0.1;
private static double totalRevenue = 0.0;
```

- `taxRate`: mức thuế VAT chung cho toàn bộ sản phẩm.
- `totalRevenue`: tổng doanh thu từ tất cả các giao dịch.

Static nghĩa là:
- Chỉ tồn tại một bản duy nhất trong bộ nhớ.
- Tất cả object Product dùng chung.

---

## Các phương thức quan trọng

### updateTaxRate(double newRate) – static

Cập nhật thuế VAT cho toàn hệ thống.

→ Ảnh hưởng đến tất cả sản phẩm.

---

### calculateFinalPrice()

Công thức:

```
finalPrice = (price - discount) × (1 + taxRate)
```

- Sử dụng discount riêng của sản phẩm
- Sử dụng taxRate dùng chung

---

### sell(int amount)

Nếu đủ hàng:
- Giảm quantity
- Tính doanh thu
- Cộng vào biến static totalRevenue
- In thông báo thành công (System.out)

Nếu không đủ hàng:
- In lỗi ra System.err

---

## Kiểm thử trong main

Chương trình sử dụng `Scanner` để:

1. Nhập thông tin cho 2 sản phẩm
2. Thực hiện giao dịch bán
3. In giá cuối cùng
4. Thay đổi thuế VAT toàn hệ thống
5. Thay đổi discount của riêng 1 sản phẩm
6. In tổng doanh thu

---

## 2. Lý do lựa chọn hướng tiếp cận & Ưu điểm

### Phân biệt rõ Static và Instance

| Instance | Static |
|----------|--------|
| Thuộc về từng object | Thuộc về lớp |
| Có nhiều bản sao | Chỉ 1 bản duy nhất |
| Ví dụ: price, quantity | Ví dụ: taxRate |

Bài này giúp hiểu rõ:

- Khi nào nên dùng static
- Ảnh hưởng toàn cục của biến static
- Tính chia sẻ dữ liệu giữa các object

---

### Ưu điểm thiết kế

1. Thuế thay đổi → toàn hệ thống cập nhật ngay
2. Discount thay đổi → chỉ ảnh hưởng sản phẩm đó
3. Doanh thu được tính tập trung
4. Phân biệt rõ System.out và System.err

---

### Kiến thức OOP áp dụng

- Static field & method
- Instance field
- Encapsulation
- Scanner (Standard Input)
- System.out / System.err
- Tính toán động theo trạng thái hệ thống

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

Chương trình sẽ yêu cầu nhập thông tin sản phẩm và thực hiện các giao dịch để minh họa:

- Ảnh hưởng của static
- Thay đổi thuế toàn cục
- Thay đổi discount cục bộ
- Tổng doanh thu toàn hệ thống
