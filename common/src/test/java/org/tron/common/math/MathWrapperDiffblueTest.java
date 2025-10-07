package org.tron.common.math;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MathWrapperDiffblueTest {
  /**
   * Test {@link MathWrapper#pow(double, double)}.
   *
   * <ul>
   *   <li>When {@code 0.5}.
   *   <li>Then return {@code 9.765625E-4}.
   * </ul>
   *
   * <p>Method under test: {@link MathWrapper#pow(double, double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"double MathWrapper.pow(double, double)"})
  public void testPow_when05_thenReturn9765625e4() {
    // Arrange, Act and Assert
    assertEquals(9.765625E-4d, MathWrapper.pow(0.5d, 10.0d), 0.0);
  }

  /**
   * Test {@link MathWrapper#pow(double, double)}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code 9.765625E-4}.
   * </ul>
   *
   * <p>Method under test: {@link MathWrapper#pow(double, double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"double MathWrapper.pow(double, double)"})
  public void testPow_when05_thenReturn9765625e42() {
    // Arrange, Act and Assert
    assertEquals(9.765625E-4d, MathWrapper.pow(-0.5d, 10.0d), 0.0);
  }

  /**
   * Test {@link MathWrapper#pow(double, double)}.
   *
   * <ul>
   *   <li>When {@link Double#NaN}.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link MathWrapper#pow(double, double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"double MathWrapper.pow(double, double)"})
  public void testPow_whenNaN_thenReturnNaN() {
    // Arrange, Act and Assert
    assertEquals(Double.NaN, MathWrapper.pow(Double.NaN, 10.0d), 0.0);
  }

  /**
   * Test {@link MathWrapper#pow(double, double)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@code 1.0E10}.
   * </ul>
   *
   * <p>Method under test: {@link MathWrapper#pow(double, double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"double MathWrapper.pow(double, double)"})
  public void testPow_whenTen_thenReturn10e10() {
    // Arrange, Act and Assert
    assertEquals(1.0E10d, MathWrapper.pow(10.0d, 10.0d), 0.0);
  }
}
