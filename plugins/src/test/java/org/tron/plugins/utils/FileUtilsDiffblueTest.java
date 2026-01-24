package org.tron.plugins.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FileUtilsDiffblueTest {
  /**
   * Test {@link FileUtils#readProperty(String, String)}.
   *
   * <p>Method under test: {@link FileUtils#readProperty(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FileUtils.readProperty(String, String)"})
  public void testReadProperty() {
    // Arrange, Act and Assert
    assertEquals("", FileUtils.readProperty("File", "Key"));
  }

  /**
   * Test {@link FileUtils#isExists(String)}.
   *
   * <p>Method under test: {@link FileUtils#isExists(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FileUtils.isExists(String)"})
  public void testIsExists() {
    // Arrange, Act and Assert
    assertFalse(FileUtils.isExists("Path"));
  }

  /**
   * Test {@link FileUtils#isSymbolicLink(File)}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toFile.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FileUtils#isSymbolicLink(File)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FileUtils.isSymbolicLink(File)"})
  public void testIsSymbolicLink_whenPropertyIsJavaIoTmpdirIsTestTxtToFile_thenReturnFalse()
      throws IOException {
    // Arrange, Act and Assert
    assertFalse(
        FileUtils.isSymbolicLink(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
  }
}
