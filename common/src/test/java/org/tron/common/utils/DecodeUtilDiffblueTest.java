package org.tron.common.utils;

import static org.junit.Assert.assertFalse;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class DecodeUtilDiffblueTest {
  /**
   * Method under test: {@link DecodeUtil#addressValid(byte[])}
   */
  @Test
  public void testAddressValid() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(DecodeUtil.addressValid("AXAXAXAX".getBytes("UTF-8")));
    assertFalse(DecodeUtil.addressValid(null));
    assertFalse(DecodeUtil.addressValid(new byte[]{}));
  }
}
