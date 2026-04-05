public class Student {
    private String id;
    private String name;
    private String email;
    private double gpa;

    public Student() {
        this.id = "";
        this.name = "";
        this.email = "";
        this.gpa = 0.0;
    }
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.email = "";
        this.gpa = 0.0;
    }
    public Student(String id, String name, String email, double gpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        setGpa(gpa);
    }
    public Student(Student other) {
        this.id = other.id;
        this.name = other.name;
        this.email = other.email;
        this.gpa = other.gpa;
    }
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("Error: GPA must be between 0.0 and 4.0. Keeping old value: " + this.gpa);
        }
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gpa=" + gpa +
                '}';
    }
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setId("S001");
        s1.setName("Nguyen Van A");
        s1.setGpa(-1.5);

        Student s2 = new Student("S002", "Tran Thi B");
        s2.setEmail("thib@gmail.com");
        s2.setGpa(3.8);

        Student s3 = new Student("S003", "Le Van C", "vanc@gmail.com", 3.2);

        System.out.println("\n--- Students Information ---");
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());
    }
}