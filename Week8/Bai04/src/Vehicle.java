
abstract class Vehicle {

    private final String plate;

    public Vehicle(String plate) {
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }

    public abstract double calculateFee(int hours);

    public int calculateBonusPoints(int hours) {
        return 1;
    }
}
