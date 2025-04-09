package org.tron.plugins.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileUtils#readProperty(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FileUtils.readProperty(String, String)"})
  public void testReadProperty_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", FileUtils.readProperty("", "Key"));
  }

  /**
   * Test {@link FileUtils#readProperty(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileUtils#readProperty(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FileUtils.readProperty(String, String)"})
  public void testReadProperty_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", FileUtils.readProperty("File", null));
  }

  /**
   * Test {@link FileUtils#createFileIfNotExists(String)}.
   * <p>
   * Method under test: {@link FileUtils#createFileIfNotExists(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FileUtils.createFileIfNotExists(String)"})
  public void testCreateFileIfNotExists() {
    // Arrange, Act and Assert
    assertFalse(FileUtils.createFileIfNotExists("/directory/foo.txt"));
  }

  /**
   * Test {@link FileUtils#isExists(String)}.
   * <p>
   * Method under test: {@link FileUtils#isExists(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FileUtils.isExists(String)"})
  public void testIsExists() {
    // Arrange, Act and Assert
    assertFalse(FileUtils.isExists("Path"));
  }

  /**
   * Test {@link FileUtils#isSymbolicLink(File)}.
   * <p>
   * Method under test: {@link FileUtils#isSymbolicLink(File)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FileUtils.isSymbolicLink(File)"})
  public void testIsSymbolicLink() throws IOException {
    // Arrange, Act and Assert
    assertFalse(FileUtils.isSymbolicLink(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
  }

  /**
   * Test {@link FileUtils#copy(Path, Path)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is empty string.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileUtils#copy(Path, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FileUtils.copy(Path, Path)"})
  public void testCopy_whenPropertyIsJavaIoTmpdirIsEmptyString_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> FileUtils.copy(Paths.get(System.getProperty("java.io.tmpdir"), ".sst"),
        Paths.get(System.getProperty("java.io.tmpdir"), "")));
  }

  /**
   * Test {@link FileUtils#copy(Path, Path)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code .sst}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileUtils#copy(Path, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FileUtils.copy(Path, Path)"})
  public void testCopy_whenPropertyIsJavaIoTmpdirIsSst_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> FileUtils.copy(Paths.get(System.getProperty("java.io.tmpdir"), ".sst"),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }

  /**
   * Test {@link FileUtils#copy(Path, Path)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileUtils#copy(Path, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FileUtils.copy(Path, Path)"})
  public void testCopy_whenPropertyIsJavaIoTmpdirIsTestTxt_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> FileUtils.copy(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }
}
