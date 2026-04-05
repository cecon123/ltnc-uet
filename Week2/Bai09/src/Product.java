import java.util.Scanner;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private double discount;

    private static double taxRate = 0.1; 
    private static double totalRevenue = 0.0;

    public Product(String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    public static void updateTaxRate(double newRate) {
        taxRate = newRate;
    }

    public double calculateFinalPrice() {
        return (this.price - this.discount) * (1 + taxRate);
    }

    public void updateDiscount(double newDiscount) {
        this.discount = newDiscount;
    }

    public void sell(int amount) {
        if (amount <= this.quantity) {
            this.quantity -= amount;
            double revenueFromSale = amount * calculateFinalPrice();
            totalRevenue += revenueFromSale;
            
            System.out.println("[Success] Sold " + amount + " units of " + this.name);
        } else {
            System.err.println("[Error] Insufficient stock for: " + this.name);
        }
    }

    public String getName() {
        return name;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- ENTER PRODUCT 1 INFORMATION ---");
        System.out.print("Name: "); String name1 = scanner.nextLine();
        System.out.print("Price: "); double price1 = scanner.nextDouble();
        System.out.print("Quantity: "); int qty1 = scanner.nextInt();
        System.out.print("Discount: "); double disc1 = scanner.nextDouble();
        scanner.nextLine(); 

        Product p1 = new Product(name1, price1, qty1, disc1);

        System.out.println("\n--- ENTER PRODUCT 2 INFORMATION ---");
        System.out.print("Name: "); String name2 = scanner.nextLine();
        System.out.print("Price: "); double price2 = scanner.nextDouble();
        System.out.print("Quantity: "); int qty2 = scanner.nextInt();
        System.out.print("Discount: "); double disc2 = scanner.nextDouble();

        Product p2 = new Product(name2, price2, qty2, disc2);

        System.out.println("\n--- SALES TRANSACTIONS ---");
        System.out.print("Enter quantity to buy for " + p1.getName() + ": ");
        int buyAmount1 = scanner.nextInt();
        p1.sell(buyAmount1);

        System.out.print("Enter quantity to buy for " + p2.getName() + ": ");
        int buyAmount2 = scanner.nextInt();
        p2.sell(buyAmount2);

        System.out.println("\n[i] Current Final Prices (10% Tax):");
        System.out.println("- " + p1.getName() + ": " + p1.calculateFinalPrice() + "$");
        System.out.println("- " + p2.getName() + ": " + p2.calculateFinalPrice() + "$");

        Product.updateTaxRate(0.08); 
        
        System.out.println("\n[ii] Prices after reducing Tax to 8% (Global change):");
        System.out.println("- " + p1.getName() + ": " + p1.calculateFinalPrice() + "$");
        System.out.println("- " + p2.getName() + ": " + p2.calculateFinalPrice() + "$");

        p1.updateDiscount(10.0);
        
        System.out.println("\n[iii] Prices after updating Discount to 10 for " + p1.getName() + " only:");
        System.out.println("- " + p1.getName() + ": " + p1.calculateFinalPrice() + "$ (Updated Instance property)");
        System.out.println("- " + p2.getName() + ": " + p2.calculateFinalPrice() + "$ (No change)");

        System.out.println("\n=> TOTAL SYSTEM REVENUE: " + Product.getTotalRevenue() + "$");

        scanner.close();
    }
}