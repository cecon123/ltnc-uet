
class Bike extends Vehicle {

    private static final double BASE_FEE = 5;
    private static final int FREE_HOURS = 3;
    private static final double EXTRA_HOUR_FEE = 2;

    public Bike(String plate) {
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
