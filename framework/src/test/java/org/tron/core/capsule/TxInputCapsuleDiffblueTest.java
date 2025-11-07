package org.tron.core.capsule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class TxInputCapsuleDiffblueTest {
  /**
   * Method under test: {@link TxInputCapsule#validate()}
   */
  @Test
  public void testValidate() throws UnsupportedEncodingException {
    // Arrange
    byte[] txId = "AXAXAXAX".getBytes("UTF-8");
    byte[] signature = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue((new TxInputCapsule(txId, 1L, signature, "AXAXAXAX".getBytes("UTF-8"))).validate());
  }

  /**
   * Method under test: {@link TxInputCapsule#getData()}
   */
  @Test
  public void testGetData() throws UnsupportedEncodingException {
    // Arrange
    byte[] txId = "AXAXAXAX".getBytes("UTF-8");
    byte[] signature = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, (new TxInputCapsule(txId, 1L, signature, "AXAXAXAX".getBytes("UTF-8"))).getData().length);
  }
}
