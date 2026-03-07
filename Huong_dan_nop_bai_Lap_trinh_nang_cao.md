# HƯỚNG DẪN NỘP BÀI THỰC HÀNH LẬP TRÌNH NÂNG CAO

## Phạm vi bài nộp

- Mỗi tuần sinh viên nộp các bài thực hành tương ứng với tuần đó.
- Mỗi bài được tổ chức trong một thư mục riêng; chỉ các bài đúng cấu trúc mới được chấm.

---

## Cấu trúc thư mục bắt buộc

Mỗi bài tập phải có cấu trúc:

```
Bai01/
├── src/        # Mã nguồn
├── lib/        # Thư viện (nếu có)
└── run.sh      # Script bash/shell để biên dịch & chạy
```

---

## Định dạng file nộp

- Nén thành file `.zip`
- Đặt tên: `HoVaTen_MSSV_WeekX.zip`

Ví dụ cấu trúc:

```
HoVaTen_MSSV_WeekX/
├── Bai01/
│   ├── src/
│   └── run.sh
├── Bai02/
│   ├── src/
│   └── run.sh
├── ...
└── Bai10/
    ├── src/
    └── run.sh
```

---

## Ví dụ `run.sh` cho Java

```bash
ROOT_DIR=$(pwd)
SRC_DIR="$ROOT_DIR/src"
BUILD_DIR="$ROOT_DIR/build"
mkdir -p "$BUILD_DIR"
javac -d "$BUILD_DIR" "$SRC_DIR"/*.java
java -cp "$BUILD_DIR" Main
```

---

## Lưu ý:

- Tên class `Main` phải trùng với class chứa `main()`
- Không dùng IDE-specific config (IntelliJ, Eclipse, VS Code...)
- Không hard-code đường dẫn tuyệt đối

---

## Yêu cầu môi trường & chấm điểm

- Bài được chạy trên máy giáo viên
- Java: JDK 25
- Giáo viên chỉ chạy: `./run.sh`
- Không chạy được / lỗi khi chạy: 0 điểm

---

## Khuyến nghị (không bắt buộc nhưng nên có)

Thêm `README.md` trong từng bài để mô tả ngắn gọn:

- Tóm tắt ý tưởng chính của lời giải
- Lý do lựa chọn hướng tiếp cận này? Ưu điểm so với các cách khác
- Cách chạy