package org.tron.plugins.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MarketUtilsDiffblueTest {
  /**
   * Test {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketUtils.createPairPriceKey(byte[], byte[], long, long)"})
  public void testCreatePairPriceKey_whenA() {
    // Arrange and Act
    byte[] actualCreatePairPriceKeyResult =
        MarketUtils.createPairPriceKey(
            new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            0L,
            0L);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
          'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0
        },
        actualCreatePairPriceKeyResult);
  }

  /**
   * Test {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketUtils.createPairPriceKey(byte[], byte[], long, long)"})
  public void testCreatePairPriceKey_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualCreatePairPriceKeyResult =
        MarketUtils.createPairPriceKey(
            "AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"), 1L, 1L);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
          'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0,
          0, 0, 0, 0, 1
        },
        actualCreatePairPriceKeyResult);
  }

  /**
   * Test {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketUtils.createPairPriceKey(byte[], byte[], long, long)"})
  public void testCreatePairPriceKey_whenAxaxaxaxBytesIsUtf82()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualCreatePairPriceKeyResult =
        MarketUtils.createPairPriceKey(
            "AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"), 1L, 0L);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
          'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0,
          0, 0, 0, 0, 0
        },
        actualCreatePairPriceKeyResult);
  }

  /**
   * Test {@link MarketUtils#findGCD(long, long)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return five.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#findGCD(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long MarketUtils.findGCD(long, long)"})
  public void testFindGCD_whenFive_thenReturnFive() {
    // Arrange, Act and Assert
    assertEquals(5L, MarketUtils.findGCD(5L, 5L));
  }

  /**
   * Test {@link MarketUtils#findGCD(long, long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#findGCD(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long MarketUtils.findGCD(long, long)"})
  public void testFindGCD_whenOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1L, MarketUtils.findGCD(1L, 5L));
  }

  /**
   * Test {@link MarketUtils#findGCD(long, long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#findGCD(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long MarketUtils.findGCD(long, long)"})
  public void testFindGCD_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, MarketUtils.findGCD(0L, 0L));
  }

  /**
   * Test {@link MarketUtils#findGCD(long, long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#findGCD(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long MarketUtils.findGCD(long, long)"})
  public void testFindGCD_whenZero_thenReturnZero2() {
    // Arrange, Act and Assert
    assertEquals(0L, MarketUtils.findGCD(0L, 5L));
  }

  /**
   * Test {@link MarketUtils#findGCD(long, long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#findGCD(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long MarketUtils.findGCD(long, long)"})
  public void testFindGCD_whenZero_thenReturnZero3() {
    // Arrange, Act and Assert
    assertEquals(0L, MarketUtils.findGCD(5L, 0L));
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void testComparePrice_whenFive_thenReturnZero() {
    // Arrange and Act
    int actualComparePriceResult = MarketUtils.comparePrice(5L, 5L, 5L, 5L);

    // Assert
    assertEquals(0, actualComparePriceResult);
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)}.
   *
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void testComparePrice_whenMax_value_thenReturnMinusOne() {
    // Arrange and Act
    int actualComparePriceResult = MarketUtils.comparePrice(Long.MAX_VALUE, 5L, 5L, 5L);

    // Assert
    assertEquals(-1, actualComparePriceResult);
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)}.
   *
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void testComparePrice_whenMax_value_thenReturnOne() {
    // Arrange and Act
    int actualComparePriceResult = MarketUtils.comparePrice(5L, Long.MAX_VALUE, 5L, 5L);

    // Assert
    assertEquals(1, actualComparePriceResult);
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void testComparePrice_whenMinusOne_thenReturnOne() {
    // Arrange and Act
    int actualComparePriceResult = MarketUtils.comparePrice(-1L, 5L, 5L, 5L);

    // Assert
    assertEquals(1, actualComparePriceResult);
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void testComparePrice_whenOne_thenReturnOne() {
    // Arrange and Act
    int actualComparePriceResult = MarketUtils.comparePrice(1L, 5L, 5L, 5L);

    // Assert
    assertEquals(1, actualComparePriceResult);
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void testComparePrice_whenZero_thenReturnOne() {
    // Arrange and Act
    int actualComparePriceResult = MarketUtils.comparePrice(0L, 5L, 5L, 5L);

    // Assert
    assertEquals(1, actualComparePriceResult);
  }
}
