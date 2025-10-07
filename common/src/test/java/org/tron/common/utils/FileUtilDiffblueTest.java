package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <ul>
   *   <li>When {@code Path}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FileUtil#recursiveList(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FileUtil.recursiveList(String)"})
  public void testRecursiveList_whenPath_thenReturnEmpty() throws IOException {
    // Arrange and Act
    List<String> actualRecursiveListResult = FileUtil.recursiveList("Path");

    // Assert
    assertTrue(actualRecursiveListResult.isEmpty());
  }

  /**
   * Test {@link FileUtil#recursiveDelete(String)}.
   *
   * <p>Method under test: {@link FileUtil#recursiveDelete(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FileUtil.recursiveDelete(String)"})
  public void testRecursiveDelete() {
    // Arrange, Act and Assert
    assertFalse(FileUtil.recursiveDelete("foo.txt"));
  }

  /**
   * Test {@link FileUtil#readData(String, char[])}.
   *
   * <p>Method under test: {@link FileUtil#readData(String, char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int FileUtil.readData(String, char[])"})
  public void testReadData() {
    // Arrange and Act
    int actualReadDataResult = FileUtil.readData("/directory/foo.txt", "AZAZ".toCharArray());

    // Assert
    assertEquals(0, actualReadDataResult);
  }

  /**
   * Test {@link FileUtil#deleteDir(File)}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toFile.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FileUtil#deleteDir(File)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FileUtil.deleteDir(File)"})
  public void testDeleteDir_whenPropertyIsJavaIoTmpdirIsTestTxtToFile_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        FileUtil.deleteDir(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
  }

  /**
   * Test {@link FileUtil#isExists(String)}.
   *
   * <p>Method under test: {@link FileUtil#isExists(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FileUtil.isExists(String)"})
  public void testIsExists() {
    // Arrange, Act and Assert
    assertFalse(FileUtil.isExists("Path"));
  }
}
