package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StringUtilDiffblueTest {
  /**
   * Test {@link StringUtil#createDbKey(ByteString)}.
   *
   * <p>Method under test: {@link StringUtil#createDbKey(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return {@code 4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#createReadableString(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.createReadableString(byte[])"})
  public void testCreateReadableStringWithBytes_thenReturn4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("4158415841584158", StringUtil.createReadableString("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link StringUtil#createReadableString(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#createReadableString(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.createReadableString(byte[])"})
  public void testCreateReadableStringWithBytes_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.createReadableString((byte[]) null));
  }

  /**
   * Test {@link StringUtil#createReadableString(ByteString)} with {@code string}.
   *
   * <p>Method under test: {@link StringUtil#createReadableString(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then return toStringUtf8 is empty string.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#hexString2ByteString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString StringUtil.hexString2ByteString(String)"})
  public void testHexString2ByteString_when0x_thenReturnToStringUtf8IsEmptyString() {
    // Arrange and Act
    ByteString actualHexString2ByteStringResult = StringUtil.hexString2ByteString("0x");

    // Assert
    assertEquals("", actualHexString2ByteStringResult.toStringUtf8());
    assertFalse(actualHexString2ByteStringResult.iterator().hasNext());
    assertTrue(actualHexString2ByteStringResult.isEmpty());
  }

  /**
   * Test {@link StringUtil#hexString2ByteString(String)}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return not Empty.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#hexString2ByteString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString StringUtil.hexString2ByteString(String)"})
  public void testHexString2ByteString_when0123456789abcdef_thenReturnNotEmpty() {
    // Arrange and Act
    ByteString actualHexString2ByteStringResult =
        StringUtil.hexString2ByteString("0123456789ABCDEF");

    // Assert
    assertFalse(actualHexString2ByteStringResult.isEmpty());
    ByteIterator iteratorResult = actualHexString2ByteStringResult.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals((byte) 1, iteratorResult.next().byteValue());
    assertEquals('#', iteratorResult.next().byteValue());
    assertEquals('E', iteratorResult.next().byteValue());
    assertEquals('g', iteratorResult.next().byteValue());
    assertEquals((byte) -119, iteratorResult.next().byteValue());
    assertEquals("\u0001#Eg����", actualHexString2ByteStringResult.toStringUtf8());
  }
}
