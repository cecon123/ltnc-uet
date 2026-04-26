
abstract class FuelVehicle extends Vehicle {

    protected double fuelLevel;

    public FuelVehicle(String plate, String brand, double fuelLevel) {
        super(plate, brand);
        this.fuelLevel = fuelLevel;
    }

    public void refuel(double liters) {
        fuelLevel += liters;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }
}
