package org.tron.common.logsfilter.capsule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.logsfilter.trigger.BlockLogTrigger;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.capsule.TransactionCapsule;

public class BlockLogTriggerCapsuleDiffblueTest {
  /**
   * Test {@link BlockLogTriggerCapsule#BlockLogTriggerCapsule(BlockCapsule)}.
   *
   * <p>Method under test: {@link BlockLogTriggerCapsule#BlockLogTriggerCapsule(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockLogTriggerCapsule.<init>(BlockCapsule)"})
  public void testNewBlockLogTriggerCapsule() {
    // Arrange
    TransactionCapsule transactionCapsule = mock(TransactionCapsule.class);
    when(transactionCapsule.getTransactionId()).thenReturn(new BlockId());

    ArrayList<TransactionCapsule> transactionCapsuleList = new ArrayList<>();
    transactionCapsuleList.add(transactionCapsule);

    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getTransactions()).thenReturn(transactionCapsuleList);
    when(block.getNum()).thenReturn(1L);
    when(block.getTimeStamp()).thenReturn(10L);
    when(block.getBlockId()).thenReturn(new BlockId());

    // Act
    BlockLogTriggerCapsule actualBlockLogTriggerCapsule = new BlockLogTriggerCapsule(block);

    // Assert
    verify(block).getBlockId();
    verify(block).getNum();
    verify(block).getTimeStamp();
    verify(block, atLeast(1)).getTransactions();
    verify(transactionCapsule).getTransactionId();
    BlockLogTrigger blockLogTrigger = actualBlockLogTriggerCapsule.getBlockLogTrigger();
    List<String> transactionList = blockLogTrigger.getTransactionList();
    assertEquals(1, transactionList.size());
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000000", transactionList.get(0));
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000000",
        blockLogTrigger.getBlockHash());
    assertEquals(1L, blockLogTrigger.getTransactionSize());
  }

  /**
   * Test {@link BlockLogTriggerCapsule#BlockLogTriggerCapsule(BlockCapsule)}.
   *
   * <p>Method under test: {@link BlockLogTriggerCapsule#BlockLogTriggerCapsule(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockLogTriggerCapsule.<init>(BlockCapsule)"})
  public void testNewBlockLogTriggerCapsule2() {
    // Arrange
    TransactionCapsule transactionCapsule = mock(TransactionCapsule.class);
    when(transactionCapsule.getTransactionId()).thenReturn(mock(Sha256Hash.class));

    ArrayList<TransactionCapsule> transactionCapsuleList = new ArrayList<>();
    transactionCapsuleList.add(transactionCapsule);

    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getTransactions()).thenReturn(transactionCapsuleList);
    when(block.getNum()).thenReturn(1L);
    when(block.getTimeStamp()).thenReturn(10L);
    when(block.getBlockId()).thenReturn(new BlockId());

    // Act
    BlockLogTriggerCapsule actualBlockLogTriggerCapsule = new BlockLogTriggerCapsule(block);

    // Assert
    verify(block).getBlockId();
    verify(block).getNum();
    verify(block).getTimeStamp();
    verify(block, atLeast(1)).getTransactions();
    verify(transactionCapsule).getTransactionId();
    BlockLogTrigger blockLogTrigger = actualBlockLogTriggerCapsule.getBlockLogTrigger();
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000000",
        blockLogTrigger.getBlockHash());
    assertEquals("blockTrigger", blockLogTrigger.getTriggerName());
    assertEquals(0L, blockLogTrigger.getLatestSolidifiedBlockNumber());
    assertEquals(1, blockLogTrigger.getTransactionList().size());
    assertEquals(10L, blockLogTrigger.getTimeStamp());
    assertEquals(1L, blockLogTrigger.getBlockNumber());
    assertEquals(1L, blockLogTrigger.getTransactionSize());
  }

  /**
   * Test {@link BlockLogTriggerCapsule#BlockLogTriggerCapsule(BlockCapsule)}.
   *
   * <ul>
   *   <li>Given {@link BlockId}.
   * </ul>
   *
   * <p>Method under test: {@link BlockLogTriggerCapsule#BlockLogTriggerCapsule(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockLogTriggerCapsule.<init>(BlockCapsule)"})
  public void testNewBlockLogTriggerCapsule_givenBlockId() {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getTransactions()).thenReturn(new ArrayList<>());
    when(block.getNum()).thenReturn(1L);
    when(block.getTimeStamp()).thenReturn(10L);
    when(block.getBlockId()).thenReturn(mock(BlockId.class));

    // Act
    BlockLogTriggerCapsule actualBlockLogTriggerCapsule = new BlockLogTriggerCapsule(block);

    // Assert
    verify(block).getBlockId();
    verify(block).getNum();
    verify(block).getTimeStamp();
    verify(block, atLeast(1)).getTransactions();
    BlockLogTrigger blockLogTrigger = actualBlockLogTriggerCapsule.getBlockLogTrigger();
    assertEquals("blockTrigger", blockLogTrigger.getTriggerName());
    assertEquals(0L, blockLogTrigger.getLatestSolidifiedBlockNumber());
    assertEquals(0L, blockLogTrigger.getTransactionSize());
    assertEquals(10L, blockLogTrigger.getTimeStamp());
    assertEquals(1L, blockLogTrigger.getBlockNumber());
    assertTrue(blockLogTrigger.getTransactionList().isEmpty());
  }

  /**
   * Test {@link BlockLogTriggerCapsule#BlockLogTriggerCapsule(BlockCapsule)}.
   *
   * <ul>
   *   <li>Then return BlockLogTrigger TransactionSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link BlockLogTriggerCapsule#BlockLogTriggerCapsule(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockLogTriggerCapsule.<init>(BlockCapsule)"})
  public void testNewBlockLogTriggerCapsule_thenReturnBlockLogTriggerTransactionSizeIsZero() {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getTransactions()).thenReturn(new ArrayList<>());
    when(block.getNum()).thenReturn(1L);
    when(block.getTimeStamp()).thenReturn(10L);
    when(block.getBlockId()).thenReturn(new BlockId());

    // Act
    BlockLogTriggerCapsule actualBlockLogTriggerCapsule = new BlockLogTriggerCapsule(block);

    // Assert
    verify(block).getBlockId();
    verify(block).getNum();
    verify(block).getTimeStamp();
    verify(block, atLeast(1)).getTransactions();
    BlockLogTrigger blockLogTrigger = actualBlockLogTriggerCapsule.getBlockLogTrigger();
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000000",
        blockLogTrigger.getBlockHash());
    assertEquals("blockTrigger", blockLogTrigger.getTriggerName());
    assertEquals(0L, blockLogTrigger.getLatestSolidifiedBlockNumber());
    assertEquals(0L, blockLogTrigger.getTransactionSize());
    assertEquals(10L, blockLogTrigger.getTimeStamp());
    assertEquals(1L, blockLogTrigger.getBlockNumber());
    assertTrue(blockLogTrigger.getTransactionList().isEmpty());
  }

  /**
   * Test {@link BlockLogTriggerCapsule#setLatestSolidifiedBlockNumber(long)}.
   *
   * <p>Method under test: {@link BlockLogTriggerCapsule#setLatestSolidifiedBlockNumber(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockLogTriggerCapsule.setLatestSolidifiedBlockNumber(long)"})
  public void testSetLatestSolidifiedBlockNumber() {
    // Arrange
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getTransactions()).thenReturn(new ArrayList<>());
    when(block.getNum()).thenReturn(1L);
    when(block.getTimeStamp()).thenReturn(10L);
    when(block.getBlockId()).thenReturn(new BlockId());
    BlockLogTriggerCapsule blockLogTriggerCapsule = new BlockLogTriggerCapsule(block);

    // Act
    blockLogTriggerCapsule.setLatestSolidifiedBlockNumber(1L);

    // Assert
    verify(block).getBlockId();
    verify(block).getNum();
    verify(block).getTimeStamp();
    verify(block, atLeast(1)).getTransactions();
    assertEquals(1L, blockLogTriggerCapsule.getBlockLogTrigger().getLatestSolidifiedBlockNumber());
  }
}
