package org.tron.core.services.jsonrpc.filters;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.concurrent.BlockingQueue;
import org.junit.Test;

public class FilterResultDiffblueTest {
  /**
   * Method under test: {@link FilterResult#getResult()}
   */
  @Test
  public void testGetResult() {
    // Arrange
    BlockFilterAndResult blockFilterAndResult = new BlockFilterAndResult();

    // Act
    BlockingQueue<String> actualResult = blockFilterAndResult.getResult();

    // Assert
    assertTrue(actualResult.isEmpty());
    assertSame(blockFilterAndResult.result, actualResult);
  }

  /**
   * Method under test: {@link FilterResult#isExpire()}
   */
  @Test
  public void testIsExpire() {
    // Arrange, Act and Assert
    assertFalse((new BlockFilterAndResult()).isExpire());
  }
}
