# Bài 8: Đóng gói sản phẩm thực thi

## 1. Mục tiêu

Bài này cấu hình vòng đời Maven để tạo ra một file `.jar` có thể chạy trực tiếp bằng terminal, không cần mở IDE.

Chương trình được đóng gói bằng `maven-jar-plugin` và chỉ định class chính là:

```text
bank_system.Main
```

Sau khi build, ứng dụng có thể chạy bằng:

```bash
java -jar target/bank-system-executable-1.0-SNAPSHOT.jar
```

## 2. Cấu hình Maven

Trong `pom.xml`, plugin chính được thêm vào là `maven-jar-plugin`:

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-jar-plugin</artifactId>
    <version>3.3.0</version>
    <configuration>
        <archive>
            <manifest>
                <addClasspath>true</addClasspath>
                <classpathPrefix>lib/</classpathPrefix>
                <mainClass>bank_system.Main</mainClass>
            </manifest>
        </archive>
    </configuration>
</plugin>
```

Ý nghĩa:

- `mainClass`: khai báo class chứa phương thức `public static void main(String[] args)`.
- `addClasspath`: thêm thông tin classpath vào manifest để jar tìm được thư viện runtime.
- `classpathPrefix`: chỉ định thư mục chứa dependency là `target/lib`.

Dự án cũng dùng `maven-dependency-plugin` để copy các dependency runtime vào `target/lib` trong pha `package`.

## 3. Class Main

File chạy chính nằm tại:

```text
src/main/java/bank_system/Main.java
```

Class này tạo dữ liệu mẫu cho hệ thống ngân hàng, thực hiện một số giao dịch và in kết quả ra terminal.

## 4. Cách build

Chạy lệnh:

```bash
mvn clean package
```

Lệnh này thực hiện các bước chính:

1. Xóa thư mục `target` cũ.
2. Biên dịch source code.
3. Chạy unit test.
4. Đóng gói chương trình thành file `.jar`.
5. Copy dependency runtime vào `target/lib`.

## 5. Cách chạy chương trình

Sau khi build thành công, chạy:

```bash
java -jar target/bank-system-executable-1.0-SNAPSHOT.jar
```

Kết quả mong đợi:

```text
=== BANK SYSTEM DEMO ===
So CMND: 123456789. Ho ten: Nguyen Van A.

Lich su giao dich cua tai khoan 1001:
- Kieu giao dich: Nap tien vang lai...

Lich su giao dich cua tai khoan 2001:
- Kieu giao dich: Nap tien tiet kiem...
```

## 6. Ý nghĩa thư mục target

Thư mục `target` là thư mục Maven tự sinh ra sau khi build.

Một số thành phần quan trọng:

```text
target/
├── classes/
├── test-classes/
├── lib/
├── surefire-reports/
├── site/jacoco/
└── bank-system-executable-1.0-SNAPSHOT.jar
```

Trong đó:

- `classes`: chứa file `.class` của source chính.
- `test-classes`: chứa file `.class` của unit test.
- `lib`: chứa dependency runtime cần cho chương trình.
- `surefire-reports`: chứa báo cáo unit test.
- `site/jacoco`: chứa báo cáo coverage nếu chạy `mvn verify`.
- file `.jar`: sản phẩm thực thi cuối cùng.

## 7. Ý nghĩa pha package trong Maven

Maven lifecycle có các pha chính:

```text
validate -> compile -> test -> package -> verify -> install -> deploy
```

Pha `package` dùng để đóng gói code đã biên dịch thành artifact, ví dụ file `.jar` đối với project Java.

## 8. Kết luận

Bài này hoàn thành yêu cầu đóng gói ứng dụng Java thành sản phẩm thực thi. Sau khi chạy `mvn clean package`, người dùng có thể khởi chạy chương trình độc lập bằng `java -jar` mà không cần IDE.
