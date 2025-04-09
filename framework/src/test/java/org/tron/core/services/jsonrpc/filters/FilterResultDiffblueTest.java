package org.tron.core.services.jsonrpc.filters;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.BlockingQueue;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FilterResultDiffblueTest {
  /**
   * Test {@link FilterResult#isExpire()}.
   * <p>
   * Method under test: {@link FilterResult#isExpire()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FilterResult.isExpire()"})
  public void testIsExpire() {
    // Arrange, Act and Assert
    assertFalse((new BlockFilterAndResult()).isExpire());
  }

  /**
   * Test {@link FilterResult#getResult()}.
   * <p>
   * Method under test: {@link FilterResult#getResult()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockingQueue FilterResult.getResult()"})
  public void testGetResult() {
    // Arrange
    BlockFilterAndResult blockFilterAndResult = new BlockFilterAndResult();

    // Act
    BlockingQueue<String> actualResult = blockFilterAndResult.getResult();

    // Assert
    assertTrue(actualResult.isEmpty());
    assertSame(blockFilterAndResult.result, actualResult);
  }
}
