
import java.time.LocalDate;

public class Food extends Product {

    protected LocalDate expiryDate;

    public Food(String id, String name, double price, LocalDate expiryDate) {
        super(id, name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public double getFinalPrice() {

        LocalDate today = LocalDate.now();

        if (expiryDate.minusDays(7).isBefore(today)) {
            return price * 0.8;
        }

        return price;
    }
}
