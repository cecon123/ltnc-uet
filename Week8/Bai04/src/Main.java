
public class Main {

    public static void main(String[] args) {
        ParkingCustomer customer = new ParkingCustomer("Nguyen Van A");

        customer.addTicket(new ParkingTicket(new Car("51A-12345"), 4));
        customer.addTicket(new ParkingTicket(new Bike("59B1-67890"), 5));
        customer.addTicket(new ParkingTicket(new Truck("60C-99999"), 6));

        System.out.println(customer.receipt());
    }
}
