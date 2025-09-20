package org.tron.plugins;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.plugins.DbMove.ConfigConverter;
import org.tron.plugins.DbMove.PathConverter;
import org.tron.plugins.DbMove.Property;

public class DbMoveDiffblueTest {
  /**
   * Test ConfigConverter {@link ConfigConverter#convert(String)}.
   *
   * <ul>
   *   <li>When {@code storage.properties}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigConverter#convert(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"com.typesafe.config.Config ConfigConverter.convert(String)"})
  public void testConfigConverterConvert_whenStorageProperties_thenThrowIOException()
      throws Exception {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new ConfigConverter().convert("storage.properties"));
  }

  /**
   * Test new {@link DbMove} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link DbMove}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DbMove.<init>()"})
  public void testNewDbMove() {
    // Arrange and Act
    DbMove actualDbMove = new DbMove();

    // Assert
    assertNull(actualDbMove.config);
    assertNull(actualDbMove.spec);
  }

  /**
   * Test PathConverter {@link PathConverter#convert(String)}.
   *
   * <ul>
   *   <li>When {@code DB path [}.
   * </ul>
   *
   * <p>Method under test: {@link PathConverter#convert(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path PathConverter.convert(String)"})
  public void testPathConverterConvert_whenDbPath() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PathConverter().convert("DB path ["));
  }

  /**
   * Test Property {@link Property#Property(String, Path, Path)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link Property#Property(String, Path, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Property.<init>(String, Path, Path)"})
  public void testPropertyNewProperty_thenThrowIOException() throws IOException {
    // Arrange
    Path original = Paths.get(System.getProperty("java.io.tmpdir"), "");
    Path destination = Paths.get(System.getProperty("java.io.tmpdir"), "");

    // Act and Assert
    assertThrows(IOException.class, () -> new Property("Name", original, destination));
  }

  /**
   * Test Property {@link Property#Property(String, Path, Path)}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link Property#Property(String, Path, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Property.<init>(String, Path, Path)"})
  public void testPropertyNewProperty_whenPropertyIsJavaIoTmpdirIsTestTxt_thenThrowIOException()
      throws IOException {
    // Arrange
    Path original = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    Path destination = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertThrows(IOException.class, () -> new Property("Name", original, destination));
  }
}
