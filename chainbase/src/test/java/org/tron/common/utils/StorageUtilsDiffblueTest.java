package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StorageUtilsDiffblueTest {
  /**
   * Method under test: {@link StorageUtils#getOutputDirectory()}
   */
  @Test
  public void testGetOutputDirectory() {
    // Arrange, Act and Assert
    assertEquals("output-directory/", StorageUtils.getOutputDirectory());
  }
}
