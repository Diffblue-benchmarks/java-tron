package org.tron.core.db;

import static org.junit.Assert.assertArrayEquals;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class TransactionTraceDiffblueTest {
  /**
   * Method under test: {@link TransactionTrace#convertToTronAddress(byte[])}
   */
  @Test
  public void testConvertToTronAddress() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualConvertToTronAddressResult = TransactionTrace.convertToTronAddress("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualConvertToTronAddressResult);
  }
}
