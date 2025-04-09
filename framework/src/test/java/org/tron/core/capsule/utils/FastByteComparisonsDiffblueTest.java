package org.tron.core.capsule.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FastByteComparisonsDiffblueTest {
  /**
   * Test {@link FastByteComparisons#equalByte(byte[], byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FastByteComparisons#equalByte(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FastByteComparisons.equalByte(byte[], byte[])"})
  public void testEqualByte_whenAxaxaxaxBytesIsUtf8_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    byte[] b1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(FastByteComparisons.equalByte(b1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link FastByteComparisons#equalByte(byte[], byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FastByteComparisons#equalByte(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FastByteComparisons.equalByte(byte[], byte[])"})
  public void testEqualByte_whenEmptyArrayOfByte_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(FastByteComparisons.equalByte(new byte[]{}, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link FastByteComparisons#equalByte(byte[], byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FastByteComparisons#equalByte(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FastByteComparisons.equalByte(byte[], byte[])"})
  public void testEqualByte_whenXaxaxaxBytesIsUtf8_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    byte[] b1 = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(FastByteComparisons.equalByte(b1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link FastByteComparisons#compareTo(byte[], int, int, byte[], int, int)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FastByteComparisons#compareTo(byte[], int, int, byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int FastByteComparisons.compareTo(byte[], int, int, byte[], int, int)"})
  public void testCompareTo_whenA_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(0, FastByteComparisons.compareTo(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 1,
        "AXAXAXAX".getBytes("UTF-8"), 1, 1));
  }

  /**
   * Test {@link FastByteComparisons#compareTo(byte[], int, int, byte[], int, int)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FastByteComparisons#compareTo(byte[], int, int, byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int FastByteComparisons.compareTo(byte[], int, int, byte[], int, int)"})
  public void testCompareTo_whenAxaxaxaxBytesIsUtf8_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] b1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, FastByteComparisons.compareTo(b1, 1, 1, "AXAXAXAX".getBytes("UTF-8"), 1, 1));
  }
}
