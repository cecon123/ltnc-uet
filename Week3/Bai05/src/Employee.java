
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
