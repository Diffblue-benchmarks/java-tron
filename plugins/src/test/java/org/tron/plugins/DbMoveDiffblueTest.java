package org.tron.plugins;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

public class DbMoveDiffblueTest {
  /**
   * Method under test: {@link DbMove.ConfigConverter#convert(String)}
   */
  @Test
  public void testConfigConverterConvert() throws Exception {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new DbMove.ConfigConverter()).convert("42"));
  }

  /**
   * Method under test: default or parameterless constructor of {@link DbMove}
   */
  @Test
  public void testNewDbMove() {
    // Arrange and Act
    DbMove actualDbMove = new DbMove();

    // Assert
    assertNull(actualDbMove.config);
    assertNull(actualDbMove.spec);
  }

  /**
   * Method under test: {@link DbMove.PathConverter#convert(String)}
   */
  @Test
  public void testPathConverterConvert() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new DbMove.PathConverter()).convert("42"));
  }

  /**
   * Method under test: {@link DbMove.Property#Property(String, Path, Path)}
   */
  @Test
  public void testPropertyNewProperty() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> new DbMove.Property("Name", Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));

    assertThrows(IOException.class, () -> new DbMove.Property("Name",
        Paths.get(System.getProperty("java.io.tmpdir"), ""), Paths.get(System.getProperty("java.io.tmpdir"), "")));
  }
}
