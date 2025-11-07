package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.exception.EventBloomException;

public class ByteUtilDiffblueTest {
  /**
   * Test {@link ByteUtil#cloneBytes(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#cloneBytes(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.cloneBytes(byte[])"})
  public void testCloneBytes_whenAxaxaxaxBytesIsUtf8_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualCloneBytesResult = ByteUtil.cloneBytes("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCloneBytesResult);
  }

  /**
   * Test {@link ByteUtil#cloneBytes(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#cloneBytes(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.cloneBytes(byte[])"})
  public void testCloneBytes_whenEmptyArrayOfByte_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, ByteUtil.cloneBytes(new byte[]{}));
  }

  /**
   * Test {@link ByteUtil#cloneBytes(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#cloneBytes(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.cloneBytes(byte[])"})
  public void testCloneBytes_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ByteUtil.cloneBytes(null));
  }

  /**
   * Test {@link ByteUtil#bigIntegerToBytes(BigInteger, int)} with {@code b}, {@code numBytes}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus one and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#bigIntegerToBytes(BigInteger, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.bigIntegerToBytes(BigInteger, int)"})
  public void testBigIntegerToBytesWithBNumBytes_thenReturnArrayOfByteWithMinusOneAndMinusOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, ByteUtil.bigIntegerToBytes(DataWord.MAX_VALUE, ByteUtil.WORD_SIZE));
  }

  /**
   * Test {@link ByteUtil#bigIntegerToBytes(BigInteger, int)} with {@code b}, {@code numBytes}.
   * <ul>
   *   <li>Then return array of {@code byte} with zero and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#bigIntegerToBytes(BigInteger, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.bigIntegerToBytes(BigInteger, int)"})
  public void testBigIntegerToBytesWithBNumBytes_thenReturnArrayOfByteWithZeroAndMinusOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        ByteUtil.bigIntegerToBytes(DataWord.MAX_VALUE, 10));
  }

  /**
   * Test {@link ByteUtil#bigIntegerToBytes(BigInteger, int)} with {@code b}, {@code numBytes}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#bigIntegerToBytes(BigInteger, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.bigIntegerToBytes(BigInteger, int)"})
  public void testBigIntegerToBytesWithBNumBytes_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ByteUtil.bigIntegerToBytes(null, 10));
  }

  /**
   * Test {@link ByteUtil#bigIntegerToBytes(BigInteger)} with {@code value}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus one and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#bigIntegerToBytes(BigInteger)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.bigIntegerToBytes(BigInteger)"})
  public void testBigIntegerToBytesWithValue_thenReturnArrayOfByteWithMinusOneAndMinusOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, ByteUtil.bigIntegerToBytes(DataWord.MAX_VALUE));
  }

  /**
   * Test {@link ByteUtil#bigIntegerToBytes(BigInteger)} with {@code value}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#bigIntegerToBytes(BigInteger)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.bigIntegerToBytes(BigInteger)"})
  public void testBigIntegerToBytesWithValue_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ByteUtil.bigIntegerToBytes(null));
  }

  /**
   * Test {@link ByteUtil#bigIntegerToBytes(BigInteger)} with {@code value}.
   * <ul>
   *   <li>When valueOf one.</li>
   *   <li>Then return array of {@code byte} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#bigIntegerToBytes(BigInteger)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.bigIntegerToBytes(BigInteger)"})
  public void testBigIntegerToBytesWithValue_whenValueOfOne_thenReturnArrayOfByteWithOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{1}, ByteUtil.bigIntegerToBytes(BigInteger.valueOf(1L)));
  }

  /**
   * Test {@link ByteUtil#bigIntegerToBytes(BigInteger)} with {@code value}.
   * <ul>
   *   <li>When {@link DataWord#_2_256}.</li>
   *   <li>Then return array of {@code byte} with one and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#bigIntegerToBytes(BigInteger)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.bigIntegerToBytes(BigInteger)"})
  public void testBigIntegerToBytesWithValue_when_2_256_thenReturnArrayOfByteWithOneAndZero() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        ByteUtil.bigIntegerToBytes(DataWord._2_256));
  }

  /**
   * Test {@link ByteUtil#merge(byte[][])}.
   * <p>
   * Method under test: {@link ByteUtil#merge(byte[][])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.merge(byte[][])"})
  public void testMerge() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualMergeResult = ByteUtil.merge("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualMergeResult);
  }

  /**
   * Test {@link ByteUtil#appendByte(byte[], byte)}.
   * <p>
   * Method under test: {@link ByteUtil#appendByte(byte[], byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.appendByte(byte[], byte)"})
  public void testAppendByte() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualAppendByteResult = ByteUtil.appendByte("AXAXAXAX".getBytes("UTF-8"), (byte) 'A');

    // Assert
    assertArrayEquals("AXAXAXAXA".getBytes("UTF-8"), actualAppendByteResult);
  }

  /**
   * Test {@link ByteUtil#nibblesToPrettyString(byte[])}.
   * <ul>
   *   <li>Then return {@code \x08\x58\x41\x58\x41\x58\x41\x58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#nibblesToPrettyString(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ByteUtil.nibblesToPrettyString(byte[])"})
  public void testNibblesToPrettyString_thenReturnX08X58X41X58X41X58X41X58() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("\\x08\\x58\\x41\\x58\\x41\\x58\\x41\\x58",
        ByteUtil.nibblesToPrettyString("\bXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#nibblesToPrettyString(byte[])}.
   * <ul>
   *   <li>Then return {@code \x41\x58\x41\x58\x41\x58\x41\x58}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#nibblesToPrettyString(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ByteUtil.nibblesToPrettyString(byte[])"})
  public void testNibblesToPrettyString_thenReturnX41X58X41X58X41X58X41X58() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("\\x41\\x58\\x41\\x58\\x41\\x58\\x41\\x58",
        ByteUtil.nibblesToPrettyString("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#oneByteToHexString(byte)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code 41}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#oneByteToHexString(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ByteUtil.oneByteToHexString(byte)"})
  public void testOneByteToHexString_whenA_thenReturn41() {
    // Arrange, Act and Assert
    assertEquals("41", ByteUtil.oneByteToHexString((byte) 'A'));
  }

  /**
   * Test {@link ByteUtil#oneByteToHexString(byte)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code 01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#oneByteToHexString(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ByteUtil.oneByteToHexString(byte)"})
  public void testOneByteToHexString_whenOne_thenReturn01() {
    // Arrange, Act and Assert
    assertEquals("01", ByteUtil.oneByteToHexString((byte) 1));
  }

  /**
   * Test {@link ByteUtil#byteArrayToInt(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 1096302936}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#byteArrayToInt(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteUtil.byteArrayToInt(byte[])"})
  public void testByteArrayToInt_whenAxaxaxaxBytesIsUtf8_thenReturn1096302936() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1096302936, ByteUtil.byteArrayToInt("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#byteArrayToInt(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#byteArrayToInt(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteUtil.byteArrayToInt(byte[])"})
  public void testByteArrayToInt_whenEmptyArrayOfByte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ByteUtil.byteArrayToInt(new byte[]{}));
  }

  /**
   * Test {@link ByteUtil#byteArrayToInt(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#byteArrayToInt(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteUtil.byteArrayToInt(byte[])"})
  public void testByteArrayToInt_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ByteUtil.byteArrayToInt(null));
  }

  /**
   * Test {@link ByteUtil#isSingleZero(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#isSingleZero(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteUtil.isSingleZero(byte[])"})
  public void testIsSingleZero_whenArrayOfByteWithA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ByteUtil.isSingleZero(new byte[]{'A'}));
  }

  /**
   * Test {@link ByteUtil#isSingleZero(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with zero.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#isSingleZero(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteUtil.isSingleZero(byte[])"})
  public void testIsSingleZero_whenArrayOfByteWithZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ByteUtil.isSingleZero(new byte[]{0}));
  }

  /**
   * Test {@link ByteUtil#isSingleZero(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#isSingleZero(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteUtil.isSingleZero(byte[])"})
  public void testIsSingleZero_whenAxaxaxaxBytesIsUtf8_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(ByteUtil.isSingleZero("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#intToBytesNoLeadZeroes(int)}.
   * <ul>
   *   <li>When {@link DecodeUtil#ADDRESS_SIZE}.</li>
   *   <li>Then return array of {@code byte} with {@code *}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#intToBytesNoLeadZeroes(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.intToBytesNoLeadZeroes(int)"})
  public void testIntToBytesNoLeadZeroes_whenAddress_size_thenReturnArrayOfByteWithAsterisk() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'*'}, ByteUtil.intToBytesNoLeadZeroes(DecodeUtil.ADDRESS_SIZE));
  }

  /**
   * Test {@link ByteUtil#intToBytesNoLeadZeroes(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#intToBytesNoLeadZeroes(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.intToBytesNoLeadZeroes(int)"})
  public void testIntToBytesNoLeadZeroes_whenZero_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, ByteUtil.intToBytesNoLeadZeroes(0));
  }

  /**
   * Test {@link ByteUtil#intToBytes(int)}.
   * <p>
   * Method under test: {@link ByteUtil#intToBytes(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.intToBytes(int)"})
  public void testIntToBytes() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, '*'}, ByteUtil.intToBytes(DecodeUtil.ADDRESS_SIZE));
  }

  /**
   * Test {@link ByteUtil#bytesToBigInteger(byte[])}.
   * <ul>
   *   <li>Then return toString is {@code 4708585257725083992}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#bytesToBigInteger(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigInteger ByteUtil.bytesToBigInteger(byte[])"})
  public void testBytesToBigInteger_thenReturnToStringIs4708585257725083992() throws UnsupportedEncodingException {
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
   * Test {@link ByteUtil#bytesToBigInteger(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return toString is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#bytesToBigInteger(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigInteger ByteUtil.bytesToBigInteger(byte[])"})
  public void testBytesToBigInteger_whenEmptyArrayOfByte_thenReturnToStringIs0() {
    // Arrange and Act
    BigInteger actualBytesToBigIntegerResult = ByteUtil.bytesToBigInteger(new byte[]{});

    // Assert
    assertEquals("0", actualBytesToBigIntegerResult.toString());
    assertEquals(-1, actualBytesToBigIntegerResult.getLowestSetBit());
    assertEquals(0, actualBytesToBigIntegerResult.signum());
    assertArrayEquals(new byte[]{0}, actualBytesToBigIntegerResult.toByteArray());
  }

  /**
   * Test {@link ByteUtil#bytesToBigInteger(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return toString is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#bytesToBigInteger(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigInteger ByteUtil.bytesToBigInteger(byte[])"})
  public void testBytesToBigInteger_whenNull_thenReturnToStringIs0() {
    // Arrange and Act
    BigInteger actualBytesToBigIntegerResult = ByteUtil.bytesToBigInteger(null);

    // Assert
    assertEquals("0", actualBytesToBigIntegerResult.toString());
    assertEquals(-1, actualBytesToBigIntegerResult.getLowestSetBit());
    assertEquals(0, actualBytesToBigIntegerResult.signum());
    assertArrayEquals(new byte[]{0}, actualBytesToBigIntegerResult.toByteArray());
  }

  /**
   * Test {@link ByteUtil#byteArrayToLong(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 4708585257725083992}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#byteArrayToLong(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ByteUtil.byteArrayToLong(byte[])"})
  public void testByteArrayToLong_whenAxaxaxaxBytesIsUtf8_thenReturn4708585257725083992()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(4708585257725083992L, ByteUtil.byteArrayToLong("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#byteArrayToLong(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#byteArrayToLong(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ByteUtil.byteArrayToLong(byte[])"})
  public void testByteArrayToLong_whenEmptyArrayOfByte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, ByteUtil.byteArrayToLong(new byte[]{}));
  }

  /**
   * Test {@link ByteUtil#byteArrayToLong(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#byteArrayToLong(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ByteUtil.byteArrayToLong(byte[])"})
  public void testByteArrayToLong_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, ByteUtil.byteArrayToLong(null));
  }

  /**
   * Test {@link ByteUtil#firstNonZeroByte(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#firstNonZeroByte(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteUtil.firstNonZeroByte(byte[])"})
  public void testFirstNonZeroByte_whenArrayOfByteWithZeroAndZero_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, ByteUtil.firstNonZeroByte(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
  }

  /**
   * Test {@link ByteUtil#firstNonZeroByte(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#firstNonZeroByte(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteUtil.firstNonZeroByte(byte[])"})
  public void testFirstNonZeroByte_whenAxaxaxaxBytesIsUtf8_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(0, ByteUtil.firstNonZeroByte("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#lastNonZeroByte(byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return six.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#lastNonZeroByte(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteUtil.lastNonZeroByte(byte[])"})
  public void testLastNonZeroByte_whenA_thenReturnSix() {
    // Arrange, Act and Assert
    assertEquals(6, ByteUtil.lastNonZeroByte(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 0}));
  }

  /**
   * Test {@link ByteUtil#lastNonZeroByte(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#lastNonZeroByte(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteUtil.lastNonZeroByte(byte[])"})
  public void testLastNonZeroByte_whenAxaxaxaxBytesIsUtf8_thenReturnSeven() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(7, ByteUtil.lastNonZeroByte("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#lastNonZeroByte(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#lastNonZeroByte(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteUtil.lastNonZeroByte(byte[])"})
  public void testLastNonZeroByte_whenEmptyArrayOfByte_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, ByteUtil.lastNonZeroByte(new byte[]{}));
  }

  /**
   * Test {@link ByteUtil#stripLeadingZeroes(byte[])}.
   * <ul>
   *   <li>Then return array of {@code byte} with zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#stripLeadingZeroes(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.stripLeadingZeroes(byte[])"})
  public void testStripLeadingZeroes_thenReturnArrayOfByteWithZero() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0},
        ByteUtil.stripLeadingZeroes(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
  }

  /**
   * Test {@link ByteUtil#stripLeadingZeroes(byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#stripLeadingZeroes(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.stripLeadingZeroes(byte[])"})
  public void testStripLeadingZeroes_whenA_thenReturnXaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualStripLeadingZeroesResult = ByteUtil
        .stripLeadingZeroes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), actualStripLeadingZeroesResult);
  }

  /**
   * Test {@link ByteUtil#stripLeadingZeroes(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#stripLeadingZeroes(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.stripLeadingZeroes(byte[])"})
  public void testStripLeadingZeroes_whenAxaxaxaxBytesIsUtf8_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualStripLeadingZeroesResult = ByteUtil.stripLeadingZeroes("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualStripLeadingZeroesResult);
  }

  /**
   * Test {@link ByteUtil#stripLeadingZeroes(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#stripLeadingZeroes(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.stripLeadingZeroes(byte[])"})
  public void testStripLeadingZeroes_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ByteUtil.stripLeadingZeroes(null));
  }

  /**
   * Test {@link ByteUtil#stripEndingZeroes(byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code AXAXAXA} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#stripEndingZeroes(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.stripEndingZeroes(byte[])"})
  public void testStripEndingZeroes_whenA_thenReturnAxaxaxaBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualStripEndingZeroesResult = ByteUtil.stripEndingZeroes(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 0});

    // Assert
    assertArrayEquals("AXAXAXA".getBytes("UTF-8"), actualStripEndingZeroesResult);
  }

  /**
   * Test {@link ByteUtil#stripEndingZeroes(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#stripEndingZeroes(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.stripEndingZeroes(byte[])"})
  public void testStripEndingZeroes_whenAxaxaxaxBytesIsUtf8_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualStripEndingZeroesResult = ByteUtil.stripEndingZeroes("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualStripEndingZeroesResult);
  }

  /**
   * Test {@link ByteUtil#stripEndingZeroes(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#stripEndingZeroes(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.stripEndingZeroes(byte[])"})
  public void testStripEndingZeroes_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ByteUtil.stripEndingZeroes(null));
  }

  /**
   * Test {@link ByteUtil#copyToArray(BigInteger)}.
   * <ul>
   *   <li>When {@link DataWord#MAX_VALUE}.</li>
   *   <li>Then return array of {@code byte} with minus one and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#copyToArray(BigInteger)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.copyToArray(BigInteger)"})
  public void testCopyToArray_whenMax_value_thenReturnArrayOfByteWithMinusOneAndMinusOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, ByteUtil.copyToArray(DataWord.MAX_VALUE));
  }

  /**
   * Test {@link ByteUtil#copyToArray(BigInteger)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#copyToArray(BigInteger)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.copyToArray(BigInteger)"})
  public void testCopyToArray_whenNull_thenReturnArrayOfByteWithZeroAndZero() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        ByteUtil.copyToArray(null));
  }

  /**
   * Test {@link ByteUtil#copyToArray(BigInteger)}.
   * <ul>
   *   <li>When valueOf thirty-two.</li>
   *   <li>Then return array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#copyToArray(BigInteger)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.copyToArray(BigInteger)"})
  public void testCopyToArray_whenValueOfThirtyTwo_thenReturnArrayOfByteWithZeroAndZero() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ' '},
        ByteUtil.copyToArray(BigInteger.valueOf(32L)));
  }

  /**
   * Test {@link ByteUtil#numberOfLeadingZeros(byte[])}.
   * <ul>
   *   <li>Then return one hundred forty-four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#numberOfLeadingZeros(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteUtil.numberOfLeadingZeros(byte[])"})
  public void testNumberOfLeadingZeros_thenReturnOneHundredFortyFour() {
    // Arrange, Act and Assert
    assertEquals(144, ByteUtil.numberOfLeadingZeros(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
  }

  /**
   * Test {@link ByteUtil#numberOfLeadingZeros(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#numberOfLeadingZeros(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteUtil.numberOfLeadingZeros(byte[])"})
  public void testNumberOfLeadingZeros_whenAxaxaxaxBytesIsUtf8_thenReturnOne() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1, ByteUtil.numberOfLeadingZeros("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#parseBytes(byte[], int, int)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#parseBytes(byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.parseBytes(byte[], int, int)"})
  public void testParseBytes_whenA_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, ByteUtil.parseBytes(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 0));
  }

  /**
   * Test {@link ByteUtil#parseBytes(byte[], int, int)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code AXA} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#parseBytes(byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.parseBytes(byte[], int, int)"})
  public void testParseBytes_whenAxaxaxaxBytesIsUtf8_thenReturnAxaBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualParseBytesResult = ByteUtil.parseBytes("AXAXAXAX".getBytes("UTF-8"), 2, 3);

    // Assert
    assertArrayEquals("AXA".getBytes("UTF-8"), actualParseBytesResult);
  }

  /**
   * Test {@link ByteUtil#parseBytes(byte[], int, int)}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#parseBytes(byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.parseBytes(byte[], int, int)"})
  public void testParseBytes_whenEmptyArrayOfByte_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, ByteUtil.parseBytes(new byte[]{}, 2, 3));
  }

  /**
   * Test {@link ByteUtil#parseWord(byte[], int)} with {@code input}, {@code idx}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#parseWord(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.parseWord(byte[], int)"})
  public void testParseWordWithInputIdx_whenOne_thenReturnEmptyArrayOfByte() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, ByteUtil.parseWord("AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Test {@link ByteUtil#parseWord(byte[], int)} with {@code input}, {@code idx}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#parseWord(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.parseWord(byte[], int)"})
  public void testParseWordWithInputIdx_whenZero_thenReturnArrayOfByteWithAAndX() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, ByteUtil.parseWord("AXAXAXAX".getBytes("UTF-8"), 0));
  }

  /**
   * Test {@link ByteUtil#parseWord(byte[], int, int)} with {@code input}, {@code offset}, {@code idx}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#parseWord(byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.parseWord(byte[], int, int)"})
  public void testParseWordWithInputOffsetIdx_whenTwo_thenReturnEmptyArrayOfByte() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, ByteUtil.parseWord("AXAXAXAX".getBytes("UTF-8"), 2, 1));
  }

  /**
   * Test {@link ByteUtil#parseWord(byte[], int, int)} with {@code input}, {@code offset}, {@code idx}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#parseWord(byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.parseWord(byte[], int, int)"})
  public void testParseWordWithInputOffsetIdx_whenZero_thenReturnArrayOfByteWithAAndX()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0}, ByteUtil.parseWord("AXAXAXAX".getBytes("UTF-8"), 2, 0));
  }

  /**
   * Test {@link ByteUtil#greater(byte[], byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#greater(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteUtil.greater(byte[], byte[])"})
  public void testGreater_whenAxaxaxaxBytesIsUtf8_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(ByteUtil.greater(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#greater(byte[], byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#greater(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteUtil.greater(byte[], byte[])"})
  public void testGreater_whenXaxaxaxBytesIsUtf8_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(ByteUtil.greater(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#greater(byte[], byte[])}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#greater(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteUtil.greater(byte[], byte[])"})
  public void testGreater_whenXxaxaxaxBytesIsUtf8_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "XXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(ByteUtil.greater(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#greaterOrEquals(byte[], byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#greaterOrEquals(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteUtil.greaterOrEquals(byte[], byte[])"})
  public void testGreaterOrEquals_whenAxaxaxaxBytesIsUtf8_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(ByteUtil.greaterOrEquals(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#greaterOrEquals(byte[], byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#greaterOrEquals(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteUtil.greaterOrEquals(byte[], byte[])"})
  public void testGreaterOrEquals_whenXaxaxaxBytesIsUtf8_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(ByteUtil.greaterOrEquals(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#less(byte[], byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#less(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteUtil.less(byte[], byte[])"})
  public void testLess_whenAxaxaxaxBytesIsUtf8_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(ByteUtil.less(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#less(byte[], byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#less(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteUtil.less(byte[], byte[])"})
  public void testLess_whenXaxaxaxBytesIsUtf8_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(ByteUtil.less(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#lessOrEquals(byte[], byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#lessOrEquals(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteUtil.lessOrEquals(byte[], byte[])"})
  public void testLessOrEquals_whenAxaxaxaxBytesIsUtf8_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(ByteUtil.lessOrEquals(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#lessOrEquals(byte[], byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#lessOrEquals(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteUtil.lessOrEquals(byte[], byte[])"})
  public void testLessOrEquals_whenXaxaxaxBytesIsUtf8_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(ByteUtil.lessOrEquals(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#lessOrEquals(byte[], byte[])}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#lessOrEquals(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteUtil.lessOrEquals(byte[], byte[])"})
  public void testLessOrEquals_whenXxaxaxaxBytesIsUtf8_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "XXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(ByteUtil.lessOrEquals(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#equals(byte[], byte[])} with {@code byte[]}, {@code byte[]}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#equals(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteUtil.equals(byte[], byte[])"})
  public void testEqualsWithByteByte_whenAxaxaxaxBytesIsUtf8_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(ByteUtil.equals(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#equals(byte[], byte[])} with {@code byte[]}, {@code byte[]}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#equals(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteUtil.equals(byte[], byte[])"})
  public void testEqualsWithByteByte_whenXaxaxaxBytesIsUtf8_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(ByteUtil.equals(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#isNullOrZeroArray(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#isNullOrZeroArray(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteUtil.isNullOrZeroArray(byte[])"})
  public void testIsNullOrZeroArray_whenAxaxaxaxBytesIsUtf8_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(ByteUtil.isNullOrZeroArray("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#isNullOrZeroArray(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#isNullOrZeroArray(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteUtil.isNullOrZeroArray(byte[])"})
  public void testIsNullOrZeroArray_whenEmptyArrayOfByte_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ByteUtil.isNullOrZeroArray(new byte[]{}));
  }

  /**
   * Test {@link ByteUtil#isNullOrZeroArray(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#isNullOrZeroArray(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteUtil.isNullOrZeroArray(byte[])"})
  public void testIsNullOrZeroArray_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ByteUtil.isNullOrZeroArray(null));
  }

  /**
   * Test {@link ByteUtil#compare(byte[], byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#compare(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteUtil.compare(byte[], byte[])"})
  public void testCompare_whenAxaxaxaxBytesIsUtf8_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, ByteUtil.compare(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#compare(byte[], byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return minus fifty-seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#compare(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteUtil.compare(byte[], byte[])"})
  public void testCompare_whenXaxaxaxBytesIsUtf8_thenReturnMinusFiftySeven() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-57, ByteUtil.compare(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#hexToBytes(String)}.
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.</li>
   *   <li>Then return array of {@code byte} with one and {@code #}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#hexToBytes(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.hexToBytes(String)"})
  public void testHexToBytes_when0123456789abcdef_thenReturnArrayOfByteWithOneAndNumberSign() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{1, '#', 'E', 'g', -119, -85, -51, -17}, ByteUtil.hexToBytes("0123456789ABCDEF"));
  }

  /**
   * Test {@link ByteUtil#convertBytesVectorToVector(byte[])}.
   * <p>
   * Method under test: {@link ByteUtil#convertBytesVectorToVector(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ByteUtil.convertBytesVectorToVector(byte[])"})
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
   * Test {@link ByteUtil#reverse(byte[])}.
   * <p>
   * Method under test: {@link ByteUtil#reverse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ByteUtil.reverse(byte[])"})
  public void testReverse() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ByteUtil.reverse(bytes);

    // Assert
    assertArrayEquals("XAXAXAXA".getBytes("UTF-8"), bytes);
  }

  /**
   * Test {@link ByteUtil#longTo32Bytes(long)}.
   * <ul>
   *   <li>When forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#longTo32Bytes(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.longTo32Bytes(long)"})
  public void testLongTo32Bytes_whenFortyTwo() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        ByteUtil.longTo32Bytes(42L));
  }

  /**
   * Test {@link ByteUtil#longTo32Bytes(long)}.
   * <ul>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#longTo32Bytes(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.longTo32Bytes(long)"})
  public void testLongTo32Bytes_whenZero() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        ByteUtil.longTo32Bytes(0L));
  }

  /**
   * Test {@link ByteUtil#setBit(byte[], int, int)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code AXAXAXAZ} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#setBit(byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.setBit(byte[], int, int)"})
  public void testSetBit_whenA_thenReturnAxaxaxazBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    byte[] data = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    byte[] actualSetBitResult = ByteUtil.setBit(data, 1, 1);

    // Assert
    assertArrayEquals("AXAXAXAZ".getBytes("UTF-8"), actualSetBitResult);
    assertArrayEquals("AXAXAXAZ".getBytes("UTF-8"), data);
  }

  /**
   * Test {@link ByteUtil#setBit(byte[], int, int)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#setBit(byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.setBit(byte[], int, int)"})
  public void testSetBit_whenAxaxaxaxBytesIsUtf8_thenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualSetBitResult = ByteUtil.setBit(data, 1, DecodeUtil.ADDRESS_SIZE);

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), data);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSetBitResult);
  }

  /**
   * Test {@link ByteUtil#setBit(byte[], int, int)}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then throw {@link Error}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#setBit(byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.setBit(byte[], int, int)"})
  public void testSetBit_whenEmptyArrayOfByte_thenThrowError() {
    // Arrange, Act and Assert
    assertThrows(Error.class, () -> ByteUtil.setBit(new byte[]{}, 1, DecodeUtil.ADDRESS_SIZE));
  }

  /**
   * Test {@link ByteUtil#compress(byte[])}.
   * <p>
   * Method under test: {@link ByteUtil#compress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteUtil.compress(byte[])"})
  public void testCompress() throws UnsupportedEncodingException, EventBloomException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'x', -100, 's', -116, 'p', 4, 'C', 0, '\n', -100, 2, 'e'},
        ByteUtil.compress("AXAXAXAX".getBytes("UTF-8")));
  }
}
