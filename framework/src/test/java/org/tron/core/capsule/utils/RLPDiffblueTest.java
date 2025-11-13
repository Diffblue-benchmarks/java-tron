package org.tron.core.capsule.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.utils.Value;
import org.tron.core.capsule.utils.RLP.LList;
import org.tron.core.db.ByteArrayWrapper;

public class RLPDiffblueTest {
  /**
   * Test {@link RLP#decodeInt(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and {@link Byte#MIN_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeInt(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.decodeInt(byte[], int)"})
  public void testDecodeInt_whenArrayOfByteWithAAndMin_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0, RLP.decodeInt(new byte[] {'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#decodeInt(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeInt(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.decodeInt(byte[], int)"})
  public void testDecodeInt_whenArrayOfByteWithAAndMinusOne_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> RLP.decodeInt(new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#decodeInt(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and zero.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeInt(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.decodeInt(byte[], int)"})
  public void testDecodeInt_whenArrayOfByteWithAAndZero_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> RLP.decodeInt(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#decodeInt(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return eighty-eight.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeInt(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.decodeInt(byte[], int)"})
  public void testDecodeInt_whenAxaxaxaxBytesIsUtf8_thenReturnEightyEight()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(88, RLP.decodeInt("AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Test {@link RLP#decodeShort(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and {@link Byte#MIN_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeShort(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"short RLP.decodeShort(byte[], int)"})
  public void testDecodeShort_whenArrayOfByteWithAAndMin_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        (short) 0,
        RLP.decodeShort(new byte[] {'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#decodeShort(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeShort(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"short RLP.decodeShort(byte[], int)"})
  public void testDecodeShort_whenArrayOfByteWithAAndMinusOne_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> RLP.decodeShort(new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#decodeShort(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and zero.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeShort(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"short RLP.decodeShort(byte[], int)"})
  public void testDecodeShort_whenArrayOfByteWithAAndZero_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> RLP.decodeShort(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#decodeShort(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return eighty-eight.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeShort(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"short RLP.decodeShort(byte[], int)"})
  public void testDecodeShort_whenAxaxaxaxBytesIsUtf8_thenReturnEightyEight()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals((short) 88, RLP.decodeShort("AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Test {@link RLP#decodeLong(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and {@link Byte#MIN_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeLong(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long RLP.decodeLong(byte[], int)"})
  public void testDecodeLong_whenArrayOfByteWithAAndMin_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0L, RLP.decodeLong(new byte[] {'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#decodeLong(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeLong(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long RLP.decodeLong(byte[], int)"})
  public void testDecodeLong_whenArrayOfByteWithAAndMinusOne_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> RLP.decodeLong(new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#decodeLong(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and zero.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeLong(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long RLP.decodeLong(byte[], int)"})
  public void testDecodeLong_whenArrayOfByteWithAAndZero_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> RLP.decodeLong(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#decodeLong(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return eighty-eight.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeLong(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long RLP.decodeLong(byte[], int)"})
  public void testDecodeLong_whenAxaxaxaxBytesIsUtf8_thenReturnEightyEight()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(88L, RLP.decodeLong("AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Test {@link RLP#decodeStringItem(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and {@link Byte#MIN_VALUE}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeStringItem(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String RLP.decodeStringItem(byte[], int)"})
  public void testDecodeStringItem_whenArrayOfByteWithAAndMin_value_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        RLP.decodeStringItem(new byte[] {'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#decodeStringItem(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeStringItem(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String RLP.decodeStringItem(byte[], int)"})
  public void testDecodeStringItem_whenArrayOfByteWithAAndMinusOne_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            RLP.decodeStringItem(
                new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1},
                1));
  }

  /**
   * Test {@link RLP#decodeStringItem(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeStringItem(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String RLP.decodeStringItem(byte[], int)"})
  public void testDecodeStringItem_whenAxaxaxaxBytesIsUtf8_thenReturnX()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("X", RLP.decodeStringItem("AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Test {@link RLP#decodeBigInteger(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and {@link Byte#MIN_VALUE}.
   *   <li>Then return toString is {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeBigInteger(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigInteger RLP.decodeBigInteger(byte[], int)"})
  public void testDecodeBigInteger_whenArrayOfByteWithAAndMin_value_thenReturnToStringIs0() {
    // Arrange and Act
    BigInteger actualDecodeBigIntegerResult =
        RLP.decodeBigInteger(new byte[] {'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, 1);

    // Assert
    assertEquals("0", actualDecodeBigIntegerResult.toString());
    assertEquals(-1, actualDecodeBigIntegerResult.getLowestSetBit());
    assertEquals(0, actualDecodeBigIntegerResult.signum());
    assertArrayEquals(new byte[] {0}, actualDecodeBigIntegerResult.toByteArray());
  }

  /**
   * Test {@link RLP#decodeBigInteger(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeBigInteger(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigInteger RLP.decodeBigInteger(byte[], int)"})
  public void testDecodeBigInteger_whenArrayOfByteWithAAndMinusOne_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            RLP.decodeBigInteger(
                new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1},
                1));
  }

  /**
   * Test {@link RLP#decodeBigInteger(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return toString is {@code 88}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeBigInteger(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigInteger RLP.decodeBigInteger(byte[], int)"})
  public void testDecodeBigInteger_whenAxaxaxaxBytesIsUtf8_thenReturnToStringIs88()
      throws UnsupportedEncodingException {
    // Arrange and Act
    BigInteger actualDecodeBigIntegerResult = RLP.decodeBigInteger("AXAXAXAX".getBytes("UTF-8"), 1);

    // Assert
    assertEquals("88", actualDecodeBigIntegerResult.toString());
    assertEquals(1, actualDecodeBigIntegerResult.signum());
    assertEquals(3, actualDecodeBigIntegerResult.getLowestSetBit());
    assertArrayEquals(new byte[] {'X'}, actualDecodeBigIntegerResult.toByteArray());
  }

  /**
   * Test {@link RLP#decodeByteArray(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and {@link Byte#MIN_VALUE}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeByteArray(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.decodeByteArray(byte[], int)"})
  public void testDecodeByteArray_whenArrayOfByteWithAAndMin_value_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {},
        RLP.decodeByteArray(new byte[] {'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#decodeByteArray(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeByteArray(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.decodeByteArray(byte[], int)"})
  public void testDecodeByteArray_whenArrayOfByteWithAAndMinusOne_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            RLP.decodeByteArray(
                new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1},
                1));
  }

  /**
   * Test {@link RLP#decodeByteArray(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return array of {@code byte} with {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeByteArray(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.decodeByteArray(byte[], int)"})
  public void testDecodeByteArray_whenAxaxaxaxBytesIsUtf8_thenReturnArrayOfByteWithX()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {'X'}, RLP.decodeByteArray("AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Test LList {@link LList#add(int, int, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LList#add(int, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LList.add(int, int, boolean)"})
  public void testLListAdd_whenFalse() throws UnsupportedEncodingException {
    // Arrange
    LList lList = new LList("AXAXAXAX".getBytes("UTF-8"));

    // Act
    lList.add(2, 3, false);

    // Assert
    assertEquals(1, lList.size());
    assertArrayEquals(new byte[] {-60, -125, 'A', 'X', 'A'}, lList.getEncoded());
  }

  /**
   * Test LList {@link LList#add(int, int, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LList#add(int, int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LList.add(int, int, boolean)"})
  public void testLListAdd_whenTrue() throws UnsupportedEncodingException {
    // Arrange
    LList lList = new LList("AXAXAXAX".getBytes("UTF-8"));

    // Act
    lList.add(2, 3, true);

    // Assert
    assertEquals(1, lList.size());
    assertArrayEquals(new byte[] {-60, -125, 'A', 'X', 'A'}, lList.getEncoded());
  }

  /**
   * Test LList {@link LList#getBytes(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link LList#getBytes(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] LList.getBytes(int)"})
  public void testLListGetBytes_whenOne_thenReturnEmptyArrayOfByte()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new LList("AXAXAXAX".getBytes("UTF-8")).getBytes(1));
  }

  /**
   * Test LList {@link LList#getEncoded()}.
   *
   * <p>Method under test: {@link LList#getEncoded()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] LList.getEncoded()"})
  public void testLListGetEncoded() throws UnsupportedEncodingException {
    // Arrange
    LList lList = new LList("AXAXAXAX".getBytes("UTF-8"));
    lList.add(2, 3, true);

    // Act and Assert
    assertArrayEquals(new byte[] {-60, -125, 'A', 'X', 'A'}, lList.getEncoded());
  }

  /**
   * Test LList {@link LList#getEncoded()}.
   *
   * <p>Method under test: {@link LList#getEncoded()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] LList.getEncoded()"})
  public void testLListGetEncoded2() throws UnsupportedEncodingException {
    // Arrange
    LList lList = new LList("AXAXAXAX".getBytes("UTF-8"));
    lList.add(1, 2, false);
    lList.add(2, 3, true);

    // Act and Assert
    assertArrayEquals(new byte[] {-57, -126, 'X', 'A', -125, 'A', 'X', 'A'}, lList.getEncoded());
  }

  /**
   * Test LList {@link LList#getEncoded()}.
   *
   * <p>Method under test: {@link LList#getEncoded()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] LList.getEncoded()"})
  public void testLListGetEncoded3() {
    // Arrange
    LList lList = new LList(new byte[] {'A', 'X', -2, 'X', 'A', 'X', 'A', 'X'});
    lList.add(2, 1, true);

    // Act and Assert
    assertArrayEquals(new byte[] {-62, -127, -2}, lList.getEncoded());
  }

  /**
   * Test LList {@link LList#getEncoded()}.
   *
   * <ul>
   *   <li>Given {@code X}.
   *   <li>Then return array of {@code byte} with minus sixty-three and zero.
   * </ul>
   *
   * <p>Method under test: {@link LList#getEncoded()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] LList.getEncoded()"})
  public void testLListGetEncoded_givenX_thenReturnArrayOfByteWithMinusSixtyThreeAndZero() {
    // Arrange
    LList lList = new LList(new byte[] {'A', 'X', 0, 'X', 'A', 'X', 'A', 'X'});
    lList.add(2, 1, true);

    // Act and Assert
    assertArrayEquals(new byte[] {-63, 0}, lList.getEncoded());
  }

  /**
   * Test LList {@link LList#getEncoded()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus sixty-four.
   * </ul>
   *
   * <p>Method under test: {@link LList#getEncoded()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] LList.getEncoded()"})
  public void testLListGetEncoded_thenReturnArrayOfByteWithMinusSixtyFour()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {-64}, new LList("AXAXAXAX".getBytes("UTF-8")).getEncoded());
  }

  /**
   * Test LList {@link LList#getEncoded()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus sixty-three and {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link LList#getEncoded()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] LList.getEncoded()"})
  public void testLListGetEncoded_thenReturnArrayOfByteWithMinusSixtyThreeAndA()
      throws UnsupportedEncodingException {
    // Arrange
    LList lList = new LList("AXAXAXAX".getBytes("UTF-8"));
    lList.add(2, 1, true);

    // Act and Assert
    assertArrayEquals(new byte[] {-63, 'A'}, lList.getEncoded());
  }

  /**
   * Test LList {@link LList#getEncoded()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus sixty-three and {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LList#getEncoded()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] LList.getEncoded()"})
  public void testLListGetEncoded_thenReturnArrayOfByteWithMinusSixtyThreeAndMin_value()
      throws UnsupportedEncodingException {
    // Arrange
    LList lList = new LList("AXAXAXAX".getBytes("UTF-8"));
    lList.add(2, 0, true);

    // Act and Assert
    assertArrayEquals(new byte[] {-63, Byte.MIN_VALUE}, lList.getEncoded());
  }

  /**
   * Test LList {@link LList#getList(int)}.
   *
   * <ul>
   *   <li>Given {@link LList#LList(byte[])} with rlp is {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link LList#getList(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LList LList.getList(int)"})
  public void testLListGetList_givenLListWithRlpIsAxaxaxaxBytesIsUtf8_thenReturnSizeIsZero()
      throws UnsupportedEncodingException {
    // Arrange and Act
    LList actualList = new LList("AXAXAXAX".getBytes("UTF-8")).getList(1);

    // Assert
    assertEquals(0, actualList.size());
    assertArrayEquals(new byte[] {-64}, actualList.getEncoded());
  }

  /**
   * Test LList {@link LList#getList(int)}.
   *
   * <ul>
   *   <li>Given {@link LList#LList(byte[])} with rlp is empty array of {@code byte}.
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LList#getList(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LList LList.getList(int)"})
  public void testLListGetList_givenLListWithRlpIsEmptyArrayOfByte_whenOne_thenReturnNull() {
    // Arrange
    LList lList = new LList(new byte[] {});

    // Act and Assert
    assertNull(lList.getList(1));
  }

  /**
   * Test LList {@link LList#getList(int)}.
   *
   * <ul>
   *   <li>Given {@code X}.
   *   <li>When one.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link LList#getList(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LList LList.getList(int)"})
  public void testLListGetList_givenX_whenOne_thenReturnSizeIsOne() {
    // Arrange
    LList lList = new LList(new byte[] {'A', 'X', -73, 'X', 'A', 'X', 'A', -1});
    lList.add(2, 3, true);
    lList.add(2, 3, true);

    // Act and Assert
    assertEquals(1, lList.getList(1).size());
  }

  /**
   * Test LList {@link LList#getList(int)}.
   *
   * <ul>
   *   <li>Then return Encoded is array of {@code byte} with minus sixty-one and {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link LList#getList(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LList LList.getList(int)"})
  public void testLListGetList_thenReturnEncodedIsArrayOfByteWithMinusSixtyOneAndA()
      throws UnsupportedEncodingException {
    // Arrange
    LList lList = new LList("AXAXAXAX".getBytes("UTF-8"));
    lList.add(2, 3, true);
    lList.add(2, 3, true);

    // Act
    LList actualList = lList.getList(1);

    // Assert
    assertEquals(3, actualList.size());
    assertArrayEquals(new byte[] {-61, 'A', 'X', 'A'}, actualList.getEncoded());
  }

  /**
   * Test LList {@link LList#getList(int)}.
   *
   * <ul>
   *   <li>Then return Encoded is array of {@code byte} with minus sixty-one and {@link
   *       Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LList#getList(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LList LList.getList(int)"})
  public void testLListGetList_thenReturnEncodedIsArrayOfByteWithMinusSixtyOneAndMin_value() {
    // Arrange
    LList lList = new LList(new byte[] {'A', 'X', Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X'});
    lList.add(2, 3, true);
    lList.add(2, 3, true);

    // Act
    LList actualList = lList.getList(1);

    // Assert
    assertEquals(3, actualList.size());
    assertArrayEquals(new byte[] {-61, Byte.MIN_VALUE, 'X', 'A'}, actualList.getEncoded());
  }

  /**
   * Test LList {@link LList#isList(int)}.
   *
   * <ul>
   *   <li>Given {@link LList#add(int, int, boolean)} with off is two and len is three and isList is
   *       {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LList#isList(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LList.isList(int)"})
  public void testLListIsList_givenAddWithOffIsTwoAndLenIsThreeAndIsListIsTrue_thenReturnTrue()
      throws UnsupportedEncodingException {
    // Arrange
    LList lList = new LList("AXAXAXAX".getBytes("UTF-8"));
    lList.add(2, 3, true);

    // Act and Assert
    assertTrue(lList.isList(0));
  }

  /**
   * Test LList {@link LList#isList(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LList#isList(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LList.isList(int)"})
  public void testLListIsList_whenOne_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(new LList("AXAXAXAX".getBytes("UTF-8")).isList(1));
  }

  /**
   * Test LList {@link LList#LList(byte[])}.
   *
   * <p>Method under test: {@link LList#LList(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LList.<init>(byte[])"})
  public void testLListNewLList() throws UnsupportedEncodingException {
    // Arrange and Act
    LList actualLList = new LList("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(0, actualLList.size());
    assertArrayEquals(new byte[] {-64}, actualLList.getEncoded());
  }

  /**
   * Test LList {@link LList#size()}.
   *
   * <p>Method under test: {@link LList#size()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int LList.size()"})
  public void testLListSize() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(0, new LList("AXAXAXAX".getBytes("UTF-8")).size());
  }

  /**
   * Test {@link RLP#nextItemLength(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus nine.
   *   <li>Then return fifty-five.
   * </ul>
   *
   * <p>Method under test: {@link RLP#nextItemLength(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.nextItemLength(byte[], int)"})
  public void testNextItemLength_whenArrayOfByteWithAAndMinusNine_thenReturnFiftyFive() {
    // Arrange, Act and Assert
    assertEquals(55, RLP.nextItemLength(new byte[] {'A', -9, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#nextItemLength(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   *   <li>Then return {@link Integer#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#nextItemLength(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.nextItemLength(byte[], int)"})
  public void testNextItemLength_whenArrayOfByteWithAAndMinusOne_thenReturnMax_value() {
    // Arrange, Act and Assert
    assertEquals(
        Integer.MAX_VALUE,
        RLP.nextItemLength(new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#nextItemLength(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#nextItemLength(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.nextItemLength(byte[], int)"})
  public void testNextItemLength_whenArrayOfByteWithAAndMinusOne_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> RLP.nextItemLength(new byte[] {'A', -1, 0, 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#nextItemLength(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus seventy-three.
   *   <li>Then return fifty-five.
   * </ul>
   *
   * <p>Method under test: {@link RLP#nextItemLength(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.nextItemLength(byte[], int)"})
  public void testNextItemLength_whenArrayOfByteWithAAndMinusSeventyThree_thenReturnFiftyFive() {
    // Arrange, Act and Assert
    assertEquals(55, RLP.nextItemLength(new byte[] {'A', -73, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#nextItemLength(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RLP#nextItemLength(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.nextItemLength(byte[], int)"})
  public void testNextItemLength_whenAxaxaxaxBytesIsUtf8_thenReturnOne()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1, RLP.nextItemLength("AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Test {@link RLP#nextItemLength(byte[], int)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link RLP#nextItemLength(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.nextItemLength(byte[], int)"})
  public void testNextItemLength_whenEmptyArrayOfByte_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, RLP.nextItemLength(new byte[] {}, 1));
  }

  /**
   * Test {@link RLP#decodeIP4Bytes(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code AXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeIP4Bytes(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.decodeIP4Bytes(byte[], int)"})
  public void testDecodeIP4Bytes_whenAxaxaxaxBytesIsUtf8_thenReturnAxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXAX".getBytes("UTF-8"), RLP.decodeIP4Bytes("AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Test {@link RLP#decodeIP4Bytes(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then return array of {@code byte} with zero and {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeIP4Bytes(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.decodeIP4Bytes(byte[], int)"})
  public void testDecodeIP4Bytes_whenX_thenReturnArrayOfByteWithZeroAndA() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {0, 'A', 'X', 'A'},
        RLP.decodeIP4Bytes(new byte[] {'A', 'X', -1, 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#decodeIP4Bytes(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then return array of {@code byte} with zero and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeIP4Bytes(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.decodeIP4Bytes(byte[], int)"})
  public void testDecodeIP4Bytes_whenX_thenReturnArrayOfByteWithZeroAndX() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {0, 'X', 'A', 'X'},
        RLP.decodeIP4Bytes(new byte[] {'A', 'X', Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#decodeIP4Bytes(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then return array of {@code byte} with zero and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeIP4Bytes(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.decodeIP4Bytes(byte[], int)"})
  public void testDecodeIP4Bytes_whenX_thenReturnArrayOfByteWithZeroAndX2() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {0, 'X', 'A', 'X'},
        RLP.decodeIP4Bytes(new byte[] {'A', 'X', -1, 'X', -127, 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#getFirstListElement(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus nine.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link RLP#getFirstListElement(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.getFirstListElement(byte[], int)"})
  public void testGetFirstListElement_whenArrayOfByteWithAAndMinusNine_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, RLP.getFirstListElement(new byte[] {'A', -9, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#getFirstListElement(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link RLP#getFirstListElement(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.getFirstListElement(byte[], int)"})
  public void testGetFirstListElement_whenArrayOfByteWithAAndMinusOne_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(
        10, RLP.getFirstListElement(new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#getFirstListElement(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link RLP#getFirstListElement(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.getFirstListElement(byte[], int)"})
  public void testGetFirstListElement_whenAxaxaxaxBytesIsUtf8_thenReturnMinusOne()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(-1, RLP.getFirstListElement("AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Test {@link RLP#getFirstListElement(byte[], int)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link RLP#getFirstListElement(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.getFirstListElement(byte[], int)"})
  public void testGetFirstListElement_whenEmptyArrayOfByte_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, RLP.getFirstListElement(new byte[] {}, 1));
  }

  /**
   * Test {@link RLP#getNextElementIndex(byte[], int)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#getNextElementIndex(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.getNextElementIndex(byte[], int)"})
  public void testGetNextElementIndex_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> RLP.getNextElementIndex(new byte[] {'A', -1, 0, 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#getNextElementIndex(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and {@link Byte#MIN_VALUE}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link RLP#getNextElementIndex(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.getNextElementIndex(byte[], int)"})
  public void testGetNextElementIndex_whenArrayOfByteWithAAndMin_value_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(
        2,
        RLP.getNextElementIndex(new byte[] {'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#getNextElementIndex(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus nine.
   *   <li>Then return fifty-seven.
   * </ul>
   *
   * <p>Method under test: {@link RLP#getNextElementIndex(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.getNextElementIndex(byte[], int)"})
  public void testGetNextElementIndex_whenArrayOfByteWithAAndMinusNine_thenReturnFiftySeven() {
    // Arrange, Act and Assert
    assertEquals(
        57, RLP.getNextElementIndex(new byte[] {'A', -9, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#getNextElementIndex(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   *   <li>Then return {@code -2147483639}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#getNextElementIndex(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.getNextElementIndex(byte[], int)"})
  public void testGetNextElementIndex_whenArrayOfByteWithAAndMinusOne_thenReturn2147483639() {
    // Arrange, Act and Assert
    assertEquals(
        -2147483639,
        RLP.getNextElementIndex(new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#getNextElementIndex(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus seventy-three.
   * </ul>
   *
   * <p>Method under test: {@link RLP#getNextElementIndex(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.getNextElementIndex(byte[], int)"})
  public void testGetNextElementIndex_whenArrayOfByteWithAAndMinusSeventyThree() {
    // Arrange, Act and Assert
    assertEquals(
        57, RLP.getNextElementIndex(new byte[] {'A', -73, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#getNextElementIndex(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link RLP#getNextElementIndex(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.getNextElementIndex(byte[], int)"})
  public void testGetNextElementIndex_whenAxaxaxaxBytesIsUtf8_thenReturnTwo()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(2, RLP.getNextElementIndex("AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Test {@link RLP#getNextElementIndex(byte[], int)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link RLP#getNextElementIndex(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.getNextElementIndex(byte[], int)"})
  public void testGetNextElementIndex_whenEmptyArrayOfByte_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, RLP.getNextElementIndex(new byte[] {}, 1));
  }

  /**
   * Test {@link RLP#getCommandCode(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus nine and {@link Byte#MIN_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RLP#getCommandCode(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte RLP.getCommandCode(byte[])"})
  public void testGetCommandCode_whenArrayOfByteWithMinusNineAndMin_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        (byte) 0,
        RLP.getCommandCode(new byte[] {-9, Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link RLP#getCommandCode(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus nine and {@code X}.
   *   <li>Then return {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#getCommandCode(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte RLP.getCommandCode(byte[])"})
  public void testGetCommandCode_whenArrayOfByteWithMinusNineAndX_thenReturnX() {
    // Arrange, Act and Assert
    assertEquals('X', RLP.getCommandCode(new byte[] {-9, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link RLP#decode2(byte[], int)} with {@code msgData}, {@code depthLimit}.
   *
   * <ul>
   *   <li>Then first return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decode2(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RLPList RLP.decode2(byte[], int)"})
  public void testDecode2WithMsgDataDepthLimit_thenFirstReturnList() {
    // Arrange and Act
    RLPList actualDecode2Result =
        RLP.decode2(new byte[] {-64, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(8, actualDecode2Result.size());
    RLPElement getResult = actualDecode2Result.get(0);
    assertTrue(getResult instanceof List);
    assertTrue(actualDecode2Result.get(1) instanceof RLPItem);
    assertTrue(actualDecode2Result.get(2) instanceof RLPItem);
    assertTrue(actualDecode2Result.get(3) instanceof RLPItem);
    assertTrue(actualDecode2Result.get(4) instanceof RLPItem);
    assertTrue(actualDecode2Result.get(5) instanceof RLPItem);
    assertTrue(actualDecode2Result.get(6) instanceof RLPItem);
    assertTrue(actualDecode2Result.get(7) instanceof RLPItem);
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link RLP#decode2(byte[], int)} with {@code msgData}, {@code depthLimit}.
   *
   * <ul>
   *   <li>Then return first RLPData is array of {@code byte} with {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decode2(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RLPList RLP.decode2(byte[], int)"})
  public void testDecode2WithMsgDataDepthLimit_thenReturnFirstRLPDataIsArrayOfByteWithA()
      throws UnsupportedEncodingException {
    // Arrange and Act
    RLPList actualDecode2Result = RLP.decode2("AXAXAXAX".getBytes("UTF-8"), 2);

    // Assert
    assertEquals(8, actualDecode2Result.size());
    assertArrayEquals(new byte[] {'A'}, actualDecode2Result.get(0).getRLPData());
    assertArrayEquals(new byte[] {'A'}, actualDecode2Result.get(2).getRLPData());
    assertArrayEquals(new byte[] {'A'}, actualDecode2Result.get(4).getRLPData());
    assertArrayEquals(new byte[] {'A'}, actualDecode2Result.get(6).getRLPData());
    assertArrayEquals(new byte[] {'X'}, actualDecode2Result.get(1).getRLPData());
    assertArrayEquals(new byte[] {'X'}, actualDecode2Result.get(3).getRLPData());
    assertArrayEquals(new byte[] {'X'}, actualDecode2Result.get(5).getRLPData());
    assertArrayEquals(new byte[] {'X'}, actualDecode2Result.get(7).getRLPData());
  }

  /**
   * Test {@link RLP#decode2(byte[], int)} with {@code msgData}, {@code depthLimit}.
   *
   * <ul>
   *   <li>Then return first RLPData is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decode2(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RLPList RLP.decode2(byte[], int)"})
  public void testDecode2WithMsgDataDepthLimit_thenReturnFirstRLPDataIsNull() {
    // Arrange and Act
    RLPList actualDecode2Result =
        RLP.decode2(new byte[] {Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(8, actualDecode2Result.size());
    assertNull(actualDecode2Result.get(0).getRLPData());
    assertArrayEquals(new byte[] {'A'}, actualDecode2Result.get(2).getRLPData());
    assertArrayEquals(new byte[] {'A'}, actualDecode2Result.get(4).getRLPData());
    assertArrayEquals(new byte[] {'A'}, actualDecode2Result.get(6).getRLPData());
    assertArrayEquals(new byte[] {'X'}, actualDecode2Result.get(1).getRLPData());
    assertArrayEquals(new byte[] {'X'}, actualDecode2Result.get(3).getRLPData());
    assertArrayEquals(new byte[] {'X'}, actualDecode2Result.get(5).getRLPData());
    assertArrayEquals(new byte[] {'X'}, actualDecode2Result.get(7).getRLPData());
  }

  /**
   * Test {@link RLP#decode2(byte[], int)} with {@code msgData}, {@code depthLimit}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decode2(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RLPList RLP.decode2(byte[], int)"})
  public void testDecode2WithMsgDataDepthLimit_whenArrayOfByteWithMinusOneAndX() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> RLP.decode2(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2));
  }

  /**
   * Test {@link RLP#decode2(byte[], int)} with {@code msgData}, {@code depthLimit}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and zero.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decode2(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RLPList RLP.decode2(byte[], int)"})
  public void testDecode2WithMsgDataDepthLimit_whenArrayOfByteWithMinusOneAndZero() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> RLP.decode2(new byte[] {-1, 0, 'A', 'X', 'A', 'X', 'A', 'X'}, 2));
  }

  /**
   * Test {@link RLP#decode2(byte[], int)} with {@code msgData}, {@code depthLimit}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decode2(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RLPList RLP.decode2(byte[], int)"})
  public void testDecode2WithMsgDataDepthLimit_whenEmptyArrayOfByte_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(RLP.decode2(new byte[] {}, 2).isEmpty());
  }

  /**
   * Test {@link RLP#decode2(byte[], int)} with {@code msgData}, {@code depthLimit}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decode2(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RLPList RLP.decode2(byte[], int)"})
  public void testDecode2WithMsgDataDepthLimit_whenZero_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> RLP.decode2(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 0));
  }

  /**
   * Test {@link RLP#decode2(byte[])} with {@code msgData}.
   *
   * <ul>
   *   <li>Then return first RLPData is array of {@code byte} with {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decode2(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RLPList RLP.decode2(byte[])"})
  public void testDecode2WithMsgData_thenReturnFirstRLPDataIsArrayOfByteWithA()
      throws UnsupportedEncodingException {
    // Arrange and Act
    RLPList actualDecode2Result = RLP.decode2("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(8, actualDecode2Result.size());
    assertArrayEquals(new byte[] {'A'}, actualDecode2Result.get(0).getRLPData());
    assertArrayEquals(new byte[] {'A'}, actualDecode2Result.get(2).getRLPData());
    assertArrayEquals(new byte[] {'A'}, actualDecode2Result.get(4).getRLPData());
    assertArrayEquals(new byte[] {'A'}, actualDecode2Result.get(6).getRLPData());
    assertArrayEquals(new byte[] {'X'}, actualDecode2Result.get(1).getRLPData());
    assertArrayEquals(new byte[] {'X'}, actualDecode2Result.get(3).getRLPData());
    assertArrayEquals(new byte[] {'X'}, actualDecode2Result.get(5).getRLPData());
    assertArrayEquals(new byte[] {'X'}, actualDecode2Result.get(7).getRLPData());
  }

  /**
   * Test {@link RLP#decode2(byte[])} with {@code msgData}.
   *
   * <ul>
   *   <li>Then return first RLPData is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decode2(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RLPList RLP.decode2(byte[])"})
  public void testDecode2WithMsgData_thenReturnFirstRLPDataIsNull() {
    // Arrange and Act
    RLPList actualDecode2Result =
        RLP.decode2(new byte[] {Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals(8, actualDecode2Result.size());
    assertNull(actualDecode2Result.get(0).getRLPData());
    assertArrayEquals(new byte[] {'A'}, actualDecode2Result.get(2).getRLPData());
    assertArrayEquals(new byte[] {'A'}, actualDecode2Result.get(4).getRLPData());
    assertArrayEquals(new byte[] {'A'}, actualDecode2Result.get(6).getRLPData());
    assertArrayEquals(new byte[] {'X'}, actualDecode2Result.get(1).getRLPData());
    assertArrayEquals(new byte[] {'X'}, actualDecode2Result.get(3).getRLPData());
    assertArrayEquals(new byte[] {'X'}, actualDecode2Result.get(5).getRLPData());
    assertArrayEquals(new byte[] {'X'}, actualDecode2Result.get(7).getRLPData());
  }

  /**
   * Test {@link RLP#decode2(byte[])} with {@code msgData}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decode2(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RLPList RLP.decode2(byte[])"})
  public void testDecode2WithMsgData_whenArrayOfByteWithAAndMinusOne_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            RLP.decode2(
                new byte[] {
                  'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1
                }));
  }

  /**
   * Test {@link RLP#decode2(byte[])} with {@code msgData}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decode2(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RLPList RLP.decode2(byte[])"})
  public void testDecode2WithMsgData_whenArrayOfByteWithAAndMinusOne_thenThrowRuntimeException2() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            RLP.decode2(
                new byte[] {'A', -1, 0, -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1}));
  }

  /**
   * Test {@link RLP#decode2(byte[])} with {@code msgData}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus sixty-four and {@code X}.
   *   <li>Then first return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decode2(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RLPList RLP.decode2(byte[])"})
  public void testDecode2WithMsgData_whenArrayOfByteWithMinusSixtyFourAndX_thenFirstReturnList() {
    // Arrange and Act
    RLPList actualDecode2Result = RLP.decode2(new byte[] {-64, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals(8, actualDecode2Result.size());
    RLPElement getResult = actualDecode2Result.get(0);
    assertTrue(getResult instanceof List);
    assertTrue(actualDecode2Result.get(1) instanceof RLPItem);
    assertTrue(actualDecode2Result.get(2) instanceof RLPItem);
    assertTrue(actualDecode2Result.get(3) instanceof RLPItem);
    assertTrue(actualDecode2Result.get(4) instanceof RLPItem);
    assertTrue(actualDecode2Result.get(5) instanceof RLPItem);
    assertTrue(actualDecode2Result.get(6) instanceof RLPItem);
    assertTrue(actualDecode2Result.get(7) instanceof RLPItem);
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link RLP#decode2(byte[])} with {@code msgData}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decode2(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RLPList RLP.decode2(byte[])"})
  public void testDecode2WithMsgData_whenEmptyArrayOfByte_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(RLP.decode2(new byte[] {}).isEmpty());
  }

  /**
   * Test {@link RLP#unwrapList(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#unwrapList(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RLPList RLP.unwrapList(byte[])"})
  public void testUnwrapList_whenArrayOfByteWithMinusOneAndX_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> RLP.unwrapList(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link RLP#unwrapList(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and zero.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#unwrapList(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RLPList RLP.unwrapList(byte[])"})
  public void testUnwrapList_whenArrayOfByteWithMinusOneAndZero_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> RLP.unwrapList(new byte[] {-1, 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link RLP#decode2OneItem(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and {@link Byte#MIN_VALUE}.
   *   <li>Then return RLPData is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decode2OneItem(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RLPElement RLP.decode2OneItem(byte[], int)"})
  public void testDecode2OneItem_whenArrayOfByteWithAAndMin_value_thenReturnRLPDataIsNull() {
    // Arrange and Act
    RLPElement actualDecode2OneItemResult =
        RLP.decode2OneItem(new byte[] {'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, 1);
    byte[] actualRLPData = actualDecode2OneItemResult.getRLPData();

    // Assert
    assertTrue(actualDecode2OneItemResult instanceof RLPItem);
    assertNull(actualDecode2OneItemResult.getRLPData());
    assertNull(actualRLPData);
  }

  /**
   * Test {@link RLP#decode2OneItem(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return RLPData.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decode2OneItem(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RLPElement RLP.decode2OneItem(byte[], int)"})
  public void testDecode2OneItem_whenAxaxaxaxBytesIsUtf8_thenReturnRLPData()
      throws UnsupportedEncodingException {
    // Arrange and Act
    RLPElement actualDecode2OneItemResult = RLP.decode2OneItem("AXAXAXAX".getBytes("UTF-8"), 1);
    byte[] actualRLPData = actualDecode2OneItemResult.getRLPData();

    // Assert
    assertTrue(actualDecode2OneItemResult instanceof RLPItem);
    byte[] rLPData = actualDecode2OneItemResult.getRLPData();
    assertSame(rLPData, actualRLPData);
    assertArrayEquals(new byte[] {'X'}, rLPData);
  }

  /**
   * Test {@link RLP#fullTraverse(byte[], int, int, int, RLPList, int)}.
   *
   * <ul>
   *   <li>Then {@link RLPList} (default constructor) first RLPData is array of {@code byte} with
   *       minus sixty-four.
   * </ul>
   *
   * <p>Method under test: {@link RLP#fullTraverse(byte[], int, int, int, RLPList, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RLP.fullTraverse(byte[], int, int, int, RLPList, int)"})
  public void testFullTraverse_thenRLPListFirstRLPDataIsArrayOfByteWithMinusSixtyFour() {
    // Arrange
    RLPList rlpList = new RLPList();

    // Act
    RLP.fullTraverse(new byte[] {'A', -64, 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 1, 3, rlpList, 2);

    // Assert
    assertEquals(2, rlpList.size());
    assertArrayEquals(new byte[] {-64}, rlpList.get(0).getRLPData());
    assertArrayEquals(new byte[] {'A'}, rlpList.get(1).getRLPData());
  }

  /**
   * Test {@link RLP#fullTraverse(byte[], int, int, int, RLPList, int)}.
   *
   * <ul>
   *   <li>Then {@link RLPList} (default constructor) first RLPData is array of {@code byte} with
   *       {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#fullTraverse(byte[], int, int, int, RLPList, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RLP.fullTraverse(byte[], int, int, int, RLPList, int)"})
  public void testFullTraverse_thenRLPListFirstRLPDataIsArrayOfByteWithX()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    RLPList rlpList = new RLPList();

    // Act
    RLP.fullTraverse(msgData, 1, 1, 3, rlpList, 2);

    // Assert
    assertEquals(2, rlpList.size());
    assertArrayEquals(new byte[] {'A'}, rlpList.get(1).getRLPData());
    assertArrayEquals(new byte[] {'X'}, rlpList.get(0).getRLPData());
  }

  /**
   * Test {@link RLP#fullTraverse(byte[], int, int, int, RLPList, int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and {@link Byte#MIN_VALUE}.
   *   <li>Then {@link RLPList} (default constructor) first RLPData is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#fullTraverse(byte[], int, int, int, RLPList, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RLP.fullTraverse(byte[], int, int, int, RLPList, int)"})
  public void testFullTraverse_whenArrayOfByteWithAAndMin_value_thenRLPListFirstRLPDataIsNull() {
    // Arrange
    RLPList rlpList = new RLPList();

    // Act
    RLP.fullTraverse(
        new byte[] {'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 1, 3, rlpList, 2);

    // Assert
    assertEquals(2, rlpList.size());
    assertNull(rlpList.get(0).getRLPData());
    assertArrayEquals(new byte[] {'A'}, rlpList.get(1).getRLPData());
  }

  /**
   * Test {@link RLP#fullTraverse(byte[], int, int, int, RLPList, int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#fullTraverse(byte[], int, int, int, RLPList, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RLP.fullTraverse(byte[], int, int, int, RLPList, int)"})
  public void testFullTraverse_whenArrayOfByteWithAAndMinusOne_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            RLP.fullTraverse(
                new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 1, 3, new RLPList(), 2));
  }

  /**
   * Test {@link RLP#fullTraverse(byte[], int, int, int, RLPList, int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#fullTraverse(byte[], int, int, int, RLPList, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RLP.fullTraverse(byte[], int, int, int, RLPList, int)"})
  public void testFullTraverse_whenArrayOfByteWithAAndMinusOne_thenThrowRuntimeException2() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            RLP.fullTraverse(
                new byte[] {'A', -1, 0, 'X', 'A', 'X', 'A', 'X'}, 1, 1, 3, new RLPList(), 2));
  }

  /**
   * Test {@link RLP#fullTraverse(byte[], int, int, int, RLPList, int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and {@code X}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#fullTraverse(byte[], int, int, int, RLPList, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RLP.fullTraverse(byte[], int, int, int, RLPList, int)"})
  public void testFullTraverse_whenArrayOfByteWithAAndX_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            RLP.fullTraverse(
                new byte[] {'A', 'X', -1, 'X', 'A', 'X', 'A', 'X'}, 1, 1, 3, new RLPList(), 2));
  }

  /**
   * Test {@link RLP#fullTraverse(byte[], int, int, int, RLPList, int)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then {@link RLPList} (default constructor) Empty.
   * </ul>
   *
   * <p>Method under test: {@link RLP#fullTraverse(byte[], int, int, int, RLPList, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RLP.fullTraverse(byte[], int, int, int, RLPList, int)"})
  public void testFullTraverse_whenEmptyArrayOfByte_thenRLPListEmpty() {
    // Arrange
    RLPList rlpList = new RLPList();

    // Act
    RLP.fullTraverse(new byte[] {}, 1, 1, 3, rlpList, 2);

    // Assert that nothing has changed
    assertTrue(rlpList.isEmpty());
  }

  /**
   * Test {@link RLP#fullTraverse(byte[], int, int, int, RLPList, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link RLPList} (default constructor) Empty.
   * </ul>
   *
   * <p>Method under test: {@link RLP#fullTraverse(byte[], int, int, int, RLPList, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RLP.fullTraverse(byte[], int, int, int, RLPList, int)"})
  public void testFullTraverse_whenNull_thenRLPListEmpty() {
    // Arrange
    RLPList rlpList = new RLPList();

    // Act
    RLP.fullTraverse(null, Short.SIZE, 1, 3, rlpList, 2);

    // Assert that nothing has changed
    assertTrue(rlpList.isEmpty());
  }

  /**
   * Test {@link RLP#fullTraverse(byte[], int, int, int, RLPList, int)}.
   *
   * <ul>
   *   <li>When seventeen.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#fullTraverse(byte[], int, int, int, RLPList, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RLP.fullTraverse(byte[], int, int, int, RLPList, int)"})
  public void testFullTraverse_whenSeventeen_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            RLP.fullTraverse(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 17, 1, 3, new RLPList(), 2));
  }

  /**
   * Test {@link RLP#decode(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and {@link Byte#MIN_VALUE}.
   *   <li>Then return Decoded is empty string.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decode(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DecodeResult RLP.decode(byte[], int)"})
  public void testDecode_whenArrayOfByteWithAAndMin_value_thenReturnDecodedIsEmptyString() {
    // Arrange and Act
    DecodeResult actualDecodeResult =
        RLP.decode(new byte[] {'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, 1);

    // Assert
    assertEquals("", actualDecodeResult.getDecoded());
    assertEquals(2, actualDecodeResult.getPos());
  }

  /**
   * Test {@link RLP#decode(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus nine.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decode(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DecodeResult RLP.decode(byte[], int)"})
  public void testDecode_whenArrayOfByteWithAAndMinusNine_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> RLP.decode(new byte[] {'A', -9, 'A', 'X', 'A', 'X', -1, 'X'}, 1));
  }

  /**
   * Test {@link RLP#decode(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   *   <li>Then return Pos is ten.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decode(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DecodeResult RLP.decode(byte[], int)"})
  public void testDecode_whenArrayOfByteWithAAndMinusOne_thenReturnPosIsTen() {
    // Arrange and Act
    DecodeResult actualDecodeResult =
        RLP.decode(new byte[] {'A', -1, 'A', 'X', 'A', 'X', -1, 'X'}, 1);

    // Assert
    Object decoded = actualDecodeResult.getDecoded();
    assertTrue(decoded instanceof Object[]);
    assertEquals(0, ((Object[]) decoded).length);
    assertEquals(10, actualDecodeResult.getPos());
  }

  /**
   * Test {@link RLP#decode(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decode(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DecodeResult RLP.decode(byte[], int)"})
  public void testDecode_whenArrayOfByteWithAAndMinusOne_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> RLP.decode(new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#decode(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus sixty-four.
   *   <li>Then Decoded return {@code Object[]}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decode(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DecodeResult RLP.decode(byte[], int)"})
  public void testDecode_whenArrayOfByteWithAAndMinusSixtyFour_thenDecodedReturnObject() {
    // Arrange and Act
    DecodeResult actualDecodeResult =
        RLP.decode(new byte[] {'A', -64, 'A', 'X', 'A', 'X', -1, 'X'}, 1);

    // Assert
    Object decoded = actualDecodeResult.getDecoded();
    assertTrue(decoded instanceof Object[]);
    assertEquals(0, ((Object[]) decoded).length);
    assertEquals(2, actualDecodeResult.getPos());
  }

  /**
   * Test {@link RLP#decode(byte[], int)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decode(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DecodeResult RLP.decode(byte[], int)"})
  public void testDecode_whenEmptyArrayOfByte_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(RLP.decode(new byte[] {}, 1));
  }

  /**
   * Test {@link RLP#decode(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decode(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DecodeResult RLP.decode(byte[], int)"})
  public void testDecode_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(RLP.decode(null, 1));
  }

  /**
   * Test {@link RLP#decodeLazyList(byte[], int, int)} with {@code data}, {@code pos}, {@code
   * length}.
   *
   * <p>Method under test: {@link RLP#decodeLazyList(byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LList RLP.decodeLazyList(byte[], int, int)"})
  public void testDecodeLazyListWithDataPosLength() throws UnsupportedEncodingException {
    // Arrange and Act
    LList actualDecodeLazyListResult = RLP.decodeLazyList("AXAXAXAX".getBytes("UTF-8"), 1, 3);

    // Assert
    assertEquals(3, actualDecodeLazyListResult.size());
    assertArrayEquals(new byte[] {-61, 'X', 'A', 'X'}, actualDecodeLazyListResult.getEncoded());
  }

  /**
   * Test {@link RLP#decodeLazyList(byte[], int, int)} with {@code data}, {@code pos}, {@code
   * length}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeLazyList(byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LList RLP.decodeLazyList(byte[], int, int)"})
  public void testDecodeLazyListWithDataPosLength_thenReturnSizeIsOne() {
    // Arrange, Act and Assert
    assertEquals(
        1, RLP.decodeLazyList(new byte[] {'A', -73, 'A', 'X', 'A', 'X', -1, 'X'}, 1, 3).size());
  }

  /**
   * Test {@link RLP#decodeLazyList(byte[], int, int)} with {@code data}, {@code pos}, {@code
   * length}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeLazyList(byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LList RLP.decodeLazyList(byte[], int, int)"})
  public void testDecodeLazyListWithDataPosLength_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> RLP.decodeLazyList(new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 3));
  }

  /**
   * Test {@link RLP#decodeLazyList(byte[], int, int)} with {@code data}, {@code pos}, {@code
   * length}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeLazyList(byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LList RLP.decodeLazyList(byte[], int, int)"})
  public void testDecodeLazyListWithDataPosLength_whenArrayOfByteWithAAndMin_value() {
    // Arrange and Act
    LList actualDecodeLazyListResult =
        RLP.decodeLazyList(new byte[] {'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 3);

    // Assert
    assertEquals(3, actualDecodeLazyListResult.size());
    assertArrayEquals(
        new byte[] {-61, Byte.MIN_VALUE, 'A', 'X'}, actualDecodeLazyListResult.getEncoded());
  }

  /**
   * Test {@link RLP#decodeLazyList(byte[], int, int)} with {@code data}, {@code pos}, {@code
   * length}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus sixty-four.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeLazyList(byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LList RLP.decodeLazyList(byte[], int, int)"})
  public void testDecodeLazyListWithDataPosLength_whenArrayOfByteWithAAndMinusSixtyFour() {
    // Arrange and Act
    LList actualDecodeLazyListResult =
        RLP.decodeLazyList(new byte[] {'A', -64, 'A', 'X', 'A', 'X', -1, 'X'}, 1, 3);

    // Assert
    assertEquals(3, actualDecodeLazyListResult.size());
    assertArrayEquals(
        new byte[] {-61, Byte.MIN_VALUE, 'A', 'X'}, actualDecodeLazyListResult.getEncoded());
  }

  /**
   * Test {@link RLP#decodeLazyList(byte[], int, int)} with {@code data}, {@code pos}, {@code
   * length}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeLazyList(byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LList RLP.decodeLazyList(byte[], int, int)"})
  public void testDecodeLazyListWithDataPosLength_whenEmptyArrayOfByte_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(RLP.decodeLazyList(new byte[] {}, 1, 3));
  }

  /**
   * Test {@link RLP#decodeLazyList(byte[], int, int)} with {@code data}, {@code pos}, {@code
   * length}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeLazyList(byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LList RLP.decodeLazyList(byte[], int, int)"})
  public void testDecodeLazyListWithDataPosLength_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(RLP.decodeLazyList(null, 1, 3));
  }

  /**
   * Test {@link RLP#decodeLazyList(byte[])} with {@code data}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MIN_VALUE} and {@code X}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeLazyList(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LList RLP.decodeLazyList(byte[])"})
  public void testDecodeLazyListWithData_whenArrayOfByteWithMin_valueAndX_thenReturnSizeIsZero() {
    // Arrange and Act
    LList actualDecodeLazyListResult =
        RLP.decodeLazyList(new byte[] {Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals(0, actualDecodeLazyListResult.size());
    assertArrayEquals(new byte[] {-64}, actualDecodeLazyListResult.getEncoded());
  }

  /**
   * Test {@link RLP#decodeLazyList(byte[])} with {@code data}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus nine and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeLazyList(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LList RLP.decodeLazyList(byte[])"})
  public void testDecodeLazyListWithData_whenArrayOfByteWithMinusNineAndX() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> RLP.decodeLazyList(new byte[] {-9, 'X', 'A', 'X', 'A', -1, 'A', 'X'}));
  }

  /**
   * Test {@link RLP#decodeLazyList(byte[])} with {@code data}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeLazyList(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LList RLP.decodeLazyList(byte[])"})
  public void testDecodeLazyListWithData_whenArrayOfByteWithMinusOneAndX() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> RLP.decodeLazyList(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link RLP#decodeLazyList(byte[])} with {@code data}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus seventy-three and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeLazyList(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LList RLP.decodeLazyList(byte[])"})
  public void testDecodeLazyListWithData_whenArrayOfByteWithMinusSeventyThreeAndX() {
    // Arrange and Act
    LList actualDecodeLazyListResult =
        RLP.decodeLazyList(new byte[] {-73, 'X', 'A', 'X', 'A', -1, 'A', 'X'});

    // Assert
    assertEquals(0, actualDecodeLazyListResult.size());
    assertArrayEquals(new byte[] {-64}, actualDecodeLazyListResult.getEncoded());
  }

  /**
   * Test {@link RLP#decodeLazyList(byte[])} with {@code data}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus sixty-four and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeLazyList(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LList RLP.decodeLazyList(byte[])"})
  public void testDecodeLazyListWithData_whenArrayOfByteWithMinusSixtyFourAndX() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> RLP.decodeLazyList(new byte[] {-64, 'X', 'A', 'X', 'A', -1, 'A', 'X'}));
  }

  /**
   * Test {@link RLP#decodeLazyList(byte[])} with {@code data}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeLazyList(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LList RLP.decodeLazyList(byte[])"})
  public void testDecodeLazyListWithData_whenAxaxaxaxBytesIsUtf8_thenReturnSizeIsZero()
      throws UnsupportedEncodingException {
    // Arrange and Act
    LList actualDecodeLazyListResult = RLP.decodeLazyList("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(0, actualDecodeLazyListResult.size());
    assertArrayEquals(new byte[] {-64}, actualDecodeLazyListResult.getEncoded());
  }

  /**
   * Test {@link RLP#decodeLazyList(byte[])} with {@code data}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeLazyList(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LList RLP.decodeLazyList(byte[])"})
  public void testDecodeLazyListWithData_whenEmptyArrayOfByte_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(RLP.decodeLazyList(new byte[] {}));
  }

  /**
   * Test {@link RLP#encode(Object)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus one hundred twenty-five and {@code O}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encode(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encode(Object)"})
  public void testEncode_thenReturnArrayOfByteWithMinusOneHundredTwentyFiveAndO() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {-125, 'O', 'b', 'j'}, RLP.encode(new Value("Obj")));
  }

  /**
   * Test {@link RLP#encode(Object)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus one hundred twenty-seven and minus one.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encode(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encode(Object)"})
  public void testEncode_thenReturnArrayOfByteWithMinusOneHundredTwentySevenAndMinusOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {-127, -1}, RLP.encode(-1));
  }

  /**
   * Test {@link RLP#encode(Object)}.
   *
   * <ul>
   *   <li>Then return first element is minus seventy-two.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encode(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encode(Object)"})
  public void testEncode_thenReturnFirstElementIsMinusSeventyTwo() {
    // Arrange and Act
    byte[] actualEncodeResult =
        RLP.encode("Unsupported type: Only accepting String, Integer and BigInteger for now");

    // Assert
    assertEquals((byte) -72, actualEncodeResult[0]);
    assertEquals(73, actualEncodeResult.length);
    assertEquals(' ', actualEncodeResult[13]);
    assertEquals(' ', actualEncodeResult[24]);
    assertEquals(' ', actualEncodeResult[50]);
    assertEquals(' ', actualEncodeResult[54]);
    assertEquals(' ', actualEncodeResult[65]);
    assertEquals(' ', actualEncodeResult[69]);
    assertEquals(' ', actualEncodeResult[MarketUtils.TOKEN_ID_LENGTH]);
    assertEquals(':', actualEncodeResult[18]);
    assertEquals('B', actualEncodeResult[55]);
    assertEquals('G', actualEncodeResult[1]);
    assertEquals('I', actualEncodeResult[58]);
    assertEquals('O', actualEncodeResult[20]);
    assertEquals('U', actualEncodeResult[2]);
    assertEquals('a', actualEncodeResult[51]);
    assertEquals('d', actualEncodeResult[12]);
    assertEquals('d', actualEncodeResult[53]);
    assertEquals('e', actualEncodeResult[11]);
    assertEquals('e', actualEncodeResult[17]);
    assertEquals('e', actualEncodeResult[48]);
    assertEquals('e', actualEncodeResult[61]);
    assertEquals('e', actualEncodeResult[63]);
    assertEquals('f', actualEncodeResult[66]);
    assertEquals('g', actualEncodeResult[57]);
    assertEquals('g', actualEncodeResult[62]);
    assertEquals('i', actualEncodeResult[56]);
    assertEquals('l', actualEncodeResult[22]);
    assertEquals('n', actualEncodeResult[21]);
    assertEquals('n', actualEncodeResult[3]);
    assertEquals('n', actualEncodeResult[52]);
    assertEquals('n', actualEncodeResult[59]);
    assertEquals('n', actualEncodeResult[70]);
    assertEquals('o', actualEncodeResult[67]);
    assertEquals('o', actualEncodeResult[71]);
    assertEquals('o', actualEncodeResult[8]);
    assertEquals('p', actualEncodeResult[6]);
    assertEquals('p', actualEncodeResult[7]);
    assertEquals('p', actualEncodeResult[Short.SIZE]);
    assertEquals('r', actualEncodeResult[49]);
    assertEquals('r', actualEncodeResult[68]);
    assertEquals('r', actualEncodeResult[9]);
    assertEquals('r', actualEncodeResult[Double.SIZE]);
    assertEquals('s', actualEncodeResult[4]);
    assertEquals('t', actualEncodeResult[10]);
    assertEquals('t', actualEncodeResult[14]);
    assertEquals('t', actualEncodeResult[60]);
    assertEquals('u', actualEncodeResult[5]);
    assertEquals('w', actualEncodeResult[72]);
    assertEquals('y', actualEncodeResult[15]);
    assertEquals('y', actualEncodeResult[23]);
  }

  /**
   * Test {@link RLP#encode(Object)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return array of {@code byte} with minus one hundred twenty-three and {@code I}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encode(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encode(Object)"})
  public void testEncode_whenInput_thenReturnArrayOfByteWithMinusOneHundredTwentyThreeAndI() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {-123, 'I', 'n', 'p', 'u', 't'}, RLP.encode("Input"));
  }

  /**
   * Test {@link RLP#encode(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encode(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encode(Object)"})
  public void testEncode_whenNull_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> RLP.encode(null));
  }

  /**
   * Test {@link RLP#encode(Object)}.
   *
   * <ul>
   *   <li>When one hundred twenty-eight.
   *   <li>Then return array of {@code byte} with {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encode(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encode(Object)"})
  public void testEncode_whenOneHundredTwentyEight_thenReturnArrayOfByteWithMin_value() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {Byte.MIN_VALUE}, RLP.encode(128));
  }

  /**
   * Test {@link RLP#encode(Object)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return array of {@code byte} with one.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encode(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encode(Object)"})
  public void testEncode_whenOne_thenReturnArrayOfByteWithOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {1}, RLP.encode(1));
  }

  /**
   * Test {@link RLP#encode(Object)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return array of {@code byte} with one.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encode(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encode(Object)"})
  public void testEncode_whenOne_thenReturnArrayOfByteWithOne2() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {1}, RLP.encode(1L));
  }

  /**
   * Test {@link RLP#encode(Object)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then return array of {@code byte} with one.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encode(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encode(Object)"})
  public void testEncode_whenValueOfOne_thenReturnArrayOfByteWithOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {1}, RLP.encode(BigInteger.valueOf(1L)));
  }

  /**
   * Test {@link RLP#encode(Object)}.
   *
   * <ul>
   *   <li>When valueOf zero.
   *   <li>Then return array of {@code byte} with {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encode(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encode(Object)"})
  public void testEncode_whenValueOfZero_thenReturnArrayOfByteWithMin_value() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {Byte.MIN_VALUE}, RLP.encode(BigInteger.valueOf(0L)));
  }

  /**
   * Test {@link RLP#encode(Object)}.
   *
   * <ul>
   *   <li>When {@link Value#Value()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encode(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encode(Object)"})
  public void testEncode_whenValue_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> RLP.encode(new Value()));
  }

  /**
   * Test {@link RLP#encode(Object)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return array of {@code byte} with {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encode(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encode(Object)"})
  public void testEncode_whenZero_thenReturnArrayOfByteWithMin_value() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {Byte.MIN_VALUE}, RLP.encode(0));
  }

  /**
   * Test {@link RLP#encode(Object)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return array of {@code byte} with {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encode(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encode(Object)"})
  public void testEncode_whenZero_thenReturnArrayOfByteWithMin_value2() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {Byte.MIN_VALUE}, RLP.encode(0L));
  }

  /**
   * Test {@link RLP#encodeLength(int, int)}.
   *
   * <ul>
   *   <li>When fifty-six.
   *   <li>Then return array of {@code byte} with {@code :} and {@code 8}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeLength(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeLength(int, int)"})
  public void testEncodeLength_whenFiftySix_thenReturnArrayOfByteWithColonAnd8() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {':', '8'}, RLP.encodeLength(56, 2));
  }

  /**
   * Test {@link RLP#encodeLength(int, int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return array of {@code byte} with five.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeLength(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeLength(int, int)"})
  public void testEncodeLength_whenThree_thenReturnArrayOfByteWithFive() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {5}, RLP.encodeLength(3, 2));
  }

  /**
   * Test {@link RLP#encodeLength(int, int)}.
   *
   * <ul>
   *   <li>When two hundred fifty-six.
   *   <li>Then return array of {@code byte} with {@code ;} and one.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeLength(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeLength(int, int)"})
  public void testEncodeLength_whenTwoHundredFiftySix_thenReturnArrayOfByteWithSemicolonAndOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {';', 1, 0}, RLP.encodeLength(256, 2));
  }

  /**
   * Test {@link RLP#encodeByte(byte)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus one hundred twenty-seven and minus one.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeByte(byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeByte(byte)"})
  public void testEncodeByte_thenReturnArrayOfByteWithMinusOneHundredTwentySevenAndMinusOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {-127, -1}, RLP.encodeByte((byte) -1));
  }

  /**
   * Test {@link RLP#encodeByte(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return array of {@code byte} with {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeByte(byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeByte(byte)"})
  public void testEncodeByte_whenA_thenReturnArrayOfByteWithA() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {'A'}, RLP.encodeByte((byte) 'A'));
  }

  /**
   * Test {@link RLP#encodeByte(byte)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return array of {@code byte} with {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeByte(byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeByte(byte)"})
  public void testEncodeByte_whenZero_thenReturnArrayOfByteWithMin_value() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {Byte.MIN_VALUE}, RLP.encodeByte((byte) 0));
  }

  /**
   * Test {@link RLP#encodeShort(short)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus one hundred twenty-seven and minus one.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeShort(short)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeShort(short)"})
  public void testEncodeShort_thenReturnArrayOfByteWithMinusOneHundredTwentySevenAndMinusOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {-127, -1}, RLP.encodeShort((short) 255));
  }

  /**
   * Test {@link RLP#encodeShort(short)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus one hundred twenty-six and minus one.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeShort(short)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeShort(short)"})
  public void testEncodeShort_thenReturnArrayOfByteWithMinusOneHundredTwentySixAndMinusOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {-126, -1, Byte.MIN_VALUE}, RLP.encodeShort((short) -128));
  }

  /**
   * Test {@link RLP#encodeShort(short)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return array of {@code byte} with one.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeShort(short)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeShort(short)"})
  public void testEncodeShort_whenOne_thenReturnArrayOfByteWithOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {1}, RLP.encodeShort((short) 1));
  }

  /**
   * Test {@link RLP#encodeShort(short)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return array of {@code byte} with {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeShort(short)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeShort(short)"})
  public void testEncodeShort_whenZero_thenReturnArrayOfByteWithMin_value() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {Byte.MIN_VALUE}, RLP.encodeShort((short) 0));
  }

  /**
   * Test {@link RLP#encodeInt(int)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus one hundred twenty-four and minus one.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeInt(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeInt(int)"})
  public void testEncodeInt_thenReturnArrayOfByteWithMinusOneHundredTwentyFourAndMinusOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {-124, -1, -1, -1, Byte.MIN_VALUE}, RLP.encodeInt(-128));
  }

  /**
   * Test {@link RLP#encodeInt(int)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus one hundred twenty-seven and minus one.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeInt(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeInt(int)"})
  public void testEncodeInt_thenReturnArrayOfByteWithMinusOneHundredTwentySevenAndMinusOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {-127, -1}, RLP.encodeInt(255));
  }

  /**
   * Test {@link RLP#encodeInt(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return array of {@code byte} with one.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeInt(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeInt(int)"})
  public void testEncodeInt_whenOne_thenReturnArrayOfByteWithOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {1}, RLP.encodeInt(1));
  }

  /**
   * Test {@link RLP#encodeInt(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return array of {@code byte} with {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeInt(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeInt(int)"})
  public void testEncodeInt_whenZero_thenReturnArrayOfByteWithMin_value() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {Byte.MIN_VALUE}, RLP.encodeInt(0));
  }

  /**
   * Test {@link RLP#encodeString(String)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus one hundred eighteen and {@code S}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeString(String)"})
  public void testEncodeString_thenReturnArrayOfByteWithMinusOneHundredEighteenAndS() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {-118, 'S', 'r', 'c', ' ', 'S', 't', 'r', 'i', 'n', 'g'},
        RLP.encodeString("Src String"));
  }

  /**
   * Test {@link RLP#encodeString(String)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus seventy-two and {@code 9}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeString(String)"})
  public void testEncodeString_thenReturnArrayOfByteWithMinusSeventyTwoAnd9() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          -72, '9', 'j', 'a', 'v', 'a', '.', 'l', 'a', 'n', 'g', '.', 'I', 'n', 't', 'e', 'g', 'e',
          'r', 'j', 'a', 'v', 'a', '.', 'm', 'a', 't', 'h', '.', 'B', 'i', 'g', 'I', 'n', 't', 'e',
          'g', 'e', 'r', 'j', 'a', 'v', 'a', '.', 'm', 'a', 't', 'h', '.', 'B', 'i', 'g', 'I', 'n',
          't', 'e', 'g', 'e', 'r'
        },
        RLP.encodeString("java.lang.Integerjava.math.BigIntegerjava.math.BigInteger"));
  }

  /**
   * Test {@link RLP#encodeString(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return array of {@code byte} with {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeString(String)"})
  public void testEncodeString_whenEmptyString_thenReturnArrayOfByteWithMin_value() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {Byte.MIN_VALUE}, RLP.encodeString(""));
  }

  /**
   * Test {@link RLP#encodeString(String)}.
   *
   * <ul>
   *   <li>When {@code )}.
   *   <li>Then return array of {@code byte} with {@code )}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeString(String)"})
  public void testEncodeString_whenRightParenthesis_thenReturnArrayOfByteWithRightParenthesis() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {')'}, RLP.encodeString(")"));
  }

  /**
   * Test {@link RLP#encodeBigInteger(BigInteger)}.
   *
   * <p>Method under test: {@link RLP#encodeBigInteger(BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeBigInteger(BigInteger)"})
  public void testEncodeBigInteger() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {-127, -1}, RLP.encodeBigInteger(BigInteger.valueOf(255L)));
  }

  /**
   * Test {@link RLP#encodeBigInteger(BigInteger)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus one hundred twenty and {@link
   *       Byte#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeBigInteger(BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeBigInteger(BigInteger)"})
  public void testEncodeBigInteger_thenReturnArrayOfByteWithMinusOneHundredTwentyAndMax_value() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {-120, Byte.MAX_VALUE, -1, -1, -1, -1, -1, -1, -1},
        RLP.encodeBigInteger(BigInteger.valueOf(Long.MAX_VALUE)));
  }

  /**
   * Test {@link RLP#encodeBigInteger(BigInteger)}.
   *
   * <ul>
   *   <li>When valueOf minus one.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeBigInteger(BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeBigInteger(BigInteger)"})
  public void testEncodeBigInteger_whenValueOfMinusOne_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> RLP.encodeBigInteger(BigInteger.valueOf(-1L)));
  }

  /**
   * Test {@link RLP#encodeBigInteger(BigInteger)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then return array of {@code byte} with one.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeBigInteger(BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeBigInteger(BigInteger)"})
  public void testEncodeBigInteger_whenValueOfOne_thenReturnArrayOfByteWithOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {1}, RLP.encodeBigInteger(BigInteger.valueOf(1L)));
  }

  /**
   * Test {@link RLP#encodeBigInteger(BigInteger)}.
   *
   * <ul>
   *   <li>When valueOf zero.
   *   <li>Then return array of {@code byte} with {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeBigInteger(BigInteger)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeBigInteger(BigInteger)"})
  public void testEncodeBigInteger_whenValueOfZero_thenReturnArrayOfByteWithMin_value() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {Byte.MIN_VALUE}, RLP.encodeBigInteger(BigInteger.valueOf(0L)));
  }

  /**
   * Test {@link RLP#calcElementPrefixSize(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RLP#calcElementPrefixSize(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.calcElementPrefixSize(byte[])"})
  public void testCalcElementPrefixSize_whenArrayOfByteWithA_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, RLP.calcElementPrefixSize(new byte[] {'A'}));
  }

  /**
   * Test {@link RLP#calcElementPrefixSize(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MIN_VALUE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RLP#calcElementPrefixSize(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.calcElementPrefixSize(byte[])"})
  public void testCalcElementPrefixSize_whenArrayOfByteWithMin_value_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, RLP.calcElementPrefixSize(new byte[] {Byte.MIN_VALUE}));
  }

  /**
   * Test {@link RLP#calcElementPrefixSize(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RLP#calcElementPrefixSize(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.calcElementPrefixSize(byte[])"})
  public void testCalcElementPrefixSize_whenArrayOfByteWithZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, RLP.calcElementPrefixSize(new byte[] {0}));
  }

  /**
   * Test {@link RLP#calcElementPrefixSize(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RLP#calcElementPrefixSize(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.calcElementPrefixSize(byte[])"})
  public void testCalcElementPrefixSize_whenAxaxaxaxBytesIsUtf8_thenReturnOne()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1, RLP.calcElementPrefixSize("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link RLP#calcElementPrefixSize(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RLP#calcElementPrefixSize(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.calcElementPrefixSize(byte[])"})
  public void testCalcElementPrefixSize_whenEmptyArrayOfByte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, RLP.calcElementPrefixSize(new byte[] {}));
  }

  /**
   * Test {@link RLP#calcElementPrefixSize(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RLP#calcElementPrefixSize(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RLP.calcElementPrefixSize(byte[])"})
  public void testCalcElementPrefixSize_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, RLP.calcElementPrefixSize(null));
  }

  /**
   * Test {@link RLP#encodeListHeader(int)}.
   *
   * <ul>
   *   <li>When fifty-six.
   *   <li>Then return array of {@code byte} with minus eight and {@code 8}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeListHeader(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeListHeader(int)"})
  public void testEncodeListHeader_whenFiftySix_thenReturnArrayOfByteWithMinusEightAnd8() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {-8, '8'}, RLP.encodeListHeader(56));
  }

  /**
   * Test {@link RLP#encodeListHeader(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return array of {@code byte} with minus sixty-one.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeListHeader(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeListHeader(int)"})
  public void testEncodeListHeader_whenThree_thenReturnArrayOfByteWithMinusSixtyOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {-61}, RLP.encodeListHeader(3));
  }

  /**
   * Test {@link RLP#encodeListHeader(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return array of {@code byte} with minus sixty-four.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeListHeader(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeListHeader(int)"})
  public void testEncodeListHeader_whenZero_thenReturnArrayOfByteWithMinusSixtyFour() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {-64}, RLP.encodeListHeader(0));
  }

  /**
   * Test {@link RLP#encodeLongElementHeader(int)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus one hundred twenty-five.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeLongElementHeader(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeLongElementHeader(int)"})
  public void testEncodeLongElementHeader_thenReturnArrayOfByteWithMinusOneHundredTwentyFive() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {-125}, RLP.encodeLongElementHeader(3));
  }

  /**
   * Test {@link RLP#encodeLongElementHeader(int)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus seventy-two and {@code 8}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeLongElementHeader(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeLongElementHeader(int)"})
  public void testEncodeLongElementHeader_thenReturnArrayOfByteWithMinusSeventyTwoAnd8() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {-72, '8'}, RLP.encodeLongElementHeader(56));
  }

  /**
   * Test {@link RLP#encodeLongElementHeader(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return array of {@code byte} with {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeLongElementHeader(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeLongElementHeader(int)"})
  public void testEncodeLongElementHeader_whenZero_thenReturnArrayOfByteWithMin_value() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {Byte.MIN_VALUE}, RLP.encodeLongElementHeader(0));
  }

  /**
   * Test {@link RLP#encodeSet(Set)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus fifty-five and minus one hundred twenty.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeSet(Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeSet(Set)"})
  public void testEncodeSet_thenReturnArrayOfByteWithMinusFiftyFiveAndMinusOneHundredTwenty() {
    // Arrange
    HashSet<ByteArrayWrapper> data = new HashSet<>();
    ByteArrayWrapper byteArrayWrapper =
        new ByteArrayWrapper(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    data.add(byteArrayWrapper);

    // Act and Assert
    assertArrayEquals(new byte[] {-55, -120, 'A', 1, 'A', 1, 'A', 1, 'A', 1}, RLP.encodeSet(data));
  }

  /**
   * Test {@link RLP#encodeSet(Set)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus sixty-three and {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeSet(Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeSet(Set)"})
  public void testEncodeSet_thenReturnArrayOfByteWithMinusSixtyThreeAndMin_value() {
    // Arrange
    HashSet<ByteArrayWrapper> data = new HashSet<>();
    ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper(new byte[] {});
    data.add(byteArrayWrapper);

    // Act and Assert
    assertArrayEquals(new byte[] {-63, Byte.MIN_VALUE}, RLP.encodeSet(data));
  }

  /**
   * Test {@link RLP#encodeSet(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return array of {@code byte} with minus sixty-four.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeSet(Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeSet(Set)"})
  public void testEncodeSet_whenHashSet_thenReturnArrayOfByteWithMinusSixtyFour() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {-64}, RLP.encodeSet(new HashSet<>()));
  }

  /**
   * Test {@link RLP#wrapList(byte[][])}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus fifty-five and minus one hundred twenty.
   * </ul>
   *
   * <p>Method under test: {@link RLP#wrapList(byte[][])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.wrapList(byte[][])"})
  public void testWrapList_thenReturnArrayOfByteWithMinusFiftyFiveAndMinusOneHundredTwenty()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {-55, -120, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        RLP.wrapList("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link RLP#wrapList(byte[][])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#wrapList(byte[][])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.wrapList(byte[][])"})
  public void testWrapList_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {-63, Byte.MIN_VALUE}, RLP.wrapList(new byte[] {}));
  }

  /**
   * Test {@link RLP#encodeList(byte[][])} with {@code byte[][]}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus fifty-six and {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeList(byte[][])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeList(byte[][])"})
  public void testEncodeListWithByte_thenReturnArrayOfByteWithMinusFiftySixAndA()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {-56, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        RLP.encodeList("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link RLP#encodeList(byte[][])} with {@code byte[][]}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return array of {@code byte} with minus sixty-four.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeList(byte[][])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeList(byte[][])"})
  public void testEncodeListWithByte_whenNull_thenReturnArrayOfByteWithMinusSixtyFour() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {-64}, RLP.encodeList((byte[][]) null));
  }

  /**
   * Test {@link RLP#encodeList(Object[])} with {@code Object[]}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus sixty-four.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeList(Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeList(Object[])"})
  public void testEncodeListWithObject_thenReturnArrayOfByteWithMinusSixtyFour() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {-64}, RLP.encodeList(new Object[] {}));
  }

  /**
   * Test {@link RLP#encodeList(Object[])} with {@code Object[]}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return array of {@code byte} with minus sixty-four.
   * </ul>
   *
   * <p>Method under test: {@link RLP#encodeList(Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.encodeList(Object[])"})
  public void testEncodeListWithObject_whenNull_thenReturnArrayOfByteWithMinusSixtyFour() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {-64}, RLP.encodeList((Object[]) null));
  }

  /**
   * Test {@link RLP#decodeItemBytes(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and {@link Byte#MIN_VALUE}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeItemBytes(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.decodeItemBytes(byte[], int)"})
  public void testDecodeItemBytes_whenArrayOfByteWithAAndMin_value_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {},
        RLP.decodeItemBytes(new byte[] {'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link RLP#decodeItemBytes(byte[], int)}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeItemBytes(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.decodeItemBytes(byte[], int)"})
  public void testDecodeItemBytes_whenArrayOfByteWithAAndMinusOne_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            RLP.decodeItemBytes(
                new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1},
                1));
  }

  /**
   * Test {@link RLP#decodeItemBytes(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return array of {@code byte} with {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link RLP#decodeItemBytes(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RLP.decodeItemBytes(byte[], int)"})
  public void testDecodeItemBytes_whenAxaxaxaxBytesIsUtf8_thenReturnArrayOfByteWithX()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {'X'}, RLP.decodeItemBytes("AXAXAXAX".getBytes("UTF-8"), 1));
  }
}
