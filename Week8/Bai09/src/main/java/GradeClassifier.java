public class GradeClassifier {

    /**
     * Phân loại học lực dựa trên điểm GPA (thang 10).
     *   [0.0, 5.0)  → "Yếu"
     *   [5.0, 6.5)  → "Trung bình"
     *   [6.5, 8.0)  → "Khá"
     *   [8.0, 10.0] → "Giỏi"
     *   Ngoài [0.0, 10.0]: ném IllegalArgumentException
     */
    public static String classifyGrade(double gpa) {
        if (gpa < 0.0 || gpa > 10.0) {
            throw new IllegalArgumentException("GPA không hợp lệ: " + gpa);
        }

        if (gpa < 5.0) {
            return "Yếu";
        }

        if (gpa < 6.5) {
            return "Trung bình";
        }

        if (gpa < 8.0) {
            return "Khá";
        }

        return "Giỏi";
    }
}