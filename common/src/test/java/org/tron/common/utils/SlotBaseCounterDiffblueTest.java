package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SlotBaseCounterDiffblueTest {
  /**
   * Test {@link SlotBaseCounter#SlotBaseCounter(int)}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link SlotBaseCounter#SlotBaseCounter(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SlotBaseCounter.<init>(int)"})
  public void testNewSlotBaseCounter_whenThree() {
    // Arrange, Act and Assert
    assertEquals(0, new SlotBaseCounter(3).totalCount());
  }

  /**
   * Test {@link SlotBaseCounter#SlotBaseCounter(int)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link SlotBaseCounter#SlotBaseCounter(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SlotBaseCounter.<init>(int)"})
  public void testNewSlotBaseCounter_whenZero() {
    // Arrange, Act and Assert
    assertEquals(0, new SlotBaseCounter(0).totalCount());
  }

  /**
   * Test {@link SlotBaseCounter#increaseSlot(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link SlotBaseCounter#SlotBaseCounter(int)} with slotSize is three totalCount is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link SlotBaseCounter#increaseSlot(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SlotBaseCounter.increaseSlot(int)"})
  public void testIncreaseSlot_whenOne_thenSlotBaseCounterWithSlotSizeIsThreeTotalCountIsOne() {
    // Arrange
    SlotBaseCounter slotBaseCounter = new SlotBaseCounter(3);

    // Act
    slotBaseCounter.increaseSlot(1);

    // Assert
    assertEquals(1, slotBaseCounter.totalCount());
  }

  /**
   * Test {@link SlotBaseCounter#totalCount()}.
   *
   * <p>Method under test: {@link SlotBaseCounter#totalCount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int SlotBaseCounter.totalCount()"})
  public void testTotalCount() {
    // Arrange, Act and Assert
    assertEquals(0, new SlotBaseCounter(3).totalCount());
  }

  /**
   * Test {@link SlotBaseCounter#toString()}.
   *
   * <p>Method under test: {@link SlotBaseCounter#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SlotBaseCounter.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("[0, 0, 0]", new SlotBaseCounter(3).toString());
  }
}
