# Bài 6: CI/CD Pipeline Optimization & Caching

## 1. Tóm tắt ý tưởng chính của lời giải

Bài này tối ưu pipeline CI/CD cho dự án Maven bằng cách bật **dependency caching** trong GitHub Actions.

Ở các lần chạy CI thông thường, Maven phải tải các thư viện từ Maven Central về thư mục local repository. Việc này làm workflow mất thêm thời gian, đặc biệt khi dự án có nhiều dependency như JUnit Jupiter, Logback, SLF4J, Checkstyle hoặc JaCoCo.

Giải pháp là sử dụng `actions/setup-java@v4` với tham số:

```yaml
cache: maven
cache-dependency-path: pom.xml
```

Khi đó GitHub Actions sẽ lưu lại Maven dependencies sau lần chạy đầu tiên. Ở các lần chạy sau, nếu `pom.xml` không thay đổi đáng kể, workflow có thể khôi phục dependency từ cache thay vì tải lại toàn bộ từ Maven Central.

## 2. Thiết kế hệ thống

Dự án vẫn giữ cấu trúc Maven chuẩn:

```text
bai6-cicd-caching/
├── pom.xml
├── README.md
├── .github/
│   └── workflows/
│       └── maven-ci.yml
└── src/
    ├── main/
    │   ├── java/
    │   │   └── bank_system/
    │   │       ├── Account.java
    │   │       ├── Bank.java
    │   │       ├── BankException.java
    │   │       ├── CheckingAccount.java
    │   │       ├── Customer.java
    │   │       ├── InsufficientFundsException.java
    │   │       ├── InvalidFundingAmountException.java
    │   │       ├── SavingsAccount.java
    │   │       └── Transaction.java
    │   └── resources/
    │       └── logback.xml
    └── test/
        └── java/
            └── bank_system/
                ├── BankTest.java
                ├── CheckingAccountTest.java
                ├── CustomerTest.java
                └── SavingsAccountTest.java
```

### 2.1. File `pom.xml`

File `pom.xml` quản lý dependency và plugin của dự án, bao gồm:

- JUnit Jupiter để chạy unit test.
- SLF4J và Logback để ghi log.
- Maven Surefire Plugin để chạy test với JUnit 5.
- JaCoCo Maven Plugin để đo code coverage và fail build nếu coverage dưới 80%.

### 2.2. File `.github/workflows/maven-ci.yml`

Workflow chính của bài này nằm trong file:

```text
.github/workflows/maven-ci.yml
```

Nội dung quan trọng:

```yaml
- name: Set up JDK with Maven cache
  uses: actions/setup-java@v4
  with:
    distribution: temurin
    java-version: '17'
    cache: maven
    cache-dependency-path: pom.xml
```

Trong đó:

| Thành phần | Ý nghĩa |
|---|---|
| `actions/setup-java@v4` | Cài đặt JDK cho runner |
| `distribution: temurin` | Dùng bản OpenJDK Temurin |
| `java-version: '17'` | Chạy project bằng Java 17 |
| `cache: maven` | Bật cache Maven dependencies |
| `cache-dependency-path: pom.xml` | Tạo cache key dựa trên nội dung `pom.xml` |

## 3. Workflow GitHub Actions

File workflow hoàn chỉnh:

```yaml
name: Maven CI with Dependency Cache

on:
  push:
    branches:
      - main
      - master
  pull_request:
    branches:
      - main
      - master

jobs:
  build:
    name: Build, test, coverage, and cache Maven dependencies
    runs-on: ubuntu-latest

    steps:
      - name: Checkout source code
        uses: actions/checkout@v4

      - name: Set up JDK with Maven cache
        uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: '17'
          cache: maven
          cache-dependency-path: pom.xml

      - name: Show Java and Maven versions
        run: |
          java -version
          mvn -version

      - name: Run tests, coverage check, and package
        run: mvn --batch-mode clean verify

      - name: Upload JaCoCo coverage report
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: jacoco-coverage-report
          path: target/site/jacoco/

      - name: Upload jar artifact
        if: success()
        uses: actions/upload-artifact@v4
        with:
          name: application-jar
          path: target/*.jar
```

