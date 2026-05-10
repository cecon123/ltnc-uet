package bank_system;

import java.nio.file.Files;
import java.nio.file.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Service minh họa cách xử lý đường dẫn tương thích đa hệ điều hành. */
public class PathService {
  private static final Logger LOGGER = LoggerFactory.getLogger(PathService.class);

  /**
   * Tạo đường dẫn tới file dữ liệu test bằng Path API thay vì hard-code dấu / hoặc \\.
   *
   * @return đường dẫn tới file sample-data.txt
   */
  public Path getSampleDataPath() {
    Path path = Path.of("src", "test", "resources", "sample-data.txt");
    LOGGER.debug("Sample data path: {}", path);
    return path;
  }

  /**
   * Kiểm tra file dữ liệu test có tồn tại hay không.
   *
   * @return true nếu file tồn tại
   */
  public boolean sampleDataExists() {
    boolean exists = Files.exists(getSampleDataPath());
    LOGGER.info("Sample data exists: {}", exists);
    return exists;
  }
}
