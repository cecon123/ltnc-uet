public class DroneRobot extends Robot implements Flyable, GPS {

    public DroneRobot(int id, String modelName) {
        super(id, modelName);
    }

    @Override
    public void performMainTask() {
        System.out.println("Drone is performing aerial surveillance.");
    }

    @Override
    public void fly() {
        System.out.println("Drone is flying.");
    }

    @Override
    public void getCoordinates() {
        System.out.println("Drone GPS coordinates acquired.");
    }
}
