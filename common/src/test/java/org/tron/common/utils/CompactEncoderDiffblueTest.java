package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CompactEncoderDiffblueTest {
  /**
   * Test {@link CompactEncoder#packNibbles(byte[])}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return array of {@code byte} with {@code q} and minus sixty-three.
   * </ul>
   *
   * <p>Method under test: {@link CompactEncoder#packNibbles(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] CompactEncoder.packNibbles(byte[])"})
  public void testPackNibbles_whenA_thenReturnArrayOfByteWithQAndMinusSixtyThree() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {'q', -63, -63, -63},
        CompactEncoder.packNibbles(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 16}));
  }

  /**
   * Test {@link CompactEncoder#packNibbles(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return array of {@code byte} with zero and {@code h}.
   * </ul>
   *
   * <p>Method under test: {@link CompactEncoder#packNibbles(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] CompactEncoder.packNibbles(byte[])"})
  public void testPackNibbles_whenAxaxaxaxBytesIsUtf8_thenReturnArrayOfByteWithZeroAndH()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {0, 'h', 'h', 'h', 'h'},
        CompactEncoder.packNibbles("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CompactEncoder#hasTerminator(byte[])}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CompactEncoder#hasTerminator(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CompactEncoder.hasTerminator(byte[])"})
  public void testHasTerminator_whenA_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CompactEncoder.hasTerminator(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link CompactEncoder#hasTerminator(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CompactEncoder#hasTerminator(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CompactEncoder.hasTerminator(byte[])"})
  public void testHasTerminator_whenAxaxaxaxBytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(CompactEncoder.hasTerminator("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CompactEncoder#unpackToNibbles(byte[])}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with zero and five.
   * </ul>
   *
   * <p>Method under test: {@link CompactEncoder#unpackToNibbles(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] CompactEncoder.unpackToNibbles(byte[])"})
  public void testUnpackToNibbles_thenReturnArrayOfByteWithZeroAndFive() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {0, 5, '\b', 4, 1, 5, '\b', 4, 1, 5, '\b', 4, 1, 5, '\b'},
        CompactEncoder.unpackToNibbles(new byte[] {16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link CompactEncoder#unpackToNibbles(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link CompactEncoder#unpackToNibbles(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] CompactEncoder.unpackToNibbles(byte[])"})
  public void testUnpackToNibbles_whenArrayOfByteWithOneAndX() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {5, '\b', 4, 1, 5, '\b', 4, 1, 5, '\b', 4, 1, 5, '\b'},
        CompactEncoder.unpackToNibbles(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link CompactEncoder#unpackToNibbles(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link CompactEncoder#unpackToNibbles(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] CompactEncoder.unpackToNibbles(byte[])"})
  public void testUnpackToNibbles_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {5, '\b', 4, 1, 5, '\b', 4, 1, 5, '\b', 4, 1, 5, '\b', 16},
        CompactEncoder.unpackToNibbles("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CompactEncoder#binToNibbles(byte[])}.
   *
   * <p>Method under test: {@link CompactEncoder#binToNibbles(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] CompactEncoder.binToNibbles(byte[])"})
  public void testBinToNibbles() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {4, 1, 5, '\b', 4, 1, 5, '\b', 4, 1, 5, '\b', 4, 1, 5, '\b', 16},
        CompactEncoder.binToNibbles("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CompactEncoder#binToNibblesNoTerminator(byte[])}.
   *
   * <p>Method under test: {@link CompactEncoder#binToNibblesNoTerminator(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] CompactEncoder.binToNibblesNoTerminator(byte[])"})
  public void testBinToNibblesNoTerminator() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {4, 1, 5, '\b', 4, 1, 5, '\b', 4, 1, 5, '\b', 4, 1, 5, '\b'},
        CompactEncoder.binToNibblesNoTerminator("AXAXAXAX".getBytes("UTF-8")));
  }
}
