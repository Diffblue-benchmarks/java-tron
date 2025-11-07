package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.tron.common.logsfilter.trigger.BlockLogTrigger;
import org.tron.core.capsule.BlockCapsule;
import org.tron.protos.Protocol;

public class BlockLogTriggerCapsuleDiffblueTest {
  /**
   * Method under test:
   * {@link BlockLogTriggerCapsule#BlockLogTriggerCapsule(BlockCapsule)}
   */
  @Test
  public void testNewBlockLogTriggerCapsule() {
    // Arrange, Act and Assert
    BlockLogTrigger blockLogTrigger = (new BlockLogTriggerCapsule(
        new BlockCapsule(Protocol.Block.getDefaultInstance()))).getBlockLogTrigger();
    assertEquals("00000000000000009afbf4c8996fb92427ae41e4649b934ca495991b7852b855", blockLogTrigger.getBlockHash());
    assertEquals("blockTrigger", blockLogTrigger.getTriggerName());
    assertEquals(0L, blockLogTrigger.getBlockNumber());
    assertEquals(0L, blockLogTrigger.getLatestSolidifiedBlockNumber());
    assertEquals(0L, blockLogTrigger.getTransactionSize());
    assertEquals(0L, blockLogTrigger.getTimeStamp());
    assertTrue(blockLogTrigger.getTransactionList().isEmpty());
  }

  /**
   * Method under test:
   * {@link BlockLogTriggerCapsule#setLatestSolidifiedBlockNumber(long)}
   */
  @Test
  public void testSetLatestSolidifiedBlockNumber() {
    // Arrange
    BlockLogTriggerCapsule blockLogTriggerCapsule = new BlockLogTriggerCapsule(
        new BlockCapsule(Protocol.Block.getDefaultInstance()));

    // Act
    blockLogTriggerCapsule.setLatestSolidifiedBlockNumber(1L);

    // Assert
    assertEquals(1L, blockLogTriggerCapsule.getBlockLogTrigger().getLatestSolidifiedBlockNumber());
  }
}
