# Bài 9: Triển khai Logging chuyên nghiệp

## 1. Mục tiêu

Bài này tối ưu hệ thống BankSystem bằng cách loại bỏ thói quen ghi log thủ công bằng `System.out.println()` và `System.err.println()`, thay vào đó dùng logging chuyên nghiệp với **SLF4J** và **Logback**.

Sau khi hoàn thành, chương trình có thể:

- ghi log có cấu trúc ra console;
- ghi log đồng thời vào file vật lý `logs/bank-system.log`;
- sử dụng các mức log như `INFO`, `WARN`, `ERROR`;
- dùng parameterized logging với dấu giữ chỗ `{}` thay cho cộng chuỗi;
- kiểm tra việc tạo log thông qua lệnh `mvn test`.

## 2. Cấu hình dependency trong Maven

Trong `pom.xml`, dự án sử dụng hai dependency chính:

```xml
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>${slf4j.version}</version>
</dependency>

<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>${logback.version}</version>
</dependency>
```

`slf4j-api` cung cấp API logging chung. `logback-classic` là implementation thực tế dùng để ghi log ra console và file.

## 3. Cấu hình Logback

File cấu hình nằm tại:

```text
src/main/resources/logback.xml
```

Nội dung chính:

```xml
<configuration>
    <property name="LOG_PATTERN"
              value="%d{yyyy-MM-dd HH:mm:ss} %-5level [%thread] %logger{36} - %msg%n" />

    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>${LOG_PATTERN}</pattern>
        </encoder>
    </appender>

    <appender name="FILE" class="ch.qos.logback.core.FileAppender">
        <file>logs/bank-system.log</file>
        <append>true</append>
        <encoder>
            <pattern>${LOG_PATTERN}</pattern>
        </encoder>
    </appender>

    <root level="INFO">
        <appender-ref ref="CONSOLE" />
        <appender-ref ref="FILE" />
    </root>
</configuration>
```

Ý nghĩa:

- `CONSOLE`: ghi log ra terminal khi chạy chương trình hoặc chạy test.
- `FILE`: ghi log vào file `logs/bank-system.log`.
- `%d{yyyy-MM-dd HH:mm:ss}`: hiển thị thời gian log.
- `%-5level`: hiển thị cấp độ log, ví dụ `INFO`, `WARN`, `ERROR`.
- `%thread`: hiển thị thread đang chạy.
- `%logger{36}`: hiển thị class ghi log.
- `%msg%n`: hiển thị nội dung log và xuống dòng.

## 4. Thay thế System.out.println bằng Logger

Trước khi refactor, code thường ghi log kiểu thủ công:

```java
System.out.println("Deposit completed for account " + accountNumber);
System.err.println("Withdraw failed");
```

Sau khi refactor, mỗi class cần log sẽ khai báo logger:

```java
private static final Logger LOGGER = LoggerFactory.getLogger(CheckingAccount.class);
```

Sau đó ghi log bằng SLF4J:

```java
LOGGER.info("Deposit completed for checking account {}, amount {}", getAccountNumber(), amount);
LOGGER.warn("Rejected savings withdrawal for account {}, amount {}", getAccountNumber(), amount);
LOGGER.error("Transaction failed for account {}", getAccountNumber(), exception);
```

## 5. Các mức log được sử dụng

| Level | Mục đích | Ví dụ trong bài |
|---|---|---|
| `INFO` | Ghi lại các mốc xử lý quan trọng khi hệ thống chạy bình thường | nạp tiền thành công, rút tiền thành công, thêm khách hàng |
| `WARN` | Ghi lại tình huống bất thường nhưng có thể kiểm soát | yêu cầu rút tiền tiết kiệm bị từ chối |
| `ERROR` | Ghi lại lỗi nghiêm trọng hoặc exception cần xử lý | lỗi giao dịch hoặc lỗi dữ liệu |

## 6. Parameterized Logging

Dự án dùng parameterized logging với `{}` thay vì cộng chuỗi.

Không nên viết:

```java
LOGGER.info("Customer " + customerId + " was added");
```

Nên viết:

```java
LOGGER.info("Customer {} was added", customerId);
```

Cách này giúp code dễ đọc hơn và tránh tạo chuỗi không cần thiết khi một mức log không được bật.

## 7. Cấu trúc project

```text
bai9-professional-logging/
├── pom.xml
├── checkstyle.xml
├── README.md
├── .github/
│   └── workflows/
│       └── logging-ci.yml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── bank_system/
│   │   │       ├── Account.java
│   │   │       ├── Bank.java
│   │   │       ├── BankException.java
│   │   │       ├── CheckingAccount.java
│   │   │       ├── Customer.java
│   │   │       ├── InsufficientFundsException.java
│   │   │       ├── InvalidFundingAmountException.java
│   │   │       ├── Main.java
│   │   │       ├── SavingsAccount.java
│   │   │       └── Transaction.java
│   │   └── resources/
│   │       └── logback.xml
│   └── test/
│       └── java/
│           └── bank_system/
│               ├── BankTest.java
│               ├── CheckingAccountTest.java
│               ├── CustomerTest.java
│               ├── LoggingTest.java
│               ├── MainTest.java
│               └── SavingsAccountTest.java
└── logs/
    └── bank-system.log
```

Thư mục `logs/` và file `bank-system.log` sẽ được tạo khi chương trình hoặc test ghi log.

## 8. Cách chạy kiểm thử

Chạy lệnh:

```bash
mvn test
```

Lệnh này sẽ chạy unit test và kích hoạt các dòng log trong quá trình kiểm thử.

Kết quả log trên console có dạng:

```text
2026-05-10 10:15:22 INFO  [main] bank_system.CheckingAccount - Deposit completed for checking account 3001, amount 100.0
2026-05-10 10:15:22 INFO  [main] bank_system.CheckingAccount - Withdraw completed for checking account 3001, amount 50.0
```

Đồng thời, file log được tạo tại:

```text
logs/bank-system.log
```

## 9. Workflow GitHub Actions

Workflow nằm tại:

```text
.github/workflows/logging-ci.yml
```

Workflow chạy khi có `push` hoặc `pull_request`, thực hiện:

```bash
mvn --batch-mode clean test
```

Sau đó upload file log:

```text
logs/bank-system.log
```

làm artifact để có thể kiểm tra lại sau khi workflow kết thúc.

## 10. Kết luận

Bài này hoàn thành yêu cầu triển khai logging chuyên nghiệp bằng SLF4J và Logback. Code đã loại bỏ `System.out.println()` trong luồng xử lý chính, chuyển sang logger có cấu trúc, có cấp độ log rõ ràng và ghi log đồng thời ra console lẫn file vật lý.
