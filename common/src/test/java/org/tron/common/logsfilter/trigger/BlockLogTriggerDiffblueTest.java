package org.tron.common.logsfilter.trigger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class BlockLogTriggerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BlockLogTrigger#setBlockHash(String)}
   *   <li>{@link BlockLogTrigger#setBlockNumber(long)}
   *   <li>{@link BlockLogTrigger#setLatestSolidifiedBlockNumber(long)}
   *   <li>{@link BlockLogTrigger#setTransactionList(List)}
   *   <li>{@link BlockLogTrigger#setTransactionSize(long)}
   *   <li>{@link BlockLogTrigger#toString()}
   *   <li>{@link BlockLogTrigger#getBlockHash()}
   *   <li>{@link BlockLogTrigger#getBlockNumber()}
   *   <li>{@link BlockLogTrigger#getLatestSolidifiedBlockNumber()}
   *   <li>{@link BlockLogTrigger#getTransactionList()}
   *   <li>{@link BlockLogTrigger#getTransactionSize()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BlockLogTrigger blockLogTrigger = new BlockLogTrigger();

    // Act
    blockLogTrigger.setBlockHash("Block Hash");
    blockLogTrigger.setBlockNumber(1L);
    blockLogTrigger.setLatestSolidifiedBlockNumber(1L);
    ArrayList<String> transactionList = new ArrayList<>();
    blockLogTrigger.setTransactionList(transactionList);
    blockLogTrigger.setTransactionSize(3L);
    String actualToStringResult = blockLogTrigger.toString();
    String actualBlockHash = blockLogTrigger.getBlockHash();
    long actualBlockNumber = blockLogTrigger.getBlockNumber();
    long actualLatestSolidifiedBlockNumber = blockLogTrigger.getLatestSolidifiedBlockNumber();
    List<String> actualTransactionList = blockLogTrigger.getTransactionList();

    // Assert that nothing has changed
    assertEquals("Block Hash", actualBlockHash);
    assertEquals("triggerName: blockTriggertimestamp: 0, blockNumber: 1, blockhash: Block Hash, transactionSize: 3,"
        + " latestSolidifiedBlockNumber: 1, transactionList: []", actualToStringResult);
    assertEquals(1L, actualBlockNumber);
    assertEquals(1L, actualLatestSolidifiedBlockNumber);
    assertEquals(3L, blockLogTrigger.getTransactionSize());
    assertTrue(actualTransactionList.isEmpty());
    assertSame(transactionList, actualTransactionList);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link BlockLogTrigger}
   */
  @Test
  public void testNewBlockLogTrigger() {
    // Arrange and Act
    BlockLogTrigger actualBlockLogTrigger = new BlockLogTrigger();

    // Assert
    assertNull(actualBlockLogTrigger.getBlockHash());
    assertEquals(0L, actualBlockLogTrigger.getBlockNumber());
    assertEquals(0L, actualBlockLogTrigger.getLatestSolidifiedBlockNumber());
    assertEquals(0L, actualBlockLogTrigger.getTransactionSize());
    assertEquals(0L, actualBlockLogTrigger.getTimeStamp());
    assertTrue(actualBlockLogTrigger.getTransactionList().isEmpty());
    assertEquals(Trigger.BLOCK_TRIGGER_NAME, actualBlockLogTrigger.getTriggerName());
  }
}
