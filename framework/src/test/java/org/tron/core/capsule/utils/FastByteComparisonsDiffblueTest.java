package org.tron.core.capsule.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class FastByteComparisonsDiffblueTest {
  /**
   * Method under test: {@link FastByteComparisons#equalByte(byte[], byte[])}
   */
  @Test
  public void testEqualByte() throws UnsupportedEncodingException {
    // Arrange
    byte[] b1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(FastByteComparisons.equalByte(b1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link FastByteComparisons#equalByte(byte[], byte[])}
   */
  @Test
  public void testEqualByte2() throws UnsupportedEncodingException {
    // Arrange
    byte[] b1 = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(FastByteComparisons.equalByte(b1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link FastByteComparisons#equalByte(byte[], byte[])}
   */
  @Test
  public void testEqualByte3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(FastByteComparisons.equalByte(new byte[]{}, "AXAXAXAX".getBytes("UTF-8")));
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

  /**
   * Method under test:
   * {@link FastByteComparisons#compareTo(byte[], int, int, byte[], int, int)}
   */
  @Test
  public void testCompareTo2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(0, FastByteComparisons.compareTo(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 1,
        "AXAXAXAX".getBytes("UTF-8"), 1, 1));
  }
}
