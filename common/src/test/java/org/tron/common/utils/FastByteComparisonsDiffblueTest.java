package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class FastByteComparisonsDiffblueTest {
  /**
   * Method under test: {@link FastByteComparisons#isEqual(byte[], byte[])}
   */
  @Test
  public void testIsEqual() throws UnsupportedEncodingException {
    // Arrange
    byte[] b1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(FastByteComparisons.isEqual(b1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link FastByteComparisons#isEqual(byte[], byte[])}
   */
  @Test
  public void testIsEqual2() throws UnsupportedEncodingException {
    // Arrange
    byte[] b1 = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(FastByteComparisons.isEqual(b1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link FastByteComparisons#isEqual(byte[], byte[])}
   */
  @Test
  public void testIsEqual3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(FastByteComparisons.isEqual(new byte[]{}, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link FastByteComparisons#compareTo(byte[], int, int, byte[], int, int)}
   */
  @Test
  public void testCompareTo() throws UnsupportedEncodingException {
    // Arrange
    byte[] b1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, FastByteComparisons.compareTo(b1, 1, 1, "AXAXAXAX".getBytes("UTF-8"), 1, 1));
  }
}
