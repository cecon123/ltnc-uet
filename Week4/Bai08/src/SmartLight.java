public class SmartLight extends Device implements Dimmable {
    private int brightness;

    public SmartLight(String id, String name) {
        super(id, name);
        this.brightness = 100;
    }

    @Override
    public void adjustLevel(int level) {
        brightness = Math.max(0, Math.min(100, level));
    }

    @Override
    public String toString() {
        return "SmartLight[" + name + ", brightness=" + brightness + "]";
    }
}
