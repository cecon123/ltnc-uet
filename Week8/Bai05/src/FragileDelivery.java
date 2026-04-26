
class FragileDelivery implements DeliveryType {

    private static final double WEIGHT_RATE = 5000;
    private static final double DISTANCE_RATE = 700;
    private static final double HANDLING_FEE = 20000;

    @Override
    public double calculateFee(double weight, double distance) {
        return weight * WEIGHT_RATE + distance * DISTANCE_RATE + HANDLING_FEE;
    }

    @Override
    public String getLabel() {
        return "[HÀNG DỄ VỠ]";
    }
}
