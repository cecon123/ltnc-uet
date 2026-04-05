
public class Tester extends Employee {

    private int bugsFound;

    public Tester(String name, double baseSalary, int bugsFound) {
        super(name, baseSalary);
        this.bugsFound = bugsFound;
    }

    @Override
    public double calculateBonus() {
        return baseSalary * 0.1 + bugsFound * 50000;
    }

}
