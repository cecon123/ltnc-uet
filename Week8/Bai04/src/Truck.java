
class Truck extends Vehicle {

    private static final double BASE_FEE = 15;
    private static final double HOURLY_FEE = 4;
    private static final int BONUS_HOUR_THRESHOLD = 5;
    private static final int EXTRA_BONUS_POINT = 1;

    public Truck(String plate) {
        super(plate);
    }

    @Override
    public double calculateFee(int hours) {
        return BASE_FEE + hours * HOURLY_FEE;
    }

    @Override
    public int calculateBonusPoints(int hours) {
        int bonusPoints = super.calculateBonusPoints(hours);

        if (hours > BONUS_HOUR_THRESHOLD) {
            bonusPoints += EXTRA_BONUS_POINT;
        }

        return bonusPoints;
    }
}
