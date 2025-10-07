package org.tron.plugins.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FileUtilsDiffblueTest {
  /**
   * Test {@link FileUtils#readProperty(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link FileUtils#readProperty(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FileUtils.readProperty(String, String)"})
  public void testReadProperty_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", FileUtils.readProperty("", "Key"));
  }

  /**
   * Test {@link FileUtils#readProperty(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link FileUtils#readProperty(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FileUtils.readProperty(String, String)"})
  public void testReadProperty_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", FileUtils.readProperty("File", null));
  }

  /**
   * Test {@link FileUtils#createFileIfNotExists(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FileUtils#createFileIfNotExists(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FileUtils.createFileIfNotExists(String)"})
  public void testCreateFileIfNotExists_when42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(FileUtils.createFileIfNotExists("42"));
  }

  /**
   * Test {@link FileUtils#createDirIfNotExists(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FileUtils#createDirIfNotExists(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FileUtils.createDirIfNotExists(String)"})
  public void testCreateDirIfNotExists_when42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(FileUtils.createDirIfNotExists("42"));
  }

  /**
   * Test {@link FileUtils#isExists(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FileUtils#isExists(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FileUtils.isExists(String)"})
  public void testIsExists_when42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(FileUtils.isExists("42"));
  }

  /**
   * Test {@link FileUtils#isExists(String)}.
   *
   * <ul>
   *   <li>When {@code Path}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FileUtils#isExists(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FileUtils.isExists(String)"})
  public void testIsExists_whenPath_thenReturnFalse() {
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
