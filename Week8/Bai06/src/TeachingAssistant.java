
public class TeachingAssistant extends Person {

    private final Course assignedCourse;

    public TeachingAssistant(String id, String name, Course assignedCourse) {
        super(id, name);
        this.assignedCourse = assignedCourse;
    }

    public Course getAssignedCourse() {
        return assignedCourse;
    }
}
