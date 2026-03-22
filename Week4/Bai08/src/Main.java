import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hub hub = new Hub();

        int n = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            String id = parts[1];
            String name = parts[2];

            switch (type) {
                case "L":
                    hub.addDevice(new SmartLight(id, name));
                    break;
                case "AC":
                    hub.addDevice(new AC(id, name));
                    break;
                case "S":
                    hub.addDevice(new SmartSpeaker(id, name));
                    break;
                case "C":
                    hub.addDevice(new Curtain(id, name));
                    break;
            }
        }

        System.out.println("Turn Off All Devices:");
        hub.turnOffAll();

        System.out.println();
        System.out.println("Setup Wifi:");
        hub.setupWifiAll();

        scanner.close();
    }
}
