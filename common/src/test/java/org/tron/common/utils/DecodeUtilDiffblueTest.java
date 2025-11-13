package org.tron.common.utils;

import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DecodeUtilDiffblueTest {
  /**
   * Test {@link DecodeUtil#addressValid(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link DecodeUtil#addressValid(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DecodeUtil.addressValid(byte[])"})
  public void testAddressValid_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(DecodeUtil.addressValid("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DecodeUtil#addressValid(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link DecodeUtil#addressValid(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DecodeUtil.addressValid(byte[])"})
  public void testAddressValid_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertFalse(DecodeUtil.addressValid(new byte[] {}));
  }

  /**
   * Test {@link DecodeUtil#addressValid(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DecodeUtil#addressValid(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DecodeUtil.addressValid(byte[])"})
  public void testAddressValid_whenNull() {
    // Arrange, Act and Assert
    assertFalse(DecodeUtil.addressValid(null));
  }
}
