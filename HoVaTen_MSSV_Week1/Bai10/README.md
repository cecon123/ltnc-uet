# Bài 1.10: Tìm số lớn thứ 2 trong mảng

## 1. Tóm tắt ý tưởng chính
Giải thuật tìm giá trị lớn thứ hai trong một mảng số nguyên bằng cách duyệt qua các phần tử một lần duy nhất (**Single-pass traversal**):
* **Kiểm tra điều kiện đầu vào:** Nếu mảng rỗng hoặc có ít hơn 2 phần tử, hàm trả về -1 ngay lập tức.
* **Duyệt mảng:** Sử dụng hai biến `max` và `second` để theo dõi hai giá trị lớn nhất hiện tại.
    * Nếu tìm thấy một số lớn hơn `max`, cập nhật `second` bằng giá trị của `max` cũ và gán `max` mới.
    * Nếu số hiện tại nhỏ hơn `max` nhưng lớn hơn `second`, chỉ cập nhật `second`.
* **Xử lý trùng lặp:** Điều kiện `num != max` đảm bảo số lớn thứ hai phải có giá trị khác biệt hoàn toàn với số lớn nhất.
* **Kết quả:** Trả về `second` nếu tìm thấy, ngược lại trả về -1 (áp dụng cho trường hợp mảng có các phần tử giống hệt nhau).


## 2. Lý do lựa chọn hướng tiếp cận này? Ưu điểm so với các cách khác
Phương pháp duyệt một lần được chọn để đáp ứng yêu cầu tối ưu về độ phức tạp thời gian $O(n)$ và không dùng thư viện sắp xếp:

| Tiêu chí | Sử dụng sắp xếp (Arrays.sort) | **Duyệt một lần (Chọn)** |
| :--- | :--- | :--- |
| **Độ phức tạp** | $O(n \log n)$ | $O(n)$ |
| **Bộ nhớ** | Tùy vào thuật toán sắp xếp (thường là $O(1)$ hoặc $O(n)$). | **Tối ưu nhất** ($O(1)$ space). |
| **Hiệu suất** | Chậm hơn đối với các mảng dữ liệu cực lớn. | **Cực nhanh**, chỉ đọc mỗi phần tử một lần duy nhất. |

**Ưu điểm:** * Không phụ thuộc vào thư viện bên ngoài như `Arrays.sort`, phù hợp với yêu cầu thực hiện thủ công.
* Xử lý tốt các mảng có phần tử trùng nhau hoặc mảng không có phần tử lớn thứ hai hợp lệ.

## 3. Cách chạy chương trình
1. Cấp quyền thực thi cho script (chỉ cần làm lần đầu):
   ```bash
   chmod +x run.sh
   ```
2. Chạy chương trình bằng lệnh:
   ```bash
   ./run.sh
   ```