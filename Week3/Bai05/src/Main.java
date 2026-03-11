
abstract class Employee {

    protected String name;
    protected String dob;
    protected String id;

    public Employee(String name, String dob, String id) {
        this.name = name;
        this.dob = dob;
        this.id = id;
    }

    public abstract double calcSalary();
    public abstract String getType();
}

class FullTimeEmployee extends Employee {

    // baseSalary + (bonus - penalty)
    private double baseSalary, bonus, penalty;

    public FullTimeEmployee(String name, String dob, String id, double baseSalary, double bonus, double penalty) {
        super(name, dob, id);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.penalty = penalty;
    }

    @Override
    public double calcSalary() {
        return baseSalary + (bonus - penalty);
    }
    @Override
    public String getType() {
        return "Full-Time";
    }

}

class PartTimeEmployee extends Employee {
    // workingHours * hourlyRate
    private int workingHours;
    private double hourlyRate;

    public PartTimeEmployee(String name, String dob, String id, int workingHours, double hourlyRate) {
        super(name, dob, id);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calcSalary() {
        return workingHours * hourlyRate;
    }

    @Override
    public String getType() {
        return "Part-Time";
    }
}

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
