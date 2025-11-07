package org.tron.common.backup.message;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UdpMessageTypeEnumDiffblueTest {
  /**
   * Method under test: {@link UdpMessageTypeEnum#fromByte(byte)}
   */
  @Test
  public void testFromByte() {
    // Arrange, Act and Assert
    assertEquals(UdpMessageTypeEnum.UNKNOWN, UdpMessageTypeEnum.fromByte((byte) 'A'));
    assertEquals(UdpMessageTypeEnum.UNKNOWN, UdpMessageTypeEnum.fromByte((byte) -1));
  }

  /**
   * Method under test: {@link UdpMessageTypeEnum#getType()}
   */
  @Test
  public void testGetType() {
    // Arrange, Act and Assert
    assertEquals((byte) 5, UdpMessageTypeEnum.valueOf("BACKUP_KEEP_ALIVE").getType());
  }
}
