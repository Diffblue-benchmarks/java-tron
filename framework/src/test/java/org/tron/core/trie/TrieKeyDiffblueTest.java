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
   * <p>
   * Methods under test:
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
    assertTrue((new TrieKey("AXAXAXAX".getBytes("UTF-8"), 1, true)).isTerminal());
  }

  /**
   * Test {@link TrieKey#fromNormal(byte[])}.
   * <p>
   * Method under test: {@link TrieKey#fromNormal(byte[])}
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
   * <ul>
   *   <li>Then return toPacked is array of {@code byte} with twenty-four and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#fromPacked(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.fromPacked(byte[])"})
  public void testFromPacked_thenReturnToPackedIsArrayOfByteWithTwentyFourAndX() throws UnsupportedEncodingException {
    // Arrange and Act
    TrieKey actualFromPackedResult = TrieKey.fromPacked("XXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(15, actualFromPackedResult.getLength());
    assertFalse(actualFromPackedResult.isEmpty());
    assertFalse(actualFromPackedResult.isTerminal());
    assertArrayEquals(new byte[]{24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualFromPackedResult.toPacked());
  }

  /**
   * Test {@link TrieKey#fromPacked(byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return Terminal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#fromPacked(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.fromPacked(byte[])"})
  public void testFromPacked_whenA_thenReturnTerminal() throws UnsupportedEncodingException {
    // Arrange and Act
    TrieKey actualFromPackedResult = TrieKey.fromPacked(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals(15, actualFromPackedResult.getLength());
    assertFalse(actualFromPackedResult.isEmpty());
    assertTrue(actualFromPackedResult.isTerminal());
    byte[] expectedToPackedResult = "?XAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToPackedResult, actualFromPackedResult.toPacked());
  }

  /**
   * Test {@link TrieKey#fromPacked(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Length is fourteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#fromPacked(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.fromPacked(byte[])"})
  public void testFromPacked_whenAxaxaxaxBytesIsUtf8_thenReturnLengthIsFourteen() throws UnsupportedEncodingException {
    // Arrange and Act
    TrieKey actualFromPackedResult = TrieKey.fromPacked("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(14, actualFromPackedResult.getLength());
    assertFalse(actualFromPackedResult.isTerminal());
    byte[] expectedToNormalResult = "XAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToNormalResult, actualFromPackedResult.toNormal());
    assertArrayEquals(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualFromPackedResult.toPacked());
  }

  /**
   * Test {@link TrieKey#empty(boolean)}.
   * <p>
   * Method under test: {@link TrieKey#empty(boolean)}
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
    assertArrayEquals(new byte[]{}, actualEmptyResult.toNormal());
    assertArrayEquals(new byte[]{' '}, actualEmptyResult.toPacked());
  }

  /**
   * Test {@link TrieKey#singleHex(int)}.
   * <p>
   * Method under test: {@link TrieKey#singleHex(int)}
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
    assertArrayEquals(new byte[]{17}, actualSingleHexResult.toPacked());
  }

  /**
   * Test {@link TrieKey#toPacked()}.
   * <ul>
   *   <li>Given empty {@code false}.</li>
   *   <li>Then return array of {@code byte} with zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#toPacked()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TrieKey.toPacked()"})
  public void testToPacked_givenEmptyFalse_thenReturnArrayOfByteWithZero() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0}, TrieKey.empty(false).toPacked());
  }

  /**
   * Test {@link TrieKey#toPacked()}.
   * <ul>
   *   <li>Given empty {@code true}.</li>
   *   <li>Then return array of {@code byte} with space.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#toPacked()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TrieKey.toPacked()"})
  public void testToPacked_givenEmptyTrue_thenReturnArrayOfByteWithSpace() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{' '}, TrieKey.empty(true).toPacked());
  }

  /**
   * Test {@link TrieKey#toPacked()}.
   * <ul>
   *   <li>Given singleHex one.</li>
   *   <li>Then return array of {@code byte} with seventeen.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#toPacked()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TrieKey.toPacked()"})
  public void testToPacked_givenSingleHexOne_thenReturnArrayOfByteWithSeventeen() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{17}, TrieKey.singleHex(1).toPacked());
  }

  /**
   * Test {@link TrieKey#toNormal()}.
   * <ul>
   *   <li>Given empty {@code true}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#toNormal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TrieKey.toNormal()"})
  public void testToNormal_givenEmptyTrue_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, TrieKey.empty(true).toNormal());
  }

  /**
   * Test {@link TrieKey#toNormal()}.
   * <ul>
   *   <li>Given singleHex one.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#toNormal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TrieKey.toNormal()"})
  public void testToNormal_givenSingleHexOne_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> TrieKey.singleHex(1).toNormal());
  }

  /**
   * Test {@link TrieKey#isEmpty()}.
   * <ul>
   *   <li>Given empty {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#isEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieKey.isEmpty()"})
  public void testIsEmpty_givenEmptyTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(TrieKey.empty(true).isEmpty());
  }

  /**
   * Test {@link TrieKey#isEmpty()}.
   * <ul>
   *   <li>Given singleHex one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#isEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieKey.isEmpty()"})
  public void testIsEmpty_givenSingleHexOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(TrieKey.singleHex(1).isEmpty());
  }

  /**
   * Test {@link TrieKey#shift(int)}.
   * <p>
   * Method under test: {@link TrieKey#shift(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.shift(int)"})
  public void testShift() {
    // Arrange and Act
    TrieKey actualShiftResult = TrieKey.empty(true).shift(1);

    // Assert
    assertEquals(-1, actualShiftResult.getLength());
    assertFalse(actualShiftResult.isEmpty());
    assertTrue(actualShiftResult.isTerminal());
  }

  /**
   * Test {@link TrieKey#getCommonPrefix(TrieKey)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When {@code A}.</li>
   *   <li>Then return Length is {@link Short#SIZE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#getCommonPrefix(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.getCommonPrefix(TrieKey)"})
  public void testGetCommonPrefix_givenA_whenA_thenReturnLengthIsSize() {
    // Arrange
    TrieKey fromNormalResult = TrieKey.fromNormal(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    TrieKey actualCommonPrefix = fromNormalResult
        .getCommonPrefix(TrieKey.fromNormal(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}));

    // Assert
    assertFalse(actualCommonPrefix.isEmpty());
    assertTrue(actualCommonPrefix.isTerminal());
    assertEquals(Short.SIZE, actualCommonPrefix.getLength());
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, actualCommonPrefix.toNormal());
    assertArrayEquals(new byte[]{' ', 'A', 1, 'A', 1, 'A', 1, 'A', 1}, actualCommonPrefix.toPacked());
  }

  /**
   * Test {@link TrieKey#getCommonPrefix(TrieKey)}.
   * <ul>
   *   <li>Given empty {@code false}.</li>
   *   <li>When empty {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#getCommonPrefix(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.getCommonPrefix(TrieKey)"})
  public void testGetCommonPrefix_givenEmptyFalse_whenEmptyTrue() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(false);

    // Act
    TrieKey actualCommonPrefix = emptyResult.getCommonPrefix(TrieKey.empty(true));

    // Assert
    assertEquals(0, actualCommonPrefix.getLength());
    assertFalse(actualCommonPrefix.isTerminal());
    assertTrue(actualCommonPrefix.isEmpty());
    assertArrayEquals(new byte[]{}, actualCommonPrefix.toNormal());
    assertArrayEquals(new byte[]{0}, actualCommonPrefix.toPacked());
  }

  /**
   * Test {@link TrieKey#getCommonPrefix(TrieKey)}.
   * <ul>
   *   <li>Given empty {@code true}.</li>
   *   <li>When empty {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#getCommonPrefix(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.getCommonPrefix(TrieKey)"})
  public void testGetCommonPrefix_givenEmptyTrue_whenEmptyFalse() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act
    TrieKey actualCommonPrefix = emptyResult.getCommonPrefix(TrieKey.empty(false));

    // Assert
    assertEquals(0, actualCommonPrefix.getLength());
    assertFalse(actualCommonPrefix.isTerminal());
    assertTrue(actualCommonPrefix.isEmpty());
    assertArrayEquals(new byte[]{}, actualCommonPrefix.toNormal());
    assertArrayEquals(new byte[]{0}, actualCommonPrefix.toPacked());
  }

  /**
   * Test {@link TrieKey#getCommonPrefix(TrieKey)}.
   * <ul>
   *   <li>Given empty {@code true}.</li>
   *   <li>When singleHex one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#getCommonPrefix(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.getCommonPrefix(TrieKey)"})
  public void testGetCommonPrefix_givenEmptyTrue_whenSingleHexOne() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act
    TrieKey actualCommonPrefix = emptyResult.getCommonPrefix(TrieKey.singleHex(1));

    // Assert
    assertEquals(0, actualCommonPrefix.getLength());
    assertFalse(actualCommonPrefix.isTerminal());
    assertTrue(actualCommonPrefix.isEmpty());
    assertArrayEquals(new byte[]{}, actualCommonPrefix.toNormal());
    assertArrayEquals(new byte[]{0}, actualCommonPrefix.toPacked());
  }

  /**
   * Test {@link TrieKey#getCommonPrefix(TrieKey)}.
   * <ul>
   *   <li>Given singleHex one.</li>
   *   <li>When {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#getCommonPrefix(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.getCommonPrefix(TrieKey)"})
  public void testGetCommonPrefix_givenSingleHexOne_whenA() {
    // Arrange
    TrieKey singleHexResult = TrieKey.singleHex(1);

    // Act
    TrieKey actualCommonPrefix = singleHexResult
        .getCommonPrefix(TrieKey.fromNormal(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}));

    // Assert
    assertEquals(0, actualCommonPrefix.getLength());
    assertFalse(actualCommonPrefix.isTerminal());
    assertTrue(actualCommonPrefix.isEmpty());
    assertArrayEquals(new byte[]{}, actualCommonPrefix.toNormal());
    assertArrayEquals(new byte[]{0}, actualCommonPrefix.toPacked());
  }

  /**
   * Test {@link TrieKey#getCommonPrefix(TrieKey)}.
   * <ul>
   *   <li>Given singleHex one.</li>
   *   <li>When empty {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#getCommonPrefix(TrieKey)}
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
    assertFalse(actualCommonPrefix.isTerminal());
    assertTrue(actualCommonPrefix.isEmpty());
    assertArrayEquals(new byte[]{}, actualCommonPrefix.toNormal());
    assertArrayEquals(new byte[]{0}, actualCommonPrefix.toPacked());
  }

  /**
   * Test {@link TrieKey#getCommonPrefix(TrieKey)}.
   * <ul>
   *   <li>Given singleHex one.</li>
   *   <li>When singleHex one.</li>
   *   <li>Then return Length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#getCommonPrefix(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.getCommonPrefix(TrieKey)"})
  public void testGetCommonPrefix_givenSingleHexOne_whenSingleHexOne_thenReturnLengthIsOne() {
    // Arrange
    TrieKey singleHexResult = TrieKey.singleHex(1);

    // Act
    TrieKey actualCommonPrefix = singleHexResult.getCommonPrefix(TrieKey.singleHex(1));

    // Assert
    assertEquals(1, actualCommonPrefix.getLength());
    assertFalse(actualCommonPrefix.isEmpty());
    assertFalse(actualCommonPrefix.isTerminal());
    assertArrayEquals(new byte[]{17}, actualCommonPrefix.toPacked());
  }

  /**
   * Test {@link TrieKey#getCommonPrefix(TrieKey)}.
   * <ul>
   *   <li>When empty {@code true}.</li>
   *   <li>Then return toPacked is array of {@code byte} with space.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#getCommonPrefix(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.getCommonPrefix(TrieKey)"})
  public void testGetCommonPrefix_whenEmptyTrue_thenReturnToPackedIsArrayOfByteWithSpace() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act
    TrieKey actualCommonPrefix = emptyResult.getCommonPrefix(TrieKey.empty(true));

    // Assert
    assertEquals(0, actualCommonPrefix.getLength());
    assertTrue(actualCommonPrefix.isEmpty());
    assertTrue(actualCommonPrefix.isTerminal());
    assertArrayEquals(new byte[]{}, actualCommonPrefix.toNormal());
    assertArrayEquals(new byte[]{' '}, actualCommonPrefix.toPacked());
  }

  /**
   * Test {@link TrieKey#matchAndShift(TrieKey)}.
   * <ul>
   *   <li>Given empty {@code true}.</li>
   *   <li>When singleHex one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#matchAndShift(TrieKey)}
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
   * <ul>
   *   <li>Given fromNormal array of {@code byte} with {@code A} and one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#matchAndShift(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.matchAndShift(TrieKey)"})
  public void testMatchAndShift_givenFromNormalArrayOfByteWithAAndOne_thenReturnNull() {
    // Arrange
    TrieKey fromNormalResult = TrieKey.fromNormal(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertNull(fromNormalResult.matchAndShift(TrieKey.singleHex(1)));
  }

  /**
   * Test {@link TrieKey#matchAndShift(TrieKey)}.
   * <ul>
   *   <li>Given fromNormal array of {@code byte} with sixteen and one.</li>
   *   <li>When {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#matchAndShift(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.matchAndShift(TrieKey)"})
  public void testMatchAndShift_givenFromNormalArrayOfByteWithSixteenAndOne_whenA() {
    // Arrange
    TrieKey fromNormalResult = TrieKey.fromNormal(new byte[]{16, 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertNull(fromNormalResult.matchAndShift(TrieKey.fromNormal(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1})));
  }

  /**
   * Test {@link TrieKey#matchAndShift(TrieKey)}.
   * <ul>
   *   <li>Given singleHex fifteen.</li>
   *   <li>When singleHex one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#matchAndShift(TrieKey)}
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
   * <ul>
   *   <li>Given singleHex one.</li>
   *   <li>Then return toPacked is array of {@code byte} with zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#matchAndShift(TrieKey)}
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
    assertArrayEquals(new byte[]{}, actualMatchAndShiftResult.toNormal());
    assertArrayEquals(new byte[]{0}, actualMatchAndShiftResult.toPacked());
  }

  /**
   * Test {@link TrieKey#matchAndShift(TrieKey)}.
   * <ul>
   *   <li>Given singleHex one.</li>
   *   <li>When empty {@code true}.</li>
   *   <li>Then return Length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#matchAndShift(TrieKey)}
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
    assertArrayEquals(new byte[]{17}, actualMatchAndShiftResult.toPacked());
  }

  /**
   * Test {@link TrieKey#matchAndShift(TrieKey)}.
   * <ul>
   *   <li>Then return Length is fifteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#matchAndShift(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.matchAndShift(TrieKey)"})
  public void testMatchAndShift_thenReturnLengthIsFifteen() {
    // Arrange
    TrieKey fromNormalResult = TrieKey.fromNormal(new byte[]{16, 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    TrieKey actualMatchAndShiftResult = fromNormalResult.matchAndShift(TrieKey.singleHex(1));

    // Assert
    assertEquals(15, actualMatchAndShiftResult.getLength());
    assertFalse(actualMatchAndShiftResult.isEmpty());
    assertTrue(actualMatchAndShiftResult.isTerminal());
    assertArrayEquals(new byte[]{'0', 1, 'A', 1, 'A', 1, 'A', 1}, actualMatchAndShiftResult.toPacked());
  }

  /**
   * Test {@link TrieKey#matchAndShift(TrieKey)}.
   * <ul>
   *   <li>Then return toPacked is array of {@code byte} with space.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#matchAndShift(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.matchAndShift(TrieKey)"})
  public void testMatchAndShift_thenReturnToPackedIsArrayOfByteWithSpace() {
    // Arrange
    TrieKey fromNormalResult = TrieKey.fromNormal(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    TrieKey actualMatchAndShiftResult = fromNormalResult
        .matchAndShift(TrieKey.fromNormal(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}));

    // Assert
    assertEquals(0, actualMatchAndShiftResult.getLength());
    assertTrue(actualMatchAndShiftResult.isEmpty());
    assertTrue(actualMatchAndShiftResult.isTerminal());
    assertArrayEquals(new byte[]{}, actualMatchAndShiftResult.toNormal());
    assertArrayEquals(new byte[]{' '}, actualMatchAndShiftResult.toPacked());
  }

  /**
   * Test {@link TrieKey#matchAndShift(TrieKey)}.
   * <ul>
   *   <li>When empty {@code true}.</li>
   *   <li>Then return toPacked is array of {@code byte} with space.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#matchAndShift(TrieKey)}
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
    assertArrayEquals(new byte[]{}, actualMatchAndShiftResult.toNormal());
    assertArrayEquals(new byte[]{' '}, actualMatchAndShiftResult.toPacked());
  }

  /**
   * Test {@link TrieKey#getLength()}.
   * <p>
   * Method under test: {@link TrieKey#getLength()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TrieKey.getLength()"})
  public void testGetLength() {
    // Arrange, Act and Assert
    assertEquals(0, TrieKey.empty(true).getLength());
  }

  /**
   * Test {@link TrieKey#getHex(int)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#getHex(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TrieKey.getHex(int)"})
  public void testGetHex_givenA_whenOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, TrieKey.fromNormal(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}).getHex(1));
  }

  /**
   * Test {@link TrieKey#getHex(int)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When two.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#getHex(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TrieKey.getHex(int)"})
  public void testGetHex_givenA_whenTwo_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, TrieKey.fromNormal(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}).getHex(2));
  }

  /**
   * Test {@link TrieKey#concat(TrieKey)}.
   * <ul>
   *   <li>Given empty {@code false}.</li>
   *   <li>When {@code A}.</li>
   *   <li>Then return Length is {@link Short#SIZE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#concat(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.concat(TrieKey)"})
  public void testConcat_givenEmptyFalse_whenA_thenReturnLengthIsSize() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(false);

    // Act
    TrieKey actualConcatResult = emptyResult.concat(TrieKey.fromNormal(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}));

    // Assert
    assertTrue(actualConcatResult.isTerminal());
    assertEquals(Short.SIZE, actualConcatResult.getLength());
    assertArrayEquals(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, actualConcatResult.toNormal());
    assertArrayEquals(new byte[]{' ', 'A', 3, 'A', 3, 'A', 3, 'A', 3}, actualConcatResult.toPacked());
  }

  /**
   * Test {@link TrieKey#concat(TrieKey)}.
   * <ul>
   *   <li>Given empty {@code false}.</li>
   *   <li>When empty {@code true}.</li>
   *   <li>Then return Length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#concat(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.concat(TrieKey)"})
  public void testConcat_givenEmptyFalse_whenEmptyTrue_thenReturnLengthIsZero() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(false);

    // Act
    TrieKey actualConcatResult = emptyResult.concat(TrieKey.empty(true));

    // Assert
    assertEquals(0, actualConcatResult.getLength());
    assertTrue(actualConcatResult.isEmpty());
    assertArrayEquals(new byte[]{}, actualConcatResult.toNormal());
    assertArrayEquals(new byte[]{' '}, actualConcatResult.toPacked());
  }

  /**
   * Test {@link TrieKey#concat(TrieKey)}.
   * <ul>
   *   <li>Given empty {@code false}.</li>
   *   <li>When singleHex three.</li>
   *   <li>Then return not Terminal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#concat(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.concat(TrieKey)"})
  public void testConcat_givenEmptyFalse_whenSingleHexThree_thenReturnNotTerminal() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(false);

    // Act
    TrieKey actualConcatResult = emptyResult.concat(TrieKey.singleHex(3));

    // Assert
    assertEquals(1, actualConcatResult.getLength());
    assertFalse(actualConcatResult.isEmpty());
    assertFalse(actualConcatResult.isTerminal());
    assertArrayEquals(new byte[]{19}, actualConcatResult.toPacked());
  }

  /**
   * Test {@link TrieKey#concat(TrieKey)}.
   * <ul>
   *   <li>Given empty {@code true}.</li>
   *   <li>When empty {@code false}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#concat(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.concat(TrieKey)"})
  public void testConcat_givenEmptyTrue_whenEmptyFalse_thenThrowRuntimeException() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> emptyResult.concat(TrieKey.empty(false)));
  }

  /**
   * Test {@link TrieKey#concat(TrieKey)}.
   * <ul>
   *   <li>Given empty {@code true}.</li>
   *   <li>When empty {@code true}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#concat(TrieKey)}
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
   * <ul>
   *   <li>Given empty {@code true}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#concat(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.concat(TrieKey)"})
  public void testConcat_givenEmptyTrue_whenNull_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> TrieKey.empty(true).concat(null));
  }

  /**
   * Test {@link TrieKey#concat(TrieKey)}.
   * <ul>
   *   <li>Given singleHex three.</li>
   *   <li>Then return toPacked is array of {@code byte} with {@code 3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#concat(TrieKey)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey TrieKey.concat(TrieKey)"})
  public void testConcat_givenSingleHexThree_thenReturnToPackedIsArrayOfByteWith3() {
    // Arrange
    TrieKey singleHexResult = TrieKey.singleHex(3);

    // Act
    TrieKey actualConcatResult = singleHexResult.concat(TrieKey.empty(true));

    // Assert
    assertEquals(1, actualConcatResult.getLength());
    assertFalse(actualConcatResult.isEmpty());
    assertTrue(actualConcatResult.isTerminal());
    assertArrayEquals(new byte[]{'3'}, actualConcatResult.toPacked());
  }

  /**
   * Test {@link TrieKey#equals(Object)}, and {@link TrieKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
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
    int notExpectedHashCodeResult = emptyResult.hashCode();
    assertNotEquals(notExpectedHashCodeResult, emptyResult2.hashCode());
  }

  /**
   * Test {@link TrieKey#equals(Object)}, and {@link TrieKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
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
    int notExpectedHashCodeResult = singleHexResult.hashCode();
    assertNotEquals(notExpectedHashCodeResult, singleHexResult2.hashCode());
  }

  /**
   * Test {@link TrieKey#equals(Object)}, and {@link TrieKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
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
    TrieKey fromNormalResult = TrieKey.fromNormal(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    TrieKey fromNormalResult2 = TrieKey.fromNormal(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertEquals(fromNormalResult, fromNormalResult2);
    int notExpectedHashCodeResult = fromNormalResult.hashCode();
    assertNotEquals(notExpectedHashCodeResult, fromNormalResult2.hashCode());
  }

  /**
   * Test {@link TrieKey#equals(Object)}, and {@link TrieKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieKey.equals(Object)", "int TrieKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(false);

    // Act and Assert
    assertNotEquals(emptyResult, TrieKey.empty(true));
  }

  /**
   * Test {@link TrieKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieKey.equals(Object)", "int TrieKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TrieKey singleHexResult = TrieKey.singleHex(1);

    // Act and Assert
    assertNotEquals(singleHexResult, TrieKey.empty(true));
  }

  /**
   * Test {@link TrieKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#equals(Object)}
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieKey.equals(Object)", "int TrieKey.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TrieKey.empty(true), null);
  }

  /**
   * Test {@link TrieKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieKey.equals(Object)", "int TrieKey.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TrieKey.empty(true), "Different type to TrieKey");
  }

  /**
   * Test {@link TrieKey#toString()}.
   * <ul>
   *   <li>Given empty {@code false}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String TrieKey.toString()"})
  public void testToString_givenEmptyFalse_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", TrieKey.empty(false).toString());
  }

  /**
   * Test {@link TrieKey#toString()}.
   * <ul>
   *   <li>Given empty {@code true}.</li>
   *   <li>Then return {@code T}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieKey#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String TrieKey.toString()"})
  public void testToString_givenEmptyTrue_thenReturnT() {
    // Arrange, Act and Assert
    assertEquals("T", TrieKey.empty(true).toString());
  }
}
