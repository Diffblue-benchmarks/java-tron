package org.tron.common.math;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StrictMathWrapperDiffblueTest {
  /**
   * Method under test: {@link StrictMathWrapper#pow(double, double)}
   */
  @Test
  public void testPow() {
    // Arrange, Act and Assert
    assertEquals(1.0E10d, StrictMathWrapper.pow(10.0d, 10.0d), 0.0);
    assertEquals(9.765625E-4d, StrictMathWrapper.pow(0.5d, 10.0d), 0.0);
    assertEquals(9.765625E-4d, StrictMathWrapper.pow(-0.5d, 10.0d), 0.0);
    assertEquals(Double.NaN, StrictMathWrapper.pow(Double.NaN, 10.0d), 0.0);
  }
}
