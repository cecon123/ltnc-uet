# Bài 1.5: Xây dựng ước số chung lớn nhất

## 1. Tóm tắt ý tưởng chính
Giải thuật tìm ước số chung lớn nhất (GCD) của hai số nguyên $a$ và $b$ dựa trên **Thuật toán Euclid**:
* **Xử lý số âm:** Mã nguồn sử dụng `Math.abs()` để chuyển đổi các tham số đầu vào thành số dương, đảm bảo tính đúng đắn của kết quả vì ước chung lớn nhất không phụ thuộc vào dấu của số.
* **Cơ chế lặp:** Sử dụng vòng lặp `while` để thực hiện phép chia lấy dư liên tiếp cho đến khi số dư bằng 0. 
* **Kết quả:** Giá trị cuối cùng của biến `a` sau khi vòng lặp kết thúc chính là ước chung lớn nhất cần tìm.


## 2. Lý do lựa chọn hướng tiếp cận này? Ưu điểm so với các cách khác
Thuật toán Euclid là phương pháp tiêu chuẩn và hiệu quả nhất cho bài toán này:

| Tiêu chí | Duyệt tuần tự (Brute Force) | Thuật toán Euclid (Đang dùng) |
| :--- | :--- | :--- |
| **Cách thức** | Thử chia lần lượt các số từ 1 đến $\min(a, b)$. | Sử dụng tính chất của phép chia lấy dư để thu hẹp khoảng cách. |
| **Độ phức tạp** | $O(n)$ | $O(\log(\min(a, b)))$ |
| **Hiệu suất** | Chậm khi các số đầu vào có giá trị lớn. | **Cực nhanh**, trả về kết quả gần như tức thì với kiểu dữ liệu `int`. |

**Ưu điểm:** * Tối ưu hóa số bước tính toán so với việc duyệt vòng lặp thông thường.
* Xử lý chính xác các trường hợp đặc biệt như khi một trong hai số bằng 0 hoặc khi gặp số nguyên âm.

## 3. Cách chạy chương trình
1. Cấp quyền thực thi cho script (chỉ cần làm lần đầu):
   ```bash
   chmod +x run.sh
   ```
2. Chạy chương trình bằng lệnh:
   ```bash
   ./run.sh
   ```