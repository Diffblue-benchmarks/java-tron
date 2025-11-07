package org.tron.plugins;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class DbRootDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link DbRoot}
   */
  @Test
  public void testNewDbRoot() {
    // Arrange, Act and Assert
    assertNull((new DbRoot()).spec);
  }
}
