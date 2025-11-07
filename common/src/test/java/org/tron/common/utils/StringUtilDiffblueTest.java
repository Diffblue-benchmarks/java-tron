package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class StringUtilDiffblueTest {
  /**
   * Method under test: {@link StringUtil#createDbKey(ByteString)}
   */
  @Test
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
   * Method under test: {@link StringUtil#createReadableString(ByteString)}
   */
  @Test
  public void testCreateReadableString() throws UnsupportedEncodingException {
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
   * Method under test: {@link StringUtil#createReadableString(byte[])}
   */
  @Test
  public void testCreateReadableString2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("4158415841584158", StringUtil.createReadableString("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link StringUtil#createReadableString(byte[])}
   */
  @Test
  public void testCreateReadableString3() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.createReadableString((byte[]) null));
  }

  /**
   * Method under test: {@link StringUtil#hexString2ByteString(String)}
   */
  @Test
  public void testHexString2ByteString() {
    // Arrange and Act
    ByteString actualHexString2ByteStringResult = StringUtil.hexString2ByteString("0x");

    // Assert
    assertEquals("", actualHexString2ByteStringResult.toStringUtf8());
    assertFalse(actualHexString2ByteStringResult.iterator().hasNext());
    assertTrue(actualHexString2ByteStringResult.isEmpty());
  }
}
