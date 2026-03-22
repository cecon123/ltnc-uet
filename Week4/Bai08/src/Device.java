public abstract class Device {
    protected String id;
    protected String name;
    protected boolean status;

    public Device(String id, String name) {
        this.id = id;
        this.name = name;
        this.status = false;
    }

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return status;
    }

    public void turnOn() {
        status = true;
    }

    public void turnOff() {
        status = false;
    }

    @Override
    public String toString() {
        return name + " (" + (status ? "ON" : "OFF") + ")";
    }
}
