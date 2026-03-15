
public class Developer extends Employee {

    private int overtimeHours;

    public Developer(String name, double baseSalary, int overtimeHours) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculateBonus() {
        return baseSalary * 0.1 + overtimeHours * 200000;
    }
}
