package org.tron.core.net.message;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class MessageTypesDiffblueTest {
  /**
   * Method under test: {@link MessageTypes#asByte()}
   */
  @Test
  public void testAsByte() {
    // Arrange, Act and Assert
    assertEquals((byte) 0, MessageTypes.FIRST.asByte());
  }

  /**
   * Method under test: {@link MessageTypes#fromByte(byte)}
   */
  @Test
  public void testFromByte() {
    // Arrange, Act and Assert
    assertNull(MessageTypes.fromByte((byte) 'A'));
  }

  /**
   * Method under test: {@link MessageTypes#inP2pRange(byte)}
   */
  @Test
  public void testInP2pRange() {
    // Arrange, Act and Assert
    assertFalse(MessageTypes.inP2pRange((byte) 'A'));
    assertTrue(MessageTypes.inP2pRange((byte) '#'));
    assertFalse(MessageTypes.inP2pRange((byte) 0));
  }

  /**
   * Method under test: {@link MessageTypes#inPbftRange(byte)}
   */
  @Test
  public void testInPbftRange() {
    // Arrange, Act and Assert
    assertFalse(MessageTypes.inPbftRange((byte) 'A'));
    assertTrue(MessageTypes.inPbftRange((byte) '4'));
  }

  /**
   * Method under test: {@link MessageTypes#inRange(byte)}
   */
  @Test
  public void testInRange() {
    // Arrange, Act and Assert
    assertFalse(MessageTypes.inRange((byte) 'A'));
    assertTrue(MessageTypes.inRange(Byte.MIN_VALUE));
  }

  /**
   * Method under test: {@link MessageTypes#inTronRange(byte)}
   */
  @Test
  public void testInTronRange() {
    // Arrange, Act and Assert
    assertFalse(MessageTypes.inTronRange((byte) 'A'));
    assertTrue(MessageTypes.inTronRange((byte) 20));
    assertFalse(MessageTypes.inTronRange((byte) -1));
  }

  /**
   * Method under test: {@link MessageTypes#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("FIRST", MessageTypes.FIRST.toString());
    assertEquals("TRX", MessageTypes.TRX.toString());
    assertEquals("BLOCK", MessageTypes.BLOCK.toString());
    assertEquals("INVENTORY", MessageTypes.INVENTORY.toString());
    assertEquals("FETCH_INV_DATA", MessageTypes.FETCH_INV_DATA.toString());
    assertEquals("SYNC_BLOCK_CHAIN", MessageTypes.SYNC_BLOCK_CHAIN.toString());
  }
}
