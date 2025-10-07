package org.tron.common.logsfilter.trigger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BlockLogTriggerDiffblueTest {
  /**
   * Test new {@link BlockLogTrigger} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BlockLogTrigger}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockLogTrigger.<init>()"})
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

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BlockLogTrigger.getBlockHash()",
    "long BlockLogTrigger.getBlockNumber()",
    "long BlockLogTrigger.getLatestSolidifiedBlockNumber()",
    "List BlockLogTrigger.getTransactionList()",
    "long BlockLogTrigger.getTransactionSize()",
    "void BlockLogTrigger.setBlockHash(String)",
    "void BlockLogTrigger.setBlockNumber(long)",
    "void BlockLogTrigger.setLatestSolidifiedBlockNumber(long)",
    "void BlockLogTrigger.setTransactionList(List)",
    "void BlockLogTrigger.setTransactionSize(long)",
    "String BlockLogTrigger.toString()"
  })
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

    // Assert
    assertEquals("Block Hash", actualBlockHash);
    assertEquals(
        "triggerName: blockTriggertimestamp: 0, blockNumber: 1, blockhash: Block Hash, transactionSize: 3,"
            + " latestSolidifiedBlockNumber: 1, transactionList: []",
        actualToStringResult);
    assertEquals(1L, actualBlockNumber);
    assertEquals(1L, actualLatestSolidifiedBlockNumber);
    assertEquals(3L, blockLogTrigger.getTransactionSize());
    assertTrue(actualTransactionList.isEmpty());
    assertSame(transactionList, actualTransactionList);
  }
}
