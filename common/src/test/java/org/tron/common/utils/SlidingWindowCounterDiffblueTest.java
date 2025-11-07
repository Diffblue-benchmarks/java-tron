package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SlidingWindowCounterDiffblueTest {
  /**
   * Method under test: {@link SlidingWindowCounter#increase()}
   */
  @Test
  public void testIncrease() {
    // Arrange
    SlidingWindowCounter slidingWindowCounter = new SlidingWindowCounter(3);

    // Act
    slidingWindowCounter.increase();

    // Assert
    assertEquals(1, slidingWindowCounter.totalCount());
  }

  /**
   * Method under test: {@link SlidingWindowCounter#totalAndAdvance()}
   */
  @Test
  public void testTotalAndAdvance() {
    // Arrange, Act and Assert
    assertEquals(0, (new SlidingWindowCounter(3)).totalAndAdvance());
  }

  /**
   * Method under test: {@link SlidingWindowCounter#totalCount()}
   */
  @Test
  public void testTotalCount() {
    // Arrange, Act and Assert
    assertEquals(0, (new SlidingWindowCounter(3)).totalCount());
  }

  /**
   * Method under test: {@link SlidingWindowCounter#SlidingWindowCounter(int)}
   */
  @Test
  public void testNewSlidingWindowCounter() {
    // Arrange, Act and Assert
    assertEquals(0, (new SlidingWindowCounter(3)).totalCount());
    assertEquals(0, (new SlidingWindowCounter(0)).totalCount());
  }

  /**
   * Method under test: {@link SlidingWindowCounter#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("total = 0 head = 0 >> [0, 0, 0]", (new SlidingWindowCounter(3)).toString());
  }
}
