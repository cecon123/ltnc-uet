
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankAccountTest {

    private static final double DELTA = 0.000001;

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("ACC001", "Nguyen Van A", 500.0);
    }

    // =========================
    // deposit(double amount)
    // Equivalence Partitioning
    // =========================
    @Test
    void deposit_shouldThrowException_whenAmountIsNegative() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(-100.0)
        );

        assertEquals("Số tiền nạp phải lớn hơn 0.", exception.getMessage());
        assertEquals(500.0, account.getBalance(), DELTA);
    }

    @Test
    void deposit_shouldThrowException_whenAmountIsZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(0.0)
        );

        assertEquals("Số tiền nạp phải lớn hơn 0.", exception.getMessage());
        assertEquals(500.0, account.getBalance(), DELTA);
    }

    @Test
    void deposit_shouldIncreaseBalance_whenAmountIsPositive() {
        account.deposit(200.0);

        assertEquals(700.0, account.getBalance(), DELTA);
    }

    // =========================
    // deposit(double amount)
    // Boundary Value Analysis
    // =========================
    @Test
    void deposit_shouldThrowException_whenAmountIsJustBelowZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(-0.01)
        );

        assertEquals("Số tiền nạp phải lớn hơn 0.", exception.getMessage());
        assertEquals(500.0, account.getBalance(), DELTA);
    }

    @Test
    void deposit_shouldIncreaseBalance_whenAmountIsJustAboveZero() {
        account.deposit(0.01);

        assertEquals(500.01, account.getBalance(), DELTA);
    }

    // =========================
    // withdraw(double amount)
    // Equivalence Partitioning
    // =========================
    @Test
    void withdraw_shouldThrowException_whenAmountIsNegative() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(-100.0)
        );

        assertEquals("Số tiền rút phải lớn hơn 0.", exception.getMessage());
        assertEquals(500.0, account.getBalance(), DELTA);
    }

    @Test
    void withdraw_shouldThrowException_whenAmountIsZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(0.0)
        );

        assertEquals("Số tiền rút phải lớn hơn 0.", exception.getMessage());
        assertEquals(500.0, account.getBalance(), DELTA);
    }

    @Test
    void withdraw_shouldReturnTrueAndDecreaseBalance_whenAmountIsLessThanBalance() {
        boolean result = account.withdraw(200.0);

        assertTrue(result);
        assertEquals(300.0, account.getBalance(), DELTA);
    }

    @Test
    void withdraw_shouldReturnTrueAndSetBalanceToZero_whenAmountEqualsBalance() {
        boolean result = account.withdraw(500.0);

        assertTrue(result);
        assertEquals(0.0, account.getBalance(), DELTA);
    }

    @Test
    void withdraw_shouldReturnFalseAndKeepBalance_whenAmountGreaterThanBalance() {
        boolean result = account.withdraw(600.0);

        assertFalse(result);
        assertEquals(500.0, account.getBalance(), DELTA);
    }

    // =========================
    // withdraw(double amount)
    // Boundary Value Analysis
    // =========================
    @Test
    void withdraw_shouldThrowException_whenAmountIsJustBelowZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(-0.01)
        );

        assertEquals("Số tiền rút phải lớn hơn 0.", exception.getMessage());
        assertEquals(500.0, account.getBalance(), DELTA);
    }

    @Test
    void withdraw_shouldReturnTrue_whenAmountIsJustAboveZero() {
        boolean result = account.withdraw(0.01);

        assertTrue(result);
        assertEquals(499.99, account.getBalance(), DELTA);
    }

    @Test
    void withdraw_shouldReturnTrue_whenAmountIsJustBelowBalance() {
        boolean result = account.withdraw(499.99);

        assertTrue(result);
        assertEquals(0.01, account.getBalance(), DELTA);
    }

    @Test
    void withdraw_shouldReturnFalse_whenAmountIsJustAboveBalance() {
        boolean result = account.withdraw(500.01);

        assertFalse(result);
        assertEquals(500.0, account.getBalance(), DELTA);
    }

    // =========================
    // Sequential consistency test
    // =========================
    @Test
    void account_shouldKeepConsistentBalance_afterDepositAndWithdrawSequence() {
        BankAccount sequenceAccount = new BankAccount("ACC002", "Tran Thi B");

        assertEquals(0.0, sequenceAccount.getBalance(), DELTA);

        sequenceAccount.deposit(500.0);
        assertEquals(500.0, sequenceAccount.getBalance(), DELTA);

        boolean firstWithdraw = sequenceAccount.withdraw(200.0);
        assertTrue(firstWithdraw);
        assertEquals(300.0, sequenceAccount.getBalance(), DELTA);

        boolean secondWithdraw = sequenceAccount.withdraw(400.0);
        assertFalse(secondWithdraw);
        assertEquals(300.0, sequenceAccount.getBalance(), DELTA);
    }
}
