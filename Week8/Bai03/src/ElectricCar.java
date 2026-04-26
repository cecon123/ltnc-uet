
class ElectricCar extends Vehicle {

    private int batteryPercent;

    public ElectricCar(String plate, String brand, int batteryPercent) {
        super(plate, brand);
        this.batteryPercent = batteryPercent;
    }

    public void charge(int percent) {
        batteryPercent += percent;

        if (batteryPercent > 100) {
            batteryPercent = 100;
        }
    }

    public int getBatteryPercent() {
        return batteryPercent;
    }

    @Override
    protected String getVehicleType() {
        return "Xe điện";
    }
}
