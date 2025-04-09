package org.tron.plugins.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ByteArrayDiffblueTest {
  /**
   * Test {@link ByteArray#fromString(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#fromString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteArray.fromString(String)"})
  public void testFromString_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ByteArray.fromString(""));
  }

  /**
   * Test {@link ByteArray#fromString(String)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return {@code foo} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#fromString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteArray.fromString(String)"})
  public void testFromString_whenFoo_thenReturnFooBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualFromStringResult = ByteArray.fromString("foo");

    // Assert
    assertArrayEquals("foo".getBytes("UTF-8"), actualFromStringResult);
  }

  /**
   * Test {@link ByteArray#fromString(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#fromString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteArray.fromString(String)"})
  public void testFromString_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ByteArray.fromString(null));
  }

  /**
   * Test {@link ByteArray#fromString(String)}.
   * <ul>
   *   <li>When space.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#fromString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteArray.fromString(String)"})
  public void testFromString_whenSpace_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ByteArray.fromString(" "));
  }

  /**
   * Test {@link ByteArray#toStr(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code AXAXAXAX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#toStr(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ByteArray.toStr(byte[])"})
  public void testToStr_whenAxaxaxaxBytesIsUtf8_thenReturnAxaxaxax() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("AXAXAXAX", ByteArray.toStr("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteArray#toStr(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#toStr(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ByteArray.toStr(byte[])"})
  public void testToStr_whenEmptyArrayOfByte_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ByteArray.toStr(new byte[]{}));
  }

  /**
   * Test {@link ByteArray#toStr(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#toStr(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ByteArray.toStr(byte[])"})
  public void testToStr_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ByteArray.toStr(null));
  }

  /**
   * Test {@link ByteArray#fromLong(long)}.
   * <p>
   * Method under test: {@link ByteArray#fromLong(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteArray.fromLong(long)"})
  public void testFromLong() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, '*'}, ByteArray.fromLong(42L));
  }

  /**
   * Test {@link ByteArray#toLong(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 4708585257725083992}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#toLong(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ByteArray.toLong(byte[])"})
  public void testToLong_whenAxaxaxaxBytesIsUtf8_thenReturn4708585257725083992() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(4708585257725083992L, ByteArray.toLong("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteArray#toLong(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#toLong(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ByteArray.toLong(byte[])"})
  public void testToLong_whenEmptyArrayOfByte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, ByteArray.toLong(new byte[]{}));
  }

  /**
   * Test {@link ByteArray#toLong(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#toLong(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ByteArray.toLong(byte[])"})
  public void testToLong_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, ByteArray.toLong(null));
  }

  /**
   * Test {@link ByteArray#fromInt(int)}.
   * <p>
   * Method under test: {@link ByteArray#fromInt(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteArray.fromInt(int)"})
  public void testFromInt() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, '*'}, ByteArray.fromInt(42));
  }

  /**
   * Test {@link ByteArray#toInt(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 1096302936}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#toInt(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteArray.toInt(byte[])"})
  public void testToInt_whenAxaxaxaxBytesIsUtf8_thenReturn1096302936() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1096302936, ByteArray.toInt("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteArray#toInt(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#toInt(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteArray.toInt(byte[])"})
  public void testToInt_whenEmptyArrayOfByte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ByteArray.toInt(new byte[]{}));
  }

  /**
   * Test {@link ByteArray#toInt(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#toInt(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteArray.toInt(byte[])"})
  public void testToInt_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ByteArray.toInt(null));
  }

  /**
   * Test {@link ByteArray#compareUnsigned(byte[], byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and {@code X}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#compareUnsigned(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteArray.compareUnsigned(byte[], byte[])"})
  public void testCompareUnsigned_whenArrayOfByteWithAAndX_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, ByteArray.compareUnsigned(null, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link ByteArray#compareUnsigned(byte[], byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and {@code X}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#compareUnsigned(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteArray.compareUnsigned(byte[], byte[])"})
  public void testCompareUnsigned_whenArrayOfByteWithAAndX_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, ByteArray.compareUnsigned(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, null));
  }

  /**
   * Test {@link ByteArray#compareUnsigned(byte[], byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#compareUnsigned(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteArray.compareUnsigned(byte[], byte[])"})
  public void testCompareUnsigned_whenArrayOfByteWithMinusOneAndX_thenReturnOne() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1,
        ByteArray.compareUnsigned(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteArray#compareUnsigned(byte[], byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#compareUnsigned(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteArray.compareUnsigned(byte[], byte[])"})
  public void testCompareUnsigned_whenAxaxaxaxBytesIsUtf8_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] a = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, ByteArray.compareUnsigned(a, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteArray#compareUnsigned(byte[], byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#compareUnsigned(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteArray.compareUnsigned(byte[], byte[])"})
  public void testCompareUnsigned_whenEmptyArrayOfByte_thenReturnMinusOne() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(-1, ByteArray.compareUnsigned(new byte[]{}, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteArray#compareUnsigned(byte[], byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#compareUnsigned(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteArray.compareUnsigned(byte[], byte[])"})
  public void testCompareUnsigned_whenEmptyArrayOfByte_thenReturnOne() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1, ByteArray.compareUnsigned("AXAXAXAX".getBytes("UTF-8"), new byte[]{}));
  }

  /**
   * Test {@link ByteArray#compareUnsigned(byte[], byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#compareUnsigned(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteArray.compareUnsigned(byte[], byte[])"})
  public void testCompareUnsigned_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ByteArray.compareUnsigned(null, null));
  }

  /**
   * Test {@link ByteArray#compareUnsigned(byte[], byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#compareUnsigned(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteArray.compareUnsigned(byte[], byte[])"})
  public void testCompareUnsigned_whenXaxaxaxBytesIsUtf8_thenReturnMinusOne() throws UnsupportedEncodingException {
    // Arrange
    byte[] a = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, ByteArray.compareUnsigned(a, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteArray#toHexString(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#toHexString(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ByteArray.toHexString(byte[])"})
  public void testToHexString_whenAxaxaxaxBytesIsUtf8_thenReturn4158415841584158() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("4158415841584158", ByteArray.toHexString("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteArray#toHexString(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#toHexString(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ByteArray.toHexString(byte[])"})
  public void testToHexString_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ByteArray.toHexString(null));
  }

  /**
   * Test {@link ByteArray#toHexString(byte[])}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 5858415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#toHexString(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ByteArray.toHexString(byte[])"})
  public void testToHexString_whenXxaxaxaxBytesIsUtf8_thenReturn5858415841584158() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("5858415841584158", ByteArray.toHexString("XXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteArray#fromHexString(String)}.
   * <ul>
   *   <li>When {@code 0x}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#fromHexString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteArray.fromHexString(String)"})
  public void testFromHexString_when0x_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, ByteArray.fromHexString("0x"));
  }

  /**
   * Test {@link ByteArray#fromHexString(String)}.
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.</li>
   *   <li>Then return array of {@code byte} with one and {@code #}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#fromHexString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteArray.fromHexString(String)"})
  public void testFromHexString_when0123456789abcdef_thenReturnArrayOfByteWithOneAndNumberSign() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{1, '#', 'E', 'g', -119, -85, -51, -17}, ByteArray.fromHexString("0123456789ABCDEF"));
  }

  /**
   * Test {@link ByteArray#fromHexString(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteArray#fromHexString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ByteArray.fromHexString(String)"})
  public void testFromHexString_whenNull_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, ByteArray.fromHexString(null));
  }
}
