
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = Integer.parseInt(sc.nextLine());
            Employee[] employees = new Employee[n];

            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                char type = line.charAt(0);
                int firstQuote = line.indexOf("\"");
                int secondQuote = line.indexOf("\"", firstQuote + 1);

                String name = line.substring(firstQuote + 1, secondQuote);
                String remain = line.substring(secondQuote + 2);
                String[] nums = remain.split(" ");

                if (type == 'F') {
                    double baseSalary = Double.parseDouble(nums[0]);
                    double bonus = Double.parseDouble(nums[1]);
                    double penalty = Double.parseDouble(nums[2]);

                    employees[i] = new FullTimeEmployee(
                            name, "", "", baseSalary, bonus, penalty
                    );

                } else {
                    int workingHours = Integer.parseInt(nums[0]);
                    double hourlyRate = Double.parseDouble(nums[1]);

                    employees[i] = new PartTimeEmployee(
                            name, "", "", workingHours, hourlyRate
                    );
                }
            }

            for (Employee e : employees) {
                System.out.println(e.name + " - " + e.getType() + " - " + e.calcSalary());
            }
        }
    }
}
