
public class Main {

    public static void main(String[] args) {

        IPayable[] payableList = new IPayable[3];

        payableList[0] = new PartTimeStaff("S01", "Alice", 80, 10);
        payableList[1] = new PartTimeStaff("S02", "Bob", 100, 12);
        payableList[2] = new Invoice("Laptop", 2, 900);
        double total = 0;

        for (IPayable p : payableList) {
            total += p.getPaymentAmount();
        }
        System.out.println("Total payment this month: $" + total);
    }

}
