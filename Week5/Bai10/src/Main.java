import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BufferedReader br = null;

        try {
            System.out.print("Nhap duong dan file config: ");
            String filePath = scanner.nextLine();

            br = new BufferedReader(new FileReader(filePath));
            Map<String, String> config = new HashMap<>();

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                int equalIndex = line.indexOf('=');

                if (
                    equalIndex == -1 ||
                    equalIndex == 0 ||
                    equalIndex == line.length() - 1
                ) {
                    continue;
                }

                String key = line.substring(0, equalIndex).trim();
                String value = line.substring(equalIndex + 1).trim();

                config.put(key, value);
            }

            validateConfig(config);

            System.out.println("Config loaded successfully.");
            for (Map.Entry<String, String> entry : config.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Config file not found.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (InvalidConfigException e) {
            System.out.println("Invalid config: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.out.println("I/O error.");
                e.printStackTrace();
            }

            System.out.println("Program finished.");
            scanner.close();
        }
    }

    public static void validateConfig(Map<String, String> config)
        throws InvalidConfigException, NumberFormatException {
        if (!config.containsKey("username")) {
            throw new InvalidConfigException("missing username");
        }

        if (!config.containsKey("timeout")) {
            throw new InvalidConfigException("missing timeout");
        }

        int timeout = Integer.parseInt(config.get("timeout"));
        if (timeout <= 0) {
            throw new InvalidConfigException("timeout must be > 0");
        }

        if (config.containsKey("maxConnections")) {
            int maxConnections = Integer.parseInt(config.get("maxConnections"));
            if (maxConnections < 1) {
                throw new InvalidConfigException("maxConnections must be >= 1");
            }
        }
    }
}
