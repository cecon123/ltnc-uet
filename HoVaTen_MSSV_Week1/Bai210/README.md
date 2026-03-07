# Bài 2.10 – Overloading & this

## 1. Tóm tắt ý tưởng chính của lời giải

Bài toán mô phỏng hệ thống điều khiển đèn thông minh (SmartLight) có:

- Nhiều mức độ sáng
- Các chế độ preset (MAX, MIN, ECO)
- Kết nối tới bộ điều khiển trung tâm (CentralHub)

Mục tiêu chính của bài:

- Hiểu Constructor Overloading
- Hiểu từ khóa this
- Hiểu Method Overloading
- Truyền chính đối tượng hiện tại làm tham số (this reference)

---

## Thiết kế lớp SmartLight

### Thuộc tính

```java
private String id;
private String name;
private int brightness;
```

- id: mã định danh của đèn
- name: tên đèn
- brightness: độ sáng hiện tại

---

## Constructor Overloading & this(...)

### Constructor đầy đủ

```java
public SmartLight(String id, String name, int brightness)
```

### Constructor 2 tham số

```java
public SmartLight(String id, String name) {
    this(id, name, 50);
}
```

Ở đây:

- Sử dụng `this(...)` để gọi constructor khác
- Gán brightness mặc định = 50

Ưu điểm:
- Tránh lặp code
- Dễ bảo trì
- Chuẩn OOP

---

## Method Overloading – setBrightness

Có 2 phương thức cùng tên:

### 1. setBrightness(int brightness)

Cập nhật độ sáng trực tiếp.

### 2. setBrightness(String preset)

Nhận giá trị preset:

- "MAX" → 100
- "MIN" → 10
- "ECO" → 30

Bên trong gọi lại:

```java
this.setBrightness(100);
```

Điều này thể hiện:

- Tái sử dụng code
- Không lặp logic

---

## Sử dụng this để truyền đối tượng hiện tại

```java
public void connectToHub(CentralHub hub) {
    hub.registerDevice(this);
}
```

Ở đây:

- `this` chính là đối tượng SmartLight hiện tại
- Truyền vào hub để đăng ký thiết bị

---

## Thiết kế lớp CentralHub

```java
public void registerDevice(SmartLight light)
```

In ra thông báo kết nối thiết bị.

Thể hiện mối quan hệ giữa các object (Object Interaction).

---

## Kiểm thử trong main

1. Tạo hub
2. Tạo l1 bằng constructor đầy đủ
3. Tạo l2 bằng constructor 2 tham số
4. Gọi l2.setBrightness("ECO")
5. Kết nối cả 2 đèn với hub
6. In độ sáng

Kết quả chứng minh:

- Constructor overloading hoạt động đúng
- Preset hoạt động đúng
- this truyền đúng object
- Hai object hoạt động độc lập

---

## 2. Lý do lựa chọn hướng tiếp cận & Ưu điểm

### Vì sao dùng Constructor Overloading?

- Linh hoạt khi khởi tạo object
- Có thể dùng giá trị mặc định
- Tránh duplicate code

---

### Vì sao dùng Method Overloading?

- Cùng một hành động (setBrightness)
- Nhưng nhiều cách sử dụng (int hoặc preset)
- Code gọn gàng, dễ đọc

---

### Vai trò của this

`this` được dùng để:

1. Gọi constructor khác
2. Phân biệt biến instance và tham số
3. Truyền chính object hiện tại làm tham số

Đây là kỹ thuật rất quan trọng trong OOP.

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

- Tạo 2 đèn
- Áp dụng preset
- Kết nối với hub
- In độ sáng để kiểm tra kết quả
