
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = Integer.parseInt(sc.nextLine());
            Product[] products = new Product[n];
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                char type = line.charAt(0);
                int firstQuote = line.indexOf("\"");
                int secondQuote = line.indexOf("\"", firstQuote + 1);
                String name = line.substring(firstQuote + 1, secondQuote);
                String remain = line.substring(secondQuote + 2);
                String[] parts = remain.split(" ");

                switch (type) {
                    case 'E' -> {
                        double price = Double.parseDouble(parts[0]);
                        double warrantyFee = Double.parseDouble(parts[1]);

                        products[i] = new Electronics("E" + i, name, price, warrantyFee);
                    }
                    case 'F' -> {
                        double price = Double.parseDouble(parts[0]);
                        LocalDate expiry = LocalDate.parse(parts[1]);

                        products[i] = new Food("F" + i, name, price, expiry);
                    }
                    default ->
                        throw new IllegalArgumentException("Invalid product type");
                }
            }

            double total = 0;
            for (Product p : products) {
                double finalPrice = p.getFinalPrice();
                total += finalPrice;
                String typeName = (p instanceof Electronics) ? "Electronics" : "Food";
                System.out.println(p.name + " - " + typeName + " - " + finalPrice);
            }
            System.out.println("Total = " + total);
        }
    }
}
