public class AC extends Device implements WifiConnectable {
    private String wifiNetwork;

    public AC(String id, String name) {
        super(id, name);
        this.wifiNetwork = null;
    }

    @Override
    public void setupWifi(String network) {
        this.wifiNetwork = network;
    }

    @Override
    public String toString() {
        return "AC[" + name + ", wifi=" + (wifiNetwork != null ? wifiNetwork : "none") + "]";
    }
}
