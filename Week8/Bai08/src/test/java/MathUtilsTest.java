
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathUtilsTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("=== Bắt đầu chạy MathUtilsTest ===");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("=== Kết thúc ===");
    }

    // =========================
    // Test max(int a, int b)
    // Equivalence Partitioning
    // =========================
    @Test
    void max_shouldReturnA_whenAGreaterThanB() {
        assertEquals(10, MathUtils.max(10, 5));
    }

    @Test
    void max_shouldReturnA_whenAEqualsB() {
        assertEquals(7, MathUtils.max(7, 7));
    }

    @Test
    void max_shouldReturnB_whenALessThanB() {
        assertEquals(9, MathUtils.max(3, 9));
    }

    // =========================
    // Test max(int a, int b)
    // Boundary Value Analysis
    // =========================
    @Test
    void max_shouldHandleMinValue_whenComparedWithZero() {
        assertEquals(0, MathUtils.max(Integer.MIN_VALUE, 0));
    }

    @Test
    void max_shouldHandleZero_whenComparedWithMinValue() {
        assertEquals(0, MathUtils.max(0, Integer.MIN_VALUE));
    }

    @Test
    void max_shouldReturnMinValue_whenBothAreMinValue() {
        assertEquals(Integer.MIN_VALUE,
                MathUtils.max(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    @Test
    void max_shouldHandleMaxValue_whenComparedWithZero() {
        assertEquals(Integer.MAX_VALUE,
                MathUtils.max(Integer.MAX_VALUE, 0));
    }

    @Test
    void max_shouldHandleZero_whenComparedWithMaxValue() {
        assertEquals(Integer.MAX_VALUE,
                MathUtils.max(0, Integer.MAX_VALUE));
    }

    @Test
    void max_shouldReturnMaxValue_whenBothAreMaxValue() {
        assertEquals(Integer.MAX_VALUE,
                MathUtils.max(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test
    void max_shouldReturnMaxValue_whenComparingMinAndMax() {
        assertEquals(Integer.MAX_VALUE,
                MathUtils.max(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    void max_shouldReturnMaxValue_whenComparingMaxAndMin() {
        assertEquals(Integer.MAX_VALUE,
                MathUtils.max(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }

    // =========================
    // Test divide(int a, int b)
    // Equivalence Partitioning
    // =========================
    @Test
    void divide_shouldReturnResult_whenDividerIsPositive() {
        assertEquals(5, MathUtils.divide(10, 2));
    }

    @Test
    void divide_shouldReturnResult_whenDividerIsNegative() {
        assertEquals(-5, MathUtils.divide(10, -2));
    }

    @Test
    void divide_shouldThrowException_whenDividerIsZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> MathUtils.divide(10, 0)
        );

        assertEquals("Divider must not be zero", exception.getMessage());
    }
}
