package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class PropUtilDiffblueTest {
  /**
   * Method under test: {@link PropUtil#readProperty(String, String)}
   */
  @Test
  public void testReadProperty() {
    // Arrange, Act and Assert
    assertEquals("", PropUtil.readProperty("File", "Key"));
  }

  /**
   * Method under test: {@link PropUtil#writeProperty(String, String, String)}
   */
  @Test
  public void testWriteProperty() {
    // Arrange, Act and Assert
    assertFalse(PropUtil.writeProperty("File", "Key", "42"));
  }
}
