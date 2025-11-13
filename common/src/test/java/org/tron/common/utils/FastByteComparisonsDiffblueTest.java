package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FastByteComparisonsDiffblueTest {
  /**
   * Test {@link FastByteComparisons#isEqual(byte[], byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FastByteComparisons#isEqual(byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FastByteComparisons.isEqual(byte[], byte[])"})
  public void testIsEqual_whenAxaxaxaxBytesIsUtf8_thenReturnTrue()
      throws UnsupportedEncodingException {
    // Arrange and Act
    boolean actualIsEqualResult =
        FastByteComparisons.isEqual("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualIsEqualResult);
  }

  /**
   * Test {@link FastByteComparisons#isEqual(byte[], byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FastByteComparisons#isEqual(byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FastByteComparisons.isEqual(byte[], byte[])"})
  public void testIsEqual_whenEmptyArrayOfByte_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange and Act
    boolean actualIsEqualResult =
        FastByteComparisons.isEqual(new byte[] {}, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertFalse(actualIsEqualResult);
  }

  /**
   * Test {@link FastByteComparisons#isEqual(byte[], byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FastByteComparisons#isEqual(byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FastByteComparisons.isEqual(byte[], byte[])"})
  public void testIsEqual_whenXaxaxaxBytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange and Act
    boolean actualIsEqualResult =
        FastByteComparisons.isEqual("\bXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertFalse(actualIsEqualResult);
  }

  /**
   * Test {@link FastByteComparisons#compareTo(byte[], int, int, byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link FastByteComparisons#compareTo(byte[], int, int, byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int FastByteComparisons.compareTo(byte[], int, int, byte[], int, int)"})
  public void testCompareTo_whenAxaxaxaxBytesIsUtf8_thenReturnZero()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        0,
        FastByteComparisons.compareTo(
            "AXAXAXAX".getBytes("UTF-8"), 1, 1, "AXAXAXAX".getBytes("UTF-8"), 1, 1));
  }
}