## 4. Lý do lựa chọn hướng tiếp cận và ưu điểm

### Hướng tiếp cận

Thay vì tự cấu hình `actions/cache`, bài này sử dụng sẵn tính năng cache của `actions/setup-java@v4`.

Cách này ngắn gọn hơn vì chỉ cần thêm:

```yaml
cache: maven
```

vào bước cài đặt JDK.

### Ưu điểm

- Giảm thời gian tải Maven dependencies ở các lần chạy sau.
- Workflow dễ đọc, dễ bảo trì.
- Không cần tự viết cache key phức tạp.
- Cache tự phụ thuộc vào `pom.xml`, nên khi dependency thay đổi thì cache cũng được cập nhật phù hợp.
- Có thể kết hợp với JaCoCo, unit test, package và upload artifact trong cùng pipeline.

### Kiến thức rút ra

Qua bài này, có thể hiểu rõ hơn:

- CI/CD không chỉ là tự động build và test, mà còn cần tối ưu hiệu năng.
- Maven dependency caching giúp giảm thời gian workflow.
- Execution logs trong GitHub Actions có thể dùng để kiểm tra cache hit/cache miss.
- `mvn clean verify` phù hợp để chạy test, kiểm tra coverage và package trong pipeline Maven.

## 5. Ví dụ kiểm tra cache hoạt động

### Lần push thứ nhất

Thực hiện commit và push:

```bash
git add .
git commit -m "Add Maven dependency caching"
git push
```

Ở lần chạy đầu tiên, cache có thể chưa tồn tại. Trong log của bước **Set up JDK with Maven cache**, có thể thấy trạng thái tương tự:

```text
Cache not found for input keys
```

Maven sẽ tải dependency từ Maven Central.

### Lần push thứ hai

Sửa nhẹ README hoặc thêm comment rồi push tiếp:

```bash
git add .
git commit -m "Verify Maven cache restore"
git push
```

Ở lần chạy thứ hai, mở log của bước **Set up JDK with Maven cache**. Nếu cache hoạt động, log có thể xuất hiện nội dung tương tự:

```text
Cache restored from key
```

Trong bước Maven build, số dòng kiểu sau sẽ giảm đi:

```text
Downloading from central: ...
Downloaded from central: ...
```

### Bảng ghi nhận kết quả thực nghiệm

Có thể ghi lại thời gian chạy thực tế như sau:

| Lần chạy | Trạng thái cache | Thời gian workflow |
|---|---|---|
| Lần 1 | Cache miss | Ghi thời gian thực tế trên GitHub Actions |
| Lần 2 | Cache hit | Ghi thời gian thực tế trên GitHub Actions |

Kết quả mong đợi là lần chạy thứ hai nhanh hơn vì dependency được lấy từ cache.

## 6. Kết luận

Bài 6 hoàn thành bằng cách tối ưu workflow GitHub Actions thông qua Maven dependency caching.

Cấu hình chính là:

```yaml
cache: maven
cache-dependency-path: pom.xml
```

Sau khi áp dụng, pipeline vẫn đảm bảo chạy đầy đủ:

- checkout source code;
- cài JDK;
- khôi phục Maven cache;
- chạy test;
- kiểm tra JaCoCo coverage;
- build package;
- upload artifact.

Điểm khác biệt là Maven dependencies có thể được lấy từ cache ở các lần chạy sau, giúp giảm thời gian build và cải thiện hiệu quả CI/CD.

## 7. Cách chạy chương trình

Chạy toàn bộ kiểm tra ở local:

```bash
mvn clean verify
```

Chạy test:

```bash
mvn test
```

Chạy package:

```bash
mvn package
```

Trên GitHub Actions, workflow tự động chạy khi có:

- `push` vào nhánh `main` hoặc `master`;
- `pull_request` vào nhánh `main` hoặc `master`.
