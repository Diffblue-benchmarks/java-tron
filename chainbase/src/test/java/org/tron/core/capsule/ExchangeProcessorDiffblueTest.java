package org.tron.core.capsule;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ExchangeProcessorDiffblueTest {
  /**
   * Method under test: {@link ExchangeProcessor#exchange(long, long, long)}
   */
  @Test
  public void testExchange() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ExchangeProcessor(5L, true)).exchange(42L, 42L, 5L));
    assertEquals(0L, (new ExchangeProcessor(5L, false)).exchange(42L, 42L, 5L));
    assertEquals(0L, (new ExchangeProcessor(5L, true)).exchange(1L, 42L, 5L));
    assertEquals(0L, (new ExchangeProcessor(5L, true)).exchange(0L, 42L, 5L));
    assertEquals(0L, (new ExchangeProcessor(5L, true)).exchange(-1L, 42L, 5L));
  }
}
