
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Developer("Alice", 20000000, 10));
        employees.add(new Developer("Bob", 18000000, 5));
        employees.add(new Tester("Charlie", 15000000, 20));
        employees.add(new Tester("David", 14000000, 15));
        employees.add(new Employee("Eve", 16000000));

        for (Employee e : employees) {

            System.out.println(e.name + " bonus: " + e.calculateBonus());

            if (e instanceof Developer) {
                System.out.println("Tặng khóa học AWS");
            }

            if (e instanceof Tester) {
                System.out.println("Tặng tool Test");
            }

            System.out.println("-------------------");
        }
    }

}
