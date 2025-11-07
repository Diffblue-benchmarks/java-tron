package org.tron.plugins.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class ByteArrayDiffblueTest {
  /**
   * Method under test: {@link ByteArray#fromString(String)}
   */
  @Test
  public void testFromString() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualFromStringResult = ByteArray.fromString("foo");

    // Assert
    assertArrayEquals("foo".getBytes("UTF-8"), actualFromStringResult);
  }

  /**
   * Method under test: {@link ByteArray#fromString(String)}
   */
  @Test
  public void testFromString2() {
    // Arrange, Act and Assert
    assertNull(ByteArray.fromString(null));
  }

  /**
   * Method under test: {@link ByteArray#fromString(String)}
   */
  @Test
  public void testFromString3() {
    // Arrange, Act and Assert
    assertNull(ByteArray.fromString(""));
  }

  /**
   * Method under test: {@link ByteArray#toStr(byte[])}
   */
  @Test
  public void testToStr() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("AXAXAXAX", ByteArray.toStr("AXAXAXAX".getBytes("UTF-8")));
    assertNull(ByteArray.toStr(null));
    assertNull(ByteArray.toStr(new byte[]{}));
  }

  /**
   * Method under test: {@link ByteArray#fromLong(long)}
   */
  @Test
  public void testFromLong() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, '*'}, ByteArray.fromLong(42L));
  }

  /**
   * Method under test: {@link ByteArray#toLong(byte[])}
   */
  @Test
  public void testToLong() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(4708585257725083992L, ByteArray.toLong("AXAXAXAX".getBytes("UTF-8")));
    assertEquals(0L, ByteArray.toLong(null));
    assertEquals(0L, ByteArray.toLong(new byte[]{}));
  }

  /**
   * Method under test: {@link ByteArray#fromInt(int)}
   */
  @Test
  public void testFromInt() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, '*'}, ByteArray.fromInt(42));
  }

  /**
   * Method under test: {@link ByteArray#toInt(byte[])}
   */
  @Test
  public void testToInt() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1096302936, ByteArray.toInt("AXAXAXAX".getBytes("UTF-8")));
    assertEquals(0, ByteArray.toInt(null));
    assertEquals(0, ByteArray.toInt(new byte[]{}));
  }

  /**
   * Method under test: {@link ByteArray#compareUnsigned(byte[], byte[])}
   */
  @Test
  public void testCompareUnsigned() throws UnsupportedEncodingException {
    // Arrange
    byte[] a = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, ByteArray.compareUnsigned(a, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteArray#compareUnsigned(byte[], byte[])}
   */
  @Test
  public void testCompareUnsigned2() {
    // Arrange, Act and Assert
    assertEquals(0, ByteArray.compareUnsigned(null, null));
  }

  /**
   * Method under test: {@link ByteArray#compareUnsigned(byte[], byte[])}
   */
  @Test
  public void testCompareUnsigned3() {
    // Arrange, Act and Assert
    assertEquals(-1, ByteArray.compareUnsigned(null, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link ByteArray#compareUnsigned(byte[], byte[])}
   */
  @Test
  public void testCompareUnsigned4() {
    // Arrange, Act and Assert
    assertEquals(1, ByteArray.compareUnsigned(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, null));
  }

  /**
   * Method under test: {@link ByteArray#compareUnsigned(byte[], byte[])}
   */
  @Test
  public void testCompareUnsigned5() throws UnsupportedEncodingException {
    // Arrange
    byte[] a = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, ByteArray.compareUnsigned(a, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteArray#compareUnsigned(byte[], byte[])}
   */
  @Test
  public void testCompareUnsigned6() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1,
        ByteArray.compareUnsigned(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteArray#compareUnsigned(byte[], byte[])}
   */
  @Test
  public void testCompareUnsigned7() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(-1, ByteArray.compareUnsigned(new byte[]{}, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteArray#compareUnsigned(byte[], byte[])}
   */
  @Test
  public void testCompareUnsigned8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1, ByteArray.compareUnsigned("AXAXAXAX".getBytes("UTF-8"), new byte[]{}));
  }

  /**
   * Method under test: {@link ByteArray#toHexString(byte[])}
   */
  @Test
  public void testToHexString() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("4158415841584158", ByteArray.toHexString("AXAXAXAX".getBytes("UTF-8")));
    assertEquals("", ByteArray.toHexString(null));
    assertEquals("5858415841584158", ByteArray.toHexString("XXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteArray#fromHexString(String)}
   */
  @Test
  public void testFromHexString() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{1, '#', 'E', 'g', -119, -85, -51, -17}, ByteArray.fromHexString("0123456789ABCDEF"));
    assertEquals(0, ByteArray.fromHexString("0x").length);
    assertEquals(0, ByteArray.fromHexString(null).length);
  }
}
