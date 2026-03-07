public class Employee {
    String name;
    MyDate birthday;
    public Employee(String name, MyDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    public Employee(Employee other) {
        this.name = other.name;
        this.birthday = new MyDate(other.birthday); // Sử dụng Copy Constructor của MyDate
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }
    public static void main(String[] args) {
        MyDate date1 = new MyDate(1, 1, 2000);
        Employee emp1 = new Employee("John", date1);
        Employee emp2 = new Employee(emp1);
        emp1.setBirthday(new MyDate(2, 2, 2022));
        System.out.println("Emp2 Birthday: " + emp2.birthday);
    }
}