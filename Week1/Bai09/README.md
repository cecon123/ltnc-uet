# Bài 1.9: Tính tổng chữ số

## 1. Tóm tắt ý tưởng chính
Giải thuật tính tổng các chữ số của một số nguyên $n$ dựa trên các phép toán số học cơ bản để tách chữ số:
* **Cơ chế tách chữ số:** Sử dụng vòng lặp `while` kết hợp với phép chia lấy dư (`n % 10`) để lấy ra chữ số cuối cùng của số nguyên.
* **Xử lý số âm:** Do yêu cầu tính tổng các chữ số, mã nguồn kiểm tra nếu chữ số vừa tách (`pop`) là số âm thì chuyển thành giá trị dương tương ứng trước khi cộng dồn vào biến `sum`.
* **Dịch chuyển số:** Sau mỗi bước, số $n$ được chia nguyên cho 10 (`n /= 10`) để loại bỏ chữ số đã tính cho đến khi $n$ bằng 0.


## 2. Lý do lựa chọn hướng tiếp cận này? Ưu điểm so với các cách khác
Phương pháp toán học trực tiếp được ưu tiên vì tính hiệu quả và không vi phạm quy tắc "không dùng thư viện có sẵn":

| Tiêu chí | Chuyển đổi sang Chuỗi (String) | **Toán học trực tiếp (Chọn)** |
| :--- | :--- | :--- |
| **Cách làm** | Đổi số thành chuỗi, duyệt từng ký tự rồi đổi ngược lại số để cộng. | Sử dụng phép chia `/` và lấy dư `%` để thao tác trực tiếp trên số. |
| **Hiệu suất** | Tốn chi phí bộ nhớ để cấp phát đối tượng chuỗi mới. | **Tối ưu nhất**, chỉ sử dụng các biến số nguyên cơ bản ($O(1)$ space). |
| **Xử lý số âm** | Phải xử lý thêm ký tự `-` trong chuỗi. | **Xử lý đơn giản** bằng cách lấy giá trị tuyệt đối của từng chữ số tách được. |

**Ưu điểm:** * Tiết kiệm tài nguyên hệ thống do không cần tạo thêm các đối tượng phức tạp như String hay Array.
* Xử lý chính xác các trường hợp đặc biệt: số 0, số âm, và các số nguyên lớn có nhiều chữ số.

## 3. Cách chạy chương trình
1. Cấp quyền thực thi cho script (chỉ cần làm lần đầu):
   ```bash
   chmod +x run.sh
   ```
2. Chạy chương trình bằng lệnh:
   ```bash
   ./run.sh
   ```