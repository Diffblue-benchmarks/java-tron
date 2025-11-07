package org.tron.common.zksnark;

import static org.junit.Assert.assertArrayEquals;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class ZksnarkUtilsDiffblueTest {
  /**
   * Method under test: {@link ZksnarkUtils#sort(byte[])}
   */
  @Test
  public void testSort() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ZksnarkUtils.sort(bytes);

    // Assert
    assertArrayEquals("XAXAXAXA".getBytes("UTF-8"), bytes);
  }
}
