package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.List;
import org.junit.Test;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.exception.EventBloomException;

public class ByteUtilDiffblueTest {
  /**
   * Method under test: {@link ByteUtil#cloneBytes(byte[])}
   */
  @Test
  public void testCloneBytes() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualCloneBytesResult = ByteUtil.cloneBytes("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCloneBytesResult);
  }

  /**
   * Method under test: {@link ByteUtil#cloneBytes(byte[])}
   */
  @Test
  public void testCloneBytes2() {
    // Arrange, Act and Assert
    assertNull(ByteUtil.cloneBytes(null));
  }

  /**
   * Method under test: {@link ByteUtil#cloneBytes(byte[])}
   */
  @Test
  public void testCloneBytes3() {
    // Arrange, Act and Assert
    assertEquals(0, ByteUtil.cloneBytes(new byte[]{}).length);
  }

  /**
   * Method under test: {@link ByteUtil#bigIntegerToBytes(BigInteger)}
   */
  @Test
  public void testBigIntegerToBytes() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, ByteUtil.bigIntegerToBytes(DataWord.MAX_VALUE));
    assertNull(ByteUtil.bigIntegerToBytes(null));
    assertArrayEquals(
        new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        ByteUtil.bigIntegerToBytes(DataWord._2_256));
    assertArrayEquals(new byte[]{1}, ByteUtil.bigIntegerToBytes(BigInteger.valueOf(1L)));
    assertArrayEquals(new byte[]{0, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        ByteUtil.bigIntegerToBytes(DataWord.MAX_VALUE, 10));
    assertNull(ByteUtil.bigIntegerToBytes(null, 10));
    assertArrayEquals(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, ByteUtil.bigIntegerToBytes(DataWord.MAX_VALUE, ByteUtil.WORD_SIZE));
  }

  /**
   * Method under test: {@link ByteUtil#merge(byte[][])}
   */
  @Test
  public void testMerge() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualMergeResult = ByteUtil.merge("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualMergeResult);
  }

  /**
   * Method under test: {@link ByteUtil#appendByte(byte[], byte)}
   */
  @Test
  public void testAppendByte() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualAppendByteResult = ByteUtil.appendByte("AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Assert
    assertArrayEquals("AXAXAXAXA".getBytes("UTF-8"), actualAppendByteResult);
  }

  /**
   * Method under test: {@link ByteUtil#nibblesToPrettyString(byte[])}
   */
  @Test
  public void testNibblesToPrettyString() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("\\x41\\x58\\x41\\x58\\x41\\x58\\x41\\x58",
        ByteUtil.nibblesToPrettyString("AXAXAXAX".getBytes("UTF-8")));
    assertEquals("\\x08\\x58\\x41\\x58\\x41\\x58\\x41\\x58",
        ByteUtil.nibblesToPrettyString("\bXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtil#oneByteToHexString(byte)}
   */
  @Test
  public void testOneByteToHexString() {
    // Arrange, Act and Assert
    assertEquals("41", ByteUtil.oneByteToHexString((byte) 'A'));
    assertEquals("01", ByteUtil.oneByteToHexString((byte) 1));
  }

  /**
   * Method under test: {@link ByteUtil#byteArrayToInt(byte[])}
   */
  @Test
  public void testByteArrayToInt() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1096302936, ByteUtil.byteArrayToInt("AXAXAXAX".getBytes("UTF-8")));
    assertEquals(0, ByteUtil.byteArrayToInt(null));
    assertEquals(0, ByteUtil.byteArrayToInt(new byte[]{}));
  }

  /**
   * Method under test: {@link ByteUtil#isSingleZero(byte[])}
   */
  @Test
  public void testIsSingleZero() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(ByteUtil.isSingleZero("AXAXAXAX".getBytes("UTF-8")));
    assertTrue(ByteUtil.isSingleZero(new byte[]{0}));
    assertFalse(ByteUtil.isSingleZero(new byte[]{'A'}));
  }

  /**
   * Method under test: {@link ByteUtil#intToBytesNoLeadZeroes(int)}
   */
  @Test
  public void testIntToBytesNoLeadZeroes() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'*'}, ByteUtil.intToBytesNoLeadZeroes(DecodeUtil.ADDRESS_SIZE));
    assertEquals(0, ByteUtil.intToBytesNoLeadZeroes(0).length);
  }

  /**
   * Method under test: {@link ByteUtil#intToBytes(int)}
   */
  @Test
  public void testIntToBytes() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, '*'}, ByteUtil.intToBytes(DecodeUtil.ADDRESS_SIZE));
  }

  /**
   * Method under test: {@link ByteUtil#bytesToBigInteger(byte[])}
   */
  @Test
  public void testBytesToBigInteger() throws UnsupportedEncodingException {
    // Arrange and Act
    BigInteger actualBytesToBigIntegerResult = ByteUtil.bytesToBigInteger("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("4708585257725083992", actualBytesToBigIntegerResult.toString());
    assertEquals(1, actualBytesToBigIntegerResult.signum());
    assertEquals(3, actualBytesToBigIntegerResult.getLowestSetBit());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, actualBytesToBigIntegerResult.toByteArray());
  }

  /**
   * Method under test: {@link ByteUtil#bytesToBigInteger(byte[])}
   */
  @Test
  public void testBytesToBigInteger2() {
    // Arrange and Act
    BigInteger actualBytesToBigIntegerResult = ByteUtil.bytesToBigInteger(null);

    // Assert
    assertEquals("0", actualBytesToBigIntegerResult.toString());
    assertEquals(-1, actualBytesToBigIntegerResult.getLowestSetBit());
    assertEquals(0, actualBytesToBigIntegerResult.signum());
    assertArrayEquals(new byte[]{0}, actualBytesToBigIntegerResult.toByteArray());
  }

  /**
   * Method under test: {@link ByteUtil#bytesToBigInteger(byte[])}
   */
  @Test
  public void testBytesToBigInteger3() {
    // Arrange and Act
    BigInteger actualBytesToBigIntegerResult = ByteUtil.bytesToBigInteger(new byte[]{});

    // Assert
    assertEquals("0", actualBytesToBigIntegerResult.toString());
    assertEquals(-1, actualBytesToBigIntegerResult.getLowestSetBit());
    assertEquals(0, actualBytesToBigIntegerResult.signum());
    assertArrayEquals(new byte[]{0}, actualBytesToBigIntegerResult.toByteArray());
  }

  /**
   * Method under test: {@link ByteUtil#byteArrayToLong(byte[])}
   */
  @Test
  public void testByteArrayToLong() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(4708585257725083992L, ByteUtil.byteArrayToLong("AXAXAXAX".getBytes("UTF-8")));
    assertEquals(0L, ByteUtil.byteArrayToLong(null));
    assertEquals(0L, ByteUtil.byteArrayToLong(new byte[]{}));
  }

  /**
   * Method under test: {@link ByteUtil#firstNonZeroByte(byte[])}
   */
  @Test
  public void testFirstNonZeroByte() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(0, ByteUtil.firstNonZeroByte("AXAXAXAX".getBytes("UTF-8")));
    assertEquals(-1, ByteUtil.firstNonZeroByte(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
  }

  /**
   * Method under test: {@link ByteUtil#lastNonZeroByte(byte[])}
   */
  @Test
  public void testLastNonZeroByte() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(7, ByteUtil.lastNonZeroByte("AXAXAXAX".getBytes("UTF-8")));
    assertEquals(6, ByteUtil.lastNonZeroByte(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 0}));
    assertEquals(-1, ByteUtil.lastNonZeroByte(new byte[]{}));
  }

  /**
   * Method under test: {@link ByteUtil#stripLeadingZeroes(byte[])}
   */
  @Test
  public void testStripLeadingZeroes() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualStripLeadingZeroesResult = ByteUtil.stripLeadingZeroes("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualStripLeadingZeroesResult);
  }

  /**
   * Method under test: {@link ByteUtil#stripLeadingZeroes(byte[])}
   */
  @Test
  public void testStripLeadingZeroes2() {
    // Arrange, Act and Assert
    assertNull(ByteUtil.stripLeadingZeroes(null));
  }

  /**
   * Method under test: {@link ByteUtil#stripLeadingZeroes(byte[])}
   */
  @Test
  public void testStripLeadingZeroes3() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0},
        ByteUtil.stripLeadingZeroes(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
  }

  /**
   * Method under test: {@link ByteUtil#stripLeadingZeroes(byte[])}
   */
  @Test
  public void testStripLeadingZeroes4() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualStripLeadingZeroesResult = ByteUtil
        .stripLeadingZeroes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), actualStripLeadingZeroesResult);
  }

  /**
   * Method under test: {@link ByteUtil#stripEndingZeroes(byte[])}
   */
  @Test
  public void testStripEndingZeroes() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualStripEndingZeroesResult = ByteUtil.stripEndingZeroes("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualStripEndingZeroesResult);
  }

  /**
   * Method under test: {@link ByteUtil#stripEndingZeroes(byte[])}
   */
  @Test
  public void testStripEndingZeroes2() {
    // Arrange, Act and Assert
    assertNull(ByteUtil.stripEndingZeroes(null));
  }

  /**
   * Method under test: {@link ByteUtil#stripEndingZeroes(byte[])}
   */
  @Test
  public void testStripEndingZeroes3() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualStripEndingZeroesResult = ByteUtil.stripEndingZeroes(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 0});

    // Assert
    assertArrayEquals("AXAXAXA".getBytes("UTF-8"), actualStripEndingZeroesResult);
  }

  /**
   * Method under test: {@link ByteUtil#copyToArray(BigInteger)}
   */
  @Test
  public void testCopyToArray() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, ByteUtil.copyToArray(DataWord.MAX_VALUE));
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        ByteUtil.copyToArray(null));
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ' '},
        ByteUtil.copyToArray(BigInteger.valueOf(32L)));
  }

  /**
   * Method under test: {@link ByteUtil#numberOfLeadingZeros(byte[])}
   */
  @Test
  public void testNumberOfLeadingZeros() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1, ByteUtil.numberOfLeadingZeros("AXAXAXAX".getBytes("UTF-8")));
    assertEquals(144, ByteUtil.numberOfLeadingZeros(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
  }

  /**
   * Method under test: {@link ByteUtil#parseBytes(byte[], int, int)}
   */
  @Test
  public void testParseBytes() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualParseBytesResult = ByteUtil.parseBytes("AXAXAXAX".getBytes("UTF-8"), 2, 3);

    // Assert
    assertArrayEquals("AXA".getBytes("UTF-8"), actualParseBytesResult);
  }

  /**
   * Method under test: {@link ByteUtil#parseBytes(byte[], int, int)}
   */
  @Test
  public void testParseBytes2() {
    // Arrange, Act and Assert
    assertEquals(0, ByteUtil.parseBytes(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 0).length);
  }

  /**
   * Method under test: {@link ByteUtil#parseBytes(byte[], int, int)}
   */
  @Test
  public void testParseBytes3() {
    // Arrange, Act and Assert
    assertEquals(0, ByteUtil.parseBytes(new byte[]{}, 2, 3).length);
  }

  /**
   * Method under test: {@link ByteUtil#parseWord(byte[], int)}
   */
  @Test
  public void testParseWord() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(0, ByteUtil.parseWord("AXAXAXAX".getBytes("UTF-8"), 1).length);
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, ByteUtil.parseWord("AXAXAXAX".getBytes("UTF-8"), 0));
    assertEquals(0, ByteUtil.parseWord("AXAXAXAX".getBytes("UTF-8"), 2, 1).length);
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0}, ByteUtil.parseWord("AXAXAXAX".getBytes("UTF-8"), 2, 0));
  }

  /**
   * Method under test: {@link ByteUtil#greater(byte[], byte[])}
   */
  @Test
  public void testGreater() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(ByteUtil.greater(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtil#greater(byte[], byte[])}
   */
  @Test
  public void testGreater2() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(ByteUtil.greater(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtil#greater(byte[], byte[])}
   */
  @Test
  public void testGreater3() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "XXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(ByteUtil.greater(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtil#greaterOrEquals(byte[], byte[])}
   */
  @Test
  public void testGreaterOrEquals() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(ByteUtil.greaterOrEquals(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtil#greaterOrEquals(byte[], byte[])}
   */
  @Test
  public void testGreaterOrEquals2() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(ByteUtil.greaterOrEquals(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtil#less(byte[], byte[])}
   */
  @Test
  public void testLess() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(ByteUtil.less(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtil#less(byte[], byte[])}
   */
  @Test
  public void testLess2() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(ByteUtil.less(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtil#lessOrEquals(byte[], byte[])}
   */
  @Test
  public void testLessOrEquals() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(ByteUtil.lessOrEquals(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtil#lessOrEquals(byte[], byte[])}
   */
  @Test
  public void testLessOrEquals2() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(ByteUtil.lessOrEquals(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtil#lessOrEquals(byte[], byte[])}
   */
  @Test
  public void testLessOrEquals3() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "XXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(ByteUtil.lessOrEquals(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtil#equals(byte[], byte[])}
   */
  @Test
  public void testEquals() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(ByteUtil.equals(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtil#equals(byte[], byte[])}
   */
  @Test
  public void testEquals2() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(ByteUtil.equals(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtil#isNullOrZeroArray(byte[])}
   */
  @Test
  public void testIsNullOrZeroArray() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(ByteUtil.isNullOrZeroArray("AXAXAXAX".getBytes("UTF-8")));
    assertTrue(ByteUtil.isNullOrZeroArray(null));
    assertTrue(ByteUtil.isNullOrZeroArray(new byte[]{}));
  }

  /**
   * Method under test: {@link ByteUtil#compare(byte[], byte[])}
   */
  @Test
  public void testCompare() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, ByteUtil.compare(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtil#compare(byte[], byte[])}
   */
  @Test
  public void testCompare2() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-57, ByteUtil.compare(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtil#hexToBytes(String)}
   */
  @Test
  public void testHexToBytes() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{1, '#', 'E', 'g', -119, -85, -51, -17}, ByteUtil.hexToBytes("0123456789ABCDEF"));
  }

  /**
   * Method under test: {@link ByteUtil#convertBytesVectorToVector(byte[])}
   */
  @Test
  public void testConvertBytesVectorToVector() throws UnsupportedEncodingException {
    // Arrange and Act
    List<Boolean> actualConvertBytesVectorToVectorResult = ByteUtil
        .convertBytesVectorToVector("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(Double.SIZE, actualConvertBytesVectorToVectorResult.size());
    assertFalse(actualConvertBytesVectorToVectorResult.get(0));
    assertFalse(actualConvertBytesVectorToVectorResult.get(2));
    assertFalse(actualConvertBytesVectorToVectorResult.get(3));
    assertFalse(actualConvertBytesVectorToVectorResult.get(4));
    assertFalse(actualConvertBytesVectorToVectorResult.get(5));
    assertFalse(actualConvertBytesVectorToVectorResult.get(58));
    assertFalse(actualConvertBytesVectorToVectorResult.get(61));
    assertFalse(actualConvertBytesVectorToVectorResult.get(62));
    assertFalse(actualConvertBytesVectorToVectorResult.get(63));
    assertTrue(actualConvertBytesVectorToVectorResult.get(1));
    assertTrue(actualConvertBytesVectorToVectorResult.get(59));
    assertTrue(actualConvertBytesVectorToVectorResult.get(60));
  }

  /**
   * Method under test: {@link ByteUtil#reverse(byte[])}
   */
  @Test
  public void testReverse() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ByteUtil.reverse(bytes);

    // Assert
    assertArrayEquals("XAXAXAXA".getBytes("UTF-8"), bytes);
  }

  /**
   * Method under test: {@link ByteUtil#longTo32Bytes(long)}
   */
  @Test
  public void testLongTo32Bytes() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        ByteUtil.longTo32Bytes(42L));
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        ByteUtil.longTo32Bytes(0L));
  }

  /**
   * Method under test: {@link ByteUtil#setBit(byte[], int, int)}
   */
  @Test
  public void testSetBit() throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualSetBitResult = ByteUtil.setBit(data, 1, DecodeUtil.ADDRESS_SIZE);

    // Assert
    assertEquals(8, data.length);
    assertEquals('X', data[7]);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSetBitResult);
  }

  /**
   * Method under test: {@link ByteUtil#setBit(byte[], int, int)}
   */
  @Test
  public void testSetBit2() throws UnsupportedEncodingException {
    // Arrange
    byte[] data = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    byte[] actualSetBitResult = ByteUtil.setBit(data, 1, 1);

    // Assert
    assertEquals(8, data.length);
    assertEquals('Z', data[7]);
    assertArrayEquals("AXAXAXAZ".getBytes("UTF-8"), actualSetBitResult);
  }

  /**
   * Method under test: {@link ByteUtil#setBit(byte[], int, int)}
   */
  @Test
  public void testSetBit3() {
    // Arrange, Act and Assert
    assertThrows(Error.class, () -> ByteUtil.setBit(new byte[]{}, 1, DecodeUtil.ADDRESS_SIZE));
  }

  /**
   * Method under test: {@link ByteUtil#compress(byte[])}
   */
  @Test
  public void testCompress() throws UnsupportedEncodingException, EventBloomException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'x', -100, 's', -116, 'p', 4, 'C', 0, '\n', -100, 2, 'e'},
        ByteUtil.compress("AXAXAXAX".getBytes("UTF-8")));
  }
}
