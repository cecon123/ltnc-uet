
class Order {

    private final DeliveryType deliveryType;
    private final double weight;
    private final double distance;

    public Order(DeliveryType deliveryType, double weight, double distance) {
        this.deliveryType = deliveryType;
        this.weight = weight;
        this.distance = distance;
    }

    public double getDeliveryFee() {
        return deliveryType.calculateFee(weight, distance);
    }

    public String getLabel() {
        return deliveryType.getLabel();
    }
}
