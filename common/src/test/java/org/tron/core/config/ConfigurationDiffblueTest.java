package org.tron.core.config;

import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class ConfigurationDiffblueTest {
  /**
   * Method under test: {@link Configuration#getByFileName(String, String)}
   */
  @Test
  public void testGetByFileName() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Configuration.getByFileName("foo.txt", "foo.txt"));
    assertThrows(IllegalArgumentException.class, () -> Configuration.getByFileName(null, "foo.txt"));
    assertThrows(IllegalArgumentException.class, () -> Configuration.getByFileName("", "foo.txt"));
    assertThrows(IllegalArgumentException.class, () -> Configuration.getByFileName(null, null));
  }
}
