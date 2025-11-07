package org.tron.core.net.message.sync;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ChainInventoryMessageDiffblueTest {
  /**
   * Method under test: {@link ChainInventoryMessage#getBlockIds()}
   */
  @Test
  public void testGetBlockIds() throws Exception {
    // Arrange, Act and Assert
    assertTrue((new ChainInventoryMessage(new byte[]{})).getBlockIds().isEmpty());
  }

  /**
   * Method under test: {@link ChainInventoryMessage#getRemainNum()}
   */
  @Test
  public void testGetRemainNum() throws Exception {
    // Arrange, Act and Assert
    assertEquals(0L, (new ChainInventoryMessage(new byte[]{})).getRemainNum().longValue());
  }

  /**
   * Method under test: {@link ChainInventoryMessage#toString()}
   */
  @Test
  public void testToString() throws Exception {
    // Arrange, Act and Assert
    assertEquals("type: BLOCK_CHAIN_INVENTORY\nsize: 0, remain_num: 0",
        (new ChainInventoryMessage(new byte[]{})).toString());
  }
}
