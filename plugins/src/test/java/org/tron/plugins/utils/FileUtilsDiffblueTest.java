package org.tron.plugins.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

public class FileUtilsDiffblueTest {
  /**
   * Method under test: {@link FileUtils#isLevelDBEngine(Path)}
   */
  @Test
  public void testIsLevelDBEngine() {
    // Arrange, Act and Assert
    assertFalse(FileUtils.isLevelDBEngine(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }

  /**
   * Method under test: {@link FileUtils#createFileIfNotExists(String)}
   */
  @Test
  public void testCreateFileIfNotExists() {
    // Arrange, Act and Assert
    assertFalse(FileUtils.createFileIfNotExists("/directory/foo.txt"));
  }

  /**
   * Method under test: {@link FileUtils#isExists(String)}
   */
  @Test
  public void testIsExists() {
    // Arrange, Act and Assert
    assertFalse(FileUtils.isExists("Path"));
  }

  /**
   * Method under test: {@link FileUtils#isSymbolicLink(File)}
   */
  @Test
  public void testIsSymbolicLink() throws IOException {
    // Arrange, Act and Assert
    assertFalse(FileUtils.isSymbolicLink(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
  }

  /**
   * Method under test: {@link FileUtils#copy(Path, Path)}
   */
  @Test
  public void testCopy() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> FileUtils.copy(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
    assertThrows(RuntimeException.class, () -> FileUtils.copy(Paths.get(System.getProperty("java.io.tmpdir"), ".sst"),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }
}
