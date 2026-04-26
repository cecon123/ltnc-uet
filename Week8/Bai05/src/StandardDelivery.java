
class StandardDelivery implements DeliveryType {

    private static final double WEIGHT_RATE = 3000;
    private static final double DISTANCE_RATE = 500;

    @Override
    public double calculateFee(double weight, double distance) {
        return weight * WEIGHT_RATE + distance * DISTANCE_RATE;
    }

    @Override
    public String getLabel() {
        return "[THƯỜNG]";
    }
}
