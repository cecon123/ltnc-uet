package bank_system;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class PathCompatibilityTest {

  @Test
  void pathShouldWorkOnAllOperatingSystemsUsingPathApi() {
    Path path = Path.of("src", "test", "resources", "sample-data.txt");

    assertTrue(Files.exists(path));
  }

  @Test
  void pathServiceShouldFindSampleDataFile() {
    PathService service = new PathService();

    assertTrue(service.sampleDataExists());
  }
}
