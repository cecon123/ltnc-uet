
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Order order = new Order();

        Product laptop = new Electronics("E001", "Laptop", 1000, 100);
        Product phone = new Electronics("E002", "Phone", 500, 50);
        Product bread = new Food("F001", "Bread", 2, LocalDate.now().plusDays(5));
        Product milk = new Food("F002", "Milk", 3, LocalDate.now().plusDays(10));
        order.addProduct(laptop);
        order.addProduct(phone);
        order.addProduct(bread);
        order.addProduct(milk);
        System.out.println("Total Price: $" + order.getTotalPrice());
    }
}
