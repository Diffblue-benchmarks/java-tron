package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Bech32DiffblueTest {
  /**
   * Method under test: {@link Bech32#encode(String, byte[])}
   */
  @Test
  public void testEncode() {
    // Arrange, Act and Assert
    assertEquals("hrp1vhqs52", Bech32.encode("Hrp", new byte[]{}));
  }
}
