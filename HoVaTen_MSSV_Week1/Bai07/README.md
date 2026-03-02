# Bài 1.7: Đảo ngược số nguyên

## 1. Tóm tắt ý tưởng chính
Giải thuật thực hiện đảo ngược thứ tự các chữ số của một số nguyên $n$ bằng cách sử dụng các phép toán số học cơ bản:
* **Cơ chế đảo ngược:** Sử dụng vòng lặp `while` để liên tục tách chữ số cuối cùng của $n$ (bằng phép chia lấy dư `% 10`) và thêm nó vào biến kết quả `rev` (bằng cách nhân `rev` với 10 và cộng chữ số vừa tách).
* **Xử lý tràn số (Overflow):** Vì giá trị đảo ngược có thể vượt quá phạm vi của kiểu `int` ($[-2^{31}, 2^{31} - 1]$), chương trình kiểm tra điều kiện tràn số trước mỗi phép nhân. Nếu kết quả dự kiến vượt quá `Integer.MAX_VALUE` hoặc nhỏ hơn `Integer.MIN_VALUE`, hàm sẽ trả về 0.
* **Không sử dụng thư viện:** Toàn bộ quá trình xử lý được thực hiện thủ công thông qua tính toán số học, không chuyển đổi sang kiểu chuỗi (String).


## 2. Lý do lựa chọn hướng tiếp cận này? Ưu điểm so với các cách khác
Phương pháp sử dụng toán học được lựa chọn vì tính tối ưu và đáp ứng đúng yêu cầu của đề bài:

| Tiêu chí | Chuyển sang Chuỗi (String) | Toán học (Đang dùng) |
| :--- | :--- | :--- |
| **Cách làm** | Chuyển `int` -> `String`, đảo ngược chuỗi, rồi chuyển lại `int`. | Sử dụng phép chia `/` và lấy dư `%` để xử lý trực tiếp. |
| **Hiệu suất** | Tốn thêm bộ nhớ để tạo đối tượng chuỗi, xử lý chậm hơn. | **Tối ưu nhất**, chỉ sử dụng các biến số nguyên đơn giản ($O(1)$ space). |
| **Xử lý tràn số** | Khó kiểm soát tràn số khi đang đảo ngược. | **Dễ dàng kiểm soát** ngay trong quá trình tính toán. |

**Ưu điểm:** * Đạt hiệu suất cao về cả thời gian xử lý và bộ nhớ.
* Xử lý triệt để các trường hợp đặc biệt: số âm, số có chữ số 0 ở cuối (như 120 đảo thành 21), và đặc biệt là các số gây tràn dữ liệu kiểu `int`.

## 3. Cách chạy chương trình
```bash
./run.sh
```