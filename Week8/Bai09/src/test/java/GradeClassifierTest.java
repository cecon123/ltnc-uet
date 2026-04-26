import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GradeClassifierTest {

    // =========================
    // Equivalence Partitioning
    // =========================

    @Test
    void classifyGrade_shouldThrowException_whenGpaLessThanZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> GradeClassifier.classifyGrade(-1.0)
        );

        assertEquals("GPA không hợp lệ: -1.0", exception.getMessage());
    }

    @Test
    void classifyGrade_shouldReturnWeak_whenGpaInWeakRange() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(3.0));
    }

    @Test
    void classifyGrade_shouldReturnAverage_whenGpaInAverageRange() {
        assertEquals("Trung bình", GradeClassifier.classifyGrade(5.5));
    }

    @Test
    void classifyGrade_shouldReturnGood_whenGpaInGoodRange() {
        assertEquals("Khá", GradeClassifier.classifyGrade(7.0));
    }

    @Test
    void classifyGrade_shouldReturnExcellent_whenGpaInExcellentRange() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(9.0));
    }

    @Test
    void classifyGrade_shouldThrowException_whenGpaGreaterThanTen() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> GradeClassifier.classifyGrade(11.0)
        );

        assertEquals("GPA không hợp lệ: 11.0", exception.getMessage());
    }

    // =========================
    // Boundary Value Analysis
    // =========================

    @Test
    void classifyGrade_shouldThrowException_whenGpaBelowZeroBoundary() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> GradeClassifier.classifyGrade(-0.1)
        );

        assertEquals("GPA không hợp lệ: -0.1", exception.getMessage());
    }

    @Test
    void classifyGrade_shouldReturnWeak_whenGpaAtZeroBoundary() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(0.0));
    }

    @Test
    void classifyGrade_shouldReturnWeak_whenGpaAboveZeroBoundary() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(0.1));
    }

    @Test
    void classifyGrade_shouldReturnWeak_whenGpaBelowFiveBoundary() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(4.9));
    }

    @Test
    void classifyGrade_shouldReturnAverage_whenGpaAtFiveBoundary() {
        assertEquals("Trung bình", GradeClassifier.classifyGrade(5.0));
    }

    @Test
    void classifyGrade_shouldReturnAverage_whenGpaAboveFiveBoundary() {
        assertEquals("Trung bình", GradeClassifier.classifyGrade(5.1));
    }

    @Test
    void classifyGrade_shouldReturnAverage_whenGpaBelowSixPointFiveBoundary() {
        assertEquals("Trung bình", GradeClassifier.classifyGrade(6.4));
    }

    @Test
    void classifyGrade_shouldReturnGood_whenGpaAtSixPointFiveBoundary() {
        assertEquals("Khá", GradeClassifier.classifyGrade(6.5));
    }

    @Test
    void classifyGrade_shouldReturnGood_whenGpaAboveSixPointFiveBoundary() {
        assertEquals("Khá", GradeClassifier.classifyGrade(6.6));
    }

    @Test
    void classifyGrade_shouldReturnGood_whenGpaBelowEightBoundary() {
        assertEquals("Khá", GradeClassifier.classifyGrade(7.9));
    }

    @Test
    void classifyGrade_shouldReturnExcellent_whenGpaAtEightBoundary() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(8.0));
    }

    @Test
    void classifyGrade_shouldReturnExcellent_whenGpaAboveEightBoundary() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(8.1));
    }

    @Test
    void classifyGrade_shouldReturnExcellent_whenGpaBelowTenBoundary() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(9.9));
    }

    @Test
    void classifyGrade_shouldReturnExcellent_whenGpaAtTenBoundary() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(10.0));
    }

    @Test
    void classifyGrade_shouldThrowException_whenGpaAboveTenBoundary() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> GradeClassifier.classifyGrade(10.1)
        );

        assertEquals("GPA không hợp lệ: 10.1", exception.getMessage());
    }

    // =========================
    // Extra exception tests
    // Theo yêu cầu đề bài
    // =========================

    @Test
    void classifyGrade_shouldThrowException_whenGpaIsMinusZeroPointOne() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> GradeClassifier.classifyGrade(-0.1)
        );

        assertEquals("GPA không hợp lệ: -0.1", exception.getMessage());
    }

    @Test
    void classifyGrade_shouldThrowException_whenGpaIsTenPointOne() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> GradeClassifier.classifyGrade(10.1)
        );

        assertEquals("GPA không hợp lệ: 10.1", exception.getMessage());
    }
}