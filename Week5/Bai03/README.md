# Bài 3: Word Frequency Counter

## 1. Tóm tắt ý tưởng chính của lời giải

Bài toán yêu cầu đếm tần suất xuất hiện của các từ trong một đoạn văn bản tiếng Anh, sau đó:

- Tìm từ xuất hiện nhiều nhất
- Liệt kê các từ chỉ xuất hiện đúng 1 lần

Hướng tiếp cận chính:

- **Chuẩn hóa chuỗi (String)**: chuyển về chữ thường và loại bỏ dấu câu
- **Sử dụng HashMap<String, Integer>** để lưu số lần xuất hiện của từng từ
- **Duyệt Map** để:
  - Tìm từ có tần suất lớn nhất
  - Lọc ra các từ xuất hiện đúng 1 lần

---

## 2. Thiết kế hệ thống

### Class: `Main`

```java
public class Main
````

#### Thuộc tính:

* Không có thuộc tính riêng

#### Vai trò:

* Là lớp chính chứa hàm `main`
* Thực hiện toàn bộ logic xử lý:

  * Chuẩn hóa văn bản
  * Tách từ
  * Đếm tần suất
  * Thống kê kết quả

#### Logic xử lý:

1. **Chuẩn hóa văn bản**

   * Chuyển về chữ thường:

     ```java
     text.toLowerCase()
     ```
   * Loại bỏ ký tự đặc biệt:

     ```java
     text.replaceAll("[^a-zA-Z\\s]", "")
     ```

2. **Tách từ**

   ```java
   String[] words = text.split("\\s+");
   ```

3. **Đếm tần suất (HashMap)**

   ```java
   wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
   ```

4. **Tìm từ xuất hiện nhiều nhất**

   * Duyệt toàn bộ Map
   * So sánh giá trị (count)

5. **Tìm các từ xuất hiện đúng 1 lần**

   * Lọc các entry có value = 1

---


## 3. Lý do lựa chọn hướng tiếp cận và ưu điểm

### Hướng tiếp cận

* Sử dụng **HashMap** để ánh xạ:

  ```
  word -> số lần xuất hiện
  ```

### Ưu điểm

* **Hiệu quả cao**: HashMap cho phép truy cập O(1)
* **Đơn giản, dễ hiểu**
* Dễ mở rộng (ví dụ: sắp xếp theo tần suất)

### Kiến thức rút ra

* Cách sử dụng `HashMap`
* Xử lý chuỗi với Regex
* Duyệt `Map.Entry`
* Sử dụng `getOrDefault`

---

## 4. Ví dụ

* **Không có input từ người dùng**
* Dữ liệu được mô phỏng trực tiếp trong chương trình

### Input (trong code)

```
Java is great. Java is powerful, and Java is popular! 
Programming in Java is fun. Learning Java helps students program better.
```

### Output

```
Most frequent word: java (count: 5)

Unique words:
great
powerful
and
popular
programming
in
fun
learning
helps
students
program
better
```

---

## 5. Kết luận

Chương trình đã giải quyết bài toán đếm tần suất từ bằng cách:

* Chuẩn hóa dữ liệu đầu vào
* Sử dụng HashMap để lưu trữ và xử lý
* Duyệt dữ liệu để thống kê

Có thể mở rộng:

* Sắp xếp từ theo tần suất giảm dần
* Loại bỏ stop-words (is, and, the,...)
* Đọc dữ liệu từ file

---

## 6. Cách chạy chương trình

1. Cấp quyền thực thi cho script:
  ```bash
  chmod +x run.sh
  ```

2. Chạy chương trình:
  ```bash
  ./run.sh
  ```
