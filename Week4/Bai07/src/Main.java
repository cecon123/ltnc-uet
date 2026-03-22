import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String id = scanner.next();
            String name = scanner.next();
            double gpa = scanner.nextDouble();
            students.add(new Student(id, name, gpa));
        }

        students.removeIf(student -> student.getGpa() < 5.0);

        System.out.println("After removing GPA < 5.0:");
        for (Student student : students) {
            System.out.println(student);
        }

        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));

        System.out.println("After sorting by name:");
        for (Student student : students) {
            System.out.println(student);
        }

        Operation<Double> add = (a, b) -> a + b;
        Operation<Double> subtract = (a, b) -> a - b;
        Operation<Double> multiply = (a, b) -> a * b;
        Operation<Double> divide = (a, b) -> a / b;

        scanner.close();
    }
}
