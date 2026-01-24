package org.tron.plugins;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.plugins.DbMove.PathConverter;
import org.tron.plugins.DbMove.Property;

public class DbMoveDiffblueTest {
  /**
   * Test new {@link DbMove} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link DbMove}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   * <p>Method under test: {@link PathConverter#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Path PathConverter.convert(String)"})
  public void testPathConverterConvert() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PathConverter().convert("42"));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
