package org.tron.core.trie;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TrieKeyDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TrieKey#TrieKey(byte[], int, boolean)}
   *   <li>{@link TrieKey#isTerminal()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieKey.<init>(byte[], int, boolean)", "boolean TrieKey.isTerminal()"})
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(new TrieKey("AXAXAXAX".getBytes("UTF-8"), 1, true).isTerminal());
  }

  /**
   * Test {@link TrieKey#fromNormal(byte[])}.
   *
   * <p>Method under test: {@link TrieKey#fromNormal(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.fromNormal(byte[])"})
  public void testFromNormal() throws UnsupportedEncodingException {
    // Arrange and Act
    TrieKey actualFromNormalResult = TrieKey.fromNormal("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertFalse(actualFromNormalResult.isEmpty());
    assertTrue(actualFromNormalResult.isTerminal());
    assertEquals(Short.SIZE, actualFromNormalResult.getLength());
    byte[] expectedToPackedResult = " AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToPackedResult, actualFromNormalResult.toPacked());
    byte[] expectedToNormalResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToNormalResult, actualFromNormalResult.toNormal());
  }

  /**
   * Test {@link TrieKey#fromPacked(byte[])}.
   *
   * <ul>
   *   <li>Then return toPacked is array of {@code byte} with twenty-four and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#fromPacked(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.fromPacked(byte[])"})
  public void testFromPacked_thenReturnToPackedIsArrayOfByteWithTwentyFourAndX()
      throws UnsupportedEncodingException {
    // Arrange and Act
    TrieKey actualFromPackedResult = TrieKey.fromPacked("XXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(15, actualFromPackedResult.getLength());
    assertFalse(actualFromPackedResult.isEmpty());
    assertFalse(actualFromPackedResult.isTerminal());
    assertArrayEquals(
        new byte[] {24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualFromPackedResult.toPacked());
  }

  /**
   * Test {@link TrieKey#fromPacked(byte[])}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Terminal.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#fromPacked(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.fromPacked(byte[])"})
  public void testFromPacked_whenA_thenReturnTerminal() throws UnsupportedEncodingException {
    // Arrange and Act
    TrieKey actualFromPackedResult =
        TrieKey.fromPacked(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals(15, actualFromPackedResult.getLength());
    assertFalse(actualFromPackedResult.isEmpty());
    assertTrue(actualFromPackedResult.isTerminal());
    byte[] expectedToPackedResult = "?XAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToPackedResult, actualFromPackedResult.toPacked());
  }

  /**
   * Test {@link TrieKey#fromPacked(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Length is fourteen.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#fromPacked(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.fromPacked(byte[])"})
  public void testFromPacked_whenAxaxaxaxBytesIsUtf8_thenReturnLengthIsFourteen()
      throws UnsupportedEncodingException {
    // Arrange and Act
    TrieKey actualFromPackedResult = TrieKey.fromPacked("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(14, actualFromPackedResult.getLength());
    assertFalse(actualFromPackedResult.isTerminal());
    byte[] expectedToNormalResult = "XAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToNormalResult, actualFromPackedResult.toNormal());
    assertArrayEquals(
        new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualFromPackedResult.toPacked());
  }

  /**
   * Test {@link TrieKey#empty(boolean)}.
   *
   * <p>Method under test: {@link TrieKey#empty(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.empty(boolean)"})
  public void testEmpty() {
    // Arrange and Act
    TrieKey actualEmptyResult = TrieKey.empty(true);

    // Assert
    assertEquals(0, actualEmptyResult.getLength());
    assertTrue(actualEmptyResult.isEmpty());
    assertTrue(actualEmptyResult.isTerminal());
    assertArrayEquals(new byte[] {}, actualEmptyResult.toNormal());
    assertArrayEquals(new byte[] {' '}, actualEmptyResult.toPacked());
  }

  /**
   * Test {@link TrieKey#singleHex(int)}.
   *
   * <p>Method under test: {@link TrieKey#singleHex(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.singleHex(int)"})
  public void testSingleHex() {
    // Arrange and Act
    TrieKey actualSingleHexResult = TrieKey.singleHex(1);

    // Assert
    assertEquals(1, actualSingleHexResult.getLength());
    assertFalse(actualSingleHexResult.isEmpty());
    assertFalse(actualSingleHexResult.isTerminal());
    assertArrayEquals(new byte[] {17}, actualSingleHexResult.toPacked());
  }

  /**
   * Test {@link TrieKey#toPacked()}.
   *
   * <ul>
   *   <li>Given empty {@code true}.
   *   <li>Then return array of {@code byte} with space.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#toPacked()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TrieKey.toPacked()"})
  public void testToPacked_givenEmptyTrue_thenReturnArrayOfByteWithSpace() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act and Assert
    assertArrayEquals(new byte[] {' '}, emptyResult.toPacked());
  }

  /**
   * Test {@link TrieKey#toPacked()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with seventeen and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#toPacked()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TrieKey.toPacked()"})
  public void testToPacked_thenReturnArrayOfByteWithSeventeenAndX()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {17, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        new TrieKey("AXAXAXAX".getBytes("UTF-8"), 1, false).toPacked());
  }

  /**
   * Test {@link TrieKey#toNormal()}.
   *
   * <ul>
   *   <li>Given empty {@code true}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#toNormal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TrieKey.toNormal()"})
  public void testToNormal_givenEmptyTrue_thenReturnEmptyArrayOfByte() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act and Assert
    assertArrayEquals(new byte[] {}, emptyResult.toNormal());
  }

  /**
   * Test {@link TrieKey#toNormal()}.
   *
   * <ul>
   *   <li>Given singleHex one.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#toNormal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TrieKey.toNormal()"})
  public void testToNormal_givenSingleHexOne_thenThrowRuntimeException() {
    // Arrange
    TrieKey singleHexResult = TrieKey.singleHex(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> singleHexResult.toNormal());
  }

  /**
   * Test {@link TrieKey#isEmpty()}.
   *
   * <ul>
   *   <li>Given empty {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#isEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieKey.isEmpty()"})
  public void testIsEmpty_givenEmptyTrue_thenReturnTrue() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act and Assert
    assertTrue(emptyResult.isEmpty());
  }

  /**
   * Test {@link TrieKey#isEmpty()}.
   *
   * <ul>
   *   <li>Given singleHex one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#isEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieKey.isEmpty()"})
  public void testIsEmpty_givenSingleHexOne_thenReturnFalse() {
    // Arrange
    TrieKey singleHexResult = TrieKey.singleHex(1);

    // Act and Assert
    assertFalse(singleHexResult.isEmpty());
  }

  /**
   * Test {@link TrieKey#shift(int)}.
   *
   * <p>Method under test: {@link TrieKey#shift(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.shift(int)"})
  public void testShift() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act
    TrieKey actualShiftResult = emptyResult.shift(1);

    // Assert
    assertEquals(-1, actualShiftResult.getLength());
    assertFalse(actualShiftResult.isEmpty());
    assertTrue(actualShiftResult.isTerminal());
  }

  /**
   * Test {@link TrieKey#getCommonPrefix(TrieKey)}.
   *
   * <p>Method under test: {@link TrieKey#getCommonPrefix(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.getCommonPrefix(TrieKey)"})
  public void testGetCommonPrefix() throws UnsupportedEncodingException {
    // Arrange
    TrieKey trieKey = new TrieKey("AXAXAXAX".getBytes("UTF-8"), 1, true);

    // Act
    TrieKey actualCommonPrefix =
        trieKey.getCommonPrefix(new TrieKey("AXAXAXAX".getBytes("UTF-8"), 1, false));

    // Assert
    assertEquals(15, actualCommonPrefix.getLength());
    assertFalse(actualCommonPrefix.isEmpty());
    assertFalse(actualCommonPrefix.isTerminal());
    assertArrayEquals(
        new byte[] {17, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualCommonPrefix.toPacked());
  }

  /**
   * Test {@link TrieKey#getCommonPrefix(TrieKey)}.
   *
   * <ul>
   *   <li>Given empty {@code true}.
   *   <li>When empty {@code true}.
   *   <li>Then return Terminal.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#getCommonPrefix(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.getCommonPrefix(TrieKey)"})
  public void testGetCommonPrefix_givenEmptyTrue_whenEmptyTrue_thenReturnTerminal() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act
    TrieKey actualCommonPrefix = emptyResult.getCommonPrefix(TrieKey.empty(true));

    // Assert
    assertEquals(0, actualCommonPrefix.getLength());
    assertTrue(actualCommonPrefix.isEmpty());
    assertTrue(actualCommonPrefix.isTerminal());
    assertArrayEquals(new byte[] {}, actualCommonPrefix.toNormal());
    assertArrayEquals(new byte[] {' '}, actualCommonPrefix.toPacked());
  }

  /**
   * Test {@link TrieKey#getCommonPrefix(TrieKey)}.
   *
   * <ul>
   *   <li>Given singleHex one.
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#getCommonPrefix(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.getCommonPrefix(TrieKey)"})
  public void testGetCommonPrefix_givenSingleHexOne_whenA() {
    // Arrange
    TrieKey singleHexResult = TrieKey.singleHex(1);

    // Act
    TrieKey actualCommonPrefix =
        singleHexResult.getCommonPrefix(
            TrieKey.fromNormal(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}));

    // Assert
    assertEquals(0, actualCommonPrefix.getLength());
    assertTrue(actualCommonPrefix.isEmpty());
    assertArrayEquals(new byte[] {}, actualCommonPrefix.toNormal());
    assertArrayEquals(new byte[] {0}, actualCommonPrefix.toPacked());
  }

  /**
   * Test {@link TrieKey#getCommonPrefix(TrieKey)}.
   *
   * <ul>
   *   <li>Given singleHex one.
   *   <li>When empty {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#getCommonPrefix(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.getCommonPrefix(TrieKey)"})
  public void testGetCommonPrefix_givenSingleHexOne_whenEmptyTrue() {
    // Arrange
    TrieKey singleHexResult = TrieKey.singleHex(1);

    // Act
    TrieKey actualCommonPrefix = singleHexResult.getCommonPrefix(TrieKey.empty(true));

    // Assert
    assertEquals(0, actualCommonPrefix.getLength());
    assertTrue(actualCommonPrefix.isEmpty());
    assertArrayEquals(new byte[] {}, actualCommonPrefix.toNormal());
    assertArrayEquals(new byte[] {0}, actualCommonPrefix.toPacked());
  }

  /**
   * Test {@link TrieKey#getCommonPrefix(TrieKey)}.
   *
   * <ul>
   *   <li>Then return Length is fifteen.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#getCommonPrefix(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.getCommonPrefix(TrieKey)"})
  public void testGetCommonPrefix_thenReturnLengthIsFifteen() throws UnsupportedEncodingException {
    // Arrange
    TrieKey trieKey = new TrieKey("AXAXAXAX".getBytes("UTF-8"), 1, false);

    // Act
    TrieKey actualCommonPrefix =
        trieKey.getCommonPrefix(new TrieKey("AXAXAXAX".getBytes("UTF-8"), 1, false));

    // Assert
    assertEquals(15, actualCommonPrefix.getLength());
    assertFalse(actualCommonPrefix.isEmpty());
    assertFalse(actualCommonPrefix.isTerminal());
    assertArrayEquals(
        new byte[] {17, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualCommonPrefix.toPacked());
  }

  /**
   * Test {@link TrieKey#getCommonPrefix(TrieKey)}.
   *
   * <ul>
   *   <li>When singleHex one.
   *   <li>Then return toPacked is array of {@code byte} with zero.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#getCommonPrefix(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.getCommonPrefix(TrieKey)"})
  public void testGetCommonPrefix_whenSingleHexOne_thenReturnToPackedIsArrayOfByteWithZero() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act
    TrieKey actualCommonPrefix = emptyResult.getCommonPrefix(TrieKey.singleHex(1));

    // Assert
    assertEquals(0, actualCommonPrefix.getLength());
    assertTrue(actualCommonPrefix.isEmpty());
    assertArrayEquals(new byte[] {}, actualCommonPrefix.toNormal());
    assertArrayEquals(new byte[] {0}, actualCommonPrefix.toPacked());
  }

  /**
   * Test {@link TrieKey#matchAndShift(TrieKey)}.
   *
   * <ul>
   *   <li>Given empty {@code true}.
   *   <li>When singleHex one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#matchAndShift(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.matchAndShift(TrieKey)"})
  public void testMatchAndShift_givenEmptyTrue_whenSingleHexOne_thenReturnNull() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act and Assert
    assertNull(emptyResult.matchAndShift(TrieKey.singleHex(1)));
  }

  /**
   * Test {@link TrieKey#matchAndShift(TrieKey)}.
   *
   * <ul>
   *   <li>Given fromNormal array of {@code byte} with {@code A} and one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#matchAndShift(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.matchAndShift(TrieKey)"})
  public void testMatchAndShift_givenFromNormalArrayOfByteWithAAndOne_thenReturnNull() {
    // Arrange
    TrieKey fromNormalResult = TrieKey.fromNormal(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertNull(fromNormalResult.matchAndShift(TrieKey.singleHex(1)));
  }

  /**
   * Test {@link TrieKey#matchAndShift(TrieKey)}.
   *
   * <ul>
   *   <li>Given fromNormal array of {@code byte} with sixteen and one.
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#matchAndShift(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.matchAndShift(TrieKey)"})
  public void testMatchAndShift_givenFromNormalArrayOfByteWithSixteenAndOne_whenA() {
    // Arrange
    TrieKey fromNormalResult = TrieKey.fromNormal(new byte[] {16, 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertNull(
        fromNormalResult.matchAndShift(
            TrieKey.fromNormal(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1})));
  }

  /**
   * Test {@link TrieKey#matchAndShift(TrieKey)}.
   *
   * <ul>
   *   <li>Given singleHex fifteen.
   *   <li>When singleHex one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#matchAndShift(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.matchAndShift(TrieKey)"})
  public void testMatchAndShift_givenSingleHexFifteen_whenSingleHexOne_thenReturnNull() {
    // Arrange
    TrieKey singleHexResult = TrieKey.singleHex(15);

    // Act and Assert
    assertNull(singleHexResult.matchAndShift(TrieKey.singleHex(1)));
  }

  /**
   * Test {@link TrieKey#matchAndShift(TrieKey)}.
   *
   * <ul>
   *   <li>Given singleHex one.
   *   <li>Then return toPacked is array of {@code byte} with zero.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#matchAndShift(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.matchAndShift(TrieKey)"})
  public void testMatchAndShift_givenSingleHexOne_thenReturnToPackedIsArrayOfByteWithZero() {
    // Arrange
    TrieKey singleHexResult = TrieKey.singleHex(1);

    // Act
    TrieKey actualMatchAndShiftResult = singleHexResult.matchAndShift(TrieKey.singleHex(1));

    // Assert
    assertEquals(0, actualMatchAndShiftResult.getLength());
    assertFalse(actualMatchAndShiftResult.isTerminal());
    assertTrue(actualMatchAndShiftResult.isEmpty());
    assertArrayEquals(new byte[] {}, actualMatchAndShiftResult.toNormal());
    assertArrayEquals(new byte[] {0}, actualMatchAndShiftResult.toPacked());
  }

  /**
   * Test {@link TrieKey#matchAndShift(TrieKey)}.
   *
   * <ul>
   *   <li>Given singleHex one.
   *   <li>When empty {@code true}.
   *   <li>Then return Length is one.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#matchAndShift(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.matchAndShift(TrieKey)"})
  public void testMatchAndShift_givenSingleHexOne_whenEmptyTrue_thenReturnLengthIsOne() {
    // Arrange
    TrieKey singleHexResult = TrieKey.singleHex(1);

    // Act
    TrieKey actualMatchAndShiftResult = singleHexResult.matchAndShift(TrieKey.empty(true));

    // Assert
    assertEquals(1, actualMatchAndShiftResult.getLength());
    assertFalse(actualMatchAndShiftResult.isEmpty());
    assertFalse(actualMatchAndShiftResult.isTerminal());
    assertArrayEquals(new byte[] {17}, actualMatchAndShiftResult.toPacked());
  }

  /**
   * Test {@link TrieKey#matchAndShift(TrieKey)}.
   *
   * <ul>
   *   <li>Then return Length is fifteen.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#matchAndShift(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.matchAndShift(TrieKey)"})
  public void testMatchAndShift_thenReturnLengthIsFifteen() {
    // Arrange
    TrieKey fromNormalResult = TrieKey.fromNormal(new byte[] {16, 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    TrieKey actualMatchAndShiftResult = fromNormalResult.matchAndShift(TrieKey.singleHex(1));

    // Assert
    assertEquals(15, actualMatchAndShiftResult.getLength());
    assertFalse(actualMatchAndShiftResult.isEmpty());
    assertTrue(actualMatchAndShiftResult.isTerminal());
    assertArrayEquals(
        new byte[] {'0', 1, 'A', 1, 'A', 1, 'A', 1}, actualMatchAndShiftResult.toPacked());
  }

  /**
   * Test {@link TrieKey#matchAndShift(TrieKey)}.
   *
   * <ul>
   *   <li>Then return toPacked is array of {@code byte} with space.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#matchAndShift(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.matchAndShift(TrieKey)"})
  public void testMatchAndShift_thenReturnToPackedIsArrayOfByteWithSpace() {
    // Arrange
    TrieKey fromNormalResult = TrieKey.fromNormal(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    TrieKey actualMatchAndShiftResult =
        fromNormalResult.matchAndShift(
            TrieKey.fromNormal(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}));

    // Assert
    assertEquals(0, actualMatchAndShiftResult.getLength());
    assertTrue(actualMatchAndShiftResult.isEmpty());
    assertTrue(actualMatchAndShiftResult.isTerminal());
    assertArrayEquals(new byte[] {}, actualMatchAndShiftResult.toNormal());
    assertArrayEquals(new byte[] {' '}, actualMatchAndShiftResult.toPacked());
  }

  /**
   * Test {@link TrieKey#matchAndShift(TrieKey)}.
   *
   * <ul>
   *   <li>When empty {@code true}.
   *   <li>Then return toPacked is array of {@code byte} with space.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#matchAndShift(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.matchAndShift(TrieKey)"})
  public void testMatchAndShift_whenEmptyTrue_thenReturnToPackedIsArrayOfByteWithSpace() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act
    TrieKey actualMatchAndShiftResult = emptyResult.matchAndShift(TrieKey.empty(true));

    // Assert
    assertEquals(0, actualMatchAndShiftResult.getLength());
    assertTrue(actualMatchAndShiftResult.isEmpty());
    assertTrue(actualMatchAndShiftResult.isTerminal());
    assertArrayEquals(new byte[] {}, actualMatchAndShiftResult.toNormal());
    assertArrayEquals(new byte[] {' '}, actualMatchAndShiftResult.toPacked());
  }

  /**
   * Test {@link TrieKey#getLength()}.
   *
   * <p>Method under test: {@link TrieKey#getLength()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TrieKey.getLength()"})
  public void testGetLength() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act and Assert
    assertEquals(0, emptyResult.getLength());
  }

  /**
   * Test {@link TrieKey#getHex(int)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#getHex(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TrieKey.getHex(int)"})
  public void testGetHex_givenA_whenOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, TrieKey.fromNormal(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}).getHex(1));
  }

  /**
   * Test {@link TrieKey#getHex(int)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#getHex(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TrieKey.getHex(int)"})
  public void testGetHex_givenA_whenTwo_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, TrieKey.fromNormal(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}).getHex(2));
  }

  /**
   * Test {@link TrieKey#concat(TrieKey)}.
   *
   * <ul>
   *   <li>Given empty {@code true}.
   *   <li>When empty {@code true}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#concat(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.concat(TrieKey)"})
  public void testConcat_givenEmptyTrue_whenEmptyTrue_thenThrowRuntimeException() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> emptyResult.concat(TrieKey.empty(true)));
  }

  /**
   * Test {@link TrieKey#concat(TrieKey)}.
   *
   * <ul>
   *   <li>Given empty {@code true}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#concat(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.concat(TrieKey)"})
  public void testConcat_givenEmptyTrue_whenNull_thenThrowRuntimeException() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> emptyResult.concat(null));
  }

  /**
   * Test {@link TrieKey#concat(TrieKey)}.
   *
   * <ul>
   *   <li>Given empty {@code true}.
   *   <li>When singleHex three.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#concat(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.concat(TrieKey)"})
  public void testConcat_givenEmptyTrue_whenSingleHexThree_thenThrowRuntimeException() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> emptyResult.concat(TrieKey.singleHex(3)));
  }

  /**
   * Test {@link TrieKey#concat(TrieKey)}.
   *
   * <ul>
   *   <li>Given singleHex three.
   *   <li>When singleHex three.
   *   <li>Then return Length is two.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#concat(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.concat(TrieKey)"})
  public void testConcat_givenSingleHexThree_whenSingleHexThree_thenReturnLengthIsTwo() {
    // Arrange
    TrieKey singleHexResult = TrieKey.singleHex(3);

    // Act
    TrieKey actualConcatResult = singleHexResult.concat(TrieKey.singleHex(3));

    // Assert
    assertEquals(2, actualConcatResult.getLength());
    assertFalse(actualConcatResult.isTerminal());
    assertArrayEquals(new byte[] {'3'}, actualConcatResult.toNormal());
    assertArrayEquals(new byte[] {0, '3'}, actualConcatResult.toPacked());
  }

  /**
   * Test {@link TrieKey#concat(TrieKey)}.
   *
   * <ul>
   *   <li>Then return Length is fifteen.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#concat(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.concat(TrieKey)"})
  public void testConcat_thenReturnLengthIsFifteen() throws UnsupportedEncodingException {
    // Arrange
    TrieKey trieKey = new TrieKey("AXAXAXAX".getBytes("UTF-8"), 1, false);

    // Act
    TrieKey actualConcatResult = trieKey.concat(TrieKey.empty(true));

    // Assert
    assertEquals(15, actualConcatResult.getLength());
    assertFalse(actualConcatResult.isEmpty());
    assertTrue(actualConcatResult.isTerminal());
    byte[] expectedToPackedResult = "1XAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToPackedResult, actualConcatResult.toPacked());
  }

  /**
   * Test {@link TrieKey#equals(Object)}, and {@link TrieKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TrieKey#equals(Object)}
   *   <li>{@link TrieKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieKey.equals(Object)", "int TrieKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);
    TrieKey emptyResult2 = TrieKey.empty(true);

    // Act and Assert
    assertEquals(emptyResult, emptyResult2);
    assertNotEquals(emptyResult.hashCode(), emptyResult2.hashCode());
  }

  /**
   * Test {@link TrieKey#equals(Object)}, and {@link TrieKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TrieKey#equals(Object)}
   *   <li>{@link TrieKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieKey.equals(Object)", "int TrieKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TrieKey singleHexResult = TrieKey.singleHex(1);
    TrieKey singleHexResult2 = TrieKey.singleHex(1);

    // Act and Assert
    assertEquals(singleHexResult, singleHexResult2);
    assertNotEquals(singleHexResult.hashCode(), singleHexResult2.hashCode());
  }

  /**
   * Test {@link TrieKey#equals(Object)}, and {@link TrieKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TrieKey#equals(Object)}
   *   <li>{@link TrieKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieKey.equals(Object)", "int TrieKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TrieKey fromNormalResult = TrieKey.fromNormal(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    TrieKey fromNormalResult2 = TrieKey.fromNormal(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertEquals(fromNormalResult, fromNormalResult2);
    assertNotEquals(fromNormalResult.hashCode(), fromNormalResult2.hashCode());
  }

  /**
   * Test {@link TrieKey#equals(Object)}, and {@link TrieKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TrieKey#equals(Object)}
   *   <li>{@link TrieKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieKey.equals(Object)", "int TrieKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act and Assert
    assertEquals(emptyResult, emptyResult);
    int expectedHashCodeResult = emptyResult.hashCode();
    assertEquals(expectedHashCodeResult, emptyResult.hashCode());
  }

  /**
   * Test {@link TrieKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieKey.equals(Object)", "int TrieKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TrieKey singleHexResult = TrieKey.singleHex(1);

    // Act and Assert
    assertNotEquals(singleHexResult, TrieKey.empty(true));
  }

  /**
   * Test {@link TrieKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieKey.equals(Object)", "int TrieKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(false);

    // Act and Assert
    assertNotEquals(emptyResult, TrieKey.empty(true));
  }

  /**
   * Test {@link TrieKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieKey.equals(Object)", "int TrieKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TrieKey singleHexResult = TrieKey.singleHex(15);

    // Act and Assert
    assertNotEquals(singleHexResult, TrieKey.singleHex(1));
  }

  /**
   * Test {@link TrieKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieKey.equals(Object)", "int TrieKey.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act and Assert
    assertNotEquals(emptyResult, null);
  }

  /**
   * Test {@link TrieKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieKey.equals(Object)", "int TrieKey.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act and Assert
    assertNotEquals(emptyResult, "Different type to TrieKey");
  }

  /**
   * Test {@link TrieKey#toString()}.
   *
   * <ul>
   *   <li>Given empty {@code true}.
   *   <li>Then return {@code T}.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String TrieKey.toString()"})
  public void testToString_givenEmptyTrue_thenReturnT() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act and Assert
    assertEquals("T", emptyResult.toString());
  }

  /**
   * Test {@link TrieKey#toString()}.
   *
   * <ul>
   *   <li>Then return {@code 158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String TrieKey.toString()"})
  public void testToString_thenReturn158415841584158() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("158415841584158", new TrieKey("AXAXAXAX".getBytes("UTF-8"), 1, false).toString());
  }

  /**
   * Test {@link TrieKey#toString()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TrieKey#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String TrieKey.toString()"})
  public void testToString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new TrieKey(null, 0, false).toString());
  }
}
