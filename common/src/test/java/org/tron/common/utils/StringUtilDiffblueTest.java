package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StringUtilDiffblueTest {
  /**
   * Test {@link StringUtil#createDbKey(ByteString)}.
   * <p>
   * Method under test: {@link StringUtil#createDbKey(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] StringUtil.createDbKey(ByteString)"})
  public void testCreateDbKey() throws UnsupportedEncodingException {
    // Arrange
    ByteString string = mock(ByteString.class);
    when(string.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualCreateDbKeyResult = StringUtil.createDbKey(string);

    // Assert
    verify(string).toByteArray();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCreateDbKeyResult);
  }

  /**
   * Test {@link StringUtil#createReadableString(byte[])} with {@code bytes}.
   * <ul>
   *   <li>Then return {@code 4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#createReadableString(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StringUtil.createReadableString(byte[])"})
  public void testCreateReadableStringWithBytes_thenReturn4158415841584158() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("4158415841584158", StringUtil.createReadableString("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link StringUtil#createReadableString(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#createReadableString(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StringUtil.createReadableString(byte[])"})
  public void testCreateReadableStringWithBytes_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.createReadableString((byte[]) null));
  }

  /**
   * Test {@link StringUtil#createReadableString(ByteString)} with {@code string}.
   * <p>
   * Method under test: {@link StringUtil#createReadableString(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StringUtil.createReadableString(ByteString)"})
  public void testCreateReadableStringWithString() throws UnsupportedEncodingException {
    // Arrange
    ByteString string = mock(ByteString.class);
    when(string.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualCreateReadableStringResult = StringUtil.createReadableString(string);

    // Assert
    verify(string).toByteArray();
    assertEquals("4158415841584158", actualCreateReadableStringResult);
  }

  /**
   * Test {@link StringUtil#hexString2ByteString(String)}.
   * <ul>
   *   <li>When {@code 0x}.</li>
   *   <li>Then return toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#hexString2ByteString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString StringUtil.hexString2ByteString(String)"})
  public void testHexString2ByteString_when0x_thenReturnToStringUtf8IsEmptyString() {
    // Arrange and Act
    ByteString actualHexString2ByteStringResult = StringUtil.hexString2ByteString("0x");

    // Assert
    assertEquals("", actualHexString2ByteStringResult.toStringUtf8());
    assertFalse(actualHexString2ByteStringResult.iterator().hasNext());
    assertTrue(actualHexString2ByteStringResult.isEmpty());
  }
}
