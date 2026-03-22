import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String id = scanner.next();
            String name = scanner.next();
            double baseSalary = scanner.nextDouble();

            if (type.equals("O")) {
                employees.add(new OfficeWorker(id, name, baseSalary));
            } else if (type.equals("T")) {
                int overtimeHours = scanner.nextInt();
                employees.add(new Technician(id, name, baseSalary, overtimeHours));
            }
        }

        double totalPay = 0;
        for (Employee emp : employees) {
            double pay = emp.calculatePay();
            System.out.printf("%s - Pay: %.1f%n", emp.getName(), pay);
            emp.work();
            totalPay += pay;
            System.out.println();
        }

        System.out.printf("Total Pay = %.1f%n", totalPay);
        scanner.close();
    }
}
