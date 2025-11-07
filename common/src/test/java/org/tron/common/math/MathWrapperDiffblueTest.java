package org.tron.common.math;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MathWrapperDiffblueTest {
  /**
   * Method under test: {@link MathWrapper#pow(double, double)}
   */
  @Test
  public void testPow() {
    // Arrange, Act and Assert
    assertEquals(1.0E10d, MathWrapper.pow(10.0d, 10.0d), 0.0);
    assertEquals(9.765625E-4d, MathWrapper.pow(0.5d, 10.0d), 0.0);
    assertEquals(9.765625E-4d, MathWrapper.pow(-0.5d, 10.0d), 0.0);
    assertEquals(Double.NaN, MathWrapper.pow(Double.NaN, 10.0d), 0.0);
  }
}
