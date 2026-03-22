public class Curtain extends Device {

    public Curtain(String id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        status = true;
    }

    @Override
    public void turnOff() {
        status = false;
    }

    @Override
    public String toString() {
        return "Curtain[" + name + ", status=" + (status ? "OPEN" : "CLOSED") + "]";
    }
}
