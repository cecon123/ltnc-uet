
public class Main {

    public static void main(String[] args) {
        Vehicle motorBike = new MotorBike("59-A1 12345", "Honda", 5.0);
        Vehicle car = new Car("51F 67890", "Toyota", 20.0);
        Vehicle electricCar = new ElectricCar("30E 99999", "VinFast", 80);

        System.out.println(motorBike.getInfo());
        System.out.println(car.getInfo());
        System.out.println(electricCar.getInfo());
    }
}
