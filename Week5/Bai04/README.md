# Bài 4: Word Frequency Analyzer

## 1. Tóm tắt ý tưởng chính của lời giải

Bài toán xây dựng công cụ phân tích tần suất xuất hiện của các từ trong văn bản tiếng Anh nhằm tìm ra “từ khóa” quan trọng.

Hướng tiếp cận chính:

- Chuẩn hóa chuỗi (chữ thường, bỏ dấu câu)
- Tách văn bản thành các từ
- Sử dụng **HashMap<String, Integer>** để lưu:
  - Key: từ
  - Value: số lần xuất hiện
- Duyệt Map để:
  - In tần suất từng từ
  - Tìm từ xuất hiện nhiều nhất

---

## 2. Thiết kế hệ thống

### Class: `Main`

```java
public class Main
````

#### Vai trò:

* Là lớp chạy chương trình
* Tạo dữ liệu mẫu và gọi các phương thức xử lý

#### Logic:

* Khởi tạo chuỗi văn bản
* Tạo đối tượng `WordCounter`
* Gọi:

  ```java
  wc.analyze(text);
  wc.displayResult();
  ```

---

### Class: `WordCounter`

```java
public class WordCounter
```

#### Thuộc tính:

* `HashMap<String, Integer> wordMap`

  * Lưu số lần xuất hiện của từng từ 

#### Vai trò:

* Xử lý toàn bộ logic phân tích văn bản

#### Các phương thức:

---

### `analyze(String text)`

#### Chức năng:

* Phân tích văn bản và đếm tần suất từ

#### Các bước:

1. Chuẩn hóa:

   * `toLowerCase()`
   * `replaceAll(...)`
2. Tách từ:

   ```java
   text.split("\\s+")
   ```
3. Đếm:

   ```java
   wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
   ```

---

### `displayResult()`

#### Chức năng:

* In kết quả thống kê

#### Bao gồm:

* In toàn bộ từ và số lần xuất hiện
* Tìm từ xuất hiện nhiều nhất

---

## 3. Lý do lựa chọn hướng tiếp cận và ưu điểm

### Hướng tiếp cận

* Sử dụng **HashMap (Key-Value)** để lưu trữ tần suất từ
* Mỗi từ được xử lý trong O(1)

### Ưu điểm

* Hiệu năng tốt hơn so với ArrayList (không cần duyệt tìm)
* Code rõ ràng, dễ hiểu
* Phù hợp với bài toán đếm tần suất

### Kiến thức rút ra

* Sử dụng HashMap
* Xử lý chuỗi với Regex
* Tách từ và duyệt mảng
* Duyệt Map với `Map.Entry`

---

## 4. Ví dụ

* **Không có input từ người dùng**
* Dữ liệu được mô phỏng trực tiếp trong chương trình 

### Input (trong code)

```
Hello world. This is a java program. Hello java, hello world.
```

### Output

```
Frequency of occurrence of words:
hello: 3
world: 2
this: 1
is: 1
a: 1
java: 2
program: 1

Most frequent word: hello (3 times)
```

---

## 5. Kết luận

Chương trình đã:

* Phân tích văn bản
* Đếm tần suất từ bằng HashMap
* Xác định từ xuất hiện nhiều nhất

Có thể mở rộng:

* Sắp xếp theo tần suất
* Loại bỏ stop-words
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
