package org.tron.core.net.message.sync;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BlockInventoryMessageDiffblueTest {
  /**
   * Method under test: {@link BlockInventoryMessage#getBlockIds()}
   */
  @Test
  public void testGetBlockIds() throws Exception {
    // Arrange, Act and Assert
    assertTrue((new BlockInventoryMessage(new byte[]{})).getBlockIds().isEmpty());
  }
}
