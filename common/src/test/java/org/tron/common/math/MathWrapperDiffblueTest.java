package org.tron.common.math;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MathWrapperDiffblueTest {
  /**
   * Test {@link MathWrapper#pow(double, double)}.
   * <ul>
   *   <li>When {@code 0.5}.</li>
   *   <li>Then return {@code 9.765625E-4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MathWrapper#pow(double, double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"double MathWrapper.pow(double, double)"})
  public void testPow_when05_thenReturn9765625e4() {
    // Arrange, Act and Assert
    assertEquals(9.765625E-4d, MathWrapper.pow(0.5d, 10.0d), 0.0);
  }

  /**
   * Test {@link MathWrapper#pow(double, double)}.
   * <ul>
   *   <li>When {@code -0.5}.</li>
   *   <li>Then return {@code 9.765625E-4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MathWrapper#pow(double, double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"double MathWrapper.pow(double, double)"})
  public void testPow_when05_thenReturn9765625e42() {
    // Arrange, Act and Assert
    assertEquals(9.765625E-4d, MathWrapper.pow(-0.5d, 10.0d), 0.0);
  }

  /**
   * Test {@link MathWrapper#pow(double, double)}.
   * <ul>
   *   <li>When {@link Double#NaN}.</li>
   *   <li>Then return {@link Double#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MathWrapper#pow(double, double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"double MathWrapper.pow(double, double)"})
  public void testPow_whenNaN_thenReturnNaN() {
    // Arrange, Act and Assert
    assertEquals(Double.NaN, MathWrapper.pow(Double.NaN, 10.0d), 0.0);
  }

  /**
   * Test {@link MathWrapper#pow(double, double)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return {@code 1.0E10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MathWrapper#pow(double, double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"double MathWrapper.pow(double, double)"})
  public void testPow_whenTen_thenReturn10e10() {
    // Arrange, Act and Assert
    assertEquals(1.0E10d, MathWrapper.pow(10.0d, 10.0d), 0.0);
  }
}
