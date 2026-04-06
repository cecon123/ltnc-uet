# Bài 1: Phép chia an toàn

## 1. Tóm tắt ý tưởng chính của lời giải

Chương trình đọc hai số nguyên `a` và `b` từ bàn phím bằng `Scanner`, sau đó thực hiện phép chia nguyên `a / b`.

Để chương trình hoạt động an toàn, lời giải sử dụng cơ chế xử lý ngoại lệ của Java:

* Bắt `InputMismatchException` khi người dùng nhập dữ liệu không phải số nguyên.
* Bắt `ArithmeticException` khi thực hiện phép chia cho `0`.
* Dùng khối `finally` để đảm bảo chương trình luôn in ra dòng `Program finished.` dù có phát sinh lỗi hay không.

Đây là một lời giải ngắn gọn, đúng yêu cầu đề bài và thể hiện rõ cách kết hợp giữa nhập liệu và xử lý ngoại lệ trong Java.

## 2. Thiết kế hệ thống

Vì chương trình chỉ gồm một lớp duy nhất nên cấu trúc rất đơn giản.

### Lớp `Main`

```java
public class Main
```

#### Vai trò

* Là lớp chứa hàm `main`, điểm bắt đầu chạy của chương trình.
* Thực hiện toàn bộ luồng xử lý: nhập dữ liệu, tính toán, bắt lỗi và kết thúc chương trình.

#### Thành phần chính

* `Scanner sc = new Scanner(System.in);`

  * Dùng để đọc 2 số nguyên từ bàn phím.

* Khối `try`

  * Đọc hai giá trị `a`, `b`.
  * Tính `a / b`.
  * In kết quả nếu phép chia hợp lệ.

* Khối `catch (InputMismatchException e)`

  * Xử lý trường hợp dữ liệu nhập vào không phải số nguyên.
  * In thông báo: `Invalid input`.

* Khối `catch (ArithmeticException e)`

  * Xử lý trường hợp chia cho `0`.
  * In thông báo: `Division by zero`.

* Khối `finally`

  * Luôn được thực hiện.
  * In thông báo: `Program finished.`
  * Đóng luồng nhập bằng `sc.close()`.

## 3. Lý do lựa chọn hướng tiếp cận và ưu điểm

### Hướng tiếp cận

Bài toán được giải theo hướng trực tiếp:

* Dùng `Scanner` để nhập dữ liệu từ bàn phím.
* Dùng phép chia nguyên của Java để tính kết quả.
* Dùng `try-catch-finally` để kiểm soát các tình huống lỗi có thể xảy ra trong quá trình nhập và tính toán.

### Ưu điểm

* Cấu trúc ngắn gọn, dễ hiểu, phù hợp với bài tập nhập môn về ngoại lệ.
* Xử lý đúng hai lỗi quan trọng nhất của bài:

  * nhập sai kiểu dữ liệu
  * chia cho 0
* Đảm bảo chương trình luôn có thông báo kết thúc nhờ `finally`.
* Phù hợp với yêu cầu đề bài và dễ mở rộng nếu sau này cần thêm các loại kiểm tra khác.

### Kiến thức rút ra

* Cách sử dụng `Scanner` để nhập dữ liệu kiểu số nguyên.
* Cách bắt ngoại lệ bằng `try-catch` trong Java.
* Sự khác nhau giữa lỗi nhập liệu (`InputMismatchException`) và lỗi tính toán (`ArithmeticException`).
* Vai trò của `finally` trong việc đảm bảo một đoạn lệnh luôn được thực hiện.

## 4. Ví dụ

### Ví dụ 1: Nhập hợp lệ

**Input**

```text
10 2
```

**Output**

```text
5
Program finished.
```

### Ví dụ 2: Chia cho 0

**Input**

```text
10 0
```

**Output**

```text
Division by zero
Program finished.
```

### Ví dụ 3: Nhập sai kiểu dữ liệu

**Input**

```text
10 a
```

**Output**

```text
Invalid input
Program finished.
```

## 5. Kết luận

Bài toán được giải bằng một chương trình Java đơn giản với một lớp `Main`, trong đó kết hợp giữa nhập dữ liệu từ bàn phím và xử lý ngoại lệ.

Lời giải đáp ứng đúng yêu cầu của đề:

* đọc hai số nguyên
* thực hiện phép chia nguyên
* xử lý lỗi nhập sai dữ liệu
* xử lý lỗi chia cho 0
* luôn in thông báo kết thúc chương trình

Đây là một ví dụ cơ bản nhưng quan trọng để làm quen với cơ chế exception handling trong Java.

## 6. Cách chạy chương trình

1. Cấp quyền thực thi cho script:
  ```bash
  chmod +x run.sh
  ```

2. Chạy chương trình:
  ```bash
  ./run.sh
  ```
