package org.tron.common.math;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MathsDiffblueTest {
  /**
   * Method under test: {@link Maths#pow(double, double, boolean)}
   */
  @Test
  public void testPow() {
    // Arrange, Act and Assert
    assertEquals(1.0E10d, Maths.pow(10.0d, 10.0d, true), 0.0);
    assertEquals(1.0E10d, Maths.pow(10.0d, 10.0d, false), 0.0);
  }
}
