import java.time.LocalDate;

class Product {
    // mã, tên, giá gốc
    protected String code;
    protected String name;
    protected double price;
    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }
    public double getFinalPrice() {
        return price;
    }
}
public class Main {
    
}
