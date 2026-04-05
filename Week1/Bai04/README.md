# Bài 1.4: Fibonacci

## 1. Tóm tắt ý tưởng chính
Giải thuật sử dụng phương pháp lăặ để tính số Fibonacci thứ $n$:
* **Xử lý biên:** Kiểm tra nếu $n < 0$ thì trả về -1 theo yêu cầu đề bài.
* **Tính toán:** Sử dụng vòng lặp từ 2 đến $n$ với hai biến phụ `f0` và `f1` để lưu giữ hai số Fibonacci liền kề trước đó. Điều này giúp tính toán số tiếp theo mà không cần dùng đến đệ quy.
* **Kiểm tra tràn số:** Trước mỗi phép cộng, chương trình kiểm tra điều kiện `Long.MAX_VALUE - f1 < f0`. Nếu đúng, nghĩa là kết quả sẽ vượt quá giới hạn của kiểu `long`, hàm sẽ trả về `Long.MAX_VALUE`.

## 2. Lý do lựa chọn hướng tiếp cận này
Có nhiều cách để tính dãy Fibonacci, nhưng phương pháp lặp được chọn nhờ tính tối ưu vượt trội:

| Phương pháp | Độ phức tạp thời gian | Độ phức tạp không gian | Nhận xét |
| :--- | :--- | :--- | :--- |
| **Đệ quy** | $O(2^n)$ | $O(n)$ | Rất chậm khi $n$ lớn, dễ gây lỗi tràn bộ nhớ (Stack Overflow). |
| **Quy hoạch động** | $O(n)$ | $O(n)$ | Nhanh nhưng tốn bộ nhớ để lưu trữ mảng kết quả. |
| **Vòng lặp (Chọn)** | $O(n)$ | $O(1)$ | **Tối ưu nhất:** Tốc độ nhanh và sử dụng bộ nhớ cực thấp (chỉ tốn vài biến đơn). |

**Ưu điểm:** Phương pháp này đảm bảo chương trình chạy ổn định và chính xác ngay cả khi $n$ đạt tới giới hạn 100, đồng thời xử lý tốt vấn đề tràn dữ liệu của kiểu `long`.

## 3. Cách chạy chương trình
1. Cấp quyền thực thi cho script (chỉ cần làm lần đầu):
   ```bash
   chmod +x run.sh
   ```
2. Chạy chương trình bằng lệnh:
   ```bash
   ./run.sh
   ```