
public class PartTimeEmployee extends Employee {

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
