package org.tron.plugins;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ToolkitDiffblueTest {
  /**
   * Method under test: {@link Toolkit#call()}
   */
  @Test
  public void testCall() throws Exception {
    // Arrange, Act and Assert
    assertEquals(0, (new Toolkit()).call().intValue());
  }
}
