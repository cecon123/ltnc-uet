# Bài 4: Kiểm thử đa hệ điều hành với Matrix Strategy

## 1. Tóm tắt ý tưởng chính

Bài này mở rộng quy trình CI/CD của một dự án Maven bằng cách sử dụng **Matrix Strategy** trong GitHub Actions.

Thay vì chỉ chạy build trên một hệ điều hành, workflow sẽ chạy song song trên:

- `ubuntu-latest`
- `windows-latest`
- `macos-latest`

Mục tiêu là phát hiện lỗi kiểu “It works on my machine”, đặc biệt là lỗi hard-code đường dẫn bằng dấu `/` hoặc `\`.

## 2. Cấu trúc dự án

```text
bai4-matrix-strategy/
├── .github/workflows/maven-ci.yml
├── pom.xml
├── README.md
├── src/main/java/bank_system/PathService.java
├── src/test/java/bank_system/PathCompatibilityTest.java
└── src/test/resources/sample-data.txt
```

## 3. Workflow GitHub Actions

File workflow nằm tại:

```text
.github/workflows/maven-ci.yml
```

Phần quan trọng nhất là cấu hình matrix:

```yaml
strategy:
  fail-fast: false
  matrix:
    os:
      - ubuntu-latest
      - windows-latest
      - macos-latest
```

Workflow sử dụng:

```yaml
runs-on: ${{ matrix.os }}
```

Vì vậy GitHub Actions sẽ tự tạo ba job build tương ứng với ba hệ điều hành.

## 4. Cách tạo lỗi để quan sát pipeline

Một lỗi thường gặp là hard-code đường dẫn theo Windows:

```java
Path path = Path.of("src\\test\\resources\\sample-data.txt");
```

Hoặc hard-code bằng chuỗi:

```java
File file = new File("src\\test\\resources\\sample-data.txt");
```

Cách viết này có thể chạy đúng trên Windows nhưng lỗi trên Ubuntu hoặc macOS.

Khi push code lên GitHub, matrix pipeline sẽ cho thấy job nào bị lỗi. Có thể mở tab **Actions** để xem execution logs và xác định lỗi nằm ở hệ điều hành nào.

## 5. Cách refactor đúng

Trong bài này, code được refactor bằng `java.nio.file.Path`:

```java
Path path = Path.of("src", "test", "resources", "sample-data.txt");
```

Cách này không phụ thuộc dấu phân cách đường dẫn của từng hệ điều hành.

File chính minh họa là:

```text
src/main/java/bank_system/PathService.java
```

Trong đó phương thức `getSampleDataPath()` tạo đường dẫn bằng `Path.of(...)`, còn `sampleDataExists()` kiểm tra file bằng `Files.exists(...)`.

## 6. Unit Test

File test:

```text
src/test/java/bank_system/PathCompatibilityTest.java
```

Test kiểm tra rằng file:

```text
src/test/resources/sample-data.txt
```

có thể được tìm thấy bằng `Path.of(...)` trên mọi hệ điều hành.

## 7. Upload artifact

Sau khi chạy:

```bash
mvn --batch-mode package
```

Maven tạo file `.jar` trong thư mục `target/`.

Workflow upload file `.jar` bằng action:

```yaml
- name: Upload jar artifact
  uses: actions/upload-artifact@v4
  with:
    name: bank-system-jar-${{ matrix.os }}
    path: target/*.jar
```

Artifact được đặt tên riêng theo từng hệ điều hành, ví dụ:

```text
bank-system-jar-ubuntu-latest
bank-system-jar-windows-latest
bank-system-jar-macos-latest
```

## 8. Cách chạy chương trình

Chạy test ở local:

```bash
mvn clean test
```

Build package:

```bash
mvn clean package
```

Chạy toàn bộ quy trình trên GitHub Actions bằng cách push code:

```bash
git add .
git commit -m "Add matrix strategy workflow"
git push
```

## 9. Kết luận

Matrix Strategy giúp kiểm thử dự án Maven trên nhiều hệ điều hành, từ đó phát hiện sớm các lỗi phụ thuộc môi trường.

Sau khi refactor code bằng `Path.of(...)`, Unit Test có thể chạy thành công trên Ubuntu, Windows và macOS.
