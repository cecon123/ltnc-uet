# Bài 2: Sao chép tệp văn bản

## 1. Tóm tắt ý tưởng chính của lời giải

Chương trình thực hiện sao chép nội dung từ một tệp nguồn sang một tệp đích theo từng dòng.

Người dùng nhập vào:
- đường dẫn tệp nguồn
- đường dẫn tệp đích

Sau đó chương trình:
- dùng `FileReader` kết hợp `BufferedReader` để đọc dữ liệu từ tệp nguồn theo từng dòng
- dùng `FileWriter` kết hợp `PrintWriter` để ghi từng dòng sang tệp đích
- đếm số dòng đã sao chép thành công
- xử lý các lỗi liên quan đến tệp và lỗi nhập/xuất
- đóng các luồng trong khối `finally`

Đây là cách tiếp cận đơn giản, rõ ràng và phù hợp với yêu cầu của bài.

## 2. Thiết kế hệ thống

Vì chương trình chỉ có một lớp duy nhất, toàn bộ luồng xử lý được đặt trong lớp `Main`.

### Lớp `Main`

```java
public class Main
```

#### Vai trò
- Chứa hàm `main`
- Điều khiển toàn bộ quá trình nhập đường dẫn, mở tệp, sao chép nội dung, đếm số dòng, xử lý lỗi và đóng tài nguyên

#### Thành phần chính trong chương trình

- `Scanner sc`
  - dùng để nhập đường dẫn tệp nguồn và tệp đích từ bàn phím

- `FileReader fr`
  - dùng để mở tệp nguồn dưới dạng luồng ký tự

- `BufferedReader br`
  - dùng để đọc tệp nguồn theo từng dòng bằng `readLine()`

- `FileWriter fw`
  - dùng để mở hoặc tạo tệp đích để ghi dữ liệu

- `PrintWriter pw`
  - dùng để ghi từng dòng văn bản sang tệp đích

- `int lineCount`
  - dùng để đếm số dòng đã sao chép

#### Logic xử lý

1. Tạo `Scanner` để nhập đường dẫn.
2. Mở tệp nguồn bằng `FileReader`.
3. Bọc `FileReader` bằng `BufferedReader` để đọc từng dòng.
4. Mở tệp đích bằng `FileWriter`.
5. Bọc `FileWriter` bằng `PrintWriter` để ghi dữ liệu.
6. Dùng vòng lặp:
   - đọc từng dòng từ tệp nguồn
   - ghi dòng đó sang tệp đích
   - tăng biến đếm số dòng
7. Nếu hoàn tất, in thông báo sao chép thành công và tổng số dòng.
8. Nếu có lỗi:
   - `FileNotFoundException`: báo không tìm thấy tệp
   - `IOException`: báo lỗi nhập/xuất
9. Cuối cùng đóng các tài nguyên trong `finally`.

## 3. Lý do lựa chọn hướng tiếp cận và ưu điểm

### Hướng tiếp cận

Bài làm sử dụng các lớp xử lý tệp ký tự cơ bản của Java:
- `FileReader` + `BufferedReader` để đọc
- `FileWriter` + `PrintWriter` để ghi

Dữ liệu được xử lý theo từng dòng nên phù hợp với yêu cầu sao chép tệp văn bản.

### Ưu điểm

- Cài đặt ngắn gọn, dễ hiểu
- Đọc và ghi theo từng dòng nên sát với yêu cầu đề bài
- Có đếm số dòng đã sao chép
- Có xử lý lỗi khi không tìm thấy tệp hoặc khi xảy ra lỗi nhập/xuất
- Có đóng tài nguyên trong `finally` để tránh rò rỉ tài nguyên

### Kiến thức rút ra

Qua bài này có thể rèn luyện các nội dung sau:
- sử dụng luồng đọc/ghi tệp văn bản trong Java
- đọc dữ liệu theo từng dòng với `BufferedReader`
- ghi dữ liệu với `PrintWriter`
- bắt ngoại lệ `FileNotFoundException` và `IOException`
- quản lý tài nguyên bằng `finally`

## 4. Ví dụ

### Input

Người dùng nhập từ bàn phím:

```text
Enter source path: input.txt
Enter destination path: output.txt
```

Giả sử tệp `input.txt` có nội dung:

```text
Hello
Java
File copy
```

### Output

```text
Copying successful
Total lines: 3
```

### Kết quả sau khi chạy

Tệp `output.txt` sẽ có nội dung:

```text
Hello
Java
File copy
```

### Trường hợp lỗi

Nếu tệp nguồn không tồn tại, chương trình sẽ in dạng thông báo như sau:

```text
File not found: input.txt (The system cannot find the file specified)
```

Nếu xảy ra lỗi nhập/xuất khác, chương trình sẽ in:

```text
Error: ...
```

## 5. Kết luận

Bài toán đã được giải bằng cách đọc nội dung tệp nguồn theo từng dòng và ghi lại nguyên vẹn sang tệp đích. Chương trình đáp ứng các chức năng chính:
- nhập đường dẫn tệp
- sao chép nội dung tệp văn bản
- đếm số dòng đã sao chép
- xử lý lỗi cơ bản
- đóng tài nguyên sau khi thực hiện

Đây là một bài thực hành tốt để làm quen với xử lý tệp và ngoại lệ trong Java.

## 6. Cách chạy chương trình

1. Cấp quyền thực thi cho script:
  ```bash
  chmod +x run.sh
  ```

2. Chạy chương trình:
  ```bash
  ./run.sh
  ```
