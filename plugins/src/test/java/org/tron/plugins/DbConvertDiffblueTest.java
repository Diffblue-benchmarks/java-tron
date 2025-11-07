package org.tron.plugins;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DbConvertDiffblueTest {
  /**
   * Method under test: {@link DbConvert.DbConverter#name()}
   */
  @Test
  public void testDbConverterName() {
    // Arrange, Act and Assert
    assertEquals("Name", (new DbConvert.DbConverter("Src Dir", "Dst Dir", "Name", true)).name());
  }

  /**
   * Method under test:
   * {@link DbConvert.DbConverter#DbConverter(String, String, String, boolean)}
   */
  @Test
  public void testDbConverterNewDbConverter() {
    // Arrange, Act and Assert
    assertEquals("Name", (new DbConvert.DbConverter("Src Dir", "Dst Dir", "Name", true)).name());
  }
}
