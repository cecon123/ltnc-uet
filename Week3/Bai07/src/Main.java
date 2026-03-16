
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            char type = sc.next().charAt(0);
            int nights = sc.nextInt();

            Room room;

            switch (type) {
                case 'S' ->
                    room = new StandardRoom(500000);
                case 'V' ->
                    room = new VipRoom(2000000);
                default ->
                    throw new IllegalArgumentException("Invalid room type");
            }

            double total = room.calculatePrice(nights);

            System.out.println((long) total);
        }
    }
}
