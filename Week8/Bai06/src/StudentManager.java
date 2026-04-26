
public class StudentManager {

    private final Student student;
    private final Course course;
    private final GradeRecord gradeRecord;
    private final TranscriptPrinter transcriptPrinter;

    public StudentManager(Student student, Course course, GradeRecord gradeRecord) {
        this.student = student;
        this.course = course;
        this.gradeRecord = gradeRecord;
        this.transcriptPrinter = new TranscriptPrinter();
    }

    public void printTranscript() {
        transcriptPrinter.printTranscript(student, course, gradeRecord);
    }
}
