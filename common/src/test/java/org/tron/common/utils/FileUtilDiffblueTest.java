package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FileUtilDiffblueTest {
  /**
   * Test {@link FileUtil#recursiveList(String)}.
   * <ul>
   *   <li>When {@code Path}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileUtil#recursiveList(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FileUtil.recursiveList(String)"})
  public void testRecursiveList_whenPath_thenReturnEmpty() throws IOException {
    // Arrange and Act
    List<String> actualRecursiveListResult = FileUtil.recursiveList("Path");

    // Assert
    assertTrue(actualRecursiveListResult.isEmpty());
  }

  /**
   * Test {@link FileUtil#recursiveDelete(String)}.
   * <p>
   * Method under test: {@link FileUtil#recursiveDelete(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FileUtil.recursiveDelete(String)"})
  public void testRecursiveDelete() {
    // Arrange, Act and Assert
    assertFalse(FileUtil.recursiveDelete("foo.txt"));
  }

  /**
   * Test {@link FileUtil#readData(String, char[])}.
   * <p>
   * Method under test: {@link FileUtil#readData(String, char[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int FileUtil.readData(String, char[])"})
  public void testReadData() {
    // Arrange, Act and Assert
    assertEquals(0, FileUtil.readData("/directory/foo.txt", "AZAZ".toCharArray()));
  }

  /**
   * Test {@link FileUtil#deleteDir(File)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toFile.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileUtil#deleteDir(File)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FileUtil.deleteDir(File)"})
  public void testDeleteDir_whenPropertyIsJavaIoTmpdirIsTestTxtToFile_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(FileUtil.deleteDir(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
  }

  /**
   * Test {@link FileUtil#createFileIfNotExists(String)}.
   * <p>
   * Method under test: {@link FileUtil#createFileIfNotExists(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FileUtil.createFileIfNotExists(String)"})
  public void testCreateFileIfNotExists() {
    // Arrange, Act and Assert
    assertFalse(FileUtil.createFileIfNotExists("/directory/foo.txt"));
  }

  /**
   * Test {@link FileUtil#isExists(String)}.
   * <p>
   * Method under test: {@link FileUtil#isExists(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FileUtil.isExists(String)"})
  public void testIsExists() {
    // Arrange, Act and Assert
    assertFalse(FileUtil.isExists("Path"));
  }
}
