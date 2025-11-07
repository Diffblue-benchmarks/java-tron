package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import org.junit.Test;

public class FileUtilDiffblueTest {
  /**
   * Method under test: {@link FileUtil#recursiveList(String)}
   */
  @Test
  public void testRecursiveList() throws IOException {
    // Arrange and Act
    List<String> actualRecursiveListResult = FileUtil.recursiveList("Path");

    // Assert
    assertTrue(actualRecursiveListResult.isEmpty());
  }

  /**
   * Method under test: {@link FileUtil#recursiveDelete(String)}
   */
  @Test
  public void testRecursiveDelete() {
    // Arrange, Act and Assert
    assertFalse(FileUtil.recursiveDelete("foo.txt"));
  }

  /**
   * Method under test: {@link FileUtil#readData(String, char[])}
   */
  @Test
  public void testReadData() {
    // Arrange, Act and Assert
    assertEquals(0, FileUtil.readData("/directory/foo.txt", "AZAZ".toCharArray()));
  }

  /**
   * Method under test: {@link FileUtil#deleteDir(File)}
   */
  @Test
  public void testDeleteDir() {
    // Arrange, Act and Assert
    assertFalse(FileUtil.deleteDir(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
  }

  /**
   * Method under test: {@link FileUtil#createFileIfNotExists(String)}
   */
  @Test
  public void testCreateFileIfNotExists() {
    // Arrange, Act and Assert
    assertFalse(FileUtil.createFileIfNotExists("/directory/foo.txt"));
  }

  /**
   * Method under test: {@link FileUtil#isExists(String)}
   */
  @Test
  public void testIsExists() {
    // Arrange, Act and Assert
    assertFalse(FileUtil.isExists("Path"));
  }
}
