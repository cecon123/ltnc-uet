
class BulkyDelivery implements DeliveryType {

    private static final double WEIGHT_RATE = 4000;
    private static final double DISTANCE_RATE = 600;
    private static final double BULKY_FEE = 50000;

    @Override
    public double calculateFee(double weight, double distance) {
        return weight * WEIGHT_RATE + distance * DISTANCE_RATE + BULKY_FEE;
    }

    @Override
    public String getLabel() {
        return "[HÀNG CỒNG KỀNH]";
    }
}
