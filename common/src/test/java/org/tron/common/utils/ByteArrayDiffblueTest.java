package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.JsonRpcInvalidParamsException;

public class ByteArrayDiffblueTest {
  /**
   * Test {@link ByteArray#toHexString(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#toHexString(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ByteArray.toHexString(byte[])"})
  public void testToHexString_whenAxaxaxaxBytesIsUtf8_thenReturn4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("4158415841584158", ByteArray.toHexString("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteArray#toHexString(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#toHexString(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ByteArray.toHexString(byte[])"})
  public void testToHexString_whenEmptyArrayOfByte_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ByteArray.toHexString(new byte[] {}));
  }

  /**
   * Test {@link ByteArray#toHexString(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#toHexString(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ByteArray.toHexString(byte[])"})
  public void testToHexString_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ByteArray.toHexString(null));
  }

  /**
   * Test {@link ByteArray#fromHexString(String)}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#fromHexString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArray.fromHexString(String)"})
  public void testFromHexString_when0x_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, ByteArray.fromHexString("0x"));
  }

  /**
   * Test {@link ByteArray#fromHexString(String)}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return array of {@code byte} with one and {@code #}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#fromHexString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArray.fromHexString(String)"})
  public void testFromHexString_when0123456789abcdef_thenReturnArrayOfByteWithOneAndNumberSign() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {1, '#', 'E', 'g', -119, -85, -51, -17},
        ByteArray.fromHexString("0123456789ABCDEF"));
  }

  /**
   * Test {@link ByteArray#fromHexString(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#fromHexString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArray.fromHexString(String)"})
  public void testFromHexString_whenNull_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, ByteArray.fromHexString(null));
  }

  /**
   * Test {@link ByteArray#toLong(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 4708585257725083992}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#toLong(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ByteArray.toLong(byte[])"})
  public void testToLong_whenAxaxaxaxBytesIsUtf8_thenReturn4708585257725083992()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(4708585257725083992L, ByteArray.toLong("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteArray#toLong(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#toLong(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ByteArray.toLong(byte[])"})
  public void testToLong_whenEmptyArrayOfByte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, ByteArray.toLong(new byte[] {}));
  }

  /**
   * Test {@link ByteArray#toLong(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#toLong(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ByteArray.toLong(byte[])"})
  public void testToLong_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, ByteArray.toLong(null));
  }

  /**
   * Test {@link ByteArray#toInt(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 1096302936}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#toInt(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ByteArray.toInt(byte[])"})
  public void testToInt_whenAxaxaxaxBytesIsUtf8_thenReturn1096302936()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1096302936, ByteArray.toInt("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteArray#toInt(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#toInt(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ByteArray.toInt(byte[])"})
  public void testToInt_whenEmptyArrayOfByte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ByteArray.toInt(new byte[] {}));
  }

  /**
   * Test {@link ByteArray#toInt(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#toInt(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ByteArray.toInt(byte[])"})
  public void testToInt_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ByteArray.toInt(null));
  }

  /**
   * Test {@link ByteArray#fromString(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#fromString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArray.fromString(String)"})
  public void testFromString_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ByteArray.fromString(""));
  }

  /**
   * Test {@link ByteArray#fromString(String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return {@code foo} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#fromString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArray.fromString(String)"})
  public void testFromString_whenFoo_thenReturnFooBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals("foo".getBytes("UTF-8"), ByteArray.fromString("foo"));
  }

  /**
   * Test {@link ByteArray#fromString(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#fromString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArray.fromString(String)"})
  public void testFromString_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ByteArray.fromString(null));
  }

  /**
   * Test {@link ByteArray#fromString(String)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#fromString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArray.fromString(String)"})
  public void testFromString_whenSpace_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ByteArray.fromString(" "));
  }

  /**
   * Test {@link ByteArray#toStr(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code AXAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#toStr(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ByteArray.toStr(byte[])"})
  public void testToStr_whenAxaxaxaxBytesIsUtf8_thenReturnAxaxaxax()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("AXAXAXAX", ByteArray.toStr("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteArray#toStr(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#toStr(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ByteArray.toStr(byte[])"})
  public void testToStr_whenEmptyArrayOfByte_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ByteArray.toStr(new byte[] {}));
  }

  /**
   * Test {@link ByteArray#toStr(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#toStr(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ByteArray.toStr(byte[])"})
  public void testToStr_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ByteArray.toStr(null));
  }

  /**
   * Test {@link ByteArray#fromLong(long)}.
   *
   * <p>Method under test: {@link ByteArray#fromLong(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArray.fromLong(long)"})
  public void testFromLong() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {0, 0, 0, 0, 0, 0, 0, '*'}, ByteArray.fromLong(42L));
  }

  /**
   * Test {@link ByteArray#fromInt(int)}.
   *
   * <p>Method under test: {@link ByteArray#fromInt(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArray.fromInt(int)"})
  public void testFromInt() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {0, 0, 0, '*'}, ByteArray.fromInt(DecodeUtil.ADDRESS_SIZE));
  }

  /**
   * Test {@link ByteArray#fromObject(Object)}.
   *
   * <p>Method under test: {@link ByteArray#fromObject(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArray.fromObject(Object)"})
  public void testFromObject() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {-84, -19, 0, 5, 't', 0, 3, 'O', 'b', 'j'}, ByteArray.fromObject("Obj"));
  }

  /**
   * Test {@link ByteArray#toJsonHex(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 0x4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#toJsonHex(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ByteArray.toJsonHex(byte[])"})
  public void testToJsonHexWithByte_whenAxaxaxaxBytesIsUtf8_thenReturn0x4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x4158415841584158", ByteArray.toJsonHex("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteArray#toJsonHex(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code 0x}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#toJsonHex(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ByteArray.toJsonHex(byte[])"})
  public void testToJsonHexWithByte_whenEmptyArrayOfByte_thenReturn0x() {
    // Arrange, Act and Assert
    assertEquals("0x", ByteArray.toJsonHex(new byte[] {}));
  }

  /**
   * Test {@link ByteArray#toJsonHex(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code 0x}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#toJsonHex(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ByteArray.toJsonHex(byte[])"})
  public void testToJsonHexWithByte_whenNull_thenReturn0x() {
    // Arrange, Act and Assert
    assertEquals("0x", ByteArray.toJsonHex((byte[]) null));
  }

  /**
   * Test {@link ByteArray#toJsonHex(int)} with {@code int}.
   *
   * <p>Method under test: {@link ByteArray#toJsonHex(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ByteArray.toJsonHex(int)"})
  public void testToJsonHexWithInt() {
    // Arrange, Act and Assert
    assertEquals("0x2", ByteArray.toJsonHex(2));
  }

  /**
   * Test {@link ByteArray#toJsonHex(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#toJsonHex(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ByteArray.toJsonHex(Long)"})
  public void testToJsonHexWithLong_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ByteArray.toJsonHex((Long) null));
  }

  /**
   * Test {@link ByteArray#toJsonHex(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 0x1}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#toJsonHex(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ByteArray.toJsonHex(Long)"})
  public void testToJsonHexWithLong_whenOne_thenReturn0x1() {
    // Arrange, Act and Assert
    assertEquals("0x1", ByteArray.toJsonHex(1L));
  }

  /**
   * Test {@link ByteArray#toJsonHex(String)} with {@code String}.
   *
   * <p>Method under test: {@link ByteArray#toJsonHex(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ByteArray.toJsonHex(String)"})
  public void testToJsonHexWithString() {
    // Arrange, Act and Assert
    assertEquals("0x0123456789ABCDEF", ByteArray.toJsonHex("0123456789ABCDEF"));
  }

  /**
   * Test {@link ByteArray#toJsonHexAddress(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 0x58415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#toJsonHexAddress(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ByteArray.toJsonHexAddress(byte[])"})
  public void testToJsonHexAddress_whenAxaxaxaxBytesIsUtf8_thenReturn0x58415841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x58415841584158", ByteArray.toJsonHexAddress("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteArray#toJsonHexAddress(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#toJsonHexAddress(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ByteArray.toJsonHexAddress(byte[])"})
  public void testToJsonHexAddress_whenEmptyArrayOfByte_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ByteArray.toJsonHexAddress(new byte[] {}));
  }

  /**
   * Test {@link ByteArray#toJsonHexAddress(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#toJsonHexAddress(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ByteArray.toJsonHexAddress(byte[])"})
  public void testToJsonHexAddress_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ByteArray.toJsonHexAddress(null));
  }

  /**
   * Test {@link ByteArray#toJsonHexAddress(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 0x0858415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#toJsonHexAddress(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ByteArray.toJsonHexAddress(byte[])"})
  public void testToJsonHexAddress_whenXaxaxaxBytesIsUtf8_thenReturn0x0858415841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("0x0858415841584158", ByteArray.toJsonHexAddress("\bXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteArray#hexToBigInteger(String)}.
   *
   * <ul>
   *   <li>When {@code 0x0123456789ABCDEF}.
   *   <li>Then return toString is {@code 81985529216486895}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#hexToBigInteger(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigInteger ByteArray.hexToBigInteger(String)"})
  public void testHexToBigInteger_when0x0123456789ABCDEF_thenReturnToStringIs81985529216486895() {
    // Arrange and Act
    BigInteger actualHexToBigIntegerResult = ByteArray.hexToBigInteger("0x0123456789ABCDEF");

    // Assert
    assertEquals("81985529216486895", actualHexToBigIntegerResult.toString());
    assertEquals(0, actualHexToBigIntegerResult.getLowestSetBit());
    assertEquals(1, actualHexToBigIntegerResult.signum());
    assertArrayEquals(
        new byte[] {1, '#', 'E', 'g', -119, -85, -51, -17},
        actualHexToBigIntegerResult.toByteArray());
  }

  /**
   * Test {@link ByteArray#hexToBigInteger(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return toString is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#hexToBigInteger(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigInteger ByteArray.hexToBigInteger(String)"})
  public void testHexToBigInteger_when42_thenReturnToStringIs42() {
    // Arrange and Act
    BigInteger actualHexToBigIntegerResult = ByteArray.hexToBigInteger("42");

    // Assert
    assertEquals("42", actualHexToBigIntegerResult.toString());
    assertEquals(1, actualHexToBigIntegerResult.getLowestSetBit());
    assertEquals(1, actualHexToBigIntegerResult.signum());
    assertArrayEquals(new byte[] {'*'}, actualHexToBigIntegerResult.toByteArray());
  }

  /**
   * Test {@link ByteArray#jsonHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code 0x0123456789ABCDEF}.
   *   <li>Then return {@code 81985529216486895}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#jsonHexToLong(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ByteArray.jsonHexToLong(String)"})
  public void testJsonHexToLong_when0x0123456789ABCDEF_thenReturn81985529216486895()
      throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertEquals(81985529216486895L, ByteArray.jsonHexToLong("0x0123456789ABCDEF"));
  }

  /**
   * Test {@link ByteArray#jsonHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then throw {@link JsonRpcInvalidParamsException}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#jsonHexToLong(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ByteArray.jsonHexToLong(String)"})
  public void testJsonHexToLong_when0123456789abcdef_thenThrowJsonRpcInvalidParamsException()
      throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertThrows(
        JsonRpcInvalidParamsException.class, () -> ByteArray.jsonHexToLong("0123456789ABCDEF"));
  }

  /**
   * Test {@link ByteArray#jsonHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code 0x42}.
   *   <li>Then return sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#jsonHexToInt(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ByteArray.jsonHexToInt(String)"})
  public void testJsonHexToInt_when0x42_thenReturnSixtySix() throws Exception {
    // Arrange, Act and Assert
    assertEquals(66, ByteArray.jsonHexToInt("0x42"));
  }

  /**
   * Test {@link ByteArray#jsonHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then throw {@link Exception}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#jsonHexToInt(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ByteArray.jsonHexToInt(String)"})
  public void testJsonHexToInt_when0123456789abcdef_thenThrowException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(Exception.class, () -> ByteArray.jsonHexToInt("0123456789ABCDEF"));
  }

  /**
   * Test {@link ByteArray#subArray(byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return array of {@code byte} with {@code X} and {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#subArray(byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArray.subArray(byte[], int, int)"})
  public void testSubArray_whenAxaxaxaxBytesIsUtf8_thenReturnArrayOfByteWithXAndA()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {'X', 'A'}, ByteArray.subArray("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link ByteArray#isEmpty(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#isEmpty(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteArray.isEmpty(byte[])"})
  public void testIsEmpty_whenAxaxaxaxBytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(ByteArray.isEmpty("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteArray#isEmpty(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#isEmpty(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteArray.isEmpty(byte[])"})
  public void testIsEmpty_whenEmptyArrayOfByte_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ByteArray.isEmpty(new byte[] {}));
  }

  /**
   * Test {@link ByteArray#isEmpty(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#isEmpty(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteArray.isEmpty(byte[])"})
  public void testIsEmpty_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ByteArray.isEmpty(null));
  }

  /**
   * Test {@link ByteArray#matrixContains(List, byte[])}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When {@link ArrayList#ArrayList()} add array of {@code byte} with {@code A} and one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#matrixContains(List, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteArray.matrixContains(List, byte[])"})
  public void testMatrixContains_givenA_whenArrayListAddArrayOfByteWithAAndOne_thenReturnTrue()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<byte[]> source = new ArrayList<>();
    source.add(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    source.add("AXAXAXAX".getBytes("UTF-8"));

    // Act
    boolean actualMatrixContainsResult =
        ByteArray.matrixContains(source, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualMatrixContainsResult);
  }

  /**
   * Test {@link ByteArray#matrixContains(List, byte[])}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#matrixContains(List, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteArray.matrixContains(List, byte[])"})
  public void testMatrixContains_givenAxaxaxaxBytesIsUtf8_thenReturnTrue()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<byte[]> source = new ArrayList<>();
    source.add("AXAXAXAX".getBytes("UTF-8"));

    // Act
    boolean actualMatrixContainsResult =
        ByteArray.matrixContains(source, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualMatrixContainsResult);
  }

  /**
   * Test {@link ByteArray#matrixContains(List, byte[])}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#matrixContains(List, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteArray.matrixContains(List, byte[])"})
  public void testMatrixContains_whenArrayList_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange and Act
    boolean actualMatrixContainsResult =
        ByteArray.matrixContains(new ArrayList<>(), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertFalse(actualMatrixContainsResult);
  }

  /**
   * Test {@link ByteArray#fromHex(String)}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#fromHex(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ByteArray.fromHex(String)"})
  public void testFromHex_when0x_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ByteArray.fromHex("0x"));
  }

  /**
   * Test {@link ByteArray#fromHex(String)}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#fromHex(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ByteArray.fromHex(String)"})
  public void testFromHex_when0123456789abcdef_thenReturn0123456789abcdef() {
    // Arrange, Act and Assert
    assertEquals("0123456789ABCDEF", ByteArray.fromHex("0123456789ABCDEF"));
  }

  /**
   * Test {@link ByteArray#fromHex(String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return {@code 0foo}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArray#fromHex(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ByteArray.fromHex(String)"})
  public void testFromHex_whenFoo_thenReturn0foo() {
    // Arrange, Act and Assert
    assertEquals("0foo", ByteArray.fromHex("foo"));
  }
}
