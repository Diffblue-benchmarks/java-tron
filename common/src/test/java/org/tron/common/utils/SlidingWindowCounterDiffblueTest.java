package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SlidingWindowCounterDiffblueTest {
  /**
   * Test {@link SlidingWindowCounter#SlidingWindowCounter(int)}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link SlidingWindowCounter#SlidingWindowCounter(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SlidingWindowCounter.<init>(int)"})
  public void testNewSlidingWindowCounter_whenThree() {
    // Arrange, Act and Assert
    assertEquals(0, new SlidingWindowCounter(3).totalCount());
  }

  /**
   * Test {@link SlidingWindowCounter#SlidingWindowCounter(int)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link SlidingWindowCounter#SlidingWindowCounter(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SlidingWindowCounter.<init>(int)"})
  public void testNewSlidingWindowCounter_whenZero() {
    // Arrange, Act and Assert
    assertEquals(0, new SlidingWindowCounter(0).totalCount());
  }

  /**
   * Test {@link SlidingWindowCounter#increase()}.
   *
   * <p>Method under test: {@link SlidingWindowCounter#increase()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SlidingWindowCounter.increase()"})
  public void testIncrease() {
    // Arrange
    SlidingWindowCounter slidingWindowCounter = new SlidingWindowCounter(3);

    // Act
    slidingWindowCounter.increase();

    // Assert
    assertEquals(1, slidingWindowCounter.totalCount());
  }

  /**
   * Test {@link SlidingWindowCounter#totalAndAdvance()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SlidingWindowCounter#totalAndAdvance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int SlidingWindowCounter.totalAndAdvance()"})
  public void testTotalAndAdvance_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new SlidingWindowCounter(3).totalAndAdvance());
  }

  /**
   * Test {@link SlidingWindowCounter#totalCount()}.
   *
   * <p>Method under test: {@link SlidingWindowCounter#totalCount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int SlidingWindowCounter.totalCount()"})
  public void testTotalCount() {
    // Arrange, Act and Assert
    assertEquals(0, new SlidingWindowCounter(3).totalCount());
  }

  /**
   * Test {@link SlidingWindowCounter#toString()}.
   *
   * <p>Method under test: {@link SlidingWindowCounter#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SlidingWindowCounter.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("total = 0 head = 0 >> [0, 0, 0]", new SlidingWindowCounter(3).toString());
  }
}
