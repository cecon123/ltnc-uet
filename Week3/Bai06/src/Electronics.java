
public class Electronics extends Product {

    private double warrantyFee;

    public Electronics(String id, String name, double price, double warrantyFee) {
        super(id, name, price);
        this.warrantyFee = warrantyFee;
    }

    @Override
    public double getFinalPrice() {
        return price * 1.1 + warrantyFee;
    }
}
