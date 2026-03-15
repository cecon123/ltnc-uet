
public abstract class Robot {

    private final int id;
    private final String modelName;
    private int batteryLevel;

    public Robot(int id, String modelName) {
        this.id = id;
        this.modelName = modelName;
        this.batteryLevel = 100;
    }

    public void chargeBattery() {
        this.batteryLevel = 100;
    }

    public void showIdentity() {
        System.out.println("Robot ID: " + id + ", Model: " + modelName);
    }

    public abstract void performMainTask();
}
