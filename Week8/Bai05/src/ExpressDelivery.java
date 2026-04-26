
class ExpressDelivery implements DeliveryType {

    private static final double WEIGHT_RATE = 3000;
    private static final double DISTANCE_RATE = 500;
    private static final double EXPRESS_MULTIPLIER = 1.5;

    @Override
    public double calculateFee(double weight, double distance) {
        double standardFee = weight * WEIGHT_RATE + distance * DISTANCE_RATE;
        return standardFee * EXPRESS_MULTIPLIER;
    }

    @Override
    public String getLabel() {
        return "[HỎA TỐC]";
    }
}
