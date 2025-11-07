package org.tron.core.capsule;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ExchangeProcessorDiffblueTest {
  /**
   * Test {@link ExchangeProcessor#exchange(long, long, long)}.
   * <ul>
   *   <li>Given {@link ExchangeProcessor#ExchangeProcessor(long, boolean)} with supply is five and useStrictMath is {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeProcessor#exchange(long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ExchangeProcessor.exchange(long, long, long)"})
  public void testExchange_givenExchangeProcessorWithSupplyIsFiveAndUseStrictMathIsFalse() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ExchangeProcessor(5L, false)).exchange(42L, 42L, 5L));
  }

  /**
   * Test {@link ExchangeProcessor#exchange(long, long, long)}.
   * <ul>
   *   <li>Given {@link ExchangeProcessor#ExchangeProcessor(long, boolean)} with supply is five and useStrictMath is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeProcessor#exchange(long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ExchangeProcessor.exchange(long, long, long)"})
  public void testExchange_givenExchangeProcessorWithSupplyIsFiveAndUseStrictMathIsTrue() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ExchangeProcessor(5L, true)).exchange(42L, 42L, 5L));
  }

  /**
   * Test {@link ExchangeProcessor#exchange(long, long, long)}.
   * <ul>
   *   <li>When minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeProcessor#exchange(long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ExchangeProcessor.exchange(long, long, long)"})
  public void testExchange_whenMinusOne() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ExchangeProcessor(5L, true)).exchange(-1L, 42L, 5L));
  }

  /**
   * Test {@link ExchangeProcessor#exchange(long, long, long)}.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeProcessor#exchange(long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ExchangeProcessor.exchange(long, long, long)"})
  public void testExchange_whenOne() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ExchangeProcessor(5L, true)).exchange(1L, 42L, 5L));
  }

  /**
   * Test {@link ExchangeProcessor#exchange(long, long, long)}.
   * <ul>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeProcessor#exchange(long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ExchangeProcessor.exchange(long, long, long)"})
  public void testExchange_whenZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ExchangeProcessor(5L, true)).exchange(0L, 42L, 5L));
  }
}
