
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            ArrayList<Employee> employees = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                String name = sc.next();
                double salary = sc.nextDouble();

                switch (type) {
                    case "E" ->
                        employees.add(new Employee(name, salary));
                    case "D" -> {
                        int overtime = sc.nextInt();
                        employees.add(new Developer(name, salary, overtime));
                    }
                    case "T" -> {
                        int bugs = sc.nextInt();
                        employees.add(new Tester(name, salary, bugs));
                    }
                }
            }

            for (Employee e : employees) {
                double bonus = e.calculateBonus();
                System.out.println(e.name + " - Bonus: " + bonus);

                if (e instanceof Developer) {
                    System.out.println("Tặng khóa học AWS");
                }

                if (e instanceof Tester) {
                    System.out.println("Tặng tool Test");
                }
            }
        }
    }
}
