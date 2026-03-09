# Git Commit Guidelines

Khi tạo commit message, hãy tuân thủ nghiêm ngặt các quy tắc sau:

## 1. Cấu trúc Conventional Commits
Sử dụng định dạng: `<type>(<scope>): <description>`

- **feat**: Một tính năng mới.
- **fix**: Sửa lỗi.
- **docs**: Thay đổi tài liệu.
- **style**: Thay đổi định dạng code (không ảnh hưởng logic).
- **refactor**: Tái cấu trúc code (không sửa lỗi cũng không thêm tính năng).
- **perf**: Cải thiện hiệu năng.
- **test**: Thêm hoặc sửa test.
- **chore**: Thay đổi build process, package manager, v.v.
- **ci**: Thay đổi cấu hình CI/CD.

## 2. Quy tắc viết Description
- **Ngôn ngữ**: Tiếng Anh (hoặc Tiếng Việt tùy theo config dự án, ưu tiên Tiếng Anh cho chuyên nghiệp).
- **Thì hiện tại (Imperative mood)**: Sử dụng "add" thay vì "added", "fix" thay vì "fixed".
- **Viết hoa**: Không viết hoa chữ cái đầu của description.
- **Dấu chấm**: Không đặt dấu chấm ở cuối dòng.
- **Độ dài**: Dòng tiêu đề không quá 50 ký tự.

## 3. Nội dung chi tiết (Body) - Nếu cần thiết
- Giải thích **TẠI SAO** thay đổi, không phải **CÁI GÌ** (Code đã thể hiện cái gì rồi).
- Nếu có thay đổi quan trọng về logic (Breaking Change), ghi rõ `BREAKING CHANGE:` ở đầu phần body.

## 4. Ví dụ mẫu
- `feat(auth): add OAuth2 provider support`
- `fix(parser): resolve overflow when handling large malware samples`
- `refactor(utils): simplify string conversion logic in Rust`
