package org.tron.plugins.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class MarketUtilsDiffblueTest {
  /**
   * Method under test:
   * {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}
   */
  @Test
  public void testCreatePairPriceKey() throws UnsupportedEncodingException {
    // Arrange
    byte[] sellTokenId = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A',
            'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
        MarketUtils.createPairPriceKey(sellTokenId, "AXAXAXAX".getBytes("UTF-8"), 1L, 1L));
  }

  /**
   * Method under test:
   * {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}
   */
  @Test
  public void testCreatePairPriceKey2() throws UnsupportedEncodingException {
    // Arrange
    byte[] sellTokenId = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A',
            'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        MarketUtils.createPairPriceKey(sellTokenId, "AXAXAXAX".getBytes("UTF-8"), 0L, 1L));
  }

  /**
   * Method under test:
   * {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}
   */
  @Test
  public void testCreatePairPriceKey3() throws UnsupportedEncodingException {
    // Arrange
    byte[] sellTokenId = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A',
            'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        MarketUtils.createPairPriceKey(sellTokenId, "AXAXAXAX".getBytes("UTF-8"), 1L, 0L));
  }

  /**
   * Method under test: {@link MarketUtils#findGCD(long, long)}
   */
  @Test
  public void testFindGCD() {
    // Arrange, Act and Assert
    assertEquals(5L, MarketUtils.findGCD(5L, 5L));
    assertEquals(1L, MarketUtils.findGCD(1L, 5L));
    assertEquals(0L, MarketUtils.findGCD(0L, 5L));
    assertEquals(-1L, MarketUtils.findGCD(-1L, 5L));
    assertEquals(0L, MarketUtils.findGCD(5L, 0L));
  }

  /**
   * Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  public void testComparePrice() {
    // Arrange, Act and Assert
    assertEquals(0, MarketUtils.comparePrice(5L, 5L, 5L, 5L));
    assertEquals(1, MarketUtils.comparePrice(1L, 5L, 5L, 5L));
    assertEquals(1, MarketUtils.comparePrice(0L, 5L, 5L, 5L));
    assertEquals(1, MarketUtils.comparePrice(-1L, 5L, 5L, 5L));
    assertEquals(-1, MarketUtils.comparePrice(Long.MAX_VALUE, 5L, 5L, 5L));
    assertEquals(1, MarketUtils.comparePrice(5L, Long.MAX_VALUE, 5L, 5L));
  }
}
