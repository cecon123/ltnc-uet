
abstract class Vehicle {

    protected String plate;
    protected String brand;

    public Vehicle(String plate, String brand) {
        this.plate = plate;
        this.brand = brand;
    }

    public String getInfo() {
        return getVehicleType() + " [" + plate + "] - " + brand;
    }

    protected abstract String getVehicleType();
}
