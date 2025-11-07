package org.tron.core.services.ratelimiter;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RuntimeDataDiffblueTest {
  /**
   * Method under test: {@link RuntimeData#getRemoteAddr()}
   */
  @Test
  public void testGetRemoteAddr() {
    // Arrange, Act and Assert
    assertEquals("", (new RuntimeData("42")).getRemoteAddr());
  }

  /**
   * Method under test: {@link RuntimeData#RuntimeData(Object)}
   */
  @Test
  public void testNewRuntimeData() {
    // Arrange, Act and Assert
    assertEquals("", (new RuntimeData("42")).getRemoteAddr());
  }
}
