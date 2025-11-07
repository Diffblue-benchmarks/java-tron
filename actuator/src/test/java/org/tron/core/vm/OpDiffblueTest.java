package org.tron.core.vm;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class OpDiffblueTest {
  /**
   * Method under test: {@link Op#getNameOf(byte)}
   */
  @Test
  public void testGetNameOf() {
    // Arrange, Act and Assert
    assertEquals("COINBASE", Op.getNameOf((byte) 'A'));
    assertEquals("ADD", Op.getNameOf(1));
  }
}
