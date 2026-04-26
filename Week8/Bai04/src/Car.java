
class Car extends Vehicle {

    private static final double BASE_FEE = 10;
    private static final int FREE_HOURS = 2;
    private static final double EXTRA_HOUR_FEE = 3;

    public Car(String plate) {
        super(plate);
    }

    @Override
    public double calculateFee(int hours) {
        double fee = BASE_FEE;

        if (hours > FREE_HOURS) {
            fee += (hours - FREE_HOURS) * EXTRA_HOUR_FEE;
        }

        return fee;
    }
}
