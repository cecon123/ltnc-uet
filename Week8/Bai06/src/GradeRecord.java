
class GradeRecord {

    private static final double ASSIGNMENT_WEIGHT = 0.2;
    private static final double MIDTERM_WEIGHT = 0.3;
    private static final double FINAL_WEIGHT = 0.5;

    private final double midtermScore;
    private final double finalScore;
    private final double assignmentScore;

    public GradeRecord(double midtermScore, double finalScore, double assignmentScore) {
        this.midtermScore = midtermScore;
        this.finalScore = finalScore;
        this.assignmentScore = assignmentScore;
    }

    public double getMidtermScore() {
        return midtermScore;
    }

    public double getFinalScore() {
        return finalScore;
    }

    public double getAssignmentScore() {
        return assignmentScore;
    }

    public double calculateFinalGrade() {
        return assignmentScore * ASSIGNMENT_WEIGHT
                + midtermScore * MIDTERM_WEIGHT
                + finalScore * FINAL_WEIGHT;
    }

    public String getAcademicStatus() {
        double grade = calculateFinalGrade();

        if (grade >= 8.5) {
            return "Giỏi";
        }

        if (grade >= 7.0) {
            return "Khá";
        }

        if (grade >= 5.5) {
            return "Trung bình";
        }

        return "Yếu";
    }
}
