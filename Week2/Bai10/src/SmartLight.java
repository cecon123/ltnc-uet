public class SmartLight {

    private String id;
    private String name;
    private int brightness;

    public SmartLight(String id, String name, int brightness) {
        this.id = id;
        this.name = name;
        this.brightness = brightness;
    }

    public SmartLight(String id, String name) {
        this(id, name, 50);
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }
    public void setBrightness(String preset) {
        switch (preset) {
            case "MAX":
                this.setBrightness(100);
                break;
            case "MIN":
                this.setBrightness(10);
                break;
            case "ECO":
                this.setBrightness(30);
                break;
            default:
                System.out.println("Lỗi preset không hợp lệ: " + preset );
        }
    }
    public String getName() {
        return this.name;
    }
    public int getBrightness() {
        return this.brightness;
    }
    public void  connectToHub(CentralHub hub) {
        hub.registerDevice(this);
    }
    public static void main(String[] args) {
        CentralHub hub = new CentralHub();
        SmartLight l1 = new SmartLight("L01", "Đèn phòng khách", 80);
        SmartLight l2 = new SmartLight("L02", "Đèn ngủ");
        l2.setBrightness("ECO");
        l1.connectToHub(hub);
        l2.connectToHub(hub);
        System.out.println("Độ sáng của " + l1.getName() + ": " + l1.getBrightness());
        System.out.println("Độ sáng của " + l2.getName() + ": " + l2.getBrightness());
    }
}
