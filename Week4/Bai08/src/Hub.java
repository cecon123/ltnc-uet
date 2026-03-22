import java.util.ArrayList;
import java.util.List;

public class Hub {
    private List<Device> devices;

    public Hub() {
        devices = new ArrayList<>();
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void turnOffAll() {
        for (Device device : devices) {
            device.turnOff();
            System.out.println(device.getName() + " turned off");
        }
    }

    public void setupWifiAll() {
        for (Device device : devices) {
            if (device instanceof WifiConnectable) {
                ((WifiConnectable) device).setupWifi("HomeNetwork");
                System.out.println(device.getName() + " connected to wifi");
            }
        }
    }
}
