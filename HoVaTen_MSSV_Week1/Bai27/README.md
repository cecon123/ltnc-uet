# Bài 2.7 – Pass-by-Reference & Deep Copy

## 1. Tóm tắt ý tưởng chính của lời giải

Bài toán yêu cầu:

- Tạo lớp `Product` gồm id, name, price
- Tạo lớp `Inventory` quản lý mảng các sản phẩm
- Chứng minh sự khác biệt giữa Shallow Copy và Deep Copy
- Đảm bảo khi thay đổi mảng bên ngoài thì dữ liệu trong Inventory không bị ảnh hưởng

---

### Thiết kế lớp Product

```java
private String id;
private String name;
private double price;
```

- Có getter và setter cho price
- Có phương thức `toString()` để in thông tin sản phẩm

---

### Thiết kế lớp Inventory

```java
private Product[] items;
```

Trong constructor:

```java
public Inventory(Product[] initialItems) {
    this.items = new Product[initialItems.length];
    for (int i = 0; i < initialItems.length; i++) {
        if (initialItems[i] != null) {
            this.items[i] = new Product(
                initialItems[i].getId(),
                initialItems[i].getName(),
                initialItems[i].getPrice()
            );
        }
    }
}
```

Thay vì:

```java
this.items = initialItems; // Shallow Copy (Sai)
```

Ta tạo từng object mới → đây là **Deep Copy**.

---

### Kiểm chứng trong main

Các bước:

1. Tạo mảng `arr` gồm 2 sản phẩm
2. Khởi tạo `Inventory kho = new Inventory(arr)`
3. Bên ngoài, thay đổi giá sản phẩm:
   ```java
   arr[0].setPrice(5000);
   ```
4. In danh sách sản phẩm trong `kho`

Kết quả:
- Giá trong `kho` không thay đổi
- Chứng minh Deep Copy hoạt động đúng

---

## 2. Lý do lựa chọn hướng tiếp cận & Ưu điểm

### Vấn đề nếu dùng Shallow Copy

Nếu constructor viết:

```java
this.items = initialItems;
```

Thì:

- `items` và `initialItems` trỏ cùng một vùng nhớ
- Khi thay đổi arr[0].setPrice(5000)
- Giá trong Inventory cũng thay đổi theo

Điều này gây:

- Rò rỉ tham chiếu (Reference Leak)
- Dữ liệu hệ thống bị thay đổi ngoài ý muốn
- Khó kiểm soát logic

---

### Vì sao Deep Copy là cần thiết?

Deep Copy đảm bảo:

- Inventory sở hữu bản sao độc lập của dữ liệu
- Không bị ảnh hưởng bởi thay đổi bên ngoài
- Đảm bảo tính toàn vẹn dữ liệu hệ thống

---

### Kiến thức quan trọng rút ra

- Java truyền tham chiếu theo giá trị (pass-by-value of reference)
- Shallow Copy chỉ sao chép địa chỉ
- Deep Copy sao chép toàn bộ object

Bài này giúp hiểu rõ:

- Cách Java quản lý bộ nhớ
- Sự khác biệt giữa Shallow và Deep Copy
- Tại sao cần defensive programming

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

- Tạo mảng sản phẩm ban đầu
- Thay đổi giá bên ngoài Inventory
- In dữ liệu trong Inventory để chứng minh Deep Copy bảo vệ dữ liệu thành công
