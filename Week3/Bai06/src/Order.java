
import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getFinalPrice();
        }
        return total;
    }
}
