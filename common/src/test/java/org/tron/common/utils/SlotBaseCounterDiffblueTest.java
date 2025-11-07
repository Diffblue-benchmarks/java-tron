package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SlotBaseCounterDiffblueTest {
  /**
   * Method under test: {@link SlotBaseCounter#increaseSlot(int)}
   */
  @Test
  public void testIncreaseSlot() {
    // Arrange
    SlotBaseCounter slotBaseCounter = new SlotBaseCounter(3);

    // Act
    slotBaseCounter.increaseSlot(1);

    // Assert
    assertEquals(1, slotBaseCounter.totalCount());
  }

  /**
   * Method under test: {@link SlotBaseCounter#totalCount()}
   */
  @Test
  public void testTotalCount() {
    // Arrange, Act and Assert
    assertEquals(0, (new SlotBaseCounter(3)).totalCount());
  }

  /**
   * Method under test: {@link SlotBaseCounter#SlotBaseCounter(int)}
   */
  @Test
  public void testNewSlotBaseCounter() {
    // Arrange, Act and Assert
    assertEquals(0, (new SlotBaseCounter(3)).totalCount());
    assertEquals(0, (new SlotBaseCounter(0)).totalCount());
  }

  /**
   * Method under test: {@link SlotBaseCounter#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("[0, 0, 0]", (new SlotBaseCounter(3)).toString());
  }
}
