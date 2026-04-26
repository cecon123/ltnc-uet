
public class MotorBike extends FuelVehicle {

    public MotorBike(String plate, String brand, double fuelLevel) {
        super(plate, brand, fuelLevel);
    }

    @Override
    protected String getVehicleType() {
        return "Xe máy";
    }
}
