
public class FullTimeEmployee extends Employee {

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
