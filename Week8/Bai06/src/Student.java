
public class Student extends Person {

    private final double gpa;

    public Student(String id, String name, double gpa) {
        super(id, name);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }
}
