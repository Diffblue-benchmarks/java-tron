package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TypeConversionDiffblueTest {
  /**
   * Test {@link TypeConversion#longToBytes(long)}.
   * <p>
   * Method under test: {@link TypeConversion#longToBytes(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TypeConversion.longToBytes(long)"})
  public void testLongToBytes() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 1}, TypeConversion.longToBytes(1L));
  }

  /**
   * Test {@link TypeConversion#bytesToLong(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 4708585257725083992}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeConversion#bytesToLong(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TypeConversion.bytesToLong(byte[])"})
  public void testBytesToLong_whenAxaxaxaxBytesIsUtf8_thenReturn4708585257725083992()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(4708585257725083992L, TypeConversion.bytesToLong("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TypeConversion#bytesToHexString(byte[])}.
   * <p>
   * Method under test: {@link TypeConversion#bytesToHexString(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TypeConversion.bytesToHexString(byte[])"})
  public void testBytesToHexString() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("4158415841584158", TypeConversion.bytesToHexString("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TypeConversion#hexStringToBytes(String)}.
   * <ul>
   *   <li>Then return array of {@code byte} with one and {@code #}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeConversion#hexStringToBytes(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TypeConversion.hexStringToBytes(String)"})
  public void testHexStringToBytes_thenReturnArrayOfByteWithOneAndNumberSign() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{1, '#', 'E', 'g', -119, -85, -51, -17},
        TypeConversion.hexStringToBytes("0123456789ABCDEF"));
  }

  /**
   * Test {@link TypeConversion#hexStringToBytes(String)}.
   * <ul>
   *   <li>When {@code Hex String}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeConversion#hexStringToBytes(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TypeConversion.hexStringToBytes(String)"})
  public void testHexStringToBytes_whenHexString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TypeConversion.hexStringToBytes("Hex String"));
  }

  /**
   * Test {@link TypeConversion#hexStringToBytes(String)}.
   * <ul>
   *   <li>When {@code utils}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeConversion#hexStringToBytes(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TypeConversion.hexStringToBytes(String)"})
  public void testHexStringToBytes_whenUtils_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TypeConversion.hexStringToBytes("utils"));
  }

  /**
   * Test {@link TypeConversion#increment(byte[])}.
   * <ul>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8} is {@code AXAXAXAY} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeConversion#increment(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TypeConversion.increment(byte[])"})
  public void testIncrement_thenAxaxaxaxBytesIsUtf8IsAxaxaxayBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(TypeConversion.increment(bytes));
    assertArrayEquals("AXAXAXAY".getBytes("UTF-8"), bytes);
  }

  /**
   * Test {@link TypeConversion#increment(byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeConversion#increment(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TypeConversion.increment(byte[])"})
  public void testIncrement_whenA_thenArrayOfByteWithAAndX() {
    // Arrange
    byte[] bytes = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', -1};

    // Act and Assert
    assertTrue(TypeConversion.increment(bytes));
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'B', 0}, bytes);
  }
}
