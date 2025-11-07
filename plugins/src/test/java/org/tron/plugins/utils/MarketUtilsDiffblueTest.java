package org.tron.plugins.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MarketUtilsDiffblueTest {
  /**
   * Test {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.createPairPriceKey(byte[], byte[], long, long)"})
  public void testCreatePairPriceKey_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    byte[] sellTokenId = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A',
            'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
        MarketUtils.createPairPriceKey(sellTokenId, "AXAXAXAX".getBytes("UTF-8"), 1L, 1L));
  }

  /**
   * Test {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}.
   * <ul>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.createPairPriceKey(byte[], byte[], long, long)"})
  public void testCreatePairPriceKey_whenZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] sellTokenId = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A',
            'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        MarketUtils.createPairPriceKey(sellTokenId, "AXAXAXAX".getBytes("UTF-8"), 0L, 1L));
  }

  /**
   * Test {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}.
   * <ul>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.createPairPriceKey(byte[], byte[], long, long)"})
  public void testCreatePairPriceKey_whenZero2() throws UnsupportedEncodingException {
    // Arrange
    byte[] sellTokenId = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A',
            'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        MarketUtils.createPairPriceKey(sellTokenId, "AXAXAXAX".getBytes("UTF-8"), 1L, 0L));
  }

  /**
   * Test {@link MarketUtils#findGCD(long, long)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return five.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#findGCD(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketUtils.findGCD(long, long)"})
  public void testFindGCD_whenFive_thenReturnFive() {
    // Arrange, Act and Assert
    assertEquals(5L, MarketUtils.findGCD(5L, 5L));
  }

  /**
   * Test {@link MarketUtils#findGCD(long, long)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#findGCD(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketUtils.findGCD(long, long)"})
  public void testFindGCD_whenMinusOne_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1L, MarketUtils.findGCD(-1L, 5L));
  }

  /**
   * Test {@link MarketUtils#findGCD(long, long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#findGCD(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketUtils.findGCD(long, long)"})
  public void testFindGCD_whenOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1L, MarketUtils.findGCD(1L, 5L));
  }

  /**
   * Test {@link MarketUtils#findGCD(long, long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#findGCD(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketUtils.findGCD(long, long)"})
  public void testFindGCD_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, MarketUtils.findGCD(0L, 5L));
  }

  /**
   * Test {@link MarketUtils#findGCD(long, long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#findGCD(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketUtils.findGCD(long, long)"})
  public void testFindGCD_whenZero_thenReturnZero2() {
    // Arrange, Act and Assert
    assertEquals(0L, MarketUtils.findGCD(5L, 0L));
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void testComparePrice_whenFive_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, MarketUtils.comparePrice(5L, 5L, 5L, 5L));
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)}.
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void testComparePrice_whenMax_value_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, MarketUtils.comparePrice(Long.MAX_VALUE, 5L, 5L, 5L));
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)}.
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void testComparePrice_whenMax_value_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, MarketUtils.comparePrice(5L, Long.MAX_VALUE, 5L, 5L));
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void testComparePrice_whenMinusOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, MarketUtils.comparePrice(-1L, 5L, 5L, 5L));
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void testComparePrice_whenOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, MarketUtils.comparePrice(1L, 5L, 5L, 5L));
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void testComparePrice_whenZero_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, MarketUtils.comparePrice(0L, 5L, 5L, 5L));
  }
}
