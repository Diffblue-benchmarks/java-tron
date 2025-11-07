package org.tron.common.overlay.message;

import static org.junit.Assert.assertThrows;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.core.exception.P2pException;

public class MessageDiffblueTest {
  /**
   * Method under test: {@link Message#compareBytes(byte[], byte[])}
   */
  @Test
  public void testCompareBytes() throws UnsupportedEncodingException, P2pException {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> Message.compareBytes(new byte[]{}, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link Message#compareBytes(byte[], byte[])}
   */
  @Test
  public void testCompareBytes2() throws UnsupportedEncodingException, P2pException {
    // Arrange
    byte[] src = "A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8");

    // Act and Assert
    assertThrows(P2pException.class, () -> Message.compareBytes(src, "AXAXAXAX".getBytes("UTF-8")));
  }
}
