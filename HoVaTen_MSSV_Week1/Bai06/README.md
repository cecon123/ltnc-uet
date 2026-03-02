# Bài 1.6: Kiểm tra số nguyên tố

## 1. Tóm tắt ý tưởng chính
Giải thuật kiểm tra một số nguyên $n$ có phải là số nguyên tố hay không bằng cách tối ưu hóa quá trình tìm ước số:
* **Loại trừ nhanh:** Các số nhỏ hơn hoặc bằng 1 không phải số nguyên tố. Số 2 là số nguyên tố chẵn duy nhất.
* **Lọc số chẵn:** Loại bỏ tất cả các số chẵn lớn hơn 2 ngay từ đầu để giảm số vòng lặp.
* **Duyệt đến căn bậc hai:** Thay vì duyệt đến $n$, vòng lặp chỉ chạy từ 3 đến $\sqrt{n}$ với bước nhảy là 2 (chỉ kiểm tra các số lẻ). Nếu $n$ chia hết cho bất kỳ số lẻ nào trong khoảng này, $n$ không phải là số nguyên tố.


## 2. Lý do lựa chọn hướng tiếp cận này? Ưu điểm so với các cách khác
Cách tiếp cận này được chọn vì đáp ứng hoàn hảo yêu cầu về hiệu suất của đề bài:

| Tiêu chí | Duyệt từ 2 đến $n-1$ | **Duyệt đến $\sqrt{n}$ và lọc số chẵn (Chọn)** |
| :--- | :--- | :--- |
| **Độ phức tạp** | $O(n)$ | $O(\sqrt{n})$ |
| **Hiệu suất** | Rất chậm khi $n$ lớn (ví dụ: `Integer.MAX_VALUE`). | **Cực nhanh**, đáp ứng yêu cầu tối ưu hơn $O(n)$. |
| **Số lần lặp** | Khoảng $2 \cdot 10^9$ lần với số nguyên lớn nhất. | Chỉ khoảng $46,340$ lần và giảm thêm một nửa nhờ lọc số lẻ. |

**Ưu điểm:** * Đạt độ phức tạp $O(\sqrt{n})$, tối ưu hơn hẳn so với cách duyệt tuyến tính thông thường.
* Không sử dụng thư viện có sẵn, phù hợp với yêu cầu thực hiện thủ công để hiểu bản chất thuật toán.
* Xử lý chính xác các trường hợp đặc biệt như số âm, số 0, số 1 và các số nguyên cực lớn.

## 3. Cách chạy chương trình
```bash
./run.sh
```