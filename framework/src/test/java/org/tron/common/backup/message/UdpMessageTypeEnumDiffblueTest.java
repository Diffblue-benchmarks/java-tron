package org.tron.common.backup.message;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UdpMessageTypeEnumDiffblueTest {
  /**
   * Test {@link UdpMessageTypeEnum#fromByte(byte)}.
   * <ul>
   *   <li>When {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UdpMessageTypeEnum#fromByte(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UdpMessageTypeEnum UdpMessageTypeEnum.fromByte(byte)"})
  public void testFromByte_whenA() {
    // Arrange, Act and Assert
    assertEquals(UdpMessageTypeEnum.UNKNOWN, UdpMessageTypeEnum.fromByte((byte) 'A'));
  }

  /**
   * Test {@link UdpMessageTypeEnum#fromByte(byte)}.
   * <ul>
   *   <li>When minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link UdpMessageTypeEnum#fromByte(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UdpMessageTypeEnum UdpMessageTypeEnum.fromByte(byte)"})
  public void testFromByte_whenMinusOne() {
    // Arrange, Act and Assert
    assertEquals(UdpMessageTypeEnum.UNKNOWN, UdpMessageTypeEnum.fromByte((byte) -1));
  }

  /**
   * Test {@link UdpMessageTypeEnum#getType()}.
   * <p>
   * Method under test: {@link UdpMessageTypeEnum#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte UdpMessageTypeEnum.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertEquals((byte) 5, UdpMessageTypeEnum.valueOf("BACKUP_KEEP_ALIVE").getType());
  }
}
