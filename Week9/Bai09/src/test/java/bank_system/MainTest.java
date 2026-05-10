package bank_system;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class MainTest {
  @Test
  void mainShouldRunWithoutException() {
    assertDoesNotThrow(() -> Main.main(new String[] {}));
  }
}
