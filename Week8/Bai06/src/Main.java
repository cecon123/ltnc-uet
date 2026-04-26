
public class Main {

    public static void main(String[] args) {
        Course oop = new Course("OOP101", "Lập trình hướng đối tượng", 3);

        Student student = new Student("SV001", "Nguyễn Văn A", 3.2);
        GradeRecord gradeRecord = new GradeRecord(8.0, 9.0, 7.5);

        StudentManager studentManager = new StudentManager(student, oop, gradeRecord);
        studentManager.printTranscript();

        TeachingAssistant teachingAssistant = new TeachingAssistant("TA001", "Trần Thị B", oop);

        System.out.println("Trợ giảng: "
                + teachingAssistant.getName()
                + " ("
                + teachingAssistant.getId()
                + ") - Phụ trách môn: "
                + teachingAssistant.getAssignedCourse().getName());
    }
}
