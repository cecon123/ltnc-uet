# Bài 2: Super Hero - Đa kế thừa Interface

## Tóm tắt ý tưởng chính

Bài này minh họa cách Java giải quyết **vấn đề đa kế thừa** thông qua **Interface**. Khi một lớp cần nhiều hành vi khác nhau (bay, bơi, chiến đấu), Java dùng interface thay vì cho phép kế thừa nhiều lớp.

## Lời giải

### Kiến trúc chương trình

```mermaid
classDiagram
    class CanFly {
        <<interface>>
        +fly() void
    }
    
    class CanSwim {
        <<interface>>
        +swim() void
    }
    
    class CanFight {
        <<interface>>
        +fight() void
    }
    
    class ActionCharacter {
        +fight() void
    }
    
    class Hero {
        +fly() void
        +swim() void
    }
    
    CanFly <|.. Hero : implements
    CanSwim <|.. Hero : implements
    CanFight <|.. Hero : implements
    ActionCharacter <|-- Hero : extends
```

### Luồng thực thi

```mermaid
flowchart TD
    A[Tạo Hero object] --> B[Ép kiểu sang CanSwim]
    B --> C[Gọi swim - Output: Hero is swimming]
    A --> D[Ép kiểu sang CanFight]
    D --> E[Gọi fight - Output: Đấm bốc...]
```

## Trả lời câu hỏi

> **Lớp Hero có cần implement lại fight() của interface CanFight không?**

**Không cần.** Vì `ActionCharacter` đã có phương thức `fight()` với cùng chữ ký, Java tự động coi `ActionCharacter.fight()` là implementation của `CanFight.fight()`. Đây là cách Java xử lý **diamond problem** - lớp con kế thừa implementation từ lớp cha để thỏa mãn interface.

## Lý do chọn hướng tiếp cận này

| Cách tiếp cận | Ưu điểm | Nhược điểm |
|---------------|---------|------------|
| **Interface (chọn)** | Cho phép đa kế thừa hành vi, linh hoạt | Phải implement lại nếu không có lớp cha |
| Abstract class | Code reuse tốt | Chỉ kế thừa được 1 lớp |
| Kép interface + class cha | Tận dụng cả 2: code reuse + đa kế thừa | Phức tạp hơn |

**Lựa chọn:** Kép interface + class cha vì Hero vừa cần hành vi chiến đấu từ `ActionCharacter`, vừa cần khả năng bay, bơi riêng biệt.

## Cách chạy chương trình

1. **Cấp quyền thực thi cho script:**
   ```bash
   chmod +x run.sh
   ```

2. **Chạy chương trình:**
   ```bash
   ./run.sh
   ```

## Kết quả

```
Hero is swimming
Đấm bốc...
```
