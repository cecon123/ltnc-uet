
public class TranscriptPrinter {

    public void printTranscript(Student student, Course course, GradeRecord gradeRecord) {
        System.out.println("Sinh viên: " + student.getName() + " (" + student.getId() + ")");
        System.out.println("Môn học: " + course.getName() + " (" + course.getId() + ") - "
                + course.getCredits() + " tín chỉ");
        System.out.println("Điểm GK: " + gradeRecord.getMidtermScore()
                + " | Điểm CK: " + gradeRecord.getFinalScore()
                + " | Điểm BT: " + gradeRecord.getAssignmentScore());
        System.out.printf("Điểm tổng kết: %.1f - Học lực: %s%n",
                gradeRecord.calculateFinalGrade(),
                gradeRecord.getAcademicStatus());
    }
}
