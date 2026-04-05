
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            IPayable[] payableList = new IPayable[n];

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                switch (type) {
                    case "S" -> {
                        String id = sc.next();
                        String name = sc.next();
                        int hours = sc.nextInt();
                        double rate = sc.nextDouble();

                        payableList[i] = new PartTimeStaff(id, name, hours, rate);
                    }
                    case "I" -> {
                        String item = sc.next();
                        int quantity = sc.nextInt();
                        double price = sc.nextDouble();

                        payableList[i] = new Invoice(item, quantity, price);
                    }
                }
            }

            double total = 0;

            for (IPayable p : payableList) {
                double payment = p.getPaymentAmount();
                total += payment;
                if (p instanceof PartTimeStaff s) {
                    System.out.println("PartTimeStaff " + s.getName() + " - Payment: " + payment);
                }
                if (p instanceof Invoice i) {
                    System.out.println("Invoice " + i.getItemName() + " - Payment: " + payment);
                }
            }
            System.out.println("Total Payment = " + total);
        }
    }
}
