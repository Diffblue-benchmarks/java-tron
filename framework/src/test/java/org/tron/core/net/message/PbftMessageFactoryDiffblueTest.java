package org.tron.core.net.message;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import org.tron.core.exception.P2pException;

public class PbftMessageFactoryDiffblueTest {
  /**
   * Method under test: {@link PbftMessageFactory#create(byte[])}
   */
  @Test
  public void testCreate() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> PbftMessageFactory.create("AXAXAXAX".getBytes("UTF-8")));
    assertThrows(P2pException.class, () -> PbftMessageFactory.create(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(P2pException.class, () -> PbftMessageFactory.create(new byte[]{3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(P2pException.class, () -> PbftMessageFactory.create(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(P2pException.class, () -> PbftMessageFactory.create(new byte[]{6, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(P2pException.class, () -> PbftMessageFactory.create(new byte[]{7, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(P2pException.class, () -> PbftMessageFactory.create("\bXAXAXAX".getBytes("UTF-8")));
  }
}
