package org.tron.common.math;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MathsDiffblueTest {
  /**
   * Test {@link Maths#pow(double, double, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Maths#pow(double, double, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"double Maths.pow(double, double, boolean)"})
  public void testPow_whenFalse() {
    // Arrange, Act and Assert
    assertEquals(1.0E10d, Maths.pow(10.0d, 10.0d, false), 0.0);
  }

  /**
   * Test {@link Maths#pow(double, double, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Maths#pow(double, double, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"double Maths.pow(double, double, boolean)"})
  public void testPow_whenTrue() {
    // Arrange, Act and Assert
    assertEquals(1.0E10d, Maths.pow(10.0d, 10.0d, true), 0.0);
  }
}
