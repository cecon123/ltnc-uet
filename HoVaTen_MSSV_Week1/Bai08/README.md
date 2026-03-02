# Bài 1.8: Kiểm tra số Palindrome

## 1. Tóm tắt ý tưởng chính
Giải thuật kiểm tra một số nguyên có phải là số Palindrome (số đối xứng) hay không bằng cách so sánh giá trị gốc với giá trị sau khi đảo ngược:
* **Xử lý số âm:** Một số âm không bao giờ là số Palindrome (ví dụ: -121 khi đảo ngược thành 121-, không trùng khớp) nên hàm trả về `false` ngay lập tức.
* **Cơ chế đảo ngược:** Sử dụng kỹ thuật toán học (chia lấy dư và chia nguyên) tương tự bài 1.7 để xây dựng số đảo ngược `rev` từ số gốc `n`.
* **Kiểm soát an toàn:** Tích hợp kiểm tra tràn số (Overflow) trong quá trình đảo ngược để đảm bảo chương trình không bị lỗi khi xử lý các số lớn.
* **So sánh:** Kết quả cuối cùng là phép so sánh công bằng giữa số ban đầu (được lưu tạm trong biến `t`) và số đã đảo ngược `rev`.


## 2. Lý do lựa chọn hướng tiếp cận này? Ưu điểm so với các cách khác
Phương pháp toán học được ưu tiên sử dụng để đáp ứng yêu cầu không dùng thư viện có sẵn và tối ưu hóa tài nguyên:

| Tiêu chí | Chuyển đổi sang Chuỗi (String) | **Sử dụng Toán học (Chọn)** |
| :--- | :--- | :--- |
| **Cách làm** | Đổi số thành chuỗi, đảo chuỗi và so sánh. | Tách từng chữ số và tính toán trực tiếp trên số nguyên. |
| **Bộ nhớ** | Tốn thêm không gian lưu trữ cho đối tượng String. | **Tiết kiệm tối đa**, chỉ dùng vài biến số nguyên ($O(1)$ space). |
| **Tốc độ** | Chậm hơn do chi phí tạo đối tượng và thao tác chuỗi. | **Cực nhanh**, thực hiện trên các phép toán số học cơ bản. |

**Ưu điểm:** * Thực hiện đúng yêu cầu không sử dụng các hàm xử lý chuỗi hoặc thư viện có sẵn.
* Xử lý chính xác các trường hợp đặc biệt: số 0 (là số đối xứng), số có chữ số 0 ở cuối (không đối xứng, ví dụ 1230), và các số âm.

## 3. Cách chạy chương trình
```bash
./run.sh
```