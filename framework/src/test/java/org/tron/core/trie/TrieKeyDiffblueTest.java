package org.tron.core.trie;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class TrieKeyDiffblueTest {
  /**
   * Method under test: {@link TrieKey#fromNormal(byte[])}
   */
  @Test
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
   * Method under test: {@link TrieKey#fromPacked(byte[])}
   */
  @Test
  public void testFromPacked() throws UnsupportedEncodingException {
    // Arrange and Act
    TrieKey actualFromPackedResult = TrieKey.fromPacked("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(14, actualFromPackedResult.getLength());
    assertFalse(actualFromPackedResult.isEmpty());
    assertFalse(actualFromPackedResult.isTerminal());
    byte[] expectedToNormalResult = "XAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToNormalResult, actualFromPackedResult.toNormal());
    assertArrayEquals(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualFromPackedResult.toPacked());
  }

  /**
   * Method under test: {@link TrieKey#fromPacked(byte[])}
   */
  @Test
  public void testFromPacked2() throws UnsupportedEncodingException {
    // Arrange and Act
    TrieKey actualFromPackedResult = TrieKey.fromPacked("XXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(15, actualFromPackedResult.getLength());
    assertFalse(actualFromPackedResult.isEmpty());
    assertFalse(actualFromPackedResult.isTerminal());
    assertArrayEquals(new byte[]{24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualFromPackedResult.toPacked());
  }

  /**
   * Method under test: {@link TrieKey#fromPacked(byte[])}
   */
  @Test
  public void testFromPacked3() throws UnsupportedEncodingException {
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
   * Method under test: {@link TrieKey#empty(boolean)}
   */
  @Test
  public void testEmpty() {
    // Arrange and Act
    TrieKey actualEmptyResult = TrieKey.empty(true);

    // Assert
    assertEquals(0, actualEmptyResult.getLength());
    assertEquals(0, actualEmptyResult.toNormal().length);
    assertTrue(actualEmptyResult.isEmpty());
    assertTrue(actualEmptyResult.isTerminal());
    assertArrayEquals(new byte[]{' '}, actualEmptyResult.toPacked());
  }

  /**
   * Method under test: {@link TrieKey#singleHex(int)}
   */
  @Test
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
   * Method under test: {@link TrieKey#toPacked()}
   */
  @Test
  public void testToPacked() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{' '}, TrieKey.empty(true).toPacked());
    assertArrayEquals(new byte[]{0}, TrieKey.empty(false).toPacked());
    assertArrayEquals(new byte[]{17}, TrieKey.singleHex(1).toPacked());
  }

  /**
   * Method under test: {@link TrieKey#toNormal()}
   */
  @Test
  public void testToNormal() {
    // Arrange, Act and Assert
    assertEquals(0, TrieKey.empty(true).toNormal().length);
    assertThrows(RuntimeException.class, () -> TrieKey.singleHex(1).toNormal());
  }

  /**
   * Method under test: {@link TrieKey#isEmpty()}
   */
  @Test
  public void testIsEmpty() {
    // Arrange, Act and Assert
    assertTrue(TrieKey.empty(true).isEmpty());
    assertFalse(TrieKey.singleHex(1).isEmpty());
  }

  /**
   * Method under test: {@link TrieKey#shift(int)}
   */
  @Test
  public void testShift() {
    // Arrange and Act
    TrieKey actualShiftResult = TrieKey.empty(true).shift(1);

    // Assert
    assertEquals(-1, actualShiftResult.getLength());
    assertFalse(actualShiftResult.isEmpty());
    assertTrue(actualShiftResult.isTerminal());
  }

  /**
   * Method under test: {@link TrieKey#getCommonPrefix(TrieKey)}
   */
  @Test
  public void testGetCommonPrefix() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act
    TrieKey actualCommonPrefix = emptyResult.getCommonPrefix(TrieKey.empty(true));

    // Assert
    assertEquals(0, actualCommonPrefix.getLength());
    assertEquals(0, actualCommonPrefix.toNormal().length);
    assertTrue(actualCommonPrefix.isEmpty());
    assertTrue(actualCommonPrefix.isTerminal());
    assertArrayEquals(new byte[]{' '}, actualCommonPrefix.toPacked());
  }

  /**
   * Method under test: {@link TrieKey#getCommonPrefix(TrieKey)}
   */
  @Test
  public void testGetCommonPrefix2() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(false);

    // Act
    TrieKey actualCommonPrefix = emptyResult.getCommonPrefix(TrieKey.empty(true));

    // Assert
    assertEquals(0, actualCommonPrefix.getLength());
    assertEquals(0, actualCommonPrefix.toNormal().length);
    assertFalse(actualCommonPrefix.isTerminal());
    assertTrue(actualCommonPrefix.isEmpty());
    assertArrayEquals(new byte[]{0}, actualCommonPrefix.toPacked());
  }

  /**
   * Method under test: {@link TrieKey#getCommonPrefix(TrieKey)}
   */
  @Test
  public void testGetCommonPrefix3() {
    // Arrange
    TrieKey singleHexResult = TrieKey.singleHex(1);

    // Act
    TrieKey actualCommonPrefix = singleHexResult.getCommonPrefix(TrieKey.empty(true));

    // Assert
    assertEquals(0, actualCommonPrefix.getLength());
    assertEquals(0, actualCommonPrefix.toNormal().length);
    assertFalse(actualCommonPrefix.isTerminal());
    assertTrue(actualCommonPrefix.isEmpty());
    assertArrayEquals(new byte[]{0}, actualCommonPrefix.toPacked());
  }

  /**
   * Method under test: {@link TrieKey#getCommonPrefix(TrieKey)}
   */
  @Test
  public void testGetCommonPrefix4() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act
    TrieKey actualCommonPrefix = emptyResult.getCommonPrefix(TrieKey.empty(false));

    // Assert
    assertEquals(0, actualCommonPrefix.getLength());
    assertEquals(0, actualCommonPrefix.toNormal().length);
    assertFalse(actualCommonPrefix.isTerminal());
    assertTrue(actualCommonPrefix.isEmpty());
    assertArrayEquals(new byte[]{0}, actualCommonPrefix.toPacked());
  }

  /**
   * Method under test: {@link TrieKey#getCommonPrefix(TrieKey)}
   */
  @Test
  public void testGetCommonPrefix5() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act
    TrieKey actualCommonPrefix = emptyResult.getCommonPrefix(TrieKey.singleHex(1));

    // Assert
    assertEquals(0, actualCommonPrefix.getLength());
    assertEquals(0, actualCommonPrefix.toNormal().length);
    assertFalse(actualCommonPrefix.isTerminal());
    assertTrue(actualCommonPrefix.isEmpty());
    assertArrayEquals(new byte[]{0}, actualCommonPrefix.toPacked());
  }

  /**
   * Method under test: {@link TrieKey#getCommonPrefix(TrieKey)}
   */
  @Test
  public void testGetCommonPrefix6() {
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
   * Method under test: {@link TrieKey#getCommonPrefix(TrieKey)}
   */
  @Test
  public void testGetCommonPrefix7() {
    // Arrange
    TrieKey singleHexResult = TrieKey.singleHex(1);

    // Act
    TrieKey actualCommonPrefix = singleHexResult
        .getCommonPrefix(TrieKey.fromNormal(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}));

    // Assert
    assertEquals(0, actualCommonPrefix.getLength());
    assertEquals(0, actualCommonPrefix.toNormal().length);
    assertFalse(actualCommonPrefix.isTerminal());
    assertTrue(actualCommonPrefix.isEmpty());
    assertArrayEquals(new byte[]{0}, actualCommonPrefix.toPacked());
  }

  /**
   * Method under test: {@link TrieKey#getCommonPrefix(TrieKey)}
   */
  @Test
  public void testGetCommonPrefix8() {
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
   * Method under test: {@link TrieKey#matchAndShift(TrieKey)}
   */
  @Test
  public void testMatchAndShift() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act
    TrieKey actualMatchAndShiftResult = emptyResult.matchAndShift(TrieKey.empty(true));

    // Assert
    assertEquals(0, actualMatchAndShiftResult.getLength());
    assertEquals(0, actualMatchAndShiftResult.toNormal().length);
    assertTrue(actualMatchAndShiftResult.isEmpty());
    assertTrue(actualMatchAndShiftResult.isTerminal());
    assertArrayEquals(new byte[]{' '}, actualMatchAndShiftResult.toPacked());
  }

  /**
   * Method under test: {@link TrieKey#matchAndShift(TrieKey)}
   */
  @Test
  public void testMatchAndShift2() {
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
   * Method under test: {@link TrieKey#matchAndShift(TrieKey)}
   */
  @Test
  public void testMatchAndShift3() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act and Assert
    assertNull(emptyResult.matchAndShift(TrieKey.singleHex(1)));
  }

  /**
   * Method under test: {@link TrieKey#matchAndShift(TrieKey)}
   */
  @Test
  public void testMatchAndShift4() {
    // Arrange
    TrieKey singleHexResult = TrieKey.singleHex(1);

    // Act
    TrieKey actualMatchAndShiftResult = singleHexResult.matchAndShift(TrieKey.singleHex(1));

    // Assert
    assertEquals(0, actualMatchAndShiftResult.getLength());
    assertEquals(0, actualMatchAndShiftResult.toNormal().length);
    assertFalse(actualMatchAndShiftResult.isTerminal());
    assertTrue(actualMatchAndShiftResult.isEmpty());
    assertArrayEquals(new byte[]{0}, actualMatchAndShiftResult.toPacked());
  }

  /**
   * Method under test: {@link TrieKey#matchAndShift(TrieKey)}
   */
  @Test
  public void testMatchAndShift5() {
    // Arrange
    TrieKey fromNormalResult = TrieKey.fromNormal(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertNull(fromNormalResult.matchAndShift(TrieKey.singleHex(1)));
  }

  /**
   * Method under test: {@link TrieKey#matchAndShift(TrieKey)}
   */
  @Test
  public void testMatchAndShift6() {
    // Arrange
    TrieKey singleHexResult = TrieKey.singleHex(15);

    // Act and Assert
    assertNull(singleHexResult.matchAndShift(TrieKey.singleHex(1)));
  }

  /**
   * Method under test: {@link TrieKey#matchAndShift(TrieKey)}
   */
  @Test
  public void testMatchAndShift7() {
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
   * Method under test: {@link TrieKey#matchAndShift(TrieKey)}
   */
  @Test
  public void testMatchAndShift8() {
    // Arrange
    TrieKey fromNormalResult = TrieKey.fromNormal(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    TrieKey actualMatchAndShiftResult = fromNormalResult
        .matchAndShift(TrieKey.fromNormal(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}));

    // Assert
    assertEquals(0, actualMatchAndShiftResult.getLength());
    assertEquals(0, actualMatchAndShiftResult.toNormal().length);
    assertTrue(actualMatchAndShiftResult.isEmpty());
    assertTrue(actualMatchAndShiftResult.isTerminal());
    assertArrayEquals(new byte[]{' '}, actualMatchAndShiftResult.toPacked());
  }

  /**
   * Method under test: {@link TrieKey#matchAndShift(TrieKey)}
   */
  @Test
  public void testMatchAndShift9() {
    // Arrange
    TrieKey fromNormalResult = TrieKey.fromNormal(new byte[]{16, 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertNull(fromNormalResult.matchAndShift(TrieKey.fromNormal(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1})));
  }

  /**
   * Method under test: {@link TrieKey#getLength()}
   */
  @Test
  public void testGetLength() {
    // Arrange, Act and Assert
    assertEquals(0, TrieKey.empty(true).getLength());
  }

  /**
   * Method under test: {@link TrieKey#getHex(int)}
   */
  @Test
  public void testGetHex() {
    // Arrange, Act and Assert
    assertEquals(1, TrieKey.fromNormal(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}).getHex(1));
    assertEquals(0, TrieKey.fromNormal(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}).getHex(2));
  }

  /**
   * Method under test: {@link TrieKey#concat(TrieKey)}
   */
  @Test
  public void testConcat() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> emptyResult.concat(TrieKey.empty(true)));
  }

  /**
   * Method under test: {@link TrieKey#concat(TrieKey)}
   */
  @Test
  public void testConcat2() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(false);

    // Act
    TrieKey actualConcatResult = emptyResult.concat(TrieKey.empty(true));

    // Assert
    assertEquals(0, actualConcatResult.getLength());
    assertEquals(0, actualConcatResult.toNormal().length);
    assertTrue(actualConcatResult.isEmpty());
    assertTrue(actualConcatResult.isTerminal());
    assertArrayEquals(new byte[]{' '}, actualConcatResult.toPacked());
  }

  /**
   * Method under test: {@link TrieKey#concat(TrieKey)}
   */
  @Test
  public void testConcat3() {
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
   * Method under test: {@link TrieKey#concat(TrieKey)}
   */
  @Test
  public void testConcat4() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> emptyResult.concat(TrieKey.empty(false)));
  }

  /**
   * Method under test: {@link TrieKey#concat(TrieKey)}
   */
  @Test
  public void testConcat5() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> TrieKey.empty(true).concat(null));
  }

  /**
   * Method under test: {@link TrieKey#concat(TrieKey)}
   */
  @Test
  public void testConcat6() {
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
   * Method under test: {@link TrieKey#concat(TrieKey)}
   */
  @Test
  public void testConcat7() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(false);

    // Act
    TrieKey actualConcatResult = emptyResult.concat(TrieKey.fromNormal(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}));

    // Assert
    assertFalse(actualConcatResult.isEmpty());
    assertTrue(actualConcatResult.isTerminal());
    assertEquals(Short.SIZE, actualConcatResult.getLength());
    assertArrayEquals(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, actualConcatResult.toNormal());
    assertArrayEquals(new byte[]{' ', 'A', 3, 'A', 3, 'A', 3, 'A', 3}, actualConcatResult.toPacked());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TrieKey#equals(Object)}
   *   <li>{@link TrieKey#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link TrieKey#equals(Object)}
   *   <li>{@link TrieKey#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link TrieKey#equals(Object)}
   *   <li>{@link TrieKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() throws UnsupportedEncodingException {
    // Arrange
    TrieKey fromNormalResult = TrieKey.fromNormal("AXAXAXAX".getBytes("UTF-8"));
    TrieKey fromNormalResult2 = TrieKey.fromNormal("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(fromNormalResult, fromNormalResult2);
    int notExpectedHashCodeResult = fromNormalResult.hashCode();
    assertNotEquals(notExpectedHashCodeResult, fromNormalResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TrieKey#equals(Object)}
   *   <li>{@link TrieKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(true);

    // Act and Assert
    assertEquals(emptyResult, emptyResult);
    int expectedHashCodeResult = emptyResult.hashCode();
    assertEquals(expectedHashCodeResult, emptyResult.hashCode());
  }

  /**
   * Method under test: {@link TrieKey#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("T", TrieKey.empty(true).toString());
    assertEquals("", TrieKey.empty(false).toString());
  }

  /**
   * Method under test: {@link TrieKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TrieKey emptyResult = TrieKey.empty(false);

    // Act and Assert
    assertNotEquals(emptyResult, TrieKey.empty(true));
  }

  /**
   * Method under test: {@link TrieKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TrieKey singleHexResult = TrieKey.singleHex(1);

    // Act and Assert
    assertNotEquals(singleHexResult, TrieKey.empty(true));
  }

  /**
   * Method under test: {@link TrieKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TrieKey singleHexResult = TrieKey.singleHex(15);

    // Act and Assert
    assertNotEquals(singleHexResult, TrieKey.singleHex(1));
  }

  /**
   * Method under test: {@link TrieKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TrieKey.empty(true), null);
  }

  /**
   * Method under test: {@link TrieKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TrieKey.empty(true), "Different type to TrieKey");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TrieKey#TrieKey(byte[], int, boolean)}
   *   <li>{@link TrieKey#isTerminal()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue((new TrieKey("AXAXAXAX".getBytes("UTF-8"), 1, true)).isTerminal());
  }
}
