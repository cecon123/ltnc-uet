public class MyDate {
    public int day, month, year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public MyDate(MyDate other) {
        this.day = other.day;
        this.month = other.month;
        this.year = other.year;
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}