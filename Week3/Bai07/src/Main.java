
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Room room = null;
            while (room == null) {
                System.out.print("Enter room type (standard/vip): ");
                String roomType = sc.nextLine().toLowerCase();

                switch (roomType) {
                    case "standard" ->
                        room = new StandardRoom(500000);
                    case "vip" ->
                        room = new VipRoom(2000000);
                    default ->
                        System.out.println("Invalid room type. Please try again.");
                }
            }
            System.out.print("Enter number of nights: ");
            int nights = sc.nextInt();
            System.out.printf("Total price: $%.2f%n", room.calculatePrice(nights));
        }
    }
}
