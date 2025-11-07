package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class TypeConversionDiffblueTest {
  /**
   * Method under test: {@link TypeConversion#longToBytes(long)}
   */
  @Test
  public void testLongToBytes() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 1}, TypeConversion.longToBytes(1L));
  }

  /**
   * Method under test: {@link TypeConversion#bytesToLong(byte[])}
   */
  @Test
  public void testBytesToLong() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(4708585257725083992L, TypeConversion.bytesToLong("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link TypeConversion#bytesToHexString(byte[])}
   */
  @Test
  public void testBytesToHexString() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("4158415841584158", TypeConversion.bytesToHexString("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link TypeConversion#hexStringToBytes(String)}
   */
  @Test
  public void testHexStringToBytes() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{1, '#', 'E', 'g', -119, -85, -51, -17},
        TypeConversion.hexStringToBytes("0123456789ABCDEF"));
    assertNull(TypeConversion.hexStringToBytes("Hex String"));
    assertNull(TypeConversion.hexStringToBytes("utils"));
  }

  /**
   * Method under test: {@link TypeConversion#increment(byte[])}
   */
  @Test
  public void testIncrement() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(8, bytes.length);
    assertTrue(TypeConversion.increment(bytes));
    assertEquals('Y', bytes[7]);
  }
}
