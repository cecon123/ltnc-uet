
public class Main {
    public static void main(String[] args) {
            Employee[] employees = new Employee[2];
            employees[0] = new FullTimeEmployee("Alice", "01/01/1990", "E001", 5000, 500, 200);
            employees[1] = new PartTimeEmployee("Bob", "02/02/1995", "E002", 80, 20);
            for (Employee emp : employees) {
                System.out.println("Name: " + emp.name);
                System.out.println("DOB: " + emp.dob);
                System.out.println("ID: " + emp.id);
                System.out.println("Type: " + emp.getType());
                System.out.println("Salary: " + emp.calcSalary() + "\n");
            }
    }
}
