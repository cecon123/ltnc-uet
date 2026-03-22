public class SmartSpeaker extends Device implements Dimmable, WifiConnectable {
    private int volume;
    private String wifiNetwork;

    public SmartSpeaker(String id, String name) {
        super(id, name);
        this.volume = 50;
        this.wifiNetwork = null;
    }

    @Override
    public void adjustLevel(int level) {
        volume = Math.max(0, Math.min(100, level));
    }

    @Override
    public void setupWifi(String network) {
        this.wifiNetwork = network;
    }

    @Override
    public String toString() {
        return "SmartSpeaker[" + name + ", volume=" + volume
            + ", wifi=" + (wifiNetwork != null ? wifiNetwork : "none") + "]";
    }
}
